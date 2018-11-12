(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[29],{

/***/ "../node_modules/@theia/preferences/lib/browser/abstract-resource-preference-provider.js":
/*!***********************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/abstract-resource-preference-provider.js ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson and others.
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
var jsoncparser = __webpack_require__(/*! jsonc-parser */ "../node_modules/jsonc-parser/lib/esm/main.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var preferences_1 = __webpack_require__(/*! @theia/core/lib/browser/preferences */ "../node_modules/@theia/core/lib/browser/preferences/index.js");
var AbstractResourcePreferenceProvider = /** @class */ (function (_super) {
    __extends(AbstractResourcePreferenceProvider, _super);
    function AbstractResourcePreferenceProvider() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        // tslint:disable-next-line:no-any
        _this.preferences = {};
        return _this;
    }
    AbstractResourcePreferenceProvider.prototype.init = function () {
        return __awaiter(this, void 0, void 0, function () {
            var uri, resource;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.getUri()];
                    case 1:
                        uri = _a.sent();
                        // In case if no workspace is opened there are no workspace settings.
                        // There is nothing to contribute to preferences and we just skip it.
                        if (!uri) {
                            this._ready.resolve();
                            return [2 /*return*/];
                        }
                        this.resource = this.resourceProvider(uri);
                        // Try to read the initial content of the preferences.  The provider
                        // becomes ready even if we fail reading the preferences, so we don't
                        // hang the preference service.
                        this.readPreferences()
                            .then(function () { return _this._ready.resolve(); })
                            .catch(function () { return _this._ready.resolve(); });
                        return [4 /*yield*/, this.resource];
                    case 2:
                        resource = _a.sent();
                        this.toDispose.push(resource);
                        if (resource.onDidChangeContents) {
                            this.toDispose.push(resource.onDidChangeContents(function (content) { return _this.readPreferences(); }));
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    // tslint:disable-next-line:no-any
    AbstractResourcePreferenceProvider.prototype.getPreferences = function () {
        return this.preferences;
    };
    // tslint:disable-next-line:no-any
    AbstractResourcePreferenceProvider.prototype.setPreference = function (key, value) {
        return __awaiter(this, void 0, void 0, function () {
            var resource, content, formattingOptions, edits, result;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.resource];
                    case 1:
                        resource = _a.sent();
                        if (!resource.saveContents) return [3 /*break*/, 4];
                        return [4 /*yield*/, this.readContents()];
                    case 2:
                        content = _a.sent();
                        formattingOptions = { tabSize: 3, insertSpaces: true, eol: '' };
                        edits = jsoncparser.modify(content, [key], value, { formattingOptions: formattingOptions });
                        result = jsoncparser.applyEdits(content, edits);
                        return [4 /*yield*/, resource.saveContents(result)];
                    case 3:
                        _a.sent();
                        this.preferences[key] = value;
                        this.onDidPreferencesChangedEmitter.fire(undefined);
                        _a.label = 4;
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    AbstractResourcePreferenceProvider.prototype.readPreferences = function () {
        return __awaiter(this, void 0, void 0, function () {
            var newContent, strippedContent;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.readContents()];
                    case 1:
                        newContent = _a.sent();
                        strippedContent = jsoncparser.stripComments(newContent);
                        this.preferences = jsoncparser.parse(strippedContent) || {};
                        this.onDidPreferencesChangedEmitter.fire(undefined);
                        return [2 /*return*/];
                }
            });
        });
    };
    AbstractResourcePreferenceProvider.prototype.readContents = function () {
        return __awaiter(this, void 0, void 0, function () {
            var resource, _a;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        _b.trys.push([0, 3, , 4]);
                        return [4 /*yield*/, this.resource];
                    case 1:
                        resource = _b.sent();
                        return [4 /*yield*/, resource.readContents()];
                    case 2: return [2 /*return*/, _b.sent()];
                    case 3:
                        _a = _b.sent();
                        return [2 /*return*/, ''];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(common_1.ILogger),
        __metadata("design:type", Object)
    ], AbstractResourcePreferenceProvider.prototype, "logger", void 0);
    __decorate([
        inversify_1.inject(common_1.ResourceProvider),
        __metadata("design:type", Function)
    ], AbstractResourcePreferenceProvider.prototype, "resourceProvider", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", Promise)
    ], AbstractResourcePreferenceProvider.prototype, "init", null);
    AbstractResourcePreferenceProvider = __decorate([
        inversify_1.injectable()
    ], AbstractResourcePreferenceProvider);
    return AbstractResourcePreferenceProvider;
}(preferences_1.PreferenceProvider));
exports.AbstractResourcePreferenceProvider = AbstractResourcePreferenceProvider;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preference-frontend-module.js":
/*!************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preference-frontend-module.js ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson and others.
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
var preferences_1 = __webpack_require__(/*! @theia/core/lib/browser/preferences */ "../node_modules/@theia/core/lib/browser/preferences/index.js");
var user_preference_provider_1 = __webpack_require__(/*! ./user-preference-provider */ "../node_modules/@theia/preferences/lib/browser/user-preference-provider.js");
var workspace_preference_provider_1 = __webpack_require__(/*! ./workspace-preference-provider */ "../node_modules/@theia/preferences/lib/browser/workspace-preference-provider.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var preferences_contribution_1 = __webpack_require__(/*! ./preferences-contribution */ "../node_modules/@theia/preferences/lib/browser/preferences-contribution.js");
var preference_tree_container_1 = __webpack_require__(/*! ./preference-tree-container */ "../node_modules/@theia/preferences/lib/browser/preference-tree-container.js");
var preferences_menu_factory_1 = __webpack_require__(/*! ./preferences-menu-factory */ "../node_modules/@theia/preferences/lib/browser/preferences-menu-factory.js");
var preferences_tree_widget_1 = __webpack_require__(/*! ./preferences-tree-widget */ "../node_modules/@theia/preferences/lib/browser/preferences-tree-widget.js");
var preferences_frontend_application_contribution_1 = __webpack_require__(/*! ./preferences-frontend-application-contribution */ "../node_modules/@theia/preferences/lib/browser/preferences-frontend-application-contribution.js");
__webpack_require__(/*! ./preferences-monaco-contribution */ "../node_modules/@theia/preferences/lib/browser/preferences-monaco-contribution.js");
function bindPreferences(bind, unbind) {
    unbind(preferences_1.PreferenceProvider);
    bind(preferences_1.PreferenceProvider).to(user_preference_provider_1.UserPreferenceProvider).inSingletonScope().whenTargetNamed(preferences_1.PreferenceScope.User);
    bind(preferences_1.PreferenceProvider).to(workspace_preference_provider_1.WorkspacePreferenceProvider).inSingletonScope().whenTargetNamed(preferences_1.PreferenceScope.Workspace);
    browser_1.bindViewContribution(bind, preferences_contribution_1.PreferencesContribution);
    bind(preferences_tree_widget_1.PreferencesContainer).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (_a) {
        var container = _a.container;
        return ({
            id: preferences_tree_widget_1.PreferencesContainer.ID,
            createWidget: function () { return container.get(preferences_tree_widget_1.PreferencesContainer); }
        });
    });
    bind(browser_1.WidgetFactory).toDynamicValue(function (_a) {
        var container = _a.container;
        return ({
            id: preferences_tree_widget_1.PreferencesTreeWidget.ID,
            createWidget: function () { return preference_tree_container_1.createPreferencesTreeWidget(container); }
        });
    }).inSingletonScope();
    bind(preferences_tree_widget_1.PreferencesEditorsContainer).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (_a) {
        var container = _a.container;
        return ({
            id: preferences_tree_widget_1.PreferencesEditorsContainer.ID,
            createWidget: function () { return container.get(preferences_tree_widget_1.PreferencesEditorsContainer); }
        });
    });
    bind(preferences_menu_factory_1.PreferencesMenuFactory).toSelf();
    bind(browser_1.FrontendApplicationContribution).to(preferences_frontend_application_contribution_1.PreferencesFrontendApplicationContribution).inSingletonScope();
}
exports.bindPreferences = bindPreferences;
exports.default = new inversify_1.ContainerModule(function (bind, unbind, isBound, rebind) {
    bindPreferences(bind, unbind);
});


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preference-tree-container.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preference-tree-container.js ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Red Hat, Inc. and others.
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
var preferences_decorator_1 = __webpack_require__(/*! ./preferences-decorator */ "../node_modules/@theia/preferences/lib/browser/preferences-decorator.js");
var preferences_decorator_service_1 = __webpack_require__(/*! ./preferences-decorator-service */ "../node_modules/@theia/preferences/lib/browser/preferences-decorator-service.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var preferences_tree_widget_1 = __webpack_require__(/*! ./preferences-tree-widget */ "../node_modules/@theia/preferences/lib/browser/preferences-tree-widget.js");
function createPreferencesTreeWidget(parent) {
    var child = browser_1.createTreeContainer(parent);
    child.bind(preferences_tree_widget_1.PreferencesTreeWidget).toSelf();
    child.rebind(browser_1.TreeProps).toConstantValue(__assign({}, browser_1.defaultTreeProps, { search: true }));
    child.rebind(browser_1.TreeWidget).toService(preferences_tree_widget_1.PreferencesTreeWidget);
    bindPreferencesDecorator(child);
    return child.get(preferences_tree_widget_1.PreferencesTreeWidget);
}
exports.createPreferencesTreeWidget = createPreferencesTreeWidget;
function bindPreferencesDecorator(parent) {
    parent.bind(preferences_decorator_1.PreferencesDecorator).toSelf().inSingletonScope();
    parent.bind(preferences_decorator_service_1.PreferencesDecoratorService).toSelf().inSingletonScope();
    parent.rebind(browser_1.TreeDecoratorService).toService(preferences_decorator_service_1.PreferencesDecoratorService);
}


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-contribution.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-contribution.js ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson and others.
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
var workspace_preference_provider_1 = __webpack_require__(/*! ./workspace-preference-provider */ "../node_modules/@theia/preferences/lib/browser/workspace-preference-provider.js");
var common_1 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var browser_2 = __webpack_require__(/*! @theia/userstorage/lib/browser */ "../node_modules/@theia/userstorage/lib/browser/index.js");
var preferences_tree_widget_1 = __webpack_require__(/*! ./preferences-tree-widget */ "../node_modules/@theia/preferences/lib/browser/preferences-tree-widget.js");
var browser_3 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var PreferencesContribution = /** @class */ (function (_super) {
    __extends(PreferencesContribution, _super);
    function PreferencesContribution() {
        return _super.call(this, {
            widgetId: preferences_tree_widget_1.PreferencesContainer.ID,
            widgetName: 'Preferences',
            defaultWidgetOptions: { area: 'main' }
        }) || this;
    }
    PreferencesContribution.prototype.registerCommands = function (commands) {
        return __awaiter(this, void 0, void 0, function () {
            var _this = this;
            return __generator(this, function (_a) {
                commands.registerCommand(browser_1.CommonCommands.OPEN_PREFERENCES, {
                    isEnabled: function () { return true; },
                    execute: function (preferenceScope) {
                        if (preferenceScope === void 0) { preferenceScope = browser_1.PreferenceScope.User; }
                        return _this.openPreferences(preferenceScope);
                    }
                });
                return [2 /*return*/];
            });
        });
    };
    PreferencesContribution.prototype.registerMenus = function (menus) {
        menus.registerMenuAction(browser_1.CommonMenus.FILE_SETTINGS_SUBMENU_OPEN, {
            commandId: browser_1.CommonCommands.OPEN_PREFERENCES.id,
            order: 'a10'
        });
    };
    PreferencesContribution.prototype.registerKeybindings = function (keybindings) {
        keybindings.registerKeybinding({
            command: browser_1.CommonCommands.OPEN_PREFERENCES.id,
            keybinding: 'ctrl+,'
        });
    };
    PreferencesContribution.prototype.openPreferences = function (preferenceScope) {
        return __awaiter(this, void 0, void 0, function () {
            var wsUri, _a, widget;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0: return [4 /*yield*/, this.workspacePreferenceProvider.getUri()];
                    case 1:
                        wsUri = _b.sent();
                        _a = wsUri;
                        if (!_a) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.filesystem.exists(wsUri.toString())];
                    case 2:
                        _a = !(_b.sent());
                        _b.label = 3;
                    case 3:
                        if (!_a) return [3 /*break*/, 5];
                        return [4 /*yield*/, this.filesystem.createFile(wsUri.toString())];
                    case 4:
                        _b.sent();
                        _b.label = 5;
                    case 5: return [4 /*yield*/, this.widget];
                    case 6:
                        widget = _b.sent();
                        widget.preferenceScope = preferenceScope;
                        _super.prototype.openView.call(this, { activate: true });
                        widget.activatePreferenceEditor(preferenceScope);
                        return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(browser_2.UserStorageService),
        __metadata("design:type", Object)
    ], PreferencesContribution.prototype, "userStorageService", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceProvider), inversify_1.named(browser_1.PreferenceScope.Workspace),
        __metadata("design:type", workspace_preference_provider_1.WorkspacePreferenceProvider)
    ], PreferencesContribution.prototype, "workspacePreferenceProvider", void 0);
    __decorate([
        inversify_1.inject(common_1.FileSystem),
        __metadata("design:type", Object)
    ], PreferencesContribution.prototype, "filesystem", void 0);
    __decorate([
        inversify_1.inject(browser_3.EditorManager),
        __metadata("design:type", browser_3.EditorManager)
    ], PreferencesContribution.prototype, "editorManager", void 0);
    PreferencesContribution = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], PreferencesContribution);
    return PreferencesContribution;
}(browser_1.AbstractViewContribution));
exports.PreferencesContribution = PreferencesContribution;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-decorator-service.js":
/*!***************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-decorator-service.js ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Red Hat, Inc. and others.
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
var tree_decorator_1 = __webpack_require__(/*! @theia/core/lib/browser/tree/tree-decorator */ "../node_modules/@theia/core/lib/browser/tree/tree-decorator.js");
var preferences_decorator_1 = __webpack_require__(/*! ./preferences-decorator */ "../node_modules/@theia/preferences/lib/browser/preferences-decorator.js");
var PreferencesDecoratorService = /** @class */ (function (_super) {
    __extends(PreferencesDecoratorService, _super);
    function PreferencesDecoratorService(preferencesTreeDecorator) {
        var _this = _super.call(this, [preferencesTreeDecorator]) || this;
        _this.preferencesTreeDecorator = preferencesTreeDecorator;
        return _this;
    }
    PreferencesDecoratorService = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(preferences_decorator_1.PreferencesDecorator)),
        __metadata("design:paramtypes", [preferences_decorator_1.PreferencesDecorator])
    ], PreferencesDecoratorService);
    return PreferencesDecoratorService;
}(tree_decorator_1.AbstractTreeDecoratorService));
exports.PreferencesDecoratorService = PreferencesDecoratorService;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-decorator.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-decorator.js ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Red Hat, Inc. and others.
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var PreferencesDecorator = /** @class */ (function () {
    function PreferencesDecorator(preferencesService) {
        var _this = this;
        this.preferencesService = preferencesService;
        this.id = 'theia-preferences-decorator';
        this.emitter = new core_1.Emitter();
        this.preferencesDecorations = new Map();
        this.preferencesService.onPreferenceChanged(function () {
            _this.fireDidChangeDecorations(_this.preferences);
        });
    }
    Object.defineProperty(PreferencesDecorator.prototype, "onDidChangeDecorations", {
        get: function () {
            return this.emitter.event;
        },
        enumerable: true,
        configurable: true
    });
    PreferencesDecorator.prototype.fireDidChangeDecorations = function (preferences) {
        var _this = this;
        if (!this.preferences) {
            this.preferences = preferences;
        }
        this.preferencesDecorations = new Map(preferences.map(function (m) {
            var preferenceName = Object.keys(m)[0];
            var preferenceValue = m[preferenceName];
            var storedValue = _this.preferencesService.get(preferenceName);
            return [preferenceName, {
                    tooltip: preferenceValue.description,
                    captionSuffixes: [
                        {
                            data: storedValue !== undefined ? ': ' + storedValue : preferenceValue.default !== undefined ? ': ' + preferenceValue.default : undefined,
                        },
                        {
                            data: ' ' + preferenceValue.description,
                            fontData: { color: 'var(--theia-ui-font-color2)' }
                        }
                    ]
                }];
        }));
        this.emitter.fire(function () { return _this.preferencesDecorations; });
    };
    PreferencesDecorator.prototype.decorations = function (tree) {
        return this.preferencesDecorations;
    };
    PreferencesDecorator = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_1.PreferenceService)),
        __metadata("design:paramtypes", [Object])
    ], PreferencesDecorator);
    return PreferencesDecorator;
}());
exports.PreferencesDecorator = PreferencesDecorator;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-frontend-application-contribution.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-frontend-application-contribution.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var json_schema_store_1 = __webpack_require__(/*! @theia/core/lib/browser/json-schema-store */ "../node_modules/@theia/core/lib/browser/json-schema-store.js");
var user_preference_provider_1 = __webpack_require__(/*! ./user-preference-provider */ "../node_modules/@theia/preferences/lib/browser/user-preference-provider.js");
var PreferencesFrontendApplicationContribution = /** @class */ (function () {
    function PreferencesFrontendApplicationContribution() {
    }
    PreferencesFrontendApplicationContribution.prototype.onStart = function () {
        var _this = this;
        this.schemaProvider.ready.then(function () { return __awaiter(_this, void 0, void 0, function () {
            var schema, uri;
            return __generator(this, function (_a) {
                schema = this.schemaProvider.getCombinedSchema();
                uri = new uri_1.default('vscode://schemas/settings/user');
                this.inmemoryResources.add(uri, JSON.stringify(schema));
                this.jsonSchemaStore.registerSchema({
                    fileMatch: ['.theia/settings.json', user_preference_provider_1.USER_PREFERENCE_URI.toString()],
                    url: uri.toString()
                });
                return [2 /*return*/];
            });
        }); });
    };
    __decorate([
        inversify_1.inject(json_schema_store_1.JsonSchemaStore),
        __metadata("design:type", json_schema_store_1.JsonSchemaStore)
    ], PreferencesFrontendApplicationContribution.prototype, "jsonSchemaStore", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceSchemaProvider),
        __metadata("design:type", browser_1.PreferenceSchemaProvider)
    ], PreferencesFrontendApplicationContribution.prototype, "schemaProvider", void 0);
    __decorate([
        inversify_1.inject(core_1.InMemoryResources),
        __metadata("design:type", core_1.InMemoryResources)
    ], PreferencesFrontendApplicationContribution.prototype, "inmemoryResources", void 0);
    PreferencesFrontendApplicationContribution = __decorate([
        inversify_1.injectable()
    ], PreferencesFrontendApplicationContribution);
    return PreferencesFrontendApplicationContribution;
}());
exports.PreferencesFrontendApplicationContribution = PreferencesFrontendApplicationContribution;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-menu-factory.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-menu-factory.js ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Red Hat, Inc. and others.
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var widgets_1 = __webpack_require__(/*! @phosphor/widgets */ "../node_modules/@phosphor/widgets/lib/index.js");
var commands_1 = __webpack_require__(/*! @phosphor/commands */ "../node_modules/@phosphor/commands/lib/index.js");
var PreferencesMenuFactory = /** @class */ (function () {
    function PreferencesMenuFactory() {
    }
    // tslint:disable-next-line:no-any
    PreferencesMenuFactory.prototype.createPreferenceContextMenu = function (id, savedPreference, property, execute) {
        var commands = new commands_1.CommandRegistry();
        var menu = new widgets_1.Menu({ commands: commands });
        if (property) {
            var enumConst = property.enum;
            if (enumConst) {
                enumConst.forEach(function (enumValue) {
                    var commandId = id + '-' + enumValue;
                    if (!commands.hasCommand(commandId)) {
                        commands.addCommand(commandId, {
                            label: enumValue,
                            iconClass: savedPreference === enumValue || !savedPreference && property.default === enumValue ? 'fa fa-check' : '',
                            execute: function () { return execute(id, enumValue); }
                        });
                        menu.addItem({
                            type: 'command',
                            command: commandId
                        });
                    }
                });
            }
            else if (property.type && property.type === 'boolean') {
                var commandTrue = id + '-true';
                commands.addCommand(commandTrue, {
                    label: 'true',
                    iconClass: savedPreference === true || savedPreference === 'true' || savedPreference === undefined && property.default === true ? 'fa fa-check' : '',
                    execute: function () { return execute(id, true); }
                });
                menu.addItem({
                    type: 'command',
                    command: commandTrue
                });
                var commandFalse = id + '-false';
                commands.addCommand(commandFalse, {
                    label: 'false',
                    iconClass: savedPreference === false || savedPreference === 'false' || savedPreference === undefined && property.default === false ? 'fa fa-check' : '',
                    execute: function () { return execute(id, false); }
                });
                menu.addItem({
                    type: 'command',
                    command: commandFalse
                });
            }
            else {
                var commandId = id + '-stringValue';
                commands.addCommand(commandId, {
                    label: 'Add Value',
                    execute: function () { return execute(id, property.default ? property.default : ''); }
                });
                menu.addItem({
                    type: 'command',
                    command: commandId
                });
            }
        }
        return menu;
    };
    PreferencesMenuFactory = __decorate([
        inversify_1.injectable()
    ], PreferencesMenuFactory);
    return PreferencesMenuFactory;
}());
exports.PreferencesMenuFactory = PreferencesMenuFactory;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-monaco-contribution.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-monaco-contribution.js ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

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
monaco.languages.register({
    id: 'jsonc',
    'aliases': [
        'JSON with Comments'
    ],
    'filenames': [
        'settings.json'
    ]
});


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/preferences-tree-widget.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/preferences-tree-widget.js ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Red Hat, Inc. and others.
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
var preferences_menu_factory_1 = __webpack_require__(/*! ./preferences-menu-factory */ "../node_modules/@theia/preferences/lib/browser/preferences-menu-factory.js");
var preferences_decorator_1 = __webpack_require__(/*! ./preferences-decorator */ "../node_modules/@theia/preferences/lib/browser/preferences-decorator.js");
var algorithm_1 = __webpack_require__(/*! @phosphor/algorithm */ "../node_modules/@phosphor/algorithm/lib/index.js");
var widgets_1 = __webpack_require__(/*! @phosphor/widgets */ "../node_modules/@phosphor/widgets/lib/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var user_preference_provider_1 = __webpack_require__(/*! ./user-preference-provider */ "../node_modules/@theia/preferences/lib/browser/user-preference-provider.js");
var workspace_preference_provider_1 = __webpack_require__(/*! ./workspace-preference-provider */ "../node_modules/@theia/preferences/lib/browser/workspace-preference-provider.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var promise_util_1 = __webpack_require__(/*! @theia/core/lib/common/promise-util */ "../node_modules/@theia/core/lib/common/promise-util.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var common_1 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var browser_3 = __webpack_require__(/*! @theia/userstorage/lib/browser */ "../node_modules/@theia/userstorage/lib/browser/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var PreferencesContainer = /** @class */ (function (_super) {
    __extends(PreferencesContainer, _super);
    function PreferencesContainer() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.editors = [];
        _this.deferredEditors = new promise_util_1.Deferred();
        _this.onDirtyChangedEmitter = new core_1.Emitter();
        _this.onDirtyChanged = _this.onDirtyChangedEmitter.event;
        _this.toDispose = new core_1.DisposableCollection();
        _this._preferenceScope = browser_1.PreferenceScope.User;
        return _this;
    }
    PreferencesContainer_1 = PreferencesContainer;
    PreferencesContainer.prototype.init = function () {
        this.id = PreferencesContainer_1.ID;
        this.title.label = 'Preferences';
        this.title.caption = this.title.label;
        this.title.closable = true;
        this.title.iconClass = 'fa fa-sliders';
        this.toDispose.push(this.onDirtyChangedEmitter);
    };
    PreferencesContainer.prototype.dispose = function () {
        if (this.isDisposed) {
            return;
        }
        _super.prototype.dispose.call(this);
        this.toDispose.dispose();
    };
    Object.defineProperty(PreferencesContainer.prototype, "autoSave", {
        get: function () {
            return this.editors.some(function (editor) { return editor.saveable.autoSave === 'on'; }) ? 'on' : 'off';
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PreferencesContainer.prototype, "dirty", {
        get: function () {
            return this.editors.some(function (editor) { return editor.saveable.dirty; });
        },
        enumerable: true,
        configurable: true
    });
    PreferencesContainer.prototype.save = function () {
        this.editors.forEach(function (editor) { return editor.saveable.save(); });
    };
    PreferencesContainer.prototype.getTrackableWidgets = function () {
        return this.deferredEditors.promise;
    };
    Object.defineProperty(PreferencesContainer.prototype, "preferenceScope", {
        get: function () {
            return this._preferenceScope;
        },
        set: function (preferenceScope) {
            this._preferenceScope = preferenceScope;
        },
        enumerable: true,
        configurable: true
    });
    PreferencesContainer.prototype.onAfterAttach = function (msg) {
        return __awaiter(this, void 0, void 0, function () {
            var _a, _b, treePanel;
            var _this = this;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0:
                        if (this.widgets.length > 0) {
                            return [2 /*return*/];
                        }
                        _a = this;
                        return [4 /*yield*/, this.widgetManager.getOrCreateWidget(PreferencesTreeWidget.ID)];
                    case 1:
                        _a.treeWidget = _c.sent();
                        this.treeWidget.onPreferenceSelected(function (value) {
                            var preferenceName = Object.keys(value)[0];
                            var preferenceValue = value[preferenceName];
                            if (_this.dirty) {
                                _this.messageService.warn('Preferences editor(s) has/have unsaved changes');
                            }
                            else if (_this.currentEditor) {
                                _this.preferenceService.set(preferenceName, preferenceValue, _this.currentEditor.title.label === 'User Preferences'
                                    ? browser_1.PreferenceScope.User
                                    : browser_1.PreferenceScope.Workspace);
                            }
                        });
                        _b = this;
                        return [4 /*yield*/, this.widgetManager.getOrCreateWidget(PreferencesEditorsContainer.ID)];
                    case 2:
                        _b.editorsContainer = _c.sent();
                        this.toDispose.push(this.editorsContainer);
                        this.editorsContainer.activatePreferenceEditor(this.preferenceScope);
                        this.editorsContainer.onInit(function () {
                            algorithm_1.toArray(_this.editorsContainer.widgets()).forEach(function (editor) {
                                var editorWidget = editor;
                                _this.editors.push(editorWidget);
                                var savable = editorWidget.saveable;
                                savable.onDirtyChanged(function () {
                                    _this.onDirtyChangedEmitter.fire(undefined);
                                });
                            });
                            _this.deferredEditors.resolve(_this.editors);
                        });
                        this.editorsContainer.onEditorChanged(function (editor) {
                            if (_this.currentEditor) {
                                _this.currentEditor.saveable.save();
                            }
                            _this.currentEditor = editor;
                        });
                        treePanel = new widgets_1.BoxPanel();
                        treePanel.addWidget(this.treeWidget);
                        this.addWidget(treePanel);
                        this.addWidget(this.editorsContainer);
                        this.treeWidget.activate();
                        _super.prototype.onAfterAttach.call(this, msg);
                        return [2 /*return*/];
                }
            });
        });
    };
    PreferencesContainer.prototype.onActivateRequest = function (msg) {
        if (this.currentEditor) {
            this.currentEditor.activate();
        }
        _super.prototype.onActivateRequest.call(this, msg);
    };
    PreferencesContainer.prototype.onCloseRequest = function (msg) {
        if (this.treeWidget) {
            this.treeWidget.close();
        }
        this.editorsContainer.close();
        _super.prototype.onCloseRequest.call(this, msg);
        this.dispose();
    };
    PreferencesContainer.prototype.activatePreferenceEditor = function (preferenceScope) {
        if (this.editorsContainer) {
            this.editorsContainer.activatePreferenceEditor(preferenceScope);
        }
    };
    var PreferencesContainer_1;
    PreferencesContainer.ID = 'preferences_container_widget';
    __decorate([
        inversify_1.inject(browser_1.WidgetManager),
        __metadata("design:type", browser_1.WidgetManager)
    ], PreferencesContainer.prototype, "widgetManager", void 0);
    __decorate([
        inversify_1.inject(browser_1.ApplicationShell),
        __metadata("design:type", browser_1.ApplicationShell)
    ], PreferencesContainer.prototype, "shell", void 0);
    __decorate([
        inversify_1.inject(core_1.MessageService),
        __metadata("design:type", core_1.MessageService)
    ], PreferencesContainer.prototype, "messageService", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceService),
        __metadata("design:type", Object)
    ], PreferencesContainer.prototype, "preferenceService", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], PreferencesContainer.prototype, "init", null);
    PreferencesContainer = PreferencesContainer_1 = __decorate([
        inversify_1.injectable()
    ], PreferencesContainer);
    return PreferencesContainer;
}(widgets_1.SplitPanel));
exports.PreferencesContainer = PreferencesContainer;
var PreferencesEditorsContainer = /** @class */ (function (_super) {
    __extends(PreferencesEditorsContainer, _super);
    function PreferencesEditorsContainer() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.onInitEmitter = new core_1.Emitter();
        _this.onInit = _this.onInitEmitter.event;
        _this.onEditorChangedEmitter = new core_1.Emitter();
        _this.onEditorChanged = _this.onEditorChangedEmitter.event;
        _this.toDispose = new core_1.DisposableCollection(_this.onEditorChangedEmitter, _this.onInitEmitter);
        return _this;
    }
    PreferencesEditorsContainer.prototype.dispose = function () {
        this.toDispose.dispose();
        _super.prototype.dispose.call(this);
    };
    PreferencesEditorsContainer.prototype.onCloseRequest = function (msg) {
        algorithm_1.toArray(this.widgets()).forEach(function (widget) { return widget.close(); });
        _super.prototype.onCloseRequest.call(this, msg);
    };
    PreferencesEditorsContainer.prototype.onUpdateRequest = function (msg) {
        this.onEditorChangedEmitter.fire(this.selectedWidgets().next());
        _super.prototype.onUpdateRequest.call(this, msg);
    };
    PreferencesEditorsContainer.prototype.onAfterAttach = function (msg) {
        return __awaiter(this, void 0, void 0, function () {
            var userPreferenceUri, userPreferences, _a, workspacePreferenceUri, workspacePreferences, _b, _c;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        userPreferenceUri = this.userPreferenceProvider.getUri();
                        return [4 /*yield*/, this.editorManager.getOrCreateByUri(userPreferenceUri)];
                    case 1:
                        userPreferences = _d.sent();
                        userPreferences.title.label = 'User Preferences';
                        _a = userPreferences.title;
                        return [4 /*yield*/, this.getPreferenceEditorCaption(userPreferenceUri)];
                    case 2:
                        _a.caption = _d.sent();
                        userPreferences.scope = browser_1.PreferenceScope.User;
                        this.addWidget(userPreferences);
                        return [4 /*yield*/, this.workspacePreferenceProvider.getUri()];
                    case 3:
                        workspacePreferenceUri = _d.sent();
                        _b = workspacePreferenceUri;
                        if (!_b) return [3 /*break*/, 5];
                        return [4 /*yield*/, this.editorManager.getOrCreateByUri(workspacePreferenceUri)];
                    case 4:
                        _b = (_d.sent());
                        _d.label = 5;
                    case 5:
                        workspacePreferences = _b;
                        if (!workspacePreferences) return [3 /*break*/, 7];
                        workspacePreferences.title.label = 'Workspace Preferences';
                        _c = workspacePreferences.title;
                        return [4 /*yield*/, this.getPreferenceEditorCaption(workspacePreferenceUri)];
                    case 6:
                        _c.caption = _d.sent();
                        workspacePreferences.scope = browser_1.PreferenceScope.Workspace;
                        this.addWidget(workspacePreferences);
                        _d.label = 7;
                    case 7:
                        this.activatePreferenceEditor(this.preferenceScope);
                        _super.prototype.onAfterAttach.call(this, msg);
                        this.onInitEmitter.fire(undefined);
                        return [2 /*return*/];
                }
            });
        });
    };
    PreferencesEditorsContainer.prototype.activatePreferenceEditor = function (preferenceScope) {
        var e_1, _a;
        this.preferenceScope = preferenceScope;
        try {
            for (var _b = __values(algorithm_1.toArray(this.widgets())), _c = _b.next(); !_c.done; _c = _b.next()) {
                var widget = _c.value;
                var preferenceEditor = widget;
                if (preferenceEditor.scope === preferenceScope) {
                    this.activateWidget(widget);
                    break;
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
    };
    PreferencesEditorsContainer.prototype.getPreferenceEditorCaption = function (preferenceUri) {
        return __awaiter(this, void 0, void 0, function () {
            var homeStat, homeUri, uri;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.fileSystem.getCurrentUserHome()];
                    case 1:
                        homeStat = _a.sent();
                        homeUri = homeStat ? new uri_1.default(homeStat.uri) : undefined;
                        uri = preferenceUri;
                        if (preferenceUri.scheme === browser_3.UserStorageUri.SCHEME && homeUri) {
                            uri = homeUri.resolve(browser_3.THEIA_USER_STORAGE_FOLDER).resolve(preferenceUri.withoutScheme().path);
                        }
                        return [2 /*return*/, homeUri
                                ? common_1.FileSystemUtils.tildifyPath(uri.path.toString(), homeUri.withoutScheme().toString())
                                : uri.path.toString()];
                }
            });
        });
    };
    PreferencesEditorsContainer.ID = 'preferences_editors_container';
    __decorate([
        inversify_1.inject(common_1.FileSystem),
        __metadata("design:type", Object)
    ], PreferencesEditorsContainer.prototype, "fileSystem", void 0);
    __decorate([
        inversify_1.inject(browser_2.EditorManager),
        __metadata("design:type", browser_2.EditorManager)
    ], PreferencesEditorsContainer.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceProvider), inversify_1.named(browser_1.PreferenceScope.User),
        __metadata("design:type", user_preference_provider_1.UserPreferenceProvider)
    ], PreferencesEditorsContainer.prototype, "userPreferenceProvider", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceProvider), inversify_1.named(browser_1.PreferenceScope.Workspace),
        __metadata("design:type", workspace_preference_provider_1.WorkspacePreferenceProvider)
    ], PreferencesEditorsContainer.prototype, "workspacePreferenceProvider", void 0);
    PreferencesEditorsContainer = __decorate([
        inversify_1.injectable()
    ], PreferencesEditorsContainer);
    return PreferencesEditorsContainer;
}(widgets_1.DockPanel));
exports.PreferencesEditorsContainer = PreferencesEditorsContainer;
var PreferencesTreeWidget = /** @class */ (function (_super) {
    __extends(PreferencesTreeWidget, _super);
    function PreferencesTreeWidget(model, treeProps, contextMenuRenderer, preferenceSchemaProvider) {
        var _this = _super.call(this, treeProps, model, contextMenuRenderer) || this;
        _this.model = model;
        _this.treeProps = treeProps;
        _this.contextMenuRenderer = contextMenuRenderer;
        _this.preferenceSchemaProvider = preferenceSchemaProvider;
        _this.preferencesGroupNames = [];
        _this.onPreferenceSelectedEmitter = new core_1.Emitter();
        _this.onPreferenceSelected = _this.onPreferenceSelectedEmitter.event;
        _this.toDispose = new core_1.DisposableCollection();
        _this.toDispose.push(_this.onPreferenceSelectedEmitter);
        _this.id = PreferencesTreeWidget_1.ID;
        _this.properties = _this.preferenceSchemaProvider.getCombinedSchema().properties;
        for (var property in _this.properties) {
            if (property) {
                var group = property.substring(0, property.indexOf('.'));
                if (_this.preferencesGroupNames.indexOf(group) < 0) {
                    _this.preferencesGroupNames.push(group);
                }
            }
        }
        return _this;
    }
    PreferencesTreeWidget_1 = PreferencesTreeWidget;
    PreferencesTreeWidget.prototype.dispose = function () {
        this.toDispose.dispose();
        _super.prototype.dispose.call(this);
    };
    PreferencesTreeWidget.prototype.onAfterAttach = function (msg) {
        this.initializeModel();
        _super.prototype.onAfterAttach.call(this, msg);
    };
    PreferencesTreeWidget.prototype.handleContextMenuEvent = function (node, event) {
        _super.prototype.handleContextMenuEvent.call(this, node, event);
        if (node.expanded === undefined) {
            this.openContextMenu(node, event.nativeEvent.x, event.nativeEvent.y);
        }
    };
    PreferencesTreeWidget.prototype.handleClickEvent = function (node, event) {
        _super.prototype.handleClickEvent.call(this, node, event);
        if (node.expanded === undefined) {
            this.openContextMenu(node, event.nativeEvent.x, event.nativeEvent.y);
        }
    };
    PreferencesTreeWidget.prototype.handleEnter = function (event) {
        _super.prototype.handleEnter.call(this, event);
        var node = this.model.selectedNodes[0];
        if (node.expanded === undefined) {
            if (node) {
                var nodeElement = document.getElementById(node.id);
                if (nodeElement) {
                    var position = nodeElement.getBoundingClientRect();
                    this.openContextMenu(this.model.selectedNodes[0], position.left, position.bottom);
                }
            }
        }
    };
    PreferencesTreeWidget.prototype.openContextMenu = function (node, positionX, positionY) {
        var _this = this;
        if (node && browser_1.SelectableTreeNode.is(node)) {
            var contextMenu = this.preferencesMenuFactory.createPreferenceContextMenu(node.id, this.preferenceService.get(node.id), this.properties[node.id], function (property, value) {
                var _a;
                _this.onPreferenceSelectedEmitter.fire((_a = {}, _a[property] = value, _a));
            });
            contextMenu.aboutToClose.connect(function () {
                _this.activate();
            });
            contextMenu.activeItem = contextMenu.items[0];
            contextMenu.open(positionX, positionY);
        }
    };
    PreferencesTreeWidget.prototype.initializeModel = function () {
        var _this = this;
        var e_2, _a;
        var preferencesGroups = [];
        var root = {
            id: 'root-node-id',
            name: 'Apply the preference to selected preferences file',
            parent: undefined,
            visible: true,
            children: preferencesGroups,
            expanded: true,
        };
        var nodes = [];
        var _loop_1 = function (group) {
            var propertyNodes = [];
            var properties = [];
            for (var property in this_1.properties) {
                if (property.startsWith(group)) {
                    properties.push(property);
                }
            }
            var preferencesGroup = {
                id: group + '-id',
                name: group.toLocaleUpperCase().substring(0, 1) + group.substring(1) + ' (' + properties.length + ')',
                visible: true,
                parent: root,
                children: propertyNodes,
                expanded: false,
                selected: false
            };
            properties.sort(function (a, b) { return a.localeCompare(b); });
            properties.forEach(function (property) {
                var _a;
                var node = {
                    id: property,
                    name: property.substring(property.indexOf('.') + 1),
                    parent: preferencesGroup,
                    visible: true,
                    selected: false
                };
                propertyNodes.push(node);
                nodes.push((_a = {}, _a[property] = _this.properties[property], _a));
            });
            preferencesGroups.push(preferencesGroup);
        };
        var this_1 = this;
        try {
            for (var _b = __values(this.preferencesGroupNames.sort(function (a, b) { return a.localeCompare(b); })), _c = _b.next(); !_c.done; _c = _b.next()) {
                var group = _c.value;
                _loop_1(group);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
        this.decorator.fireDidChangeDecorations(nodes);
        this.model.root = root;
    };
    var PreferencesTreeWidget_1;
    PreferencesTreeWidget.ID = 'preferences_tree_widget';
    __decorate([
        inversify_1.inject(preferences_menu_factory_1.PreferencesMenuFactory),
        __metadata("design:type", preferences_menu_factory_1.PreferencesMenuFactory)
    ], PreferencesTreeWidget.prototype, "preferencesMenuFactory", void 0);
    __decorate([
        inversify_1.inject(browser_1.PreferenceService),
        __metadata("design:type", Object)
    ], PreferencesTreeWidget.prototype, "preferenceService", void 0);
    __decorate([
        inversify_1.inject(preferences_decorator_1.PreferencesDecorator),
        __metadata("design:type", preferences_decorator_1.PreferencesDecorator)
    ], PreferencesTreeWidget.prototype, "decorator", void 0);
    PreferencesTreeWidget = PreferencesTreeWidget_1 = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_1.TreeModel)),
        __param(1, inversify_1.inject(browser_1.TreeProps)),
        __param(2, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __param(3, inversify_1.inject(browser_1.PreferenceSchemaProvider)),
        __metadata("design:paramtypes", [Object, Object, Object, browser_1.PreferenceSchemaProvider])
    ], PreferencesTreeWidget);
    return PreferencesTreeWidget;
}(browser_1.TreeWidget));
exports.PreferencesTreeWidget = PreferencesTreeWidget;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/user-preference-provider.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/user-preference-provider.js ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson and others.
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var abstract_resource_preference_provider_1 = __webpack_require__(/*! ./abstract-resource-preference-provider */ "../node_modules/@theia/preferences/lib/browser/abstract-resource-preference-provider.js");
var browser_1 = __webpack_require__(/*! @theia/userstorage/lib/browser */ "../node_modules/@theia/userstorage/lib/browser/index.js");
exports.USER_PREFERENCE_URI = new uri_1.default().withScheme(browser_1.UserStorageUri.SCHEME).withPath('settings.json');
var UserPreferenceProvider = /** @class */ (function (_super) {
    __extends(UserPreferenceProvider, _super);
    function UserPreferenceProvider() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    UserPreferenceProvider.prototype.getUri = function () {
        return exports.USER_PREFERENCE_URI;
    };
    UserPreferenceProvider = __decorate([
        inversify_1.injectable()
    ], UserPreferenceProvider);
    return UserPreferenceProvider;
}(abstract_resource_preference_provider_1.AbstractResourcePreferenceProvider));
exports.UserPreferenceProvider = UserPreferenceProvider;


