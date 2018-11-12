(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[29],{

/***/ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-container.js":
/*!******************************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-container.js ***!
  \******************************************************************************************/
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
var __assign = (this && this.__assign) || Object.assign || function(t) {
    for (var s, i = 1, n = arguments.length; i < n; i++) {
        s = arguments[i];
        for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
            t[p] = s[p];
    }
    return t;
};
Object.defineProperty(exports, "__esModule", { value: true });
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var file_tree_1 = __webpack_require__(/*! ../file-tree */ "../node_modules/@theia/filesystem/lib/browser/file-tree/index.js");
var file_dialog_1 = __webpack_require__(/*! ./file-dialog */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog.js");
var file_dialog_model_1 = __webpack_require__(/*! ./file-dialog-model */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-model.js");
var file_dialog_widget_1 = __webpack_require__(/*! ./file-dialog-widget */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-widget.js");
var file_dialog_tree_1 = __webpack_require__(/*! ./file-dialog-tree */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-tree.js");
function createFileDialogContainer(parent) {
    var child = file_tree_1.createFileTreeContainer(parent);
    child.unbind(file_tree_1.FileTreeModel);
    child.bind(file_dialog_model_1.FileDialogModel).toSelf();
    child.rebind(browser_1.TreeModel).toDynamicValue(function (ctx) { return ctx.container.get(file_dialog_model_1.FileDialogModel); });
    child.unbind(file_tree_1.FileTreeWidget);
    child.bind(file_dialog_widget_1.FileDialogWidget).toSelf();
    child.bind(file_dialog_tree_1.FileDialogTree).toSelf();
    child.rebind(browser_1.Tree).toService(file_dialog_tree_1.FileDialogTree);
    return child;
}
exports.createFileDialogContainer = createFileDialogContainer;
function createOpenFileDialogContainer(parent, props) {
    var container = createFileDialogContainer(parent);
    container.rebind(browser_1.TreeProps).toConstantValue(__assign({}, browser_1.defaultTreeProps, { multiSelect: props.canSelectMany, search: true }));
    container.bind(file_dialog_1.OpenFileDialogProps).toConstantValue(props);
    container.bind(file_dialog_1.OpenFileDialog).toSelf();
    return container;
}
exports.createOpenFileDialogContainer = createOpenFileDialogContainer;
function createSaveFileDialogContainer(parent, props) {
    var container = createFileDialogContainer(parent);
    container.rebind(browser_1.TreeProps).toConstantValue(__assign({}, browser_1.defaultTreeProps, { multiSelect: false, search: true }));
    container.bind(file_dialog_1.SaveFileDialogProps).toConstantValue(props);
    container.bind(file_dialog_1.SaveFileDialog).toSelf();
    return container;
}
exports.createSaveFileDialogContainer = createSaveFileDialogContainer;


/***/ }),

/***/ "../node_modules/@theia/filesystem/lib/browser/file-dialog/index.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/file-dialog/index.js ***!
  \**************************************************************************/
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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(/*! ./file-dialog */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog.js"));
__export(__webpack_require__(/*! ./file-dialog-container */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-container.js"));
__export(__webpack_require__(/*! ./file-dialog-tree-filters-renderer */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-tree-filters-renderer.js"));
__export(__webpack_require__(/*! ./file-dialog-service */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/file-dialog-service.js"));


/***/ }),

/***/ "../node_modules/@theia/filesystem/lib/browser/index.js":
/*!**************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/index.js ***!
  \**************************************************************/
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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(/*! ./location */ "../node_modules/@theia/filesystem/lib/browser/location/index.js"));
__export(__webpack_require__(/*! ./file-tree */ "../node_modules/@theia/filesystem/lib/browser/file-tree/index.js"));
__export(__webpack_require__(/*! ./file-dialog */ "../node_modules/@theia/filesystem/lib/browser/file-dialog/index.js"));
__export(__webpack_require__(/*! ./filesystem-preferences */ "../node_modules/@theia/filesystem/lib/browser/filesystem-preferences.js"));
__export(__webpack_require__(/*! ./filesystem-watcher */ "../node_modules/@theia/filesystem/lib/browser/filesystem-watcher.js"));
__export(__webpack_require__(/*! ./file-resource */ "../node_modules/@theia/filesystem/lib/browser/file-resource.js"));


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/marker-tree-model.js":
/*!***********************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/marker-tree-model.js ***!
  \***********************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var marker_tree_1 = __webpack_require__(/*! ./marker-tree */ "../node_modules/@theia/markers/lib/browser/marker-tree.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var MarkerTreeModel = /** @class */ (function (_super) {
    __extends(MarkerTreeModel, _super);
    function MarkerTreeModel() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MarkerTreeModel.prototype.doOpenNode = function (node) {
        if (marker_tree_1.MarkerNode.is(node)) {
            browser_1.open(this.openerService, node.uri, this.getOpenerOptionsByMarker(node));
        }
        else {
            _super.prototype.doOpenNode.call(this, node);
        }
    };
    MarkerTreeModel.prototype.getOpenerOptionsByMarker = function (node) {
        return undefined;
    };
    __decorate([
        inversify_1.inject(browser_1.OpenerService),
        __metadata("design:type", Object)
    ], MarkerTreeModel.prototype, "openerService", void 0);
    MarkerTreeModel = __decorate([
        inversify_1.injectable()
    ], MarkerTreeModel);
    return MarkerTreeModel;
}(browser_1.TreeModelImpl));
exports.MarkerTreeModel = MarkerTreeModel;


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/marker-tree.js":
/*!*****************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/marker-tree.js ***!
  \*****************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var __values = (this && this.__values) || function (o) {
    var m = typeof Symbol === "function" && o[Symbol.iterator], i = 0;
    if (m) return m.call(o);
    return {
        next: function () {
            if (o && i >= o.length) o = void 0;
            return { value: o && o[i++], done: !o };
        }
    };
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var marker_manager_1 = __webpack_require__(/*! ./marker-manager */ "../node_modules/@theia/markers/lib/browser/marker-manager.js");
var selection_1 = __webpack_require__(/*! @theia/core/lib/common/selection */ "../node_modules/@theia/core/lib/common/selection.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
exports.MarkerOptions = Symbol('MarkerOptions');
var MarkerTree = /** @class */ (function (_super) {
    __extends(MarkerTree, _super);
    function MarkerTree(markerManager, markerOptions, labelProvider) {
        var _this = _super.call(this) || this;
        _this.markerManager = markerManager;
        _this.markerOptions = markerOptions;
        _this.labelProvider = labelProvider;
        _this.toDispose.push(markerManager.onDidChangeMarkers(function (uri) { return _this.refreshMarkerInfo(uri); }));
        _this.root = {
            visible: false,
            id: 'theia-' + markerOptions.kind + '-marker-widget',
            name: 'MarkerTree',
            kind: markerOptions.kind,
            children: [],
            parent: undefined
        };
        return _this;
    }
    MarkerTree.prototype.refreshMarkerInfo = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var id, existing, markers, node, _a, children;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        id = uri.toString();
                        existing = this.getNode(id);
                        markers = this.markerManager.findMarkers({ uri: uri });
                        if (markers.length <= 0) {
                            if (MarkerInfoNode.is(existing)) {
                                browser_1.CompositeTreeNode.removeChild(existing.parent, existing);
                                this.removeNode(existing);
                                this.fireChanged();
                            }
                            return [2 /*return*/];
                        }
                        if (!MarkerInfoNode.is(existing)) return [3 /*break*/, 1];
                        _a = existing;
                        return [3 /*break*/, 3];
                    case 1: return [4 /*yield*/, this.createMarkerInfo(id, uri)];
                    case 2:
                        _a = _b.sent();
                        _b.label = 3;
                    case 3:
                        node = _a;
                        browser_1.CompositeTreeNode.addChild(node.parent, node);
                        children = this.getMarkerNodes(node, markers);
                        node.numberOfMarkers = markers.length;
                        this.setChildren(node, children);
                        return [2 /*return*/];
                }
            });
        });
    };
    MarkerTree.prototype.resolveChildren = function (parent) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, nodes, _b, _c, id, uri, existing, markers, node, _d, e_1_1;
            return __generator(this, function (_e) {
                switch (_e.label) {
                    case 0:
                        if (!MarkerRootNode.is(parent)) return [3 /*break*/, 11];
                        nodes = [];
                        _e.label = 1;
                    case 1:
                        _e.trys.push([1, 8, 9, 10]);
                        _b = __values(this.markerManager.getUris()), _c = _b.next();
                        _e.label = 2;
                    case 2:
                        if (!!_c.done) return [3 /*break*/, 7];
                        id = _c.value;
                        uri = new uri_1.default(id);
                        existing = this.getNode(id);
                        markers = this.markerManager.findMarkers({ uri: uri });
                        if (!MarkerInfoNode.is(existing)) return [3 /*break*/, 3];
                        _d = existing;
                        return [3 /*break*/, 5];
                    case 3: return [4 /*yield*/, this.createMarkerInfo(id, uri)];
                    case 4:
                        _d = _e.sent();
                        _e.label = 5;
                    case 5:
                        node = _d;
                        node.children = this.getMarkerNodes(node, markers);
                        node.numberOfMarkers = node.children.length;
                        nodes.push(node);
                        _e.label = 6;
                    case 6:
                        _c = _b.next();
                        return [3 /*break*/, 2];
                    case 7: return [3 /*break*/, 10];
                    case 8:
                        e_1_1 = _e.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 10];
                    case 9:
                        try {
                            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 10: return [2 /*return*/, nodes];
                    case 11: return [2 /*return*/, _super.prototype.resolveChildren.call(this, parent)];
                }
            });
        });
    };
    MarkerTree.prototype.createMarkerInfo = function (id, uri) {
        return __awaiter(this, void 0, void 0, function () {
            var label, icon, description;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.labelProvider.getName(uri)];
                    case 1:
                        label = _a.sent();
                        return [4 /*yield*/, this.labelProvider.getIcon(uri)];
                    case 2:
                        icon = _a.sent();
                        return [4 /*yield*/, this.labelProvider.getLongName(uri.parent)];
                    case 3:
                        description = _a.sent();
                        return [2 /*return*/, {
                                children: [],
                                expanded: true,
                                uri: uri,
                                id: id,
                                name: label,
                                icon: icon,
                                description: description,
                                parent: this.root,
                                selected: false,
                                numberOfMarkers: 0
                            }];
                }
            });
        });
    };
    MarkerTree.prototype.getMarkerNodes = function (parent, markers) {
        var _this = this;
        return markers.map(function (marker, index) {
            return _this.createMarkerNode(marker, index, parent);
        });
    };
    MarkerTree.prototype.createMarkerNode = function (marker, index, parent) {
        var id = parent.id + '_' + index;
        var existing = this.getNode(id);
        if (MarkerNode.is(existing)) {
            existing.marker = marker;
            return existing;
        }
        return {
            id: id,
            name: 'marker',
            parent: parent,
            selected: false,
            uri: parent.uri,
            marker: marker
        };
    };
    MarkerTree = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [marker_manager_1.MarkerManager, Object, label_provider_1.LabelProvider])
    ], MarkerTree);
    return MarkerTree;
}(browser_1.TreeImpl));
exports.MarkerTree = MarkerTree;
var MarkerNode;
(function (MarkerNode) {
    function is(node) {
        return selection_1.UriSelection.is(node) && browser_1.SelectableTreeNode.is(node) && 'marker' in node;
    }
    MarkerNode.is = is;
})(MarkerNode = exports.MarkerNode || (exports.MarkerNode = {}));
var MarkerInfoNode;
(function (MarkerInfoNode) {
    function is(node) {
        return browser_1.ExpandableTreeNode.is(node) && selection_1.UriSelection.is(node);
    }
    MarkerInfoNode.is = is;
})(MarkerInfoNode = exports.MarkerInfoNode || (exports.MarkerInfoNode = {}));
var MarkerRootNode;
(function (MarkerRootNode) {
    function is(node) {
        return browser_1.CompositeTreeNode.is(node) && 'kind' in node;
    }
    MarkerRootNode.is = is;
})(MarkerRootNode = exports.MarkerRootNode || (exports.MarkerRootNode = {}));


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-container.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-container.js ***!
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
var __assign = (this && this.__assign) || Object.assign || function(t) {
    for (var s, i = 1, n = arguments.length; i < n; i++) {
        s = arguments[i];
        for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
            t[p] = s[p];
    }
    return t;
};
Object.defineProperty(exports, "__esModule", { value: true });
var marker_tree_1 = __webpack_require__(/*! ../marker-tree */ "../node_modules/@theia/markers/lib/browser/marker-tree.js");
var problem_widget_1 = __webpack_require__(/*! ./problem-widget */ "../node_modules/@theia/markers/lib/browser/problem/problem-widget.js");
var problem_tree_model_1 = __webpack_require__(/*! ./problem-tree-model */ "../node_modules/@theia/markers/lib/browser/problem/problem-tree-model.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var problem_marker_1 = __webpack_require__(/*! ../../common/problem-marker */ "../node_modules/@theia/markers/lib/common/problem-marker.js");
exports.PROBLEM_TREE_PROPS = __assign({}, browser_1.defaultTreeProps, { contextMenuPath: [problem_marker_1.PROBLEM_KIND] });
exports.PROBLEM_OPTIONS = {
    kind: 'problem'
};
function createProblemTreeContainer(parent) {
    var child = browser_1.createTreeContainer(parent);
    child.unbind(browser_1.TreeImpl);
    child.bind(problem_tree_model_1.ProblemTree).toSelf();
    child.rebind(browser_1.Tree).toDynamicValue(function (ctx) { return ctx.container.get(problem_tree_model_1.ProblemTree); });
    child.unbind(browser_1.TreeWidget);
    child.bind(problem_widget_1.ProblemWidget).toSelf();
    child.unbind(browser_1.TreeModelImpl);
    child.bind(problem_tree_model_1.ProblemTreeModel).toSelf();
    child.rebind(browser_1.TreeModel).toDynamicValue(function (ctx) { return ctx.container.get(problem_tree_model_1.ProblemTreeModel); });
    child.rebind(browser_1.TreeProps).toConstantValue(exports.PROBLEM_TREE_PROPS);
    child.bind(marker_tree_1.MarkerOptions).toConstantValue(exports.PROBLEM_OPTIONS);
    return child;
}
exports.createProblemTreeContainer = createProblemTreeContainer;
function createProblemWidget(parent) {
    return createProblemTreeContainer(parent).get(problem_widget_1.ProblemWidget);
}
exports.createProblemWidget = createProblemWidget;


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-contribution.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-contribution.js ***!
  \**********************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var status_bar_1 = __webpack_require__(/*! @theia/core/lib/browser/status-bar/status-bar */ "../node_modules/@theia/core/lib/browser/status-bar/status-bar.js");
var view_contribution_1 = __webpack_require__(/*! @theia/core/lib/browser/shell/view-contribution */ "../node_modules/@theia/core/lib/browser/shell/view-contribution.js");
var problem_marker_1 = __webpack_require__(/*! ../../common/problem-marker */ "../node_modules/@theia/markers/lib/common/problem-marker.js");
var problem_manager_1 = __webpack_require__(/*! ./problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var ProblemContribution = /** @class */ (function (_super) {
    __extends(ProblemContribution, _super);
    function ProblemContribution() {
        return _super.call(this, {
            widgetId: problem_marker_1.PROBLEM_KIND,
            widgetName: 'Problems',
            defaultWidgetOptions: {
                area: 'bottom'
            },
            toggleCommandId: 'problemsView:toggle',
            toggleKeybinding: 'ctrlcmd+shift+m'
        }) || this;
    }
    ProblemContribution.prototype.onStart = function (app) {
        var _this = this;
        this.setStatusBarElement(this.problemManager.getProblemStat());
        this.problemManager.onDidChangeMarkers(function () {
            _this.setStatusBarElement(_this.problemManager.getProblemStat());
        });
    };
    ProblemContribution.prototype.initializeLayout = function (app) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.openView()];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    ProblemContribution.prototype.setStatusBarElement = function (problemStat) {
        this.statusBar.setElement('problem-marker-status', {
            text: "$(times-circle) " + problemStat.errors + " $(exclamation-triangle) " + problemStat.warnings,
            alignment: status_bar_1.StatusBarAlignment.LEFT,
            priority: 10,
            command: this.toggleCommand ? this.toggleCommand.id : undefined
        });
    };
    __decorate([
        inversify_1.inject(problem_manager_1.ProblemManager),
        __metadata("design:type", problem_manager_1.ProblemManager)
    ], ProblemContribution.prototype, "problemManager", void 0);
    __decorate([
        inversify_1.inject(status_bar_1.StatusBar),
        __metadata("design:type", Object)
    ], ProblemContribution.prototype, "statusBar", void 0);
    ProblemContribution = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], ProblemContribution);
    return ProblemContribution;
}(view_contribution_1.AbstractViewContribution));
exports.ProblemContribution = ProblemContribution;


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-decorator.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-decorator.js ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 TypeFox and others.
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var __values = (this && this.__values) || function (o) {
    var m = typeof Symbol === "function" && o[Symbol.iterator], i = 0;
    if (m) return m.call(o);
    return {
        next: function () {
            if (o && i >= o.length) o = void 0;
            return { value: o && o[i++], done: !o };
        }
    };
};
var __read = (this && this.__read) || function (o, n) {
    var m = typeof Symbol === "function" && o[Symbol.iterator];
    if (!m) return o;
    var i = m.call(o), r, ar = [], e;
    try {
        while ((n === void 0 || n-- > 0) && !(r = i.next()).done) ar.push(r.value);
    }
    catch (error) { e = { error: error }; }
    finally {
        try {
            if (r && !r.done && (m = i["return"])) m.call(i);
        }
        finally { if (e) throw e.error; }
    }
    return ar;
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var vscode_languageserver_types_1 = __webpack_require__(/*! vscode-languageserver-types */ "../node_modules/vscode-languageserver-types/lib/esm/main.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var objects_1 = __webpack_require__(/*! @theia/core/lib/common/objects */ "../node_modules/@theia/core/lib/common/objects.js");
var event_1 = __webpack_require__(/*! @theia/core/lib/common/event */ "../node_modules/@theia/core/lib/common/event.js");
var tree_iterator_1 = __webpack_require__(/*! @theia/core/lib/browser/tree/tree-iterator */ "../node_modules/@theia/core/lib/browser/tree/tree-iterator.js");
var tree_decorator_1 = __webpack_require__(/*! @theia/core/lib/browser/tree/tree-decorator */ "../node_modules/@theia/core/lib/browser/tree/tree-decorator.js");
var browser_1 = __webpack_require__(/*! @theia/filesystem/lib/browser */ "../node_modules/@theia/filesystem/lib/browser/index.js");
var problem_manager_1 = __webpack_require__(/*! ./problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var ProblemDecorator = /** @class */ (function () {
    function ProblemDecorator(problemManager) {
        var _this = this;
        this.problemManager = problemManager;
        this.id = 'theia-problem-decorator';
        this.emitter = new event_1.Emitter();
        this.problemManager.onDidChangeMarkers(function () { return _this.fireDidChangeDecorations(function (tree) { return _this.collectDecorators(tree); }); });
    }
    ProblemDecorator_1 = ProblemDecorator;
    ProblemDecorator.prototype.decorations = function (tree) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                return [2 /*return*/, this.collectDecorators(tree)];
            });
        });
    };
    Object.defineProperty(ProblemDecorator.prototype, "onDidChangeDecorations", {
        get: function () {
            return this.emitter.event;
        },
        enumerable: true,
        configurable: true
    });
    ProblemDecorator.prototype.fireDidChangeDecorations = function (event) {
        this.emitter.fire(event);
    };
    ProblemDecorator.prototype.collectDecorators = function (tree) {
        var _this = this;
        var e_1, _a;
        var result = new Map();
        if (tree.root === undefined) {
            return result;
        }
        var markers = this.appendContainerMarkers(tree, this.collectMarkers(tree));
        try {
            for (var _b = __values(new tree_iterator_1.DepthFirstTreeIterator(tree.root)), _c = _b.next(); !_c.done; _c = _b.next()) {
                var node = _c.value;
                var nodeUri = browser_1.FileStatNode.getUri(node);
                if (nodeUri) {
                    var marker = markers.get(nodeUri);
                    if (marker) {
                        result.set(node.id, marker);
                    }
                }
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_1) throw e_1.error; }
        }
        return new Map(Array.from(result.entries()).map(function (m) { return [m[0], _this.toDecorator(m[1])]; }));
    };
    ProblemDecorator.prototype.appendContainerMarkers = function (tree, markers) {
        var e_2, _a;
        var result = new Map();
        try {
            // We traverse up and assign the diagnostic to the container directory.
            // Note, instead of stopping at the WS root, we traverse up the driver root.
            // We will filter them later based on the expansion state of the tree.
            for (var _b = __values(new Map(markers.map(function (m) { return [new uri_1.default(m.uri), m]; })).entries()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var _d = __read(_c.value, 2), uri = _d[0], marker = _d[1];
                var uriString = uri.toString();
                result.set(uriString, marker);
                var parentUri = uri.parent;
                while (parentUri && !parentUri.path.isRoot) {
                    var parentUriString = parentUri.toString();
                    var existing = result.get(parentUriString);
                    // Make sure the highest diagnostic severity (smaller number) will be propagated to the container directory.
                    if (existing === undefined || this.compare(marker, existing) < 0) {
                        result.set(parentUriString, {
                            data: marker.data,
                            uri: parentUriString,
                            owner: marker.owner,
                            kind: marker.kind
                        });
                        parentUri = parentUri.parent;
                    }
                    else {
                        parentUri = undefined;
                    }
                }
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
        return result;
    };
    ProblemDecorator.prototype.collectMarkers = function (tree) {
        var _this = this;
        return Array.from(this.problemManager.getUris())
            .map(function (uri) { return new uri_1.default(uri); })
            .map(function (uri) { return _this.problemManager.findMarkers({ uri: uri }); })
            .map(function (markers) { return markers.sort(_this.compare.bind(_this)); })
            .map(function (markers) { return markers.shift(); })
            .filter(objects_1.notEmpty)
            .filter(this.filterMarker.bind(this));
    };
    ProblemDecorator.prototype.toDecorator = function (marker) {
        var position = tree_decorator_1.TreeDecoration.IconOverlayPosition.BOTTOM_RIGHT;
        var icon = this.getOverlayIcon(marker);
        var color = this.getOverlayIconColor(marker);
        return {
            iconOverlay: {
                position: position,
                icon: icon,
                color: color,
                background: {
                    shape: 'circle',
                    color: 'var(--theia-layout-color0)'
                }
            }
        };
    };
    ProblemDecorator.prototype.getOverlayIcon = function (marker) {
        var severity = marker.data.severity;
        switch (severity) {
            case 1: return 'times-circle';
            case 2: return 'exclamation-circle';
            case 3: return 'info-circle';
            default: return 'hand-o-up';
        }
    };
    ProblemDecorator.prototype.getOverlayIconColor = function (marker) {
        var severity = marker.data.severity;
        switch (severity) {
            case 1: return 'var(--theia-error-color0)';
            case 2: return 'var(--theia-warn-color0)';
            case 3: return 'var(--theia-info-color0)';
            default: return 'var(--theia-success-color0)';
        }
    };
    /**
     * Returns `true` if the diagnostic (`data`) of the marker argument has `Error`, `Warning`, or `Information` severity.
     * Otherwise, returns `false`.
     */
    ProblemDecorator.prototype.filterMarker = function (marker) {
        var severity = marker.data.severity;
        return severity === vscode_languageserver_types_1.DiagnosticSeverity.Error
            || severity === vscode_languageserver_types_1.DiagnosticSeverity.Warning
            || severity === vscode_languageserver_types_1.DiagnosticSeverity.Information;
    };
    ProblemDecorator.prototype.compare = function (left, right) {
        return ProblemDecorator_1.severityCompare(left, right);
    };
    var ProblemDecorator_1;
    ProblemDecorator = ProblemDecorator_1 = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(problem_manager_1.ProblemManager)),
        __metadata("design:paramtypes", [problem_manager_1.ProblemManager])
    ], ProblemDecorator);
    return ProblemDecorator;
}());
exports.ProblemDecorator = ProblemDecorator;
(function (ProblemDecorator) {
    // Highest severities (errors) come first, then the others. Undefined severities treated as the last ones.
    ProblemDecorator.severityCompare = function (left, right) {
        return (left.data.severity || Number.MAX_SAFE_INTEGER) - (right.data.severity || Number.MAX_SAFE_INTEGER);
    };
})(ProblemDecorator = exports.ProblemDecorator || (exports.ProblemDecorator = {}));
exports.ProblemDecorator = ProblemDecorator;


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-frontend-module.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-frontend-module.js ***!
  \*************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var problem_widget_1 = __webpack_require__(/*! ./problem-widget */ "../node_modules/@theia/markers/lib/browser/problem/problem-widget.js");
