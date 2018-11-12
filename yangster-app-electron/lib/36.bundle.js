(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[36],{

/***/ "../node_modules/@theia/file-search/lib/browser/file-search-frontend-module.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/@theia/file-search/lib/browser/file-search-frontend-module.js ***!
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var quick_file_open_contribution_1 = __webpack_require__(/*! ./quick-file-open-contribution */ "../node_modules/@theia/file-search/lib/browser/quick-file-open-contribution.js");
var quick_file_open_1 = __webpack_require__(/*! ./quick-file-open */ "../node_modules/@theia/file-search/lib/browser/quick-file-open.js");
var file_search_service_1 = __webpack_require__(/*! ../common/file-search-service */ "../node_modules/@theia/file-search/lib/common/file-search-service.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(file_search_service_1.FileSearchService).toDynamicValue(function (ctx) {
        var provider = ctx.container.get(browser_1.WebSocketConnectionProvider);
        return provider.createProxy(file_search_service_1.fileSearchServicePath);
    }).inSingletonScope();
    bind(quick_file_open_contribution_1.QuickFileOpenFrontendContribution).toSelf().inSingletonScope();
    [common_1.CommandContribution, browser_1.KeybindingContribution, browser_1.QuickOpenContribution].forEach(function (serviceIdentifier) {
        return bind(serviceIdentifier).toService(quick_file_open_contribution_1.QuickFileOpenFrontendContribution);
    });
    bind(quick_file_open_1.QuickFileOpenService).toSelf().inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/file-search/lib/browser/quick-file-open-contribution.js":
/*!**************************************************************************************!*\
  !*** ../node_modules/@theia/file-search/lib/browser/quick-file-open-contribution.js ***!
  \**************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var quick_file_open_1 = __webpack_require__(/*! ./quick-file-open */ "../node_modules/@theia/file-search/lib/browser/quick-file-open.js");
var QuickFileOpenFrontendContribution = /** @class */ (function () {
    function QuickFileOpenFrontendContribution() {
    }
    QuickFileOpenFrontendContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(quick_file_open_1.quickFileOpen, {
            execute: function () { return _this.quickFileOpenService.open(); },
            isEnabled: function () { return _this.quickFileOpenService.isEnabled(); }
        });
    };
    QuickFileOpenFrontendContribution.prototype.registerKeybindings = function (keybindings) {
        keybindings.registerKeybinding({
            command: quick_file_open_1.quickFileOpen.id,
            keybinding: 'ctrlcmd+p'
        });
    };
    QuickFileOpenFrontendContribution.prototype.registerQuickOpenHandlers = function (handlers) {
        handlers.registerHandler(this.quickFileOpenService, true);
    };
    __decorate([
        inversify_1.inject(quick_file_open_1.QuickFileOpenService),
        __metadata("design:type", quick_file_open_1.QuickFileOpenService)
    ], QuickFileOpenFrontendContribution.prototype, "quickFileOpenService", void 0);
    QuickFileOpenFrontendContribution = __decorate([
        inversify_1.injectable()
    ], QuickFileOpenFrontendContribution);
    return QuickFileOpenFrontendContribution;
}());
exports.QuickFileOpenFrontendContribution = QuickFileOpenFrontendContribution;


/***/ }),

