(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[31],{

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/in-memory-text-resource.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/in-memory-text-resource.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
exports.MEMORY_TEXT = 'mem-txt';
var InMemoryTextResource = /** @class */ (function () {
    function InMemoryTextResource(uri) {
        this.uri = uri;
    }
    InMemoryTextResource.prototype.readContents = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                return [2 /*return*/, this.uri.query];
            });
        });
    };
    InMemoryTextResource.prototype.dispose = function () { };
    return InMemoryTextResource;
}());
exports.InMemoryTextResource = InMemoryTextResource;
var InMemoryTextResourceResolver = /** @class */ (function () {
    function InMemoryTextResourceResolver() {
    }
    InMemoryTextResourceResolver.prototype.resolve = function (uri) {
        if (uri.scheme !== exports.MEMORY_TEXT) {
            throw new Error("Expected a URI with " + exports.MEMORY_TEXT + " scheme. Was: " + uri + ".");
        }
        return new InMemoryTextResource(uri);
    };
    InMemoryTextResourceResolver = __decorate([
        inversify_1.injectable()
    ], InMemoryTextResourceResolver);
    return InMemoryTextResourceResolver;
}());
exports.InMemoryTextResourceResolver = InMemoryTextResourceResolver;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-frontend-contribution.js":
/*!***********************************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-frontend-contribution.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var search_in_workspace_widget_1 = __webpack_require__(/*! ./search-in-workspace-widget */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-widget.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var navigator_contribution_1 = __webpack_require__(/*! @theia/navigator/lib/browser/navigator-contribution */ "../node_modules/@theia/navigator/lib/browser/navigator-contribution.js");
var uri_command_handler_1 = __webpack_require__(/*! @theia/core/lib/common/uri-command-handler */ "../node_modules/@theia/core/lib/common/uri-command-handler.js");
var browser_2 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
var SearchInWorkspaceCommands;
(function (SearchInWorkspaceCommands) {
    var SEARCH_CATEGORY = 'Search';
    SearchInWorkspaceCommands.TOGGLE_SIW_WIDGET = {
        id: 'search-in-workspace.toggle'
    };
    SearchInWorkspaceCommands.OPEN_SIW_WIDGET = {
        id: 'search-in-workspace.open',
        category: SEARCH_CATEGORY,
        label: 'Find in Files'
    };
    SearchInWorkspaceCommands.FIND_IN_FOLDER = {
        id: 'search-in-workspace.in-folder',
        category: SEARCH_CATEGORY,
        label: 'Find in Folder...'
    };
})(SearchInWorkspaceCommands = exports.SearchInWorkspaceCommands || (exports.SearchInWorkspaceCommands = {}));
var SearchInWorkspaceFrontendContribution = /** @class */ (function (_super) {
    __extends(SearchInWorkspaceFrontendContribution, _super);
    function SearchInWorkspaceFrontendContribution() {
        return _super.call(this, {
            widgetId: search_in_workspace_widget_1.SearchInWorkspaceWidget.ID,
            widgetName: search_in_workspace_widget_1.SearchInWorkspaceWidget.LABEL,
            defaultWidgetOptions: {
                area: 'left'
            },
            toggleCommandId: SearchInWorkspaceCommands.TOGGLE_SIW_WIDGET.id
        }) || this;
    }
    SearchInWorkspaceFrontendContribution.prototype.initializeLayout = function (app) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.openView({ activate: false })];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    SearchInWorkspaceFrontendContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        _super.prototype.registerCommands.call(this, commands);
        commands.registerCommand(SearchInWorkspaceCommands.OPEN_SIW_WIDGET, {
            isEnabled: function () { return _this.workspaceService.tryGetRoots().length > 0; },
            execute: function () { return _this.openView({
                activate: true
            }); }
        });
        commands.registerCommand(SearchInWorkspaceCommands.FIND_IN_FOLDER, this.newUriAwareCommandHandler({
            execute: function (fileUri) { return __awaiter(_this, void 0, void 0, function () {
                var widget, uriStr;
                return __generator(this, function (_a) {
                    switch (_a.label) {
                        case 0: return [4 /*yield*/, this.openView({
                                activate: true
                            })];
                        case 1:
                            widget = _a.sent();
                            uriStr = this.labelProvider.getLongName(fileUri);
                            widget.findInFolder(uriStr);
                            return [2 /*return*/];
                    }
                });
            }); }
        }));
    };
    SearchInWorkspaceFrontendContribution.prototype.registerKeybindings = function (keybindings) {
        _super.prototype.registerKeybindings.call(this, keybindings);
        keybindings.registerKeybinding({
            command: SearchInWorkspaceCommands.OPEN_SIW_WIDGET.id,
            keybinding: 'ctrlcmd+shift+f'
        });
    };
    SearchInWorkspaceFrontendContribution.prototype.registerMenus = function (menus) {
        _super.prototype.registerMenus.call(this, menus);
        menus.registerMenuAction(__spread(navigator_contribution_1.NAVIGATOR_CONTEXT_MENU, ['6_find']), {
            commandId: SearchInWorkspaceCommands.FIND_IN_FOLDER.id
        });
        menus.registerMenuAction(browser_1.CommonMenus.EDIT_FIND, {
            commandId: SearchInWorkspaceCommands.OPEN_SIW_WIDGET.id
        });
    };
    SearchInWorkspaceFrontendContribution.prototype.newUriAwareCommandHandler = function (handler) {
        return new uri_command_handler_1.UriAwareCommandHandler(this.selectionService, handler);
    };
    __decorate([
        inversify_1.inject(core_1.SelectionService),
        __metadata("design:type", core_1.SelectionService)
    ], SearchInWorkspaceFrontendContribution.prototype, "selectionService", void 0);
    __decorate([
        inversify_1.inject(browser_1.LabelProvider),
        __metadata("design:type", browser_1.LabelProvider)
    ], SearchInWorkspaceFrontendContribution.prototype, "labelProvider", void 0);
    __decorate([
        inversify_1.inject(browser_2.WorkspaceService),
        __metadata("design:type", browser_2.WorkspaceService)
    ], SearchInWorkspaceFrontendContribution.prototype, "workspaceService", void 0);
    SearchInWorkspaceFrontendContribution = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], SearchInWorkspaceFrontendContribution);
    return SearchInWorkspaceFrontendContribution;
}(browser_1.AbstractViewContribution));
exports.SearchInWorkspaceFrontendContribution = SearchInWorkspaceFrontendContribution;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-frontend-module.js":
/*!*****************************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-frontend-module.js ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017-2018 Ericsson and others.
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
var search_in_workspace_service_1 = __webpack_require__(/*! ./search-in-workspace-service */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-service.js");
var search_in_workspace_interface_1 = __webpack_require__(/*! ../common/search-in-workspace-interface */ "../node_modules/@theia/search-in-workspace/lib/common/search-in-workspace-interface.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var search_in_workspace_widget_1 = __webpack_require__(/*! ./search-in-workspace-widget */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-widget.js");
var search_in_workspace_result_tree_widget_1 = __webpack_require__(/*! ./search-in-workspace-result-tree-widget */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-result-tree-widget.js");
var search_in_workspace_frontend_contribution_1 = __webpack_require__(/*! ./search-in-workspace-frontend-contribution */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-frontend-contribution.js");
var in_memory_text_resource_1 = __webpack_require__(/*! ./in-memory-text-resource */ "../node_modules/@theia/search-in-workspace/lib/browser/in-memory-text-resource.js");
__webpack_require__(/*! ../../src/browser/styles/index.css */ "../node_modules/@theia/search-in-workspace/src/browser/styles/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(search_in_workspace_widget_1.SearchInWorkspaceWidget).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (ctx) { return ({
        id: search_in_workspace_widget_1.SearchInWorkspaceWidget.ID,
        createWidget: function () { return ctx.container.get(search_in_workspace_widget_1.SearchInWorkspaceWidget); }
    }); });
    bind(search_in_workspace_result_tree_widget_1.SearchInWorkspaceResultTreeWidget).toDynamicValue(function (ctx) { return createSearchTreeWidget(ctx.container); });
    browser_1.bindViewContribution(bind, search_in_workspace_frontend_contribution_1.SearchInWorkspaceFrontendContribution);
    bind(browser_1.FrontendApplicationContribution).toService(search_in_workspace_frontend_contribution_1.SearchInWorkspaceFrontendContribution);
    // The object that gets notified of search results.
    bind(search_in_workspace_service_1.SearchInWorkspaceClientImpl).toSelf().inSingletonScope();
    bind(search_in_workspace_service_1.SearchInWorkspaceService).toSelf().inSingletonScope();
    // The object to call methods on the backend.
    bind(search_in_workspace_interface_1.SearchInWorkspaceServer).toDynamicValue(function (ctx) {
        var client = ctx.container.get(search_in_workspace_service_1.SearchInWorkspaceClientImpl);
        return browser_1.WebSocketConnectionProvider.createProxy(ctx.container, '/search-in-workspace', client);
    }).inSingletonScope();
    bind(in_memory_text_resource_1.InMemoryTextResourceResolver).toSelf().inSingletonScope();
    bind(core_1.ResourceResolver).toService(in_memory_text_resource_1.InMemoryTextResourceResolver);
});
function createSearchTreeWidget(parent) {
    var child = browser_1.createTreeContainer(parent);
    child.unbind(browser_1.TreeWidget);
    child.bind(search_in_workspace_result_tree_widget_1.SearchInWorkspaceResultTreeWidget).toSelf();
    return child.get(search_in_workspace_result_tree_widget_1.SearchInWorkspaceResultTreeWidget);
}
exports.createSearchTreeWidget = createSearchTreeWidget;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-result-tree-widget.js":
/*!********************************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-result-tree-widget.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var search_in_workspace_service_1 = __webpack_require__(/*! ./search-in-workspace-service */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-service.js");
var browser_2 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_3 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_4 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
var in_memory_text_resource_1 = __webpack_require__(/*! ./in-memory-text-resource */ "../node_modules/@theia/search-in-workspace/lib/browser/in-memory-text-resource.js");
var browser_5 = __webpack_require__(/*! @theia/filesystem/lib/browser */ "../node_modules/@theia/filesystem/lib/browser/index.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var SearchInWorkspaceResultNode;
(function (SearchInWorkspaceResultNode) {
    // tslint:disable-next-line:no-any
    function is(node) {
        return browser_1.ExpandableTreeNode.is(node) && browser_1.SelectableTreeNode.is(node) && 'path' in node;
    }
    SearchInWorkspaceResultNode.is = is;
})(SearchInWorkspaceResultNode = exports.SearchInWorkspaceResultNode || (exports.SearchInWorkspaceResultNode = {}));
var SearchInWorkspaceResultLineNode;
(function (SearchInWorkspaceResultLineNode) {
    // tslint:disable-next-line:no-any
    function is(node) {
        return browser_1.SelectableTreeNode.is(node) && 'line' in node && 'character' in node && 'lineText' in node;
    }
    SearchInWorkspaceResultLineNode.is = is;
})(SearchInWorkspaceResultLineNode = exports.SearchInWorkspaceResultLineNode || (exports.SearchInWorkspaceResultLineNode = {}));
var SearchInWorkspaceResultTreeWidget = /** @class */ (function (_super) {
    __extends(SearchInWorkspaceResultTreeWidget, _super);
    function SearchInWorkspaceResultTreeWidget(props, model, contextMenuRenderer) {
        var _this = _super.call(this, props, model, contextMenuRenderer) || this;
        _this.props = props;
        _this.model = model;
        _this.contextMenuRenderer = contextMenuRenderer;
        _this.workspaceRoot = '';
        _this._showReplaceButtons = false;
        _this._replaceTerm = '';
        _this.searchTerm = '';
        _this.appliedDecorations = new Map();
        _this.cancelIndicator = new core_1.CancellationTokenSource();
        _this.changeEmitter = new core_1.Emitter();
        // tslint:disable-next-line:no-any
        _this.focusInputEmitter = new core_1.Emitter();
        _this.replace = function (node, e) { return _this.doReplace(node, e); };
        _this.remove = function (node, e) { return _this.doRemove(node, e); };
        model.root = {
            id: 'ResultTree',
            name: 'ResultTree',
            parent: undefined,
            visible: false,
            children: []
        };
        _this.toDispose.push(model.onSelectionChanged(function (nodes) {
            var node = nodes[0];
            if (SearchInWorkspaceResultLineNode.is(node)) {
                _this.doOpen(node, true);
            }
        }));
        _this.resultTree = new Map();
        _this.toDispose.push(model.onNodeRefreshed(function () { return _this.changeEmitter.fire(_this.resultTree); }));
        return _this;
    }
    SearchInWorkspaceResultTreeWidget.prototype.init = function () {
        var _this = this;
        _super.prototype.init.call(this);
        this.addClass('resultContainer');
        this.workspaceService.roots.then(function (roots) {
            var rootFileStat = roots[0];
            if (rootFileStat) {
                var uri = new uri_1.default(rootFileStat.uri);
                _this.workspaceRoot = uri.withoutScheme().toString();
            }
        });
        this.toDispose.push(this.changeEmitter);
        this.toDispose.push(this.focusInputEmitter);
        this.toDispose.push(this.editorManager.onActiveEditorChanged(function () {
            _this.updateCurrentEditorDecorations();
        }));
    };
    Object.defineProperty(SearchInWorkspaceResultTreeWidget.prototype, "showReplaceButtons", {
        set: function (srb) {
            this._showReplaceButtons = srb;
            this.update();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SearchInWorkspaceResultTreeWidget.prototype, "replaceTerm", {
        set: function (rt) {
            this._replaceTerm = rt;
            this.update();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SearchInWorkspaceResultTreeWidget.prototype, "onChange", {
        get: function () {
            return this.changeEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SearchInWorkspaceResultTreeWidget.prototype, "onFocusInput", {
        get: function () {
            return this.focusInputEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    SearchInWorkspaceResultTreeWidget.prototype.collapseAll = function () {
        var _this = this;
        this.resultTree.forEach(function (v) { return _this.expansionService.collapseNode(v); });
    };
    SearchInWorkspaceResultTreeWidget.prototype.search = function (searchTerm, searchOptions) {
        return __awaiter(this, void 0, void 0, function () {
            var token, searchId;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.searchTerm = searchTerm;
                        this.resultTree.clear();
                        this.resultTree = new Map();
                        this.cancelIndicator.cancel();
                        this.cancelIndicator = new core_1.CancellationTokenSource();
                        token = this.cancelIndicator.token;
                        if (searchTerm === '') {
                            this.refreshModelChildren();
                            return [2 /*return*/];
                        }
                        return [4 /*yield*/, this.searchService.search(searchTerm, {
                                onResult: function (aSearchId, result) { return __awaiter(_this, void 0, void 0, function () {
                                    var _a, name, path, tree, resultElement, resultLine, children, icon;
                                    return __generator(this, function (_b) {
                                        switch (_b.label) {
                                            case 0:
                                                if (token.isCancellationRequested || aSearchId !== searchId) {
                                                    return [2 /*return*/];
                                                }
                                                _a = this.filenameAndPath(result.file), name = _a.name, path = _a.path;
                                                tree = this.resultTree;
                                                resultElement = tree.get(result.file);
                                                if (!resultElement) return [3 /*break*/, 1];
                                                resultLine = this.createResultLineNode(result, resultElement);
                                                resultElement.children.push(resultLine);
                                                if (resultElement.children.length >= 20) {
                                                    resultElement.expanded = false;
                                                }
                                                return [3 /*break*/, 3];
                                            case 1:
                                                children = [];
                                                return [4 /*yield*/, this.labelProvider.getIcon(new uri_1.default(result.file))];
                                            case 2:
                                                icon = _b.sent();
                                                if (browser_1.CompositeTreeNode.is(this.model.root)) {
                                                    resultElement = {
                                                        selected: false,
                                                        name: name,
                                                        path: path,
                                                        children: children,
                                                        expanded: true,
                                                        id: path + '-' + name,
                                                        parent: this.model.root,
                                                        icon: icon,
                                                        file: result.file
                                                    };
                                                    resultElement.children.push(this.createResultLineNode(result, resultElement));
                                                    tree.set(result.file, resultElement);
                                                }
                                                _b.label = 3;
                                            case 3: return [2 /*return*/];
                                        }
                                    });
                                }); },
                                onDone: function () {
                                    if (token.isCancellationRequested) {
                                        return;
                                    }
                                    _this.refreshModelChildren();
                                }
                            }, searchOptions).catch(function (e) { return; })];
                    case 1:
                        searchId = _a.sent();
                        token.onCancellationRequested(function () {
                            if (searchId) {
                                _this.searchService.cancel(searchId);
                            }
                        });
                        return [2 /*return*/];
                }
            });
        });
    };
    SearchInWorkspaceResultTreeWidget.prototype.focusFirstResult = function () {
        if (browser_1.CompositeTreeNode.is(this.model.root) && this.model.root.children.length > 0) {
            var node = this.model.root.children[0];
            if (browser_1.SelectableTreeNode.is(node)) {
                this.node.focus();
                this.model.selectNode(node);
            }
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.handleUp = function (event) {
        if (!this.model.getPrevSelectableNode(this.model.selectedNodes[0])) {
            this.focusInputEmitter.fire(true);
        }
        else {
            _super.prototype.handleUp.call(this, event);
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.refreshModelChildren = function () {
        if (browser_1.CompositeTreeNode.is(this.model.root)) {
            this.model.root.children = Array.from(this.resultTree.values());
            this.model.refresh();
            this.updateCurrentEditorDecorations();
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.updateCurrentEditorDecorations = function () {
        var _this = this;
        this.shell.allTabBars.map(function (tb) {
            var currentTitle = tb.currentTitle;
            if (currentTitle && currentTitle.owner instanceof browser_3.EditorWidget) {
                var widget = currentTitle.owner;
                var result = _this.resultTree.get(widget.editor.uri.withoutScheme().toString());
                _this.decorateEditor(result, widget);
            }
        });
        var currentWidget = this.editorManager.currentEditor;
        if (currentWidget) {
            var result = this.resultTree.get(currentWidget.editor.uri.withoutScheme().toString());
            this.decorateEditor(result, currentWidget);
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.createResultLineNode = function (result, resultNode) {
        return __assign({}, result, { selected: false, id: result.file + '-' + result.line + '-' + result.character + '-' + result.length, name: result.lineText, parent: resultNode });
    };
    SearchInWorkspaceResultTreeWidget.prototype.filenameAndPath = function (uriStr) {
        var uri = new uri_1.default(uriStr);
        var name = uri.displayName;
        var path = new core_1.Path(uri.toString().substr(this.workspaceRoot.length + 1)).dir.toString();
        return { name: name, path: path };
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderCaption = function (node, props) {
        if (SearchInWorkspaceResultNode.is(node)) {
            return this.renderResultNode(node);
        }
        else if (SearchInWorkspaceResultLineNode.is(node)) {
            return this.renderResultLineNode(node);
        }
        return '';
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderTailDecorations = function (node, props) {
        return React.createElement("div", { className: 'result-node-buttons' },
            this._showReplaceButtons && this.renderReplaceButton(node),
            this.renderRemoveButton(node));
    };
    SearchInWorkspaceResultTreeWidget.prototype.doReplace = function (node, e) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.replaceResult(node);
                this.removeNode(node);
                e.stopPropagation();
                return [2 /*return*/];
            });
        });
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderReplaceButton = function (node) {
        var _this = this;
        return React.createElement("span", { className: 'replace-result', onClick: function (e) { return _this.replace(node, e); } });
    };
    SearchInWorkspaceResultTreeWidget.prototype.replaceAll = function () {
        var _this = this;
        this.resultTree.forEach(function (resultNode) { return __awaiter(_this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.replaceResult(resultNode)];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        }); });
        this.resultTree.clear();
        this.refreshModelChildren();
    };
    SearchInWorkspaceResultTreeWidget.prototype.updateRightResults = function (node) {
        var result = this.resultTree.get(node.file);
        if (result) {
            var rightPositionedNodes = result.children.filter(function (rl) { return rl.line === node.line && rl.character > node.character; });
            var diff_1 = this._replaceTerm.length - this.searchTerm.length;
            rightPositionedNodes.map(function (r) { return r.character += diff_1; });
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.replaceResult = function (node) {
        return __awaiter(this, void 0, void 0, function () {
            var toReplace, widget, source, replaceOperations;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        toReplace = [];
                        if (SearchInWorkspaceResultNode.is(node)) {
                            toReplace.push.apply(toReplace, __spread(node.children));
                        }
                        else if (SearchInWorkspaceResultLineNode.is(node)) {
                            toReplace.push(node);
                            this.updateRightResults(node);
                        }
                        if (!(toReplace.length > 0)) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.doOpen(toReplace[0])];
                    case 1:
                        widget = _a.sent();
                        source = widget.editor.document.getText();
                        replaceOperations = toReplace.map(function (resultLineNode) { return ({
                            text: _this._replaceTerm,
                            range: {
                                start: {
                                    line: resultLineNode.line - 1,
                                    character: resultLineNode.character - 1
                                },
                                end: {
                                    line: resultLineNode.line - 1,
                                    character: resultLineNode.character - 1 + resultLineNode.length
                                }
                            }
                        }); });
                        return [4 /*yield*/, widget.editor.replaceText({
                                source: source,
                                replaceOperations: replaceOperations
                            })];
                    case 2:
                        _a.sent();
                        _a.label = 3;
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    SearchInWorkspaceResultTreeWidget.prototype.doRemove = function (node, e) {
        this.removeNode(node);
        e.stopPropagation();
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderRemoveButton = function (node) {
        var _this = this;
        return React.createElement("span", { className: 'remove-node', onClick: function (e) { return _this.remove(node, e); } });
    };
    SearchInWorkspaceResultTreeWidget.prototype.removeNode = function (node) {
        if (SearchInWorkspaceResultNode.is(node)) {
            this.resultTree.delete(node.file);
        }
        else if (SearchInWorkspaceResultLineNode.is(node)) {
            var result = this.resultTree.get(node.file);
            if (result) {
                var index = result.children.findIndex(function (n) { return n.file === node.file && n.line === node.line && n.character === node.character; });
                if (index > -1) {
                    result.children.splice(index, 1);
                    if (result.children.length === 0) {
                        this.resultTree.delete(result.file);
                    }
                }
            }
        }
        this.refreshModelChildren();
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderResultNode = function (node) {
        var icon = node.icon;
        return React.createElement("div", { className: 'result' },
            React.createElement("div", { className: 'result-head' },
                React.createElement("div", { className: "result-head-info noWrapInfo noselect " + (node.selected ? 'selected' : '') },
                    React.createElement("span", { className: "file-icon " + (icon || '') }),
                    React.createElement("span", { className: 'file-name' }, node.name),
                    React.createElement("span", { className: 'file-path' }, node.path)),
                React.createElement("span", { className: 'result-number' }, node.children.length.toString())));
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderResultLineNode = function (node) {
        var prefix = node.character > 26 ? '... ' : '';
        return React.createElement("div", { className: "resultLine noWrapInfo " + (node.selected ? 'selected' : '') },
            React.createElement("span", null, prefix + node.lineText.substr(0, node.character - 1).substr(-25)),
            this.renderMatchLinePart(node),
            React.createElement("span", null, node.lineText.substr(node.character - 1 + node.length, 75)));
    };
    SearchInWorkspaceResultTreeWidget.prototype.renderMatchLinePart = function (node) {
        var replaceTerm = this._replaceTerm !== '' && this._showReplaceButtons ? React.createElement("span", { className: 'replace-term' }, this._replaceTerm) : '';
        var className = "match" + (this._showReplaceButtons ? ' strike-through' : '');
        return React.createElement(React.Fragment, null,
            React.createElement("span", { className: className },
                " ",
                node.lineText.substr(node.character - 1, node.length)),
            replaceTerm);
    };
    SearchInWorkspaceResultTreeWidget.prototype.doOpen = function (node, preview) {
        if (preview === void 0) { preview = false; }
        return __awaiter(this, void 0, void 0, function () {
            var fileUri, resultNode, leftUri, rightUri, opts, editorWidget;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        resultNode = this.resultTree.get(node.file);
                        if (!(resultNode && this._showReplaceButtons && preview)) return [3 /*break*/, 2];
                        leftUri = new uri_1.default(node.file).withScheme('file');
                        return [4 /*yield*/, this.createReplacePreview(resultNode)];
                    case 1:
                        rightUri = _a.sent();
                        fileUri = browser_1.DiffUris.encode(leftUri, rightUri);
                        return [3 /*break*/, 3];
                    case 2:
                        fileUri = new uri_1.default(node.file).withScheme('file');
                        _a.label = 3;
                    case 3:
                        opts = !browser_1.DiffUris.isDiffUri(fileUri) ? {
                            selection: {
                                start: {
                                    line: node.line - 1,
                                    character: node.character - 1
                                },
                                end: {
                                    line: node.line - 1,
                                    character: node.character - 1 + node.length
                                }
                            },
                            mode: 'reveal'
                        } : undefined;
                        return [4 /*yield*/, this.editorManager.open(fileUri, opts)];
                    case 4:
                        editorWidget = _a.sent();
                        if (!browser_1.DiffUris.isDiffUri(fileUri)) {
                            this.decorateEditor(resultNode, editorWidget);
                        }
                        return [2 /*return*/, editorWidget];
                }
            });
        });
    };
    SearchInWorkspaceResultTreeWidget.prototype.createReplacePreview = function (node) {
        return __awaiter(this, void 0, void 0, function () {
            var fileUri, uri, resource, content, lines;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        fileUri = new uri_1.default(node.file).withScheme('file');
                        uri = fileUri.withoutScheme().toString();
                        return [4 /*yield*/, this.fileResourceResolver.resolve(fileUri)];
                    case 1:
                        resource = _a.sent();
                        return [4 /*yield*/, resource.readContents()];
                    case 2:
                        content = _a.sent();
                        lines = content.split('\n');
                        node.children.map(function (l) {
                            var leftPositionedNodes = node.children.filter(function (rl) { return rl.line === l.line && rl.character < l.character; });
                            var diff = (_this._replaceTerm.length - _this.searchTerm.length) * leftPositionedNodes.length;
                            var start = lines[l.line - 1].substr(0, l.character - 1 + diff);
                            var end = lines[l.line - 1].substr(l.character - 1 + diff + l.length);
                            lines[l.line - 1] = start + _this._replaceTerm + end;
                        });
                        return [2 /*return*/, new uri_1.default(uri).withScheme(in_memory_text_resource_1.MEMORY_TEXT).withQuery(lines.join('\n'))];
                }
            });
        });
    };
    SearchInWorkspaceResultTreeWidget.prototype.decorateEditor = function (node, editorWidget) {
        if (!browser_1.DiffUris.isDiffUri(editorWidget.editor.uri)) {
            var key = editorWidget.editor.uri.toString() + "#search-in-workspace-matches";
            var oldDecorations = this.appliedDecorations.get(key) || [];
            var newDecorations = this.createEditorDecorations(node);
            var appliedDecorations = editorWidget.editor.deltaDecorations({
                newDecorations: newDecorations,
                oldDecorations: oldDecorations,
            });
            this.appliedDecorations.set(key, appliedDecorations);
        }
    };
    SearchInWorkspaceResultTreeWidget.prototype.createEditorDecorations = function (resultNode) {
        var decorations = [];
        if (resultNode) {
            resultNode.children.map(function (res) {
                decorations.push({
                    range: {
                        start: {
                            line: res.line - 1,
                            character: res.character - 1
                        },
                        end: {
                            line: res.line - 1,
                            character: res.character - 1 + res.length
                        }
                    },
                    options: {
                        overviewRuler: {
                            color: 'rgba(230, 0, 0, 1)',
                            position: browser_3.OverviewRulerLane.Full
                        },
                        className: res.selected ? 'current-search-in-workspace-editor-match' : 'search-in-workspace-editor-match',
                        stickiness: browser_3.TrackedRangeStickiness.GrowsOnlyWhenTypingBefore
                    }
                });
            });
        }
        return decorations;
    };
    __decorate([
        inversify_1.inject(search_in_workspace_service_1.SearchInWorkspaceService),
        __metadata("design:type", search_in_workspace_service_1.SearchInWorkspaceService)
    ], SearchInWorkspaceResultTreeWidget.prototype, "searchService", void 0);
    __decorate([
        inversify_1.inject(browser_3.EditorManager),
        __metadata("design:type", browser_3.EditorManager)
    ], SearchInWorkspaceResultTreeWidget.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(browser_5.FileResourceResolver),
        __metadata("design:type", browser_5.FileResourceResolver)
    ], SearchInWorkspaceResultTreeWidget.prototype, "fileResourceResolver", void 0);
    __decorate([
        inversify_1.inject(browser_1.ApplicationShell),
        __metadata("design:type", browser_1.ApplicationShell)
    ], SearchInWorkspaceResultTreeWidget.prototype, "shell", void 0);
    __decorate([
        inversify_1.inject(browser_1.LabelProvider),
        __metadata("design:type", browser_1.LabelProvider)
    ], SearchInWorkspaceResultTreeWidget.prototype, "labelProvider", void 0);
    __decorate([
        inversify_1.inject(browser_4.WorkspaceService),
        __metadata("design:type", browser_4.WorkspaceService)
    ], SearchInWorkspaceResultTreeWidget.prototype, "workspaceService", void 0);
    __decorate([
        inversify_1.inject(browser_1.TreeExpansionService),
        __metadata("design:type", Object)
    ], SearchInWorkspaceResultTreeWidget.prototype, "expansionService", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], SearchInWorkspaceResultTreeWidget.prototype, "init", null);
    SearchInWorkspaceResultTreeWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_2.TreeProps)),
        __param(1, inversify_1.inject(browser_1.TreeModel)),
        __param(2, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __metadata("design:paramtypes", [Object, Object, Object])
    ], SearchInWorkspaceResultTreeWidget);
    return SearchInWorkspaceResultTreeWidget;
}(browser_1.TreeWidget));
exports.SearchInWorkspaceResultTreeWidget = SearchInWorkspaceResultTreeWidget;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-service.js":
/*!*********************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-service.js ***!
  \*********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017-2018 Ericsson and others.
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var search_in_workspace_interface_1 = __webpack_require__(/*! ../common/search-in-workspace-interface */ "../node_modules/@theia/search-in-workspace/lib/common/search-in-workspace-interface.js");
var browser_1 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
/**
 * Class that will receive the search results from the server.  This is separate
 * from the SearchInWorkspaceService class only to avoid a cycle in the
 * dependency injection.
 */
var SearchInWorkspaceClientImpl = /** @class */ (function () {
    function SearchInWorkspaceClientImpl() {
    }
    SearchInWorkspaceClientImpl.prototype.onResult = function (searchId, result) {
        this.service.onResult(searchId, result);
    };
    SearchInWorkspaceClientImpl.prototype.onDone = function (searchId, error) {
        this.service.onDone(searchId, error);
    };
    SearchInWorkspaceClientImpl.prototype.setService = function (service) {
        this.service = service;
    };
    SearchInWorkspaceClientImpl = __decorate([
        inversify_1.injectable()
    ], SearchInWorkspaceClientImpl);
    return SearchInWorkspaceClientImpl;
}());
exports.SearchInWorkspaceClientImpl = SearchInWorkspaceClientImpl;
/**
 * Service to search text in the workspace files.
 */
var SearchInWorkspaceService = /** @class */ (function () {
    function SearchInWorkspaceService() {
        // All the searches that we have started, that are not done yet (onDone
        // with that searchId has not been called).
        this.pendingSearches = new Map();
        // Due to the asynchronicity of the node backend, it's possible that we
        // start a search, receive an event for that search, and then receive
        // the search id for that search.We therefore need to keep those
        // events until we get the search id and return it to the caller.
        // Otherwise the caller would discard the event because it doesn't know
        // the search id yet.
        this.pendingOnDones = new Map();
        this.lastKnownSearchId = -1;
    }
    SearchInWorkspaceService.prototype.init = function () {
        this.client.setService(this);
    };
    SearchInWorkspaceService.prototype.isEnabled = function () {
        return this.workspaceService.opened;
    };
    SearchInWorkspaceService.prototype.onResult = function (searchId, result) {
        var callbacks = this.pendingSearches.get(searchId);
        if (callbacks) {
            callbacks.onResult(searchId, result);
        }
    };
    SearchInWorkspaceService.prototype.onDone = function (searchId, error) {
        var callbacks = this.pendingSearches.get(searchId);
        if (callbacks) {
            this.pendingSearches.delete(searchId);
            callbacks.onDone(searchId, error);
        }
        else {
            if (searchId > this.lastKnownSearchId) {
                this.logger.debug("Got an onDone for a searchId we don't know about (" + searchId + "), stashing it for later with error = ", error);
                this.pendingOnDones.set(searchId, error);
            }
            else {
                // It's possible to receive an onDone for a search we have cancelled.  Just ignore it.
                this.logger.debug("Got an onDone for a searchId we don't know about (" + searchId + "), but it's probably an old one, error = ", error);
            }
        }
    };
    // Start a search of the string "what" in the workspace.
    SearchInWorkspaceService.prototype.search = function (what, callbacks, opts) {
        return __awaiter(this, void 0, void 0, function () {
            var root, searchId, error_1;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.workspaceService.roots];
                    case 1:
                        root = (_a.sent())[0];
                        if (!root) {
                            throw new Error('Search failed: no workspace root.');
                        }
                        return [4 /*yield*/, this.searchServer.search(what, root.uri, opts)];
                    case 2:
                        searchId = _a.sent();
                        this.pendingSearches.set(searchId, callbacks);
                        this.lastKnownSearchId = searchId;
                        this.logger.debug('Service launched search ' + searchId);
                        // Check if we received an onDone before search() returned.
                        if (this.pendingOnDones.has(searchId)) {
                            this.logger.debug('Ohh, we have a stashed onDone for that searchId');
                            error_1 = this.pendingOnDones.get(searchId);
                            this.pendingOnDones.delete(searchId);
                            // Call the client's searchId, but first give it a
                            // chance to record the returned searchId.
                            setTimeout(function () {
                                _this.onDone(searchId, error_1);
                            }, 0);
                        }
                        return [2 /*return*/, searchId];
                }
            });
        });
    };
    // Cancel an ongoing search.
    SearchInWorkspaceService.prototype.cancel = function (searchId) {
        this.pendingSearches.delete(searchId);
        this.searchServer.cancel(searchId);
    };
    __decorate([
        inversify_1.inject(search_in_workspace_interface_1.SearchInWorkspaceServer),
        __metadata("design:type", Object)
    ], SearchInWorkspaceService.prototype, "searchServer", void 0);
    __decorate([
        inversify_1.inject(SearchInWorkspaceClientImpl),
        __metadata("design:type", SearchInWorkspaceClientImpl)
    ], SearchInWorkspaceService.prototype, "client", void 0);
    __decorate([
        inversify_1.inject(browser_1.WorkspaceService),
        __metadata("design:type", browser_1.WorkspaceService)
    ], SearchInWorkspaceService.prototype, "workspaceService", void 0);
    __decorate([
        inversify_1.inject(core_1.ILogger),
        __metadata("design:type", Object)
    ], SearchInWorkspaceService.prototype, "logger", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], SearchInWorkspaceService.prototype, "init", null);
    SearchInWorkspaceService = __decorate([
        inversify_1.injectable()
    ], SearchInWorkspaceService);
    return SearchInWorkspaceService;
}());
exports.SearchInWorkspaceService = SearchInWorkspaceService;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-widget.js":
/*!********************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-widget.js ***!
  \********************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var search_in_workspace_result_tree_widget_1 = __webpack_require__(/*! ./search-in-workspace-result-tree-widget */ "../node_modules/@theia/search-in-workspace/lib/browser/search-in-workspace-result-tree-widget.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var ReactDOM = __webpack_require__(/*! react-dom */ "../node_modules/react-dom/index.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_2 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
var SearchInWorkspaceWidget = /** @class */ (function (_super) {
    __extends(SearchInWorkspaceWidget, _super);
    function SearchInWorkspaceWidget() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.showSearchDetails = false;
        _this.hasResults = false;
        _this.resultNumber = 0;
        _this.searchFieldContainerIsFocused = false;
        _this.searchTerm = '';
        _this.replaceTerm = '';
        _this.showReplaceField = false;
        _this.refresh = function () {
            _this.resultTreeWidget.search(_this.searchTerm, _this.searchInWorkspaceOptions);
            _this.update();
        };
        _this.collapseAll = function () {
            _this.resultTreeWidget.collapseAll();
            _this.update();
        };
        _this.clear = function () {
            _this.searchTerm = '';
            _this.replaceTerm = '';
            _this.searchInWorkspaceOptions.include = [];
            _this.searchInWorkspaceOptions.exclude = [];
            _this.includeIgnoredState.enabled = false;
            _this.matchCaseState.enabled = false;
            _this.wholeWordState.enabled = false;
            _this.regExpState.enabled = false;
            var search = document.getElementById('search-input-field');
            var replace = document.getElementById('replace-input-field');
            var include = document.getElementById('include-glob-field');
            var exclude = document.getElementById('exclude-glob-field');
            if (search && replace && include && exclude) {
                search.value = '';
                replace.value = '';
                include.value = '';
                exclude.value = '';
            }
            _this.resultTreeWidget.search(_this.searchTerm, _this.searchInWorkspaceOptions);
            _this.update();
        };
        _this.focusSearchFieldContainer = function () { return _this.doFocusSearchFieldContainer(); };
        _this.unfocusSearchFieldContainer = function () { return _this.doUnfocusSearchFieldContainer(); };
        _this.search = function (e) { return _this.doSearch(e); };
        _this.updateReplaceTerm = function (e) { return _this.doUpdateReplaceTerm(e); };
        return _this;
    }
    SearchInWorkspaceWidget_1 = SearchInWorkspaceWidget;
    SearchInWorkspaceWidget.prototype.init = function () {
        var _this = this;
        this.id = SearchInWorkspaceWidget_1.ID;
        this.title.label = SearchInWorkspaceWidget_1.LABEL;
        this.title.caption = SearchInWorkspaceWidget_1.LABEL;
        this.title.iconClass = 'fa search-in-workspace-tab-icon';
        this.contentNode = document.createElement('div');
        this.contentNode.classList.add('t-siw-search-container');
        this.searchFormContainer = document.createElement('div');
        this.searchFormContainer.classList.add('searchHeader');
        this.contentNode.appendChild(this.searchFormContainer);
        this.node.appendChild(this.contentNode);
        this.matchCaseState = {
            className: 'match-case',
            enabled: false,
            title: 'Match Case'
        };
        this.wholeWordState = {
            className: 'whole-word',
            enabled: false,
            title: 'Match Whole Word'
        };
        this.regExpState = {
            className: 'use-regexp',
            enabled: false,
            title: 'Use Regular Expression'
        };
        this.includeIgnoredState = {
            className: 'include-ignored fa fa-eye',
            enabled: false,
            title: 'Include Ignored Files'
        };
        this.searchInWorkspaceOptions = {
            matchCase: false,
            matchWholeWord: false,
            useRegExp: false,
            includeIgnored: false,
            include: [],
            exclude: [],
            maxResults: 2000
        };
        this.toDispose.push(this.resultTreeWidget.onChange(function (r) {
            _this.hasResults = r.size > 0;
            _this.resultNumber = 0;
            var results = Array.from(r.values());
            results.forEach(function (result) { return _this.resultNumber += result.children.length; });
            _this.update();
        }));
        this.toDispose.push(this.resultTreeWidget.onFocusInput(function (b) {
            _this.focusInputField();
        }));
        this.toDispose.push(this.resultTreeWidget);
    };
    SearchInWorkspaceWidget.prototype.storeState = function () {
        return {
            matchCaseState: this.matchCaseState,
            wholeWordState: this.wholeWordState,
            regExpState: this.regExpState,
            includeIgnoredState: this.includeIgnoredState,
            showSearchDetails: this.showSearchDetails,
            searchInWorkspaceOptions: this.searchInWorkspaceOptions,
            searchTerm: this.searchTerm,
            replaceTerm: this.replaceTerm,
            showReplaceField: this.showReplaceField
        };
    };
    // tslint:disable-next-line:no-any
    SearchInWorkspaceWidget.prototype.restoreState = function (oldState) {
        this.matchCaseState = oldState.matchCaseState;
        this.wholeWordState = oldState.wholeWordState;
        this.regExpState = oldState.regExpState;
        this.includeIgnoredState = oldState.includeIgnoredState;
        this.showSearchDetails = oldState.showSearchDetails;
        this.searchInWorkspaceOptions = oldState.searchInWorkspaceOptions;
        this.searchTerm = oldState.searchTerm;
        this.replaceTerm = oldState.replaceTerm;
        this.showReplaceField = oldState.showReplaceField;
        this.resultTreeWidget.replaceTerm = this.replaceTerm;
        this.resultTreeWidget.showReplaceButtons = this.showReplaceField;
        this.refresh();
    };
    SearchInWorkspaceWidget.prototype.findInFolder = function (uri) {
        this.showSearchDetails = true;
        var value = uri + "/**";
        this.searchInWorkspaceOptions.include = [value];
        var include = document.getElementById('include-glob-field');
        if (include) {
            include.value = value;
        }
        this.update();
    };
    SearchInWorkspaceWidget.prototype.onAfterAttach = function (msg) {
        var _this = this;
        _super.prototype.onAfterAttach.call(this, msg);
        ReactDOM.render(React.createElement(React.Fragment, null, this.renderSearchHeader()), this.searchFormContainer);
        browser_1.Widget.attach(this.resultTreeWidget, this.contentNode);
        this.toDisposeOnDetach.push(common_1.Disposable.create(function () {
            browser_1.Widget.detach(_this.resultTreeWidget);
        }));
    };
    SearchInWorkspaceWidget.prototype.onUpdateRequest = function (msg) {
        _super.prototype.onUpdateRequest.call(this, msg);
        ReactDOM.render(React.createElement(React.Fragment, null, this.renderSearchHeader()), this.searchFormContainer);
    };
    SearchInWorkspaceWidget.prototype.onResize = function (msg) {
        _super.prototype.onResize.call(this, msg);
        browser_1.MessageLoop.sendMessage(this.resultTreeWidget, browser_1.Widget.ResizeMessage.UnknownSize);
    };
    SearchInWorkspaceWidget.prototype.onAfterShow = function (msg) {
        this.focusInputField();
    };
    SearchInWorkspaceWidget.prototype.onActivateRequest = function (msg) {
        _super.prototype.onActivateRequest.call(this, msg);
        this.focusInputField();
    };
    SearchInWorkspaceWidget.prototype.focusInputField = function () {
        var f = document.getElementById('search-input-field');
        if (f) {
            f.focus();
            f.select();
        }
    };
    SearchInWorkspaceWidget.prototype.renderSearchHeader = function () {
        var controlButtons = this.renderControlButtons();
        var searchAndReplaceContainer = this.renderSearchAndReplace();
        var searchDetails = this.renderSearchDetails();
        return React.createElement("div", null,
            controlButtons,
            searchAndReplaceContainer,
            searchDetails);
    };
    SearchInWorkspaceWidget.prototype.renderControlButtons = function () {
        var refreshButton = this.renderControlButton("refresh" + ((this.hasResults || this.searchTerm !== '') && this.workspaceService.tryGetRoots().length > 0
            ? ' enabled' : ''), 'Refresh', this.refresh);
        var collapseAllButton = this.renderControlButton("collapse-all" + (this.hasResults ? ' enabled' : ''), 'Collapse All', this.collapseAll);
        var clearButton = this.renderControlButton("clear-all" + (this.hasResults ? ' enabled' : ''), 'Clear', this.clear);
        return React.createElement("div", { className: 'controls button-container' },
            refreshButton,
            collapseAllButton,
            clearButton);
    };
    SearchInWorkspaceWidget.prototype.renderControlButton = function (btnClass, title, clickHandler) {
        return React.createElement("span", { className: "btn " + btnClass, title: title, onClick: clickHandler });
    };
    SearchInWorkspaceWidget.prototype.renderSearchAndReplace = function () {
        var toggleContainer = this.renderReplaceFieldToggle();
        var searchField = this.renderSearchField();
        var replaceField = this.renderReplaceField();
        return React.createElement("div", { className: 'search-and-replace-container' },
            toggleContainer,
            React.createElement("div", { className: 'search-and-replace-fields' },
                searchField,
                replaceField));
    };
    SearchInWorkspaceWidget.prototype.renderReplaceFieldToggle = function () {
        var _this = this;
        var toggle = React.createElement("span", { className: "fa fa-caret-" + (this.showReplaceField ? 'down' : 'right') });
        return React.createElement("div", { className: 'replace-toggle', tabIndex: 0, onClick: function (e) {
                var elArr = document.getElementsByClassName('replace-toggle');
                if (elArr && elArr.length > 0) {
                    elArr[0].focus();
                }
                _this.showReplaceField = !_this.showReplaceField;
                _this.resultTreeWidget.showReplaceButtons = _this.showReplaceField;
                _this.update();
            } }, toggle);
    };
    SearchInWorkspaceWidget.prototype.renderNotification = function () {
        if (this.workspaceService.tryGetRoots().length <= 0) {
            return React.createElement("div", { className: 'search-notification show' },
                React.createElement("div", null, "Cannot search without an active workspace present."));
        }
        return React.createElement("div", { className: "search-notification " + (this.searchInWorkspaceOptions.maxResults && this.resultNumber >= this.searchInWorkspaceOptions.maxResults ? 'show' : '') },
            React.createElement("div", null, "This is only a subset of all results. Use a more specific search term to narrow down the result list."));
    };
    SearchInWorkspaceWidget.prototype.doFocusSearchFieldContainer = function () {
        this.searchFieldContainerIsFocused = true;
        this.update();
    };
    SearchInWorkspaceWidget.prototype.doUnfocusSearchFieldContainer = function () {
        this.searchFieldContainerIsFocused = false;
        this.update();
    };
    SearchInWorkspaceWidget.prototype.doSearch = function (e) {
        if (e.target) {
            if (browser_1.Key.ARROW_DOWN.keyCode === e.keyCode) {
                this.resultTreeWidget.focusFirstResult();
            }
            else {
                this.searchTerm = e.target.value;
                this.resultTreeWidget.search(this.searchTerm, (this.searchInWorkspaceOptions || {}));
                this.update();
            }
        }
    };
    SearchInWorkspaceWidget.prototype.renderSearchField = function () {
        var input = React.createElement("input", { id: 'search-input-field', type: 'text', size: 1, placeholder: 'Search', defaultValue: this.searchTerm, onKeyUp: this.search });
        var notification = this.renderNotification();
        var optionContainer = this.renderOptionContainer();
        var tooMany = this.searchInWorkspaceOptions.maxResults && this.resultNumber >= this.searchInWorkspaceOptions.maxResults ? 'tooManyResults' : '';
        var className = "search-field-container " + tooMany + " " + (this.searchFieldContainerIsFocused ? 'focused' : '');
        return React.createElement("div", { className: className },
            React.createElement("div", { className: 'search-field', tabIndex: -1, onFocus: this.focusSearchFieldContainer, onBlur: this.unfocusSearchFieldContainer },
                input,
                optionContainer),
            notification);
    };
    SearchInWorkspaceWidget.prototype.doUpdateReplaceTerm = function (e) {
        if (e.target) {
            this.replaceTerm = e.target.value;
            this.resultTreeWidget.replaceTerm = this.replaceTerm;
            this.resultTreeWidget.search(this.searchTerm, (this.searchInWorkspaceOptions || {}));
            this.update();
        }
    };
    SearchInWorkspaceWidget.prototype.renderReplaceField = function () {
        var replaceAllButtonContainer = this.renderReplaceAllButtonContainer();
        return React.createElement("div", { className: "replace-field" + (this.showReplaceField ? '' : ' hidden') },
            React.createElement("input", { id: 'replace-input-field', type: 'text', size: 1, placeholder: 'Replace', defaultValue: this.replaceTerm, onKeyUp: this.updateReplaceTerm }),
            replaceAllButtonContainer);
    };
    SearchInWorkspaceWidget.prototype.renderReplaceAllButtonContainer = function () {
        var _this = this;
        return React.createElement("div", { className: 'replace-all-button-container' },
            React.createElement("span", { className: "replace-all-button" + (this.searchTerm === '' ? ' disabled' : ''), onClick: function () {
                    _this.resultTreeWidget.replaceAll();
                } }));
    };
    SearchInWorkspaceWidget.prototype.renderOptionContainer = function () {
        var matchCaseOption = this.renderOptionElement(this.matchCaseState);
        var wholeWordOption = this.renderOptionElement(this.wholeWordState);
        var regexOption = this.renderOptionElement(this.regExpState);
        var includeIgnoredOption = this.renderOptionElement(this.includeIgnoredState);
        return React.createElement("div", { className: 'option-buttons' },
            matchCaseOption,
            wholeWordOption,
            regexOption,
            includeIgnoredOption);
    };
    SearchInWorkspaceWidget.prototype.renderOptionElement = function (opt) {
        var _this = this;
        return React.createElement("span", { className: opt.className + " option " + (opt.enabled ? 'enabled' : ''), title: opt.title, onClick: function () { return _this.handleOptionClick(opt); } });
    };
    SearchInWorkspaceWidget.prototype.handleOptionClick = function (option) {
        option.enabled = !option.enabled;
        this.updateSearchOptions();
        this.searchFieldContainerIsFocused = true;
        this.resultTreeWidget.search(this.searchTerm, this.searchInWorkspaceOptions);
        this.update();
    };
    SearchInWorkspaceWidget.prototype.updateSearchOptions = function () {
        this.searchInWorkspaceOptions.matchCase = this.matchCaseState.enabled;
        this.searchInWorkspaceOptions.matchWholeWord = this.wholeWordState.enabled;
        this.searchInWorkspaceOptions.useRegExp = this.regExpState.enabled;
        this.searchInWorkspaceOptions.includeIgnored = this.includeIgnoredState.enabled;
    };
    SearchInWorkspaceWidget.prototype.renderSearchDetails = function () {
        var expandButton = this.renderExpandGlobFieldsButton();
        var globFieldContainer = this.renderGlobFieldContainer();
        return React.createElement("div", { className: 'search-details' },
            expandButton,
            globFieldContainer);
    };
    SearchInWorkspaceWidget.prototype.renderGlobFieldContainer = function () {
        var includeField = this.renderGlobField('include');
        var excludeField = this.renderGlobField('exclude');
        return React.createElement("div", { className: "glob-field-container" + (!this.showSearchDetails ? ' hidden' : '') },
            includeField,
            excludeField);
    };
    SearchInWorkspaceWidget.prototype.renderExpandGlobFieldsButton = function () {
        var _this = this;
        return React.createElement("div", { className: 'button-container' },
            React.createElement("span", { className: 'fa fa-ellipsis-h btn', onClick: function () {
                    _this.showSearchDetails = !_this.showSearchDetails;
                    _this.update();
                } }));
    };
    SearchInWorkspaceWidget.prototype.renderGlobField = function (kind) {
        var _this = this;
        var currentValue = this.searchInWorkspaceOptions[kind];
        var value = currentValue && currentValue.join(', ') || '';
        return React.createElement("div", { className: 'glob-field' },
            React.createElement("div", { className: 'label' }, 'files to ' + kind),
            React.createElement("input", { type: 'text', size: 1, defaultValue: value, id: kind + '-glob-field', onKeyUp: function (e) {
                    if (e.target) {
                        if (browser_1.Key.ENTER.keyCode === e.keyCode) {
                            _this.resultTreeWidget.search(_this.searchTerm, _this.searchInWorkspaceOptions);
                        }
                        else {
                            _this.searchInWorkspaceOptions[kind] = _this.splitOnComma(e.target.value);
                        }
                    }
                } }));
    };
    SearchInWorkspaceWidget.prototype.splitOnComma = function (patterns) {
        return patterns.split(',').map(function (s) { return s.trim(); });
    };
    var SearchInWorkspaceWidget_1;
    SearchInWorkspaceWidget.ID = 'search-in-workspace';
    SearchInWorkspaceWidget.LABEL = 'Search';
    __decorate([
        inversify_1.inject(search_in_workspace_result_tree_widget_1.SearchInWorkspaceResultTreeWidget),
        __metadata("design:type", search_in_workspace_result_tree_widget_1.SearchInWorkspaceResultTreeWidget)
    ], SearchInWorkspaceWidget.prototype, "resultTreeWidget", void 0);
    __decorate([
        inversify_1.inject(browser_2.WorkspaceService),
        __metadata("design:type", browser_2.WorkspaceService)
    ], SearchInWorkspaceWidget.prototype, "workspaceService", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], SearchInWorkspaceWidget.prototype, "init", null);
    SearchInWorkspaceWidget = SearchInWorkspaceWidget_1 = __decorate([
        inversify_1.injectable()
    ], SearchInWorkspaceWidget);
    return SearchInWorkspaceWidget;
}(browser_1.BaseWidget));
exports.SearchInWorkspaceWidget = SearchInWorkspaceWidget;


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/lib/common/search-in-workspace-interface.js":
/*!**********************************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/lib/common/search-in-workspace-interface.js ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017-2018 Ericsson and others.
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
var SearchInWorkspaceResult;
(function (SearchInWorkspaceResult) {
    /**
     * Sort search in workspace results according to file, line, character position
     * and then length.
     */
    function compare(a, b) {
        if (a.file !== b.file) {
            return a.file < b.file ? -1 : 1;
        }
        if (a.line !== b.line) {
            return a.line - b.line;
        }
        if (a.character !== b.character) {
            return a.character - b.character;
        }
        return a.length - b.length;
    }
    SearchInWorkspaceResult.compare = compare;
})(SearchInWorkspaceResult = exports.SearchInWorkspaceResult || (exports.SearchInWorkspaceResult = {}));
exports.SearchInWorkspaceClient = Symbol('SearchInWorkspaceClient');
exports.SearchInWorkspaceServer = Symbol('SearchInWorkspaceServer');