var problem_contribution_1 = __webpack_require__(/*! ./problem-contribution */ "../node_modules/@theia/markers/lib/browser/problem/problem-contribution.js");
var problem_container_1 = __webpack_require__(/*! ./problem-container */ "../node_modules/@theia/markers/lib/browser/problem/problem-container.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var problem_manager_1 = __webpack_require__(/*! ./problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var problem_marker_1 = __webpack_require__(/*! ../../common/problem-marker */ "../node_modules/@theia/markers/lib/common/problem-marker.js");
var widget_manager_1 = __webpack_require__(/*! @theia/core/lib/browser/widget-manager */ "../node_modules/@theia/core/lib/browser/widget-manager.js");
var navigator_decorator_service_1 = __webpack_require__(/*! @theia/navigator/lib/browser/navigator-decorator-service */ "../node_modules/@theia/navigator/lib/browser/navigator-decorator-service.js");
var problem_decorator_1 = __webpack_require__(/*! ./problem-decorator */ "../node_modules/@theia/markers/lib/browser/problem/problem-decorator.js");
__webpack_require__(/*! ../../../src/browser/style/index.css */ "../node_modules/@theia/markers/src/browser/style/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(problem_manager_1.ProblemManager).toSelf().inSingletonScope();
    bind(problem_widget_1.ProblemWidget).toDynamicValue(function (ctx) {
        return problem_container_1.createProblemWidget(ctx.container);
    });
    bind(widget_manager_1.WidgetFactory).toDynamicValue(function (context) { return ({
        id: problem_marker_1.PROBLEM_KIND,
        createWidget: function () { return context.container.get(problem_widget_1.ProblemWidget); }
    }); });
    browser_1.bindViewContribution(bind, problem_contribution_1.ProblemContribution);
    bind(browser_1.FrontendApplicationContribution).toService(problem_contribution_1.ProblemContribution);
    bind(problem_decorator_1.ProblemDecorator).toSelf().inSingletonScope();
    bind(navigator_decorator_service_1.NavigatorTreeDecorator).toService(problem_decorator_1.ProblemDecorator);
});


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-tree-model.js":
/*!********************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-tree-model.js ***!
  \********************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var problem_marker_1 = __webpack_require__(/*! ../../common/problem-marker */ "../node_modules/@theia/markers/lib/common/problem-marker.js");