/***/ }),

/***/ "../node_modules/@theia/preferences/lib/browser/workspace-preference-provider.js":
/*!***************************************************************************************!*\
  !*** ../node_modules/@theia/preferences/lib/browser/workspace-preference-provider.js ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson and others.
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var workspace_service_1 = __webpack_require__(/*! @theia/workspace/lib/browser/workspace-service */ "../node_modules/@theia/workspace/lib/browser/workspace-service.js");
var abstract_resource_preference_provider_1 = __webpack_require__(/*! ./abstract-resource-preference-provider */ "../node_modules/@theia/preferences/lib/browser/abstract-resource-preference-provider.js");
var WorkspacePreferenceProvider = /** @class */ (function (_super) {
    __extends(WorkspacePreferenceProvider, _super);
    function WorkspacePreferenceProvider() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    WorkspacePreferenceProvider.prototype.getUri = function () {
        return __awaiter(this, void 0, void 0, function () {
            var workspaceFolder, rootUri;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.workspaceService.roots];
                    case 1:
                        workspaceFolder = (_a.sent())[0];
                        if (workspaceFolder) {
                            rootUri = new uri_1.default(workspaceFolder.uri);
                            return [2 /*return*/, rootUri.resolve('.theia').resolve('settings.json')];
                        }
                        return [2 /*return*/, undefined];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(workspace_service_1.WorkspaceService),
        __metadata("design:type", workspace_service_1.WorkspaceService)
    ], WorkspacePreferenceProvider.prototype, "workspaceService", void 0);
    WorkspacePreferenceProvider = __decorate([
        inversify_1.injectable()
    ], WorkspacePreferenceProvider);
    return WorkspacePreferenceProvider;
}(abstract_resource_preference_provider_1.AbstractResourcePreferenceProvider));
exports.WorkspacePreferenceProvider = WorkspacePreferenceProvider;


/***/ }),

/***/ "../node_modules/@theia/userstorage/lib/browser/index.js":
/*!***************************************************************!*\
  !*** ../node_modules/@theia/userstorage/lib/browser/index.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017 Ericsson and others.
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
__export(__webpack_require__(/*! ./user-storage-service */ "../node_modules/@theia/userstorage/lib/browser/user-storage-service.js"));
__export(__webpack_require__(/*! ./user-storage-resource */ "../node_modules/@theia/userstorage/lib/browser/user-storage-resource.js"));
__export(__webpack_require__(/*! ./user-storage-uri */ "../node_modules/@theia/userstorage/lib/browser/user-storage-uri.js"));
__export(__webpack_require__(/*! ./user-storage-service-filesystem */ "../node_modules/@theia/userstorage/lib/browser/user-storage-service-filesystem.js"));
__export(__webpack_require__(/*! ./user-storage-frontend-module */ "../node_modules/@theia/userstorage/lib/browser/user-storage-frontend-module.js"));


/***/ })

}]);
//# sourceMappingURL=29.bundle.js.map