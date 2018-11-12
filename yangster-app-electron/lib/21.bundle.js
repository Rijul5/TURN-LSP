(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[21],{

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-contribution.js":
/*!**************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-contribution.js ***!
  \**************************************************************************************/
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
var __spread = (this && this.__spread) || function () {
    for (var ar = [], i = 0; i < arguments.length; i++) ar = ar.concat(__read(arguments[i]));
    return ar;
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var callhierarchy_1 = __webpack_require__(/*! ./callhierarchy */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy.js");
var current_editor_access_1 = __webpack_require__(/*! ./current-editor-access */ "../node_modules/@theia/callhierarchy/lib/browser/current-editor-access.js");
var callhierarchy_service_1 = __webpack_require__(/*! ./callhierarchy-service */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-service.js");
exports.CALL_HIERARCHY_TOGGLE_COMMAND_ID = 'callhierachy:toggle';
exports.CALL_HIERARCHY_LABEL = 'Call Hierarchy';
var CallHierarchyCommands;
(function (CallHierarchyCommands) {
    CallHierarchyCommands.OPEN = {
        id: 'callhierarchy:open',
        label: 'Open Call Hierarchy'
    };
})(CallHierarchyCommands = exports.CallHierarchyCommands || (exports.CallHierarchyCommands = {}));
var CallHierarchyContribution = /** @class */ (function (_super) {
    __extends(CallHierarchyContribution, _super);
    function CallHierarchyContribution() {
        return _super.call(this, {
            widgetId: callhierarchy_1.CALLHIERARCHY_ID,
            widgetName: exports.CALL_HIERARCHY_LABEL,
            defaultWidgetOptions: {
                area: 'bottom'
            },
            toggleCommandId: exports.CALL_HIERARCHY_TOGGLE_COMMAND_ID,
            toggleKeybinding: 'ctrlcmd+shift+f1'
        }) || this;
    }
    CallHierarchyContribution.prototype.isCallHierarchyAvailable = function () {
        var selection = this.editorAccess.getSelection();
        var languageId = this.editorAccess.getLanguageId();
        return !!selection && !!languageId && !!this.callHierarchyServiceProvider.get(languageId);
    };
    CallHierarchyContribution.prototype.openView = function (args) {
        return __awaiter(this, void 0, void 0, function () {
            var widget, selection, languageId;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, _super.prototype.openView.call(this, args)];
                    case 1:
                        widget = _a.sent();
                        selection = this.editorAccess.getSelection();
                        languageId = this.editorAccess.getLanguageId();
                        widget.initializeModel(selection, languageId);
                        return [2 /*return*/, widget];
                }
            });
        });
    };
    CallHierarchyContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(CallHierarchyCommands.OPEN, {
            execute: function () { return _this.openView({
                toggle: false,
                activate: true
            }); },
            isEnabled: this.isCallHierarchyAvailable.bind(this)
        });
        _super.prototype.registerCommands.call(this, commands);
    };
    CallHierarchyContribution.prototype.registerMenus = function (menus) {
        var menuPath = __spread(browser_2.EDITOR_CONTEXT_MENU, ['navigation']);
        menus.registerMenuAction(menuPath, {
            commandId: CallHierarchyCommands.OPEN.id,
            label: exports.CALL_HIERARCHY_LABEL
        });
        _super.prototype.registerMenus.call(this, menus);
    };
    CallHierarchyContribution.prototype.registerKeybindings = function (keybindings) {
        _super.prototype.registerKeybindings.call(this, keybindings);
        keybindings.registerKeybinding({
            command: CallHierarchyCommands.OPEN.id,
            keybinding: 'ctrlcmd+f1'
        });
    };
    __decorate([
        inversify_1.inject(current_editor_access_1.CurrentEditorAccess),
        __metadata("design:type", current_editor_access_1.CurrentEditorAccess)
    ], CallHierarchyContribution.prototype, "editorAccess", void 0);
    __decorate([
        inversify_1.inject(callhierarchy_service_1.CallHierarchyServiceProvider),
        __metadata("design:type", callhierarchy_service_1.CallHierarchyServiceProvider)
    ], CallHierarchyContribution.prototype, "callHierarchyServiceProvider", void 0);
    CallHierarchyContribution = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], CallHierarchyContribution);
    return CallHierarchyContribution;
}(browser_1.AbstractViewContribution));
exports.CallHierarchyContribution = CallHierarchyContribution;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-frontend-module.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-frontend-module.js ***!
  \*****************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var callhierarchy_contribution_1 = __webpack_require__(/*! ./callhierarchy-contribution */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-contribution.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var callhierarchy_service_1 = __webpack_require__(/*! ./callhierarchy-service */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-service.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var callhierarchy_1 = __webpack_require__(/*! ./callhierarchy */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy.js");
var callhierarchy_tree_1 = __webpack_require__(/*! ./callhierarchy-tree */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/index.js");
var current_editor_access_1 = __webpack_require__(/*! ./current-editor-access */ "../node_modules/@theia/callhierarchy/lib/browser/current-editor-access.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
__webpack_require__(/*! ../../src/browser/style/index.css */ "../node_modules/@theia/callhierarchy/src/browser/style/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(current_editor_access_1.CurrentEditorAccess).toSelf().inSingletonScope();
    common_1.bindContributionProvider(bind, callhierarchy_service_1.CallHierarchyService);
    bind(callhierarchy_service_1.CallHierarchyServiceProvider).to(callhierarchy_service_1.CallHierarchyServiceProvider).inSingletonScope();
    browser_1.bindViewContribution(bind, callhierarchy_contribution_1.CallHierarchyContribution);
    bind(browser_1.WidgetFactory).toDynamicValue(function (context) { return ({
        id: callhierarchy_1.CALLHIERARCHY_ID,
        createWidget: function () { return callhierarchy_tree_1.createHierarchyTreeWidget(context.container); }
    }); });
});


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-service.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-service.js ***!
  \*********************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
exports.CallHierarchyService = Symbol('CallHierarchyService');
var CallHierarchyServiceProvider = /** @class */ (function () {
    function CallHierarchyServiceProvider() {
    }
    CallHierarchyServiceProvider.prototype.get = function (languageId) {
        return this.contributions.getContributions().find(function (service) { return languageId === service.languageId; });
    };
    __decorate([
        inversify_1.inject(common_1.ContributionProvider), inversify_1.named(exports.CallHierarchyService),
        __metadata("design:type", Object)
    ], CallHierarchyServiceProvider.prototype, "contributions", void 0);
    CallHierarchyServiceProvider = __decorate([
        inversify_1.injectable()
    ], CallHierarchyServiceProvider);
    return CallHierarchyServiceProvider;
}());
exports.CallHierarchyServiceProvider = CallHierarchyServiceProvider;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-container.js":
/*!***********************************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-container.js ***!
  \***********************************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var callhierarchy_tree_1 = __webpack_require__(/*! ./callhierarchy-tree */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js");
var callhierarchy_tree_model_1 = __webpack_require__(/*! ./callhierarchy-tree-model */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-model.js");
var callhierarchy_tree_widget_1 = __webpack_require__(/*! ./callhierarchy-tree-widget */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-widget.js");
function createHierarchyTreeContainer(parent) {
    var child = browser_1.createTreeContainer(parent);
    child.unbind(browser_1.TreeImpl);
    child.bind(callhierarchy_tree_1.CallHierarchyTree).toSelf();
    child.rebind(browser_1.Tree).toDynamicValue(function (ctx) { return ctx.container.get(callhierarchy_tree_1.CallHierarchyTree); });
    child.unbind(browser_1.TreeModelImpl);
    child.bind(callhierarchy_tree_model_1.CallHierarchyTreeModel).toSelf();
    child.rebind(browser_1.TreeModel).toDynamicValue(function (ctx) { return ctx.container.get(callhierarchy_tree_model_1.CallHierarchyTreeModel); });
    child.bind(callhierarchy_tree_widget_1.CallHierarchyTreeWidget).toSelf();
    child.rebind(browser_1.TreeWidget).toDynamicValue(function (ctx) { return ctx.container.get(callhierarchy_tree_widget_1.CallHierarchyTreeWidget); });
    return child;
}
function createHierarchyTreeWidget(parent) {
    return createHierarchyTreeContainer(parent).get(callhierarchy_tree_widget_1.CallHierarchyTreeWidget);
}
exports.createHierarchyTreeWidget = createHierarchyTreeWidget;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-model.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-model.js ***!
  \*******************************************************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var callhierarchy_tree_1 = __webpack_require__(/*! ./callhierarchy-tree */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js");
var callhierarchy_service_1 = __webpack_require__(/*! ../callhierarchy-service */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-service.js");
var CallHierarchyTreeModel = /** @class */ (function (_super) {
    __extends(CallHierarchyTreeModel, _super);
    function CallHierarchyTreeModel() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    CallHierarchyTreeModel.prototype.getTree = function () {
        return this.tree;
    };
    CallHierarchyTreeModel.prototype.initializeCallHierarchy = function (languageId, location) {
        return __awaiter(this, void 0, void 0, function () {
            var callHierarchyService, rootDefinition, rootNode;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.tree.root = undefined;
                        this.tree.callHierarchyService = undefined;
                        if (!(languageId && location)) return [3 /*break*/, 2];
                        callHierarchyService = this.callHierarchyServiceProvider.get(languageId);
                        if (!callHierarchyService) return [3 /*break*/, 2];
                        this.tree.callHierarchyService = callHierarchyService;
                        return [4 /*yield*/, callHierarchyService.getRootDefinition(location)];
                    case 1:
                        rootDefinition = _a.sent();
                        if (rootDefinition) {
                            rootNode = callhierarchy_tree_1.DefinitionNode.create(rootDefinition, undefined);
                            this.tree.root = rootNode;
                        }
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    CallHierarchyTreeModel.prototype.doOpenNode = function (node) {
        // do nothing (in particular do not expand the node)
    };
    __decorate([
        inversify_1.inject(callhierarchy_tree_1.CallHierarchyTree),
        __metadata("design:type", callhierarchy_tree_1.CallHierarchyTree)
    ], CallHierarchyTreeModel.prototype, "tree", void 0);
    __decorate([
        inversify_1.inject(callhierarchy_service_1.CallHierarchyServiceProvider),
        __metadata("design:type", callhierarchy_service_1.CallHierarchyServiceProvider)
    ], CallHierarchyTreeModel.prototype, "callHierarchyServiceProvider", void 0);
    CallHierarchyTreeModel = __decorate([
        inversify_1.injectable()
    ], CallHierarchyTreeModel);
    return CallHierarchyTreeModel;
}(browser_1.TreeModelImpl));
exports.CallHierarchyTreeModel = CallHierarchyTreeModel;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-widget.js":
/*!********************************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-widget.js ***!
  \********************************************************************************************************/
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
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
var callhierarchy_tree_1 = __webpack_require__(/*! ./callhierarchy-tree */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js");
var callhierarchy_tree_model_1 = __webpack_require__(/*! ./callhierarchy-tree-model */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-model.js");
var callhierarchy_1 = __webpack_require__(/*! ../callhierarchy */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var vscode_languageserver_types_1 = __webpack_require__(/*! vscode-languageserver-types */ "../node_modules/vscode-languageserver-types/lib/esm/main.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
exports.HIERARCHY_TREE_CLASS = 'theia-CallHierarchyTree';
exports.DEFINITION_NODE_CLASS = 'theia-CallHierarchyTreeNode';
exports.DEFINITION_ICON_CLASS = 'theia-CallHierarchyTreeNodeIcon';
var CallHierarchyTreeWidget = /** @class */ (function (_super) {
    __extends(CallHierarchyTreeWidget, _super);
    function CallHierarchyTreeWidget(props, model, contextMenuRenderer, labelProvider, editorManager) {
        var _this = _super.call(this, props, model, contextMenuRenderer) || this;
        _this.props = props;
        _this.model = model;
        _this.labelProvider = labelProvider;
        _this.editorManager = editorManager;
        _this.id = callhierarchy_1.CALLHIERARCHY_ID;
        _this.title.label = 'Call Hierarchy';
        _this.title.caption = 'Call Hierarchy';
        _this.title.iconClass = 'fa call-hierarchy-tab-icon';
        _this.title.closable = true;
        _this.addClass(exports.HIERARCHY_TREE_CLASS);
        _this.toDispose.push(_this.model.onSelectionChanged(function (selection) {
            var node = selection[0];
            if (node) {
                _this.openEditor(node, true);
            }
        }));
        _this.toDispose.push(_this.model.onOpenNode(function (node) {
            _this.openEditor(node, false);
        }));
        return _this;
    }
    CallHierarchyTreeWidget.prototype.initializeModel = function (selection, languageId) {
        this.model.initializeCallHierarchy(languageId, selection);
    };
    CallHierarchyTreeWidget.prototype.createNodeClassNames = function (node, props) {
        var classNames = _super.prototype.createNodeClassNames.call(this, node, props);
        if (callhierarchy_tree_1.DefinitionNode.is(node)) {
            classNames.push(exports.DEFINITION_NODE_CLASS);
        }
        return classNames;
    };
    CallHierarchyTreeWidget.prototype.createNodeAttributes = function (node, props) {
        var elementAttrs = _super.prototype.createNodeAttributes.call(this, node, props);
        return __assign({}, elementAttrs);
    };
    CallHierarchyTreeWidget.prototype.renderTree = function (model) {
        return _super.prototype.renderTree.call(this, model)
            || React.createElement("div", { className: 'noCallers' }, "No callers have been detected.");
    };
    CallHierarchyTreeWidget.prototype.renderCaption = function (node, props) {
        if (callhierarchy_tree_1.DefinitionNode.is(node)) {
            return this.decorateDefinitionCaption(node.definition);
        }
        if (callhierarchy_tree_1.CallerNode.is(node)) {
            return this.decorateCallerCaption(node.caller);
        }
        return 'caption';
    };
    CallHierarchyTreeWidget.prototype.decorateDefinitionCaption = function (definition) {
        var containerName = definition.containerName;
        var symbol = definition.symbolName;
        var location = this.labelProvider.getName(new uri_1.default(definition.location.uri));
        var container = (containerName) ? containerName + ' — ' + location : location;
        return React.createElement("div", { className: 'definitionNode' },
            React.createElement("div", { className: 'symbol-icon ' + this.toIconClass(definition.symbolKind) }),
            React.createElement("div", { className: 'symbol' }, symbol),
            React.createElement("div", { className: 'container' }, container));
    };
    CallHierarchyTreeWidget.prototype.decorateCallerCaption = function (caller) {
        var definition = caller.callerDefinition;
        var containerName = definition.containerName;
        var symbol = definition.symbolName;
        var referenceCount = caller.references.length;
        var location = this.labelProvider.getName(new uri_1.default(definition.location.uri));
        var container = (containerName) ? containerName + ' — ' + location : location;
        return React.createElement("div", { className: 'definitionNode' },
            React.createElement("div", { className: 'symbol-icon ' + this.toIconClass(definition.symbolKind) }),
            React.createElement("div", { className: 'symbol' }, symbol),
            React.createElement("div", { className: 'referenceCount' }, (referenceCount > 1) ? "[" + referenceCount + "]" : ''),
            React.createElement("div", { className: 'container' }, container));
    };
    CallHierarchyTreeWidget.prototype.toIconClass = function (symbolKind) {
        switch (symbolKind) {
            case vscode_languageserver_types_1.SymbolKind.File: return 'file';
            case vscode_languageserver_types_1.SymbolKind.Module: return 'module';
            case vscode_languageserver_types_1.SymbolKind.Namespace: return 'namespace';
            case vscode_languageserver_types_1.SymbolKind.Package: return 'package';
            case vscode_languageserver_types_1.SymbolKind.Class: return 'class';
            case vscode_languageserver_types_1.SymbolKind.Method: return 'method';
            case vscode_languageserver_types_1.SymbolKind.Property: return 'property';
            case vscode_languageserver_types_1.SymbolKind.Field: return 'field';
            case vscode_languageserver_types_1.SymbolKind.Constructor: return 'constructor';
            case vscode_languageserver_types_1.SymbolKind.Enum: return 'enum';
            case vscode_languageserver_types_1.SymbolKind.Interface: return 'interface';
            case vscode_languageserver_types_1.SymbolKind.Function: return 'function';
            case vscode_languageserver_types_1.SymbolKind.Variable: return 'variable';
            case vscode_languageserver_types_1.SymbolKind.Constant: return 'constant';
            case vscode_languageserver_types_1.SymbolKind.String: return 'string';
            case vscode_languageserver_types_1.SymbolKind.Number: return 'number';
            case vscode_languageserver_types_1.SymbolKind.Boolean: return 'boolean';
            case vscode_languageserver_types_1.SymbolKind.Array: return 'array';
            default: return 'unknown';
        }
    };
    CallHierarchyTreeWidget.prototype.openEditor = function (node, keepFocus) {
        var location;
        if (callhierarchy_tree_1.DefinitionNode.is(node)) {
            location = node.definition.location;
        }
        if (callhierarchy_tree_1.CallerNode.is(node)) {
            location = node.caller.references[0];
        }
        if (location) {
            this.editorManager.open(new uri_1.default(location.uri), {
                mode: keepFocus ? 'reveal' : 'activate',
                selection: vscode_languageserver_types_1.Range.create(location.range.start, location.range.end)
            }).then(function (editorWidget) {
                if (editorWidget.parent instanceof browser_1.DockPanel) {
                    editorWidget.parent.selectWidget(editorWidget);
                }
            });
        }
    };
    CallHierarchyTreeWidget.prototype.storeState = function () {
        var callHierarchyService = this.model.getTree().callHierarchyService;
        if (this.model.root && callHierarchyService) {
            return {
                root: this.deflateForStorage(this.model.root),
                languageId: callHierarchyService.languageId,
            };
        }
        else {
            return {};
        }
    };
    CallHierarchyTreeWidget.prototype.restoreState = function (oldState) {
        // tslint:disable-next-line:no-any
        if (oldState.root && oldState.languageId) {
            // tslint:disable-next-line:no-any
            this.model.root = this.inflateFromStorage(oldState.root);
            // tslint:disable-next-line:no-any
            this.model.initializeCallHierarchy(oldState.languageId, this.model.root.definition.location);
        }
    };
    CallHierarchyTreeWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_1.TreeProps)),
        __param(1, inversify_1.inject(callhierarchy_tree_model_1.CallHierarchyTreeModel)),
        __param(2, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __param(3, inversify_1.inject(label_provider_1.LabelProvider)),
        __param(4, inversify_1.inject(browser_2.EditorManager)),
        __metadata("design:paramtypes", [Object, callhierarchy_tree_model_1.CallHierarchyTreeModel, Object, label_provider_1.LabelProvider,
            browser_2.EditorManager])
    ], CallHierarchyTreeWidget);
    return CallHierarchyTreeWidget;
}(browser_1.TreeWidget));
exports.CallHierarchyTreeWidget = CallHierarchyTreeWidget;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js":
/*!*************************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js ***!
  \*************************************************************************************************/
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
var __spread = (this && this.__spread) || function () {
    for (var ar = [], i = 0; i < arguments.length; i++) ar = ar.concat(__read(arguments[i]));
    return ar;
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var md5_1 = __webpack_require__(/*! ts-md5/dist/md5 */ "../node_modules/ts-md5/dist/md5.js");
var CallHierarchyTree = /** @class */ (function (_super) {
    __extends(CallHierarchyTree, _super);
    function CallHierarchyTree() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Object.defineProperty(CallHierarchyTree.prototype, "callHierarchyService", {
        get: function () {
            return this._callHierarchyService;
        },
        set: function (callHierarchyService) {
            this._callHierarchyService = callHierarchyService;
        },
        enumerable: true,
        configurable: true
    });
    CallHierarchyTree.prototype.resolveChildren = function (parent) {
        return __awaiter(this, void 0, void 0, function () {
            var definition, callers;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!this.callHierarchyService) {
                            return [2 /*return*/, Promise.resolve([])];
                        }
                        if (parent.children.length > 0) {
                            return [2 /*return*/, Promise.resolve(__spread(parent.children))];
                        }
                        if (DefinitionNode.is(parent)) {
                            definition = parent.definition;
                        }
                        else if (CallerNode.is(parent)) {
                            definition = parent.caller.callerDefinition;
                        }
                        if (!definition) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.callHierarchyService.getCallers(definition)];
                    case 1:
                        callers = _a.sent();
                        if (!callers) {
                            return [2 /*return*/, Promise.resolve([])];
                        }
                        return [2 /*return*/, this.toNodes(callers, parent)];
                    case 2: return [2 /*return*/, Promise.resolve([])];
                }
            });
        });
    };
    CallHierarchyTree.prototype.toNodes = function (callers, parent) {
        var _this = this;
        return callers.map(function (caller) { return _this.toNode(caller, parent); });
    };
    CallHierarchyTree.prototype.toNode = function (caller, parent) {
        return CallerNode.create(caller, parent);
    };
    CallHierarchyTree = __decorate([
        inversify_1.injectable()
    ], CallHierarchyTree);
    return CallHierarchyTree;
}(browser_1.TreeImpl));
exports.CallHierarchyTree = CallHierarchyTree;
var DefinitionNode;
(function (DefinitionNode) {
    function is(node) {
        return !!node && 'definition' in node;
    }
    DefinitionNode.is = is;
    function create(definition, parent) {
        var name = definition.symbolName;
        var id = createId(definition, parent);
        return {
            id: id, definition: definition, name: name, parent: parent,
            visible: true,
            children: [],
            expanded: false,
            selected: false,
        };
    }
    DefinitionNode.create = create;
})(DefinitionNode = exports.DefinitionNode || (exports.DefinitionNode = {}));
var CallerNode;
(function (CallerNode) {
    function is(node) {
        return !!node && 'caller' in node;
    }
    CallerNode.is = is;
    function create(caller, parent) {
        var callerDefinition = caller.callerDefinition;
        var name = callerDefinition.symbolName;
        var id = createId(callerDefinition, parent);
        return {
            id: id, caller: caller, name: name, parent: parent,
            visible: true,
            children: [],
            expanded: false,
            selected: false,
        };
    }
    CallerNode.create = create;
})(CallerNode = exports.CallerNode || (exports.CallerNode = {}));
function createId(definition, parent) {
    var idPrefix = (parent) ? parent.id + '/' : '';
    var id = idPrefix + md5_1.Md5.hashStr(JSON.stringify(definition));
    return id;
}


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/index.js":
/*!************************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/index.js ***!
  \************************************************************************************/
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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(/*! ./callhierarchy-tree */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree.js"));
__export(__webpack_require__(/*! ./callhierarchy-tree-model */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-model.js"));
__export(__webpack_require__(/*! ./callhierarchy-tree-widget */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-widget.js"));
__export(__webpack_require__(/*! ./callhierarchy-tree-container */ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy-tree/callhierarchy-tree-container.js"));


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/callhierarchy.js":
/*!*************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/callhierarchy.js ***!
  \*************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
exports.CALLHIERARCHY_ID = 'callhierarchy';


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/lib/browser/current-editor-access.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/lib/browser/current-editor-access.js ***!
  \*********************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var CurrentEditorAccess = /** @class */ (function () {
    function CurrentEditorAccess() {
    }
    CurrentEditorAccess.prototype.getSelection = function () {
        var activeEditor = this.getCurrentEditor();
        if (!activeEditor) {
            return;
        }
        var range = activeEditor.selection;
        var uri = activeEditor.uri.toString();
        return { range: range, uri: uri };
    };
    CurrentEditorAccess.prototype.getLanguageId = function () {
        var activeEditor = this.getCurrentEditor();
        if (!activeEditor) {
            return;
        }
        return activeEditor.document.languageId;
    };
    CurrentEditorAccess.prototype.getCurrentEditor = function () {
        var activeEditor = this.editorManager.currentEditor;
        if (activeEditor) {
            return activeEditor.editor;
        }
        return undefined;
    };
    __decorate([
        inversify_1.inject(browser_1.EditorManager),
        __metadata("design:type", browser_1.EditorManager)
    ], CurrentEditorAccess.prototype, "editorManager", void 0);
    CurrentEditorAccess = __decorate([
        inversify_1.injectable()
    ], CurrentEditorAccess);
    return CurrentEditorAccess;
}());
exports.CurrentEditorAccess = CurrentEditorAccess;


/***/ }),

/***/ "../node_modules/@theia/callhierarchy/src/browser/style/index.css":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/callhierarchy/src/browser/style/index.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/callhierarchy/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/callhierarchy/src/browser/style/index.css":
/*!***************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/callhierarchy/src/browser/style/index.css ***!
  \***************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-CallHierarchyTree {\n    font-size: var(--theia-ui-font-size1);\n    color: var(--theia-ui-font-color1);\n}\n\n.theia-CallHierarchyTree .theia-TreeNode {\n    width: 100%;\n}\n\n.theia-CallHierarchyTree .theia-ExpansionToggle {\n    min-width: 16px;\n}\n\n.theia-CallHierarchyTree .noCallers {\n    margin: 5px;\n}\n\n.theia-CallHierarchyTree .definitionNode {\n    display: flex;\n}\n\n.theia-CallHierarchyTree .definitionNode {\n    width: calc(100% - 32px);\n}\n\n.theia-CallHierarchyTree .definitionNode div {\n    margin-right: 5px;\n}\n\n.theia-CallHierarchyTree .definitionNode .symbol {\n    white-space: nowrap;\n    overflow: hidden;\n}\n\n.theia-CallHierarchyTree .definitionNode .referenceCount {\n    white-space: nowrap;\n    overflow: hidden;\n    color: var(--theia-ui-font-color3);\n}\n\n.theia-CallHierarchyTree .definitionNode .container {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    color: var(--theia-ui-font-color2);\n}\n\n.call-hierarchy-tab-icon::before {\n    content: \"\\F0AB\"\n}\n", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=21.bundle.js.map