var problem_manager_1 = __webpack_require__(/*! ./problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var marker_tree_1 = __webpack_require__(/*! ../marker-tree */ "../node_modules/@theia/markers/lib/browser/marker-tree.js");
var marker_tree_model_1 = __webpack_require__(/*! ../marker-tree-model */ "../node_modules/@theia/markers/lib/browser/marker-tree-model.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
var ProblemTree = /** @class */ (function (_super) {
    __extends(ProblemTree, _super);
    function ProblemTree(problemManager, markerOptions, labelProvider) {
        var _this = _super.call(this, problemManager, markerOptions, labelProvider) || this;
        _this.problemManager = problemManager;
        _this.markerOptions = markerOptions;
        _this.labelProvider = labelProvider;
        return _this;
    }
    ProblemTree = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(problem_manager_1.ProblemManager)),
        __param(1, inversify_1.inject(marker_tree_1.MarkerOptions)),
        __param(2, inversify_1.inject(label_provider_1.LabelProvider)),
        __metadata("design:paramtypes", [problem_manager_1.ProblemManager, Object, label_provider_1.LabelProvider])
    ], ProblemTree);
    return ProblemTree;
}(marker_tree_1.MarkerTree));
exports.ProblemTree = ProblemTree;
var ProblemTreeModel = /** @class */ (function (_super) {
    __extends(ProblemTreeModel, _super);
    function ProblemTreeModel() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ProblemTreeModel.prototype.getOpenerOptionsByMarker = function (node) {
        if (problem_marker_1.ProblemMarker.is(node.marker)) {
            return {
                selection: node.marker.data.range
            };
        }
        return undefined;
    };
    ProblemTreeModel.prototype.removeNode = function (node) {
        if (marker_tree_1.MarkerInfoNode.is(node)) {
            this.problemManager.cleanAllMarkers(node.uri);
        }
        if (marker_tree_1.MarkerNode.is(node)) {
            var uri = node.uri;
            var owner = node.marker.owner;
            var diagnostics = this.problemManager.findMarkers({ uri: uri, owner: owner, dataFilter: function (data) { return node.marker.data !== data; } }).map(function (_a) {
                var data = _a.data;
                return data;
            });
            this.problemManager.setMarkers(uri, owner, diagnostics);
        }
    };
    __decorate([
        inversify_1.inject(problem_manager_1.ProblemManager),
        __metadata("design:type", problem_manager_1.ProblemManager)
    ], ProblemTreeModel.prototype, "problemManager", void 0);
    ProblemTreeModel = __decorate([
        inversify_1.injectable()
    ], ProblemTreeModel);
    return ProblemTreeModel;
}(marker_tree_model_1.MarkerTreeModel));
exports.ProblemTreeModel = ProblemTreeModel;


