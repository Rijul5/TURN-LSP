(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[33],{

/***/ "../node_modules/@theia/navigator/lib/browser/navigator-container.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/navigator/lib/browser/navigator-container.js ***!
  \***************************************************************************/
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
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
Object.defineProperty(exports, "__esModule", { value: true });
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/filesystem/lib/browser */ "../node_modules/@theia/filesystem/lib/browser/index.js");
var contribution_provider_1 = __webpack_require__(/*! @theia/core/lib/common/contribution-provider */ "../node_modules/@theia/core/lib/common/contribution-provider.js");
var navigator_tree_1 = __webpack_require__(/*! ./navigator-tree */ "../node_modules/@theia/navigator/lib/browser/navigator-tree.js");
var navigator_model_1 = __webpack_require__(/*! ./navigator-model */ "../node_modules/@theia/navigator/lib/browser/navigator-model.js");
var navigator_widget_1 = __webpack_require__(/*! ./navigator-widget */ "../node_modules/@theia/navigator/lib/browser/navigator-widget.js");
var navigator_contribution_1 = __webpack_require__(/*! ./navigator-contribution */ "../node_modules/@theia/navigator/lib/browser/navigator-contribution.js");
var navigator_decorator_service_1 = __webpack_require__(/*! ./navigator-decorator-service */ "../node_modules/@theia/navigator/lib/browser/navigator-decorator-service.js");
exports.FILE_NAVIGATOR_PROPS = __assign({}, browser_1.defaultTreeProps, { contextMenuPath: navigator_contribution_1.NAVIGATOR_CONTEXT_MENU, multiSelect: true, search: true });
function createFileNavigatorContainer(parent) {
    var child = browser_2.createFileTreeContainer(parent);
    child.unbind(browser_2.FileTree);
    child.bind(navigator_tree_1.FileNavigatorTree).toSelf();
    child.rebind(browser_1.Tree).toService(navigator_tree_1.FileNavigatorTree);
    child.unbind(browser_2.FileTreeModel);
    child.bind(navigator_model_1.FileNavigatorModel).toSelf();
    child.rebind(browser_1.TreeModel).toService(navigator_model_1.FileNavigatorModel);
    child.unbind(browser_2.FileTreeWidget);
    child.bind(navigator_widget_1.FileNavigatorWidget).toSelf();
    child.rebind(browser_1.TreeProps).toConstantValue(exports.FILE_NAVIGATOR_PROPS);
    child.bind(navigator_decorator_service_1.NavigatorDecoratorService).toSelf().inSingletonScope();
    child.rebind(browser_1.TreeDecoratorService).toService(navigator_decorator_service_1.NavigatorDecoratorService);
    contribution_provider_1.bindContributionProvider(child, navigator_decorator_service_1.NavigatorTreeDecorator);
    return child;
}
exports.createFileNavigatorContainer = createFileNavigatorContainer;
function createFileNavigatorWidget(parent) {
    return createFileNavigatorContainer(parent).get(navigator_widget_1.FileNavigatorWidget);
}
exports.createFileNavigatorWidget = createFileNavigatorWidget;


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

/***/ "../node_modules/@theia/navigator/lib/browser/navigator-frontend-module.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/navigator/lib/browser/navigator-frontend-module.js ***!
  \*********************************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var navigator_widget_1 = __webpack_require__(/*! ./navigator-widget */ "../node_modules/@theia/navigator/lib/browser/navigator-widget.js");
var navigator_keybinding_context_1 = __webpack_require__(/*! ./navigator-keybinding-context */ "../node_modules/@theia/navigator/lib/browser/navigator-keybinding-context.js");
var navigator_contribution_1 = __webpack_require__(/*! ./navigator-contribution */ "../node_modules/@theia/navigator/lib/browser/navigator-contribution.js");
var navigator_container_1 = __webpack_require__(/*! ./navigator-container */ "../node_modules/@theia/navigator/lib/browser/navigator-container.js");
var widget_manager_1 = __webpack_require__(/*! @theia/core/lib/browser/widget-manager */ "../node_modules/@theia/core/lib/browser/widget-manager.js");
var navigator_preferences_1 = __webpack_require__(/*! ./navigator-preferences */ "../node_modules/@theia/navigator/lib/browser/navigator-preferences.js");
var navigator_filter_1 = __webpack_require__(/*! ./navigator-filter */ "../node_modules/@theia/navigator/lib/browser/navigator-filter.js");
__webpack_require__(/*! ../../src/browser/style/index.css */ "../node_modules/@theia/navigator/src/browser/style/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    navigator_preferences_1.bindFileNavigatorPreferences(bind);
    bind(navigator_filter_1.FileNavigatorFilter).toSelf().inSingletonScope();
    browser_1.bindViewContribution(bind, navigator_contribution_1.FileNavigatorContribution);
    bind(browser_1.FrontendApplicationContribution).toService(navigator_contribution_1.FileNavigatorContribution);
    bind(browser_1.KeybindingContext).to(navigator_keybinding_context_1.NavigatorActiveContext).inSingletonScope();
    bind(navigator_widget_1.FileNavigatorWidget).toDynamicValue(function (ctx) {
        return navigator_container_1.createFileNavigatorWidget(ctx.container);
    });
    bind(widget_manager_1.WidgetFactory).toDynamicValue(function (context) { return ({
        id: navigator_widget_1.FILE_NAVIGATOR_ID,
        createWidget: function () { return context.container.get(navigator_widget_1.FileNavigatorWidget); }
    }); });
});


