(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[23],{

/***/ "../node_modules/@theia/outline-view/lib/browser/outline-view-service.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/outline-view/lib/browser/outline-view-service.js ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017 TypeFox and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var outline_view_widget_1 = __webpack_require__(/*! ./outline-view-widget */ "../node_modules/@theia/outline-view/lib/browser/outline-view-widget.js");
var OutlineViewService = /** @class */ (function () {
    function OutlineViewService(factory) {
        this.factory = factory;
        this.id = 'outline-view';
        this.onDidChangeOutlineEmitter = new core_1.Emitter();
        this.onDidChangeOpenStateEmitter = new core_1.Emitter();
        this.onDidSelectEmitter = new core_1.Emitter();
        this.onDidOpenEmitter = new core_1.Emitter();
    }
    Object.defineProperty(OutlineViewService.prototype, "onDidSelect", {
        get: function () {
            return this.onDidSelectEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(OutlineViewService.prototype, "onDidOpen", {
        get: function () {
            return this.onDidOpenEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(OutlineViewService.prototype, "onDidChangeOutline", {
        get: function () {
            return this.onDidChangeOutlineEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(OutlineViewService.prototype, "onDidChangeOpenState", {
        get: function () {
            return this.onDidChangeOpenStateEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(OutlineViewService.prototype, "open", {
        get: function () {
            return this.widget !== undefined && this.widget.isVisible;
        },
        enumerable: true,
        configurable: true
    });
    OutlineViewService.prototype.publish = function (roots) {
        if (this.widget) {
            this.widget.setOutlineTree(roots);
            this.onDidChangeOutlineEmitter.fire(roots);
        }
    };
    OutlineViewService.prototype.createWidget = function () {
        var _this = this;
        this.widget = this.factory();
        var disposables = new core_1.DisposableCollection();
        disposables.push(this.widget.onDidChangeOpenStateEmitter.event(function (open) { return _this.onDidChangeOpenStateEmitter.fire(open); }));
        disposables.push(this.widget.model.onOpenNode(function (node) { return _this.onDidOpenEmitter.fire(node); }));
        disposables.push(this.widget.model.onSelectionChanged(function (selection) { return _this.onDidSelectEmitter.fire(selection[0]); }));
        this.widget.disposed.connect(function () {
            _this.widget = undefined;
            disposables.dispose();
        });
        return Promise.resolve(this.widget);
    };
    OutlineViewService = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(outline_view_widget_1.OutlineViewWidgetFactory)),
        __metadata("design:paramtypes", [Function])
    ], OutlineViewService);
    return OutlineViewService;
}());
exports.OutlineViewService = OutlineViewService;


/***/ }),

/***/ "../node_modules/@theia/outline-view/lib/browser/outline-view-widget.js":
/*!******************************************************************************!*\
  !*** ../node_modules/@theia/outline-view/lib/browser/outline-view-widget.js ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017 TypeFox and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var OutlineSymbolInformationNode;
(function (OutlineSymbolInformationNode) {
    function is(node) {
        return !!node && browser_1.SelectableTreeNode.is(node) && 'iconClass' in node;
    }
    OutlineSymbolInformationNode.is = is;
})(OutlineSymbolInformationNode = exports.OutlineSymbolInformationNode || (exports.OutlineSymbolInformationNode = {}));
exports.OutlineViewWidgetFactory = Symbol('OutlineViewWidgetFactory');
var OutlineViewWidget = /** @class */ (function (_super) {
    __extends(OutlineViewWidget, _super);
    function OutlineViewWidget(treeProps, model, contextMenuRenderer) {
        var _this = _super.call(this, treeProps, model, contextMenuRenderer) || this;
        _this.treeProps = treeProps;
        _this.contextMenuRenderer = contextMenuRenderer;
        _this.onDidChangeOpenStateEmitter = new core_1.Emitter();
        _this.id = 'outline-view';
        _this.title.label = 'Outline';
        _this.title.caption = 'Outline';
        _this.title.iconClass = 'fa outline-view-tab-icon';
        _this.addClass('theia-outline-view');
        return _this;
    }
    OutlineViewWidget.prototype.setOutlineTree = function (roots) {
        var nodes = this.reconcileTreeState(roots);
        this.model.root = {
            id: 'outline-view-root',
            name: 'Outline Root',
            visible: false,
            children: nodes,
            parent: undefined
        };
    };
    OutlineViewWidget.prototype.reconcileTreeState = function (nodes) {
        var _this = this;
        nodes.forEach(function (node) {
            if (OutlineSymbolInformationNode.is(node)) {
                var treeNode = _this.model.getNode(node.id);
                if (treeNode && OutlineSymbolInformationNode.is(treeNode)) {
                    treeNode.expanded = node.expanded;
                    treeNode.selected = node.selected;
                }
                _this.reconcileTreeState(Array.from(node.children));
            }
        });
        return nodes;
    };
    OutlineViewWidget.prototype.onAfterHide = function (msg) {
        _super.prototype.onAfterHide.call(this, msg);
        this.onDidChangeOpenStateEmitter.fire(false);
    };
    OutlineViewWidget.prototype.onAfterShow = function (msg) {
        _super.prototype.onAfterShow.call(this, msg);
        this.onDidChangeOpenStateEmitter.fire(true);
    };
    OutlineViewWidget.prototype.renderIcon = function (node, props) {
        if (OutlineSymbolInformationNode.is(node)) {
            return React.createElement("div", { className: 'symbol-icon symbol-icon-center ' + node.iconClass });
        }
        // tslint:disable-next-line:no-null-keyword
        return null;
    };
    OutlineViewWidget.prototype.isExpandable = function (node) {
        return OutlineSymbolInformationNode.is(node) && node.children.length > 0;
    };
    OutlineViewWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_1.TreeProps)),
        __param(1, inversify_1.inject(browser_1.TreeModel)),
        __param(2, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __metadata("design:paramtypes", [Object, Object, Object])
    ], OutlineViewWidget);
    return OutlineViewWidget;
}(browser_1.TreeWidget));
exports.OutlineViewWidget = OutlineViewWidget;


/***/ })

}]);
//# sourceMappingURL=23.bundle.js.map