/***/ }),

/***/ "../node_modules/@theia/markers/lib/browser/problem/problem-widget.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/markers/lib/browser/problem/problem-widget.js ***!
  \****************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var problem_manager_1 = __webpack_require__(/*! ./problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var problem_marker_1 = __webpack_require__(/*! ../../common/problem-marker */ "../node_modules/@theia/markers/lib/common/problem-marker.js");
var problem_tree_model_1 = __webpack_require__(/*! ./problem-tree-model */ "../node_modules/@theia/markers/lib/browser/problem/problem-tree-model.js");
var marker_tree_1 = __webpack_require__(/*! ../marker-tree */ "../node_modules/@theia/markers/lib/browser/marker-tree.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var ProblemWidget = /** @class */ (function (_super) {
    __extends(ProblemWidget, _super);
    function ProblemWidget(problemManager, treeProps, model, contextMenuRenderer) {
        var _this = _super.call(this, treeProps, model, contextMenuRenderer) || this;
        _this.problemManager = problemManager;
        _this.treeProps = treeProps;
        _this.model = model;
        _this.contextMenuRenderer = contextMenuRenderer;
        _this.id = 'problems';
        _this.title.label = 'Problems';
        _this.title.caption = 'Problems';
        _this.title.iconClass = 'fa problem-tab-icon';
        _this.title.closable = true;
        _this.addClass('theia-marker-container');
        _this.addClipboardListener(_this.node, 'copy', function (e) { return _this.handleCopy(e); });
        return _this;
    }
    ProblemWidget.prototype.storeState = function () {
        // no-op
        return {};
    };
    ProblemWidget.prototype.superStoreState = function () {
        return _super.prototype.storeState.call(this);
    };
    ProblemWidget.prototype.restoreState = function (state) {
        // no-op
    };
    ProblemWidget.prototype.superRestoreState = function (state) {
        return _super.prototype.restoreState.call(this, state);
    };
    ProblemWidget.prototype.handleCopy = function (event) {
        var uris = this.model.selectedNodes.filter(marker_tree_1.MarkerNode.is).map(function (node) { return node.uri.toString(); });
        if (uris.length > 0) {
            event.clipboardData.setData('text/plain', uris.join('\n'));
            event.preventDefault();
        }
    };
    ProblemWidget.prototype.renderTree = function (model) {
        if (marker_tree_1.MarkerRootNode.is(model.root) && model.root.children.length > 0) {
            return _super.prototype.renderTree.call(this, model);
        }
        return React.createElement("div", { className: 'noMarkers' }, "No problems have been detected in the workspace so far.");
    };
    ProblemWidget.prototype.renderCaption = function (node, props) {
        if (marker_tree_1.MarkerInfoNode.is(node)) {
            return this.decorateMarkerFileNode(node);
        }
        else if (marker_tree_1.MarkerNode.is(node)) {
            return this.decorateMarkerNode(node);
        }
        return 'caption';
    };
    ProblemWidget.prototype.renderTailDecorations = function (node, props) {
        return React.createElement("div", { className: 'row-button-container' }, this.renderRemoveButton(node));
    };
    ProblemWidget.prototype.renderRemoveButton = function (node) {
        return React.createElement(ProblemMarkerRemoveButton, { model: this.model, node: node });
    };
    ProblemWidget.prototype.decorateMarkerNode = function (node) {
        if (problem_marker_1.ProblemMarker.is(node.marker)) {
            var severityClass = '';
            var problemMarker = node.marker;
            if (problemMarker.data.severity) {
                severityClass = this.getSeverityClass(problemMarker.data.severity);
            }
            return React.createElement("div", { className: 'markerNode' },
                React.createElement("div", null,
                    React.createElement("i", { className: severityClass })),
                React.createElement("div", { className: 'owner' }, '[' + problemMarker.owner + ']'),
                React.createElement("div", { className: 'message' },
                    problemMarker.data.message,
                    (problemMarker.data.code) ? React.createElement("span", { className: 'code' }, '[' + problemMarker.data.code + ']') : '',
                    React.createElement("span", { className: 'position' }, '(' + (problemMarker.data.range.start.line + 1) + ', ' + (problemMarker.data.range.start.character + 1) + ')')));
        }
        return '';
    };
    ProblemWidget.prototype.getSeverityClass = function (severity) {
        switch (severity) {
            case 1: return 'fa fa-times-circle error';
            case 2: return 'fa fa-exclamation-circle warning';
            case 3: return 'fa fa-info-circle information';
            default: return 'fa fa-hand-o-up hint';
        }
    };
    ProblemWidget.prototype.decorateMarkerFileNode = function (node) {
        return React.createElement("div", { className: 'markerFileNode' },
            React.createElement("div", { className: (node.icon || '') + ' file-icon' }),
            React.createElement("div", null, node.name),
            React.createElement("div", { className: 'path' }, node.description || ''),
            React.createElement("div", { className: 'counter' }, node.numberOfMarkers.toString()));
    };
    ProblemWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(problem_manager_1.ProblemManager)),
        __param(1, inversify_1.inject(browser_1.TreeProps)),
        __param(2, inversify_1.inject(problem_tree_model_1.ProblemTreeModel)),
        __param(3, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __metadata("design:paramtypes", [problem_manager_1.ProblemManager, Object, problem_tree_model_1.ProblemTreeModel, Object])
    ], ProblemWidget);
    return ProblemWidget;
}(browser_1.TreeWidget));
exports.ProblemWidget = ProblemWidget;
var ProblemMarkerRemoveButton = /** @class */ (function (_super) {
    __extends(ProblemMarkerRemoveButton, _super);
    function ProblemMarkerRemoveButton() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.remove = function (e) { return _this.doRemove(e); };
        return _this;
    }
    ProblemMarkerRemoveButton.prototype.render = function () {
        return React.createElement("span", { className: 'remove-node', onClick: this.remove });
    };
    ProblemMarkerRemoveButton.prototype.doRemove = function (e) {
        this.props.model.removeNode(this.props.node);
        e.stopPropagation();
    };
    return ProblemMarkerRemoveButton;
}(React.Component));
exports.ProblemMarkerRemoveButton = ProblemMarkerRemoveButton;