/***/ "../node_modules/@theia/file-search/lib/browser/quick-file-open.js":
/*!*************************************************************************!*\
  !*** ../node_modules/@theia/file-search/lib/browser/quick-file-open.js ***!
  \*************************************************************************/
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
var filesystem_1 = __webpack_require__(/*! @theia/filesystem/lib/common/filesystem */ "../node_modules/@theia/filesystem/lib/common/filesystem.js");
var workspace_service_1 = __webpack_require__(/*! @theia/workspace/lib/browser/workspace-service */ "../node_modules/@theia/workspace/lib/browser/workspace-service.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var file_search_service_1 = __webpack_require__(/*! ../common/file-search-service */ "../node_modules/@theia/file-search/lib/common/file-search-service.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
var navigation_location_service_1 = __webpack_require__(/*! @theia/editor/lib/browser/navigation/navigation-location-service */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location-service.js");
var fuzzy = __webpack_require__(/*! fuzzy */ "../node_modules/fuzzy/lib/fuzzy.js");
exports.quickFileOpen = {
    id: 'file-search.openFile',
    label: 'Open File...'
};
var QuickFileOpenService = /** @class */ (function () {
    function QuickFileOpenService() {
        /**
         * Whether to hide .gitignored (and other ignored) files.
         */
        this.hideIgnoredFiles = true;
        /**
         * Whether the dialog is currently open.
         */
        this.isOpen = false;
        /**
         * The current lookFor string input by the user.
         */
        this.currentLookFor = '';
        this.prefix = '...';
        this.cancelIndicator = new common_1.CancellationTokenSource();
    }
    Object.defineProperty(QuickFileOpenService.prototype, "description", {
        get: function () {
            return 'Open File';
        },
        enumerable: true,
        configurable: true
    });
    QuickFileOpenService.prototype.getModel = function () {
        return this;
    };
    QuickFileOpenService.prototype.getOptions = function () {
        var _this = this;
        var placeholder = 'File name to search.';
        var keybinding = this.getKeyCommand();
        if (keybinding) {
            placeholder += " (Press " + keybinding + " to show/hide ignored files)";
        }
        return {
            placeholder: placeholder,
            fuzzyMatchLabel: true,
            fuzzyMatchDescription: true,
            onClose: function () {
                _this.isOpen = false;
                _this.cancelIndicator.cancel();
            }
        };
    };
    QuickFileOpenService.prototype.isEnabled = function () {
        return this.workspaceService.opened;
    };
    QuickFileOpenService.prototype.open = function () {
        // Triggering the keyboard shortcut while the dialog is open toggles
        // showing the ignored files.
        if (this.isOpen) {
            this.hideIgnoredFiles = !this.hideIgnoredFiles;
        }
        else {
            this.hideIgnoredFiles = true;
            this.currentLookFor = '';
            this.isOpen = true;
        }
        this.quickOpenService.open(this.currentLookFor);
    };
    /**
     * Get a string (suitable to show to the user) representing the keyboard
     * shortcut used to open the quick file open menu.
     */
    QuickFileOpenService.prototype.getKeyCommand = function () {
        var keyCommand = this.keybindingRegistry.getKeybindingsForCommand(exports.quickFileOpen.id);
        if (keyCommand) {
            // We only consider the first keybinding.
            var accel = browser_1.Keybinding.acceleratorFor(keyCommand[0], '+');
            return accel.join(' ');
        }
        return undefined;
    };
    QuickFileOpenService.prototype.onType = function (lookFor, acceptor) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, workspaceFolder, token, rootUri, root, alreadyCollected, recentlyUsedItems, locations, locations_1, locations_1_1, location_1, uriString, _b, _c, e_1_1, handler;
            var _this = this;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        workspaceFolder = this.workspaceService.tryGetRoots()[0];
                        if (!workspaceFolder) {
                            return [2 /*return*/];
                        }
                        this.currentLookFor = lookFor;
                        this.cancelIndicator.cancel();
                        this.cancelIndicator = new common_1.CancellationTokenSource();
                        token = this.cancelIndicator.token;
                        rootUri = workspaceFolder.uri;
                        root = new uri_1.default(rootUri);
                        alreadyCollected = new Set();
                        recentlyUsedItems = [];
                        locations = __spread(this.navigationLocationService.locations()).reverse();
                        _d.label = 1;
                    case 1:
                        _d.trys.push([1, 6, 7, 8]);
                        locations_1 = __values(locations), locations_1_1 = locations_1.next();
                        _d.label = 2;
                    case 2:
                        if (!!locations_1_1.done) return [3 /*break*/, 5];
                        location_1 = locations_1_1.value;
                        uriString = location_1.uri.toString();
                        if (!(!alreadyCollected.has(uriString) && fuzzy.test(lookFor, uriString))) return [3 /*break*/, 4];
                        _c = (_b = recentlyUsedItems).push;
                        return [4 /*yield*/, this.toItem(location_1.uri, recentlyUsedItems.length === 0 ? 'recently opened' : undefined)];
                    case 3:
                        _c.apply(_b, [_d.sent()]);
                        alreadyCollected.add(uriString);
                        _d.label = 4;
                    case 4:
                        locations_1_1 = locations_1.next();
                        return [3 /*break*/, 2];
                    case 5: return [3 /*break*/, 8];
                    case 6:
                        e_1_1 = _d.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 8];
                    case 7:
                        try {
                            if (locations_1_1 && !locations_1_1.done && (_a = locations_1.return)) _a.call(locations_1);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 8:
                        if (lookFor.length > 0) {
                            handler = function (result) { return __awaiter(_this, void 0, void 0, function () {
                                var e_2, _a, fileSearchResultItems, result_1, result_1_1, p, uri, uriString, _b, _c, e_2_1;
                                return __generator(this, function (_d) {
                                    switch (_d.label) {
                                        case 0:
                                            if (!!token.isCancellationRequested) return [3 /*break*/, 9];
                                            fileSearchResultItems = [];
                                            _d.label = 1;
                                        case 1:
                                            _d.trys.push([1, 6, 7, 8]);
                                            result_1 = __values(result), result_1_1 = result_1.next();
                                            _d.label = 2;
                                        case 2:
                                            if (!!result_1_1.done) return [3 /*break*/, 5];
                                            p = result_1_1.value;
                                            uri = root.withPath(root.path.join(p));
                                            uriString = uri.toString();
                                            if (!!alreadyCollected.has(uriString)) return [3 /*break*/, 4];
                                            _c = (_b = fileSearchResultItems).push;
                                            return [4 /*yield*/, this.toItem(uri, fileSearchResultItems.length === 0 ? 'file results' : undefined)];
                                        case 3:
                                            _c.apply(_b, [_d.sent()]);
                                            alreadyCollected.add(uriString);
                                            _d.label = 4;
                                        case 4:
                                            result_1_1 = result_1.next();
                                            return [3 /*break*/, 2];
                                        case 5: return [3 /*break*/, 8];
                                        case 6:
                                            e_2_1 = _d.sent();
                                            e_2 = { error: e_2_1 };
                                            return [3 /*break*/, 8];
                                        case 7:
                                            try {
                                                if (result_1_1 && !result_1_1.done && (_a = result_1.return)) _a.call(result_1);
                                            }
                                            finally { if (e_2) throw e_2.error; }
                                            return [7 /*endfinally*/];
                                        case 8:
                                            acceptor(__spread(recentlyUsedItems, fileSearchResultItems));
                                            _d.label = 9;
                                        case 9: return [2 /*return*/];
                                    }
                                });
                            }); };
                            this.fileSearchService.find(lookFor, {
                                rootUri: rootUri,
                                fuzzyMatch: true,
                                limit: 200,
                                useGitIgnore: this.hideIgnoredFiles,
                            }, token).then(handler);
                        }
                        else {
                            acceptor(recentlyUsedItems);
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    QuickFileOpenService.prototype.getRunFunction = function (uri) {
        var _this = this;
        return function (mode) {
            if (mode !== browser_1.QuickOpenMode.OPEN) {
                return false;
            }
            _this.openerService.getOpener(uri).then(function (opener) { return opener.open(uri); });
            return true;
        };
    };
    QuickFileOpenService.prototype.toItem = function (uriOrString, group) {
        return __awaiter(this, void 0, void 0, function () {
            var uri, options, _a;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        uri = uriOrString instanceof uri_1.default ? uriOrString : new uri_1.default(uriOrString);
                        _a = {
                            label: this.labelProvider.getName(uri)
                        };
                        return [4 /*yield*/, this.labelProvider.getIcon(uri)];
                    case 1:
                        options = (_a.iconClass = (_b.sent()) + ' file-icon',
                            _a.description = this.labelProvider.getLongName(uri.parent),
                            _a.tooltip = uri.path.toString(),
                            _a.uri = uri,
                            _a.hidden = false,
                            _a.run = this.getRunFunction(uri),
                            _a);
                        if (group) {
                            return [2 /*return*/, new browser_1.QuickOpenGroupItem(__assign({}, options, { groupLabel: group }))];
                        }
                        else {
                            return [2 /*return*/, new browser_1.QuickOpenItem(options)];
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(browser_1.KeybindingRegistry),
        __metadata("design:type", browser_1.KeybindingRegistry)
    ], QuickFileOpenService.prototype, "keybindingRegistry", void 0);
    __decorate([
        inversify_1.inject(filesystem_1.FileSystem),
        __metadata("design:type", Object)
    ], QuickFileOpenService.prototype, "fileSystem", void 0);
    __decorate([
        inversify_1.inject(workspace_service_1.WorkspaceService),
        __metadata("design:type", workspace_service_1.WorkspaceService)
    ], QuickFileOpenService.prototype, "workspaceService", void 0);
    __decorate([
        inversify_1.inject(browser_1.OpenerService),
        __metadata("design:type", Object)
    ], QuickFileOpenService.prototype, "openerService", void 0);
    __decorate([
        inversify_1.inject(browser_1.PrefixQuickOpenService),
        __metadata("design:type", browser_1.PrefixQuickOpenService)
    ], QuickFileOpenService.prototype, "quickOpenService", void 0);
    __decorate([
        inversify_1.inject(file_search_service_1.FileSearchService),
        __metadata("design:type", Object)
    ], QuickFileOpenService.prototype, "fileSearchService", void 0);
    __decorate([
        inversify_1.inject(label_provider_1.LabelProvider),
        __metadata("design:type", label_provider_1.LabelProvider)
    ], QuickFileOpenService.prototype, "labelProvider", void 0);
    __decorate([
        inversify_1.inject(navigation_location_service_1.NavigationLocationService),
        __metadata("design:type", navigation_location_service_1.NavigationLocationService)
    ], QuickFileOpenService.prototype, "navigationLocationService", void 0);
    QuickFileOpenService = __decorate([
        inversify_1.injectable()
    ], QuickFileOpenService);
    return QuickFileOpenService;
}());
exports.QuickFileOpenService = QuickFileOpenService;


/***/ }),

/***/ "../node_modules/@theia/file-search/lib/common/file-search-service.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/file-search/lib/common/file-search-service.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
exports.fileSearchServicePath = '/services/search';
exports.FileSearchService = Symbol('FileSearchService');


/***/ })

}]);
//# sourceMappingURL=36.bundle.js.map