/***/ }),

/***/ "../node_modules/@theia/search-in-workspace/src/browser/styles/index.css":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/search-in-workspace/src/browser/styles/index.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/search-in-workspace/src/browser/styles/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/search-in-workspace/src/browser/styles/index.css":
/*!**********************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/search-in-workspace/src/browser/styles/index.css ***!
  \**********************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017-2018 Ericsson and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n :root {\n  --theia-current-search-match-color: var(--theia-word-highlight-color0);\n  --theia-range-highlight: var(--theia-word-highlight-color1);\n }\n\n.t-siw-search-container {\n    color: var(--theia-ui-font-color1);\n    padding: 5px;\n    display: flex;\n    flex-direction: column;\n    height: 100%;\n    box-sizing: border-box;\n}\n\n.t-siw-search-container input[type=\"text\"] {\n    flex: 1;\n    line-height: var(--theia-content-line-height);\n    font-size: var(--theia-ui-font-size1);\n    padding-left: 8px;\n    color: var(--theia-ui-font-color1);\n}\n\n.t-siw-search-container input[type=\"text\"]:focus {\n    outline: none;\n}\n\n.t-siw-search-container #search-input-field:focus {\n    border: none;\n}\n\n.t-siw-search-container #search-input-field {\n    background: none;\n    border: none;\n}\n\n.t-siw-search-container .searchHeader {\n    width: 100%;\n    margin-bottom:  10px;\n}\n\n.t-siw-search-container .searchHeader .controls.button-container {\n    height: 22px;\n    margin-bottom: 5px;\n}\n\n.t-siw-search-container .searchHeader .controls .refresh {\n    background: var(--theia-icon-refresh);\n}\n\n.t-siw-search-container .searchHeader .controls .collapse-all {\n    background: var(--theia-icon-collapse-all);\n}\n\n.t-siw-search-container .searchHeader .controls .clear-all {\n    background: var(--theia-icon-clear);\n}\n\n.t-siw-search-container .searchHeader .search-field-container {\n    background: var(--theia-layout-color2);\n}\n\n.t-siw-search-container .searchHeader .search-field-container.focused {\n    border-style: solid;\n    border-width: var(--theia-border-width);\n    border-color: var(--theia-accent-color3);\n    margin: -1px;\n}\n\n.t-siw-search-container .searchHeader .search-field {\n    display: flex;\n    align-items:  center;\n}\n\n.t-siw-search-container .searchHeader .search-field:focus {\n    border: none;\n}\n\n.t-siw-search-container .searchHeader .search-field .option {\n    opacity: 0.7;\n    cursor: pointer;\n}\n\n.t-siw-search-container .searchHeader .search-field .option.enabled {\n    border: var(--theia-border-width) var(--theia-accent-color3) solid;\n}\n\n.t-siw-search-container .searchHeader .search-field .option:hover {\n    opacity: 1;\n}\n\n.t-siw-search-container .searchHeader .search-field .option.match-case {\n    background-image: var(--theia-icon-case-sensitive);\n}\n\n.t-siw-search-container .searchHeader .search-field .option.whole-word {\n    background-image: var(--theia-icon-whole-word);\n}\n\n.t-siw-search-container .searchHeader .search-field .option.use-regexp {\n    background-image: var(--theia-icon-regex);\n}\n\n.t-siw-search-container .searchHeader .search-field .option-buttons {\n    height: 23px;\n    display: flex;\n    align-items:  center;\n    background-color: none;\n}\n\n.t-siw-search-container .searchHeader .search-field-container.tooManyResults {\n    border-style: solid;\n    border-width: var(--theia-border-width);\n    margin: -1px;\n    border-color: var(--theia-warn-color0);\n}\n\n.t-siw-search-container .searchHeader .search-field-container .search-notification {\n    height: 0;\n    display: none;\n    width: 100%;\n    position: relative;\n}\n\n.t-siw-search-container .searchHeader .search-field-container.focused .search-notification.show {\n    display: block;\n}\n\n.t-siw-search-container .searchHeader .search-notification div{\n    background-color: var(--theia-warn-color0);\n    width: calc(100% + 2px);\n    margin-left: -1px;\n    color: var(--theia-warn-font-color0);\n    z-index: 1000;\n    position: absolute;\n    border: 1px solid var(--theia-warn-color0);\n    box-sizing: border-box;\n    padding: 3px;\n}\n\n.t-siw-search-container .searchHeader .button-container {\n    text-align: right;\n    padding-right: 5px;\n    padding-top: 5px;\n    display: flex;\n    justify-content: flex-end;\n}\n\n.t-siw-search-container .searchHeader .search-field .option,\n.t-siw-search-container .searchHeader .button-container .btn {\n    width: 21px;\n    height: 21px;\n    margin: 0 1px;\n    display: inline-block;\n    box-sizing: border-box;\n    align-items: center;\n    user-select: none;\n    background-repeat: no-repeat;\n    background-position: center;\n    border: var(--theia-border-width) solid transparent;\n}\n\n.t-siw-search-container .searchHeader .search-field .fa.option {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n}\n\n.t-siw-search-container .searchHeader .controls .btn{\n    margin-left: 3px;\n    opacity: 0.25;\n    width: 18px\n}\n\n.t-siw-search-container .searchHeader .controls .btn.enabled{\n    opacity: 0.7;\n    cursor: pointer;\n}\n\n.t-siw-search-container .searchHeader .controls .btn.enabled:hover{\n    opacity: 1;\n}\n\n.t-siw-search-container .searchHeader .search-details .button-container {\n    height: 5px;\n}\n\n\n.t-siw-search-container .searchHeader .search-details .button-container .btn{\n    cursor: pointer;\n}\n\n.t-siw-search-container .searchHeader .glob-field-container.hidden {\n    display: none;\n}\n\n.t-siw-search-container .searchHeader .glob-field-container .glob-field {\n    margin-bottom: 8px;\n    margin-left: 17px;\n    display: flex;\n    flex-direction: column;\n}\n\n.t-siw-search-container .searchHeader .glob-field-container .glob-field .label {\n    margin-bottom: 3px;\n    user-select: none;\n    font-size: var(--theia-ui-font-size0);\n}\n\n.t-siw-search-container .resultContainer {\n    height: 100%;\n}\n\n.t-siw-search-container .result {\n    overflow: hidden;\n    width: 100%;\n}\n\n.t-siw-search-container .result .result-head {\n    display:flex;\n}\n\n.t-siw-search-container .result .result-head .result-no {\n    background: var(--theia-ui-expand-button-color);\n    padding: 3px 8px;\n    border-radius: 7px;\n    font-size: var(--theia-ui-font-size0);\n}\n\n.t-siw-search-container .result .result-head .expand-icon {\n    margin: 0 3px;\n    width: 7px;\n}\n\n.t-siw-search-container .result .result-head .file-icon {\n    margin: 0 3px;\n}\n\n.t-siw-search-container .result .result-head .file-name {\n    margin-right: 5px;\n}\n\n.t-siw-search-container .result .result-head .file-path {\n    color: var(--theia-ui-font-color2);\n    font-size: var(--theia-ui-font-size0);\n    margin-left: 3px;\n}\n\n.t-siw-search-container .resultLine .match {\n    background: var(--theia-word-highlight-match-color1);\n    display: inline-block;\n    line-height: normal;\n}\n\n.t-siw-search-container .resultLine .match.strike-through {\n    text-decoration: line-through;\n}\n\n.t-siw-search-container .resultLine.selected .match {\n    background: var(--theia-word-highlight-match-color1);\n}\n.t-siw-search-container .resultLine .replace-term {\n    background: var(--theia-word-highlight-replace-color0);\n}\n\n.noWrapInfo {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    width: 100%;\n}\n\n.result-head-info {\n    align-items: center;\n}\n\n.search-in-workspace-editor-match {\n    background: var(--theia-word-highlight-match-color0);\n}\n\n.current-search-in-workspace-editor-match {\n    background: var(--theia-current-search-match-color)\n}\n\n.current-match-range-highlight {\n    background: var(--theia-range-highlight);\n}\n\n.result-node-buttons {\n    display: none;\n}\n\n.theia-TreeNode:hover .result-node-buttons {\n    display: flex;\n    justify-content: flex-end;\n    flex: 1;\n    align-items: center;\n    align-self: center;\n}\n\n.theia-TreeNode:hover .result-number {\n    display: none;\n}\n\n.theia-TreeNode .result-number {\n    background-color: var(--theia-ui-font-color2);\n    border-radius: 10px;\n    padding: 0 5px;\n    text-align: center;\n    font-size: calc(var(--theia-ui-font-size0) * 0.8);\n    color: var(--theia-inverse-ui-font-color0);\n    font-weight: 400;\n    min-width: 7px;\n    height: 16px;\n    line-height: calc(var(--theia-private-horizontal-tab-height) * 0.8);\n    align-self: center;\n}\n\n.result-node-buttons .remove-node {\n    background-image: var(--theia-icon-close);\n}\n\n.result-node-buttons > span {\n    width: 15px;\n    height: 15px;\n    margin-right: 3px;\n    background-repeat:  no-repeat;\n    background-position: center;\n    background-size: contain;\n}\n\n.search-and-replace-container {\n    display: flex;\n}\n\n.replace-toggle {\n    display: flex;\n    align-items:  center;\n    width: 15px;\n    min-width: 15px;\n    justify-content: center;\n    margin-right: 2px;\n    box-sizing: border-box;\n}\n\n.replace-toggle:hover {\n    background: var(--theia-layout-color2);\n}\n\n.search-and-replace-fields {\n    display: flex;\n    flex-direction: column;\n    flex: 1;\n}\n\n.replace-field {\n    display: flex;\n    margin-top: 5px;\n}\n\n.replace-field.hidden {\n    display: none;\n}\n\n.replace-all-button-container {\n    width: 25px;\n    display: flex;\n    align-items: center;\n    justify-content:  center;\n}\n\n.replace-all-button {\n    width:  100%;\n    height: 100%;\n    display: inline-block;\n    background: var(--theia-icon-replace-all) no-repeat center;\n}\n\n.result-node-buttons .replace-result {\n    background-image: var(--theia-icon-replace);\n}\n\n.replace-all-button.disabled {\n    opacity: 0.5;\n}\n\n.search-in-workspace-tab-icon::before {\n    content: \"\\F002\"\n}\n", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=31.bundle.js.map