/***/ }),

/***/ "../node_modules/@theia/markers/src/browser/style/index.css":
/*!******************************************************************!*\
  !*** ../node_modules/@theia/markers/src/browser/style/index.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/markers/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/navigator/lib/browser/navigator-decorator-service.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/@theia/navigator/lib/browser/navigator-decorator-service.js ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 TypeFox and others.
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var contribution_provider_1 = __webpack_require__(/*! @theia/core/lib/common/contribution-provider */ "../node_modules/@theia/core/lib/common/contribution-provider.js");
var tree_decorator_1 = __webpack_require__(/*! @theia/core/lib/browser/tree/tree-decorator */ "../node_modules/@theia/core/lib/browser/tree/tree-decorator.js");
/**
 * Symbol for all decorators that would like to contribute into the navigator.
 */
exports.NavigatorTreeDecorator = Symbol('NavigatorTreeDecorator');
/**
 * Decorator service for the navigator.
 */
var NavigatorDecoratorService = /** @class */ (function (_super) {
    __extends(NavigatorDecoratorService, _super);
    function NavigatorDecoratorService(contributions) {
        var _this = _super.call(this, contributions.getContributions()) || this;
        _this.contributions = contributions;
        return _this;
    }
    NavigatorDecoratorService = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(contribution_provider_1.ContributionProvider)), __param(0, inversify_1.named(exports.NavigatorTreeDecorator)),
        __metadata("design:paramtypes", [Object])
    ], NavigatorDecoratorService);
    return NavigatorDecoratorService;
}(tree_decorator_1.AbstractTreeDecoratorService));
exports.NavigatorDecoratorService = NavigatorDecoratorService;


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/markers/src/browser/style/index.css":
/*!*********************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/markers/src/browser/style/index.css ***!
  \*********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-marker-container {\n    font-size: var(--theia-ui-font-size1);\n    color: var(--theia-ui-font-color1);\n}\n\n.theia-marker-container .theia-ExpansionToggle {\n    min-width: 16px;\n}\n\n.theia-marker-container .noMarkers {\n    margin: 5px;\n}\n\n.theia-marker-container .markerNode,\n.theia-marker-container .markerFileNode {\n    display: flex;\n    align-items: center;\n}\n\n.theia-marker-container .markerNode {\n    width: calc(100% - 32px);\n}\n\n.theia-marker-container .markerNode div,\n.theia-marker-container .markerFileNode div {\n    margin-right: 5px;\n}\n\n.theia-marker-container .markerFileNode .path {\n    font-size: var(--theia-ui-font-size0);\n    color: var(--theia-ui-font-color2);\n    align-self: flex-end;\n    white-space: nowrap;\n}\n\n.theia-marker-container .error {\n    color: var(--theia-error-color0);\n}\n\n.theia-marker-container .warning {\n    color: var(--theia-warn-color0);\n}\n\n.theia-marker-container .information {\n    color: var(--theia-info-color0);\n}\n\n.theia-marker-container .hint {\n    color: var(--theia-success-color0);\n}\n\n.theia-marker-container .markerNode .position,\n.theia-marker-container .markerNode .owner,\n.theia-marker-container .markerNode .code {\n    color: var(--theia-ui-font-color2);\n}\n\n.theia-marker-container .markerNode .position,\n.theia-marker-container .markerNode .code {\n    margin-left: 5px;\n}\n\n.theia-marker-container .markerNode .message {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n}\n\n.theia-marker-container .markerFileNode .counter {\n    background-color: var(--theia-ui-font-color2);\n    border-radius: 20px;\n    padding: 0 5px;\n    text-align: center;\n    font-size: calc(var(--theia-ui-font-size0) * 0.8);\n    color: var(--theia-inverse-ui-font-color0);\n    font-weight: 400;\n    min-width: 8px;\n    height: calc(var(--theia-private-horizontal-tab-height) * 0.8);\n    line-height: calc(var(--theia-private-horizontal-tab-height) * 0.8);\n}\n\n.problem-tab-icon::before {\n    content: \"\\F06A\"\n}\n\n.theia-marker-container .row-button-container {\n    display: none;\n}\n\n.theia-marker-container .theia-TreeNodeContent:hover .row-button-container {\n    display: flex;\n    justify-content: flex-end;\n    flex: 1;\n    align-items: center;\n    align-self: center;\n}\n\n.theia-marker-container .row-button-container .remove-node {\n    background-image: var(--theia-icon-close);\n    width: 15px;\n    height: 15px;\n}\n", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=29.bundle.js.map