/***/ }),

/***/ "../node_modules/@theia/navigator/src/browser/style/index.css":
/*!********************************************************************!*\
  !*** ../node_modules/@theia/navigator/src/browser/style/index.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/navigator/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/workspace/lib/browser/index.js":
/*!*************************************************************!*\
  !*** ../node_modules/@theia/workspace/lib/browser/index.js ***!
  \*************************************************************/
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
__export(__webpack_require__(/*! ./workspace-commands */ "../node_modules/@theia/workspace/lib/browser/workspace-commands.js"));
__export(__webpack_require__(/*! ./workspace-service */ "../node_modules/@theia/workspace/lib/browser/workspace-service.js"));
__export(__webpack_require__(/*! ./workspace-frontend-contribution */ "../node_modules/@theia/workspace/lib/browser/workspace-frontend-contribution.js"));
__export(__webpack_require__(/*! ./workspace-frontend-module */ "../node_modules/@theia/workspace/lib/browser/workspace-frontend-module.js"));
__export(__webpack_require__(/*! ./workspace-preferences */ "../node_modules/@theia/workspace/lib/browser/workspace-preferences.js"));


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/navigator/src/browser/style/index.css":
/*!***********************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/navigator/src/browser/style/index.css ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-navigator-container {\n    font-size: var(--theia-ui-font-size1);\n    color: var(--theia-ui-font-color1);\n    margin: 5px;\n    position: relative;\n}\n\n.theia-navigator-container .open-workspace-button-container {\n    margin: auto;\n    margin-top: 5px;\n}\n\n.theia-navigator-container .center {\n    text-align: center;\n}\n\n.p-Widget .open-workspace-button {\n    border: 1px solid var(--theia-border-color1);\n    color: var(--theia-ui-font-color1);\n    font-size: var(--theia-ui-font-size1);\n    border-radius: 0;\n    background-color: var(--theia-accent-color3);\n    outline: none;\n    cursor: pointer;\n    padding-left: 12px;\n    padding-right: 12px;\n    padding-top: 4px;\n    padding-bottom: 4px;\n    width: calc(100% - var(--theia-ui-padding)*4);\n}\n\n.navigator-tab-icon::before {\n    content: \"\\F0C5\"\n}\n", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=33.bundle.js.map