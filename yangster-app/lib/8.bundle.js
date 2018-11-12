(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[8],{

/***/ "../node_modules/@theia/languages/lib/browser/language-client-contribution.js":
/*!************************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/language-client-contribution.js ***!
  \************************************************************************************/
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
// tslint:disable:no-any
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var language_client_services_1 = __webpack_require__(/*! ./language-client-services */ "../node_modules/@theia/languages/lib/browser/language-client-services.js");
var language_client_factory_1 = __webpack_require__(/*! ./language-client-factory */ "../node_modules/@theia/languages/lib/browser/language-client-factory.js");
var browser_2 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
exports.LanguageClientContribution = Symbol('LanguageClientContribution');
var BaseLanguageClientContribution = /** @class */ (function () {
    function BaseLanguageClientContribution(workspace, languages, languageClientFactory) {
        this.workspace = workspace;
        this.languages = languages;
        this.languageClientFactory = languageClientFactory;
        this.toDeactivate = new common_1.DisposableCollection();
        this.toRestart = new common_1.DisposableCollection();
        this.waitForReady();
    }
    Object.defineProperty(BaseLanguageClientContribution.prototype, "languageClient", {
        get: function () {
            return this._languageClient ? Promise.resolve(this._languageClient) : this.ready;
        },
        enumerable: true,
        configurable: true
    });
    // tslint:disable-next-line:no-any
    BaseLanguageClientContribution.prototype.waitForActivation = function (app) {
        var _this = this;
        // tslint:disable-next-line:no-any
        var activationPromises = [];
        var workspaceContains = this.workspaceContains;
        if (workspaceContains.length !== 0) {
            activationPromises.push(this.waitForItemInWorkspace());
        }
        var documentSelector = this.documentSelector;
        if (documentSelector) {
            activationPromises.push(this.waitForOpenTextDocument(documentSelector));
        }
        if (activationPromises.length !== 0) {
            return Promise.all([
                this.workspace.ready,
                Promise.race(activationPromises.map(function (p) { return new Promise(function (resolve) { return __awaiter(_this, void 0, void 0, function () {
                    var e_1;
                    return __generator(this, function (_a) {
                        switch (_a.label) {
                            case 0:
                                _a.trys.push([0, 2, , 3]);
                                return [4 /*yield*/, p];
                            case 1:
                                _a.sent();
                                resolve();
                                return [3 /*break*/, 3];
                            case 2:
                                e_1 = _a.sent();
                                console.error(e_1);
                                return [3 /*break*/, 3];
                            case 3: return [2 /*return*/];
                        }
                    });
                }); }); }))
            ]);
        }
        return this.workspace.ready;
    };
    BaseLanguageClientContribution.prototype.activate = function () {
        if (this.toDeactivate.disposed) {
            this.doActivate(this.toDeactivate);
        }
        return this.toDeactivate;
    };
    BaseLanguageClientContribution.prototype.deactivate = function () {
        this.toDeactivate.dispose();
    };
    BaseLanguageClientContribution.prototype.doActivate = function (toDeactivate) {
        var _this = this;
        var options = {};
        toDeactivate.push(common_1.Disposable.create(function () { return options.reconnecting = false; }));
        this.connectionProvider.listen({
            path: language_client_services_1.LanguageContribution.getPath(this),
            onConnection: function (messageConnection) {
                if (toDeactivate.disposed) {
                    messageConnection.dispose();
                    return;
                }
                var languageClient = _this.createLanguageClient(messageConnection);
                _this.onWillStart(languageClient);
                toDeactivate.pushAll([
                    messageConnection,
                    _this.toRestart.push(common_1.Disposable.create(function () { return __awaiter(_this, void 0, void 0, function () {
                        return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0: return [4 /*yield*/, languageClient.onReady()];
                                case 1:
                                    _a.sent();
                                    languageClient.stop();
                                    return [2 /*return*/];
                            }
                        });
                    }); })),
                    languageClient.start()
                ]);
            }
        }, options);
    };
    Object.defineProperty(BaseLanguageClientContribution.prototype, "running", {
        get: function () {
            return !this.toDeactivate.disposed && this.state === language_client_services_1.State.Running;
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClientContribution.prototype.restart = function () {
        this.toRestart.dispose();
    };
    BaseLanguageClientContribution.prototype.onWillStart = function (languageClient) {
        var _this = this;
        languageClient.onDidChangeState(function (_a) {
            var newState = _a.newState;
            _this.state = newState;
        });
        languageClient.onReady().then(function () { return _this.onReady(languageClient); });
    };
    BaseLanguageClientContribution.prototype.onReady = function (languageClient) {
        this._languageClient = languageClient;
        this.resolveReady(this._languageClient);
        this.waitForReady();
    };
    BaseLanguageClientContribution.prototype.waitForReady = function () {
        var _this = this;
        this.ready = new Promise(function (resolve) {
            return _this.resolveReady = resolve;
        });
    };
    BaseLanguageClientContribution.prototype.createLanguageClient = function (connection) {
        var clientOptions = this.createOptions();
        return this.languageClientFactory.get(this, clientOptions, connection);
    };
    BaseLanguageClientContribution.prototype.createOptions = function () {
        var _this = this;
        var _a = this, id = _a.id, documentSelector = _a.documentSelector, fileEvents = _a.fileEvents, configurationSection = _a.configurationSection, initializationOptions = _a.initializationOptions;
        return {
            documentSelector: documentSelector,
            synchronize: { fileEvents: fileEvents, configurationSection: configurationSection },
            initializationFailedHandler: function (err) { return _this.handleInitializationFailed(err); },
            diagnosticCollectionName: id,
            initializationOptions: initializationOptions
        };
    };
    BaseLanguageClientContribution.prototype.handleInitializationFailed = function (err) {
        var _this = this;
        this.deactivate();
        var detail = err instanceof Error ? ": " + err.message : '.';
        this.messageService.error("Failed to start " + this.name + " language server" + detail, 'Retry').then(function (result) {
            if (result) {
                _this.activate();
            }
        });
        return false;
    };
    Object.defineProperty(BaseLanguageClientContribution.prototype, "initializationOptions", {
        // tslint:disable-next-line:no-any
        get: function () {
            return undefined;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClientContribution.prototype, "configurationSection", {
        get: function () {
            return undefined;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClientContribution.prototype, "workspaceContains", {
        get: function () {
            return [];
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClientContribution.prototype, "documentSelector", {
        get: function () {
            return [this.id];
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClientContribution.prototype, "fileEvents", {
        get: function () {
            return this._fileEvents = this._fileEvents || this.createFileEvents();
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClientContribution.prototype.createFileEvents = function () {
        var e_2, _a;
        var watchers = [];
        if (this.workspace.createFileSystemWatcher) {
            try {
                for (var _b = __values(this.globPatterns), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var globPattern = _c.value;
                    watchers.push(this.workspace.createFileSystemWatcher(globPattern));
                }
            }
            catch (e_2_1) { e_2 = { error: e_2_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_2) throw e_2.error; }
            }
        }
        return watchers;
    };
    Object.defineProperty(BaseLanguageClientContribution.prototype, "globPatterns", {
        get: function () {
            return [];
        },
        enumerable: true,
        configurable: true
    });
    /**
     * Check to see if one of the paths is in the current workspace.
     */
    // tslint:disable-next-line:no-any
    BaseLanguageClientContribution.prototype.waitForItemInWorkspace = function () {
        return __awaiter(this, void 0, void 0, function () {
            var doesContain;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.workspaceService.containsSome(this.workspaceContains)];
                    case 1:
                        doesContain = _a.sent();
                        if (!doesContain) {
                            return [2 /*return*/, new Promise(function (resolve) { })];
                        }
                        return [2 /*return*/, doesContain];
                }
            });
        });
    };
    // FIXME move it to the workspace
    BaseLanguageClientContribution.prototype.waitForOpenTextDocument = function (selector) {
        var _this = this;
        var document = this.workspace.textDocuments.filter(function (doc) {
            return _this.languages.match(selector, doc);
        })[0];
        if (document !== undefined) {
            return Promise.resolve(document);
        }
        return new Promise(function (resolve) {
            var disposable = _this.workspace.onDidOpenTextDocument(function (doc) {
                if (_this.languages.match(selector, doc)) {
                    disposable.dispose();
                    resolve(doc);
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(core_1.MessageService),
        __metadata("design:type", core_1.MessageService)
    ], BaseLanguageClientContribution.prototype, "messageService", void 0);
    __decorate([
        inversify_1.inject(core_1.CommandRegistry),
        __metadata("design:type", core_1.CommandRegistry)
    ], BaseLanguageClientContribution.prototype, "registry", void 0);
    __decorate([
        inversify_1.inject(browser_2.WorkspaceService),
        __metadata("design:type", browser_2.WorkspaceService)
    ], BaseLanguageClientContribution.prototype, "workspaceService", void 0);
    __decorate([
        inversify_1.inject(browser_1.WebSocketConnectionProvider),
        __metadata("design:type", browser_1.WebSocketConnectionProvider)
    ], BaseLanguageClientContribution.prototype, "connectionProvider", void 0);
    BaseLanguageClientContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(language_client_services_1.Workspace)),
        __param(1, inversify_1.inject(language_client_services_1.Languages)),
        __param(2, inversify_1.inject(language_client_factory_1.LanguageClientFactory)),
        __metadata("design:paramtypes", [Object, Object, language_client_factory_1.LanguageClientFactory])
    ], BaseLanguageClientContribution);
    return BaseLanguageClientContribution;
}());
exports.BaseLanguageClientContribution = BaseLanguageClientContribution;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/language-client-factory.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/language-client-factory.js ***!
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var monaco_languageclient_1 = __webpack_require__(/*! monaco-languageclient */ "../node_modules/monaco-languageclient/lib/index.js");
var language_client_services_1 = __webpack_require__(/*! ./language-client-services */ "../node_modules/@theia/languages/lib/browser/language-client-services.js");
var LanguageClientFactory = /** @class */ (function () {
    function LanguageClientFactory(workspace, languages, window) {
        this.workspace = workspace;
        this.languages = languages;
        this.window = window;
        language_client_services_1.Services.install({
            workspace: workspace,
            languages: languages,
            window: window,
            commands: {
                registerCommand: this.registerCommand.bind(this)
            }
        });
    }
    // tslint:disable-next-line:no-any
    LanguageClientFactory.prototype.registerCommand = function (id, callback, thisArg) {
        var execute = callback.bind(thisArg);
        return this.registry.registerCommand({ id: id }, { execute: execute });
    };
    LanguageClientFactory.prototype.get = function (contribution, clientOptions, connection) {
        var _this = this;
        if (clientOptions.revealOutputChannelOn === undefined) {
            clientOptions.revealOutputChannelOn = monaco_languageclient_1.RevealOutputChannelOn.Never;
        }
        if (!clientOptions.errorHandler) {
            clientOptions.errorHandler = {
                // ignore connection errors
                error: function () { return monaco_languageclient_1.ErrorAction.Continue; },
                closed: function () { return monaco_languageclient_1.CloseAction.DoNotRestart; }
            };
        }
        var initializationFailedHandler = clientOptions.initializationFailedHandler;
        clientOptions.initializationFailedHandler = function (e) { return !!initializationFailedHandler && initializationFailedHandler(e); };
        connection.onDispose(function () { return initializationFailedHandler = function () { return false; }; });
        return new language_client_services_1.MonacoLanguageClient({
            id: contribution.id,
            name: contribution.name,
            clientOptions: clientOptions,
            connectionProvider: {
                get: function (errorHandler, closeHandler) { return __awaiter(_this, void 0, void 0, function () { return __generator(this, function (_a) {
                    return [2 /*return*/, language_client_services_1.createConnection(connection, errorHandler, closeHandler)];
                }); }); }
            }
        });
    };
    __decorate([
        inversify_1.inject(common_1.CommandRegistry),
        __metadata("design:type", common_1.CommandRegistry)
    ], LanguageClientFactory.prototype, "registry", void 0);
    LanguageClientFactory = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(language_client_services_1.Workspace)),
        __param(1, inversify_1.inject(language_client_services_1.Languages)),
        __param(2, inversify_1.inject(language_client_services_1.Window)),
        __metadata("design:paramtypes", [Object, Object, Object])
    ], LanguageClientFactory);
    return LanguageClientFactory;
}());
exports.LanguageClientFactory = LanguageClientFactory;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/language-client-provider-impl.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/language-client-provider-impl.js ***!
  \*************************************************************************************/
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var language_client_contribution_1 = __webpack_require__(/*! ./language-client-contribution */ "../node_modules/@theia/languages/lib/browser/language-client-contribution.js");
var LanguageClientProviderImpl = /** @class */ (function () {
    function LanguageClientProviderImpl() {
    }
    LanguageClientProviderImpl.prototype.getLanguageClient = function (languageId) {
        return __awaiter(this, void 0, void 0, function () {
            var contribution;
            return __generator(this, function (_a) {
                contribution = this.getLanguageContribution(languageId);
                if (contribution) {
                    return [2 /*return*/, contribution.languageClient];
                }
                return [2 /*return*/];
            });
        });
    };
    LanguageClientProviderImpl.prototype.getLanguageContribution = function (languageId) {
        var e_1, _a;
        var contributions = this.contributions.getContributions();
        if (contributions) {
            try {
                for (var contributions_1 = __values(contributions), contributions_1_1 = contributions_1.next(); !contributions_1_1.done; contributions_1_1 = contributions_1.next()) {
                    var contribution = contributions_1_1.value;
                    if (contribution.id === languageId) {
                        return contribution;
                    }
                }
            }
            catch (e_1_1) { e_1 = { error: e_1_1 }; }
            finally {
                try {
                    if (contributions_1_1 && !contributions_1_1.done && (_a = contributions_1.return)) _a.call(contributions_1);
                }
                finally { if (e_1) throw e_1.error; }
            }
        }
        return undefined;
    };
    __decorate([
        inversify_1.inject(common_1.ContributionProvider), inversify_1.named(language_client_contribution_1.LanguageClientContribution),
        __metadata("design:type", Object)
    ], LanguageClientProviderImpl.prototype, "contributions", void 0);
    LanguageClientProviderImpl = __decorate([
        inversify_1.injectable()
    ], LanguageClientProviderImpl);
    return LanguageClientProviderImpl;
}());
exports.LanguageClientProviderImpl = LanguageClientProviderImpl;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/language-client-provider.js":
/*!********************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/language-client-provider.js ***!
  \********************************************************************************/
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
exports.LanguageClientProvider = Symbol('LanguageClientProvider');


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/language-client-services.js":
/*!********************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/language-client-services.js ***!
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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(/*! monaco-languageclient */ "../node_modules/monaco-languageclient/lib/index.js"));
__export(__webpack_require__(/*! ../common */ "../node_modules/@theia/languages/lib/common/index.js"));
exports.Languages = Symbol('Languages');
exports.Workspace = Symbol('Workspace');
exports.Commands = Symbol('Commands');
exports.Window = Symbol('Window');
exports.IConnectionProvider = Symbol('IConnectionProvider');
exports.ILanguageClient = Symbol('ILanguageClient');


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/languages-frontend-contribution.js":
/*!***************************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/languages-frontend-contribution.js ***!
  \***************************************************************************************/
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var language_client_contribution_1 = __webpack_require__(/*! ./language-client-contribution */ "../node_modules/@theia/languages/lib/browser/language-client-contribution.js");
var LanguagesFrontendContribution = /** @class */ (function () {
    function LanguagesFrontendContribution() {
    }
    LanguagesFrontendContribution.prototype.onStart = function (app) {
        var e_1, _a;
        var _loop_1 = function (contribution) {
            contribution.waitForActivation(app).then(function () {
                return contribution.activate(app);
            });
        };
        try {
            for (var _b = __values(this.contributions.getContributions()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var contribution = _c.value;
                _loop_1(contribution);
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
    LanguagesFrontendContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        var e_2, _a;
        var _loop_2 = function (contribution) {
            commands.registerCommand({
                id: contribution.id + ".server.start",
                label: contribution.name + ": Start Language Server"
            }, {
                execute: function () { return contribution.activate(_this.app); },
                isEnabled: function () { return !contribution.running; },
                isVisible: function () { return !contribution.running; },
            });
            commands.registerCommand({
                id: contribution.id + ".server.stop",
                label: contribution.name + ": Stop Language Server"
            }, {
                execute: function () { return contribution.deactivate(); },
                isEnabled: function () { return contribution.running; },
                isVisible: function () { return contribution.running; },
            });
            commands.registerCommand({
                id: contribution.id + ".server.restart",
                label: contribution.name + ": Restart Language Server"
            }, {
                execute: function () { return contribution.restart(); },
                isEnabled: function () { return contribution.running; },
                isVisible: function () { return contribution.running; },
            });
        };
        try {
            for (var _b = __values(this.contributions.getContributions()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var contribution = _c.value;
                _loop_2(contribution);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
    };
    __decorate([
        inversify_1.inject(browser_1.FrontendApplication),
        __metadata("design:type", browser_1.FrontendApplication)
    ], LanguagesFrontendContribution.prototype, "app", void 0);
    __decorate([
        inversify_1.inject(common_1.ContributionProvider), inversify_1.named(language_client_contribution_1.LanguageClientContribution),
        __metadata("design:type", Object)
    ], LanguagesFrontendContribution.prototype, "contributions", void 0);
    LanguagesFrontendContribution = __decorate([
        inversify_1.injectable()
    ], LanguagesFrontendContribution);
    return LanguagesFrontendContribution;
}());
exports.LanguagesFrontendContribution = LanguagesFrontendContribution;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/languages-frontend-module.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/languages-frontend-module.js ***!
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var language_client_services_1 = __webpack_require__(/*! ./language-client-services */ "../node_modules/@theia/languages/lib/browser/language-client-services.js");
var window_impl_1 = __webpack_require__(/*! ./window-impl */ "../node_modules/@theia/languages/lib/browser/window-impl.js");
var language_client_factory_1 = __webpack_require__(/*! ./language-client-factory */ "../node_modules/@theia/languages/lib/browser/language-client-factory.js");
var languages_frontend_contribution_1 = __webpack_require__(/*! ./languages-frontend-contribution */ "../node_modules/@theia/languages/lib/browser/languages-frontend-contribution.js");
var language_client_contribution_1 = __webpack_require__(/*! ./language-client-contribution */ "../node_modules/@theia/languages/lib/browser/language-client-contribution.js");
var workspace_symbols_1 = __webpack_require__(/*! ./workspace-symbols */ "../node_modules/@theia/languages/lib/browser/workspace-symbols.js");
var language_client_provider_1 = __webpack_require__(/*! ./language-client-provider */ "../node_modules/@theia/languages/lib/browser/language-client-provider.js");
var language_client_provider_impl_1 = __webpack_require__(/*! ./language-client-provider-impl */ "../node_modules/@theia/languages/lib/browser/language-client-provider-impl.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    var e_1, _a;
    bind(language_client_services_1.Window).to(window_impl_1.WindowImpl).inSingletonScope();
    bind(language_client_factory_1.LanguageClientFactory).toSelf().inSingletonScope();
    common_1.bindContributionProvider(bind, language_client_contribution_1.LanguageClientContribution);
    bind(languages_frontend_contribution_1.LanguagesFrontendContribution).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(languages_frontend_contribution_1.LanguagesFrontendContribution);
    bind(common_1.CommandContribution).toService(languages_frontend_contribution_1.LanguagesFrontendContribution);
    bind(workspace_symbols_1.WorkspaceSymbolCommand).toSelf().inSingletonScope();
    try {
        for (var _b = __values([common_1.CommandContribution, browser_1.KeybindingContribution, browser_1.QuickOpenContribution]), _c = _b.next(); !_c.done; _c = _b.next()) {
            var identifier = _c.value;
            bind(identifier).toService(workspace_symbols_1.WorkspaceSymbolCommand);
        }
    }
    catch (e_1_1) { e_1 = { error: e_1_1 }; }
    finally {
        try {
            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
        }
        finally { if (e_1) throw e_1.error; }
    }
    bind(language_client_provider_impl_1.LanguageClientProviderImpl).toSelf().inSingletonScope();
    bind(language_client_provider_1.LanguageClientProvider).toService(language_client_provider_impl_1.LanguageClientProviderImpl);
});


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/window-impl.js":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/window-impl.js ***!
  \*******************************************************************/
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var services_1 = __webpack_require__(/*! monaco-languageclient/lib/services */ "../node_modules/monaco-languageclient/lib/services.js");
var output_channel_1 = __webpack_require__(/*! @theia/output/lib/common/output-channel */ "../node_modules/@theia/output/lib/common/output-channel.js");
var output_contribution_1 = __webpack_require__(/*! @theia/output/lib/browser/output-contribution */ "../node_modules/@theia/output/lib/browser/output-contribution.js");
var WindowImpl = /** @class */ (function () {
    function WindowImpl() {
    }
    WindowImpl.prototype.showMessage = function (type, message) {
        var actions = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            actions[_i - 2] = arguments[_i];
        }
        var _a, _b, _c, _d;
        var originalActions = new Map((actions || []).map(function (action) { return [action.title, action]; }));
        var actionTitles = (actions || []).map(function (action) { return action.title; });
        var mapActionType = function (result) {
            if (!!result) {
                return originalActions.get(result);
            }
            return undefined;
        };
        if (type === services_1.MessageType.Error) {
            return (_a = this.messageService).error.apply(_a, __spread([message], actionTitles)).then(mapActionType);
        }
        if (type === services_1.MessageType.Warning) {
            return (_b = this.messageService).warn.apply(_b, __spread([message], actionTitles)).then(mapActionType);
        }
        if (type === services_1.MessageType.Info) {
            return (_c = this.messageService).info.apply(_c, __spread([message], actionTitles)).then(mapActionType);
        }
        if (type === services_1.MessageType.Log) {
            return (_d = this.messageService).log.apply(_d, __spread([message], actionTitles)).then(mapActionType);
        }
        return Promise.resolve(undefined);
    };
    WindowImpl.prototype.createOutputChannel = function (name) {
        var _this = this;
        var outputChannel = this.outputChannelManager.getChannel(name);
        return {
            append: outputChannel.append.bind(outputChannel),
            appendLine: outputChannel.appendLine.bind(outputChannel),
            show: function (preserveFocus) { return __awaiter(_this, void 0, void 0, function () {
                var options, activate, reveal;
                return __generator(this, function (_a) {
                    switch (_a.label) {
                        case 0:
                            options = Object.assign({
                                preserveFocus: false,
                            }, { preserveFocus: preserveFocus });
                            activate = !options.preserveFocus;
                            reveal = options.preserveFocus;
                            return [4 /*yield*/, this.outputContribution.openView({ activate: activate, reveal: reveal })];
                        case 1:
                            _a.sent();
                            outputChannel.setVisibility(true);
                            return [2 /*return*/];
                    }
                });
            }); },
            dispose: function () {
                _this.outputChannelManager.deleteChannel(outputChannel.name);
            }
        };
    };
    __decorate([
        inversify_1.inject(common_1.MessageService),
        __metadata("design:type", common_1.MessageService)
    ], WindowImpl.prototype, "messageService", void 0);
    __decorate([
        inversify_1.inject(output_channel_1.OutputChannelManager),
        __metadata("design:type", output_channel_1.OutputChannelManager)
    ], WindowImpl.prototype, "outputChannelManager", void 0);
    __decorate([
        inversify_1.inject(output_contribution_1.OutputContribution),
        __metadata("design:type", output_contribution_1.OutputContribution)
    ], WindowImpl.prototype, "outputContribution", void 0);
    WindowImpl = __decorate([
        inversify_1.injectable()
    ], WindowImpl);
    return WindowImpl;
}());
exports.WindowImpl = WindowImpl;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/workspace-symbols.js":
/*!*************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/workspace-symbols.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var language_client_services_1 = __webpack_require__(/*! ./language-client-services */ "../node_modules/@theia/languages/lib/browser/language-client-services.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var vscode_languageserver_types_1 = __webpack_require__(/*! vscode-languageserver-types */ "../node_modules/vscode-languageserver-types/lib/esm/main.js");
var WorkspaceSymbolCommand = /** @class */ (function () {
    function WorkspaceSymbolCommand(languages, openerService, quickOpenService, selectionService) {
        this.languages = languages;
        this.openerService = openerService;
        this.quickOpenService = quickOpenService;
        this.selectionService = selectionService;
        this.prefix = '#';
        this.description = 'Go to symbol in workspace';
        this.command = {
            id: 'languages.workspace.symbol',
            label: 'Open Workspace Symbol...'
        };
        this.cancellationSource = new core_1.CancellationTokenSource();
    }
    WorkspaceSymbolCommand.prototype.isEnabled = function () {
        return this.languages.workspaceSymbolProviders !== undefined;
    };
    WorkspaceSymbolCommand.prototype.execute = function () {
        this.quickOpenService.open(this.prefix);
    };
    WorkspaceSymbolCommand.prototype.getModel = function () {
        return this;
    };
    WorkspaceSymbolCommand.prototype.getOptions = function () {
        var _this = this;
        return {
            fuzzyMatchLabel: true,
            showItemsWithoutHighlight: true,
            onClose: function () {
                _this.cancellationSource.cancel();
            }
        };
    };
    WorkspaceSymbolCommand.prototype.registerCommands = function (commands) {
        commands.registerCommand(this.command, this);
    };
    WorkspaceSymbolCommand.prototype.registerKeybindings = function (keybindings) {
        keybindings.registerKeybinding({
            command: this.command.id,
            keybinding: 'ctrlcmd+o',
        });
    };
    WorkspaceSymbolCommand.prototype.registerQuickOpenHandlers = function (handlers) {
        handlers.registerHandler(this);
    };
    WorkspaceSymbolCommand.prototype.onType = function (lookFor, acceptor) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, newCancellationSource_1, param, items_1, _b, _c, provider;
            var _this = this;
            return __generator(this, function (_d) {
                if (this.languages.workspaceSymbolProviders) {
                    this.cancellationSource.cancel();
                    newCancellationSource_1 = new core_1.CancellationTokenSource();
                    this.cancellationSource = newCancellationSource_1;
                    param = {
                        query: lookFor
                    };
                    items_1 = [];
                    try {
                        for (_b = __values(this.languages.workspaceSymbolProviders), _c = _b.next(); !_c.done; _c = _b.next()) {
                            provider = _c.value;
                            provider.provideWorkspaceSymbols(param, newCancellationSource_1.token).then(function (symbols) {
                                var e_2, _a;
                                if (symbols && !newCancellationSource_1.token.isCancellationRequested) {
                                    try {
                                        for (var symbols_1 = __values(symbols), symbols_1_1 = symbols_1.next(); !symbols_1_1.done; symbols_1_1 = symbols_1.next()) {
                                            var symbol = symbols_1_1.value;
                                            items_1.push(_this.createItem(symbol));
                                        }
                                    }
                                    catch (e_2_1) { e_2 = { error: e_2_1 }; }
                                    finally {
                                        try {
                                            if (symbols_1_1 && !symbols_1_1.done && (_a = symbols_1.return)) _a.call(symbols_1);
                                        }
                                        finally { if (e_2) throw e_2.error; }
                                    }
                                    if (items_1.length === 0) {
                                        items_1.push(new browser_1.QuickOpenItem({
                                            label: lookFor.length === 0 ? 'Type to search for symbols' : 'No symbols matching',
                                            run: function () { return false; }
                                        }));
                                    }
                                    acceptor(items_1);
                                }
                            });
                        }
                    }
                    catch (e_1_1) { e_1 = { error: e_1_1 }; }
                    finally {
                        try {
                            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                        }
                        finally { if (e_1) throw e_1.error; }
                    }
                }
                return [2 /*return*/];
            });
        });
    };
    WorkspaceSymbolCommand.prototype.createItem = function (sym) {
        var _this = this;
        var uri = new uri_1.default(sym.location.uri);
        var icon = SymbolKind[sym.kind].toLowerCase();
        var parent = sym.containerName;
        if (parent) {
            parent += ' - ';
        }
        parent = (parent || '') + uri.displayName;
        return new SimpleOpenItem(sym.name, icon, parent, uri.toString(), function () {
            _this.openerService.getOpener(uri).then(function (opener) { return opener.open(uri, {
                selection: vscode_languageserver_types_1.Range.create(sym.location.range.start, sym.location.range.start)
            }); });
        });
    };
    WorkspaceSymbolCommand = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(language_client_services_1.Languages)),
        __param(1, inversify_1.inject(browser_1.OpenerService)),
        __param(2, inversify_1.inject(browser_1.PrefixQuickOpenService)),
        __param(3, inversify_1.inject(core_1.SelectionService)),
        __metadata("design:paramtypes", [Object, Object, browser_1.PrefixQuickOpenService,
            core_1.SelectionService])
    ], WorkspaceSymbolCommand);
    return WorkspaceSymbolCommand;
}());
exports.WorkspaceSymbolCommand = WorkspaceSymbolCommand;
var SimpleOpenItem = /** @class */ (function (_super) {
    __extends(SimpleOpenItem, _super);
    function SimpleOpenItem(label, icon, parent, toolTip, onOpen, onSelect) {
        var _this = _super.call(this) || this;
        _this.label = label;
        _this.icon = icon;
        _this.parent = parent;
        _this.toolTip = toolTip;
        _this.onOpen = onOpen;
        _this.onSelect = onSelect;
        return _this;
    }
    SimpleOpenItem.prototype.getLabel = function () {
        return this.label;
    };
    SimpleOpenItem.prototype.isHidden = function () {
        return false;
    };
    SimpleOpenItem.prototype.getTooltip = function () {
        return this.toolTip;
    };
    SimpleOpenItem.prototype.getDescription = function () {
        return this.parent;
    };
    SimpleOpenItem.prototype.getIconClass = function () {
        return this.icon;
    };
    SimpleOpenItem.prototype.run = function (mode) {
        if (mode !== browser_1.QuickOpenMode.OPEN) {
            if (!this.onSelect) {
                return false;
            }
            this.onSelect();
            return true;
        }
        this.onOpen();
        return true;
    };
    return SimpleOpenItem;
}(browser_1.QuickOpenItem));
var SymbolKind;
(function (SymbolKind) {
    SymbolKind[SymbolKind["File"] = 1] = "File";
    SymbolKind[SymbolKind["Module"] = 2] = "Module";
    SymbolKind[SymbolKind["Namespace"] = 3] = "Namespace";
    SymbolKind[SymbolKind["Package"] = 4] = "Package";
    SymbolKind[SymbolKind["Class"] = 5] = "Class";
    SymbolKind[SymbolKind["Method"] = 6] = "Method";
    SymbolKind[SymbolKind["Property"] = 7] = "Property";
    SymbolKind[SymbolKind["Field"] = 8] = "Field";
    SymbolKind[SymbolKind["Constructor"] = 9] = "Constructor";
    SymbolKind[SymbolKind["Enum"] = 10] = "Enum";
    SymbolKind[SymbolKind["Interface"] = 11] = "Interface";
    SymbolKind[SymbolKind["Function"] = 12] = "Function";
    SymbolKind[SymbolKind["Variable"] = 13] = "Variable";
    SymbolKind[SymbolKind["Constant"] = 14] = "Constant";
    SymbolKind[SymbolKind["String"] = 15] = "String";
    SymbolKind[SymbolKind["Number"] = 16] = "Number";
    SymbolKind[SymbolKind["Boolean"] = 17] = "Boolean";
    SymbolKind[SymbolKind["Array"] = 18] = "Array";
})(SymbolKind || (SymbolKind = {}));


/***/ }),

/***/ "../node_modules/@theia/languages/lib/common/index.js":
/*!************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/common/index.js ***!
  \************************************************************/
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
__export(__webpack_require__(/*! ./language-contribution */ "../node_modules/@theia/languages/lib/common/language-contribution.js"));


/***/ }),

/***/ "../node_modules/@theia/languages/lib/common/language-contribution.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/common/language-contribution.js ***!
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
var LanguageContribution;
(function (LanguageContribution) {
    function getPath(contribution) {
        return '/services/languages/' + contribution.id;
    }
    LanguageContribution.getPath = getPath;
})(LanguageContribution = exports.LanguageContribution || (exports.LanguageContribution = {}));


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

/***/ "../node_modules/glob-to-regexp/index.js":
/*!***********************************************!*\
  !*** ../node_modules/glob-to-regexp/index.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = function (glob, opts) {
  if (typeof glob !== 'string') {
    throw new TypeError('Expected a string');
  }

  var str = String(glob);

  // The regexp we are building, as a string.
  var reStr = "";

  // Whether we are matching so called "extended" globs (like bash) and should
  // support single character matching, matching ranges of characters, group
  // matching, etc.
  var extended = opts ? !!opts.extended : false;

  // When globstar is _false_ (default), '/foo/*' is translated a regexp like
  // '^\/foo\/.*$' which will match any string beginning with '/foo/'
  // When globstar is _true_, '/foo/*' is translated to regexp like
  // '^\/foo\/[^/]*$' which will match any string beginning with '/foo/' BUT
  // which does not have a '/' to the right of it.
  // E.g. with '/foo/*' these will match: '/foo/bar', '/foo/bar.txt' but
  // these will not '/foo/bar/baz', '/foo/bar/baz.txt'
  // Lastely, when globstar is _true_, '/foo/**' is equivelant to '/foo/*' when
  // globstar is _false_
  var globstar = opts ? !!opts.globstar : false;

  // If we are doing extended matching, this boolean is true when we are inside
  // a group (eg {*.html,*.js}), and false otherwise.
  var inGroup = false;

  // RegExp flags (eg "i" ) to pass in to RegExp constructor.
  var flags = opts && typeof( opts.flags ) === "string" ? opts.flags : "";

  var c;
  for (var i = 0, len = str.length; i < len; i++) {
    c = str[i];

    switch (c) {
    case "\\":
    case "/":
    case "$":
    case "^":
    case "+":
    case ".":
    case "(":
    case ")":
    case "=":
    case "!":
    case "|":
      reStr += "\\" + c;
      break;

    case "?":
      if (extended) {
        reStr += ".";
	    break;
      }

    case "[":
    case "]":
      if (extended) {
        reStr += c;
	    break;
      }

    case "{":
      if (extended) {
        inGroup = true;
	    reStr += "(";
	    break;
      }

    case "}":
      if (extended) {
        inGroup = false;
	    reStr += ")";
	    break;
      }

    case ",":
      if (inGroup) {
        reStr += "|";
	    break;
      }
      reStr += "\\" + c;
      break;

    case "*":
      // Move over all consecutive "*"'s.
      // Also store the previous and next characters
      var prevChar = str[i - 1];
      var starCount = 1;
      while(str[i + 1] === "*") {
        starCount++;
        i++;
      }
      var nextChar = str[i + 1];

      if (!globstar) {
        // globstar is disabled, so treat any number of "*" as one
        reStr += ".*";
      } else {
        // globstar is enabled, so determine if this is a globstar segment
        var isGlobstar = starCount > 1                      // multiple "*"'s
          && (prevChar === "/" || prevChar === undefined)   // from the start of the segment
          && (nextChar === "/" || nextChar === undefined)   // to the end of the segment

        if (isGlobstar) {
          // it's a globstar, so match zero or more path segments
          reStr += "(?:[^/]*(?:\/|$))*";
          i++; // move over the "/"
        } else {
          // it's not a globstar, so only match one path segment
          reStr += "[^/]*";
        }
      }
      break;

    default:
      reStr += c;
    }
  }

  // When regexp 'g' flag is specified don't
  // constrain the regular expression with ^ & $
  if (!flags || !~flags.indexOf('g')) {
    reStr = "^" + reStr + "$";
  }

  return new RegExp(reStr, flags);
};


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/connection.js":
/*!***************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/connection.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
var main_1 = __webpack_require__(/*! vscode-languageserver-protocol/lib/main */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var Is = __webpack_require__(/*! vscode-languageserver-protocol/lib/utils/is */ "../node_modules/vscode-languageserver-protocol/lib/utils/is.js");
function createConnection(connection, errorHandler, closeHandler) {
    connection.onError(function (data) { errorHandler(data[0], data[1], data[2]); });
    connection.onClose(closeHandler);
    return {
        listen: function () { return connection.listen(); },
        sendRequest: function (type) {
            var params = [];
            for (var _i = 1; _i < arguments.length; _i++) {
                params[_i - 1] = arguments[_i];
            }
            return connection.sendRequest.apply(connection, [Is.string(type) ? type : type.method].concat(params));
        },
        onRequest: function (type, handler) { return connection.onRequest(Is.string(type) ? type : type.method, handler); },
        sendNotification: function (type, params) { return connection.sendNotification(Is.string(type) ? type : type.method, params); },
        onNotification: function (type, handler) { return connection.onNotification(Is.string(type) ? type : type.method, handler); },
        trace: function (value, tracer, sendNotification) {
            if (sendNotification === void 0) { sendNotification = false; }
            return connection.trace(value, tracer, sendNotification);
        },
        initialize: function (params) { return connection.sendRequest(main_1.InitializeRequest.type, params); },
        shutdown: function () { return connection.sendRequest(main_1.ShutdownRequest.type, undefined); },
        exit: function () { return connection.sendNotification(main_1.ExitNotification.type); },
        onLogMessage: function (handler) { return connection.onNotification(main_1.LogMessageNotification.type, handler); },
        onShowMessage: function (handler) { return connection.onNotification(main_1.ShowMessageNotification.type, handler); },
        onTelemetry: function (handler) { return connection.onNotification(main_1.TelemetryEventNotification.type, handler); },
        didChangeConfiguration: function (params) { return connection.sendNotification(main_1.DidChangeConfigurationNotification.type, params); },
        didChangeWatchedFiles: function (params) { return connection.sendNotification(main_1.DidChangeWatchedFilesNotification.type, params); },
        didOpenTextDocument: function (params) { return connection.sendNotification(main_1.DidOpenTextDocumentNotification.type, params); },
        didChangeTextDocument: function (params) { return connection.sendNotification(main_1.DidChangeTextDocumentNotification.type, params); },
        didCloseTextDocument: function (params) { return connection.sendNotification(main_1.DidCloseTextDocumentNotification.type, params); },
        didSaveTextDocument: function (params) { return connection.sendNotification(main_1.DidSaveTextDocumentNotification.type, params); },
        onDiagnostics: function (handler) { return connection.onNotification(main_1.PublishDiagnosticsNotification.type, handler); },
        dispose: function () { return connection.dispose(); }
    };
}
exports.createConnection = createConnection;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/console-window.js":
/*!*******************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/console-window.js ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
var ConsoleWindow = /** @class */ (function () {
    function ConsoleWindow() {
        this.channels = new Map();
    }
    ConsoleWindow.prototype.showMessage = function (type, message) {
        var actions = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            actions[_i - 2] = arguments[_i];
        }
        if (type === services_1.MessageType.Error) {
            console.error(message);
        }
        if (type === services_1.MessageType.Warning) {
            console.warn(message);
        }
        if (type === services_1.MessageType.Info) {
            console.info(message);
        }
        if (type === services_1.MessageType.Log) {
            console.log(message);
        }
        return Promise.resolve(undefined);
    };
    ConsoleWindow.prototype.createOutputChannel = function (name) {
        var existing = this.channels.get(name);
        if (existing) {
            return existing;
        }
        var channel = {
            append: function (value) {
                console.log(name + ': ' + value);
            },
            appendLine: function (line) {
                console.log(name + ': ' + line);
            },
            show: function () {
                // no-op
            },
            dispose: function () {
                // no-op
            }
        };
        this.channels.set(name, channel);
        return channel;
    };
    return ConsoleWindow;
}());
exports.ConsoleWindow = ConsoleWindow;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/disposable.js":
/*!***************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/disposable.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
exports.Disposable = services_1.Disposable;
var DisposableCollection = /** @class */ (function () {
    function DisposableCollection() {
        this.disposables = [];
    }
    DisposableCollection.prototype.dispose = function () {
        while (this.disposables.length !== 0) {
            this.disposables.pop().dispose();
        }
    };
    DisposableCollection.prototype.push = function (disposable) {
        var disposables = this.disposables;
        disposables.push(disposable);
        return {
            dispose: function () {
                var index = disposables.indexOf(disposable);
                if (index !== -1) {
                    disposables.splice(index, 1);
                }
            }
        };
    };
    return DisposableCollection;
}());
exports.DisposableCollection = DisposableCollection;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/index.js":
/*!**********************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/index.js ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
__export(__webpack_require__(/*! ./disposable */ "../node_modules/monaco-languageclient/lib/disposable.js"));
__export(__webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js"));
__export(__webpack_require__(/*! ./connection */ "../node_modules/monaco-languageclient/lib/connection.js"));
__export(__webpack_require__(/*! ./monaco-language-client */ "../node_modules/monaco-languageclient/lib/monaco-language-client.js"));
__export(__webpack_require__(/*! ./monaco-commands */ "../node_modules/monaco-languageclient/lib/monaco-commands.js"));
__export(__webpack_require__(/*! ./console-window */ "../node_modules/monaco-languageclient/lib/console-window.js"));
__export(__webpack_require__(/*! ./monaco-languages */ "../node_modules/monaco-languageclient/lib/monaco-languages.js"));
__export(__webpack_require__(/*! ./monaco-workspace */ "../node_modules/monaco-languageclient/lib/monaco-workspace.js"));
__export(__webpack_require__(/*! ./monaco-services */ "../node_modules/monaco-languageclient/lib/monaco-services.js"));
__export(__webpack_require__(/*! ./monaco-converter */ "../node_modules/monaco-languageclient/lib/monaco-converter.js"));


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-commands.js":
/*!********************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-commands.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var MonacoCommands = /** @class */ (function () {
    function MonacoCommands(editor) {
        this.editor = editor;
    }
    MonacoCommands.prototype.registerCommand = function (command, callback, thisArg) {
        return this.editor._commandService.addCommand({
            id: command,
            handler: function (_accessor) {
                var args = [];
                for (var _i = 1; _i < arguments.length; _i++) {
                    args[_i - 1] = arguments[_i];
                }
                return callback.apply(void 0, args);
            }
        });
    };
    return MonacoCommands;
}());
exports.MonacoCommands = MonacoCommands;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-converter.js":
/*!*********************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-converter.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

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
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var Is = __webpack_require__(/*! vscode-languageserver-protocol/lib/utils/is */ "../node_modules/vscode-languageserver-protocol/lib/utils/is.js");
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
var ProtocolDocumentLink;
(function (ProtocolDocumentLink) {
    function is(item) {
        return !!item && 'data' in item;
    }
    ProtocolDocumentLink.is = is;
})(ProtocolDocumentLink = exports.ProtocolDocumentLink || (exports.ProtocolDocumentLink = {}));
var ProtocolCodeLens;
(function (ProtocolCodeLens) {
    function is(item) {
        return !!item && 'data' in item;
    }
    ProtocolCodeLens.is = is;
})(ProtocolCodeLens = exports.ProtocolCodeLens || (exports.ProtocolCodeLens = {}));
var ProtocolCompletionItem;
(function (ProtocolCompletionItem) {
    function is(item) {
        return !!item && 'data' in item;
    }
    ProtocolCompletionItem.is = is;
})(ProtocolCompletionItem = exports.ProtocolCompletionItem || (exports.ProtocolCompletionItem = {}));
var MonacoToProtocolConverter = /** @class */ (function () {
    function MonacoToProtocolConverter() {
    }
    MonacoToProtocolConverter.prototype.asPosition = function (lineNumber, column) {
        var line = lineNumber === undefined || lineNumber === null ? undefined : lineNumber - 1;
        var character = column === undefined || column === null ? undefined : column - 1;
        return {
            line: line, character: character
        };
    };
    MonacoToProtocolConverter.prototype.asRange = function (range) {
        if (range === undefined) {
            return undefined;
        }
        if (range === null) {
            return null;
        }
        var start = this.asPosition(range.startLineNumber, range.startColumn);
        var end = this.asPosition(range.endLineNumber, range.endColumn);
        return {
            start: start, end: end
        };
    };
    MonacoToProtocolConverter.prototype.asTextDocumentIdentifier = function (model) {
        return {
            uri: model.uri.toString()
        };
    };
    MonacoToProtocolConverter.prototype.asTextDocumentPositionParams = function (model, position) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            position: this.asPosition(position.lineNumber, position.column)
        };
    };
    MonacoToProtocolConverter.prototype.asCompletionParams = function (model, position, context) {
        return Object.assign(this.asTextDocumentPositionParams(model, position), {
            context: this.asCompletionContext(context)
        });
    };
    MonacoToProtocolConverter.prototype.asCompletionContext = function (context) {
        return {
            triggerKind: this.asTriggerKind(context.triggerKind),
            triggerCharacter: context.triggerCharacter
        };
    };
    MonacoToProtocolConverter.prototype.asTriggerKind = function (triggerKind) {
        switch (triggerKind) {
            case monaco.languages.SuggestTriggerKind.TriggerCharacter:
                return services_1.CompletionTriggerKind.TriggerCharacter;
            case monaco.languages.SuggestTriggerKind.TriggerForIncompleteCompletions:
                return services_1.CompletionTriggerKind.TriggerForIncompleteCompletions;
            default:
                return services_1.CompletionTriggerKind.Invoked;
        }
    };
    MonacoToProtocolConverter.prototype.asCompletionItem = function (item) {
        var result = { label: item.label };
        var protocolItem = ProtocolCompletionItem.is(item) ? item : undefined;
        if (item.detail) {
            result.detail = item.detail;
        }
        // We only send items back we created. So this can't be something else than
        // a string right now.
        if (item.documentation) {
            if (!protocolItem || !protocolItem.documentationFormat) {
                result.documentation = item.documentation;
            }
            else {
                result.documentation = this.asDocumentation(protocolItem.documentationFormat, item.documentation);
            }
        }
        if (item.filterText) {
            result.filterText = item.filterText;
        }
        this.fillPrimaryInsertText(result, item);
        if (Is.number(item.kind)) {
            result.kind = this.asCompletionItemKind(item.kind, protocolItem && protocolItem.originalItemKind);
        }
        if (item.sortText) {
            result.sortText = item.sortText;
        }
        if (item.additionalTextEdits) {
            result.additionalTextEdits = this.asTextEdits(item.additionalTextEdits);
        }
        if (item.command) {
            result.command = this.asCommand(item.command);
        }
        if (item.commitCharacters) {
            result.commitCharacters = item.commitCharacters.slice();
        }
        if (item.command) {
            result.command = this.asCommand(item.command);
        }
        // TODO if (item.preselect === true || item.preselect === false) { result.preselect = item.preselect; }
        if (protocolItem) {
            if (protocolItem.data !== undefined) {
                result.data = protocolItem.data;
            }
            if (protocolItem.deprecated === true || protocolItem.deprecated === false) {
                result.deprecated = protocolItem.deprecated;
            }
        }
        return result;
    };
    MonacoToProtocolConverter.prototype.asCompletionItemKind = function (value, original) {
        if (original !== undefined) {
            return original;
        }
        return value + 1;
    };
    MonacoToProtocolConverter.prototype.asDocumentation = function (format, documentation) {
        switch (format) {
            case services_1.MarkupKind.PlainText:
                return { kind: format, value: documentation };
            case services_1.MarkupKind.Markdown:
                return { kind: format, value: documentation.value };
            default:
                return "Unsupported Markup content received. Kind is: " + format;
        }
    };
    MonacoToProtocolConverter.prototype.fillPrimaryInsertText = function (target, source) {
        var format = services_1.InsertTextFormat.PlainText;
        var text;
        var range;
        if (source.textEdit) {
            text = source.textEdit.text;
            range = this.asRange(source.textEdit.range);
        }
        else if (typeof source.insertText === 'string') {
            text = source.insertText;
        }
        else if (source.insertText) {
            format = services_1.InsertTextFormat.Snippet;
            text = source.insertText.value;
        }
        if (source.range) {
            range = this.asRange(source.range);
        }
        target.insertTextFormat = format;
        if (source.fromEdit && text && range) {
            target.textEdit = { newText: text, range: range };
        }
        else {
            target.insertText = text;
        }
    };
    MonacoToProtocolConverter.prototype.asTextEdit = function (edit) {
        var range = this.asRange(edit.range);
        return {
            range: range,
            newText: edit.text
        };
    };
    MonacoToProtocolConverter.prototype.asTextEdits = function (items) {
        var _this = this;
        if (!items) {
            return undefined;
        }
        return items.map(function (item) { return _this.asTextEdit(item); });
    };
    MonacoToProtocolConverter.prototype.asReferenceParams = function (model, position, options) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            position: this.asPosition(position.lineNumber, position.column),
            context: { includeDeclaration: options.includeDeclaration }
        };
    };
    MonacoToProtocolConverter.prototype.asDocumentSymbolParams = function (model) {
        return {
            textDocument: this.asTextDocumentIdentifier(model)
        };
    };
    MonacoToProtocolConverter.prototype.asCodeLensParams = function (model) {
        return {
            textDocument: this.asTextDocumentIdentifier(model)
        };
    };
    MonacoToProtocolConverter.prototype.asDiagnosticSeverity = function (value) {
        switch (value) {
            case monaco.MarkerSeverity.Error:
                return services_1.DiagnosticSeverity.Error;
            case monaco.MarkerSeverity.Warning:
                return services_1.DiagnosticSeverity.Warning;
            case monaco.MarkerSeverity.Info:
                return services_1.DiagnosticSeverity.Information;
            case monaco.MarkerSeverity.Hint:
                return services_1.DiagnosticSeverity.Hint;
        }
        return undefined;
    };
    MonacoToProtocolConverter.prototype.asDiagnostic = function (marker) {
        var range = this.asRange(new monaco.Range(marker.startLineNumber, marker.startColumn, marker.endLineNumber, marker.endColumn));
        var severity = this.asDiagnosticSeverity(marker.severity);
        return services_1.Diagnostic.create(range, marker.message, severity, marker.code, marker.source);
    };
    MonacoToProtocolConverter.prototype.asDiagnostics = function (markers) {
        var _this = this;
        if (markers === void 0 || markers === null) {
            return markers;
        }
        return markers.map(function (marker) { return _this.asDiagnostic(marker); });
    };
    MonacoToProtocolConverter.prototype.asCodeActionContext = function (context) {
        if (context === void 0 || context === null) {
            return context;
        }
        var diagnostics = this.asDiagnostics(context.markers);
        return services_1.CodeActionContext.create(diagnostics, Is.string(context.only) ? [context.only] : undefined);
    };
    MonacoToProtocolConverter.prototype.asCodeActionParams = function (model, range, context) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            range: this.asRange(range),
            context: this.asCodeActionContext(context)
        };
    };
    MonacoToProtocolConverter.prototype.asCommand = function (item) {
        if (item) {
            var args = item.arguments || [];
            return services_1.Command.create.apply(services_1.Command, [item.title, item.id].concat(args));
        }
        return undefined;
    };
    MonacoToProtocolConverter.prototype.asCodeLens = function (item) {
        var result = services_1.CodeLens.create(this.asRange(item.range));
        if (item.command) {
            result.command = this.asCommand(item.command);
        }
        if (ProtocolCodeLens.is(item)) {
            if (item.data) {
                result.data = item.data;
            }
            ;
        }
        return result;
    };
    MonacoToProtocolConverter.prototype.asFormattingOptions = function (options) {
        return { tabSize: options.tabSize, insertSpaces: options.insertSpaces };
    };
    MonacoToProtocolConverter.prototype.asDocumentFormattingParams = function (model, options) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            options: this.asFormattingOptions(options)
        };
    };
    MonacoToProtocolConverter.prototype.asDocumentRangeFormattingParams = function (model, range, options) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            range: this.asRange(range),
            options: this.asFormattingOptions(options)
        };
    };
    MonacoToProtocolConverter.prototype.asDocumentOnTypeFormattingParams = function (model, position, ch, options) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            position: this.asPosition(position.lineNumber, position.column),
            ch: ch,
            options: this.asFormattingOptions(options)
        };
    };
    MonacoToProtocolConverter.prototype.asRenameParams = function (model, position, newName) {
        return {
            textDocument: this.asTextDocumentIdentifier(model),
            position: this.asPosition(position.lineNumber, position.column),
            newName: newName
        };
    };
    MonacoToProtocolConverter.prototype.asDocumentLinkParams = function (model) {
        return {
            textDocument: this.asTextDocumentIdentifier(model)
        };
    };
    MonacoToProtocolConverter.prototype.asDocumentLink = function (item) {
        var result = services_1.DocumentLink.create(this.asRange(item.range));
        if (item.url) {
            result.target = item.url;
        }
        if (ProtocolDocumentLink.is(item) && item.data) {
            result.data = item.data;
        }
        return result;
    };
    return MonacoToProtocolConverter;
}());
exports.MonacoToProtocolConverter = MonacoToProtocolConverter;
var ProtocolToMonacoConverter = /** @class */ (function () {
    function ProtocolToMonacoConverter() {
    }
    ProtocolToMonacoConverter.prototype.asResourceEdits = function (resource, edits, modelVersionId) {
        return {
            resource: resource,
            edits: this.asTextEdits(edits),
            modelVersionId: modelVersionId
        };
    };
    ProtocolToMonacoConverter.prototype.asWorkspaceEdit = function (item) {
        if (!item) {
            return undefined;
        }
        var edits = [];
        if (item.documentChanges) {
            for (var _i = 0, _a = item.documentChanges; _i < _a.length; _i++) {
                var change = _a[_i];
                var resource = monaco.Uri.parse(change.textDocument.uri);
                var version = typeof change.textDocument.version === 'number' ? change.textDocument.version : undefined;
                edits.push(this.asResourceEdits(resource, change.edits, version));
            }
        }
        else if (item.changes) {
            for (var _b = 0, _c = Object.keys(item.changes); _b < _c.length; _b++) {
                var key = _c[_b];
                var resource = monaco.Uri.parse(key);
                edits.push(this.asResourceEdits(resource, item.changes[key]));
            }
        }
        return {
            edits: edits
        };
    };
    ProtocolToMonacoConverter.prototype.asTextEdit = function (edit) {
        if (!edit) {
            return undefined;
        }
        var range = this.asRange(edit.range);
        return {
            range: range,
            text: edit.newText
        };
    };
    ProtocolToMonacoConverter.prototype.asTextEdits = function (items) {
        var _this = this;
        if (!items) {
            return undefined;
        }
        return items.map(function (item) { return _this.asTextEdit(item); });
    };
    ProtocolToMonacoConverter.prototype.asCodeLens = function (item) {
        if (!item) {
            return undefined;
        }
        var range = this.asRange(item.range);
        var result = { range: range };
        if (item.command) {
            result.command = this.asCommand(item.command);
        }
        if (item.data !== void 0 && item.data !== null) {
            result.data = item.data;
        }
        return result;
    };
    ProtocolToMonacoConverter.prototype.asCodeLenses = function (items) {
        var _this = this;
        if (!items) {
            return undefined;
        }
        return items.map(function (codeLens) { return _this.asCodeLens(codeLens); });
    };
    ProtocolToMonacoConverter.prototype.asCodeActions = function (actions) {
        var _this = this;
        return actions.map(function (action) { return _this.asCodeAction(action); });
    };
    ProtocolToMonacoConverter.prototype.asCodeAction = function (item) {
        if (services_1.CodeAction.is(item)) {
            return {
                title: item.title,
                command: this.asCommand(item.command),
                edit: this.asWorkspaceEdit(item.edit),
                diagnostics: this.asDiagnostics(item.diagnostics),
                kind: item.kind
            };
        }
        return {
            command: {
                id: item.command,
                title: item.title,
                arguments: item.arguments
            },
            title: item.title
        };
    };
    ProtocolToMonacoConverter.prototype.asCommand = function (command) {
        if (!command) {
            return undefined;
        }
        return {
            id: command.command,
            title: command.title,
            arguments: command.arguments
        };
    };
    ProtocolToMonacoConverter.prototype.asDocumentSymbol = function (value) {
        var _this = this;
        var children = value.children && value.children.map(function (c) { return _this.asDocumentSymbol(c); });
        return {
            name: value.name,
            detail: value.detail || "",
            kind: this.asSymbolKind(value.kind),
            range: this.asRange(value.range),
            selectionRange: this.asRange(value.selectionRange),
            children: children
        };
    };
    ProtocolToMonacoConverter.prototype.asDocumentSymbols = function (values) {
        var _this = this;
        if (services_1.DocumentSymbol.is(values[0])) {
            return values.map(function (s) { return _this.asDocumentSymbol(s); });
        }
        return this.asSymbolInformations(values);
    };
    ProtocolToMonacoConverter.prototype.asSymbolInformations = function (values, uri) {
        var _this = this;
        if (!values) {
            return undefined;
        }
        return values.map(function (information) { return _this.asSymbolInformation(information, uri); });
    };
    ProtocolToMonacoConverter.prototype.asSymbolInformation = function (item, uri) {
        var location = this.asLocation(uri ? __assign({}, item.location, { uri: uri.toString() }) : item.location);
        return {
            name: item.name,
            detail: '',
            containerName: item.containerName,
            kind: this.asSymbolKind(item.kind),
            range: location.range,
            selectionRange: location.range
        };
    };
    ProtocolToMonacoConverter.prototype.asSymbolKind = function (item) {
        if (item <= services_1.SymbolKind.TypeParameter) {
            // Symbol kind is one based in the protocol and zero based in code.
            return item - 1;
        }
        return monaco.languages.SymbolKind.Property;
    };
    ProtocolToMonacoConverter.prototype.asDocumentHighlights = function (values) {
        var _this = this;
        if (!values) {
            return undefined;
        }
        return values.map(function (item) { return _this.asDocumentHighlight(item); });
    };
    ProtocolToMonacoConverter.prototype.asDocumentHighlight = function (item) {
        var range = this.asRange(item.range);
        var kind = Is.number(item.kind) ? this.asDocumentHighlightKind(item.kind) : undefined;
        return { range: range, kind: kind };
    };
    ProtocolToMonacoConverter.prototype.asDocumentHighlightKind = function (item) {
        switch (item) {
            case services_1.DocumentHighlightKind.Text:
                return monaco.languages.DocumentHighlightKind.Text;
            case services_1.DocumentHighlightKind.Read:
                return monaco.languages.DocumentHighlightKind.Read;
            case services_1.DocumentHighlightKind.Write:
                return monaco.languages.DocumentHighlightKind.Write;
        }
        return monaco.languages.DocumentHighlightKind.Text;
    };
    ProtocolToMonacoConverter.prototype.asReferences = function (values) {
        var _this = this;
        if (!values) {
            return undefined;
        }
        return values.map(function (location) { return _this.asLocation(location); });
    };
    ProtocolToMonacoConverter.prototype.asDefinitionResult = function (item) {
        var _this = this;
        if (!item) {
            return undefined;
        }
        if (Is.array(item)) {
            return item.map(function (location) { return _this.asLocation(location); });
        }
        else {
            return this.asLocation(item);
        }
    };
    ProtocolToMonacoConverter.prototype.asLocation = function (item) {
        if (!item) {
            return undefined;
        }
        var uri = monaco.Uri.parse(item.uri);
        var range = this.asRange(item.range);
        return {
            uri: uri, range: range
        };
    };
    ProtocolToMonacoConverter.prototype.asSignatureHelp = function (item) {
        if (!item) {
            return undefined;
        }
        var result = {};
        if (Is.number(item.activeSignature)) {
            result.activeSignature = item.activeSignature;
        }
        else {
            // activeSignature was optional in the past
            result.activeSignature = 0;
        }
        if (Is.number(item.activeParameter)) {
            result.activeParameter = item.activeParameter;
        }
        else {
            // activeParameter was optional in the past
            result.activeParameter = 0;
        }
        if (item.signatures) {
            result.signatures = this.asSignatureInformations(item.signatures);
        }
        else {
            result.signatures = [];
        }
        return result;
    };
    ProtocolToMonacoConverter.prototype.asSignatureInformations = function (items) {
        var _this = this;
        return items.map(function (item) { return _this.asSignatureInformation(item); });
    };
    ProtocolToMonacoConverter.prototype.asSignatureInformation = function (item) {
        var result = { label: item.label };
        if (item.documentation) {
            result.documentation = this.asDocumentation(item.documentation);
        }
        if (item.parameters) {
            result.parameters = this.asParameterInformations(item.parameters);
        }
        else {
            result.parameters = [];
        }
        return result;
    };
    ProtocolToMonacoConverter.prototype.asParameterInformations = function (item) {
        var _this = this;
        return item.map(function (item) { return _this.asParameterInformation(item); });
    };
    ProtocolToMonacoConverter.prototype.asParameterInformation = function (item) {
        var result = { label: item.label };
        if (item.documentation) {
            result.documentation = this.asDocumentation(item.documentation);
        }
        ;
        return result;
    };
    ProtocolToMonacoConverter.prototype.asHover = function (hover) {
        if (!hover) {
            return undefined;
        }
        return {
            contents: this.asHoverContent(hover.contents),
            range: this.asRange(hover.range)
        };
    };
    ProtocolToMonacoConverter.prototype.asHoverContent = function (contents) {
        var _this = this;
        if (Array.isArray(contents)) {
            return contents.map(function (content) { return _this.asMarkdownString(content); });
        }
        return [this.asMarkdownString(contents)];
    };
    ProtocolToMonacoConverter.prototype.asDocumentation = function (value) {
        if (Is.string(value)) {
            return value;
        }
        if (value.kind === services_1.MarkupKind.PlainText) {
            return value.value;
        }
        return this.asMarkdownString(value);
    };
    ProtocolToMonacoConverter.prototype.asMarkdownString = function (content) {
        if (services_1.MarkupContent.is(content)) {
            return {
                value: content.value
            };
        }
        if (Is.string(content)) {
            return { value: content };
        }
        var language = content.language, value = content.value;
        return {
            value: '```' + language + '\n' + value + '\n```'
        };
    };
    ProtocolToMonacoConverter.prototype.asSeverity = function (severity) {
        if (severity === 1) {
            return monaco.MarkerSeverity.Error;
        }
        if (severity === 2) {
            return monaco.MarkerSeverity.Warning;
        }
        if (severity === 3) {
            return monaco.MarkerSeverity.Info;
        }
        return monaco.MarkerSeverity.Hint;
    };
    ProtocolToMonacoConverter.prototype.asDiagnostics = function (diagnostics) {
        var _this = this;
        if (!diagnostics) {
            return undefined;
        }
        return diagnostics.map(function (diagnostic) { return _this.asDiagnostic(diagnostic); });
    };
    ProtocolToMonacoConverter.prototype.asDiagnostic = function (diagnostic) {
        return {
            code: typeof diagnostic.code === "number" ? diagnostic.code.toString() : diagnostic.code,
            severity: this.asSeverity(diagnostic.severity),
            message: diagnostic.message,
            source: diagnostic.source,
            startLineNumber: diagnostic.range.start.line + 1,
            startColumn: diagnostic.range.start.character + 1,
            endLineNumber: diagnostic.range.end.line + 1,
            endColumn: diagnostic.range.end.character + 1,
            relatedInformation: this.asRelatedInformations(diagnostic.relatedInformation)
        };
    };
    ProtocolToMonacoConverter.prototype.asRelatedInformations = function (relatedInformation) {
        var _this = this;
        if (!relatedInformation) {
            return undefined;
        }
        return relatedInformation.map(function (item) { return _this.asRelatedInformation(item); });
    };
    ProtocolToMonacoConverter.prototype.asRelatedInformation = function (relatedInformation) {
        return {
            resource: monaco.Uri.parse(relatedInformation.location.uri),
            startLineNumber: relatedInformation.location.range.start.line + 1,
            startColumn: relatedInformation.location.range.start.character + 1,
            endLineNumber: relatedInformation.location.range.end.line + 1,
            endColumn: relatedInformation.location.range.end.character + 1,
            message: relatedInformation.message
        };
    };
    ProtocolToMonacoConverter.prototype.asCompletionResult = function (result) {
        var _this = this;
        if (!result) {
            return {
                isIncomplete: false,
                items: []
            };
        }
        if (Array.isArray(result)) {
            var items = result.map(function (item) { return _this.asCompletionItem(item); });
            return {
                isIncomplete: false,
                items: items
            };
        }
        return {
            isIncomplete: result.isIncomplete,
            items: result.items.map(this.asCompletionItem.bind(this))
        };
    };
    ProtocolToMonacoConverter.prototype.asCompletionItem = function (item) {
        var result = { label: item.label };
        if (item.detail) {
            result.detail = item.detail;
        }
        if (item.documentation) {
            result.documentation = this.asDocumentation(item.documentation);
            result.documentationFormat = Is.string(item.documentation) ? undefined : item.documentation.kind;
        }
        ;
        if (item.filterText) {
            result.filterText = item.filterText;
        }
        var insertText = this.asCompletionInsertText(item);
        if (insertText) {
            result.insertText = insertText.text;
            result.range = insertText.range;
            result.fromEdit = insertText.fromEdit;
        }
        if (Is.number(item.kind)) {
            var _a = this.asCompletionItemKind(item.kind), itemKind = _a[0], original = _a[1];
            result.kind = itemKind;
            if (original) {
                result.originalItemKind = original;
            }
        }
        if (item.sortText) {
            result.sortText = item.sortText;
        }
        if (item.additionalTextEdits) {
            result.additionalTextEdits = this.asTextEdits(item.additionalTextEdits);
        }
        if (Is.stringArray(item.commitCharacters)) {
            result.commitCharacters = item.commitCharacters.slice();
        }
        if (item.command) {
            result.command = this.asCommand(item.command);
        }
        if (item.deprecated === true || item.deprecated === false) {
            result.deprecated = item.deprecated;
        }
        // TODO if (item.preselect === true || item.preselect === false) { result.preselect = item.preselect; }
        if (item.data !== undefined) {
            result.data = item.data;
        }
        return result;
    };
    ProtocolToMonacoConverter.prototype.asCompletionItemKind = function (value) {
        // Protocol item kind is 1 based, codes item kind is zero based.
        if (services_1.CompletionItemKind.Text <= value && value <= services_1.CompletionItemKind.TypeParameter) {
            return [value - 1, undefined];
        }
        ;
        return [services_1.CompletionItemKind.Text, value];
    };
    ProtocolToMonacoConverter.prototype.asCompletionInsertText = function (item) {
        if (item.textEdit) {
            var range = this.asRange(item.textEdit.range);
            var value = item.textEdit.newText;
            var text = item.insertTextFormat === services_1.InsertTextFormat.Snippet ? { value: value } : value;
            return {
                text: text, range: range, fromEdit: true
            };
        }
        if (item.insertText) {
            var value = item.insertText;
            var text = item.insertTextFormat === services_1.InsertTextFormat.Snippet ? { value: value } : value;
            return { text: text, fromEdit: false };
        }
        return undefined;
    };
    ProtocolToMonacoConverter.prototype.asDocumentLinks = function (documentLinks) {
        var _this = this;
        return documentLinks.map(function (link) { return _this.asDocumentLink(link); });
    };
    ProtocolToMonacoConverter.prototype.asDocumentLink = function (documentLink) {
        return {
            range: this.asRange(documentLink.range),
            url: documentLink.target,
            data: documentLink.data
        };
    };
    ProtocolToMonacoConverter.prototype.asRange = function (range) {
        if (range === undefined) {
            return undefined;
        }
        if (range === null) {
            return null;
        }
        var start = this.asPosition(range.start);
        var end = this.asPosition(range.end);
        if (start instanceof monaco.Position && end instanceof monaco.Position) {
            return new monaco.Range(start.lineNumber, start.column, end.lineNumber, end.column);
        }
        var startLineNumber = !start || start.lineNumber === undefined ? undefined : start.lineNumber;
        var startColumn = !start || start.column === undefined ? undefined : start.column;
        var endLineNumber = !end || end.lineNumber === undefined ? undefined : end.lineNumber;
        var endColumn = !end || end.column === undefined ? undefined : end.column;
        return { startLineNumber: startLineNumber, startColumn: startColumn, endLineNumber: endLineNumber, endColumn: endColumn };
    };
    ProtocolToMonacoConverter.prototype.asPosition = function (position) {
        if (position === undefined) {
            return undefined;
        }
        if (position === null) {
            return null;
        }
        var line = position.line, character = position.character;
        var lineNumber = line === undefined ? undefined : line + 1;
        var column = character === undefined ? undefined : character + 1;
        if (lineNumber !== undefined && column !== undefined) {
            return new monaco.Position(lineNumber, column);
        }
        return { lineNumber: lineNumber, column: column };
    };
    ProtocolToMonacoConverter.prototype.asColorInformations = function (items) {
        var _this = this;
        return items.map(function (item) { return _this.asColorInformation(item); });
    };
    ProtocolToMonacoConverter.prototype.asColorInformation = function (item) {
        return {
            range: this.asRange(item.range),
            color: item.color
        };
    };
    ProtocolToMonacoConverter.prototype.asColorPresentations = function (items) {
        var _this = this;
        return items.map(function (item) { return _this.asColorPresentation(item); });
    };
    ProtocolToMonacoConverter.prototype.asColorPresentation = function (item) {
        return {
            label: item.label,
            textEdit: this.asTextEdit(item.textEdit),
            additionalTextEdits: this.asTextEdits(item.additionalTextEdits)
        };
    };
    ProtocolToMonacoConverter.prototype.asFoldingRanges = function (items) {
        var _this = this;
        if (!items) {
            return items;
        }
        return items.map(function (item) { return _this.asFoldingRange(item); });
    };
    ProtocolToMonacoConverter.prototype.asFoldingRange = function (item) {
        return {
            start: item.startLine + 1,
            end: item.endLine + 1,
            kind: this.asFoldingRangeKind(item.kind)
        };
    };
    ProtocolToMonacoConverter.prototype.asFoldingRangeKind = function (kind) {
        if (kind) {
            switch (kind) {
                case services_1.FoldingRangeKind.Comment:
                    return monaco.languages.FoldingRangeKind.Comment;
                case services_1.FoldingRangeKind.Imports:
                    return monaco.languages.FoldingRangeKind.Imports;
                case services_1.FoldingRangeKind.Region:
                    return monaco.languages.FoldingRangeKind.Region;
            }
            ;
        }
        return undefined;
    };
    return ProtocolToMonacoConverter;
}());
exports.ProtocolToMonacoConverter = ProtocolToMonacoConverter;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-diagnostic-collection.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-diagnostic-collection.js ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var disposable_1 = __webpack_require__(/*! ./disposable */ "../node_modules/monaco-languageclient/lib/disposable.js");
var MonacoDiagnosticCollection = /** @class */ (function () {
    function MonacoDiagnosticCollection(name, p2m) {
        this.name = name;
        this.p2m = p2m;
        this.diagnostics = new Map();
        this.toDispose = new disposable_1.DisposableCollection();
    }
    MonacoDiagnosticCollection.prototype.dispose = function () {
        this.toDispose.dispose();
    };
    MonacoDiagnosticCollection.prototype.get = function (uri) {
        var diagnostics = this.diagnostics.get(uri);
        return !!diagnostics ? diagnostics.diagnostics : [];
    };
    MonacoDiagnosticCollection.prototype.set = function (uri, diagnostics) {
        var _this = this;
        var existing = this.diagnostics.get(uri);
        if (existing) {
            existing.diagnostics = diagnostics;
        }
        else {
            var modelDiagnostics_1 = new MonacoModelDiagnostics(uri, diagnostics, this.name, this.p2m);
            this.diagnostics.set(uri, modelDiagnostics_1);
            this.toDispose.push(disposable_1.Disposable.create(function () {
                _this.diagnostics.delete(uri);
                modelDiagnostics_1.dispose();
            }));
        }
    };
    return MonacoDiagnosticCollection;
}());
exports.MonacoDiagnosticCollection = MonacoDiagnosticCollection;
var MonacoModelDiagnostics = /** @class */ (function () {
    function MonacoModelDiagnostics(uri, diagnostics, owner, p2m) {
        var _this = this;
        this.owner = owner;
        this.p2m = p2m;
        this._markers = [];
        this._diagnostics = [];
        this.uri = monaco.Uri.parse(uri);
        this.diagnostics = diagnostics;
        monaco.editor.onDidCreateModel(function (model) { return _this.doUpdateModelMarkers(model); });
    }
    Object.defineProperty(MonacoModelDiagnostics.prototype, "diagnostics", {
        get: function () {
            return this._diagnostics;
        },
        set: function (diagnostics) {
            this._diagnostics = diagnostics;
            this._markers = this.p2m.asDiagnostics(diagnostics);
            this.updateModelMarkers();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(MonacoModelDiagnostics.prototype, "markers", {
        get: function () {
            return this._markers;
        },
        enumerable: true,
        configurable: true
    });
    MonacoModelDiagnostics.prototype.dispose = function () {
        this._markers = [];
        this.updateModelMarkers();
    };
    MonacoModelDiagnostics.prototype.updateModelMarkers = function () {
        var model = monaco.editor.getModel(this.uri);
        this.doUpdateModelMarkers(model);
    };
    MonacoModelDiagnostics.prototype.doUpdateModelMarkers = function (model) {
        if (model && this.uri.toString() === model.uri.toString()) {
            monaco.editor.setModelMarkers(model, this.owner, this._markers);
        }
    };
    return MonacoModelDiagnostics;
}());
exports.MonacoModelDiagnostics = MonacoModelDiagnostics;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-language-client.js":
/*!***************************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-language-client.js ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var client_1 = __webpack_require__(/*! vscode-base-languageclient/lib/client */ "../node_modules/vscode-base-languageclient/lib/client.js");
var typeDefinition_1 = __webpack_require__(/*! vscode-base-languageclient/lib/typeDefinition */ "../node_modules/vscode-base-languageclient/lib/typeDefinition.js");
var implementation_1 = __webpack_require__(/*! vscode-base-languageclient/lib/implementation */ "../node_modules/vscode-base-languageclient/lib/implementation.js");
var colorProvider_1 = __webpack_require__(/*! vscode-base-languageclient/lib/colorProvider */ "../node_modules/vscode-base-languageclient/lib/colorProvider.js");
var workspaceFolders_1 = __webpack_require__(/*! vscode-base-languageclient/lib/workspaceFolders */ "../node_modules/vscode-base-languageclient/lib/workspaceFolders.js");
var foldingRange_1 = __webpack_require__(/*! vscode-base-languageclient/lib/foldingRange */ "../node_modules/vscode-base-languageclient/lib/foldingRange.js");
__export(__webpack_require__(/*! vscode-base-languageclient/lib/client */ "../node_modules/vscode-base-languageclient/lib/client.js"));
var MonacoLanguageClient = /** @class */ (function (_super) {
    __extends(MonacoLanguageClient, _super);
    function MonacoLanguageClient(_a) {
        var id = _a.id, name = _a.name, clientOptions = _a.clientOptions, connectionProvider = _a.connectionProvider;
        var _this = _super.call(this, id || name.toLowerCase(), name, clientOptions) || this;
        _this.connectionProvider = connectionProvider;
        _this.createConnection = _this.doCreateConnection.bind(_this);
        // bypass LSP <=> VS Code conversion
        var self = _this;
        self._p2c = new Proxy(self._p2c, {
            get: function (target, prop) {
                if (prop === 'asUri') {
                    return target[prop];
                }
                return MonacoLanguageClient.bypassConversion;
            }
        });
        self._c2p = new Proxy(self._c2p, {
            get: function (target, prop) {
                if (prop === 'asUri') {
                    return target[prop];
                }
                if (prop === 'asCompletionParams') {
                    return function (textDocument, position, context) {
                        return {
                            textDocument: target.asTextDocumentIdentifier(textDocument),
                            position: position,
                            context: context
                        };
                    };
                }
                if (prop === 'asWillSaveTextDocumentParams') {
                    return function (event) {
                        return {
                            textDocument: target.asTextDocumentIdentifier(event.document),
                            reason: event.reason
                        };
                    };
                }
                if (prop.endsWith('Params')) {
                    return target[prop];
                }
                return MonacoLanguageClient.bypassConversion;
            }
        });
        return _this;
    }
    MonacoLanguageClient.prototype.doCreateConnection = function () {
        var errorHandler = this.handleConnectionError.bind(this);
        var closeHandler = this.handleConnectionClosed.bind(this);
        return this.connectionProvider.get(errorHandler, closeHandler, this.outputChannel);
    };
    MonacoLanguageClient.prototype.createMessageTransports = function (encoding) {
        throw new Error('Unsupported');
    };
    MonacoLanguageClient.prototype.registerBuiltinFeatures = function () {
        _super.prototype.registerBuiltinFeatures.call(this);
        this.registerFeature(new typeDefinition_1.TypeDefinitionFeature(this));
        this.registerFeature(new implementation_1.ImplementationFeature(this));
        this.registerFeature(new colorProvider_1.ColorProviderFeature(this));
        this.registerFeature(new workspaceFolders_1.WorkspaceFoldersFeature(this));
        var foldingRangeFeature = new foldingRange_1.FoldingRangeFeature(this);
        foldingRangeFeature['asFoldingRanges'] = MonacoLanguageClient.bypassConversion;
        this.registerFeature(foldingRangeFeature);
    };
    MonacoLanguageClient.bypassConversion = function (result) { return result || undefined; };
    return MonacoLanguageClient;
}(client_1.BaseLanguageClient));
exports.MonacoLanguageClient = MonacoLanguageClient;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-languages.js":
/*!*********************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-languages.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var globToRegExp = __webpack_require__(/*! glob-to-regexp */ "../node_modules/glob-to-regexp/index.js");
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
var monaco_diagnostic_collection_1 = __webpack_require__(/*! ./monaco-diagnostic-collection */ "../node_modules/monaco-languageclient/lib/monaco-diagnostic-collection.js");
var disposable_1 = __webpack_require__(/*! ./disposable */ "../node_modules/monaco-languageclient/lib/disposable.js");
var MonacoModelIdentifier;
(function (MonacoModelIdentifier) {
    function fromDocument(document) {
        return {
            uri: monaco.Uri.parse(document.uri),
            languageId: document.languageId
        };
    }
    MonacoModelIdentifier.fromDocument = fromDocument;
    function fromModel(model) {
        return {
            uri: model.uri,
            languageId: model.getModeId()
        };
    }
    MonacoModelIdentifier.fromModel = fromModel;
})(MonacoModelIdentifier = exports.MonacoModelIdentifier || (exports.MonacoModelIdentifier = {}));
function testGlob(pattern, value) {
    var regExp = globToRegExp(pattern, {
        extended: true,
        globstar: true
    });
    return regExp.test(value);
}
exports.testGlob = testGlob;
function getLanguages() {
    var languages = [];
    for (var _i = 0, _a = monaco.languages.getLanguages().map(function (l) { return l.id; }); _i < _a.length; _i++) {
        var language = _a[_i];
        if (languages.indexOf(language) === -1) {
            languages.push(language);
        }
    }
    return languages;
}
exports.getLanguages = getLanguages;
var MonacoLanguages = /** @class */ (function () {
    function MonacoLanguages(p2m, m2p) {
        this.p2m = p2m;
        this.m2p = m2p;
    }
    MonacoLanguages.prototype.match = function (selector, document) {
        return this.matchModel(selector, MonacoModelIdentifier.fromDocument(document));
    };
    MonacoLanguages.prototype.createDiagnosticCollection = function (name) {
        return new monaco_diagnostic_collection_1.MonacoDiagnosticCollection(name || 'default', this.p2m);
    };
    MonacoLanguages.prototype.registerCompletionItemProvider = function (selector, provider) {
        var triggerCharacters = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            triggerCharacters[_i - 2] = arguments[_i];
        }
        var completionProvider = this.createCompletionProvider.apply(this, [selector, provider].concat(triggerCharacters));
        var providers = new disposable_1.DisposableCollection();
        for (var _a = 0, _b = getLanguages(); _a < _b.length; _a++) {
            var language = _b[_a];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerCompletionItemProvider(language, completionProvider));
            }
        }
        ;
        return providers;
    };
    MonacoLanguages.prototype.createCompletionProvider = function (selector, provider) {
        var _this = this;
        var triggerCharacters = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            triggerCharacters[_i - 2] = arguments[_i];
        }
        return {
            triggerCharacters: triggerCharacters,
            provideCompletionItems: function (model, position, token, context) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asCompletionParams(model, position, context);
                return provider.provideCompletionItems(params, token).then(function (result) { return _this.p2m.asCompletionResult(result); });
            },
            resolveCompletionItem: provider.resolveCompletionItem ? function (item, token) {
                var protocolItem = _this.m2p.asCompletionItem(item);
                return provider.resolveCompletionItem(protocolItem, token).then(function (resolvedItem) {
                    var resolvedCompletionItem = _this.p2m.asCompletionItem(resolvedItem);
                    Object.assign(item, resolvedCompletionItem);
                    return item;
                });
            } : undefined
        };
    };
    MonacoLanguages.prototype.registerHoverProvider = function (selector, provider) {
        var hoverProvider = this.createHoverProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerHoverProvider(language, hoverProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createHoverProvider = function (selector, provider) {
        var _this = this;
        return {
            provideHover: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideHover(params, token).then(function (hover) { return _this.p2m.asHover(hover); });
            }
        };
    };
    MonacoLanguages.prototype.registerSignatureHelpProvider = function (selector, provider) {
        var triggerCharacters = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            triggerCharacters[_i - 2] = arguments[_i];
        }
        var signatureHelpProvider = this.createSignatureHelpProvider.apply(this, [selector, provider].concat(triggerCharacters));
        var providers = new disposable_1.DisposableCollection();
        for (var _a = 0, _b = getLanguages(); _a < _b.length; _a++) {
            var language = _b[_a];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerSignatureHelpProvider(language, signatureHelpProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createSignatureHelpProvider = function (selector, provider) {
        var _this = this;
        var triggerCharacters = [];
        for (var _i = 2; _i < arguments.length; _i++) {
            triggerCharacters[_i - 2] = arguments[_i];
        }
        var signatureHelpTriggerCharacters = triggerCharacters;
        return {
            signatureHelpTriggerCharacters: signatureHelpTriggerCharacters,
            provideSignatureHelp: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideSignatureHelp(params, token).then(function (signatureHelp) { return _this.p2m.asSignatureHelp(signatureHelp); });
            }
        };
    };
    MonacoLanguages.prototype.registerDefinitionProvider = function (selector, provider) {
        var definitionProvider = this.createDefinitionProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerDefinitionProvider(language, definitionProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDefinitionProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDefinition: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideDefinition(params, token).then(function (result) { return _this.p2m.asDefinitionResult(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerReferenceProvider = function (selector, provider) {
        var referenceProvider = this.createReferenceProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerReferenceProvider(language, referenceProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createReferenceProvider = function (selector, provider) {
        var _this = this;
        return {
            provideReferences: function (model, position, context, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asReferenceParams(model, position, context);
                return provider.provideReferences(params, token).then(function (result) { return _this.p2m.asReferences(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerDocumentHighlightProvider = function (selector, provider) {
        var documentHighlightProvider = this.createDocumentHighlightProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerDocumentHighlightProvider(language, documentHighlightProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentHighlightProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDocumentHighlights: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideDocumentHighlights(params, token).then(function (result) { return _this.p2m.asDocumentHighlights(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerDocumentSymbolProvider = function (selector, provider) {
        var documentSymbolProvider = this.createDocumentSymbolProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerDocumentSymbolProvider(language, documentSymbolProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentSymbolProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDocumentSymbols: function (model, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asDocumentSymbolParams(model);
                return provider.provideDocumentSymbols(params, token).then(function (result) { return _this.p2m.asDocumentSymbols(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerCodeActionsProvider = function (selector, provider) {
        var codeActionProvider = this.createCodeActionProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerCodeActionProvider(language, codeActionProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createCodeActionProvider = function (selector, provider) {
        var _this = this;
        return {
            provideCodeActions: function (model, range, context, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asCodeActionParams(model, range, context);
                return provider.provideCodeActions(params, token).then(function (result) { return _this.p2m.asCodeActions(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerCodeLensProvider = function (selector, provider) {
        var codeLensProvider = this.createCodeLensProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerCodeLensProvider(language, codeLensProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createCodeLensProvider = function (selector, provider) {
        var _this = this;
        return {
            provideCodeLenses: function (model, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asCodeLensParams(model);
                return provider.provideCodeLenses(params, token).then(function (result) { return _this.p2m.asCodeLenses(result); });
            },
            resolveCodeLens: provider.resolveCodeLens ? function (model, codeLens, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return codeLens;
                }
                var protocolCodeLens = _this.m2p.asCodeLens(codeLens);
                return provider.resolveCodeLens(protocolCodeLens, token).then(function (result) {
                    var resolvedCodeLens = _this.p2m.asCodeLens(result);
                    Object.assign(codeLens, resolvedCodeLens);
                    return codeLens;
                });
            } : (function (m, codeLens, t) { return codeLens; })
        };
    };
    MonacoLanguages.prototype.registerDocumentFormattingEditProvider = function (selector, provider) {
        var documentFormattingEditProvider = this.createDocumentFormattingEditProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerDocumentFormattingEditProvider(language, documentFormattingEditProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentFormattingEditProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDocumentFormattingEdits: function (model, options, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asDocumentFormattingParams(model, options);
                return provider.provideDocumentFormattingEdits(params, token).then(function (result) { return _this.p2m.asTextEdits(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerDocumentRangeFormattingEditProvider = function (selector, provider) {
        var documentRangeFormattingEditProvider = this.createDocumentRangeFormattingEditProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerDocumentRangeFormattingEditProvider(language, documentRangeFormattingEditProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentRangeFormattingEditProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDocumentRangeFormattingEdits: function (model, range, options, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asDocumentRangeFormattingParams(model, range, options);
                return provider.provideDocumentRangeFormattingEdits(params, token).then(function (result) { return _this.p2m.asTextEdits(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerOnTypeFormattingEditProvider = function (selector, provider, firstTriggerCharacter) {
        var moreTriggerCharacter = [];
        for (var _i = 3; _i < arguments.length; _i++) {
            moreTriggerCharacter[_i - 3] = arguments[_i];
        }
        var onTypeFormattingEditProvider = this.createOnTypeFormattingEditProvider.apply(this, [selector, provider, firstTriggerCharacter].concat(moreTriggerCharacter));
        var providers = new disposable_1.DisposableCollection();
        for (var _a = 0, _b = getLanguages(); _a < _b.length; _a++) {
            var language = _b[_a];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerOnTypeFormattingEditProvider(language, onTypeFormattingEditProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createOnTypeFormattingEditProvider = function (selector, provider, firstTriggerCharacter) {
        var _this = this;
        var moreTriggerCharacter = [];
        for (var _i = 3; _i < arguments.length; _i++) {
            moreTriggerCharacter[_i - 3] = arguments[_i];
        }
        var autoFormatTriggerCharacters = [firstTriggerCharacter].concat(moreTriggerCharacter);
        return {
            autoFormatTriggerCharacters: autoFormatTriggerCharacters,
            provideOnTypeFormattingEdits: function (model, position, ch, options, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var params = _this.m2p.asDocumentOnTypeFormattingParams(model, position, ch, options);
                return provider.provideOnTypeFormattingEdits(params, token).then(function (result) { return _this.p2m.asTextEdits(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerRenameProvider = function (selector, provider) {
        var renameProvider = this.createRenameProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerRenameProvider(language, renameProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createRenameProvider = function (selector, provider) {
        var _this = this;
        return {
            provideRenameEdits: function (model, position, newName, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asRenameParams(model, position, newName);
                return provider.provideRenameEdits(params, token).then(function (result) { return _this.p2m.asWorkspaceEdit(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerDocumentLinkProvider = function (selector, provider) {
        var linkProvider = this.createDocumentLinkProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerLinkProvider(language, linkProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentLinkProvider = function (selector, provider) {
        var _this = this;
        return {
            provideLinks: function (model, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asDocumentLinkParams(model);
                return provider.provideDocumentLinks(params, token).then(function (result) { return _this.p2m.asDocumentLinks(result); });
            },
            resolveLink: function (link, token) {
                // resolve the link if the provider supports it
                // and the link doesn't have a url set
                if (provider.resolveDocumentLink && (link.url === null || link.url === undefined)) {
                    var documentLink = _this.m2p.asDocumentLink(link);
                    return provider.resolveDocumentLink(documentLink, token).then(function (result) {
                        var resolvedLink = _this.p2m.asDocumentLink(result);
                        Object.assign(link, resolvedLink);
                        return link;
                    });
                }
                return link;
            }
        };
    };
    MonacoLanguages.prototype.registerImplementationProvider = function (selector, provider) {
        var implementationProvider = this.createImplementationProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerImplementationProvider(language, implementationProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createImplementationProvider = function (selector, provider) {
        var _this = this;
        return {
            provideImplementation: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideImplementation(params, token).then(function (result) { return _this.p2m.asDefinitionResult(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerTypeDefinitionProvider = function (selector, provider) {
        var typeDefinitionProvider = this.createTypeDefinitionProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerTypeDefinitionProvider(language, typeDefinitionProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createTypeDefinitionProvider = function (selector, provider) {
        var _this = this;
        return {
            provideTypeDefinition: function (model, position, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return undefined;
                }
                var params = _this.m2p.asTextDocumentPositionParams(model, position);
                return provider.provideTypeDefinition(params, token).then(function (result) { return _this.p2m.asDefinitionResult(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerColorProvider = function (selector, provider) {
        var documentColorProvider = this.createDocumentColorProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerColorProvider(language, documentColorProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createDocumentColorProvider = function (selector, provider) {
        var _this = this;
        return {
            provideDocumentColors: function (model, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var textDocument = _this.m2p.asTextDocumentIdentifier(model);
                return provider.provideDocumentColors({ textDocument: textDocument }, token).then(function (result) { return _this.p2m.asColorInformations(result); });
            },
            provideColorPresentations: function (model, info, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var textDocument = _this.m2p.asTextDocumentIdentifier(model);
                var range = _this.m2p.asRange(info.range);
                return provider.provideColorPresentations({
                    textDocument: textDocument,
                    color: info.color,
                    range: range
                }, token).then(function (result) { return _this.p2m.asColorPresentations(result); });
            }
        };
    };
    MonacoLanguages.prototype.registerFoldingRangeProvider = function (selector, provider) {
        var foldingRangeProvider = this.createFoldingRangeProvider(selector, provider);
        var providers = new disposable_1.DisposableCollection();
        for (var _i = 0, _a = getLanguages(); _i < _a.length; _i++) {
            var language = _a[_i];
            if (this.matchLanguage(selector, language)) {
                providers.push(monaco.languages.registerFoldingRangeProvider(language, foldingRangeProvider));
            }
        }
        return providers;
    };
    MonacoLanguages.prototype.createFoldingRangeProvider = function (selector, provider) {
        var _this = this;
        return {
            provideFoldingRanges: function (model, context, token) {
                if (!_this.matchModel(selector, MonacoModelIdentifier.fromModel(model))) {
                    return [];
                }
                var textDocument = _this.m2p.asTextDocumentIdentifier(model);
                return provider.provideFoldingRanges({
                    textDocument: textDocument
                }, token).then(function (result) { return _this.p2m.asFoldingRanges(result); });
            }
        };
    };
    MonacoLanguages.prototype.matchModel = function (selector, model) {
        var _this = this;
        if (Array.isArray(selector)) {
            return selector.some(function (filter) { return _this.matchModel(filter, model); });
        }
        if (services_1.DocumentFilter.is(selector)) {
            if (!!selector.language && selector.language !== model.languageId) {
                return false;
            }
            if (!!selector.scheme && selector.scheme !== model.uri.scheme) {
                return false;
            }
            if (!!selector.pattern && !testGlob(selector.pattern, model.uri.path)) {
                return false;
            }
            return true;
        }
        return selector === model.languageId;
    };
    MonacoLanguages.prototype.matchLanguage = function (selector, languageId) {
        var _this = this;
        if (Array.isArray(selector)) {
            return selector.some(function (filter) { return _this.matchLanguage(filter, languageId); });
        }
        if (services_1.DocumentFilter.is(selector)) {
            return !selector.language || selector.language === languageId;
        }
        return selector === languageId;
    };
    return MonacoLanguages;
}());
exports.MonacoLanguages = MonacoLanguages;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-services.js":
/*!********************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-services.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var monaco_converter_1 = __webpack_require__(/*! ./monaco-converter */ "../node_modules/monaco-languageclient/lib/monaco-converter.js");
var monaco_commands_1 = __webpack_require__(/*! ./monaco-commands */ "../node_modules/monaco-languageclient/lib/monaco-commands.js");
var monaco_languages_1 = __webpack_require__(/*! ./monaco-languages */ "../node_modules/monaco-languageclient/lib/monaco-languages.js");
var monaco_workspace_1 = __webpack_require__(/*! ./monaco-workspace */ "../node_modules/monaco-languageclient/lib/monaco-workspace.js");
var console_window_1 = __webpack_require__(/*! ./console-window */ "../node_modules/monaco-languageclient/lib/console-window.js");
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
var MonacoServices;
(function (MonacoServices) {
    function create(editor, options) {
        if (options === void 0) { options = {}; }
        var m2p = new monaco_converter_1.MonacoToProtocolConverter();
        var p2m = new monaco_converter_1.ProtocolToMonacoConverter();
        return {
            commands: new monaco_commands_1.MonacoCommands(editor),
            languages: new monaco_languages_1.MonacoLanguages(p2m, m2p),
            workspace: new monaco_workspace_1.MonacoWorkspace(p2m, m2p, options.rootUri),
            window: new console_window_1.ConsoleWindow()
        };
    }
    MonacoServices.create = create;
    function install(editor, options) {
        if (options === void 0) { options = {}; }
        var services = create(editor, options);
        services_1.Services.install(services);
        return services;
    }
    MonacoServices.install = install;
    function get() {
        return services_1.Services.get();
    }
    MonacoServices.get = get;
})(MonacoServices = exports.MonacoServices || (exports.MonacoServices = {}));


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/monaco-workspace.js":
/*!*********************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/monaco-workspace.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
var MonacoWorkspace = /** @class */ (function () {
    function MonacoWorkspace(p2m, m2p, _rootUri) {
        if (_rootUri === void 0) { _rootUri = null; }
        var _this = this;
        this.p2m = p2m;
        this.m2p = m2p;
        this._rootUri = _rootUri;
        this.documents = new Map();
        this.onDidOpenTextDocumentEmitter = new services_1.Emitter();
        this.onDidCloseTextDocumentEmitter = new services_1.Emitter();
        this.onDidChangeTextDocumentEmitter = new services_1.Emitter();
        for (var _i = 0, _a = monaco.editor.getModels(); _i < _a.length; _i++) {
            var model = _a[_i];
            this.addModel(model);
        }
        monaco.editor.onDidCreateModel(function (model) { return _this.addModel(model); });
        monaco.editor.onWillDisposeModel(function (model) { return _this.removeModel(model); });
    }
    Object.defineProperty(MonacoWorkspace.prototype, "rootUri", {
        get: function () {
            return this._rootUri;
        },
        enumerable: true,
        configurable: true
    });
    MonacoWorkspace.prototype.removeModel = function (model) {
        var uri = model.uri.toString();
        var document = this.documents.get(uri);
        if (document) {
            this.documents.delete(uri);
            this.onDidCloseTextDocumentEmitter.fire(document);
        }
    };
    MonacoWorkspace.prototype.addModel = function (model) {
        var _this = this;
        var uri = model.uri.toString();
        var document = this.setModel(uri, model);
        this.onDidOpenTextDocumentEmitter.fire(document);
        model.onDidChangeContent(function (event) {
            return _this.onDidChangeContent(uri, model, event);
        });
    };
    MonacoWorkspace.prototype.onDidChangeContent = function (uri, model, event) {
        var textDocument = this.setModel(uri, model);
        var contentChanges = [];
        for (var _i = 0, _a = event.changes; _i < _a.length; _i++) {
            var change = _a[_i];
            var range = this.m2p.asRange(change.range);
            var rangeLength = change.rangeLength;
            var text = change.text;
            contentChanges.push({ range: range, rangeLength: rangeLength, text: text });
        }
        this.onDidChangeTextDocumentEmitter.fire({
            textDocument: textDocument,
            contentChanges: contentChanges
        });
    };
    MonacoWorkspace.prototype.setModel = function (uri, model) {
        var document = services_1.TextDocument.create(uri, model.getModeId(), model.getVersionId(), model.getValue());
        this.documents.set(uri, document);
        return document;
    };
    Object.defineProperty(MonacoWorkspace.prototype, "textDocuments", {
        get: function () {
            return Array.from(this.documents.values());
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(MonacoWorkspace.prototype, "onDidOpenTextDocument", {
        get: function () {
            return this.onDidOpenTextDocumentEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(MonacoWorkspace.prototype, "onDidCloseTextDocument", {
        get: function () {
            return this.onDidCloseTextDocumentEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(MonacoWorkspace.prototype, "onDidChangeTextDocument", {
        get: function () {
            return this.onDidChangeTextDocumentEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    MonacoWorkspace.prototype.applyEdit = function (workspaceEdit) {
        var edit = this.p2m.asWorkspaceEdit(workspaceEdit);
        // Collect all referenced models
        var models = edit.edits.reduce(function (acc, currentEdit) {
            var textEdit = currentEdit;
            acc[textEdit.resource.toString()] = monaco.editor.getModel(textEdit.resource);
            return acc;
        }, {});
        // If any of the models do not exist, refuse to apply the edit.
        if (!Object.keys(models).map(function (uri) { return models[uri]; }).every(function (model) { return !!model; })) {
            return Promise.resolve(false);
        }
        // Group edits by resource so we can batch them when applying
        var editsByResource = edit.edits.reduce(function (acc, currentEdit) {
            var _a;
            var textEdit = currentEdit;
            var uri = textEdit.resource.toString();
            if (!(uri in acc)) {
                acc[uri] = [];
            }
            var operations = textEdit.edits.map(function (edit) {
                return {
                    range: monaco.Range.lift(edit.range),
                    text: edit.text
                };
            });
            (_a = acc[uri]).push.apply(_a, operations);
            return acc;
        }, {});
        // Apply edits for each resource
        Object.keys(editsByResource).forEach(function (uri) {
            models[uri].pushEditOperations([], // Do not try and preserve editor selections.
            editsByResource[uri].map(function (resourceEdit) {
                return {
                    identifier: { major: 1, minor: 0 },
                    range: resourceEdit.range,
                    text: resourceEdit.text,
                    forceMoveMarkers: true,
                };
            }), function () { return []; });
        });
        return Promise.resolve(true);
    };
    return MonacoWorkspace;
}());
exports.MonacoWorkspace = MonacoWorkspace;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/services.js":
/*!*************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/services.js ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
var main_1 = __webpack_require__(/*! vscode-languageserver-protocol/lib/main */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-jsonrpc/lib/main.js");
exports.Disposable = vscode_jsonrpc_1.Disposable;
exports.CancellationToken = vscode_jsonrpc_1.CancellationToken;
exports.Event = vscode_jsonrpc_1.Event;
exports.Emitter = vscode_jsonrpc_1.Emitter;
__export(__webpack_require__(/*! vscode-languageserver-protocol/lib/main */ "../node_modules/vscode-languageserver-protocol/lib/main.js"));
var Services;
(function (Services) {
    var global = window;
    var symbol = Symbol('Services');
    Services.get = function () {
        var services = global[symbol];
        if (!services) {
            throw new Error('Language Client services has not been installed');
        }
        return services;
    };
    function install(services) {
        if (global[symbol]) {
            console.error(new Error('Language Client services has been overriden'));
        }
        global[symbol] = services;
    }
    Services.install = install;
})(Services = exports.Services || (exports.Services = {}));
function isDocumentSelector(selector) {
    if (!selector || !Array.isArray(selector)) {
        return false;
    }
    return selector.every(function (value) { return typeof value === 'string' || main_1.DocumentFilter.is(value); });
}
exports.isDocumentSelector = isDocumentSelector;
var DocumentIdentifier;
(function (DocumentIdentifier) {
    function is(arg) {
        return !!arg && ('uri' in arg) && ('languageId' in arg);
    }
    DocumentIdentifier.is = is;
})(DocumentIdentifier = exports.DocumentIdentifier || (exports.DocumentIdentifier = {}));
var ConfigurationTarget;
(function (ConfigurationTarget) {
    ConfigurationTarget[ConfigurationTarget["Global"] = 1] = "Global";
    ConfigurationTarget[ConfigurationTarget["Workspace"] = 2] = "Workspace";
    ConfigurationTarget[ConfigurationTarget["WorkspaceFolder"] = 3] = "WorkspaceFolder";
})(ConfigurationTarget = exports.ConfigurationTarget || (exports.ConfigurationTarget = {}));


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/vscode-api.js":
/*!***************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/vscode-api.js ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
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
var vscode_uri_1 = __webpack_require__(/*! vscode-uri */ "../node_modules/vscode-uri/lib/esm/index.js");
var disposable_1 = __webpack_require__(/*! ./disposable */ "../node_modules/monaco-languageclient/lib/disposable.js");
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
function createVSCodeApi(servicesProvider) {
    var _this = this;
    var unsupported = function () { throw new Error('unsupported'); };
    var Uri = vscode_uri_1.default;
    var CompletionItem = /** @class */ (function () {
        function CompletionItem(label, kind) {
            this.label = label;
            this.kind = kind;
        }
        return CompletionItem;
    }());
    var CodeLens = /** @class */ (function () {
        function CodeLens(range, command) {
            this.range = range;
            this.command = command;
        }
        Object.defineProperty(CodeLens.prototype, "isResolved", {
            get: function () {
                return !!this.command;
            },
            enumerable: true,
            configurable: true
        });
        return CodeLens;
    }());
    var DocumentLink = /** @class */ (function () {
        function DocumentLink(range, target) {
            this.range = range;
            this.target = target;
        }
        return DocumentLink;
    }());
    var CodeActionKind = /** @class */ (function () {
        function CodeActionKind(value) {
            this.value = value;
            this.append = unsupported;
            this.contains = unsupported;
        }
        CodeActionKind.Empty = new CodeActionKind();
        CodeActionKind.QuickFix = new CodeActionKind('quickfix');
        CodeActionKind.Refactor = new CodeActionKind('refactor');
        CodeActionKind.RefactorExtract = new CodeActionKind('refactor.extract');
        CodeActionKind.RefactorInline = new CodeActionKind('refactor.inline');
        CodeActionKind.RefactorRewrite = new CodeActionKind('refactor.rewrite');
        CodeActionKind.Source = new CodeActionKind('source');
        CodeActionKind.SourceOrganizeImports = new CodeActionKind('source.organizeImports');
        return CodeActionKind;
    }());
    var workspace = {
        createFileSystemWatcher: function (globPattern, ignoreCreateEvents, ignoreChangeEvents, ignoreDeleteEvents) {
            var services = servicesProvider();
            if (typeof globPattern !== 'string') {
                throw new Error('unsupported');
            }
            if (services.workspace.createFileSystemWatcher) {
                var watcher = services.workspace.createFileSystemWatcher(globPattern, ignoreCreateEvents, ignoreChangeEvents, ignoreDeleteEvents);
                return Object.assign(watcher, {
                    ignoreCreateEvents: !!ignoreCreateEvents,
                    ignoreChangeEvents: !!ignoreChangeEvents,
                    ignoreDeleteEvents: !!ignoreDeleteEvents,
                });
            }
            return {
                ignoreCreateEvents: !!ignoreCreateEvents,
                ignoreChangeEvents: !!ignoreChangeEvents,
                ignoreDeleteEvents: !!ignoreDeleteEvents,
                onDidCreate: services_1.Event.None,
                onDidChange: services_1.Event.None,
                onDidDelete: services_1.Event.None,
                dispose: function () { }
            };
        },
        applyEdit: function (edit) { return __awaiter(_this, void 0, void 0, function () {
            var services;
            return __generator(this, function (_a) {
                services = servicesProvider();
                if (services_1.WorkspaceEdit.is(edit)) {
                    return [2 /*return*/, services.workspace.applyEdit(edit)];
                }
                throw new Error('unsupported');
            });
        }); },
        getConfiguration: function (section, resource) {
            var workspace = servicesProvider().workspace;
            var configuration = workspace.configurations ?
                workspace.configurations.getConfiguration(section, resource ? resource.toString() : undefined) :
                undefined;
            var result = {
                get: function (section, defaultValue) {
                    return configuration ? configuration.get(section, defaultValue) : defaultValue;
                },
                has: function (section) {
                    return configuration ? configuration.has(section) : false;
                },
                inspect: unsupported,
                update: unsupported
            };
            return Object.assign(result, {
                toJSON: function () { return configuration ? configuration.toJSON() : undefined; }
            });
        },
        get onDidChangeConfiguration() {
            var services = servicesProvider();
            if (services.workspace.configurations) {
                return services.workspace.configurations.onDidChangeConfiguration;
            }
            return services_1.Event.None;
        },
        get workspaceFolders() {
            var services = servicesProvider();
            var rootUri = services.workspace.rootUri;
            if (!rootUri) {
                return undefined;
            }
            var uri = Uri.parse(rootUri);
            return [{
                    uri: uri,
                    index: 0,
                    name: uri.toString()
                }];
        },
        get textDocuments() {
            var services = servicesProvider();
            return services.workspace.textDocuments;
        },
        get onDidOpenTextDocument() {
            var services = servicesProvider();
            return services.workspace.onDidOpenTextDocument;
        },
        get onDidCloseTextDocument() {
            var services = servicesProvider();
            return services.workspace.onDidCloseTextDocument;
        },
        get onDidChangeTextDocument() {
            var services = servicesProvider();
            return function (listener, thisArgs, disposables) {
                return services.workspace.onDidChangeTextDocument(function (_a) {
                    var textDocument = _a.textDocument, contentChanges = _a.contentChanges;
                    var l = listener.bind(thisArgs);
                    l({
                        document: textDocument,
                        contentChanges: contentChanges
                    });
                }, undefined, disposables);
            };
        },
        get onWillSaveTextDocument() {
            var services = servicesProvider();
            var onWillSaveTextDocument = services.workspace.onWillSaveTextDocument;
            if (!onWillSaveTextDocument) {
                return services_1.Event.None;
            }
            return function (listener, thisArgs, disposables) {
                return onWillSaveTextDocument(function (_a) {
                    var textDocument = _a.textDocument, reason = _a.reason, waitUntil = _a.waitUntil;
                    var l = listener.bind(thisArgs);
                    l({
                        document: textDocument,
                        reason: reason,
                        waitUntil: function (edits) {
                            if (waitUntil) {
                                waitUntil(edits);
                            }
                        }
                    });
                }, undefined, disposables);
            };
        },
        get onDidSaveTextDocument() {
            var services = servicesProvider();
            return services.workspace.onDidSaveTextDocument || services_1.Event.None;
        },
        onDidChangeWorkspaceFolders: services_1.Event.None,
        getWorkspaceFolder: unsupported,
        asRelativePath: unsupported,
        updateWorkspaceFolders: unsupported,
        findFiles: unsupported,
        saveAll: unsupported,
        openTextDocument: unsupported,
        registerTextDocumentContentProvider: unsupported,
        registerTaskProvider: unsupported,
        registerFileSystemProvider: unsupported,
        rootPath: undefined,
        name: undefined
    };
    var languages = {
        match: function (selector, document) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            if (!services_1.DocumentIdentifier.is(document)) {
                throw new Error('unexpected document: ' + JSON.stringify(document));
            }
            var services = servicesProvider();
            var result = services.languages.match(selector, document);
            return result ? 1 : 0;
        },
        createDiagnosticCollection: function (name) {
            var services = servicesProvider();
            var collection = services.languages.createDiagnosticCollection ?
                services.languages.createDiagnosticCollection(name) : undefined;
            return {
                name: name || 'default',
                set: function (arg0, arg1) {
                    if (collection) {
                        if (arg1) {
                            collection.set(arg0.toString(), arg1);
                        }
                        else {
                            collection.set(arg0.toString(), []);
                        }
                    }
                },
                dispose: function () {
                    if (collection) {
                        collection.dispose();
                    }
                },
                delete: unsupported,
                clear: unsupported,
                forEach: unsupported,
                get: unsupported,
                has: unsupported
            };
        },
        registerCompletionItemProvider: function (selector, provider) {
            var triggerCharacters = [];
            for (var _i = 2; _i < arguments.length; _i++) {
                triggerCharacters[_i - 2] = arguments[_i];
            }
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerCompletionItemProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            var resolveCompletionItem = provider.resolveCompletionItem;
            return languages.registerCompletionItemProvider.apply(languages, [selector, {
                    provideCompletionItems: function (_a, token) {
                        var textDocument = _a.textDocument, position = _a.position, context = _a.context;
                        return provider.provideCompletionItems(textDocument, position, token, context || {
                            triggerKind: services_1.CompletionTriggerKind.Invoked
                        });
                    },
                    resolveCompletionItem: resolveCompletionItem ? function (item, token) {
                        return resolveCompletionItem(item, token);
                    } : undefined
                }].concat(triggerCharacters));
        },
        registerCodeActionsProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerCodeActionsProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerCodeActionsProvider(selector, {
                provideCodeActions: function (_a, token) {
                    var textDocument = _a.textDocument, range = _a.range, context = _a.context;
                    return provider.provideCodeActions(textDocument, range, context, token);
                }
            });
        },
        registerCodeLensProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerCodeLensProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            var resolveCodeLens = provider.resolveCodeLens;
            return languages.registerCodeLensProvider(selector, {
                provideCodeLenses: function (_a, token) {
                    var textDocument = _a.textDocument;
                    return provider.provideCodeLenses(textDocument, token);
                },
                resolveCodeLens: resolveCodeLens ? function (codeLens, token) {
                    return resolveCodeLens(codeLens, token);
                } : undefined
            });
        },
        registerDefinitionProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDefinitionProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerDefinitionProvider(selector, {
                provideDefinition: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position;
                    return provider.provideDefinition(textDocument, position, token);
                }
            });
        },
        registerImplementationProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerImplementationProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerImplementationProvider(selector, {
                provideImplementation: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position;
                    return provider.provideImplementation(textDocument, position, token);
                }
            });
        },
        registerTypeDefinitionProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerTypeDefinitionProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerTypeDefinitionProvider(selector, {
                provideTypeDefinition: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position;
                    return provider.provideTypeDefinition(textDocument, position, token);
                }
            });
        },
        registerHoverProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (languages.registerHoverProvider) {
                return languages.registerHoverProvider(selector, {
                    provideHover: function (_a, token) {
                        var textDocument = _a.textDocument, position = _a.position;
                        return provider.provideHover(textDocument, position, token);
                    }
                });
            }
            return disposable_1.Disposable.create(function () { });
        },
        registerDocumentHighlightProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDocumentHighlightProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerDocumentHighlightProvider(selector, {
                provideDocumentHighlights: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position;
                    return provider.provideDocumentHighlights(textDocument, position, token);
                }
            });
        },
        registerDocumentSymbolProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDocumentSymbolProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerDocumentSymbolProvider(selector, {
                provideDocumentSymbols: function (_a, token) {
                    var textDocument = _a.textDocument;
                    return provider.provideDocumentSymbols(textDocument, token);
                }
            });
        },
        registerWorkspaceSymbolProvider: function (provider) {
            var languages = servicesProvider().languages;
            if (!languages.registerWorkspaceSymbolProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerWorkspaceSymbolProvider({
                provideWorkspaceSymbols: function (_a, token) {
                    var query = _a.query;
                    return provider.provideWorkspaceSymbols(query, token);
                }
            });
        },
        registerReferenceProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerReferenceProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerReferenceProvider(selector, {
                provideReferences: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position, context = _a.context;
                    return provider.provideReferences(textDocument, position, context, token);
                }
            });
        },
        registerRenameProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerRenameProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerRenameProvider(selector, {
                provideRenameEdits: function (_a, token) {
                    var textDocument = _a.textDocument, position = _a.position, newName = _a.newName;
                    return provider.provideRenameEdits(textDocument, position, newName, token);
                }
            });
        },
        registerDocumentFormattingEditProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDocumentFormattingEditProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerDocumentFormattingEditProvider(selector, {
                provideDocumentFormattingEdits: function (_a, token) {
                    var textDocument = _a.textDocument, options = _a.options;
                    return provider.provideDocumentFormattingEdits(textDocument, options, token);
                }
            });
        },
        registerDocumentRangeFormattingEditProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDocumentRangeFormattingEditProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerDocumentRangeFormattingEditProvider(selector, {
                provideDocumentRangeFormattingEdits: function (_a, token) {
                    var textDocument = _a.textDocument, range = _a.range, options = _a.options;
                    return provider.provideDocumentRangeFormattingEdits(textDocument, range, options, token);
                }
            });
        },
        registerOnTypeFormattingEditProvider: function (selector, provider, firstTriggerCharacter) {
            var moreTriggerCharacter = [];
            for (var _i = 3; _i < arguments.length; _i++) {
                moreTriggerCharacter[_i - 3] = arguments[_i];
            }
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerOnTypeFormattingEditProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerOnTypeFormattingEditProvider.apply(languages, [selector, {
                    provideOnTypeFormattingEdits: function (_a, token) {
                        var textDocument = _a.textDocument, position = _a.position, ch = _a.ch, options = _a.options;
                        return provider.provideOnTypeFormattingEdits(textDocument, position, ch, options, token);
                    }
                }, firstTriggerCharacter].concat(moreTriggerCharacter));
        },
        registerSignatureHelpProvider: function (selector, provider) {
            var triggerCharacter = [];
            for (var _i = 2; _i < arguments.length; _i++) {
                triggerCharacter[_i - 2] = arguments[_i];
            }
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerSignatureHelpProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerSignatureHelpProvider.apply(languages, [selector, {
                    provideSignatureHelp: function (_a, token) {
                        var textDocument = _a.textDocument, position = _a.position;
                        return provider.provideSignatureHelp(textDocument, position, token);
                    }
                }].concat(triggerCharacter));
        },
        registerDocumentLinkProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerDocumentLinkProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            var resolveDocumentLink = provider.resolveDocumentLink;
            return languages.registerDocumentLinkProvider(selector, {
                provideDocumentLinks: function (_a, token) {
                    var textDocument = _a.textDocument;
                    return provider.provideDocumentLinks(textDocument, token);
                },
                resolveDocumentLink: resolveDocumentLink ? function (link, token) {
                    return resolveDocumentLink(link, token);
                } : undefined
            });
        },
        registerColorProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerColorProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerColorProvider(selector, {
                provideDocumentColors: function (_a, token) {
                    var textDocument = _a.textDocument;
                    return provider.provideDocumentColors(textDocument, token);
                },
                provideColorPresentations: function (_a, token) {
                    var textDocument = _a.textDocument, color = _a.color, range = _a.range;
                    return provider.provideColorPresentations(color, {
                        document: textDocument,
                        range: range
                    }, token);
                }
            });
        },
        registerFoldingRangeProvider: function (selector, provider) {
            if (!services_1.isDocumentSelector(selector)) {
                throw new Error('unexpected selector: ' + JSON.stringify(selector));
            }
            var languages = servicesProvider().languages;
            if (!languages.registerFoldingRangeProvider) {
                return disposable_1.Disposable.create(function () { });
            }
            return languages.registerFoldingRangeProvider(selector, {
                provideFoldingRanges: function (_a, token) {
                    var textDocument = _a.textDocument;
                    return provider.provideFoldingRanges(textDocument, {}, token);
                }
            });
        },
        getLanguages: unsupported,
        getDiagnostics: unsupported,
        setLanguageConfiguration: unsupported,
        onDidChangeDiagnostics: unsupported
    };
    function showMessage(type, arg0, arg1) {
        if (typeof arg0 !== "string") {
            throw new Error('unexpected message: ' + JSON.stringify(arg0));
        }
        var message = arg0;
        if (arg1 !== undefined && !Array.isArray(arg1)) {
            throw new Error('unexpected actions: ' + JSON.stringify(arg1));
        }
        var actions = arg1 || [];
        var window = servicesProvider().window;
        if (!window) {
            return Promise.resolve(undefined);
        }
        return window.showMessage.apply(window, [type, message].concat(actions));
    }
    var window = {
        showInformationMessage: showMessage.bind(undefined, services_1.MessageType.Info),
        showWarningMessage: showMessage.bind(undefined, services_1.MessageType.Warning),
        showErrorMessage: showMessage.bind(undefined, services_1.MessageType.Error),
        createOutputChannel: function (name) {
            var window = servicesProvider().window;
            var createOutputChannel = window ? window.createOutputChannel : undefined;
            var channel = createOutputChannel ? createOutputChannel.bind(window)(name) : undefined;
            return {
                name: name,
                append: channel.append.bind(channel),
                appendLine: channel.appendLine.bind(channel),
                clear: unsupported,
                show: channel.show.bind(channel),
                hide: unsupported,
                dispose: channel.dispose.bind(channel)
            };
        },
        showTextDocument: unsupported,
        createTextEditorDecorationType: unsupported,
        showQuickPick: unsupported,
        showWorkspaceFolderPick: unsupported,
        showOpenDialog: unsupported,
        showSaveDialog: unsupported,
        showInputBox: unsupported,
        createWebviewPanel: unsupported,
        setStatusBarMessage: unsupported,
        withScmProgress: unsupported,
        withProgress: unsupported,
        createStatusBarItem: unsupported,
        createTerminal: unsupported,
        registerTreeDataProvider: unsupported,
        createTreeView: unsupported,
        registerWebviewPanelSerializer: unsupported,
        get activeTextEditor() {
            return unsupported();
        },
        get visibleTextEditors() {
            return unsupported();
        },
        onDidChangeActiveTextEditor: unsupported,
        onDidChangeVisibleTextEditors: unsupported,
        onDidChangeTextEditorSelection: unsupported,
        onDidChangeTextEditorVisibleRanges: unsupported,
        onDidChangeTextEditorOptions: unsupported,
        onDidChangeTextEditorViewColumn: unsupported,
        onDidCloseTerminal: unsupported,
        get state() {
            return unsupported();
        },
        onDidChangeWindowState: unsupported
    };
    var commands = {
        registerCommand: function (command, callback, thisArg) {
            var commands = servicesProvider().commands;
            if (!commands) {
                return disposable_1.Disposable.create(function () { });
            }
            return commands.registerCommand(command, callback, thisArg);
        },
        registerTextEditorCommand: unsupported,
        executeCommand: unsupported,
        getCommands: unsupported
    };
    var CodeDisposable = /** @class */ (function () {
        function CodeDisposable(callOnDispose) {
            this.callOnDispose = callOnDispose;
        }
        CodeDisposable.prototype.dispose = function () {
            this.callOnDispose();
        };
        return CodeDisposable;
    }());
    return {
        workspace: workspace,
        languages: languages,
        window: window,
        commands: commands,
        Uri: Uri,
        CompletionItem: CompletionItem,
        CodeLens: CodeLens,
        DocumentLink: DocumentLink,
        CodeActionKind: CodeActionKind,
        Disposable: CodeDisposable
    };
}
exports.createVSCodeApi = createVSCodeApi;


/***/ }),

/***/ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js":
/*!*************************************************************************!*\
  !*** ../node_modules/monaco-languageclient/lib/vscode-compatibility.js ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/* --------------------------------------------------------------------------------------------
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io). All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
var vscode_api_1 = __webpack_require__(/*! ./vscode-api */ "../node_modules/monaco-languageclient/lib/vscode-api.js");
var services_1 = __webpack_require__(/*! ./services */ "../node_modules/monaco-languageclient/lib/services.js");
module.exports = vscode_api_1.createVSCodeApi(services_1.Services.get);


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/client.js":
/*!****************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/client.js ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(process) {/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var c2p = __webpack_require__(/*! ./codeConverter */ "../node_modules/vscode-base-languageclient/lib/codeConverter.js");
var p2c = __webpack_require__(/*! ./protocolConverter */ "../node_modules/vscode-base-languageclient/lib/protocolConverter.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var async_1 = __webpack_require__(/*! ./utils/async */ "../node_modules/vscode-base-languageclient/lib/utils/async.js");
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
__export(__webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js"));
var ConsoleLogger = /** @class */ (function () {
    function ConsoleLogger() {
    }
    ConsoleLogger.prototype.error = function (message) {
        console.error(message);
    };
    ConsoleLogger.prototype.warn = function (message) {
        console.warn(message);
    };
    ConsoleLogger.prototype.info = function (message) {
        console.info(message);
    };
    ConsoleLogger.prototype.log = function (message) {
        console.log(message);
    };
    return ConsoleLogger;
}());
function createConnection(input, output, errorHandler, closeHandler) {
    var logger = new ConsoleLogger();
    var connection = vscode_languageserver_protocol_1.createProtocolConnection(input, output, logger);
    connection.onError(function (data) { errorHandler(data[0], data[1], data[2]); });
    connection.onClose(closeHandler);
    var result = {
        listen: function () { return connection.listen(); },
        sendRequest: function (type) {
            var params = [];
            for (var _i = 1; _i < arguments.length; _i++) {
                params[_i - 1] = arguments[_i];
            }
            return connection.sendRequest.apply(connection, __spread([Is.string(type) ? type : type.method], params));
        },
        onRequest: function (type, handler) { return connection.onRequest(Is.string(type) ? type : type.method, handler); },
        sendNotification: function (type, params) { return connection.sendNotification(Is.string(type) ? type : type.method, params); },
        onNotification: function (type, handler) { return connection.onNotification(Is.string(type) ? type : type.method, handler); },
        trace: function (value, tracer, sendNotification) {
            if (sendNotification === void 0) { sendNotification = false; }
            return connection.trace(value, tracer, sendNotification);
        },
        initialize: function (params) { return connection.sendRequest(vscode_languageserver_protocol_1.InitializeRequest.type, params); },
        shutdown: function () { return connection.sendRequest(vscode_languageserver_protocol_1.ShutdownRequest.type, undefined); },
        exit: function () { return connection.sendNotification(vscode_languageserver_protocol_1.ExitNotification.type); },
        onLogMessage: function (handler) { return connection.onNotification(vscode_languageserver_protocol_1.LogMessageNotification.type, handler); },
        onShowMessage: function (handler) { return connection.onNotification(vscode_languageserver_protocol_1.ShowMessageNotification.type, handler); },
        onTelemetry: function (handler) { return connection.onNotification(vscode_languageserver_protocol_1.TelemetryEventNotification.type, handler); },
        didChangeConfiguration: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidChangeConfigurationNotification.type, params); },
        didChangeWatchedFiles: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidChangeWatchedFilesNotification.type, params); },
        didOpenTextDocument: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidOpenTextDocumentNotification.type, params); },
        didChangeTextDocument: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type, params); },
        didCloseTextDocument: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidCloseTextDocumentNotification.type, params); },
        didSaveTextDocument: function (params) { return connection.sendNotification(vscode_languageserver_protocol_1.DidSaveTextDocumentNotification.type, params); },
        onDiagnostics: function (handler) { return connection.onNotification(vscode_languageserver_protocol_1.PublishDiagnosticsNotification.type, handler); },
        dispose: function () { return connection.dispose(); }
    };
    return result;
}
/**
 * An action to be performed when the connection is producing errors.
 */
var ErrorAction;
(function (ErrorAction) {
    /**
     * Continue running the server.
     */
    ErrorAction[ErrorAction["Continue"] = 1] = "Continue";
    /**
     * Shutdown the server.
     */
    ErrorAction[ErrorAction["Shutdown"] = 2] = "Shutdown";
})(ErrorAction = exports.ErrorAction || (exports.ErrorAction = {}));
/**
 * An action to be performed when the connection to a server got closed.
 */
var CloseAction;
(function (CloseAction) {
    /**
     * Don't restart the server. The connection stays closed.
     */
    CloseAction[CloseAction["DoNotRestart"] = 1] = "DoNotRestart";
    /**
     * Restart the server.
     */
    CloseAction[CloseAction["Restart"] = 2] = "Restart";
})(CloseAction = exports.CloseAction || (exports.CloseAction = {}));
var DefaultErrorHandler = /** @class */ (function () {
    function DefaultErrorHandler(name) {
        this.name = name;
        this.restarts = [];
    }
    DefaultErrorHandler.prototype.error = function (_error, _message, count) {
        if (count && count <= 3) {
            return ErrorAction.Continue;
        }
        return ErrorAction.Shutdown;
    };
    DefaultErrorHandler.prototype.closed = function () {
        this.restarts.push(Date.now());
        if (this.restarts.length < 5) {
            return CloseAction.Restart;
        }
        else {
            var diff = this.restarts[this.restarts.length - 1] - this.restarts[0];
            if (diff <= 3 * 60 * 1000) {
                vscode_1.window.showErrorMessage("The " + this.name + " server crashed 5 times in the last 3 minutes. The server will not be restarted.");
                return CloseAction.DoNotRestart;
            }
            else {
                this.restarts.shift();
                return CloseAction.Restart;
            }
        }
    };
    return DefaultErrorHandler;
}());
var RevealOutputChannelOn;
(function (RevealOutputChannelOn) {
    RevealOutputChannelOn[RevealOutputChannelOn["Info"] = 1] = "Info";
    RevealOutputChannelOn[RevealOutputChannelOn["Warn"] = 2] = "Warn";
    RevealOutputChannelOn[RevealOutputChannelOn["Error"] = 3] = "Error";
    RevealOutputChannelOn[RevealOutputChannelOn["Never"] = 4] = "Never";
})(RevealOutputChannelOn = exports.RevealOutputChannelOn || (exports.RevealOutputChannelOn = {}));
var State;
(function (State) {
    State[State["Stopped"] = 1] = "Stopped";
    State[State["Running"] = 2] = "Running";
})(State = exports.State || (exports.State = {}));
var ClientState;
(function (ClientState) {
    ClientState[ClientState["Initial"] = 0] = "Initial";
    ClientState[ClientState["Starting"] = 1] = "Starting";
    ClientState[ClientState["StartFailed"] = 2] = "StartFailed";
    ClientState[ClientState["Running"] = 3] = "Running";
    ClientState[ClientState["Stopping"] = 4] = "Stopping";
    ClientState[ClientState["Stopped"] = 5] = "Stopped";
})(ClientState || (ClientState = {}));
var SupporedSymbolKinds = [
    vscode_languageserver_protocol_1.SymbolKind.File,
    vscode_languageserver_protocol_1.SymbolKind.Module,
    vscode_languageserver_protocol_1.SymbolKind.Namespace,
    vscode_languageserver_protocol_1.SymbolKind.Package,
    vscode_languageserver_protocol_1.SymbolKind.Class,
    vscode_languageserver_protocol_1.SymbolKind.Method,
    vscode_languageserver_protocol_1.SymbolKind.Property,
    vscode_languageserver_protocol_1.SymbolKind.Field,
    vscode_languageserver_protocol_1.SymbolKind.Constructor,
    vscode_languageserver_protocol_1.SymbolKind.Enum,
    vscode_languageserver_protocol_1.SymbolKind.Interface,
    vscode_languageserver_protocol_1.SymbolKind.Function,
    vscode_languageserver_protocol_1.SymbolKind.Variable,
    vscode_languageserver_protocol_1.SymbolKind.Constant,
    vscode_languageserver_protocol_1.SymbolKind.String,
    vscode_languageserver_protocol_1.SymbolKind.Number,
    vscode_languageserver_protocol_1.SymbolKind.Boolean,
    vscode_languageserver_protocol_1.SymbolKind.Array,
    vscode_languageserver_protocol_1.SymbolKind.Object,
    vscode_languageserver_protocol_1.SymbolKind.Key,
    vscode_languageserver_protocol_1.SymbolKind.Null,
    vscode_languageserver_protocol_1.SymbolKind.EnumMember,
    vscode_languageserver_protocol_1.SymbolKind.Struct,
    vscode_languageserver_protocol_1.SymbolKind.Event,
    vscode_languageserver_protocol_1.SymbolKind.Operator,
    vscode_languageserver_protocol_1.SymbolKind.TypeParameter
];
var SupportedCompletionItemKinds = [
    vscode_languageserver_protocol_1.CompletionItemKind.Text,
    vscode_languageserver_protocol_1.CompletionItemKind.Method,
    vscode_languageserver_protocol_1.CompletionItemKind.Function,
    vscode_languageserver_protocol_1.CompletionItemKind.Constructor,
    vscode_languageserver_protocol_1.CompletionItemKind.Field,
    vscode_languageserver_protocol_1.CompletionItemKind.Variable,
    vscode_languageserver_protocol_1.CompletionItemKind.Class,
    vscode_languageserver_protocol_1.CompletionItemKind.Interface,
    vscode_languageserver_protocol_1.CompletionItemKind.Module,
    vscode_languageserver_protocol_1.CompletionItemKind.Property,
    vscode_languageserver_protocol_1.CompletionItemKind.Unit,
    vscode_languageserver_protocol_1.CompletionItemKind.Value,
    vscode_languageserver_protocol_1.CompletionItemKind.Enum,
    vscode_languageserver_protocol_1.CompletionItemKind.Keyword,
    vscode_languageserver_protocol_1.CompletionItemKind.Snippet,
    vscode_languageserver_protocol_1.CompletionItemKind.Color,
    vscode_languageserver_protocol_1.CompletionItemKind.File,
    vscode_languageserver_protocol_1.CompletionItemKind.Reference,
    vscode_languageserver_protocol_1.CompletionItemKind.Folder,
    vscode_languageserver_protocol_1.CompletionItemKind.EnumMember,
    vscode_languageserver_protocol_1.CompletionItemKind.Constant,
    vscode_languageserver_protocol_1.CompletionItemKind.Struct,
    vscode_languageserver_protocol_1.CompletionItemKind.Event,
    vscode_languageserver_protocol_1.CompletionItemKind.Operator,
    vscode_languageserver_protocol_1.CompletionItemKind.TypeParameter
];
function ensure(target, key) {
    if (target[key] === void 0) {
        target[key] = {};
    }
    return target[key];
}
var DynamicFeature;
(function (DynamicFeature) {
    function is(value) {
        var candidate = value;
        return candidate && Is.func(candidate.register) && Is.func(candidate.unregister) && Is.func(candidate.dispose) && candidate.messages !== void 0;
    }
    DynamicFeature.is = is;
})(DynamicFeature || (DynamicFeature = {}));
var DocumentNotifiactions = /** @class */ (function () {
    function DocumentNotifiactions(_client, _event, _type, _middleware, _createParams, _selectorFilter) {
        this._client = _client;
        this._event = _event;
        this._type = _type;
        this._middleware = _middleware;
        this._createParams = _createParams;
        this._selectorFilter = _selectorFilter;
        this._selectors = new Map();
    }
    DocumentNotifiactions.textDocumentFilter = function (selectors, textDocument) {
        var e_1, _a;
        try {
            for (var selectors_1 = __values(selectors), selectors_1_1 = selectors_1.next(); !selectors_1_1.done; selectors_1_1 = selectors_1.next()) {
                var selector = selectors_1_1.value;
                if (vscode_1.languages.match(selector, textDocument)) {
                    return true;
                }
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (selectors_1_1 && !selectors_1_1.done && (_a = selectors_1.return)) _a.call(selectors_1);
            }
            finally { if (e_1) throw e_1.error; }
        }
        return false;
    };
    DocumentNotifiactions.prototype.register = function (_message, data) {
        if (!data.registerOptions.documentSelector) {
            return;
        }
        if (!this._listener) {
            this._listener = this._event(this.callback, this);
        }
        this._selectors.set(data.id, data.registerOptions.documentSelector);
    };
    DocumentNotifiactions.prototype.callback = function (data) {
        var _this = this;
        if (!this._selectorFilter || this._selectorFilter(this._selectors.values(), data)) {
            if (this._middleware) {
                this._middleware(data, function (data) { return _this._client.sendNotification(_this._type, _this._createParams(data)); });
            }
            else {
                this._client.sendNotification(this._type, this._createParams(data));
            }
            this.notificationSent(data);
        }
    };
    DocumentNotifiactions.prototype.notificationSent = function (_data) {
    };
    DocumentNotifiactions.prototype.unregister = function (id) {
        this._selectors.delete(id);
        if (this._selectors.size === 0 && this._listener) {
            this._listener.dispose();
            this._listener = undefined;
        }
    };
    DocumentNotifiactions.prototype.dispose = function () {
        this._selectors.clear();
        if (this._listener) {
            this._listener.dispose();
        }
    };
    return DocumentNotifiactions;
}());
var DidOpenTextDocumentFeature = /** @class */ (function (_super) {
    __extends(DidOpenTextDocumentFeature, _super);
    function DidOpenTextDocumentFeature(client, _syncedDocuments) {
        var _this = _super.call(this, client, vscode_1.workspace.onDidOpenTextDocument, vscode_languageserver_protocol_1.DidOpenTextDocumentNotification.type, client.clientOptions.middleware.didOpen, function (textDocument) { return client.code2ProtocolConverter.asOpenTextDocumentParams(textDocument); }, DocumentNotifiactions.textDocumentFilter) || this;
        _this._syncedDocuments = _syncedDocuments;
        return _this;
    }
    Object.defineProperty(DidOpenTextDocumentFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidOpenTextDocumentNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    DidOpenTextDocumentFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'textDocument'), 'synchronization').dynamicRegistration = true;
    };
    DidOpenTextDocumentFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.openClose) {
            this.register(this.messages, { id: UUID.generateUuid(), registerOptions: { documentSelector: documentSelector } });
        }
    };
    DidOpenTextDocumentFeature.prototype.register = function (message, data) {
        var _this = this;
        _super.prototype.register.call(this, message, data);
        if (!data.registerOptions.documentSelector) {
            return;
        }
        var documentSelector = data.registerOptions.documentSelector;
        vscode_1.workspace.textDocuments.forEach(function (textDocument) {
            var uri = textDocument.uri.toString();
            if (_this._syncedDocuments.has(uri)) {
                return;
            }
            if (vscode_1.languages.match(documentSelector, textDocument)) {
                var middleware = _this._client.clientOptions.middleware;
                var didOpen = function (textDocument) {
                    _this._client.sendNotification(_this._type, _this._createParams(textDocument));
                };
                if (middleware.didOpen) {
                    middleware.didOpen(textDocument, didOpen);
                }
                else {
                    didOpen(textDocument);
                }
                _this._syncedDocuments.set(uri, textDocument);
            }
        });
    };
    DidOpenTextDocumentFeature.prototype.notificationSent = function (textDocument) {
        _super.prototype.notificationSent.call(this, textDocument);
        this._syncedDocuments.set(textDocument.uri.toString(), textDocument);
    };
    return DidOpenTextDocumentFeature;
}(DocumentNotifiactions));
var DidCloseTextDocumentFeature = /** @class */ (function (_super) {
    __extends(DidCloseTextDocumentFeature, _super);
    function DidCloseTextDocumentFeature(client, _syncedDocuments) {
        var _this = _super.call(this, client, vscode_1.workspace.onDidCloseTextDocument, vscode_languageserver_protocol_1.DidCloseTextDocumentNotification.type, client.clientOptions.middleware.didClose, function (textDocument) { return client.code2ProtocolConverter.asCloseTextDocumentParams(textDocument); }, DocumentNotifiactions.textDocumentFilter) || this;
        _this._syncedDocuments = _syncedDocuments;
        return _this;
    }
    Object.defineProperty(DidCloseTextDocumentFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidCloseTextDocumentNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    DidCloseTextDocumentFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'textDocument'), 'synchronization').dynamicRegistration = true;
    };
    DidCloseTextDocumentFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.openClose) {
            this.register(this.messages, { id: UUID.generateUuid(), registerOptions: { documentSelector: documentSelector } });
        }
    };
    DidCloseTextDocumentFeature.prototype.notificationSent = function (textDocument) {
        _super.prototype.notificationSent.call(this, textDocument);
        this._syncedDocuments.delete(textDocument.uri.toString());
    };
    DidCloseTextDocumentFeature.prototype.unregister = function (id) {
        var _this = this;
        var selector = this._selectors.get(id);
        // The super call removed the selector from the map
        // of selectors.
        _super.prototype.unregister.call(this, id);
        var selectors = this._selectors.values();
        this._syncedDocuments.forEach(function (textDocument) {
            if (vscode_1.languages.match(selector, textDocument) && !_this._selectorFilter(selectors, textDocument)) {
                var middleware = _this._client.clientOptions.middleware;
                var didClose = function (textDocument) {
                    _this._client.sendNotification(_this._type, _this._createParams(textDocument));
                };
                _this._syncedDocuments.delete(textDocument.uri.toString());
                if (middleware.didClose) {
                    middleware.didClose(textDocument, didClose);
                }
                else {
                    didClose(textDocument);
                }
            }
        });
    };
    return DidCloseTextDocumentFeature;
}(DocumentNotifiactions));
var DidChangeTextDocumentFeature = /** @class */ (function () {
    function DidChangeTextDocumentFeature(_client) {
        this._client = _client;
        this._changeData = new Map();
        this._forcingDelivery = false;
    }
    Object.defineProperty(DidChangeTextDocumentFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    DidChangeTextDocumentFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'textDocument'), 'synchronization').dynamicRegistration = true;
    };
    DidChangeTextDocumentFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.change !== void 0 && textDocumentSyncOptions.change !== vscode_languageserver_protocol_1.TextDocumentSyncKind.None) {
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: Object.assign({}, { documentSelector: documentSelector }, { syncKind: textDocumentSyncOptions.change })
            });
        }
    };
    DidChangeTextDocumentFeature.prototype.register = function (_message, data) {
        if (!data.registerOptions.documentSelector) {
            return;
        }
        if (!this._listener) {
            this._listener = vscode_1.workspace.onDidChangeTextDocument(this.callback, this);
        }
        this._changeData.set(data.id, {
            documentSelector: data.registerOptions.documentSelector,
            syncKind: data.registerOptions.syncKind
        });
    };
    DidChangeTextDocumentFeature.prototype.callback = function (event) {
        var e_2, _a;
        var _this = this;
        // Text document changes are send for dirty changes as well. We don't
        // have dirty / undirty events in the LSP so we ignore content changes
        // with length zero.
        if (event.contentChanges.length === 0) {
            return;
        }
        var _loop_1 = function (changeData) {
            if (vscode_1.languages.match(changeData.documentSelector, event.document)) {
                var middleware = this_1._client.clientOptions.middleware;
                if (changeData.syncKind === vscode_languageserver_protocol_1.TextDocumentSyncKind.Incremental) {
                    var params_1 = this_1._client.code2ProtocolConverter.asChangeTextDocumentParams(event);
                    if (middleware.didChange) {
                        middleware.didChange(event, function () { return _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type, params_1); });
                    }
                    else {
                        this_1._client.sendNotification(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type, params_1);
                    }
                }
                else if (changeData.syncKind === vscode_languageserver_protocol_1.TextDocumentSyncKind.Full) {
                    var didChange = function (event) {
                        if (_this._changeDelayer) {
                            if (_this._changeDelayer.uri !== event.document.uri.toString()) {
                                // Use this force delivery to track boolean state. Otherwise we might call two times.
                                _this.forceDelivery();
                                _this._changeDelayer.uri = event.document.uri.toString();
                            }
                            _this._changeDelayer.delayer.trigger(function () {
                                _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type, _this._client.code2ProtocolConverter.asChangeTextDocumentParams(event.document));
                            });
                        }
                        else {
                            _this._changeDelayer = {
                                uri: event.document.uri.toString(),
                                delayer: new async_1.Delayer(200)
                            };
                            _this._changeDelayer.delayer.trigger(function () {
                                _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type, _this._client.code2ProtocolConverter.asChangeTextDocumentParams(event.document));
                            }, -1);
                        }
                    };
                    if (middleware.didChange) {
                        middleware.didChange(event, didChange);
                    }
                    else {
                        didChange(event);
                    }
                }
            }
        };
        var this_1 = this;
        try {
            for (var _b = __values(this._changeData.values()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var changeData = _c.value;
                _loop_1(changeData);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
    };
    DidChangeTextDocumentFeature.prototype.unregister = function (id) {
        this._changeData.delete(id);
        if (this._changeData.size === 0 && this._listener) {
            this._listener.dispose();
            this._listener = undefined;
        }
    };
    DidChangeTextDocumentFeature.prototype.dispose = function () {
        this._changeDelayer = undefined;
        this._forcingDelivery = false;
        this._changeData.clear();
        if (this._listener) {
            this._listener.dispose();
            this._listener = undefined;
        }
    };
    DidChangeTextDocumentFeature.prototype.forceDelivery = function () {
        if (this._forcingDelivery || !this._changeDelayer) {
            return;
        }
        try {
            this._forcingDelivery = true;
            this._changeDelayer.delayer.forceDelivery();
        }
        finally {
            this._forcingDelivery = false;
        }
    };
    return DidChangeTextDocumentFeature;
}());
var WillSaveFeature = /** @class */ (function (_super) {
    __extends(WillSaveFeature, _super);
    function WillSaveFeature(client) {
        return _super.call(this, client, vscode_1.workspace.onWillSaveTextDocument, vscode_languageserver_protocol_1.WillSaveTextDocumentNotification.type, client.clientOptions.middleware.willSave, function (willSaveEvent) { return client.code2ProtocolConverter.asWillSaveTextDocumentParams(willSaveEvent); }, function (selectors, willSaveEvent) { return DocumentNotifiactions.textDocumentFilter(selectors, willSaveEvent.document); }) || this;
    }
    Object.defineProperty(WillSaveFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.WillSaveTextDocumentNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    WillSaveFeature.prototype.fillClientCapabilities = function (capabilities) {
        var value = ensure(ensure(capabilities, 'textDocument'), 'synchronization');
        value.willSave = true;
    };
    WillSaveFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.willSave) {
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: { documentSelector: documentSelector }
            });
        }
    };
    return WillSaveFeature;
}(DocumentNotifiactions));
var WillSaveWaitUntilFeature = /** @class */ (function () {
    function WillSaveWaitUntilFeature(_client) {
        this._client = _client;
        this._selectors = new Map();
    }
    Object.defineProperty(WillSaveWaitUntilFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.WillSaveTextDocumentWaitUntilRequest.type;
        },
        enumerable: true,
        configurable: true
    });
    WillSaveWaitUntilFeature.prototype.fillClientCapabilities = function (capabilities) {
        var value = ensure(ensure(capabilities, 'textDocument'), 'synchronization');
        value.willSaveWaitUntil = true;
    };
    WillSaveWaitUntilFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.willSaveWaitUntil) {
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: { documentSelector: documentSelector }
            });
        }
    };
    WillSaveWaitUntilFeature.prototype.register = function (_message, data) {
        if (!data.registerOptions.documentSelector) {
            return;
        }
        if (!this._listener) {
            this._listener = vscode_1.workspace.onWillSaveTextDocument(this.callback, this);
        }
        this._selectors.set(data.id, data.registerOptions.documentSelector);
    };
    WillSaveWaitUntilFeature.prototype.callback = function (event) {
        var _this = this;
        if (DocumentNotifiactions.textDocumentFilter(this._selectors.values(), event.document)) {
            var middleware = this._client.clientOptions.middleware;
            var willSaveWaitUntil = function (event) {
                return _this._client.sendRequest(vscode_languageserver_protocol_1.WillSaveTextDocumentWaitUntilRequest.type, _this._client.code2ProtocolConverter.asWillSaveTextDocumentParams(event)).then(function (edits) {
                    var vEdits = _this._client.protocol2CodeConverter.asTextEdits(edits);
                    return vEdits === void 0 ? [] : vEdits;
                });
            };
            event.waitUntil(middleware.willSaveWaitUntil
                ? middleware.willSaveWaitUntil(event, willSaveWaitUntil)
                : willSaveWaitUntil(event));
        }
    };
    WillSaveWaitUntilFeature.prototype.unregister = function (id) {
        this._selectors.delete(id);
        if (this._selectors.size === 0 && this._listener) {
            this._listener.dispose();
            this._listener = undefined;
        }
    };
    WillSaveWaitUntilFeature.prototype.dispose = function () {
        this._selectors.clear();
        if (this._listener) {
            this._listener.dispose();
            this._listener = undefined;
        }
    };
    return WillSaveWaitUntilFeature;
}());
var DidSaveTextDocumentFeature = /** @class */ (function (_super) {
    __extends(DidSaveTextDocumentFeature, _super);
    function DidSaveTextDocumentFeature(client) {
        var _this = _super.call(this, client, vscode_1.workspace.onDidSaveTextDocument, vscode_languageserver_protocol_1.DidSaveTextDocumentNotification.type, client.clientOptions.middleware.didSave, function (textDocument) { return client.code2ProtocolConverter.asSaveTextDocumentParams(textDocument, _this._includeText); }, DocumentNotifiactions.textDocumentFilter) || this;
        return _this;
    }
    Object.defineProperty(DidSaveTextDocumentFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidSaveTextDocumentNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    DidSaveTextDocumentFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'textDocument'), 'synchronization').didSave = true;
    };
    DidSaveTextDocumentFeature.prototype.initialize = function (capabilities, documentSelector) {
        var textDocumentSyncOptions = capabilities.resolvedTextDocumentSync;
        if (documentSelector && textDocumentSyncOptions && textDocumentSyncOptions.save) {
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: Object.assign({}, { documentSelector: documentSelector }, { includeText: !!textDocumentSyncOptions.save.includeText })
            });
        }
    };
    DidSaveTextDocumentFeature.prototype.register = function (method, data) {
        this._includeText = !!data.registerOptions.includeText;
        _super.prototype.register.call(this, method, data);
    };
    return DidSaveTextDocumentFeature;
}(DocumentNotifiactions));
var FileSystemWatcherFeature = /** @class */ (function () {
    function FileSystemWatcherFeature(_client, _notifyFileEvent) {
        this._client = _client;
        this._notifyFileEvent = _notifyFileEvent;
        this._watchers = new Map();
    }
    Object.defineProperty(FileSystemWatcherFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidChangeWatchedFilesNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    FileSystemWatcherFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'workspace'), 'didChangeWatchedFiles').dynamicRegistration = true;
    };
    FileSystemWatcherFeature.prototype.initialize = function (_capabilities, _documentSelector) {
    };
    FileSystemWatcherFeature.prototype.register = function (_method, data) {
        var e_3, _a;
        if (!Array.isArray(data.registerOptions.watchers)) {
            return;
        }
        var disposeables = [];
        try {
            for (var _b = __values(data.registerOptions.watchers), _c = _b.next(); !_c.done; _c = _b.next()) {
                var watcher = _c.value;
                if (!Is.string(watcher.globPattern)) {
                    continue;
                }
                var watchCreate = true, watchChange = true, watchDelete = true;
                if (watcher.kind !== void 0 && watcher.kind !== null) {
                    watchCreate = (watcher.kind & vscode_languageserver_protocol_1.WatchKind.Create) !== 0;
                    watchChange = (watcher.kind & vscode_languageserver_protocol_1.WatchKind.Change) != 0;
                    watchDelete = (watcher.kind & vscode_languageserver_protocol_1.WatchKind.Delete) != 0;
                }
                var fileSystemWatcher = vscode_1.workspace.createFileSystemWatcher(watcher.globPattern, !watchCreate, !watchChange, !watchDelete);
                this.hookListeners(fileSystemWatcher, watchCreate, watchChange, watchDelete);
                disposeables.push(fileSystemWatcher);
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_3) throw e_3.error; }
        }
        this._watchers.set(data.id, disposeables);
    };
    FileSystemWatcherFeature.prototype.registerRaw = function (id, fileSystemWatchers) {
        var e_4, _a;
        var disposeables = [];
        try {
            for (var fileSystemWatchers_1 = __values(fileSystemWatchers), fileSystemWatchers_1_1 = fileSystemWatchers_1.next(); !fileSystemWatchers_1_1.done; fileSystemWatchers_1_1 = fileSystemWatchers_1.next()) {
                var fileSystemWatcher = fileSystemWatchers_1_1.value;
                this.hookListeners(fileSystemWatcher, true, true, true, disposeables);
            }
        }
        catch (e_4_1) { e_4 = { error: e_4_1 }; }
        finally {
            try {
                if (fileSystemWatchers_1_1 && !fileSystemWatchers_1_1.done && (_a = fileSystemWatchers_1.return)) _a.call(fileSystemWatchers_1);
            }
            finally { if (e_4) throw e_4.error; }
        }
        this._watchers.set(id, disposeables);
    };
    FileSystemWatcherFeature.prototype.hookListeners = function (fileSystemWatcher, watchCreate, watchChange, watchDelete, listeners) {
        var _this = this;
        if (watchCreate) {
            fileSystemWatcher.onDidCreate(function (resource) { return _this._notifyFileEvent({
                uri: _this._client.code2ProtocolConverter.asUri(resource),
                type: vscode_languageserver_protocol_1.FileChangeType.Created
            }); }, null, listeners);
        }
        if (watchChange) {
            fileSystemWatcher.onDidChange(function (resource) { return _this._notifyFileEvent({
                uri: _this._client.code2ProtocolConverter.asUri(resource),
                type: vscode_languageserver_protocol_1.FileChangeType.Changed
            }); }, null, listeners);
        }
        if (watchDelete) {
            fileSystemWatcher.onDidDelete(function (resource) { return _this._notifyFileEvent({
                uri: _this._client.code2ProtocolConverter.asUri(resource),
                type: vscode_languageserver_protocol_1.FileChangeType.Deleted
            }); }, null, listeners);
        }
    };
    FileSystemWatcherFeature.prototype.unregister = function (id) {
        var e_5, _a;
        var disposeables = this._watchers.get(id);
        if (disposeables) {
            try {
                for (var disposeables_1 = __values(disposeables), disposeables_1_1 = disposeables_1.next(); !disposeables_1_1.done; disposeables_1_1 = disposeables_1.next()) {
                    var disposable = disposeables_1_1.value;
                    disposable.dispose();
                }
            }
            catch (e_5_1) { e_5 = { error: e_5_1 }; }
            finally {
                try {
                    if (disposeables_1_1 && !disposeables_1_1.done && (_a = disposeables_1.return)) _a.call(disposeables_1);
                }
                finally { if (e_5) throw e_5.error; }
            }
        }
    };
    FileSystemWatcherFeature.prototype.dispose = function () {
        this._watchers.forEach(function (disposeables) {
            var e_6, _a;
            try {
                for (var disposeables_2 = __values(disposeables), disposeables_2_1 = disposeables_2.next(); !disposeables_2_1.done; disposeables_2_1 = disposeables_2.next()) {
                    var disposable = disposeables_2_1.value;
                    disposable.dispose();
                }
            }
            catch (e_6_1) { e_6 = { error: e_6_1 }; }
            finally {
                try {
                    if (disposeables_2_1 && !disposeables_2_1.done && (_a = disposeables_2.return)) _a.call(disposeables_2);
                }
                finally { if (e_6) throw e_6.error; }
            }
        });
        this._watchers.clear();
    };
    return FileSystemWatcherFeature;
}());
var TextDocumentFeature = /** @class */ (function () {
    function TextDocumentFeature(_client, _message) {
        this._client = _client;
        this._message = _message;
        this._providers = new Map();
    }
    Object.defineProperty(TextDocumentFeature.prototype, "messages", {
        get: function () {
            return this._message;
        },
        enumerable: true,
        configurable: true
    });
    TextDocumentFeature.prototype.register = function (message, data) {
        if (message.method !== this.messages.method) {
            throw new Error("Register called on wrong feature. Requested " + message.method + " but reached feature " + this.messages.method);
        }
        if (!data.registerOptions.documentSelector) {
            return;
        }
        var provider = this.registerLanguageProvider(data.registerOptions);
        if (provider) {
            this._providers.set(data.id, provider);
        }
    };
    TextDocumentFeature.prototype.unregister = function (id) {
        var provider = this._providers.get(id);
        if (provider) {
            provider.dispose();
        }
    };
    TextDocumentFeature.prototype.dispose = function () {
        this._providers.forEach(function (value) {
            value.dispose();
        });
        this._providers.clear();
    };
    return TextDocumentFeature;
}());
exports.TextDocumentFeature = TextDocumentFeature;
var WorkspaceFeature = /** @class */ (function () {
    function WorkspaceFeature(_client, _message) {
        this._client = _client;
        this._message = _message;
        this._providers = new Map();
    }
    Object.defineProperty(WorkspaceFeature.prototype, "messages", {
        get: function () {
            return this._message;
        },
        enumerable: true,
        configurable: true
    });
    WorkspaceFeature.prototype.register = function (message, data) {
        if (message.method !== this.messages.method) {
            throw new Error("Register called on wron feature. Requested " + message.method + " but reached feature " + this.messages.method);
        }
        var provider = this.registerLanguageProvider(data.registerOptions);
        if (provider) {
            this._providers.set(data.id, provider);
        }
    };
    WorkspaceFeature.prototype.unregister = function (id) {
        var provider = this._providers.get(id);
        if (provider) {
            provider.dispose();
        }
    };
    WorkspaceFeature.prototype.dispose = function () {
        this._providers.forEach(function (value) {
            value.dispose();
        });
        this._providers.clear();
    };
    return WorkspaceFeature;
}());
var CompletionItemFeature = /** @class */ (function (_super) {
    __extends(CompletionItemFeature, _super);
    function CompletionItemFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.CompletionRequest.type) || this;
    }
    CompletionItemFeature.prototype.fillClientCapabilities = function (capabilites) {
        var completion = ensure(ensure(capabilites, 'textDocument'), 'completion');
        completion.dynamicRegistration = true;
        completion.contextSupport = true;
        completion.completionItem = {
            snippetSupport: true,
            commitCharactersSupport: true,
            documentationFormat: [vscode_languageserver_protocol_1.MarkupKind.Markdown, vscode_languageserver_protocol_1.MarkupKind.PlainText],
            deprecatedSupport: true,
            preselectSupport: true
        };
        completion.completionItemKind = { valueSet: SupportedCompletionItemKinds };
    };
    CompletionItemFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.completionProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilities.completionProvider)
        });
    };
    CompletionItemFeature.prototype.registerLanguageProvider = function (options) {
        var triggerCharacters = options.triggerCharacters || [];
        var client = this._client;
        var provideCompletionItems = function (document, position, context, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.CompletionRequest.type, client.code2ProtocolConverter.asCompletionParams(document, position, context), token).then(client.protocol2CodeConverter.asCompletionResult, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.CompletionRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var resolveCompletionItem = function (item, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.CompletionResolveRequest.type, client.code2ProtocolConverter.asCompletionItem(item), token).then(client.protocol2CodeConverter.asCompletionItem, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.CompletionResolveRequest.type, error);
                return Promise.resolve(item);
            });
        };
        var middleware = this._client.clientOptions.middleware;
        return vscode_1.languages.registerCompletionItemProvider.apply(vscode_1.languages, __spread([options.documentSelector, {
                provideCompletionItems: function (document, position, token, context) {
                    return middleware.provideCompletionItem
                        ? middleware.provideCompletionItem(document, position, context, token, provideCompletionItems)
                        : provideCompletionItems(document, position, context, token);
                },
                resolveCompletionItem: options.resolveProvider
                    ? function (item, token) {
                        return middleware.resolveCompletionItem
                            ? middleware.resolveCompletionItem(item, token, resolveCompletionItem)
                            : resolveCompletionItem(item, token);
                    }
                    : undefined
            }], triggerCharacters));
    };
    return CompletionItemFeature;
}(TextDocumentFeature));
var HoverFeature = /** @class */ (function (_super) {
    __extends(HoverFeature, _super);
    function HoverFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.HoverRequest.type) || this;
    }
    HoverFeature.prototype.fillClientCapabilities = function (capabilites) {
        var hoverCapability = (ensure(ensure(capabilites, 'textDocument'), 'hover'));
        hoverCapability.dynamicRegistration = true;
        hoverCapability.contentFormat = [vscode_languageserver_protocol_1.MarkupKind.Markdown, vscode_languageserver_protocol_1.MarkupKind.PlainText];
    };
    HoverFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.hoverProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    HoverFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideHover = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.HoverRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asHover, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.HoverRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerHoverProvider(options.documentSelector, {
            provideHover: function (document, position, token) {
                return middleware.provideHover
                    ? middleware.provideHover(document, position, token, provideHover)
                    : provideHover(document, position, token);
            }
        });
    };
    return HoverFeature;
}(TextDocumentFeature));
var SignatureHelpFeature = /** @class */ (function (_super) {
    __extends(SignatureHelpFeature, _super);
    function SignatureHelpFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.SignatureHelpRequest.type) || this;
    }
    SignatureHelpFeature.prototype.fillClientCapabilities = function (capabilites) {
        var config = ensure(ensure(capabilites, 'textDocument'), 'signatureHelp');
        config.dynamicRegistration = true;
        config.signatureInformation = { documentationFormat: [vscode_languageserver_protocol_1.MarkupKind.Markdown, vscode_languageserver_protocol_1.MarkupKind.PlainText] };
    };
    SignatureHelpFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.signatureHelpProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilities.signatureHelpProvider)
        });
    };
    SignatureHelpFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var providerSignatureHelp = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.SignatureHelpRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asSignatureHelp, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.SignatureHelpRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        var triggerCharacters = options.triggerCharacters || [];
        return vscode_1.languages.registerSignatureHelpProvider.apply(vscode_1.languages, __spread([options.documentSelector, {
                provideSignatureHelp: function (document, position, token) {
                    return middleware.provideSignatureHelp
                        ? middleware.provideSignatureHelp(document, position, token, providerSignatureHelp)
                        : providerSignatureHelp(document, position, token);
                }
            }], triggerCharacters));
    };
    return SignatureHelpFeature;
}(TextDocumentFeature));
var DefinitionFeature = /** @class */ (function (_super) {
    __extends(DefinitionFeature, _super);
    function DefinitionFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DefinitionRequest.type) || this;
    }
    DefinitionFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'definition').dynamicRegistration = true;
    };
    DefinitionFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.definitionProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    DefinitionFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDefinition = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.DefinitionRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asDefinitionResult, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DefinitionRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDefinitionProvider(options.documentSelector, {
            provideDefinition: function (document, position, token) {
                return middleware.provideDefinition
                    ? middleware.provideDefinition(document, position, token, provideDefinition)
                    : provideDefinition(document, position, token);
            }
        });
    };
    return DefinitionFeature;
}(TextDocumentFeature));
var ReferencesFeature = /** @class */ (function (_super) {
    __extends(ReferencesFeature, _super);
    function ReferencesFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.ReferencesRequest.type) || this;
    }
    ReferencesFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'references').dynamicRegistration = true;
    };
    ReferencesFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.referencesProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    ReferencesFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var providerReferences = function (document, position, options, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.ReferencesRequest.type, client.code2ProtocolConverter.asReferenceParams(document, position, options), token).then(client.protocol2CodeConverter.asReferences, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.ReferencesRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerReferenceProvider(options.documentSelector, {
            provideReferences: function (document, position, options, token) {
                return middleware.provideReferences
                    ? middleware.provideReferences(document, position, options, token, providerReferences)
                    : providerReferences(document, position, options, token);
            }
        });
    };
    return ReferencesFeature;
}(TextDocumentFeature));
var DocumentHighlightFeature = /** @class */ (function (_super) {
    __extends(DocumentHighlightFeature, _super);
    function DocumentHighlightFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentHighlightRequest.type) || this;
    }
    DocumentHighlightFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'documentHighlight').dynamicRegistration = true;
    };
    DocumentHighlightFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentHighlightProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    DocumentHighlightFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDocumentHighlights = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentHighlightRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asDocumentHighlights, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentHighlightRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDocumentHighlightProvider(options.documentSelector, {
            provideDocumentHighlights: function (document, position, token) {
                return middleware.provideDocumentHighlights
                    ? middleware.provideDocumentHighlights(document, position, token, provideDocumentHighlights)
                    : provideDocumentHighlights(document, position, token);
            }
        });
    };
    return DocumentHighlightFeature;
}(TextDocumentFeature));
var DocumentSymbolFeature = /** @class */ (function (_super) {
    __extends(DocumentSymbolFeature, _super);
    function DocumentSymbolFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentSymbolRequest.type) || this;
    }
    DocumentSymbolFeature.prototype.fillClientCapabilities = function (capabilites) {
        var symbolCapabilities = ensure(ensure(capabilites, 'textDocument'), 'documentSymbol');
        symbolCapabilities.dynamicRegistration = true;
        symbolCapabilities.symbolKind = {
            valueSet: SupporedSymbolKinds
        };
        symbolCapabilities.hierarchicalDocumentSymbolSupport = true;
    };
    DocumentSymbolFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentSymbolProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    DocumentSymbolFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDocumentSymbols = function (document, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentSymbolRequest.type, client.code2ProtocolConverter.asDocumentSymbolParams(document), token).then(function (data) {
                if (data === null) {
                    return undefined;
                }
                if (data.length === 0) {
                    return [];
                }
                else {
                    var element = data[0];
                    if (vscode_languageserver_protocol_1.DocumentSymbol.is(element)) {
                        return client.protocol2CodeConverter.asDocumentSymbols(data);
                    }
                    else {
                        return client.protocol2CodeConverter.asSymbolInformations(data);
                    }
                }
            }, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentSymbolRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDocumentSymbolProvider(options.documentSelector, {
            provideDocumentSymbols: function (document, token) {
                return middleware.provideDocumentSymbols
                    ? middleware.provideDocumentSymbols(document, token, provideDocumentSymbols)
                    : provideDocumentSymbols(document, token);
            }
        });
    };
    return DocumentSymbolFeature;
}(TextDocumentFeature));
var WorkspaceSymbolFeature = /** @class */ (function (_super) {
    __extends(WorkspaceSymbolFeature, _super);
    function WorkspaceSymbolFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.WorkspaceSymbolRequest.type) || this;
    }
    WorkspaceSymbolFeature.prototype.fillClientCapabilities = function (capabilites) {
        var symbolCapabilities = ensure(ensure(capabilites, 'workspace'), 'symbol');
        symbolCapabilities.dynamicRegistration = true;
        symbolCapabilities.symbolKind = {
            valueSet: SupporedSymbolKinds
        };
    };
    WorkspaceSymbolFeature.prototype.initialize = function (capabilities) {
        if (!capabilities.workspaceSymbolProvider) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: undefined
        });
    };
    WorkspaceSymbolFeature.prototype.registerLanguageProvider = function (_options) {
        var client = this._client;
        var provideWorkspaceSymbols = function (query, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.WorkspaceSymbolRequest.type, { query: query }, token).then(client.protocol2CodeConverter.asSymbolInformations, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.WorkspaceSymbolRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerWorkspaceSymbolProvider({
            provideWorkspaceSymbols: function (query, token) {
                return middleware.provideWorkspaceSymbols
                    ? middleware.provideWorkspaceSymbols(query, token, provideWorkspaceSymbols)
                    : provideWorkspaceSymbols(query, token);
            }
        });
    };
    return WorkspaceSymbolFeature;
}(WorkspaceFeature));
var CodeActionFeature = /** @class */ (function (_super) {
    __extends(CodeActionFeature, _super);
    function CodeActionFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.CodeActionRequest.type) || this;
    }
    CodeActionFeature.prototype.fillClientCapabilities = function (capabilites) {
        var cap = ensure(ensure(capabilites, 'textDocument'), 'codeAction');
        cap.dynamicRegistration = true;
        cap.codeActionLiteralSupport = {
            codeActionKind: {
                valueSet: [
                    '',
                    vscode_languageserver_protocol_1.CodeActionKind.QuickFix,
                    vscode_languageserver_protocol_1.CodeActionKind.Refactor,
                    vscode_languageserver_protocol_1.CodeActionKind.RefactorExtract,
                    vscode_languageserver_protocol_1.CodeActionKind.RefactorInline,
                    vscode_languageserver_protocol_1.CodeActionKind.RefactorRewrite,
                    vscode_languageserver_protocol_1.CodeActionKind.Source,
                    vscode_languageserver_protocol_1.CodeActionKind.SourceOrganizeImports
                ]
            }
        };
    };
    CodeActionFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.codeActionProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    CodeActionFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideCodeActions = function (document, range, context, token) {
            var params = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document),
                range: client.code2ProtocolConverter.asRange(range),
                context: client.code2ProtocolConverter.asCodeActionContext(context)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.CodeActionRequest.type, params, token).then(function (values) {
                var e_7, _a;
                if (values === null) {
                    return undefined;
                }
                var result = [];
                try {
                    for (var values_1 = __values(values), values_1_1 = values_1.next(); !values_1_1.done; values_1_1 = values_1.next()) {
                        var item = values_1_1.value;
                        if (vscode_languageserver_protocol_1.Command.is(item)) {
                            result.push(client.protocol2CodeConverter.asCommand(item));
                        }
                        else {
                            result.push(client.protocol2CodeConverter.asCodeAction(item));
                        }
                        ;
                    }
                }
                catch (e_7_1) { e_7 = { error: e_7_1 }; }
                finally {
                    try {
                        if (values_1_1 && !values_1_1.done && (_a = values_1.return)) _a.call(values_1);
                    }
                    finally { if (e_7) throw e_7.error; }
                }
                return result;
            }, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.CodeActionRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerCodeActionsProvider(options.documentSelector, {
            provideCodeActions: function (document, range, context, token) {
                return middleware.provideCodeActions
                    ? middleware.provideCodeActions(document, range, context, token, provideCodeActions)
                    : provideCodeActions(document, range, context, token);
            }
        });
    };
    return CodeActionFeature;
}(TextDocumentFeature));
var CodeLensFeature = /** @class */ (function (_super) {
    __extends(CodeLensFeature, _super);
    function CodeLensFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.CodeLensRequest.type) || this;
    }
    CodeLensFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'codeLens').dynamicRegistration = true;
    };
    CodeLensFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.codeLensProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilities.codeLensProvider)
        });
    };
    CodeLensFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideCodeLenses = function (document, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.CodeLensRequest.type, client.code2ProtocolConverter.asCodeLensParams(document), token).then(client.protocol2CodeConverter.asCodeLenses, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.CodeLensRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var resolveCodeLens = function (codeLens, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.CodeLensResolveRequest.type, client.code2ProtocolConverter.asCodeLens(codeLens), token).then(client.protocol2CodeConverter.asCodeLens, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.CodeLensResolveRequest.type, error);
                return codeLens;
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerCodeLensProvider(options.documentSelector, {
            provideCodeLenses: function (document, token) {
                return middleware.provideCodeLenses
                    ? middleware.provideCodeLenses(document, token, provideCodeLenses)
                    : provideCodeLenses(document, token);
            },
            resolveCodeLens: (options.resolveProvider)
                ? function (codeLens, token) {
                    return middleware.resolveCodeLens
                        ? middleware.resolveCodeLens(codeLens, token, resolveCodeLens)
                        : resolveCodeLens(codeLens, token);
                }
                : undefined
        });
    };
    return CodeLensFeature;
}(TextDocumentFeature));
var DocumentFormattingFeature = /** @class */ (function (_super) {
    __extends(DocumentFormattingFeature, _super);
    function DocumentFormattingFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentFormattingRequest.type) || this;
    }
    DocumentFormattingFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'formatting').dynamicRegistration = true;
    };
    DocumentFormattingFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentFormattingProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    DocumentFormattingFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDocumentFormattingEdits = function (document, options, token) {
            var params = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document),
                options: client.code2ProtocolConverter.asFormattingOptions(options)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentFormattingRequest.type, params, token).then(client.protocol2CodeConverter.asTextEdits, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentFormattingRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDocumentFormattingEditProvider(options.documentSelector, {
            provideDocumentFormattingEdits: function (document, options, token) {
                return middleware.provideDocumentFormattingEdits
                    ? middleware.provideDocumentFormattingEdits(document, options, token, provideDocumentFormattingEdits)
                    : provideDocumentFormattingEdits(document, options, token);
            }
        });
    };
    return DocumentFormattingFeature;
}(TextDocumentFeature));
var DocumentRangeFormattingFeature = /** @class */ (function (_super) {
    __extends(DocumentRangeFormattingFeature, _super);
    function DocumentRangeFormattingFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentRangeFormattingRequest.type) || this;
    }
    DocumentRangeFormattingFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'rangeFormatting').dynamicRegistration = true;
    };
    DocumentRangeFormattingFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentRangeFormattingProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    DocumentRangeFormattingFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDocumentRangeFormattingEdits = function (document, range, options, token) {
            var params = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document),
                range: client.code2ProtocolConverter.asRange(range),
                options: client.code2ProtocolConverter.asFormattingOptions(options)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentRangeFormattingRequest.type, params, token).then(client.protocol2CodeConverter.asTextEdits, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentRangeFormattingRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDocumentRangeFormattingEditProvider(options.documentSelector, {
            provideDocumentRangeFormattingEdits: function (document, range, options, token) {
                return middleware.provideDocumentRangeFormattingEdits
                    ? middleware.provideDocumentRangeFormattingEdits(document, range, options, token, provideDocumentRangeFormattingEdits)
                    : provideDocumentRangeFormattingEdits(document, range, options, token);
            }
        });
    };
    return DocumentRangeFormattingFeature;
}(TextDocumentFeature));
var DocumentOnTypeFormattingFeature = /** @class */ (function (_super) {
    __extends(DocumentOnTypeFormattingFeature, _super);
    function DocumentOnTypeFormattingFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentOnTypeFormattingRequest.type) || this;
    }
    DocumentOnTypeFormattingFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'onTypeFormatting').dynamicRegistration = true;
    };
    DocumentOnTypeFormattingFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentOnTypeFormattingProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilities.documentOnTypeFormattingProvider)
        });
    };
    DocumentOnTypeFormattingFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var moreTriggerCharacter = options.moreTriggerCharacter || [];
        var provideOnTypeFormattingEdits = function (document, position, ch, options, token) {
            var params = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document),
                position: client.code2ProtocolConverter.asPosition(position),
                ch: ch,
                options: client.code2ProtocolConverter.asFormattingOptions(options)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentOnTypeFormattingRequest.type, params, token).then(client.protocol2CodeConverter.asTextEdits, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentOnTypeFormattingRequest.type, error);
                return Promise.resolve([]);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerOnTypeFormattingEditProvider.apply(vscode_1.languages, __spread([options.documentSelector, {
                provideOnTypeFormattingEdits: function (document, position, ch, options, token) {
                    return middleware.provideOnTypeFormattingEdits
                        ? middleware.provideOnTypeFormattingEdits(document, position, ch, options, token, provideOnTypeFormattingEdits)
                        : provideOnTypeFormattingEdits(document, position, ch, options, token);
                }
            }, options.firstTriggerCharacter], moreTriggerCharacter));
    };
    return DocumentOnTypeFormattingFeature;
}(TextDocumentFeature));
var RenameFeature = /** @class */ (function (_super) {
    __extends(RenameFeature, _super);
    function RenameFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.RenameRequest.type) || this;
    }
    RenameFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'rename').dynamicRegistration = true;
    };
    RenameFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.renameProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector })
        });
    };
    RenameFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideRenameEdits = function (document, position, newName, token) {
            var params = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document),
                position: client.code2ProtocolConverter.asPosition(position),
                newName: newName
            };
            return client.sendRequest(vscode_languageserver_protocol_1.RenameRequest.type, params, token).then(client.protocol2CodeConverter.asWorkspaceEdit, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.RenameRequest.type, error);
                return Promise.reject(new Error(error.message));
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerRenameProvider(options.documentSelector, {
            provideRenameEdits: function (document, position, newName, token) {
                return middleware.provideRenameEdits
                    ? middleware.provideRenameEdits(document, position, newName, token, provideRenameEdits)
                    : provideRenameEdits(document, position, newName, token);
            }
        });
    };
    return RenameFeature;
}(TextDocumentFeature));
var DocumentLinkFeature = /** @class */ (function (_super) {
    __extends(DocumentLinkFeature, _super);
    function DocumentLinkFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentLinkRequest.type) || this;
    }
    DocumentLinkFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'documentLink').dynamicRegistration = true;
    };
    DocumentLinkFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.documentLinkProvider || !documentSelector) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilities.documentLinkProvider)
        });
    };
    DocumentLinkFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideDocumentLinks = function (document, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentLinkRequest.type, client.code2ProtocolConverter.asDocumentLinkParams(document), token).then(client.protocol2CodeConverter.asDocumentLinks, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentLinkRequest.type, error);
                Promise.resolve(new Error(error.message));
            });
        };
        var resolveDocumentLink = function (link, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentLinkResolveRequest.type, client.code2ProtocolConverter.asDocumentLink(link), token).then(client.protocol2CodeConverter.asDocumentLink, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.DocumentLinkResolveRequest.type, error);
                Promise.resolve(new Error(error.message));
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerDocumentLinkProvider(options.documentSelector, {
            provideDocumentLinks: function (document, token) {
                return middleware.provideDocumentLinks
                    ? middleware.provideDocumentLinks(document, token, provideDocumentLinks)
                    : provideDocumentLinks(document, token);
            },
            resolveDocumentLink: options.resolveProvider
                ? function (link, token) {
                    return middleware.resolveDocumentLink
                        ? middleware.resolveDocumentLink(link, token, resolveDocumentLink)
                        : resolveDocumentLink(link, token);
                }
                : undefined
        });
    };
    return DocumentLinkFeature;
}(TextDocumentFeature));
var ConfigurationFeature = /** @class */ (function () {
    function ConfigurationFeature(_client) {
        this._client = _client;
        this._listeners = new Map();
    }
    Object.defineProperty(ConfigurationFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidChangeConfigurationNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    ConfigurationFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'workspace'), 'didChangeConfiguration').dynamicRegistration = true;
    };
    ConfigurationFeature.prototype.initialize = function () {
        var section = this._client.clientOptions.synchronize.configurationSection;
        if (section !== void 0) {
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: {
                    section: section
                }
            });
        }
    };
    ConfigurationFeature.prototype.register = function (_message, data) {
        var _this = this;
        var disposable = vscode_1.workspace.onDidChangeConfiguration(function (event) {
            _this.onDidChangeConfiguration(data.registerOptions.section, event);
        });
        this._listeners.set(data.id, disposable);
        if (data.registerOptions.section !== void 0) {
            this.onDidChangeConfiguration(data.registerOptions.section, undefined);
        }
    };
    ConfigurationFeature.prototype.unregister = function (id) {
        var disposable = this._listeners.get(id);
        if (disposable) {
            this._listeners.delete(id);
            disposable.dispose();
        }
    };
    ConfigurationFeature.prototype.dispose = function () {
        var e_8, _a;
        try {
            for (var _b = __values(this._listeners.values()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var disposable = _c.value;
                disposable.dispose();
            }
        }
        catch (e_8_1) { e_8 = { error: e_8_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_8) throw e_8.error; }
        }
        this._listeners.clear();
    };
    ConfigurationFeature.prototype.onDidChangeConfiguration = function (configurationSection, event) {
        var _this = this;
        var sections;
        if (Is.string(configurationSection)) {
            sections = [configurationSection];
        }
        else {
            sections = configurationSection;
        }
        if (sections !== void 0 && event !== void 0) {
            var affected = sections.some(function (section) { return event.affectsConfiguration(section); });
            if (!affected) {
                return;
            }
        }
        var didChangeConfiguration = function (sections) {
            if (sections === void 0) {
                _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeConfigurationNotification.type, { settings: null });
                return;
            }
            _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeConfigurationNotification.type, { settings: _this.extractSettingsInformation(sections) });
        };
        var middleware = this.getMiddleware();
        middleware
            ? middleware(sections, didChangeConfiguration)
            : didChangeConfiguration(sections);
    };
    ConfigurationFeature.prototype.extractSettingsInformation = function (keys) {
        function ensurePath(config, path) {
            var current = config;
            for (var i = 0; i < path.length - 1; i++) {
                var obj = current[path[i]];
                if (!obj) {
                    obj = Object.create(null);
                    current[path[i]] = obj;
                }
                current = obj;
            }
            return current;
        }
        var resource = this._client.clientOptions.workspaceFolder
            ? this._client.clientOptions.workspaceFolder.uri
            : undefined;
        var result = Object.create(null);
        for (var i = 0; i < keys.length; i++) {
            var key = keys[i];
            var index = key.indexOf('.');
            var config = null;
            if (index >= 0) {
                config = vscode_1.workspace.getConfiguration(key.substr(0, index), resource).get(key.substr(index + 1));
            }
            else {
                config = vscode_1.workspace.getConfiguration(key, resource);
            }
            if (config) {
                var path = keys[i].split('.');
                ensurePath(result, path)[path[path.length - 1]] = config;
            }
        }
        return result;
    };
    ConfigurationFeature.prototype.getMiddleware = function () {
        var middleware = this._client.clientOptions.middleware;
        if (middleware.workspace && middleware.workspace.didChangeConfiguration) {
            return middleware.workspace.didChangeConfiguration;
        }
        else {
            return undefined;
        }
    };
    return ConfigurationFeature;
}());
var ExecuteCommandFeature = /** @class */ (function () {
    function ExecuteCommandFeature(_client) {
        this._client = _client;
        this._commands = new Map();
    }
    Object.defineProperty(ExecuteCommandFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.ExecuteCommandRequest.type;
        },
        enumerable: true,
        configurable: true
    });
    ExecuteCommandFeature.prototype.fillClientCapabilities = function (capabilities) {
        ensure(ensure(capabilities, 'workspace'), 'executeCommand').dynamicRegistration = true;
    };
    ExecuteCommandFeature.prototype.initialize = function (capabilities) {
        if (!capabilities.executeCommandProvider) {
            return;
        }
        this.register(this.messages, {
            id: UUID.generateUuid(),
            registerOptions: Object.assign({}, capabilities.executeCommandProvider)
        });
    };
    ExecuteCommandFeature.prototype.register = function (_message, data) {
        var e_9, _a;
        var client = this._client;
        if (data.registerOptions.commands) {
            var disposeables = [];
            var _loop_2 = function (command) {
                disposeables.push(vscode_1.commands.registerCommand(command, function () {
                    var args = [];
                    for (var _i = 0; _i < arguments.length; _i++) {
                        args[_i] = arguments[_i];
                    }
                    var params = {
                        command: command,
                        arguments: args
                    };
                    return client.sendRequest(vscode_languageserver_protocol_1.ExecuteCommandRequest.type, params).then(undefined, function (error) {
                        client.logFailedRequest(vscode_languageserver_protocol_1.ExecuteCommandRequest.type, error);
                    });
                }));
            };
            try {
                for (var _b = __values(data.registerOptions.commands), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var command = _c.value;
                    _loop_2(command);
                }
            }
            catch (e_9_1) { e_9 = { error: e_9_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_9) throw e_9.error; }
            }
            this._commands.set(data.id, disposeables);
        }
    };
    ExecuteCommandFeature.prototype.unregister = function (id) {
        var disposeables = this._commands.get(id);
        if (disposeables) {
            disposeables.forEach(function (disposable) { return disposable.dispose(); });
        }
    };
    ExecuteCommandFeature.prototype.dispose = function () {
        this._commands.forEach(function (value) {
            value.forEach(function (disposable) { return disposable.dispose(); });
        });
        this._commands.clear();
    };
    return ExecuteCommandFeature;
}());
var MessageTransports;
(function (MessageTransports) {
    function is(value) {
        var candidate = value;
        return candidate && vscode_languageserver_protocol_1.MessageReader.is(value.reader) && vscode_languageserver_protocol_1.MessageWriter.is(value.writer);
    }
    MessageTransports.is = is;
})(MessageTransports = exports.MessageTransports || (exports.MessageTransports = {}));
var BaseLanguageClient = /** @class */ (function () {
    function BaseLanguageClient(id, name, clientOptions) {
        var _this = this;
        this._features = [];
        this._method2Message = new Map();
        this._dynamicFeatures = new Map();
        this._id = id;
        this._name = name;
        clientOptions = clientOptions || {};
        this._clientOptions = {
            documentSelector: clientOptions.documentSelector || [],
            synchronize: clientOptions.synchronize || {},
            diagnosticCollectionName: clientOptions.diagnosticCollectionName,
            outputChannelName: clientOptions.outputChannelName || this._name,
            revealOutputChannelOn: clientOptions.revealOutputChannelOn || RevealOutputChannelOn.Error,
            stdioEncoding: clientOptions.stdioEncoding || 'utf8',
            initializationOptions: clientOptions.initializationOptions,
            initializationFailedHandler: clientOptions.initializationFailedHandler,
            errorHandler: clientOptions.errorHandler || new DefaultErrorHandler(this._name),
            middleware: clientOptions.middleware || {},
            uriConverters: clientOptions.uriConverters,
            workspaceFolder: clientOptions.workspaceFolder
        };
        this._clientOptions.synchronize = this._clientOptions.synchronize || {};
        this.state = ClientState.Initial;
        this._connectionPromise = undefined;
        this._resolvedConnection = undefined;
        this._initializeResult = undefined;
        if (clientOptions.outputChannel) {
            this._outputChannel = clientOptions.outputChannel;
            this._disposeOutputChannel = false;
        }
        else {
            this._outputChannel = undefined;
            this._disposeOutputChannel = true;
        }
        this._listeners = undefined;
        this._providers = undefined;
        this._diagnostics = undefined;
        this._fileEvents = [];
        this._fileEventDelayer = new async_1.Delayer(250);
        this._onReady = new Promise(function (resolve, reject) {
            _this._onReadyCallbacks = { resolve: resolve, reject: reject };
        });
        this._onStop = undefined;
        this._telemetryEmitter = new vscode_languageserver_protocol_1.Emitter();
        this._stateChangeEmitter = new vscode_languageserver_protocol_1.Emitter();
        this._tracer = {
            log: function (message, data) {
                _this.logTrace(message, data);
            }
        };
        this._c2p = c2p.createConverter(clientOptions.uriConverters ? clientOptions.uriConverters.code2Protocol : undefined);
        this._p2c = p2c.createConverter(clientOptions.uriConverters ? clientOptions.uriConverters.protocol2Code : undefined);
        this._syncedDocuments = new Map();
        this.registerBuiltinFeatures();
    }
    Object.defineProperty(BaseLanguageClient.prototype, "state", {
        get: function () {
            return this._state;
        },
        set: function (value) {
            var oldState = this.getPublicState();
            this._state = value;
            var newState = this.getPublicState();
            if (newState !== oldState) {
                this._stateChangeEmitter.fire({ oldState: oldState, newState: newState });
            }
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClient.prototype.getPublicState = function () {
        if (this.state === ClientState.Running) {
            return State.Running;
        }
        else {
            return State.Stopped;
        }
    };
    Object.defineProperty(BaseLanguageClient.prototype, "initializeResult", {
        get: function () {
            return this._initializeResult;
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClient.prototype.sendRequest = function (type) {
        var _a;
        var params = [];
        for (var _i = 1; _i < arguments.length; _i++) {
            params[_i - 1] = arguments[_i];
        }
        if (!this.isConnectionActive()) {
            throw new Error('Language client is not ready yet');
        }
        this.forceDocumentSync();
        try {
            return (_a = this._resolvedConnection).sendRequest.apply(_a, __spread([type], params));
        }
        catch (error) {
            this.error("Sending request " + (Is.string(type) ? type : type.method) + " failed.", error);
            throw error;
        }
    };
    BaseLanguageClient.prototype.onRequest = function (type, handler) {
        if (!this.isConnectionActive()) {
            throw new Error('Language client is not ready yet');
        }
        try {
            this._resolvedConnection.onRequest(type, handler);
        }
        catch (error) {
            this.error("Registering request handler " + (Is.string(type) ? type : type.method) + " failed.", error);
            throw error;
        }
    };
    BaseLanguageClient.prototype.sendNotification = function (type, params) {
        if (!this.isConnectionActive()) {
            throw new Error('Language client is not ready yet');
        }
        this.forceDocumentSync();
        try {
            this._resolvedConnection.sendNotification(type, params);
        }
        catch (error) {
            this.error("Sending notification " + (Is.string(type) ? type : type.method) + " failed.", error);
            throw error;
        }
    };
    BaseLanguageClient.prototype.onNotification = function (type, handler) {
        if (!this.isConnectionActive()) {
            throw new Error('Language client is not ready yet');
        }
        try {
            this._resolvedConnection.onNotification(type, handler);
        }
        catch (error) {
            this.error("Registering notification handler " + (Is.string(type) ? type : type.method) + " failed.", error);
            throw error;
        }
    };
    Object.defineProperty(BaseLanguageClient.prototype, "clientOptions", {
        get: function () {
            return this._clientOptions;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "protocol2CodeConverter", {
        get: function () {
            return this._p2c;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "code2ProtocolConverter", {
        get: function () {
            return this._c2p;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "onTelemetry", {
        get: function () {
            return this._telemetryEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "onDidChangeState", {
        get: function () {
            return this._stateChangeEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "outputChannel", {
        get: function () {
            if (!this._outputChannel) {
                this._outputChannel = vscode_1.window.createOutputChannel(this._clientOptions.outputChannelName ? this._clientOptions.outputChannelName : this._name);
            }
            return this._outputChannel;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(BaseLanguageClient.prototype, "diagnostics", {
        get: function () {
            return this._diagnostics;
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClient.prototype.createDefaultErrorHandler = function () {
        return new DefaultErrorHandler(this._name);
    };
    Object.defineProperty(BaseLanguageClient.prototype, "trace", {
        set: function (value) {
            var _this = this;
            this._trace = value;
            this.onReady().then(function () {
                _this.resolveConnection().then(function (connection) {
                    connection.trace(value, _this._tracer);
                });
            }, function () {
            });
        },
        enumerable: true,
        configurable: true
    });
    BaseLanguageClient.prototype.data2String = function (data) {
        if (data instanceof vscode_languageserver_protocol_1.ResponseError) {
            var responseError = data;
            return "  Message: " + responseError.message + "\n  Code: " + responseError.code + " " + (responseError.data ? '\n' + responseError.data.toString() : '');
        }
        if (data instanceof Error) {
            if (Is.string(data.stack)) {
                return data.stack;
            }
            return data.message;
        }
        if (Is.string(data)) {
            return data;
        }
        return data.toString();
    };
    BaseLanguageClient.prototype.info = function (message, data) {
        this.outputChannel.appendLine("[Info  - " + (new Date().toLocaleTimeString()) + "] " + message);
        if (data) {
            this.outputChannel.appendLine(this.data2String(data));
        }
        if (this._clientOptions.revealOutputChannelOn <= RevealOutputChannelOn.Info) {
            this.outputChannel.show(true);
        }
    };
    BaseLanguageClient.prototype.warn = function (message, data) {
        this.outputChannel.appendLine("[Warn  - " + (new Date().toLocaleTimeString()) + "] " + message);
        if (data) {
            this.outputChannel.appendLine(this.data2String(data));
        }
        if (this._clientOptions.revealOutputChannelOn <= RevealOutputChannelOn.Warn) {
            this.outputChannel.show(true);
        }
    };
    BaseLanguageClient.prototype.error = function (message, data) {
        this.outputChannel.appendLine("[Error - " + (new Date().toLocaleTimeString()) + "] " + message);
        if (data) {
            this.outputChannel.appendLine(this.data2String(data));
        }
        if (this._clientOptions.revealOutputChannelOn <= RevealOutputChannelOn.Error) {
            this.outputChannel.show(true);
        }
    };
    BaseLanguageClient.prototype.logTrace = function (message, data) {
        this.outputChannel.appendLine("[Trace - " + (new Date().toLocaleTimeString()) + "] " + message);
        if (data) {
            this.outputChannel.appendLine(this.data2String(data));
        }
    };
    BaseLanguageClient.prototype.needsStart = function () {
        return this.state === ClientState.Initial || this.state === ClientState.Stopping || this.state === ClientState.Stopped;
    };
    BaseLanguageClient.prototype.needsStop = function () {
        return this.state === ClientState.Starting || this.state === ClientState.Running;
    };
    BaseLanguageClient.prototype.onReady = function () {
        return this._onReady;
    };
    BaseLanguageClient.prototype.isConnectionActive = function () {
        return this.state === ClientState.Running && !!this._resolvedConnection;
    };
    BaseLanguageClient.prototype.start = function () {
        var _this = this;
        this._listeners = [];
        this._providers = [];
        // If we restart then the diagnostics collection is reused.
        if (!this._diagnostics) {
            this._diagnostics = this._clientOptions.diagnosticCollectionName
                ? vscode_1.languages.createDiagnosticCollection(this._clientOptions.diagnosticCollectionName)
                : vscode_1.languages.createDiagnosticCollection();
        }
        this.state = ClientState.Starting;
        this.resolveConnection().then(function (connection) {
            connection.onLogMessage(function (message) {
                switch (message.type) {
                    case vscode_languageserver_protocol_1.MessageType.Error:
                        _this.error(message.message);
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Warning:
                        _this.warn(message.message);
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Info:
                        _this.info(message.message);
                        break;
                    default:
                        _this.outputChannel.appendLine(message.message);
                }
            });
            connection.onShowMessage(function (message) {
                switch (message.type) {
                    case vscode_languageserver_protocol_1.MessageType.Error:
                        vscode_1.window.showErrorMessage(message.message);
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Warning:
                        vscode_1.window.showWarningMessage(message.message);
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Info:
                        vscode_1.window.showInformationMessage(message.message);
                        break;
                    default:
                        vscode_1.window.showInformationMessage(message.message);
                }
            });
            connection.onRequest(vscode_languageserver_protocol_1.ShowMessageRequest.type, function (params) {
                var messageFunc;
                switch (params.type) {
                    case vscode_languageserver_protocol_1.MessageType.Error:
                        messageFunc = vscode_1.window.showErrorMessage;
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Warning:
                        messageFunc = vscode_1.window.showWarningMessage;
                        break;
                    case vscode_languageserver_protocol_1.MessageType.Info:
                        messageFunc = vscode_1.window.showInformationMessage;
                        break;
                    default:
                        messageFunc = vscode_1.window.showInformationMessage;
                }
                var actions = params.actions || [];
                return messageFunc.apply(void 0, __spread([params.message], actions));
            });
            connection.onTelemetry(function (data) {
                _this._telemetryEmitter.fire(data);
            });
            connection.listen();
            // Error is handled in the intialize call.
            return _this.initialize(connection);
        }).then(undefined, function (error) {
            _this.state = ClientState.StartFailed;
            _this._onReadyCallbacks.reject(error);
            _this.error('Starting client failed', error);
            vscode_1.window.showErrorMessage("Couldn't start client " + _this._name);
        });
        return new vscode_1.Disposable(function () {
            if (_this.needsStop()) {
                _this.stop();
            }
        });
    };
    BaseLanguageClient.prototype.resolveConnection = function () {
        if (!this._connectionPromise) {
            this._connectionPromise = this.createConnection();
        }
        return this._connectionPromise;
    };
    BaseLanguageClient.prototype.initialize = function (connection) {
        var _this = this;
        this.refreshTrace(connection, false);
        var initOption = this._clientOptions.initializationOptions;
        var rootPath = this._clientOptions.workspaceFolder
            ? this._clientOptions.workspaceFolder.uri.fsPath
            : this._clientGetRootPath();
        var initParams = {
            processId: process.pid,
            rootPath: rootPath ? rootPath : null,
            rootUri: rootPath ? this._c2p.asUri(vscode_1.Uri.file(rootPath)) : null,
            capabilities: this.computeClientCapabilities(),
            initializationOptions: Is.func(initOption) ? initOption() : initOption,
            trace: vscode_languageserver_protocol_1.Trace.toString(this._trace),
            workspaceFolders: null
        };
        this.fillInitializeParams(initParams);
        return connection.initialize(initParams).then(function (result) {
            _this._resolvedConnection = connection;
            _this._initializeResult = result;
            _this.state = ClientState.Running;
            var textDocumentSyncOptions = undefined;
            if (Is.number(result.capabilities.textDocumentSync) && result.capabilities.textDocumentSync !== vscode_languageserver_protocol_1.TextDocumentSyncKind.None) {
                textDocumentSyncOptions = {
                    openClose: true,
                    change: result.capabilities.textDocumentSync,
                    save: {
                        includeText: false
                    }
                };
            }
            else if (result.capabilities.textDocumentSync !== void 0 && result.capabilities.textDocumentSync !== null) {
                textDocumentSyncOptions = result.capabilities.textDocumentSync;
            }
            _this._capabilities = Object.assign({}, result.capabilities, { resolvedTextDocumentSync: textDocumentSyncOptions });
            connection.onDiagnostics(function (params) { return _this.handleDiagnostics(params); });
            connection.onRequest(vscode_languageserver_protocol_1.RegistrationRequest.type, function (params) { return _this.handleRegistrationRequest(params); });
            // See https://github.com/Microsoft/vscode-languageserver-node/issues/199
            connection.onRequest('client/registerFeature', function (params) { return _this.handleRegistrationRequest(params); });
            connection.onRequest(vscode_languageserver_protocol_1.UnregistrationRequest.type, function (params) { return _this.handleUnregistrationRequest(params); });
            // See https://github.com/Microsoft/vscode-languageserver-node/issues/199
            connection.onRequest('client/unregisterFeature', function (params) { return _this.handleUnregistrationRequest(params); });
            connection.onRequest(vscode_languageserver_protocol_1.ApplyWorkspaceEditRequest.type, function (params) { return _this.handleApplyWorkspaceEdit(params); });
            connection.sendNotification(vscode_languageserver_protocol_1.InitializedNotification.type, {});
            _this.hookFileEvents(connection);
            _this.hookConfigurationChanged(connection);
            _this.initializeFeatures(connection);
            _this._onReadyCallbacks.resolve();
            return result;
        }).then(undefined, function (error) {
            if (_this._clientOptions.initializationFailedHandler) {
                if (_this._clientOptions.initializationFailedHandler(error)) {
                    _this.initialize(connection);
                }
                else {
                    _this.stop();
                    _this._onReadyCallbacks.reject(error);
                }
            }
            else if (error instanceof vscode_languageserver_protocol_1.ResponseError && error.data && error.data.retry) {
                vscode_1.window.showErrorMessage(error.message, { title: 'Retry', id: "retry" }).then(function (item) {
                    if (item && item.id === 'retry') {
                        _this.initialize(connection);
                    }
                    else {
                        _this.stop();
                        _this._onReadyCallbacks.reject(error);
                    }
                });
            }
            else {
                if (error && error.message) {
                    vscode_1.window.showErrorMessage(error.message);
                }
                _this.error('Server initialization failed.', error);
                _this.stop();
                _this._onReadyCallbacks.reject(error);
            }
        });
    };
    BaseLanguageClient.prototype._clientGetRootPath = function () {
        var folders = vscode_1.workspace.workspaceFolders;
        if (!folders || folders.length === 0) {
            return undefined;
        }
        var folder = folders[0];
        if (folder.uri.scheme === 'file') {
            return folder.uri.fsPath;
        }
        return undefined;
    };
    BaseLanguageClient.prototype.stop = function () {
        var _this = this;
        this._initializeResult = undefined;
        if (!this._connectionPromise) {
            this.state = ClientState.Stopped;
            return Promise.resolve();
        }
        if (this.state === ClientState.Stopping && this._onStop) {
            return this._onStop;
        }
        this.state = ClientState.Stopping;
        this.cleanUp();
        // unkook listeners
        return this._onStop = this.resolveConnection().then(function (connection) {
            return connection.shutdown().then(function () {
                connection.exit();
                connection.dispose();
                _this.state = ClientState.Stopped;
                _this._onStop = undefined;
                _this._connectionPromise = undefined;
                _this._resolvedConnection = undefined;
            });
        });
    };
    BaseLanguageClient.prototype.cleanUp = function (channel, diagnostics) {
        var e_10, _a;
        if (channel === void 0) { channel = true; }
        if (diagnostics === void 0) { diagnostics = true; }
        if (this._listeners) {
            this._listeners.forEach(function (listener) { return listener.dispose(); });
            this._listeners = undefined;
        }
        if (this._providers) {
            this._providers.forEach(function (provider) { return provider.dispose(); });
            this._providers = undefined;
        }
        if (this._syncedDocuments) {
            this._syncedDocuments.clear();
        }
        try {
            for (var _b = __values(this._dynamicFeatures.values()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var handler = _c.value;
                handler.dispose();
            }
        }
        catch (e_10_1) { e_10 = { error: e_10_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_10) throw e_10.error; }
        }
        if (channel && this._outputChannel && this._disposeOutputChannel) {
            this._outputChannel.dispose();
            this._outputChannel = undefined;
        }
        if (diagnostics && this._diagnostics) {
            this._diagnostics.dispose();
            this._diagnostics = undefined;
        }
    };
    BaseLanguageClient.prototype.notifyFileEvent = function (event) {
        var _this = this;
        this._fileEvents.push(event);
        this._fileEventDelayer.trigger(function () {
            _this.onReady().then(function () {
                _this.resolveConnection().then(function (connection) {
                    if (_this.isConnectionActive()) {
                        connection.didChangeWatchedFiles({ changes: _this._fileEvents });
                    }
                    _this._fileEvents = [];
                });
            }, function (error) {
                _this.error("Notify file events failed.", error);
            });
        });
    };
    BaseLanguageClient.prototype.forceDocumentSync = function () {
        this._dynamicFeatures.get(vscode_languageserver_protocol_1.DidChangeTextDocumentNotification.type.method).forceDelivery();
    };
    BaseLanguageClient.prototype.handleDiagnostics = function (params) {
        var _this = this;
        if (!this._diagnostics) {
            return;
        }
        var uri = this._p2c.asUri(params.uri);
        var diagnostics = this._p2c.asDiagnostics(params.diagnostics);
        var middleware = this.clientOptions.middleware.handleDiagnostics;
        if (middleware) {
            middleware(uri, diagnostics, function (uri, diagnostics) { return _this.setDiagnostics(uri, diagnostics); });
        }
        else {
            this.setDiagnostics(uri, diagnostics);
        }
    };
    BaseLanguageClient.prototype.setDiagnostics = function (uri, diagnostics) {
        if (!this._diagnostics) {
            return;
        }
        this._diagnostics.set(uri, diagnostics);
    };
    BaseLanguageClient.prototype.createConnection = function () {
        var _this = this;
        var errorHandler = function (error, message, count) {
            _this.handleConnectionError(error, message, count);
        };
        var closeHandler = function () {
            _this.handleConnectionClosed();
        };
        return this.createMessageTransports(this._clientOptions.stdioEncoding || 'utf8').then(function (transports) {
            return createConnection(transports.reader, transports.writer, errorHandler, closeHandler);
        });
    };
    BaseLanguageClient.prototype.handleConnectionClosed = function () {
        // Check whether this is a normal shutdown in progress or the client stopped normally.
        if (this.state === ClientState.Stopping || this.state === ClientState.Stopped) {
            return;
        }
        try {
            if (this._resolvedConnection) {
                this._resolvedConnection.dispose();
            }
        }
        catch (error) {
            // Disposing a connection could fail if error cases.
        }
        var action = CloseAction.DoNotRestart;
        try {
            action = this._clientOptions.errorHandler.closed();
        }
        catch (error) {
            // Ignore errors coming from the error handler.
        }
        this._connectionPromise = undefined;
        this._resolvedConnection = undefined;
        if (action === CloseAction.DoNotRestart) {
            this.error('Connection to server got closed. Server will not be restarted.');
            this.state = ClientState.Stopped;
            this.cleanUp(false, true);
        }
        else if (action === CloseAction.Restart) {
            this.info('Connection to server got closed. Server will restart.');
            this.cleanUp(false, false);
            this.state = ClientState.Initial;
            this.start();
        }
    };
    BaseLanguageClient.prototype.handleConnectionError = function (error, message, count) {
        var action = this._clientOptions.errorHandler.error(error, message, count);
        if (action === ErrorAction.Shutdown) {
            this.error('Connection to server is erroring. Shutting down server.');
            this.stop();
        }
    };
    BaseLanguageClient.prototype.hookConfigurationChanged = function (connection) {
        var _this = this;
        vscode_1.workspace.onDidChangeConfiguration(function () {
            _this.refreshTrace(connection, true);
        });
    };
    BaseLanguageClient.prototype.refreshTrace = function (connection, sendNotification) {
        if (sendNotification === void 0) { sendNotification = false; }
        var config = vscode_1.workspace.getConfiguration(this._id);
        var trace = vscode_languageserver_protocol_1.Trace.Off;
        if (config) {
            trace = vscode_languageserver_protocol_1.Trace.fromString(config.get('trace.server', 'off'));
        }
        this._trace = trace;
        connection.trace(this._trace, this._tracer, sendNotification);
    };
    BaseLanguageClient.prototype.hookFileEvents = function (_connection) {
        var fileEvents = this._clientOptions.synchronize.fileEvents;
        if (!fileEvents) {
            return;
        }
        var watchers;
        if (Is.array(fileEvents)) {
            watchers = fileEvents;
        }
        else {
            watchers = [fileEvents];
        }
        if (!watchers) {
            return;
        }
        this._dynamicFeatures.get(vscode_languageserver_protocol_1.DidChangeWatchedFilesNotification.type.method).registerRaw(UUID.generateUuid(), watchers);
    };
    BaseLanguageClient.prototype.registerFeatures = function (features) {
        var e_11, _a;
        try {
            for (var features_1 = __values(features), features_1_1 = features_1.next(); !features_1_1.done; features_1_1 = features_1.next()) {
                var feature = features_1_1.value;
                this.registerFeature(feature);
            }
        }
        catch (e_11_1) { e_11 = { error: e_11_1 }; }
        finally {
            try {
                if (features_1_1 && !features_1_1.done && (_a = features_1.return)) _a.call(features_1);
            }
            finally { if (e_11) throw e_11.error; }
        }
    };
    BaseLanguageClient.prototype.registerFeature = function (feature) {
        var e_12, _a;
        this._features.push(feature);
        if (DynamicFeature.is(feature)) {
            var messages = feature.messages;
            if (Array.isArray(messages)) {
                try {
                    for (var messages_1 = __values(messages), messages_1_1 = messages_1.next(); !messages_1_1.done; messages_1_1 = messages_1.next()) {
                        var message = messages_1_1.value;
                        this._method2Message.set(message.method, message);
                        this._dynamicFeatures.set(message.method, feature);
                    }
                }
                catch (e_12_1) { e_12 = { error: e_12_1 }; }
                finally {
                    try {
                        if (messages_1_1 && !messages_1_1.done && (_a = messages_1.return)) _a.call(messages_1);
                    }
                    finally { if (e_12) throw e_12.error; }
                }
            }
            else {
                this._method2Message.set(messages.method, messages);
                this._dynamicFeatures.set(messages.method, feature);
            }
        }
    };
    BaseLanguageClient.prototype.registerBuiltinFeatures = function () {
        var _this = this;
        this.registerFeature(new ConfigurationFeature(this));
        this.registerFeature(new DidOpenTextDocumentFeature(this, this._syncedDocuments));
        this.registerFeature(new DidChangeTextDocumentFeature(this));
        this.registerFeature(new WillSaveFeature(this));
        this.registerFeature(new WillSaveWaitUntilFeature(this));
        this.registerFeature(new DidSaveTextDocumentFeature(this));
        this.registerFeature(new DidCloseTextDocumentFeature(this, this._syncedDocuments));
        this.registerFeature(new FileSystemWatcherFeature(this, function (event) { return _this.notifyFileEvent(event); }));
        this.registerFeature(new CompletionItemFeature(this));
        this.registerFeature(new HoverFeature(this));
        this.registerFeature(new SignatureHelpFeature(this));
        this.registerFeature(new DefinitionFeature(this));
        this.registerFeature(new ReferencesFeature(this));
        this.registerFeature(new DocumentHighlightFeature(this));
        this.registerFeature(new DocumentSymbolFeature(this));
        this.registerFeature(new WorkspaceSymbolFeature(this));
        this.registerFeature(new CodeActionFeature(this));
        this.registerFeature(new CodeLensFeature(this));
        this.registerFeature(new DocumentFormattingFeature(this));
        this.registerFeature(new DocumentRangeFormattingFeature(this));
        this.registerFeature(new DocumentOnTypeFormattingFeature(this));
        this.registerFeature(new RenameFeature(this));
        this.registerFeature(new DocumentLinkFeature(this));
        this.registerFeature(new ExecuteCommandFeature(this));
    };
    BaseLanguageClient.prototype.fillInitializeParams = function (params) {
        var e_13, _a;
        try {
            for (var _b = __values(this._features), _c = _b.next(); !_c.done; _c = _b.next()) {
                var feature = _c.value;
                if (Is.func(feature.fillInitializeParams)) {
                    feature.fillInitializeParams(params);
                }
            }
        }
        catch (e_13_1) { e_13 = { error: e_13_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_13) throw e_13.error; }
        }
    };
    BaseLanguageClient.prototype.computeClientCapabilities = function () {
        var e_14, _a;
        var result = {};
        ensure(result, 'workspace').applyEdit = true;
        ensure(ensure(result, 'workspace'), 'workspaceEdit').documentChanges = true;
        ensure(ensure(result, 'textDocument'), 'publishDiagnostics').relatedInformation = true;
        try {
            for (var _b = __values(this._features), _c = _b.next(); !_c.done; _c = _b.next()) {
                var feature = _c.value;
                feature.fillClientCapabilities(result);
            }
        }
        catch (e_14_1) { e_14 = { error: e_14_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_14) throw e_14.error; }
        }
        return result;
    };
    BaseLanguageClient.prototype.initializeFeatures = function (_connection) {
        var e_15, _a;
        var documentSelector = this._clientOptions.documentSelector;
        try {
            for (var _b = __values(this._features), _c = _b.next(); !_c.done; _c = _b.next()) {
                var feature = _c.value;
                feature.initialize(this._capabilities, documentSelector);
            }
        }
        catch (e_15_1) { e_15 = { error: e_15_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_15) throw e_15.error; }
        }
    };
    BaseLanguageClient.prototype.handleRegistrationRequest = function (params) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            var e_16, _a;
            try {
                for (var _b = __values(params.registrations), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var registration = _c.value;
                    var feature = _this._dynamicFeatures.get(registration.method);
                    if (!feature) {
                        reject(new Error("No feature implementation for " + registration.method + " found. Registration failed."));
                        return;
                    }
                    var options = registration.registerOptions || {};
                    options.documentSelector = options.documentSelector || _this._clientOptions.documentSelector;
                    var data = {
                        id: registration.id,
                        registerOptions: options
                    };
                    feature.register(_this._method2Message.get(registration.method), data);
                }
            }
            catch (e_16_1) { e_16 = { error: e_16_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_16) throw e_16.error; }
            }
            resolve();
        });
    };
    BaseLanguageClient.prototype.handleUnregistrationRequest = function (params) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            var e_17, _a;
            try {
                for (var _b = __values(params.unregisterations), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var unregistration = _c.value;
                    var feature = _this._dynamicFeatures.get(unregistration.method);
                    if (!feature) {
                        reject(new Error("No feature implementation for " + unregistration.method + " found. Unregistration failed."));
                        return;
                    }
                    feature.unregister(unregistration.id);
                }
            }
            catch (e_17_1) { e_17 = { error: e_17_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_17) throw e_17.error; }
            }
            ;
            resolve();
        });
    };
    BaseLanguageClient.prototype.handleApplyWorkspaceEdit = function (params) {
        var e_18, _a;
        // This is some sort of workaround since the version check should be done by VS Code in the Workspace.applyEdit.
        // However doing it here adds some safety since the server can lag more behind then an extension.
        var workspaceEdit = params.edit;
        var openTextDocuments = new Map();
        vscode_1.workspace.textDocuments.forEach(function (document) { return openTextDocuments.set(document.uri.toString(), document); });
        var versionMismatch = false;
        if (workspaceEdit.documentChanges) {
            try {
                for (var _b = __values(workspaceEdit.documentChanges), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var change = _c.value;
                    if (change.textDocument.version && change.textDocument.version >= 0) {
                        var textDocument = openTextDocuments.get(change.textDocument.uri);
                        if (textDocument && textDocument.version !== change.textDocument.version) {
                            versionMismatch = true;
                            break;
                        }
                    }
                }
            }
            catch (e_18_1) { e_18 = { error: e_18_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_18) throw e_18.error; }
            }
        }
        if (versionMismatch) {
            return Promise.resolve({ applied: false });
        }
        return vscode_1.workspace.applyEdit(this._p2c.asWorkspaceEdit(params.edit)).then(function (value) { return { applied: value }; });
    };
    ;
    BaseLanguageClient.prototype.logFailedRequest = function (type, error) {
        // If we get a request cancel don't log anything.
        if (error instanceof vscode_languageserver_protocol_1.ResponseError && error.code === vscode_languageserver_protocol_1.ErrorCodes.RequestCancelled) {
            return;
        }
        this.error("Request " + type.method + " failed.", error);
    };
    return BaseLanguageClient;
}());
exports.BaseLanguageClient = BaseLanguageClient;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../process/browser.js */ "../node_modules/process/browser.js")))

/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/codeConverter.js":
/*!***********************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/codeConverter.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
var code = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var proto = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var protocolCompletionItem_1 = __webpack_require__(/*! ./protocolCompletionItem */ "../node_modules/vscode-base-languageclient/lib/protocolCompletionItem.js");
var protocolCodeLens_1 = __webpack_require__(/*! ./protocolCodeLens */ "../node_modules/vscode-base-languageclient/lib/protocolCodeLens.js");
var protocolDocumentLink_1 = __webpack_require__(/*! ./protocolDocumentLink */ "../node_modules/vscode-base-languageclient/lib/protocolDocumentLink.js");
function createConverter(uriConverter) {
    var nullConverter = function (value) { return value.toString(); };
    var _uriConverter = uriConverter || nullConverter;
    function asUri(value) {
        return _uriConverter(value);
    }
    function asTextDocumentIdentifier(textDocument) {
        return {
            uri: _uriConverter(textDocument.uri)
        };
    }
    function asVersionedTextDocumentIdentifier(textDocument) {
        return {
            uri: _uriConverter(textDocument.uri),
            version: textDocument.version
        };
    }
    function asOpenTextDocumentParams(textDocument) {
        return {
            textDocument: {
                uri: _uriConverter(textDocument.uri),
                languageId: textDocument.languageId,
                version: textDocument.version,
                text: textDocument.getText()
            }
        };
    }
    function isTextDocumentChangeEvent(value) {
        var candidate = value;
        return !!candidate.document && !!candidate.contentChanges;
    }
    function isTextDocument(value) {
        var candidate = value;
        return !!candidate.uri && !!candidate.version;
    }
    function asChangeTextDocumentParams(arg) {
        if (isTextDocument(arg)) {
            var result = {
                textDocument: {
                    uri: _uriConverter(arg.uri),
                    version: arg.version
                },
                contentChanges: [{ text: arg.getText() }]
            };
            return result;
        }
        else if (isTextDocumentChangeEvent(arg)) {
            var document = arg.document;
            var result = {
                textDocument: {
                    uri: _uriConverter(document.uri),
                    version: document.version
                },
                contentChanges: arg.contentChanges.map(function (change) {
                    var range = change.range;
                    return {
                        range: {
                            start: { line: range.start.line, character: range.start.character },
                            end: { line: range.end.line, character: range.end.character }
                        },
                        rangeLength: change.rangeLength,
                        text: change.text
                    };
                })
            };
            return result;
        }
        else {
            throw Error('Unsupported text document change parameter');
        }
    }
    function asCloseTextDocumentParams(textDocument) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument)
        };
    }
    function asSaveTextDocumentParams(textDocument, includeContent) {
        if (includeContent === void 0) { includeContent = false; }
        var result = {
            textDocument: asVersionedTextDocumentIdentifier(textDocument)
        };
        if (includeContent) {
            result.text = textDocument.getText();
        }
        return result;
    }
    function asTextDocumentSaveReason(reason) {
        switch (reason) {
            case code.TextDocumentSaveReason.Manual:
                return proto.TextDocumentSaveReason.Manual;
            case code.TextDocumentSaveReason.AfterDelay:
                return proto.TextDocumentSaveReason.AfterDelay;
            case code.TextDocumentSaveReason.FocusOut:
                return proto.TextDocumentSaveReason.FocusOut;
        }
        return proto.TextDocumentSaveReason.Manual;
    }
    function asWillSaveTextDocumentParams(event) {
        return {
            textDocument: asTextDocumentIdentifier(event.document),
            reason: asTextDocumentSaveReason(event.reason)
        };
    }
    function asTextDocumentPositionParams(textDocument, position) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument),
            position: asWorkerPosition(position)
        };
    }
    function asTriggerKind(triggerKind) {
        switch (triggerKind) {
            case code.CompletionTriggerKind.TriggerCharacter:
                return proto.CompletionTriggerKind.TriggerCharacter;
            case code.CompletionTriggerKind.TriggerForIncompleteCompletions:
                return proto.CompletionTriggerKind.TriggerForIncompleteCompletions;
            default:
                return proto.CompletionTriggerKind.Invoked;
        }
    }
    function asCompletionParams(textDocument, position, context) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument),
            position: asWorkerPosition(position),
            context: {
                triggerKind: asTriggerKind(context.triggerKind),
                triggerCharacter: context.triggerCharacter
            }
        };
    }
    function asWorkerPosition(position) {
        return { line: position.line, character: position.character };
    }
    function asPosition(value) {
        if (value === void 0) {
            return undefined;
        }
        else if (value === null) {
            return null;
        }
        return { line: value.line, character: value.character };
    }
    function asRange(value) {
        if (value === void 0 || value === null) {
            return value;
        }
        return { start: asPosition(value.start), end: asPosition(value.end) };
    }
    function asDiagnosticSeverity(value) {
        switch (value) {
            case code.DiagnosticSeverity.Error:
                return proto.DiagnosticSeverity.Error;
            case code.DiagnosticSeverity.Warning:
                return proto.DiagnosticSeverity.Warning;
            case code.DiagnosticSeverity.Information:
                return proto.DiagnosticSeverity.Information;
            case code.DiagnosticSeverity.Hint:
                return proto.DiagnosticSeverity.Hint;
        }
    }
    function asDiagnostic(item) {
        var result = proto.Diagnostic.create(asRange(item.range), item.message);
        if (Is.number(item.severity)) {
            result.severity = asDiagnosticSeverity(item.severity);
        }
        if (Is.number(item.code) || Is.string(item.code)) {
            result.code = item.code;
        }
        if (item.source) {
            result.source = item.source;
        }
        return result;
    }
    function asDiagnostics(items) {
        if (items === void 0 || items === null) {
            return items;
        }
        return items.map(asDiagnostic);
    }
    function asDocumentation(format, documentation) {
        switch (format) {
            case '$string':
                return documentation;
            case proto.MarkupKind.PlainText:
                return { kind: format, value: documentation };
            case proto.MarkupKind.Markdown:
                return { kind: format, value: documentation.value };
            default:
                return "Unsupported Markup content received. Kind is: " + format;
        }
    }
    function asCompletionItemKind(value, original) {
        if (original !== void 0) {
            return original;
        }
        return value + 1;
    }
    function asCompletionItem(item) {
        var result = { label: item.label };
        var protocolItem = item instanceof protocolCompletionItem_1.default ? item : undefined;
        if (item.detail) {
            result.detail = item.detail;
        }
        // We only send items back we created. So this can't be something else than
        // a string right now.
        if (item.documentation) {
            if (!protocolItem || protocolItem.documentationFormat === '$string') {
                result.documentation = item.documentation;
            }
            else {
                result.documentation = asDocumentation(protocolItem.documentationFormat, item.documentation);
            }
        }
        if (item.filterText) {
            result.filterText = item.filterText;
        }
        fillPrimaryInsertText(result, item);
        if (Is.number(item.kind)) {
            result.kind = asCompletionItemKind(item.kind, protocolItem && protocolItem.originalItemKind);
        }
        if (item.sortText) {
            result.sortText = item.sortText;
        }
        if (item.additionalTextEdits) {
            result.additionalTextEdits = asTextEdits(item.additionalTextEdits);
        }
        if (item.commitCharacters) {
            result.commitCharacters = item.commitCharacters.slice();
        }
        if (item.command) {
            result.command = asCommand(item.command);
        }
        if (item.preselect === true || item.preselect === false) {
            result.preselect = item.preselect;
        }
        if (protocolItem) {
            if (protocolItem.data !== void 0) {
                result.data = protocolItem.data;
            }
            if (protocolItem.deprecated === true || protocolItem.deprecated === false) {
                result.deprecated = protocolItem.deprecated;
            }
        }
        return result;
    }
    function fillPrimaryInsertText(target, source) {
        var format = proto.InsertTextFormat.PlainText;
        var text;
        var range = undefined;
        if (source.textEdit) {
            text = source.textEdit.newText;
            range = asRange(source.textEdit.range);
        }
        else if (source.insertText instanceof code.SnippetString) {
            format = proto.InsertTextFormat.Snippet;
            text = source.insertText.value;
        }
        else {
            text = source.insertText;
        }
        if (source.range) {
            range = asRange(source.range);
        }
        target.insertTextFormat = format;
        if (source.fromEdit && text && range) {
            target.textEdit = { newText: text, range: range };
        }
        else {
            target.insertText = text;
        }
    }
    function asTextEdit(edit) {
        return { range: asRange(edit.range), newText: edit.newText };
    }
    function asTextEdits(edits) {
        if (edits === void 0 || edits === null) {
            return edits;
        }
        return edits.map(asTextEdit);
    }
    function asReferenceParams(textDocument, position, options) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument),
            position: asWorkerPosition(position),
            context: { includeDeclaration: options.includeDeclaration }
        };
    }
    function asCodeActionContext(context) {
        if (context === void 0 || context === null) {
            return context;
        }
        return proto.CodeActionContext.create(asDiagnostics(context.diagnostics), Is.string(context.only) ? [context.only] : undefined);
    }
    function asCommand(item) {
        var result = proto.Command.create(item.title, item.command);
        if (item.arguments) {
            result.arguments = item.arguments;
        }
        return result;
    }
    function asCodeLens(item) {
        var result = proto.CodeLens.create(asRange(item.range));
        if (item.command) {
            result.command = asCommand(item.command);
        }
        if (item instanceof protocolCodeLens_1.default) {
            if (item.data) {
                result.data = item.data;
            }
            ;
        }
        return result;
    }
    function asFormattingOptions(item) {
        return { tabSize: item.tabSize, insertSpaces: item.insertSpaces };
    }
    function asDocumentSymbolParams(textDocument) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument)
        };
    }
    function asCodeLensParams(textDocument) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument)
        };
    }
    function asDocumentLink(item) {
        var result = proto.DocumentLink.create(asRange(item.range));
        if (item.target) {
            result.target = asUri(item.target);
        }
        var protocolItem = item instanceof protocolDocumentLink_1.default ? item : undefined;
        if (protocolItem && protocolItem.data) {
            result.data = protocolItem.data;
        }
        return result;
    }
    function asDocumentLinkParams(textDocument) {
        return {
            textDocument: asTextDocumentIdentifier(textDocument)
        };
    }
    return {
        asUri: asUri,
        asTextDocumentIdentifier: asTextDocumentIdentifier,
        asOpenTextDocumentParams: asOpenTextDocumentParams,
        asChangeTextDocumentParams: asChangeTextDocumentParams,
        asCloseTextDocumentParams: asCloseTextDocumentParams,
        asSaveTextDocumentParams: asSaveTextDocumentParams,
        asWillSaveTextDocumentParams: asWillSaveTextDocumentParams,
        asTextDocumentPositionParams: asTextDocumentPositionParams,
        asCompletionParams: asCompletionParams,
        asWorkerPosition: asWorkerPosition,
        asRange: asRange,
        asPosition: asPosition,
        asDiagnosticSeverity: asDiagnosticSeverity,
        asDiagnostic: asDiagnostic,
        asDiagnostics: asDiagnostics,
        asCompletionItem: asCompletionItem,
        asTextEdit: asTextEdit,
        asReferenceParams: asReferenceParams,
        asCodeActionContext: asCodeActionContext,
        asCommand: asCommand,
        asCodeLens: asCodeLens,
        asFormattingOptions: asFormattingOptions,
        asDocumentSymbolParams: asDocumentSymbolParams,
        asCodeLensParams: asCodeLensParams,
        asDocumentLink: asDocumentLink,
        asDocumentLinkParams: asDocumentLinkParams
    };
}
exports.createConverter = createConverter;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/colorProvider.js":
/*!***********************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/colorProvider.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var client_1 = __webpack_require__(/*! ./client */ "../node_modules/vscode-base-languageclient/lib/client.js");
function ensure(target, key) {
    if (target[key] === void 0) {
        target[key] = {};
    }
    return target[key];
}
var ColorProviderFeature = /** @class */ (function (_super) {
    __extends(ColorProviderFeature, _super);
    function ColorProviderFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.DocumentColorRequest.type) || this;
    }
    ColorProviderFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'colorProvider').dynamicRegistration = true;
    };
    ColorProviderFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.colorProvider) {
            return;
        }
        var implCapabilities = capabilities.colorProvider;
        var id = Is.string(implCapabilities.id) && implCapabilities.id.length > 0 ? implCapabilities.id : UUID.generateUuid();
        var selector = implCapabilities.documentSelector || documentSelector;
        if (selector) {
            this.register(this.messages, {
                id: id,
                registerOptions: Object.assign({}, { documentSelector: selector })
            });
        }
    };
    ColorProviderFeature.prototype.registerLanguageProvider = function (options) {
        var _this = this;
        var client = this._client;
        var provideColorPresentations = function (color, context, token) {
            var requestParams = {
                color: color,
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(context.document),
                range: client.code2ProtocolConverter.asRange(context.range)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.ColorPresentationRequest.type, requestParams, token).then(_this.asColorPresentations.bind(_this), function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.ColorPresentationRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var provideDocumentColors = function (document, token) {
            var requestParams = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.DocumentColorRequest.type, requestParams, token).then(_this.asColorInformations.bind(_this), function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.ColorPresentationRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerColorProvider(options.documentSelector, {
            provideColorPresentations: function (color, context, token) {
                return middleware.provideColorPresentations
                    ? middleware.provideColorPresentations(color, context, token, provideColorPresentations)
                    : provideColorPresentations(color, context, token);
            },
            provideDocumentColors: function (document, token) {
                return middleware.provideDocumentColors
                    ? middleware.provideDocumentColors(document, token, provideDocumentColors)
                    : provideDocumentColors(document, token);
            }
        });
    };
    ColorProviderFeature.prototype.asColor = function (color) {
        return new vscode_1.Color(color.red, color.green, color.blue, color.alpha);
    };
    ColorProviderFeature.prototype.asColorInformations = function (colorInformation) {
        var _this = this;
        if (Array.isArray(colorInformation)) {
            return colorInformation.map(function (ci) {
                return new vscode_1.ColorInformation(_this._client.protocol2CodeConverter.asRange(ci.range), _this.asColor(ci.color));
            });
        }
        return [];
    };
    ColorProviderFeature.prototype.asColorPresentations = function (colorPresentations) {
        var _this = this;
        if (Array.isArray(colorPresentations)) {
            return colorPresentations.map(function (cp) {
                var presentation = new vscode_1.ColorPresentation(cp.label);
                presentation.additionalTextEdits = _this._client.protocol2CodeConverter.asTextEdits(cp.additionalTextEdits);
                presentation.textEdit = _this._client.protocol2CodeConverter.asTextEdit(cp.textEdit);
                return presentation;
            });
        }
        return [];
    };
    return ColorProviderFeature;
}(client_1.TextDocumentFeature));
exports.ColorProviderFeature = ColorProviderFeature;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/foldingRange.js":
/*!**********************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/foldingRange.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var client_1 = __webpack_require__(/*! ./client */ "../node_modules/vscode-base-languageclient/lib/client.js");
function ensure(target, key) {
    if (target[key] === void 0) {
        target[key] = {};
    }
    return target[key];
}
var FoldingRangeFeature = /** @class */ (function (_super) {
    __extends(FoldingRangeFeature, _super);
    function FoldingRangeFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.FoldingRangeRequest.type) || this;
    }
    FoldingRangeFeature.prototype.fillClientCapabilities = function (capabilites) {
        var capability = ensure(ensure(capabilites, 'textDocument'), 'foldingRange');
        capability.dynamicRegistration = true;
        capability.rangeLimit = 5000;
        capability.lineFoldingOnly = true;
    };
    FoldingRangeFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.foldingRangeProvider) {
            return;
        }
        var implCapabilities = capabilities.foldingRangeProvider;
        var id = Is.string(implCapabilities.id) && implCapabilities.id.length > 0 ? implCapabilities.id : UUID.generateUuid();
        var selector = implCapabilities.documentSelector || documentSelector;
        if (selector) {
            this.register(this.messages, {
                id: id,
                registerOptions: Object.assign({}, { documentSelector: selector })
            });
        }
    };
    FoldingRangeFeature.prototype.registerLanguageProvider = function (options) {
        var _this = this;
        var client = this._client;
        var provideFoldingRanges = function (document, _, token) {
            var requestParams = {
                textDocument: client.code2ProtocolConverter.asTextDocumentIdentifier(document)
            };
            return client.sendRequest(vscode_languageserver_protocol_1.FoldingRangeRequest.type, requestParams, token).then(_this.asFoldingRanges.bind(_this), function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.FoldingRangeRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerFoldingRangeProvider(options.documentSelector, {
            provideFoldingRanges: function (document, context, token) {
                return middleware.provideFoldingRanges
                    ? middleware.provideFoldingRanges(document, context, token, provideFoldingRanges)
                    : provideFoldingRanges(document, context, token);
            }
        });
    };
    FoldingRangeFeature.prototype.asFoldingRangeKind = function (kind) {
        if (kind) {
            switch (kind) {
                case vscode_languageserver_protocol_1.FoldingRangeKind.Comment:
                    return vscode_1.FoldingRangeKind.Comment;
                case vscode_languageserver_protocol_1.FoldingRangeKind.Imports:
                    return vscode_1.FoldingRangeKind.Imports;
                case vscode_languageserver_protocol_1.FoldingRangeKind.Region:
                    return vscode_1.FoldingRangeKind.Region;
            }
        }
        return void 0;
    };
    FoldingRangeFeature.prototype.asFoldingRanges = function (foldingRanges) {
        var _this = this;
        if (Array.isArray(foldingRanges)) {
            return foldingRanges.map(function (r) {
                return new vscode_1.FoldingRange(r.startLine, r.endLine, _this.asFoldingRangeKind(r.kind));
            });
        }
        return [];
    };
    return FoldingRangeFeature;
}(client_1.TextDocumentFeature));
exports.FoldingRangeFeature = FoldingRangeFeature;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/implementation.js":
/*!************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/implementation.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var client_1 = __webpack_require__(/*! ./client */ "../node_modules/vscode-base-languageclient/lib/client.js");
function ensure(target, key) {
    if (target[key] === void 0) {
        target[key] = {};
    }
    return target[key];
}
var ImplementationFeature = /** @class */ (function (_super) {
    __extends(ImplementationFeature, _super);
    function ImplementationFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.ImplementationRequest.type) || this;
    }
    ImplementationFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'implementation').dynamicRegistration = true;
    };
    ImplementationFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.implementationProvider) {
            return;
        }
        if (capabilities.implementationProvider === true) {
            if (!documentSelector) {
                return;
            }
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: Object.assign({}, { documentSelector: documentSelector })
            });
        }
        else {
            var implCapabilities = capabilities.implementationProvider;
            var id = Is.string(implCapabilities.id) && implCapabilities.id.length > 0 ? implCapabilities.id : UUID.generateUuid();
            var selector = implCapabilities.documentSelector || documentSelector;
            if (selector) {
                this.register(this.messages, {
                    id: id,
                    registerOptions: Object.assign({}, { documentSelector: selector })
                });
            }
        }
    };
    ImplementationFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideImplementation = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.ImplementationRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asDefinitionResult, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.ImplementationRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerImplementationProvider(options.documentSelector, {
            provideImplementation: function (document, position, token) {
                return middleware.provideImplementation
                    ? middleware.provideImplementation(document, position, token, provideImplementation)
                    : provideImplementation(document, position, token);
            }
        });
    };
    return ImplementationFeature;
}(client_1.TextDocumentFeature));
exports.ImplementationFeature = ImplementationFeature;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/protocolCodeLens.js":
/*!**************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/protocolCodeLens.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var code = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var ProtocolCodeLens = /** @class */ (function (_super) {
    __extends(ProtocolCodeLens, _super);
    function ProtocolCodeLens(range) {
        return _super.call(this, range) || this;
    }
    return ProtocolCodeLens;
}(code.CodeLens));
exports.default = ProtocolCodeLens;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/protocolCompletionItem.js":
/*!********************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/protocolCompletionItem.js ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var code = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var ProtocolCompletionItem = /** @class */ (function (_super) {
    __extends(ProtocolCompletionItem, _super);
    function ProtocolCompletionItem(label) {
        return _super.call(this, label) || this;
    }
    return ProtocolCompletionItem;
}(code.CompletionItem));
exports.default = ProtocolCompletionItem;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/protocolConverter.js":
/*!***************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/protocolConverter.js ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
var code = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var ls = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var protocolCompletionItem_1 = __webpack_require__(/*! ./protocolCompletionItem */ "../node_modules/vscode-base-languageclient/lib/protocolCompletionItem.js");
var protocolCodeLens_1 = __webpack_require__(/*! ./protocolCodeLens */ "../node_modules/vscode-base-languageclient/lib/protocolCodeLens.js");
var protocolDocumentLink_1 = __webpack_require__(/*! ./protocolDocumentLink */ "../node_modules/vscode-base-languageclient/lib/protocolDocumentLink.js");
var CodeBlock;
(function (CodeBlock) {
    function is(value) {
        var candidate = value;
        return candidate && Is.string(candidate.language) && Is.string(candidate.value);
    }
    CodeBlock.is = is;
})(CodeBlock || (CodeBlock = {}));
function createConverter(uriConverter) {
    var nullConverter = function (value) { return code.Uri.parse(value); };
    var _uriConverter = uriConverter || nullConverter;
    function asUri(value) {
        return _uriConverter(value);
    }
    function asDiagnostics(diagnostics) {
        return diagnostics.map(asDiagnostic);
    }
    function asDiagnostic(diagnostic) {
        var result = new code.Diagnostic(asRange(diagnostic.range), diagnostic.message, asDiagnosticSeverity(diagnostic.severity));
        if (Is.number(diagnostic.code) || Is.string(diagnostic.code)) {
            result.code = diagnostic.code;
        }
        if (diagnostic.source) {
            result.source = diagnostic.source;
        }
        if (diagnostic.relatedInformation) {
            result.relatedInformation = asRelatedInformation(diagnostic.relatedInformation);
        }
        return result;
    }
    function asRelatedInformation(relatedInformation) {
        return relatedInformation.map(asDiagnosticRelatedInformation);
    }
    function asDiagnosticRelatedInformation(information) {
        return new code.DiagnosticRelatedInformation(asLocation(information.location), information.message);
    }
    function asPosition(value) {
        if (!value) {
            return undefined;
        }
        return new code.Position(value.line, value.character);
    }
    function asRange(value) {
        if (!value) {
            return undefined;
        }
        return new code.Range(asPosition(value.start), asPosition(value.end));
    }
    function asDiagnosticSeverity(value) {
        if (value === void 0 || value === null) {
            return code.DiagnosticSeverity.Error;
        }
        switch (value) {
            case ls.DiagnosticSeverity.Error:
                return code.DiagnosticSeverity.Error;
            case ls.DiagnosticSeverity.Warning:
                return code.DiagnosticSeverity.Warning;
            case ls.DiagnosticSeverity.Information:
                return code.DiagnosticSeverity.Information;
            case ls.DiagnosticSeverity.Hint:
                return code.DiagnosticSeverity.Hint;
        }
        return code.DiagnosticSeverity.Error;
    }
    function asHoverContent(value) {
        var e_1, _a;
        if (Is.string(value)) {
            return new code.MarkdownString(value);
        }
        else if (CodeBlock.is(value)) {
            var result = new code.MarkdownString();
            return result.appendCodeblock(value.value, value.language);
        }
        else if (Array.isArray(value)) {
            var result = [];
            try {
                for (var value_1 = __values(value), value_1_1 = value_1.next(); !value_1_1.done; value_1_1 = value_1.next()) {
                    var element = value_1_1.value;
                    var item = new code.MarkdownString();
                    if (CodeBlock.is(element)) {
                        item.appendCodeblock(element.value, element.language);
                    }
                    else {
                        item.appendMarkdown(element);
                    }
                    result.push(item);
                }
            }
            catch (e_1_1) { e_1 = { error: e_1_1 }; }
            finally {
                try {
                    if (value_1_1 && !value_1_1.done && (_a = value_1.return)) _a.call(value_1);
                }
                finally { if (e_1) throw e_1.error; }
            }
            return result;
        }
        else {
            var result = void 0;
            switch (value.kind) {
                case ls.MarkupKind.Markdown:
                    return new code.MarkdownString(value.value);
                case ls.MarkupKind.PlainText:
                    result = new code.MarkdownString();
                    result.appendText(value.value);
                    return result;
                default:
                    result = new code.MarkdownString();
                    result.appendText("Unsupported Markup content received. Kind is: " + value.kind);
                    return result;
            }
        }
    }
    function asDocumentation(value) {
        if (Is.string(value)) {
            return value;
        }
        else {
            switch (value.kind) {
                case ls.MarkupKind.Markdown:
                    return new code.MarkdownString(value.value);
                case ls.MarkupKind.PlainText:
                    return value.value;
                default:
                    return "Unsupported Markup content received. Kind is: " + value.kind;
            }
        }
    }
    function asHover(hover) {
        if (!hover) {
            return undefined;
        }
        return new code.Hover(asHoverContent(hover.contents), asRange(hover.range));
    }
    function asCompletionResult(result) {
        if (!result) {
            return undefined;
        }
        if (Array.isArray(result)) {
            var items = result;
            return items.map(asCompletionItem);
        }
        var list = result;
        return new code.CompletionList(list.items.map(asCompletionItem), list.isIncomplete);
    }
    function asCompletionItemKind(value) {
        // Protocol item kind is 1 based, codes item kind is zero based.
        if (ls.CompletionItemKind.Text <= value && value <= ls.CompletionItemKind.TypeParameter) {
            return [value - 1, undefined];
        }
        ;
        return [code.CompletionItemKind.Text, value];
    }
    function asCompletionItem(item) {
        var result = new protocolCompletionItem_1.default(item.label);
        if (item.detail) {
            result.detail = item.detail;
        }
        if (item.documentation) {
            result.documentation = asDocumentation(item.documentation);
            result.documentationFormat = Is.string(item.documentation) ? '$string' : item.documentation.kind;
        }
        ;
        if (item.filterText) {
            result.filterText = item.filterText;
        }
        var insertText = asCompletionInsertText(item);
        if (insertText) {
            result.insertText = insertText.text;
            result.range = insertText.range;
            result.fromEdit = insertText.fromEdit;
        }
        if (Is.number(item.kind)) {
            var _a = __read(asCompletionItemKind(item.kind), 2), itemKind = _a[0], original = _a[1];
            result.kind = itemKind;
            if (original) {
                result.originalItemKind = original;
            }
        }
        if (item.sortText) {
            result.sortText = item.sortText;
        }
        if (item.additionalTextEdits) {
            result.additionalTextEdits = asTextEdits(item.additionalTextEdits);
        }
        if (Is.stringArray(item.commitCharacters)) {
            result.commitCharacters = item.commitCharacters.slice();
        }
        if (item.command) {
            result.command = asCommand(item.command);
        }
        if (item.deprecated === true || item.deprecated === false) {
            result.deprecated = item.deprecated;
        }
        if (item.preselect === true || item.preselect === false) {
            result.preselect = item.preselect;
        }
        if (item.data !== void 0) {
            result.data = item.data;
        }
        return result;
    }
    function asCompletionInsertText(item) {
        if (item.textEdit) {
            if (item.insertTextFormat === ls.InsertTextFormat.Snippet) {
                return { text: new code.SnippetString(item.textEdit.newText), range: asRange(item.textEdit.range), fromEdit: true };
            }
            else {
                return { text: item.textEdit.newText, range: asRange(item.textEdit.range), fromEdit: true };
            }
        }
        else if (item.insertText) {
            if (item.insertTextFormat === ls.InsertTextFormat.Snippet) {
                return { text: new code.SnippetString(item.insertText), fromEdit: false };
            }
            else {
                return { text: item.insertText, fromEdit: false };
            }
        }
        else {
            return undefined;
        }
    }
    function asTextEdit(edit) {
        if (!edit) {
            return undefined;
        }
        return new code.TextEdit(asRange(edit.range), edit.newText);
    }
    function asTextEdits(items) {
        if (!items) {
            return undefined;
        }
        return items.map(asTextEdit);
    }
    function asSignatureHelp(item) {
        if (!item) {
            return undefined;
        }
        var result = new code.SignatureHelp();
        if (Is.number(item.activeSignature)) {
            result.activeSignature = item.activeSignature;
        }
        else {
            // activeSignature was optional in the past
            result.activeSignature = 0;
        }
        if (Is.number(item.activeParameter)) {
            result.activeParameter = item.activeParameter;
        }
        else {
            // activeParameter was optional in the past
            result.activeParameter = 0;
        }
        if (item.signatures) {
            result.signatures = asSignatureInformations(item.signatures);
        }
        return result;
    }
    function asSignatureInformations(items) {
        return items.map(asSignatureInformation);
    }
    function asSignatureInformation(item) {
        var result = new code.SignatureInformation(item.label);
        if (item.documentation) {
            result.documentation = asDocumentation(item.documentation);
        }
        if (item.parameters) {
            result.parameters = asParameterInformations(item.parameters);
        }
        return result;
    }
    function asParameterInformations(item) {
        return item.map(asParameterInformation);
    }
    function asParameterInformation(item) {
        var result = new code.ParameterInformation(item.label);
        if (item.documentation) {
            result.documentation = asDocumentation(item.documentation);
        }
        ;
        return result;
    }
    function asDefinitionResult(item) {
        if (!item) {
            return undefined;
        }
        if (Is.array(item)) {
            return item.map(function (location) { return asLocation(location); });
        }
        else {
            return asLocation(item);
        }
    }
    function asLocation(item) {
        if (!item) {
            return undefined;
        }
        return new code.Location(_uriConverter(item.uri), asRange(item.range));
    }
    function asReferences(values) {
        if (!values) {
            return undefined;
        }
        return values.map(function (location) { return asLocation(location); });
    }
    function asDocumentHighlights(values) {
        if (!values) {
            return undefined;
        }
        return values.map(asDocumentHighlight);
    }
    function asDocumentHighlight(item) {
        var result = new code.DocumentHighlight(asRange(item.range));
        if (Is.number(item.kind)) {
            result.kind = asDocumentHighlightKind(item.kind);
        }
        return result;
    }
    function asDocumentHighlightKind(item) {
        switch (item) {
            case ls.DocumentHighlightKind.Text:
                return code.DocumentHighlightKind.Text;
            case ls.DocumentHighlightKind.Read:
                return code.DocumentHighlightKind.Read;
            case ls.DocumentHighlightKind.Write:
                return code.DocumentHighlightKind.Write;
        }
        return code.DocumentHighlightKind.Text;
    }
    function asSymbolInformations(values, uri) {
        if (!values) {
            return undefined;
        }
        return values.map(function (information) { return asSymbolInformation(information, uri); });
    }
    function asSymbolKind(item) {
        if (item <= ls.SymbolKind.TypeParameter) {
            // Symbol kind is one based in the protocol and zero based in code.
            return item - 1;
        }
        return code.SymbolKind.Property;
    }
    function asSymbolInformation(item, uri) {
        // Symbol kind is one based in the protocol and zero based in code.
        var result = new code.SymbolInformation(item.name, asSymbolKind(item.kind), asRange(item.location.range), item.location.uri ? _uriConverter(item.location.uri) : uri);
        if (item.containerName) {
            result.containerName = item.containerName;
        }
        return result;
    }
    function asDocumentSymbols(values) {
        if (values === void 0 || values === null) {
            return undefined;
        }
        return values.map(asDocumentSymbol);
    }
    function asDocumentSymbol(value) {
        var e_2, _a;
        var result = new code.DocumentSymbol(value.name, value.detail !== void 0 ? value.detail : value.name, asSymbolKind(value.kind), asRange(value.range), asRange(value.selectionRange));
        if (value.children !== void 0 && value.children.length > 0) {
            var children = [];
            try {
                for (var _b = __values(value.children), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var child = _c.value;
                    children.push(asDocumentSymbol(child));
                }
            }
            catch (e_2_1) { e_2 = { error: e_2_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_2) throw e_2.error; }
            }
            result.children = children;
        }
        return result;
    }
    function asCommand(item) {
        var result = { title: item.title, command: item.command };
        if (item.arguments) {
            result.arguments = item.arguments;
        }
        return result;
    }
    function asCommands(items) {
        if (!items) {
            return undefined;
        }
        return items.map(asCommand);
    }
    var kindMapping = new Map();
    kindMapping.set('', code.CodeActionKind.Empty);
    kindMapping.set(ls.CodeActionKind.QuickFix, code.CodeActionKind.QuickFix);
    kindMapping.set(ls.CodeActionKind.Refactor, code.CodeActionKind.Refactor);
    kindMapping.set(ls.CodeActionKind.RefactorExtract, code.CodeActionKind.RefactorExtract);
    kindMapping.set(ls.CodeActionKind.RefactorInline, code.CodeActionKind.RefactorInline);
    kindMapping.set(ls.CodeActionKind.RefactorRewrite, code.CodeActionKind.RefactorRewrite);
    kindMapping.set(ls.CodeActionKind.Source, code.CodeActionKind.Source);
    kindMapping.set(ls.CodeActionKind.SourceOrganizeImports, code.CodeActionKind.SourceOrganizeImports);
    function asCodeActionKind(item) {
        var e_3, _a;
        if (item === void 0 || item === null) {
            return undefined;
        }
        var result = kindMapping.get(item);
        if (result) {
            return result;
        }
        var parts = item.split('.');
        result = code.CodeActionKind.Empty;
        try {
            for (var parts_1 = __values(parts), parts_1_1 = parts_1.next(); !parts_1_1.done; parts_1_1 = parts_1.next()) {
                var part = parts_1_1.value;
                result = result.append(part);
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (parts_1_1 && !parts_1_1.done && (_a = parts_1.return)) _a.call(parts_1);
            }
            finally { if (e_3) throw e_3.error; }
        }
        return result;
    }
    function asCodeAction(item) {
        if (item === void 0 || item === null) {
            return undefined;
        }
        var result = new code.CodeAction(item.title);
        if (item.kind !== void 0) {
            result.kind = asCodeActionKind(item.kind);
        }
        if (item.diagnostics) {
            result.diagnostics = asDiagnostics(item.diagnostics);
        }
        if (item.edit) {
            result.edit = asWorkspaceEdit(item.edit);
        }
        if (item.command) {
            result.command = asCommand(item.command);
        }
        return result;
    }
    function asCodeLens(item) {
        if (!item) {
            return undefined;
        }
        var result = new protocolCodeLens_1.default(asRange(item.range));
        if (item.command) {
            result.command = asCommand(item.command);
        }
        if (item.data !== void 0 && item.data !== null) {
            result.data = item.data;
        }
        return result;
    }
    function asCodeLenses(items) {
        if (!items) {
            return undefined;
        }
        return items.map(function (codeLens) { return asCodeLens(codeLens); });
    }
    function asWorkspaceEdit(item) {
        if (!item) {
            return undefined;
        }
        var result = new code.WorkspaceEdit();
        if (item.documentChanges) {
            item.documentChanges.forEach(function (change) {
                result.set(_uriConverter(change.textDocument.uri), asTextEdits(change.edits));
            });
        }
        else if (item.changes) {
            Object.keys(item.changes).forEach(function (key) {
                result.set(_uriConverter(key), asTextEdits(item.changes[key]));
            });
        }
        return result;
    }
    function asDocumentLink(item) {
        var range = asRange(item.range);
        var target = item.target ? asUri(item.target) : undefined;
        // target must be optional in DocumentLink
        var link = new protocolDocumentLink_1.default(range, target);
        if (item.data !== void 0 && item.data !== null) {
            link.data = item.data;
        }
        return link;
    }
    function asDocumentLinks(items) {
        if (!items) {
            return undefined;
        }
        return items.map(asDocumentLink);
    }
    function asColor(color) {
        return new code.Color(color.red, color.green, color.blue, color.alpha);
    }
    function asColorInformation(ci) {
        return new code.ColorInformation(asRange(ci.range), asColor(ci.color));
    }
    function asColorInformations(colorInformation) {
        if (Array.isArray(colorInformation)) {
            return colorInformation.map(asColorInformation);
        }
        return undefined;
    }
    function asColorPresentation(cp) {
        var presentation = new code.ColorPresentation(cp.label);
        presentation.additionalTextEdits = asTextEdits(cp.additionalTextEdits);
        if (cp.textEdit) {
            presentation.textEdit = asTextEdit(cp.textEdit);
        }
        return presentation;
    }
    function asColorPresentations(colorPresentations) {
        if (Array.isArray(colorPresentations)) {
            return colorPresentations.map(asColorPresentation);
        }
        return undefined;
    }
    function asFoldingRangeKind(kind) {
        if (kind) {
            switch (kind) {
                case ls.FoldingRangeKind.Comment:
                    return code.FoldingRangeKind.Comment;
                case ls.FoldingRangeKind.Imports:
                    return code.FoldingRangeKind.Imports;
                case ls.FoldingRangeKind.Region:
                    return code.FoldingRangeKind.Region;
            }
        }
        return void 0;
    }
    function asFoldingRange(r) {
        return new code.FoldingRange(r.startLine, r.endLine, asFoldingRangeKind(r.kind));
    }
    function asFoldingRanges(foldingRanges) {
        if (Array.isArray(foldingRanges)) {
            return foldingRanges.map(asFoldingRange);
        }
        return void 0;
    }
    return {
        asUri: asUri,
        asDiagnostics: asDiagnostics,
        asDiagnostic: asDiagnostic,
        asRange: asRange,
        asPosition: asPosition,
        asDiagnosticSeverity: asDiagnosticSeverity,
        asHover: asHover,
        asCompletionResult: asCompletionResult,
        asCompletionItem: asCompletionItem,
        asTextEdit: asTextEdit,
        asTextEdits: asTextEdits,
        asSignatureHelp: asSignatureHelp,
        asSignatureInformations: asSignatureInformations,
        asSignatureInformation: asSignatureInformation,
        asParameterInformations: asParameterInformations,
        asParameterInformation: asParameterInformation,
        asDefinitionResult: asDefinitionResult,
        asLocation: asLocation,
        asReferences: asReferences,
        asDocumentHighlights: asDocumentHighlights,
        asDocumentHighlight: asDocumentHighlight,
        asDocumentHighlightKind: asDocumentHighlightKind,
        asSymbolInformations: asSymbolInformations,
        asSymbolInformation: asSymbolInformation,
        asDocumentSymbols: asDocumentSymbols,
        asDocumentSymbol: asDocumentSymbol,
        asCommand: asCommand,
        asCommands: asCommands,
        asCodeAction: asCodeAction,
        asCodeLens: asCodeLens,
        asCodeLenses: asCodeLenses,
        asWorkspaceEdit: asWorkspaceEdit,
        asDocumentLink: asDocumentLink,
        asDocumentLinks: asDocumentLinks,
        asFoldingRangeKind: asFoldingRangeKind,
        asFoldingRange: asFoldingRange,
        asFoldingRanges: asFoldingRanges,
        asColor: asColor,
        asColorInformation: asColorInformation,
        asColorInformations: asColorInformations,
        asColorPresentation: asColorPresentation,
        asColorPresentations: asColorPresentations
    };
}
exports.createConverter = createConverter;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/protocolDocumentLink.js":
/*!******************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/protocolDocumentLink.js ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var code = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var ProtocolDocumentLink = /** @class */ (function (_super) {
    __extends(ProtocolDocumentLink, _super);
    function ProtocolDocumentLink(range, target) {
        return _super.call(this, range, target) || this;
    }
    return ProtocolDocumentLink;
}(code.DocumentLink));
exports.default = ProtocolDocumentLink;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/typeDefinition.js":
/*!************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/typeDefinition.js ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
Object.defineProperty(exports, "__esModule", { value: true });
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
var Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-base-languageclient/lib/utils/is.js");
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
var client_1 = __webpack_require__(/*! ./client */ "../node_modules/vscode-base-languageclient/lib/client.js");
function ensure(target, key) {
    if (target[key] === void 0) {
        target[key] = {};
    }
    return target[key];
}
var TypeDefinitionFeature = /** @class */ (function (_super) {
    __extends(TypeDefinitionFeature, _super);
    function TypeDefinitionFeature(client) {
        return _super.call(this, client, vscode_languageserver_protocol_1.TypeDefinitionRequest.type) || this;
    }
    TypeDefinitionFeature.prototype.fillClientCapabilities = function (capabilites) {
        ensure(ensure(capabilites, 'textDocument'), 'typeDefinition').dynamicRegistration = true;
    };
    TypeDefinitionFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!capabilities.typeDefinitionProvider) {
            return;
        }
        if (capabilities.typeDefinitionProvider === true) {
            if (!documentSelector) {
                return;
            }
            this.register(this.messages, {
                id: UUID.generateUuid(),
                registerOptions: Object.assign({}, { documentSelector: documentSelector })
            });
        }
        else {
            var implCapabilities = capabilities.typeDefinitionProvider;
            var id = Is.string(implCapabilities.id) && implCapabilities.id.length > 0 ? implCapabilities.id : UUID.generateUuid();
            var selector = implCapabilities.documentSelector || documentSelector;
            if (selector) {
                this.register(this.messages, {
                    id: id,
                    registerOptions: Object.assign({}, { documentSelector: selector })
                });
            }
        }
    };
    TypeDefinitionFeature.prototype.registerLanguageProvider = function (options) {
        var client = this._client;
        var provideTypeDefinition = function (document, position, token) {
            return client.sendRequest(vscode_languageserver_protocol_1.TypeDefinitionRequest.type, client.code2ProtocolConverter.asTextDocumentPositionParams(document, position), token).then(client.protocol2CodeConverter.asDefinitionResult, function (error) {
                client.logFailedRequest(vscode_languageserver_protocol_1.TypeDefinitionRequest.type, error);
                return Promise.resolve(null);
            });
        };
        var middleware = client.clientOptions.middleware;
        return vscode_1.languages.registerTypeDefinitionProvider(options.documentSelector, {
            provideTypeDefinition: function (document, position, token) {
                return middleware.provideTypeDefinition
                    ? middleware.provideTypeDefinition(document, position, token, provideTypeDefinition)
                    : provideTypeDefinition(document, position, token);
            }
        });
    };
    return TypeDefinitionFeature;
}(client_1.TextDocumentFeature));
exports.TypeDefinitionFeature = TypeDefinitionFeature;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/utils/async.js":
/*!*********************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/utils/async.js ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
var Delayer = /** @class */ (function () {
    function Delayer(defaultDelay) {
        this.defaultDelay = defaultDelay;
        this.timeout = undefined;
        this.completionPromise = undefined;
        this.onSuccess = undefined;
        this.task = undefined;
    }
    Delayer.prototype.trigger = function (task, delay) {
        var _this = this;
        if (delay === void 0) { delay = this.defaultDelay; }
        this.task = task;
        if (delay >= 0) {
            this.cancelTimeout();
        }
        if (!this.completionPromise) {
            this.completionPromise = new Promise(function (resolve) {
                _this.onSuccess = resolve;
            }).then(function () {
                _this.completionPromise = undefined;
                _this.onSuccess = undefined;
                var result = _this.task();
                _this.task = undefined;
                return result;
            });
        }
        if (delay >= 0 || this.timeout === void 0) {
            this.timeout = setTimeout(function () {
                _this.timeout = undefined;
                _this.onSuccess(undefined);
            }, delay >= 0 ? delay : this.defaultDelay);
        }
        return this.completionPromise;
    };
    Delayer.prototype.forceDelivery = function () {
        if (!this.completionPromise) {
            return undefined;
        }
        this.cancelTimeout();
        var result = this.task();
        this.completionPromise = undefined;
        this.onSuccess = undefined;
        this.task = undefined;
        return result;
    };
    Delayer.prototype.isTriggered = function () {
        return this.timeout !== void 0;
    };
    Delayer.prototype.cancel = function () {
        this.cancelTimeout();
        this.completionPromise = undefined;
    };
    Delayer.prototype.cancelTimeout = function () {
        if (this.timeout !== void 0) {
            clearTimeout(this.timeout);
            this.timeout = undefined;
        }
    };
    return Delayer;
}());
exports.Delayer = Delayer;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/utils/is.js":
/*!******************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/utils/is.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
var toString = Object.prototype.toString;
function boolean(value) {
    return value === true || value === false;
}
exports.boolean = boolean;
function string(value) {
    return toString.call(value) === '[object String]';
}
exports.string = string;
function number(value) {
    return toString.call(value) === '[object Number]';
}
exports.number = number;
function error(value) {
    return toString.call(value) === '[object Error]';
}
exports.error = error;
function func(value) {
    return toString.call(value) === '[object Function]';
}
exports.func = func;
function array(value) {
    return Array.isArray(value);
}
exports.array = array;
function stringArray(value) {
    return array(value) && value.every(function (elem) { return string(elem); });
}
exports.stringArray = stringArray;
function typedArray(value, check) {
    return Array.isArray(value) && value.every(check);
}
exports.typedArray = typedArray;
function thenable(value) {
    return value && func(value.then);
}
exports.thenable = thenable;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js":
/*!********************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/utils/uuid.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

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
Object.defineProperty(exports, "__esModule", { value: true });
var ValueUUID = /** @class */ (function () {
    function ValueUUID(_value) {
        this._value = _value;
        // empty
    }
    ValueUUID.prototype.asHex = function () {
        return this._value;
    };
    ValueUUID.prototype.equals = function (other) {
        return this.asHex() === other.asHex();
    };
    return ValueUUID;
}());
var V4UUID = /** @class */ (function (_super) {
    __extends(V4UUID, _super);
    function V4UUID() {
        return _super.call(this, [
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            '-',
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            '-',
            '4',
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            '-',
            V4UUID._oneOf(V4UUID._timeHighBits),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            '-',
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
            V4UUID._randomHex(),
        ].join('')) || this;
    }
    V4UUID._oneOf = function (array) {
        return array[Math.floor(array.length * Math.random())];
    };
    V4UUID._randomHex = function () {
        return V4UUID._oneOf(V4UUID._chars);
    };
    V4UUID._chars = ['0', '1', '2', '3', '4', '5', '6', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
    V4UUID._timeHighBits = ['8', '9', 'a', 'b'];
    return V4UUID;
}(ValueUUID));
/**
 * An empty UUID that contains only zeros.
 */
exports.empty = new ValueUUID('00000000-0000-0000-0000-000000000000');
function v4() {
    return new V4UUID();
}
exports.v4 = v4;
var _UUIDPattern = /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i;
function isUUID(value) {
    return _UUIDPattern.test(value);
}
exports.isUUID = isUUID;
/**
 * Parses a UUID that is of the format xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx.
 * @param value A uuid string.
 */
function parse(value) {
    if (!isUUID(value)) {
        throw new Error('invalid uuid');
    }
    return new ValueUUID(value);
}
exports.parse = parse;
function generateUuid() {
    return v4().asHex();
}
exports.generateUuid = generateUuid;


/***/ }),

/***/ "../node_modules/vscode-base-languageclient/lib/workspaceFolders.js":
/*!**************************************************************************!*\
  !*** ../node_modules/vscode-base-languageclient/lib/workspaceFolders.js ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

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
var UUID = __webpack_require__(/*! ./utils/uuid */ "../node_modules/vscode-base-languageclient/lib/utils/uuid.js");
var vscode_1 = __webpack_require__(/*! vscode */ "../node_modules/monaco-languageclient/lib/vscode-compatibility.js");
var vscode_languageserver_protocol_1 = __webpack_require__(/*! vscode-languageserver-protocol */ "../node_modules/vscode-languageserver-protocol/lib/main.js");
function access(target, key) {
    if (target === void 0) {
        return undefined;
    }
    return target[key];
}
var WorkspaceFoldersFeature = /** @class */ (function () {
    function WorkspaceFoldersFeature(_client) {
        this._client = _client;
        this._listeners = new Map();
    }
    Object.defineProperty(WorkspaceFoldersFeature.prototype, "messages", {
        get: function () {
            return vscode_languageserver_protocol_1.DidChangeWorkspaceFoldersNotification.type;
        },
        enumerable: true,
        configurable: true
    });
    WorkspaceFoldersFeature.prototype.fillInitializeParams = function (params) {
        var _this = this;
        var folders = vscode_1.workspace.workspaceFolders;
        if (folders === void 0) {
            params.workspaceFolders = null;
        }
        else {
            params.workspaceFolders = folders.map(function (folder) { return _this.asProtocol(folder); });
        }
    };
    WorkspaceFoldersFeature.prototype.fillClientCapabilities = function (capabilities) {
        capabilities.workspace = capabilities.workspace || {};
        capabilities.workspace.workspaceFolders = true;
    };
    WorkspaceFoldersFeature.prototype.initialize = function (capabilities) {
        var _this = this;
        var client = this._client;
        client.onRequest(vscode_languageserver_protocol_1.WorkspaceFoldersRequest.type, function (token) {
            var workspaceFolders = function () {
                var folders = vscode_1.workspace.workspaceFolders;
                if (folders === void 0) {
                    return null;
                }
                var result = folders.map(function (folder) {
                    return _this.asProtocol(folder);
                });
                return result;
            };
            var middleware = client.clientOptions.middleware.workspace;
            return middleware && middleware.workspaceFolders
                ? middleware.workspaceFolders(token, workspaceFolders)
                : workspaceFolders(token);
        });
        var value = access(access(access(capabilities, 'workspace'), 'workspaceFolders'), 'changeNotifications');
        var id;
        if (typeof value === 'string') {
            id = value;
        }
        else if (value === true) {
            id = UUID.generateUuid();
        }
        if (id) {
            this.register(this.messages, {
                id: id,
                registerOptions: undefined
            });
        }
    };
    WorkspaceFoldersFeature.prototype.register = function (_message, data) {
        var _this = this;
        var id = data.id;
        var client = this._client;
        var disposable = vscode_1.workspace.onDidChangeWorkspaceFolders(function (event) {
            var didChangeWorkspaceFolders = function (event) {
                var params = {
                    event: {
                        added: event.added.map(function (folder) { return _this.asProtocol(folder); }),
                        removed: event.removed.map(function (folder) { return _this.asProtocol(folder); })
                    }
                };
                _this._client.sendNotification(vscode_languageserver_protocol_1.DidChangeWorkspaceFoldersNotification.type, params);
            };
            var middleware = client.clientOptions.middleware.workspace;
            middleware && middleware.didChangeWorkspaceFolders
                ? middleware.didChangeWorkspaceFolders(event, didChangeWorkspaceFolders)
                : didChangeWorkspaceFolders(event);
        });
        this._listeners.set(id, disposable);
    };
    WorkspaceFoldersFeature.prototype.unregister = function (id) {
        var disposable = this._listeners.get(id);
        if (disposable === void 0) {
            return;
        }
        this._listeners.delete(id);
        disposable.dispose();
    };
    WorkspaceFoldersFeature.prototype.dispose = function () {
        var e_1, _a;
        try {
            for (var _b = __values(this._listeners.values()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var disposable = _c.value;
                disposable.dispose();
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_1) throw e_1.error; }
        }
        this._listeners.clear();
    };
    WorkspaceFoldersFeature.prototype.asProtocol = function (workspaceFolder) {
        if (workspaceFolder === void 0) {
            return null;
        }
        return { uri: this._client.code2ProtocolConverter.asUri(workspaceFolder.uri), name: workspaceFolder.name };
    };
    return WorkspaceFoldersFeature;
}());
exports.WorkspaceFoldersFeature = WorkspaceFoldersFeature;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/main.js":
/*!******************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/main.js ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
exports.ErrorCodes = vscode_jsonrpc_1.ErrorCodes;
exports.ResponseError = vscode_jsonrpc_1.ResponseError;
exports.CancellationToken = vscode_jsonrpc_1.CancellationToken;
exports.CancellationTokenSource = vscode_jsonrpc_1.CancellationTokenSource;
exports.Disposable = vscode_jsonrpc_1.Disposable;
exports.Event = vscode_jsonrpc_1.Event;
exports.Emitter = vscode_jsonrpc_1.Emitter;
exports.Trace = vscode_jsonrpc_1.Trace;
exports.TraceFormat = vscode_jsonrpc_1.TraceFormat;
exports.SetTraceNotification = vscode_jsonrpc_1.SetTraceNotification;
exports.LogTraceNotification = vscode_jsonrpc_1.LogTraceNotification;
exports.RequestType = vscode_jsonrpc_1.RequestType;
exports.RequestType0 = vscode_jsonrpc_1.RequestType0;
exports.NotificationType = vscode_jsonrpc_1.NotificationType;
exports.NotificationType0 = vscode_jsonrpc_1.NotificationType0;
exports.MessageReader = vscode_jsonrpc_1.MessageReader;
exports.MessageWriter = vscode_jsonrpc_1.MessageWriter;
exports.ConnectionStrategy = vscode_jsonrpc_1.ConnectionStrategy;
exports.StreamMessageReader = vscode_jsonrpc_1.StreamMessageReader;
exports.StreamMessageWriter = vscode_jsonrpc_1.StreamMessageWriter;
exports.IPCMessageReader = vscode_jsonrpc_1.IPCMessageReader;
exports.IPCMessageWriter = vscode_jsonrpc_1.IPCMessageWriter;
exports.createClientPipeTransport = vscode_jsonrpc_1.createClientPipeTransport;
exports.createServerPipeTransport = vscode_jsonrpc_1.createServerPipeTransport;
exports.generateRandomPipeName = vscode_jsonrpc_1.generateRandomPipeName;
exports.createClientSocketTransport = vscode_jsonrpc_1.createClientSocketTransport;
exports.createServerSocketTransport = vscode_jsonrpc_1.createServerSocketTransport;
__export(__webpack_require__(/*! vscode-languageserver-types */ "../node_modules/vscode-languageserver-types/lib/esm/main.js"));
__export(__webpack_require__(/*! ./protocol */ "../node_modules/vscode-languageserver-protocol/lib/protocol.js"));
function createProtocolConnection(reader, writer, logger, strategy) {
    return vscode_jsonrpc_1.createMessageConnection(reader, writer, logger, strategy);
}
exports.createProtocolConnection = createProtocolConnection;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.colorProvider.js":
/*!************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.colorProvider.js ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * A request to list all color symbols found in a given text document. The request's
 * parameter is of type [DocumentColorParams](#DocumentColorParams) the
 * response is of type [ColorInformation[]](#ColorInformation) or a Thenable
 * that resolves to such.
 */
var DocumentColorRequest;
(function (DocumentColorRequest) {
    DocumentColorRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/documentColor');
})(DocumentColorRequest = exports.DocumentColorRequest || (exports.DocumentColorRequest = {}));
/**
 * A request to list all presentation for a color. The request's
 * parameter is of type [ColorPresentationParams](#ColorPresentationParams) the
 * response is of type [ColorInformation[]](#ColorInformation) or a Thenable
 * that resolves to such.
 */
var ColorPresentationRequest;
(function (ColorPresentationRequest) {
    ColorPresentationRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/colorPresentation');
})(ColorPresentationRequest = exports.ColorPresentationRequest || (exports.ColorPresentationRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.configuration.js":
/*!************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.configuration.js ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * The 'workspace/configuration' request is sent from the server to the client to fetch a certain
 * configuration setting.
 *
 * This pull model replaces the old push model were the client signaled configuration change via an
 * event. If the server still needs to react to configuration changes (since the server caches the
 * result of `workspace/configuration` requests) the server should register for an empty configuration
 * change event and empty the cache if such an event is received.
 */
var ConfigurationRequest;
(function (ConfigurationRequest) {
    ConfigurationRequest.type = new vscode_jsonrpc_1.RequestType('workspace/configuration');
})(ConfigurationRequest = exports.ConfigurationRequest || (exports.ConfigurationRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.foldingRange.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.foldingRange.js ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/
Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * Enum of known range kinds
 */
var FoldingRangeKind;
(function (FoldingRangeKind) {
    /**
     * Folding range for a comment
     */
    FoldingRangeKind["Comment"] = "comment";
    /**
     * Folding range for a imports or includes
     */
    FoldingRangeKind["Imports"] = "imports";
    /**
     * Folding range for a region (e.g. `#region`)
     */
    FoldingRangeKind["Region"] = "region";
})(FoldingRangeKind = exports.FoldingRangeKind || (exports.FoldingRangeKind = {}));
/**
 * A request to provide folding ranges in a document. The request's
 * parameter is of type [FoldingRangeParams](#FoldingRangeParams), the
 * response is of type [FoldingRangeList](#FoldingRangeList) or a Thenable
 * that resolves to such.
 */
var FoldingRangeRequest;
(function (FoldingRangeRequest) {
    FoldingRangeRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/foldingRange');
})(FoldingRangeRequest = exports.FoldingRangeRequest || (exports.FoldingRangeRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.implementation.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.implementation.js ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * A request to resolve the implementation locations of a symbol at a given text
 * document position. The request's parameter is of type [TextDocumentPositioParams]
 * (#TextDocumentPositionParams) the response is of type [Definition](#Definition) or a
 * Thenable that resolves to such.
 */
var ImplementationRequest;
(function (ImplementationRequest) {
    ImplementationRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/implementation');
})(ImplementationRequest = exports.ImplementationRequest || (exports.ImplementationRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.js":
/*!**********************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const Is = __webpack_require__(/*! ./utils/is */ "../node_modules/vscode-languageserver-protocol/lib/utils/is.js");
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
const protocol_implementation_1 = __webpack_require__(/*! ./protocol.implementation */ "../node_modules/vscode-languageserver-protocol/lib/protocol.implementation.js");
exports.ImplementationRequest = protocol_implementation_1.ImplementationRequest;
const protocol_typeDefinition_1 = __webpack_require__(/*! ./protocol.typeDefinition */ "../node_modules/vscode-languageserver-protocol/lib/protocol.typeDefinition.js");
exports.TypeDefinitionRequest = protocol_typeDefinition_1.TypeDefinitionRequest;
const protocol_workspaceFolders_1 = __webpack_require__(/*! ./protocol.workspaceFolders */ "../node_modules/vscode-languageserver-protocol/lib/protocol.workspaceFolders.js");
exports.WorkspaceFoldersRequest = protocol_workspaceFolders_1.WorkspaceFoldersRequest;
exports.DidChangeWorkspaceFoldersNotification = protocol_workspaceFolders_1.DidChangeWorkspaceFoldersNotification;
const protocol_configuration_1 = __webpack_require__(/*! ./protocol.configuration */ "../node_modules/vscode-languageserver-protocol/lib/protocol.configuration.js");
exports.ConfigurationRequest = protocol_configuration_1.ConfigurationRequest;
const protocol_colorProvider_1 = __webpack_require__(/*! ./protocol.colorProvider */ "../node_modules/vscode-languageserver-protocol/lib/protocol.colorProvider.js");
exports.DocumentColorRequest = protocol_colorProvider_1.DocumentColorRequest;
exports.ColorPresentationRequest = protocol_colorProvider_1.ColorPresentationRequest;
const protocol_foldingRange_1 = __webpack_require__(/*! ./protocol.foldingRange */ "../node_modules/vscode-languageserver-protocol/lib/protocol.foldingRange.js");
exports.FoldingRangeRequest = protocol_foldingRange_1.FoldingRangeRequest;
var DocumentFilter;
(function (DocumentFilter) {
    function is(value) {
        let candidate = value;
        return Is.string(candidate.language) || Is.string(candidate.scheme) || Is.string(candidate.pattern);
    }
    DocumentFilter.is = is;
})(DocumentFilter = exports.DocumentFilter || (exports.DocumentFilter = {}));
/**
 * The `client/registerCapability` request is sent from the server to the client to register a new capability
 * handler on the client side.
 */
var RegistrationRequest;
(function (RegistrationRequest) {
    RegistrationRequest.type = new vscode_jsonrpc_1.RequestType('client/registerCapability');
})(RegistrationRequest = exports.RegistrationRequest || (exports.RegistrationRequest = {}));
/**
 * The `client/unregisterCapability` request is sent from the server to the client to unregister a previously registered capability
 * handler on the client side.
 */
var UnregistrationRequest;
(function (UnregistrationRequest) {
    UnregistrationRequest.type = new vscode_jsonrpc_1.RequestType('client/unregisterCapability');
})(UnregistrationRequest = exports.UnregistrationRequest || (exports.UnregistrationRequest = {}));
var ResourceOperationKind;
(function (ResourceOperationKind) {
    /**
     * Supports creating new resources.
     */
    ResourceOperationKind.Create = 'create';
    /**
     * Supports renaming existing resources.
     */
    ResourceOperationKind.Rename = 'rename';
    /**
     * Supports deleting existing resources.
     */
    ResourceOperationKind.Delete = 'delete';
})(ResourceOperationKind = exports.ResourceOperationKind || (exports.ResourceOperationKind = {}));
var FailureHandlingKind;
(function (FailureHandlingKind) {
    /**
     * Applying the workspace change is simply aborted if one of the changes provided
     * fails. All operations executed before the failing operation stay executed.
     */
    FailureHandlingKind.Abort = 'abort';
    /**
     * All operations are executed transactional. That means they either all
     * succeed or no changes at all are applied to the workspace.
     */
    FailureHandlingKind.Transactional = 'transactional';
    /**
     * If the workspace edit contains only textual file changes they are executed transactional.
     * If resource changes (create, rename or delete file) are part of the change the failure
     * handling startegy is abort.
     */
    FailureHandlingKind.TextOnlyTransactional = 'textOnlyTransactional';
    /**
     * The client tries to undo the operations already executed. But there is no
     * guaruntee that this is succeeding.
     */
    FailureHandlingKind.Undo = 'undo';
})(FailureHandlingKind = exports.FailureHandlingKind || (exports.FailureHandlingKind = {}));
/**
 * Defines how the host (editor) should sync
 * document changes to the language server.
 */
var TextDocumentSyncKind;
(function (TextDocumentSyncKind) {
    /**
     * Documents should not be synced at all.
     */
    TextDocumentSyncKind.None = 0;
    /**
     * Documents are synced by always sending the full content
     * of the document.
     */
    TextDocumentSyncKind.Full = 1;
    /**
     * Documents are synced by sending the full content on open.
     * After that only incremental updates to the document are
     * send.
     */
    TextDocumentSyncKind.Incremental = 2;
})(TextDocumentSyncKind = exports.TextDocumentSyncKind || (exports.TextDocumentSyncKind = {}));
/**
 * The initialize request is sent from the client to the server.
 * It is sent once as the request after starting up the server.
 * The requests parameter is of type [InitializeParams](#InitializeParams)
 * the response if of type [InitializeResult](#InitializeResult) of a Thenable that
 * resolves to such.
 */
var InitializeRequest;
(function (InitializeRequest) {
    InitializeRequest.type = new vscode_jsonrpc_1.RequestType('initialize');
})(InitializeRequest = exports.InitializeRequest || (exports.InitializeRequest = {}));
/**
 * Known error codes for an `InitializeError`;
 */
var InitializeError;
(function (InitializeError) {
    /**
     * If the protocol version provided by the client can't be handled by the server.
     * @deprecated This initialize error got replaced by client capabilities. There is
     * no version handshake in version 3.0x
     */
    InitializeError.unknownProtocolVersion = 1;
})(InitializeError = exports.InitializeError || (exports.InitializeError = {}));
/**
 * The intialized notification is sent from the client to the
 * server after the client is fully initialized and the server
 * is allowed to send requests from the server to the client.
 */
var InitializedNotification;
(function (InitializedNotification) {
    InitializedNotification.type = new vscode_jsonrpc_1.NotificationType('initialized');
})(InitializedNotification = exports.InitializedNotification || (exports.InitializedNotification = {}));
//---- Shutdown Method ----
/**
 * A shutdown request is sent from the client to the server.
 * It is sent once when the client decides to shutdown the
 * server. The only notification that is sent after a shutdown request
 * is the exit event.
 */
var ShutdownRequest;
(function (ShutdownRequest) {
    ShutdownRequest.type = new vscode_jsonrpc_1.RequestType0('shutdown');
})(ShutdownRequest = exports.ShutdownRequest || (exports.ShutdownRequest = {}));
//---- Exit Notification ----
/**
 * The exit event is sent from the client to the server to
 * ask the server to exit its process.
 */
var ExitNotification;
(function (ExitNotification) {
    ExitNotification.type = new vscode_jsonrpc_1.NotificationType0('exit');
})(ExitNotification = exports.ExitNotification || (exports.ExitNotification = {}));
//---- Configuration notification ----
/**
 * The configuration change notification is sent from the client to the server
 * when the client's configuration has changed. The notification contains
 * the changed configuration as defined by the language client.
 */
var DidChangeConfigurationNotification;
(function (DidChangeConfigurationNotification) {
    DidChangeConfigurationNotification.type = new vscode_jsonrpc_1.NotificationType('workspace/didChangeConfiguration');
})(DidChangeConfigurationNotification = exports.DidChangeConfigurationNotification || (exports.DidChangeConfigurationNotification = {}));
//---- Message show and log notifications ----
/**
 * The message type
 */
var MessageType;
(function (MessageType) {
    /**
     * An error message.
     */
    MessageType.Error = 1;
    /**
     * A warning message.
     */
    MessageType.Warning = 2;
    /**
     * An information message.
     */
    MessageType.Info = 3;
    /**
     * A log message.
     */
    MessageType.Log = 4;
})(MessageType = exports.MessageType || (exports.MessageType = {}));
/**
 * The show message notification is sent from a server to a client to ask
 * the client to display a particular message in the user interface.
 */
var ShowMessageNotification;
(function (ShowMessageNotification) {
    ShowMessageNotification.type = new vscode_jsonrpc_1.NotificationType('window/showMessage');
})(ShowMessageNotification = exports.ShowMessageNotification || (exports.ShowMessageNotification = {}));
/**
 * The show message request is sent from the server to the client to show a message
 * and a set of options actions to the user.
 */
var ShowMessageRequest;
(function (ShowMessageRequest) {
    ShowMessageRequest.type = new vscode_jsonrpc_1.RequestType('window/showMessageRequest');
})(ShowMessageRequest = exports.ShowMessageRequest || (exports.ShowMessageRequest = {}));
/**
 * The log message notification is sent from the server to the client to ask
 * the client to log a particular message.
 */
var LogMessageNotification;
(function (LogMessageNotification) {
    LogMessageNotification.type = new vscode_jsonrpc_1.NotificationType('window/logMessage');
})(LogMessageNotification = exports.LogMessageNotification || (exports.LogMessageNotification = {}));
//---- Telemetry notification
/**
 * The telemetry event notification is sent from the server to the client to ask
 * the client to log telemetry data.
 */
var TelemetryEventNotification;
(function (TelemetryEventNotification) {
    TelemetryEventNotification.type = new vscode_jsonrpc_1.NotificationType('telemetry/event');
})(TelemetryEventNotification = exports.TelemetryEventNotification || (exports.TelemetryEventNotification = {}));
/**
 * The document open notification is sent from the client to the server to signal
 * newly opened text documents. The document's truth is now managed by the client
 * and the server must not try to read the document's truth using the document's
 * uri. Open in this sense means it is managed by the client. It doesn't necessarily
 * mean that its content is presented in an editor. An open notification must not
 * be sent more than once without a corresponding close notification send before.
 * This means open and close notification must be balanced and the max open count
 * is one.
 */
var DidOpenTextDocumentNotification;
(function (DidOpenTextDocumentNotification) {
    DidOpenTextDocumentNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/didOpen');
})(DidOpenTextDocumentNotification = exports.DidOpenTextDocumentNotification || (exports.DidOpenTextDocumentNotification = {}));
/**
 * The document change notification is sent from the client to the server to signal
 * changes to a text document.
 */
var DidChangeTextDocumentNotification;
(function (DidChangeTextDocumentNotification) {
    DidChangeTextDocumentNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/didChange');
})(DidChangeTextDocumentNotification = exports.DidChangeTextDocumentNotification || (exports.DidChangeTextDocumentNotification = {}));
/**
 * The document close notification is sent from the client to the server when
 * the document got closed in the client. The document's truth now exists where
 * the document's uri points to (e.g. if the document's uri is a file uri the
 * truth now exists on disk). As with the open notification the close notification
 * is about managing the document's content. Receiving a close notification
 * doesn't mean that the document was open in an editor before. A close
 * notification requires a previous open notification to be sent.
 */
var DidCloseTextDocumentNotification;
(function (DidCloseTextDocumentNotification) {
    DidCloseTextDocumentNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/didClose');
})(DidCloseTextDocumentNotification = exports.DidCloseTextDocumentNotification || (exports.DidCloseTextDocumentNotification = {}));
/**
 * The document save notification is sent from the client to the server when
 * the document got saved in the client.
 */
var DidSaveTextDocumentNotification;
(function (DidSaveTextDocumentNotification) {
    DidSaveTextDocumentNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/didSave');
})(DidSaveTextDocumentNotification = exports.DidSaveTextDocumentNotification || (exports.DidSaveTextDocumentNotification = {}));
/**
 * A document will save notification is sent from the client to the server before
 * the document is actually saved.
 */
var WillSaveTextDocumentNotification;
(function (WillSaveTextDocumentNotification) {
    WillSaveTextDocumentNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/willSave');
})(WillSaveTextDocumentNotification = exports.WillSaveTextDocumentNotification || (exports.WillSaveTextDocumentNotification = {}));
/**
 * A document will save request is sent from the client to the server before
 * the document is actually saved. The request can return an array of TextEdits
 * which will be applied to the text document before it is saved. Please note that
 * clients might drop results if computing the text edits took too long or if a
 * server constantly fails on this request. This is done to keep the save fast and
 * reliable.
 */
var WillSaveTextDocumentWaitUntilRequest;
(function (WillSaveTextDocumentWaitUntilRequest) {
    WillSaveTextDocumentWaitUntilRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/willSaveWaitUntil');
})(WillSaveTextDocumentWaitUntilRequest = exports.WillSaveTextDocumentWaitUntilRequest || (exports.WillSaveTextDocumentWaitUntilRequest = {}));
//---- File eventing ----
/**
 * The watched files notification is sent from the client to the server when
 * the client detects changes to file watched by the language client.
 */
var DidChangeWatchedFilesNotification;
(function (DidChangeWatchedFilesNotification) {
    DidChangeWatchedFilesNotification.type = new vscode_jsonrpc_1.NotificationType('workspace/didChangeWatchedFiles');
})(DidChangeWatchedFilesNotification = exports.DidChangeWatchedFilesNotification || (exports.DidChangeWatchedFilesNotification = {}));
/**
 * The file event type
 */
var FileChangeType;
(function (FileChangeType) {
    /**
     * The file got created.
     */
    FileChangeType.Created = 1;
    /**
     * The file got changed.
     */
    FileChangeType.Changed = 2;
    /**
     * The file got deleted.
     */
    FileChangeType.Deleted = 3;
})(FileChangeType = exports.FileChangeType || (exports.FileChangeType = {}));
var WatchKind;
(function (WatchKind) {
    /**
     * Interested in create events.
     */
    WatchKind.Create = 1;
    /**
     * Interested in change events
     */
    WatchKind.Change = 2;
    /**
     * Interested in delete events
     */
    WatchKind.Delete = 4;
})(WatchKind = exports.WatchKind || (exports.WatchKind = {}));
//---- Diagnostic notification ----
/**
 * Diagnostics notification are sent from the server to the client to signal
 * results of validation runs.
 */
var PublishDiagnosticsNotification;
(function (PublishDiagnosticsNotification) {
    PublishDiagnosticsNotification.type = new vscode_jsonrpc_1.NotificationType('textDocument/publishDiagnostics');
})(PublishDiagnosticsNotification = exports.PublishDiagnosticsNotification || (exports.PublishDiagnosticsNotification = {}));
/**
 * How a completion was triggered
 */
var CompletionTriggerKind;
(function (CompletionTriggerKind) {
    /**
     * Completion was triggered by typing an identifier (24x7 code
     * complete), manual invocation (e.g Ctrl+Space) or via API.
     */
    CompletionTriggerKind.Invoked = 1;
    /**
     * Completion was triggered by a trigger character specified by
     * the `triggerCharacters` properties of the `CompletionRegistrationOptions`.
     */
    CompletionTriggerKind.TriggerCharacter = 2;
    /**
     * Completion was re-triggered as current completion list is incomplete
     */
    CompletionTriggerKind.TriggerForIncompleteCompletions = 3;
})(CompletionTriggerKind = exports.CompletionTriggerKind || (exports.CompletionTriggerKind = {}));
/**
 * Request to request completion at a given text document position. The request's
 * parameter is of type [TextDocumentPosition](#TextDocumentPosition) the response
 * is of type [CompletionItem[]](#CompletionItem) or [CompletionList](#CompletionList)
 * or a Thenable that resolves to such.
 *
 * The request can delay the computation of the [`detail`](#CompletionItem.detail)
 * and [`documentation`](#CompletionItem.documentation) properties to the `completionItem/resolve`
 * request. However, properties that are needed for the initial sorting and filtering, like `sortText`,
 * `filterText`, `insertText`, and `textEdit`, must not be changed during resolve.
 */
var CompletionRequest;
(function (CompletionRequest) {
    CompletionRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/completion');
})(CompletionRequest = exports.CompletionRequest || (exports.CompletionRequest = {}));
/**
 * Request to resolve additional information for a given completion item.The request's
 * parameter is of type [CompletionItem](#CompletionItem) the response
 * is of type [CompletionItem](#CompletionItem) or a Thenable that resolves to such.
 */
var CompletionResolveRequest;
(function (CompletionResolveRequest) {
    CompletionResolveRequest.type = new vscode_jsonrpc_1.RequestType('completionItem/resolve');
})(CompletionResolveRequest = exports.CompletionResolveRequest || (exports.CompletionResolveRequest = {}));
//---- Hover Support -------------------------------
/**
 * Request to request hover information at a given text document position. The request's
 * parameter is of type [TextDocumentPosition](#TextDocumentPosition) the response is of
 * type [Hover](#Hover) or a Thenable that resolves to such.
 */
var HoverRequest;
(function (HoverRequest) {
    HoverRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/hover');
})(HoverRequest = exports.HoverRequest || (exports.HoverRequest = {}));
var SignatureHelpRequest;
(function (SignatureHelpRequest) {
    SignatureHelpRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/signatureHelp');
})(SignatureHelpRequest = exports.SignatureHelpRequest || (exports.SignatureHelpRequest = {}));
//---- Goto Definition -------------------------------------
/**
 * A request to resolve the definition location of a symbol at a given text
 * document position. The request's parameter is of type [TextDocumentPosition]
 * (#TextDocumentPosition) the response is of type [Definition](#Definition) or a
 * Thenable that resolves to such.
 */
var DefinitionRequest;
(function (DefinitionRequest) {
    DefinitionRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/definition');
})(DefinitionRequest = exports.DefinitionRequest || (exports.DefinitionRequest = {}));
/**
 * A request to resolve project-wide references for the symbol denoted
 * by the given text document position. The request's parameter is of
 * type [ReferenceParams](#ReferenceParams) the response is of type
 * [Location[]](#Location) or a Thenable that resolves to such.
 */
var ReferencesRequest;
(function (ReferencesRequest) {
    ReferencesRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/references');
})(ReferencesRequest = exports.ReferencesRequest || (exports.ReferencesRequest = {}));
//---- Document Highlight ----------------------------------
/**
 * Request to resolve a [DocumentHighlight](#DocumentHighlight) for a given
 * text document position. The request's parameter is of type [TextDocumentPosition]
 * (#TextDocumentPosition) the request response is of type [DocumentHighlight[]]
 * (#DocumentHighlight) or a Thenable that resolves to such.
 */
var DocumentHighlightRequest;
(function (DocumentHighlightRequest) {
    DocumentHighlightRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/documentHighlight');
})(DocumentHighlightRequest = exports.DocumentHighlightRequest || (exports.DocumentHighlightRequest = {}));
//---- Document Symbol Provider ---------------------------
/**
 * A request to list all symbols found in a given text document. The request's
 * parameter is of type [TextDocumentIdentifier](#TextDocumentIdentifier) the
 * response is of type [SymbolInformation[]](#SymbolInformation) or a Thenable
 * that resolves to such.
 */
var DocumentSymbolRequest;
(function (DocumentSymbolRequest) {
    DocumentSymbolRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/documentSymbol');
})(DocumentSymbolRequest = exports.DocumentSymbolRequest || (exports.DocumentSymbolRequest = {}));
//---- Workspace Symbol Provider ---------------------------
/**
 * A request to list project-wide symbols matching the query string given
 * by the [WorkspaceSymbolParams](#WorkspaceSymbolParams). The response is
 * of type [SymbolInformation[]](#SymbolInformation) or a Thenable that
 * resolves to such.
 */
var WorkspaceSymbolRequest;
(function (WorkspaceSymbolRequest) {
    WorkspaceSymbolRequest.type = new vscode_jsonrpc_1.RequestType('workspace/symbol');
})(WorkspaceSymbolRequest = exports.WorkspaceSymbolRequest || (exports.WorkspaceSymbolRequest = {}));
/**
 * A request to provide commands for the given text document and range.
 */
var CodeActionRequest;
(function (CodeActionRequest) {
    CodeActionRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/codeAction');
})(CodeActionRequest = exports.CodeActionRequest || (exports.CodeActionRequest = {}));
/**
 * A request to provide code lens for the given text document.
 */
var CodeLensRequest;
(function (CodeLensRequest) {
    CodeLensRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/codeLens');
})(CodeLensRequest = exports.CodeLensRequest || (exports.CodeLensRequest = {}));
/**
 * A request to resolve a command for a given code lens.
 */
var CodeLensResolveRequest;
(function (CodeLensResolveRequest) {
    CodeLensResolveRequest.type = new vscode_jsonrpc_1.RequestType('codeLens/resolve');
})(CodeLensResolveRequest = exports.CodeLensResolveRequest || (exports.CodeLensResolveRequest = {}));
/**
 * A request to to format a whole document.
 */
var DocumentFormattingRequest;
(function (DocumentFormattingRequest) {
    DocumentFormattingRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/formatting');
})(DocumentFormattingRequest = exports.DocumentFormattingRequest || (exports.DocumentFormattingRequest = {}));
/**
 * A request to to format a range in a document.
 */
var DocumentRangeFormattingRequest;
(function (DocumentRangeFormattingRequest) {
    DocumentRangeFormattingRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/rangeFormatting');
})(DocumentRangeFormattingRequest = exports.DocumentRangeFormattingRequest || (exports.DocumentRangeFormattingRequest = {}));
/**
 * A request to format a document on type.
 */
var DocumentOnTypeFormattingRequest;
(function (DocumentOnTypeFormattingRequest) {
    DocumentOnTypeFormattingRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/onTypeFormatting');
})(DocumentOnTypeFormattingRequest = exports.DocumentOnTypeFormattingRequest || (exports.DocumentOnTypeFormattingRequest = {}));
/**
 * A request to rename a symbol.
 */
var RenameRequest;
(function (RenameRequest) {
    RenameRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/rename');
})(RenameRequest = exports.RenameRequest || (exports.RenameRequest = {}));
/**
 * A request to test and perform the setup necessary for a rename.
 */
var PrepareRenameRequest;
(function (PrepareRenameRequest) {
    PrepareRenameRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/prepareRename');
})(PrepareRenameRequest = exports.PrepareRenameRequest || (exports.PrepareRenameRequest = {}));
/**
 * A request to provide document links
 */
var DocumentLinkRequest;
(function (DocumentLinkRequest) {
    DocumentLinkRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/documentLink');
})(DocumentLinkRequest = exports.DocumentLinkRequest || (exports.DocumentLinkRequest = {}));
/**
 * Request to resolve additional information for a given document link. The request's
 * parameter is of type [DocumentLink](#DocumentLink) the response
 * is of type [DocumentLink](#DocumentLink) or a Thenable that resolves to such.
 */
var DocumentLinkResolveRequest;
(function (DocumentLinkResolveRequest) {
    DocumentLinkResolveRequest.type = new vscode_jsonrpc_1.RequestType('documentLink/resolve');
})(DocumentLinkResolveRequest = exports.DocumentLinkResolveRequest || (exports.DocumentLinkResolveRequest = {}));
/**
 * A request send from the client to the server to execute a command. The request might return
 * a workspace edit which the client will apply to the workspace.
 */
var ExecuteCommandRequest;
(function (ExecuteCommandRequest) {
    ExecuteCommandRequest.type = new vscode_jsonrpc_1.RequestType('workspace/executeCommand');
})(ExecuteCommandRequest = exports.ExecuteCommandRequest || (exports.ExecuteCommandRequest = {}));
/**
 * A request sent from the server to the client to modified certain resources.
 */
var ApplyWorkspaceEditRequest;
(function (ApplyWorkspaceEditRequest) {
    ApplyWorkspaceEditRequest.type = new vscode_jsonrpc_1.RequestType('workspace/applyEdit');
})(ApplyWorkspaceEditRequest = exports.ApplyWorkspaceEditRequest || (exports.ApplyWorkspaceEditRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.typeDefinition.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.typeDefinition.js ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * A request to resolve the type definition locations of a symbol at a given text
 * document position. The request's parameter is of type [TextDocumentPositioParams]
 * (#TextDocumentPositionParams) the response is of type [Definition](#Definition) or a
 * Thenable that resolves to such.
 */
var TypeDefinitionRequest;
(function (TypeDefinitionRequest) {
    TypeDefinitionRequest.type = new vscode_jsonrpc_1.RequestType('textDocument/typeDefinition');
})(TypeDefinitionRequest = exports.TypeDefinitionRequest || (exports.TypeDefinitionRequest = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/protocol.workspaceFolders.js":
/*!***************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/protocol.workspaceFolders.js ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js");
/**
 * The `workspace/workspaceFolders` is sent from the server to the client to fetch the open workspace folders.
 */
var WorkspaceFoldersRequest;
(function (WorkspaceFoldersRequest) {
    WorkspaceFoldersRequest.type = new vscode_jsonrpc_1.RequestType0('workspace/workspaceFolders');
})(WorkspaceFoldersRequest = exports.WorkspaceFoldersRequest || (exports.WorkspaceFoldersRequest = {}));
/**
 * The `workspace/didChangeWorkspaceFolders` notification is sent from the client to the server when the workspace
 * folder configuration changes.
 */
var DidChangeWorkspaceFoldersNotification;
(function (DidChangeWorkspaceFoldersNotification) {
    DidChangeWorkspaceFoldersNotification.type = new vscode_jsonrpc_1.NotificationType('workspace/didChangeWorkspaceFolders');
})(DidChangeWorkspaceFoldersNotification = exports.DidChangeWorkspaceFoldersNotification || (exports.DidChangeWorkspaceFoldersNotification = {}));


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/lib/utils/is.js":
/*!**********************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/lib/utils/is.js ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
function boolean(value) {
    return value === true || value === false;
}
exports.boolean = boolean;
function string(value) {
    return typeof value === 'string' || value instanceof String;
}
exports.string = string;
function number(value) {
    return typeof value === 'number' || value instanceof Number;
}
exports.number = number;
function error(value) {
    return value instanceof Error;
}
exports.error = error;
function func(value) {
    return typeof value === 'function';
}
exports.func = func;
function array(value) {
    return Array.isArray(value);
}
exports.array = array;
function stringArray(value) {
    return array(value) && value.every(elem => string(elem));
}
exports.stringArray = stringArray;
function typedArray(value, check) {
    return Array.isArray(value) && value.every(check);
}
exports.typedArray = typedArray;
function thenable(value) {
    return value && func(value.then);
}
exports.thenable = thenable;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/cancellation.js":
/*!******************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/cancellation.js ***!
  \******************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

Object.defineProperty(exports, "__esModule", { value: true });
const events_1 = __webpack_require__(/*! ./events */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js");
const Is = __webpack_require__(/*! ./is */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js");
var CancellationToken;
(function (CancellationToken) {
    CancellationToken.None = Object.freeze({
        isCancellationRequested: false,
        onCancellationRequested: events_1.Event.None
    });
    CancellationToken.Cancelled = Object.freeze({
        isCancellationRequested: true,
        onCancellationRequested: events_1.Event.None
    });
    function is(value) {
        let candidate = value;
        return candidate && (candidate === CancellationToken.None
            || candidate === CancellationToken.Cancelled
            || (Is.boolean(candidate.isCancellationRequested) && !!candidate.onCancellationRequested));
    }
    CancellationToken.is = is;
})(CancellationToken = exports.CancellationToken || (exports.CancellationToken = {}));
const shortcutEvent = Object.freeze(function (callback, context) {
    let handle = setTimeout(callback.bind(context), 0);
    return { dispose() { clearTimeout(handle); } };
});
class MutableToken {
    constructor() {
        this._isCancelled = false;
    }
    cancel() {
        if (!this._isCancelled) {
            this._isCancelled = true;
            if (this._emitter) {
                this._emitter.fire(undefined);
                this._emitter = undefined;
            }
        }
    }
    get isCancellationRequested() {
        return this._isCancelled;
    }
    get onCancellationRequested() {
        if (this._isCancelled) {
            return shortcutEvent;
        }
        if (!this._emitter) {
            this._emitter = new events_1.Emitter();
        }
        return this._emitter.event;
    }
}
class CancellationTokenSource {
    get token() {
        if (!this._token) {
            // be lazy and create the token only when
            // actually needed
            this._token = new MutableToken();
        }
        return this._token;
    }
    cancel() {
        if (!this._token) {
            // save an object by returning the default
            // cancelled token when cancellation happens
            // before someone asks for the token
            this._token = CancellationToken.Cancelled;
        }
        else {
            this._token.cancel();
        }
    }
    dispose() {
        this.cancel();
    }
}
exports.CancellationTokenSource = CancellationTokenSource;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js":
/*!************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
var Disposable;
(function (Disposable) {
    function create(func) {
        return {
            dispose: func
        };
    }
    Disposable.create = create;
})(Disposable = exports.Disposable || (exports.Disposable = {}));
var Event;
(function (Event) {
    const _disposable = { dispose() { } };
    Event.None = function () { return _disposable; };
})(Event = exports.Event || (exports.Event = {}));
class CallbackList {
    add(callback, context = null, bucket) {
        if (!this._callbacks) {
            this._callbacks = [];
            this._contexts = [];
        }
        this._callbacks.push(callback);
        this._contexts.push(context);
        if (Array.isArray(bucket)) {
            bucket.push({ dispose: () => this.remove(callback, context) });
        }
    }
    remove(callback, context = null) {
        if (!this._callbacks) {
            return;
        }
        var foundCallbackWithDifferentContext = false;
        for (var i = 0, len = this._callbacks.length; i < len; i++) {
            if (this._callbacks[i] === callback) {
                if (this._contexts[i] === context) {
                    // callback & context match => remove it
                    this._callbacks.splice(i, 1);
                    this._contexts.splice(i, 1);
                    return;
                }
                else {
                    foundCallbackWithDifferentContext = true;
                }
            }
        }
        if (foundCallbackWithDifferentContext) {
            throw new Error('When adding a listener with a context, you should remove it with the same context');
        }
    }
    invoke(...args) {
        if (!this._callbacks) {
            return [];
        }
        var ret = [], callbacks = this._callbacks.slice(0), contexts = this._contexts.slice(0);
        for (var i = 0, len = callbacks.length; i < len; i++) {
            try {
                ret.push(callbacks[i].apply(contexts[i], args));
            }
            catch (e) {
                console.error(e);
            }
        }
        return ret;
    }
    isEmpty() {
        return !this._callbacks || this._callbacks.length === 0;
    }
    dispose() {
        this._callbacks = undefined;
        this._contexts = undefined;
    }
}
class Emitter {
    constructor(_options) {
        this._options = _options;
    }
    /**
     * For the public to allow to subscribe
     * to events from this Emitter
     */
    get event() {
        if (!this._event) {
            this._event = (listener, thisArgs, disposables) => {
                if (!this._callbacks) {
                    this._callbacks = new CallbackList();
                }
                if (this._options && this._options.onFirstListenerAdd && this._callbacks.isEmpty()) {
                    this._options.onFirstListenerAdd(this);
                }
                this._callbacks.add(listener, thisArgs);
                let result;
                result = {
                    dispose: () => {
                        this._callbacks.remove(listener, thisArgs);
                        result.dispose = Emitter._noop;
                        if (this._options && this._options.onLastListenerRemove && this._callbacks.isEmpty()) {
                            this._options.onLastListenerRemove(this);
                        }
                    }
                };
                if (Array.isArray(disposables)) {
                    disposables.push(result);
                }
                return result;
            };
        }
        return this._event;
    }
    /**
     * To be kept private to fire an event to
     * subscribers
     */
    fire(event) {
        if (this._callbacks) {
            this._callbacks.invoke.call(this._callbacks, event);
        }
    }
    dispose() {
        if (this._callbacks) {
            this._callbacks.dispose();
            this._callbacks = undefined;
        }
    }
}
Emitter._noop = function () { };
exports.Emitter = Emitter;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js":
/*!********************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js ***!
  \********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
function boolean(value) {
    return value === true || value === false;
}
exports.boolean = boolean;
function string(value) {
    return typeof value === 'string' || value instanceof String;
}
exports.string = string;
function number(value) {
    return typeof value === 'number' || value instanceof Number;
}
exports.number = number;
function error(value) {
    return value instanceof Error;
}
exports.error = error;
function func(value) {
    return typeof value === 'function';
}
exports.func = func;
function array(value) {
    return Array.isArray(value);
}
exports.array = array;
function stringArray(value) {
    return array(value) && value.every(elem => string(elem));
}
exports.stringArray = stringArray;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/linkedMap.js":
/*!***************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/linkedMap.js ***!
  \***************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/
Object.defineProperty(exports, "__esModule", { value: true });
var Touch;
(function (Touch) {
    Touch.None = 0;
    Touch.First = 1;
    Touch.Last = 2;
})(Touch = exports.Touch || (exports.Touch = {}));
class LinkedMap {
    constructor() {
        this._map = new Map();
        this._head = undefined;
        this._tail = undefined;
        this._size = 0;
    }
    clear() {
        this._map.clear();
        this._head = undefined;
        this._tail = undefined;
        this._size = 0;
    }
    isEmpty() {
        return !this._head && !this._tail;
    }
    get size() {
        return this._size;
    }
    has(key) {
        return this._map.has(key);
    }
    get(key) {
        const item = this._map.get(key);
        if (!item) {
            return undefined;
        }
        return item.value;
    }
    set(key, value, touch = Touch.None) {
        let item = this._map.get(key);
        if (item) {
            item.value = value;
            if (touch !== Touch.None) {
                this.touch(item, touch);
            }
        }
        else {
            item = { key, value, next: undefined, previous: undefined };
            switch (touch) {
                case Touch.None:
                    this.addItemLast(item);
                    break;
                case Touch.First:
                    this.addItemFirst(item);
                    break;
                case Touch.Last:
                    this.addItemLast(item);
                    break;
                default:
                    this.addItemLast(item);
                    break;
            }
            this._map.set(key, item);
            this._size++;
        }
    }
    delete(key) {
        const item = this._map.get(key);
        if (!item) {
            return false;
        }
        this._map.delete(key);
        this.removeItem(item);
        this._size--;
        return true;
    }
    shift() {
        if (!this._head && !this._tail) {
            return undefined;
        }
        if (!this._head || !this._tail) {
            throw new Error('Invalid list');
        }
        const item = this._head;
        this._map.delete(item.key);
        this.removeItem(item);
        this._size--;
        return item.value;
    }
    forEach(callbackfn, thisArg) {
        let current = this._head;
        while (current) {
            if (thisArg) {
                callbackfn.bind(thisArg)(current.value, current.key, this);
            }
            else {
                callbackfn(current.value, current.key, this);
            }
            current = current.next;
        }
    }
    forEachReverse(callbackfn, thisArg) {
        let current = this._tail;
        while (current) {
            if (thisArg) {
                callbackfn.bind(thisArg)(current.value, current.key, this);
            }
            else {
                callbackfn(current.value, current.key, this);
            }
            current = current.previous;
        }
    }
    values() {
        let result = [];
        let current = this._head;
        while (current) {
            result.push(current.value);
            current = current.next;
        }
        return result;
    }
    keys() {
        let result = [];
        let current = this._head;
        while (current) {
            result.push(current.key);
            current = current.next;
        }
        return result;
    }
    /* JSON RPC run on es5 which has no Symbol.iterator
    public keys(): IterableIterator<K> {
        let current = this._head;
        let iterator: IterableIterator<K> = {
            [Symbol.iterator]() {
                return iterator;
            },
            next():IteratorResult<K> {
                if (current) {
                    let result = { value: current.key, done: false };
                    current = current.next;
                    return result;
                } else {
                    return { value: undefined, done: true };
                }
            }
        };
        return iterator;
    }

    public values(): IterableIterator<V> {
        let current = this._head;
        let iterator: IterableIterator<V> = {
            [Symbol.iterator]() {
                return iterator;
            },
            next():IteratorResult<V> {
                if (current) {
                    let result = { value: current.value, done: false };
                    current = current.next;
                    return result;
                } else {
                    return { value: undefined, done: true };
                }
            }
        };
        return iterator;
    }
    */
    addItemFirst(item) {
        // First time Insert
        if (!this._head && !this._tail) {
            this._tail = item;
        }
        else if (!this._head) {
            throw new Error('Invalid list');
        }
        else {
            item.next = this._head;
            this._head.previous = item;
        }
        this._head = item;
    }
    addItemLast(item) {
        // First time Insert
        if (!this._head && !this._tail) {
            this._head = item;
        }
        else if (!this._tail) {
            throw new Error('Invalid list');
        }
        else {
            item.previous = this._tail;
            this._tail.next = item;
        }
        this._tail = item;
    }
    removeItem(item) {
        if (item === this._head && item === this._tail) {
            this._head = undefined;
            this._tail = undefined;
        }
        else if (item === this._head) {
            this._head = item.next;
        }
        else if (item === this._tail) {
            this._tail = item.previous;
        }
        else {
            const next = item.next;
            const previous = item.previous;
            if (!next || !previous) {
                throw new Error('Invalid list');
            }
            next.previous = previous;
            previous.next = next;
        }
    }
    touch(item, touch) {
        if (!this._head || !this._tail) {
            throw new Error('Invalid list');
        }
        if ((touch !== Touch.First && touch !== Touch.Last)) {
            return;
        }
        if (touch === Touch.First) {
            if (item === this._head) {
                return;
            }
            const next = item.next;
            const previous = item.previous;
            // Unlink the item
            if (item === this._tail) {
                // previous must be defined since item was not head but is tail
                // So there are more than on item in the map
                previous.next = undefined;
                this._tail = previous;
            }
            else {
                // Both next and previous are not undefined since item was neither head nor tail.
                next.previous = previous;
                previous.next = next;
            }
            // Insert the node at head
            item.previous = undefined;
            item.next = this._head;
            this._head.previous = item;
            this._head = item;
        }
        else if (touch === Touch.Last) {
            if (item === this._tail) {
                return;
            }
            const next = item.next;
            const previous = item.previous;
            // Unlink the item.
            if (item === this._head) {
                // next must be defined since item was not tail but is head
                // So there are more than on item in the map
                next.previous = undefined;
                this._head = next;
            }
            else {
                // Both next and previous are not undefined since item was neither head nor tail.
                next.previous = previous;
                previous.next = next;
            }
            item.next = undefined;
            item.previous = this._tail;
            this._tail.next = item;
            this._tail = item;
        }
    }
}
exports.LinkedMap = LinkedMap;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js":
/*!**********************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/main.js ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(setImmediate) {/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
/// <reference path="./thenable.ts" />

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
const Is = __webpack_require__(/*! ./is */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js");
const messages_1 = __webpack_require__(/*! ./messages */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messages.js");
exports.RequestType = messages_1.RequestType;
exports.RequestType0 = messages_1.RequestType0;
exports.RequestType1 = messages_1.RequestType1;
exports.RequestType2 = messages_1.RequestType2;
exports.RequestType3 = messages_1.RequestType3;
exports.RequestType4 = messages_1.RequestType4;
exports.RequestType5 = messages_1.RequestType5;
exports.RequestType6 = messages_1.RequestType6;
exports.RequestType7 = messages_1.RequestType7;
exports.RequestType8 = messages_1.RequestType8;
exports.RequestType9 = messages_1.RequestType9;
exports.ResponseError = messages_1.ResponseError;
exports.ErrorCodes = messages_1.ErrorCodes;
exports.NotificationType = messages_1.NotificationType;
exports.NotificationType0 = messages_1.NotificationType0;
exports.NotificationType1 = messages_1.NotificationType1;
exports.NotificationType2 = messages_1.NotificationType2;
exports.NotificationType3 = messages_1.NotificationType3;
exports.NotificationType4 = messages_1.NotificationType4;
exports.NotificationType5 = messages_1.NotificationType5;
exports.NotificationType6 = messages_1.NotificationType6;
exports.NotificationType7 = messages_1.NotificationType7;
exports.NotificationType8 = messages_1.NotificationType8;
exports.NotificationType9 = messages_1.NotificationType9;
const messageReader_1 = __webpack_require__(/*! ./messageReader */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageReader.js");
exports.MessageReader = messageReader_1.MessageReader;
exports.StreamMessageReader = messageReader_1.StreamMessageReader;
exports.IPCMessageReader = messageReader_1.IPCMessageReader;
exports.SocketMessageReader = messageReader_1.SocketMessageReader;
const messageWriter_1 = __webpack_require__(/*! ./messageWriter */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageWriter.js");
exports.MessageWriter = messageWriter_1.MessageWriter;
exports.StreamMessageWriter = messageWriter_1.StreamMessageWriter;
exports.IPCMessageWriter = messageWriter_1.IPCMessageWriter;
exports.SocketMessageWriter = messageWriter_1.SocketMessageWriter;
const events_1 = __webpack_require__(/*! ./events */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js");
exports.Disposable = events_1.Disposable;
exports.Event = events_1.Event;
exports.Emitter = events_1.Emitter;
const cancellation_1 = __webpack_require__(/*! ./cancellation */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/cancellation.js");
exports.CancellationTokenSource = cancellation_1.CancellationTokenSource;
exports.CancellationToken = cancellation_1.CancellationToken;
const linkedMap_1 = __webpack_require__(/*! ./linkedMap */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/linkedMap.js");
__export(__webpack_require__(/*! ./pipeSupport */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/pipeSupport.js"));
__export(__webpack_require__(/*! ./socketSupport */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/socketSupport.js"));
var CancelNotification;
(function (CancelNotification) {
    CancelNotification.type = new messages_1.NotificationType('$/cancelRequest');
})(CancelNotification || (CancelNotification = {}));
exports.NullLogger = Object.freeze({
    error: () => { },
    warn: () => { },
    info: () => { },
    log: () => { }
});
var Trace;
(function (Trace) {
    Trace[Trace["Off"] = 0] = "Off";
    Trace[Trace["Messages"] = 1] = "Messages";
    Trace[Trace["Verbose"] = 2] = "Verbose";
})(Trace = exports.Trace || (exports.Trace = {}));
(function (Trace) {
    function fromString(value) {
        value = value.toLowerCase();
        switch (value) {
            case 'off':
                return Trace.Off;
            case 'messages':
                return Trace.Messages;
            case 'verbose':
                return Trace.Verbose;
            default:
                return Trace.Off;
        }
    }
    Trace.fromString = fromString;
    function toString(value) {
        switch (value) {
            case Trace.Off:
                return 'off';
            case Trace.Messages:
                return 'messages';
            case Trace.Verbose:
                return 'verbose';
            default:
                return 'off';
        }
    }
    Trace.toString = toString;
})(Trace = exports.Trace || (exports.Trace = {}));
var TraceFormat;
(function (TraceFormat) {
    TraceFormat["Text"] = "text";
    TraceFormat["JSON"] = "json";
})(TraceFormat = exports.TraceFormat || (exports.TraceFormat = {}));
(function (TraceFormat) {
    function fromString(value) {
        value = value.toLowerCase();
        if (value === 'json') {
            return TraceFormat.JSON;
        }
        else {
            return TraceFormat.Text;
        }
    }
    TraceFormat.fromString = fromString;
})(TraceFormat = exports.TraceFormat || (exports.TraceFormat = {}));
var SetTraceNotification;
(function (SetTraceNotification) {
    SetTraceNotification.type = new messages_1.NotificationType('$/setTraceNotification');
})(SetTraceNotification = exports.SetTraceNotification || (exports.SetTraceNotification = {}));
var LogTraceNotification;
(function (LogTraceNotification) {
    LogTraceNotification.type = new messages_1.NotificationType('$/logTraceNotification');
})(LogTraceNotification = exports.LogTraceNotification || (exports.LogTraceNotification = {}));
var ConnectionErrors;
(function (ConnectionErrors) {
    /**
     * The connection is closed.
     */
    ConnectionErrors[ConnectionErrors["Closed"] = 1] = "Closed";
    /**
     * The connection got disposed.
     */
    ConnectionErrors[ConnectionErrors["Disposed"] = 2] = "Disposed";
    /**
     * The connection is already in listening mode.
     */
    ConnectionErrors[ConnectionErrors["AlreadyListening"] = 3] = "AlreadyListening";
})(ConnectionErrors = exports.ConnectionErrors || (exports.ConnectionErrors = {}));
class ConnectionError extends Error {
    constructor(code, message) {
        super(message);
        this.code = code;
        Object.setPrototypeOf(this, ConnectionError.prototype);
    }
}
exports.ConnectionError = ConnectionError;
var ConnectionStrategy;
(function (ConnectionStrategy) {
    function is(value) {
        let candidate = value;
        return candidate && Is.func(candidate.cancelUndispatched);
    }
    ConnectionStrategy.is = is;
})(ConnectionStrategy = exports.ConnectionStrategy || (exports.ConnectionStrategy = {}));
var ConnectionState;
(function (ConnectionState) {
    ConnectionState[ConnectionState["New"] = 1] = "New";
    ConnectionState[ConnectionState["Listening"] = 2] = "Listening";
    ConnectionState[ConnectionState["Closed"] = 3] = "Closed";
    ConnectionState[ConnectionState["Disposed"] = 4] = "Disposed";
})(ConnectionState || (ConnectionState = {}));
function _createMessageConnection(messageReader, messageWriter, logger, strategy) {
    let sequenceNumber = 0;
    let notificationSquenceNumber = 0;
    let unknownResponseSquenceNumber = 0;
    const version = '2.0';
    let starRequestHandler = undefined;
    let requestHandlers = Object.create(null);
    let starNotificationHandler = undefined;
    let notificationHandlers = Object.create(null);
    let timer;
    let messageQueue = new linkedMap_1.LinkedMap();
    let responsePromises = Object.create(null);
    let requestTokens = Object.create(null);
    let trace = Trace.Off;
    let traceFormat = TraceFormat.Text;
    let tracer;
    let state = ConnectionState.New;
    let errorEmitter = new events_1.Emitter();
    let closeEmitter = new events_1.Emitter();
    let unhandledNotificationEmitter = new events_1.Emitter();
    let disposeEmitter = new events_1.Emitter();
    function createRequestQueueKey(id) {
        return 'req-' + id.toString();
    }
    function createResponseQueueKey(id) {
        if (id === null) {
            return 'res-unknown-' + (++unknownResponseSquenceNumber).toString();
        }
        else {
            return 'res-' + id.toString();
        }
    }
    function createNotificationQueueKey() {
        return 'not-' + (++notificationSquenceNumber).toString();
    }
    function addMessageToQueue(queue, message) {
        if (messages_1.isRequestMessage(message)) {
            queue.set(createRequestQueueKey(message.id), message);
        }
        else if (messages_1.isResponseMessage(message)) {
            queue.set(createResponseQueueKey(message.id), message);
        }
        else {
            queue.set(createNotificationQueueKey(), message);
        }
    }
    function cancelUndispatched(_message) {
        return undefined;
    }
    function isListening() {
        return state === ConnectionState.Listening;
    }
    function isClosed() {
        return state === ConnectionState.Closed;
    }
    function isDisposed() {
        return state === ConnectionState.Disposed;
    }
    function closeHandler() {
        if (state === ConnectionState.New || state === ConnectionState.Listening) {
            state = ConnectionState.Closed;
            closeEmitter.fire(undefined);
        }
        // If the connection is disposed don't sent close events.
    }
    ;
    function readErrorHandler(error) {
        errorEmitter.fire([error, undefined, undefined]);
    }
    function writeErrorHandler(data) {
        errorEmitter.fire(data);
    }
    messageReader.onClose(closeHandler);
    messageReader.onError(readErrorHandler);
    messageWriter.onClose(closeHandler);
    messageWriter.onError(writeErrorHandler);
    function triggerMessageQueue() {
        if (timer || messageQueue.size === 0) {
            return;
        }
        timer = setImmediate(() => {
            timer = undefined;
            processMessageQueue();
        });
    }
    function processMessageQueue() {
        if (messageQueue.size === 0) {
            return;
        }
        let message = messageQueue.shift();
        try {
            if (messages_1.isRequestMessage(message)) {
                handleRequest(message);
            }
            else if (messages_1.isNotificationMessage(message)) {
                handleNotification(message);
            }
            else if (messages_1.isResponseMessage(message)) {
                handleResponse(message);
            }
            else {
                handleInvalidMessage(message);
            }
        }
        finally {
            triggerMessageQueue();
        }
    }
    let callback = (message) => {
        try {
            // We have received a cancellation message. Check if the message is still in the queue
            // and cancel it if allowed to do so.
            if (messages_1.isNotificationMessage(message) && message.method === CancelNotification.type.method) {
                let key = createRequestQueueKey(message.params.id);
                let toCancel = messageQueue.get(key);
                if (messages_1.isRequestMessage(toCancel)) {
                    let response = strategy && strategy.cancelUndispatched ? strategy.cancelUndispatched(toCancel, cancelUndispatched) : cancelUndispatched(toCancel);
                    if (response && (response.error !== void 0 || response.result !== void 0)) {
                        messageQueue.delete(key);
                        response.id = toCancel.id;
                        traceSendingResponse(response, message.method, Date.now());
                        messageWriter.write(response);
                        return;
                    }
                }
            }
            addMessageToQueue(messageQueue, message);
        }
        finally {
            triggerMessageQueue();
        }
    };
    function handleRequest(requestMessage) {
        if (isDisposed()) {
            // we return here silently since we fired an event when the
            // connection got disposed.
            return;
        }
        function reply(resultOrError, method, startTime) {
            let message = {
                jsonrpc: version,
                id: requestMessage.id
            };
            if (resultOrError instanceof messages_1.ResponseError) {
                message.error = resultOrError.toJson();
            }
            else {
                message.result = resultOrError === void 0 ? null : resultOrError;
            }
            traceSendingResponse(message, method, startTime);
            messageWriter.write(message);
        }
        function replyError(error, method, startTime) {
            let message = {
                jsonrpc: version,
                id: requestMessage.id,
                error: error.toJson()
            };
            traceSendingResponse(message, method, startTime);
            messageWriter.write(message);
        }
        function replySuccess(result, method, startTime) {
            // The JSON RPC defines that a response must either have a result or an error
            // So we can't treat undefined as a valid response result.
            if (result === void 0) {
                result = null;
            }
            let message = {
                jsonrpc: version,
                id: requestMessage.id,
                result: result
            };
            traceSendingResponse(message, method, startTime);
            messageWriter.write(message);
        }
        traceReceivedRequest(requestMessage);
        let element = requestHandlers[requestMessage.method];
        let type;
        let requestHandler;
        if (element) {
            type = element.type;
            requestHandler = element.handler;
        }
        let startTime = Date.now();
        if (requestHandler || starRequestHandler) {
            let cancellationSource = new cancellation_1.CancellationTokenSource();
            let tokenKey = String(requestMessage.id);
            requestTokens[tokenKey] = cancellationSource;
            try {
                let handlerResult;
                if (requestMessage.params === void 0 || (type !== void 0 && type.numberOfParams === 0)) {
                    handlerResult = requestHandler
                        ? requestHandler(cancellationSource.token)
                        : starRequestHandler(requestMessage.method, cancellationSource.token);
                }
                else if (Is.array(requestMessage.params) && (type === void 0 || type.numberOfParams > 1)) {
                    handlerResult = requestHandler
                        ? requestHandler(...requestMessage.params, cancellationSource.token)
                        : starRequestHandler(requestMessage.method, ...requestMessage.params, cancellationSource.token);
                }
                else {
                    handlerResult = requestHandler
                        ? requestHandler(requestMessage.params, cancellationSource.token)
                        : starRequestHandler(requestMessage.method, requestMessage.params, cancellationSource.token);
                }
                let promise = handlerResult;
                if (!handlerResult) {
                    delete requestTokens[tokenKey];
                    replySuccess(handlerResult, requestMessage.method, startTime);
                }
                else if (promise.then) {
                    promise.then((resultOrError) => {
                        delete requestTokens[tokenKey];
                        reply(resultOrError, requestMessage.method, startTime);
                    }, error => {
                        delete requestTokens[tokenKey];
                        if (error instanceof messages_1.ResponseError) {
                            replyError(error, requestMessage.method, startTime);
                        }
                        else if (error && Is.string(error.message)) {
                            replyError(new messages_1.ResponseError(messages_1.ErrorCodes.InternalError, `Request ${requestMessage.method} failed with message: ${error.message}`), requestMessage.method, startTime);
                        }
                        else {
                            replyError(new messages_1.ResponseError(messages_1.ErrorCodes.InternalError, `Request ${requestMessage.method} failed unexpectedly without providing any details.`), requestMessage.method, startTime);
                        }
                    });
                }
                else {
                    delete requestTokens[tokenKey];
                    reply(handlerResult, requestMessage.method, startTime);
                }
            }
            catch (error) {
                delete requestTokens[tokenKey];
                if (error instanceof messages_1.ResponseError) {
                    reply(error, requestMessage.method, startTime);
                }
                else if (error && Is.string(error.message)) {
                    replyError(new messages_1.ResponseError(messages_1.ErrorCodes.InternalError, `Request ${requestMessage.method} failed with message: ${error.message}`), requestMessage.method, startTime);
                }
                else {
                    replyError(new messages_1.ResponseError(messages_1.ErrorCodes.InternalError, `Request ${requestMessage.method} failed unexpectedly without providing any details.`), requestMessage.method, startTime);
                }
            }
        }
        else {
            replyError(new messages_1.ResponseError(messages_1.ErrorCodes.MethodNotFound, `Unhandled method ${requestMessage.method}`), requestMessage.method, startTime);
        }
    }
    function handleResponse(responseMessage) {
        if (isDisposed()) {
            // See handle request.
            return;
        }
        if (responseMessage.id === null) {
            if (responseMessage.error) {
                logger.error(`Received response message without id: Error is: \n${JSON.stringify(responseMessage.error, undefined, 4)}`);
            }
            else {
                logger.error(`Received response message without id. No further error information provided.`);
            }
        }
        else {
            let key = String(responseMessage.id);
            let responsePromise = responsePromises[key];
            traceReceivedResponse(responseMessage, responsePromise);
            if (responsePromise) {
                delete responsePromises[key];
                try {
                    if (responseMessage.error) {
                        let error = responseMessage.error;
                        responsePromise.reject(new messages_1.ResponseError(error.code, error.message, error.data));
                    }
                    else if (responseMessage.result !== void 0) {
                        responsePromise.resolve(responseMessage.result);
                    }
                    else {
                        throw new Error('Should never happen.');
                    }
                }
                catch (error) {
                    if (error.message) {
                        logger.error(`Response handler '${responsePromise.method}' failed with message: ${error.message}`);
                    }
                    else {
                        logger.error(`Response handler '${responsePromise.method}' failed unexpectedly.`);
                    }
                }
            }
        }
    }
    function handleNotification(message) {
        if (isDisposed()) {
            // See handle request.
            return;
        }
        let type = undefined;
        let notificationHandler;
        if (message.method === CancelNotification.type.method) {
            notificationHandler = (params) => {
                let id = params.id;
                let source = requestTokens[String(id)];
                if (source) {
                    source.cancel();
                }
            };
        }
        else {
            let element = notificationHandlers[message.method];
            if (element) {
                notificationHandler = element.handler;
                type = element.type;
            }
        }
        if (notificationHandler || starNotificationHandler) {
            try {
                traceReceivedNotification(message);
                if (message.params === void 0 || (type !== void 0 && type.numberOfParams === 0)) {
                    notificationHandler ? notificationHandler() : starNotificationHandler(message.method);
                }
                else if (Is.array(message.params) && (type === void 0 || type.numberOfParams > 1)) {
                    notificationHandler ? notificationHandler(...message.params) : starNotificationHandler(message.method, ...message.params);
                }
                else {
                    notificationHandler ? notificationHandler(message.params) : starNotificationHandler(message.method, message.params);
                }
            }
            catch (error) {
                if (error.message) {
                    logger.error(`Notification handler '${message.method}' failed with message: ${error.message}`);
                }
                else {
                    logger.error(`Notification handler '${message.method}' failed unexpectedly.`);
                }
            }
        }
        else {
            unhandledNotificationEmitter.fire(message);
        }
    }
    function handleInvalidMessage(message) {
        if (!message) {
            logger.error('Received empty message.');
            return;
        }
        logger.error(`Received message which is neither a response nor a notification message:\n${JSON.stringify(message, null, 4)}`);
        // Test whether we find an id to reject the promise
        let responseMessage = message;
        if (Is.string(responseMessage.id) || Is.number(responseMessage.id)) {
            let key = String(responseMessage.id);
            let responseHandler = responsePromises[key];
            if (responseHandler) {
                responseHandler.reject(new Error('The received response has neither a result nor an error property.'));
            }
        }
    }
    function traceSendingRequest(message) {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose && message.params) {
                data = `Params: ${JSON.stringify(message.params, null, 4)}\n\n`;
            }
            tracer.log(`Sending request '${message.method} - (${message.id})'.`, data);
        }
        else {
            logLSPMessage('send-request', message);
        }
    }
    function traceSendingNotification(message) {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose) {
                if (message.params) {
                    data = `Params: ${JSON.stringify(message.params, null, 4)}\n\n`;
                }
                else {
                    data = 'No parameters provided.\n\n';
                }
            }
            tracer.log(`Sending notification '${message.method}'.`, data);
        }
        else {
            logLSPMessage('send-notification', message);
        }
    }
    function traceSendingResponse(message, method, startTime) {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose) {
                if (message.error && message.error.data) {
                    data = `Error data: ${JSON.stringify(message.error.data, null, 4)}\n\n`;
                }
                else {
                    if (message.result) {
                        data = `Result: ${JSON.stringify(message.result, null, 4)}\n\n`;
                    }
                    else if (message.error === void 0) {
                        data = 'No result returned.\n\n';
                    }
                }
            }
            tracer.log(`Sending response '${method} - (${message.id})'. Processing request took ${Date.now() - startTime}ms`, data);
        }
        else {
            logLSPMessage('send-response', message);
        }
    }
    function traceReceivedRequest(message) {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose && message.params) {
                data = `Params: ${JSON.stringify(message.params, null, 4)}\n\n`;
            }
            tracer.log(`Received request '${message.method} - (${message.id})'.`, data);
        }
        else {
            logLSPMessage('receive-request', message);
        }
    }
    function traceReceivedNotification(message) {
        if (trace === Trace.Off || !tracer || message.method === LogTraceNotification.type.method) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose) {
                if (message.params) {
                    data = `Params: ${JSON.stringify(message.params, null, 4)}\n\n`;
                }
                else {
                    data = 'No parameters provided.\n\n';
                }
            }
            tracer.log(`Received notification '${message.method}'.`, data);
        }
        else {
            logLSPMessage('receive-notification', message);
        }
    }
    function traceReceivedResponse(message, responsePromise) {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        if (traceFormat === TraceFormat.Text) {
            let data = undefined;
            if (trace === Trace.Verbose) {
                if (message.error && message.error.data) {
                    data = `Error data: ${JSON.stringify(message.error.data, null, 4)}\n\n`;
                }
                else {
                    if (message.result) {
                        data = `Result: ${JSON.stringify(message.result, null, 4)}\n\n`;
                    }
                    else if (message.error === void 0) {
                        data = 'No result returned.\n\n';
                    }
                }
            }
            if (responsePromise) {
                let error = message.error ? ` Request failed: ${message.error.message} (${message.error.code}).` : '';
                tracer.log(`Received response '${responsePromise.method} - (${message.id})' in ${Date.now() - responsePromise.timerStart}ms.${error}`, data);
            }
            else {
                tracer.log(`Received response ${message.id} without active response promise.`, data);
            }
        }
        else {
            logLSPMessage('receive-response', message);
        }
    }
    function logLSPMessage(type, message) {
        if (!tracer || trace === Trace.Off) {
            return;
        }
        const lspMessage = {
            isLSPMessage: true,
            type,
            message,
            timestamp: Date.now()
        };
        tracer.log(lspMessage);
    }
    function throwIfClosedOrDisposed() {
        if (isClosed()) {
            throw new ConnectionError(ConnectionErrors.Closed, 'Connection is closed.');
        }
        if (isDisposed()) {
            throw new ConnectionError(ConnectionErrors.Disposed, 'Connection is disposed.');
        }
    }
    function throwIfListening() {
        if (isListening()) {
            throw new ConnectionError(ConnectionErrors.AlreadyListening, 'Connection is already listening');
        }
    }
    function throwIfNotListening() {
        if (!isListening()) {
            throw new Error('Call listen() first.');
        }
    }
    function undefinedToNull(param) {
        if (param === void 0) {
            return null;
        }
        else {
            return param;
        }
    }
    function computeMessageParams(type, params) {
        let result;
        let numberOfParams = type.numberOfParams;
        switch (numberOfParams) {
            case 0:
                result = null;
                break;
            case 1:
                result = undefinedToNull(params[0]);
                break;
            default:
                result = [];
                for (let i = 0; i < params.length && i < numberOfParams; i++) {
                    result.push(undefinedToNull(params[i]));
                }
                if (params.length < numberOfParams) {
                    for (let i = params.length; i < numberOfParams; i++) {
                        result.push(null);
                    }
                }
                break;
        }
        return result;
    }
    let connection = {
        sendNotification: (type, ...params) => {
            throwIfClosedOrDisposed();
            let method;
            let messageParams;
            if (Is.string(type)) {
                method = type;
                switch (params.length) {
                    case 0:
                        messageParams = null;
                        break;
                    case 1:
                        messageParams = params[0];
                        break;
                    default:
                        messageParams = params;
                        break;
                }
            }
            else {
                method = type.method;
                messageParams = computeMessageParams(type, params);
            }
            let notificationMessage = {
                jsonrpc: version,
                method: method,
                params: messageParams
            };
            traceSendingNotification(notificationMessage);
            messageWriter.write(notificationMessage);
        },
        onNotification: (type, handler) => {
            throwIfClosedOrDisposed();
            if (Is.func(type)) {
                starNotificationHandler = type;
            }
            else if (handler) {
                if (Is.string(type)) {
                    notificationHandlers[type] = { type: undefined, handler };
                }
                else {
                    notificationHandlers[type.method] = { type, handler };
                }
            }
        },
        sendRequest: (type, ...params) => {
            throwIfClosedOrDisposed();
            throwIfNotListening();
            let method;
            let messageParams;
            let token = undefined;
            if (Is.string(type)) {
                method = type;
                switch (params.length) {
                    case 0:
                        messageParams = null;
                        break;
                    case 1:
                        // The cancellation token is optional so it can also be undefined.
                        if (cancellation_1.CancellationToken.is(params[0])) {
                            messageParams = null;
                            token = params[0];
                        }
                        else {
                            messageParams = undefinedToNull(params[0]);
                        }
                        break;
                    default:
                        const last = params.length - 1;
                        if (cancellation_1.CancellationToken.is(params[last])) {
                            token = params[last];
                            if (params.length === 2) {
                                messageParams = undefinedToNull(params[0]);
                            }
                            else {
                                messageParams = params.slice(0, last).map(value => undefinedToNull(value));
                            }
                        }
                        else {
                            messageParams = params.map(value => undefinedToNull(value));
                        }
                        break;
                }
            }
            else {
                method = type.method;
                messageParams = computeMessageParams(type, params);
                let numberOfParams = type.numberOfParams;
                token = cancellation_1.CancellationToken.is(params[numberOfParams]) ? params[numberOfParams] : undefined;
            }
            let id = sequenceNumber++;
            let result = new Promise((resolve, reject) => {
                let requestMessage = {
                    jsonrpc: version,
                    id: id,
                    method: method,
                    params: messageParams
                };
                let responsePromise = { method: method, timerStart: Date.now(), resolve, reject };
                traceSendingRequest(requestMessage);
                try {
                    messageWriter.write(requestMessage);
                }
                catch (e) {
                    // Writing the message failed. So we need to reject the promise.
                    responsePromise.reject(new messages_1.ResponseError(messages_1.ErrorCodes.MessageWriteError, e.message ? e.message : 'Unknown reason'));
                    responsePromise = null;
                }
                if (responsePromise) {
                    responsePromises[String(id)] = responsePromise;
                }
            });
            if (token) {
                token.onCancellationRequested(() => {
                    connection.sendNotification(CancelNotification.type, { id });
                });
            }
            return result;
        },
        onRequest: (type, handler) => {
            throwIfClosedOrDisposed();
            if (Is.func(type)) {
                starRequestHandler = type;
            }
            else if (handler) {
                if (Is.string(type)) {
                    requestHandlers[type] = { type: undefined, handler };
                }
                else {
                    requestHandlers[type.method] = { type, handler };
                }
            }
        },
        trace: (_value, _tracer, sendNotificationOrTraceOptions) => {
            let _sendNotification = false;
            let _traceFormat = TraceFormat.Text;
            if (sendNotificationOrTraceOptions !== void 0) {
                if (Is.boolean(sendNotificationOrTraceOptions)) {
                    _sendNotification = sendNotificationOrTraceOptions;
                }
                else {
                    _sendNotification = sendNotificationOrTraceOptions.sendNotification || false;
                    _traceFormat = sendNotificationOrTraceOptions.traceFormat || TraceFormat.Text;
                }
            }
            trace = _value;
            traceFormat = _traceFormat;
            if (trace === Trace.Off) {
                tracer = undefined;
            }
            else {
                tracer = _tracer;
            }
            if (_sendNotification && !isClosed() && !isDisposed()) {
                connection.sendNotification(SetTraceNotification.type, { value: Trace.toString(_value) });
            }
        },
        onError: errorEmitter.event,
        onClose: closeEmitter.event,
        onUnhandledNotification: unhandledNotificationEmitter.event,
        onDispose: disposeEmitter.event,
        dispose: () => {
            if (isDisposed()) {
                return;
            }
            state = ConnectionState.Disposed;
            disposeEmitter.fire(undefined);
            let error = new Error('Connection got disposed.');
            Object.keys(responsePromises).forEach((key) => {
                responsePromises[key].reject(error);
            });
            responsePromises = Object.create(null);
            requestTokens = Object.create(null);
            messageQueue = new linkedMap_1.LinkedMap();
            // Test for backwards compatibility
            if (Is.func(messageWriter.dispose)) {
                messageWriter.dispose();
            }
            if (Is.func(messageReader.dispose)) {
                messageReader.dispose();
            }
        },
        listen: () => {
            throwIfClosedOrDisposed();
            throwIfListening();
            state = ConnectionState.Listening;
            messageReader.listen(callback);
        },
        inspect: () => {
            console.log("inspect");
        }
    };
    connection.onNotification(LogTraceNotification.type, (params) => {
        if (trace === Trace.Off || !tracer) {
            return;
        }
        tracer.log(params.message, trace === Trace.Verbose ? params.verbose : undefined);
    });
    return connection;
}
function isMessageReader(value) {
    return value.listen !== void 0 && value.read === void 0;
}
function isMessageWriter(value) {
    return value.write !== void 0 && value.end === void 0;
}
function createMessageConnection(input, output, logger, strategy) {
    if (!logger) {
        logger = exports.NullLogger;
    }
    let reader = isMessageReader(input) ? input : new messageReader_1.StreamMessageReader(input);
    let writer = isMessageWriter(output) ? output : new messageWriter_1.StreamMessageWriter(output);
    return _createMessageConnection(reader, writer, logger, strategy);
}
exports.createMessageConnection = createMessageConnection;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../../timers-browserify/main.js */ "../node_modules/timers-browserify/main.js").setImmediate))

/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageReader.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageReader.js ***!
  \*******************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(Buffer) {/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const events_1 = __webpack_require__(/*! ./events */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js");
const Is = __webpack_require__(/*! ./is */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js");
let DefaultSize = 8192;
let CR = Buffer.from('\r', 'ascii')[0];
let LF = Buffer.from('\n', 'ascii')[0];
let CRLF = '\r\n';
class MessageBuffer {
    constructor(encoding = 'utf8') {
        this.encoding = encoding;
        this.index = 0;
        this.buffer = Buffer.allocUnsafe(DefaultSize);
    }
    append(chunk) {
        var toAppend = chunk;
        if (typeof (chunk) === 'string') {
            var str = chunk;
            var bufferLen = Buffer.byteLength(str, this.encoding);
            toAppend = Buffer.allocUnsafe(bufferLen);
            toAppend.write(str, 0, bufferLen, this.encoding);
        }
        if (this.buffer.length - this.index >= toAppend.length) {
            toAppend.copy(this.buffer, this.index, 0, toAppend.length);
        }
        else {
            var newSize = (Math.ceil((this.index + toAppend.length) / DefaultSize) + 1) * DefaultSize;
            if (this.index === 0) {
                this.buffer = Buffer.allocUnsafe(newSize);
                toAppend.copy(this.buffer, 0, 0, toAppend.length);
            }
            else {
                this.buffer = Buffer.concat([this.buffer.slice(0, this.index), toAppend], newSize);
            }
        }
        this.index += toAppend.length;
    }
    tryReadHeaders() {
        let result = undefined;
        let current = 0;
        while (current + 3 < this.index && (this.buffer[current] !== CR || this.buffer[current + 1] !== LF || this.buffer[current + 2] !== CR || this.buffer[current + 3] !== LF)) {
            current++;
        }
        // No header / body separator found (e.g CRLFCRLF)
        if (current + 3 >= this.index) {
            return result;
        }
        result = Object.create(null);
        let headers = this.buffer.toString('ascii', 0, current).split(CRLF);
        headers.forEach((header) => {
            let index = header.indexOf(':');
            if (index === -1) {
                throw new Error('Message header must separate key and value using :');
            }
            let key = header.substr(0, index);
            let value = header.substr(index + 1).trim();
            result[key] = value;
        });
        let nextStart = current + 4;
        this.buffer = this.buffer.slice(nextStart);
        this.index = this.index - nextStart;
        return result;
    }
    tryReadContent(length) {
        if (this.index < length) {
            return null;
        }
        let result = this.buffer.toString(this.encoding, 0, length);
        let nextStart = length;
        this.buffer.copy(this.buffer, 0, nextStart);
        this.index = this.index - nextStart;
        return result;
    }
    get numberOfBytes() {
        return this.index;
    }
}
var MessageReader;
(function (MessageReader) {
    function is(value) {
        let candidate = value;
        return candidate && Is.func(candidate.listen) && Is.func(candidate.dispose) &&
            Is.func(candidate.onError) && Is.func(candidate.onClose) && Is.func(candidate.onPartialMessage);
    }
    MessageReader.is = is;
})(MessageReader = exports.MessageReader || (exports.MessageReader = {}));
class AbstractMessageReader {
    constructor() {
        this.errorEmitter = new events_1.Emitter();
        this.closeEmitter = new events_1.Emitter();
        this.partialMessageEmitter = new events_1.Emitter();
    }
    dispose() {
        this.errorEmitter.dispose();
        this.closeEmitter.dispose();
    }
    get onError() {
        return this.errorEmitter.event;
    }
    fireError(error) {
        this.errorEmitter.fire(this.asError(error));
    }
    get onClose() {
        return this.closeEmitter.event;
    }
    fireClose() {
        this.closeEmitter.fire(undefined);
    }
    get onPartialMessage() {
        return this.partialMessageEmitter.event;
    }
    firePartialMessage(info) {
        this.partialMessageEmitter.fire(info);
    }
    asError(error) {
        if (error instanceof Error) {
            return error;
        }
        else {
            return new Error(`Reader recevied error. Reason: ${Is.string(error.message) ? error.message : 'unknown'}`);
        }
    }
}
exports.AbstractMessageReader = AbstractMessageReader;
class StreamMessageReader extends AbstractMessageReader {
    constructor(readable, encoding = 'utf8') {
        super();
        this.readable = readable;
        this.buffer = new MessageBuffer(encoding);
        this._partialMessageTimeout = 10000;
    }
    set partialMessageTimeout(timeout) {
        this._partialMessageTimeout = timeout;
    }
    get partialMessageTimeout() {
        return this._partialMessageTimeout;
    }
    listen(callback) {
        this.nextMessageLength = -1;
        this.messageToken = 0;
        this.partialMessageTimer = undefined;
        this.callback = callback;
        this.readable.on('data', (data) => {
            this.onData(data);
        });
        this.readable.on('error', (error) => this.fireError(error));
        this.readable.on('close', () => this.fireClose());
    }
    onData(data) {
        this.buffer.append(data);
        while (true) {
            if (this.nextMessageLength === -1) {
                let headers = this.buffer.tryReadHeaders();
                if (!headers) {
                    return;
                }
                let contentLength = headers['Content-Length'];
                if (!contentLength) {
                    throw new Error('Header must provide a Content-Length property.');
                }
                let length = parseInt(contentLength);
                if (isNaN(length)) {
                    throw new Error('Content-Length value must be a number.');
                }
                this.nextMessageLength = length;
                // Take the encoding form the header. For compatibility
                // treat both utf-8 and utf8 as node utf8
            }
            var msg = this.buffer.tryReadContent(this.nextMessageLength);
            if (msg === null) {
                /** We haven't recevied the full message yet. */
                this.setPartialMessageTimer();
                return;
            }
            this.clearPartialMessageTimer();
            this.nextMessageLength = -1;
            this.messageToken++;
            var json = JSON.parse(msg);
            this.callback(json);
        }
    }
    clearPartialMessageTimer() {
        if (this.partialMessageTimer) {
            clearTimeout(this.partialMessageTimer);
            this.partialMessageTimer = undefined;
        }
    }
    setPartialMessageTimer() {
        this.clearPartialMessageTimer();
        if (this._partialMessageTimeout <= 0) {
            return;
        }
        this.partialMessageTimer = setTimeout((token, timeout) => {
            this.partialMessageTimer = undefined;
            if (token === this.messageToken) {
                this.firePartialMessage({ messageToken: token, waitingTime: timeout });
                this.setPartialMessageTimer();
            }
        }, this._partialMessageTimeout, this.messageToken, this._partialMessageTimeout);
    }
}
exports.StreamMessageReader = StreamMessageReader;
class IPCMessageReader extends AbstractMessageReader {
    constructor(process) {
        super();
        this.process = process;
        let eventEmitter = this.process;
        eventEmitter.on('error', (error) => this.fireError(error));
        eventEmitter.on('close', () => this.fireClose());
    }
    listen(callback) {
        this.process.on('message', callback);
    }
}
exports.IPCMessageReader = IPCMessageReader;
class SocketMessageReader extends StreamMessageReader {
    constructor(socket, encoding = 'utf-8') {
        super(socket, encoding);
    }
}
exports.SocketMessageReader = SocketMessageReader;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../../buffer/index.js */ "../node_modules/buffer/index.js").Buffer))

/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageWriter.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageWriter.js ***!
  \*******************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(Buffer) {/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const events_1 = __webpack_require__(/*! ./events */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/events.js");
const Is = __webpack_require__(/*! ./is */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js");
let ContentLength = 'Content-Length: ';
let CRLF = '\r\n';
var MessageWriter;
(function (MessageWriter) {
    function is(value) {
        let candidate = value;
        return candidate && Is.func(candidate.dispose) && Is.func(candidate.onClose) &&
            Is.func(candidate.onError) && Is.func(candidate.write);
    }
    MessageWriter.is = is;
})(MessageWriter = exports.MessageWriter || (exports.MessageWriter = {}));
class AbstractMessageWriter {
    constructor() {
        this.errorEmitter = new events_1.Emitter();
        this.closeEmitter = new events_1.Emitter();
    }
    dispose() {
        this.errorEmitter.dispose();
        this.closeEmitter.dispose();
    }
    get onError() {
        return this.errorEmitter.event;
    }
    fireError(error, message, count) {
        this.errorEmitter.fire([this.asError(error), message, count]);
    }
    get onClose() {
        return this.closeEmitter.event;
    }
    fireClose() {
        this.closeEmitter.fire(undefined);
    }
    asError(error) {
        if (error instanceof Error) {
            return error;
        }
        else {
            return new Error(`Writer recevied error. Reason: ${Is.string(error.message) ? error.message : 'unknown'}`);
        }
    }
}
exports.AbstractMessageWriter = AbstractMessageWriter;
class StreamMessageWriter extends AbstractMessageWriter {
    constructor(writable, encoding = 'utf8') {
        super();
        this.writable = writable;
        this.encoding = encoding;
        this.errorCount = 0;
        this.writable.on('error', (error) => this.fireError(error));
        this.writable.on('close', () => this.fireClose());
    }
    write(msg) {
        let json = JSON.stringify(msg);
        let contentLength = Buffer.byteLength(json, this.encoding);
        let headers = [
            ContentLength, contentLength.toString(), CRLF,
            CRLF
        ];
        try {
            // Header must be written in ASCII encoding
            this.writable.write(headers.join(''), 'ascii');
            // Now write the content. This can be written in any encoding
            this.writable.write(json, this.encoding);
            this.errorCount = 0;
        }
        catch (error) {
            this.errorCount++;
            this.fireError(error, msg, this.errorCount);
        }
    }
}
exports.StreamMessageWriter = StreamMessageWriter;
class IPCMessageWriter extends AbstractMessageWriter {
    constructor(process) {
        super();
        this.process = process;
        this.errorCount = 0;
        this.queue = [];
        this.sending = false;
        let eventEmitter = this.process;
        eventEmitter.on('error', (error) => this.fireError(error));
        eventEmitter.on('close', () => this.fireClose);
    }
    write(msg) {
        if (!this.sending && this.queue.length === 0) {
            // See https://github.com/nodejs/node/issues/7657
            this.doWriteMessage(msg);
        }
        else {
            this.queue.push(msg);
        }
    }
    doWriteMessage(msg) {
        try {
            if (this.process.send) {
                this.sending = true;
                this.process.send(msg, undefined, undefined, (error) => {
                    this.sending = false;
                    if (error) {
                        this.errorCount++;
                        this.fireError(error, msg, this.errorCount);
                    }
                    else {
                        this.errorCount = 0;
                    }
                    if (this.queue.length > 0) {
                        this.doWriteMessage(this.queue.shift());
                    }
                });
            }
        }
        catch (error) {
            this.errorCount++;
            this.fireError(error, msg, this.errorCount);
        }
    }
}
exports.IPCMessageWriter = IPCMessageWriter;
class SocketMessageWriter extends AbstractMessageWriter {
    constructor(socket, encoding = 'utf8') {
        super();
        this.socket = socket;
        this.queue = [];
        this.sending = false;
        this.encoding = encoding;
        this.errorCount = 0;
        this.socket.on('error', (error) => this.fireError(error));
        this.socket.on('close', () => this.fireClose());
    }
    write(msg) {
        if (!this.sending && this.queue.length === 0) {
            // See https://github.com/nodejs/node/issues/7657
            this.doWriteMessage(msg);
        }
        else {
            this.queue.push(msg);
        }
    }
    doWriteMessage(msg) {
        let json = JSON.stringify(msg);
        let contentLength = Buffer.byteLength(json, this.encoding);
        let headers = [
            ContentLength, contentLength.toString(), CRLF,
            CRLF
        ];
        try {
            // Header must be written in ASCII encoding
            this.sending = true;
            this.socket.write(headers.join(''), 'ascii', (error) => {
                if (error) {
                    this.handleError(error, msg);
                }
                try {
                    // Now write the content. This can be written in any encoding
                    this.socket.write(json, this.encoding, (error) => {
                        this.sending = false;
                        if (error) {
                            this.handleError(error, msg);
                        }
                        else {
                            this.errorCount = 0;
                        }
                        if (this.queue.length > 0) {
                            this.doWriteMessage(this.queue.shift());
                        }
                    });
                }
                catch (error) {
                    this.handleError(error, msg);
                }
            });
        }
        catch (error) {
            this.handleError(error, msg);
        }
    }
    handleError(error, msg) {
        this.errorCount++;
        this.fireError(error, msg, this.errorCount);
    }
}
exports.SocketMessageWriter = SocketMessageWriter;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../../buffer/index.js */ "../node_modules/buffer/index.js").Buffer))

/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messages.js":
/*!**************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messages.js ***!
  \**************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const is = __webpack_require__(/*! ./is */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/is.js");
/**
 * Predefined error codes.
 */
var ErrorCodes;
(function (ErrorCodes) {
    // Defined by JSON RPC
    ErrorCodes.ParseError = -32700;
    ErrorCodes.InvalidRequest = -32600;
    ErrorCodes.MethodNotFound = -32601;
    ErrorCodes.InvalidParams = -32602;
    ErrorCodes.InternalError = -32603;
    ErrorCodes.serverErrorStart = -32099;
    ErrorCodes.serverErrorEnd = -32000;
    ErrorCodes.ServerNotInitialized = -32002;
    ErrorCodes.UnknownErrorCode = -32001;
    // Defined by the protocol.
    ErrorCodes.RequestCancelled = -32800;
    // Defined by VSCode library.
    ErrorCodes.MessageWriteError = 1;
    ErrorCodes.MessageReadError = 2;
})(ErrorCodes = exports.ErrorCodes || (exports.ErrorCodes = {}));
/**
 * An error object return in a response in case a request
 * has failed.
 */
class ResponseError extends Error {
    constructor(code, message, data) {
        super(message);
        this.code = is.number(code) ? code : ErrorCodes.UnknownErrorCode;
        this.data = data;
        Object.setPrototypeOf(this, ResponseError.prototype);
    }
    toJson() {
        return {
            code: this.code,
            message: this.message,
            data: this.data,
        };
    }
}
exports.ResponseError = ResponseError;
/**
 * An abstract implementation of a MessageType.
 */
class AbstractMessageType {
    constructor(_method, _numberOfParams) {
        this._method = _method;
        this._numberOfParams = _numberOfParams;
    }
    get method() {
        return this._method;
    }
    get numberOfParams() {
        return this._numberOfParams;
    }
}
exports.AbstractMessageType = AbstractMessageType;
/**
 * Classes to type request response pairs
 */
class RequestType0 extends AbstractMessageType {
    constructor(method) {
        super(method, 0);
        this._ = undefined;
    }
}
exports.RequestType0 = RequestType0;
class RequestType extends AbstractMessageType {
    constructor(method) {
        super(method, 1);
        this._ = undefined;
    }
}
exports.RequestType = RequestType;
class RequestType1 extends AbstractMessageType {
    constructor(method) {
        super(method, 1);
        this._ = undefined;
    }
}
exports.RequestType1 = RequestType1;
class RequestType2 extends AbstractMessageType {
    constructor(method) {
        super(method, 2);
        this._ = undefined;
    }
}
exports.RequestType2 = RequestType2;
class RequestType3 extends AbstractMessageType {
    constructor(method) {
        super(method, 3);
        this._ = undefined;
    }
}
exports.RequestType3 = RequestType3;
class RequestType4 extends AbstractMessageType {
    constructor(method) {
        super(method, 4);
        this._ = undefined;
    }
}
exports.RequestType4 = RequestType4;
class RequestType5 extends AbstractMessageType {
    constructor(method) {
        super(method, 5);
        this._ = undefined;
    }
}
exports.RequestType5 = RequestType5;
class RequestType6 extends AbstractMessageType {
    constructor(method) {
        super(method, 6);
        this._ = undefined;
    }
}
exports.RequestType6 = RequestType6;
class RequestType7 extends AbstractMessageType {
    constructor(method) {
        super(method, 7);
        this._ = undefined;
    }
}
exports.RequestType7 = RequestType7;
class RequestType8 extends AbstractMessageType {
    constructor(method) {
        super(method, 8);
        this._ = undefined;
    }
}
exports.RequestType8 = RequestType8;
class RequestType9 extends AbstractMessageType {
    constructor(method) {
        super(method, 9);
        this._ = undefined;
    }
}
exports.RequestType9 = RequestType9;
class NotificationType extends AbstractMessageType {
    constructor(method) {
        super(method, 1);
        this._ = undefined;
    }
}
exports.NotificationType = NotificationType;
class NotificationType0 extends AbstractMessageType {
    constructor(method) {
        super(method, 0);
        this._ = undefined;
    }
}
exports.NotificationType0 = NotificationType0;
class NotificationType1 extends AbstractMessageType {
    constructor(method) {
        super(method, 1);
        this._ = undefined;
    }
}
exports.NotificationType1 = NotificationType1;
class NotificationType2 extends AbstractMessageType {
    constructor(method) {
        super(method, 2);
        this._ = undefined;
    }
}
exports.NotificationType2 = NotificationType2;
class NotificationType3 extends AbstractMessageType {
    constructor(method) {
        super(method, 3);
        this._ = undefined;
    }
}
exports.NotificationType3 = NotificationType3;
class NotificationType4 extends AbstractMessageType {
    constructor(method) {
        super(method, 4);
        this._ = undefined;
    }
}
exports.NotificationType4 = NotificationType4;
class NotificationType5 extends AbstractMessageType {
    constructor(method) {
        super(method, 5);
        this._ = undefined;
    }
}
exports.NotificationType5 = NotificationType5;
class NotificationType6 extends AbstractMessageType {
    constructor(method) {
        super(method, 6);
        this._ = undefined;
    }
}
exports.NotificationType6 = NotificationType6;
class NotificationType7 extends AbstractMessageType {
    constructor(method) {
        super(method, 7);
        this._ = undefined;
    }
}
exports.NotificationType7 = NotificationType7;
class NotificationType8 extends AbstractMessageType {
    constructor(method) {
        super(method, 8);
        this._ = undefined;
    }
}
exports.NotificationType8 = NotificationType8;
class NotificationType9 extends AbstractMessageType {
    constructor(method) {
        super(method, 9);
        this._ = undefined;
    }
}
exports.NotificationType9 = NotificationType9;
/**
 * Tests if the given message is a request message
 */
function isRequestMessage(message) {
    let candidate = message;
    return candidate && is.string(candidate.method) && (is.string(candidate.id) || is.number(candidate.id));
}
exports.isRequestMessage = isRequestMessage;
/**
 * Tests if the given message is a notification message
 */
function isNotificationMessage(message) {
    let candidate = message;
    return candidate && is.string(candidate.method) && message.id === void 0;
}
exports.isNotificationMessage = isNotificationMessage;
/**
 * Tests if the given message is a response message
 */
function isResponseMessage(message) {
    let candidate = message;
    return candidate && (candidate.result !== void 0 || !!candidate.error) && (is.string(candidate.id) || is.number(candidate.id) || candidate.id === null);
}
exports.isResponseMessage = isResponseMessage;


/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/pipeSupport.js":
/*!*****************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/pipeSupport.js ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(process) {/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const path_1 = __webpack_require__(/*! path */ "../node_modules/path-browserify/index.js");
const os_1 = __webpack_require__(/*! os */ "../node_modules/os-browserify/browser.js");
const crypto_1 = __webpack_require__(/*! crypto */ "../node_modules/node-libs-browser/mock/empty.js");
const net_1 = __webpack_require__(/*! net */ "../node_modules/node-libs-browser/mock/empty.js");
const messageReader_1 = __webpack_require__(/*! ./messageReader */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageReader.js");
const messageWriter_1 = __webpack_require__(/*! ./messageWriter */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageWriter.js");
function generateRandomPipeName() {
    const randomSuffix = crypto_1.randomBytes(21).toString('hex');
    if (process.platform === 'win32') {
        return `\\\\.\\pipe\\vscode-jsonrpc-${randomSuffix}-sock`;
    }
    else {
        // Mac/Unix: use socket file
        return path_1.join(os_1.tmpdir(), `vscode-${randomSuffix}.sock`);
    }
}
exports.generateRandomPipeName = generateRandomPipeName;
function createClientPipeTransport(pipeName, encoding = 'utf-8') {
    let connectResolve;
    let connected = new Promise((resolve, _reject) => {
        connectResolve = resolve;
    });
    return new Promise((resolve, reject) => {
        let server = net_1.createServer((socket) => {
            server.close();
            connectResolve([
                new messageReader_1.SocketMessageReader(socket, encoding),
                new messageWriter_1.SocketMessageWriter(socket, encoding)
            ]);
        });
        server.on('error', reject);
        server.listen(pipeName, () => {
            server.removeListener('error', reject);
            resolve({
                onConnected: () => { return connected; }
            });
        });
    });
}
exports.createClientPipeTransport = createClientPipeTransport;
function createServerPipeTransport(pipeName, encoding = 'utf-8') {
    const socket = net_1.createConnection(pipeName);
    return [
        new messageReader_1.SocketMessageReader(socket, encoding),
        new messageWriter_1.SocketMessageWriter(socket, encoding)
    ];
}
exports.createServerPipeTransport = createServerPipeTransport;

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../../process/browser.js */ "../node_modules/process/browser.js")))

/***/ }),

/***/ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/socketSupport.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/socketSupport.js ***!
  \*******************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

Object.defineProperty(exports, "__esModule", { value: true });
const net_1 = __webpack_require__(/*! net */ "../node_modules/node-libs-browser/mock/empty.js");
const messageReader_1 = __webpack_require__(/*! ./messageReader */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageReader.js");
const messageWriter_1 = __webpack_require__(/*! ./messageWriter */ "../node_modules/vscode-languageserver-protocol/node_modules/vscode-jsonrpc/lib/messageWriter.js");
function createClientSocketTransport(port, encoding = 'utf-8') {
    let connectResolve;
    let connected = new Promise((resolve, _reject) => {
        connectResolve = resolve;
    });
    return new Promise((resolve, reject) => {
        let server = net_1.createServer((socket) => {
            server.close();
            connectResolve([
                new messageReader_1.SocketMessageReader(socket, encoding),
                new messageWriter_1.SocketMessageWriter(socket, encoding)
            ]);
        });
        server.on('error', reject);
        server.listen(port, '127.0.0.1', () => {
            server.removeListener('error', reject);
            resolve({
                onConnected: () => { return connected; }
            });
        });
    });
}
exports.createClientSocketTransport = createClientSocketTransport;
function createServerSocketTransport(port, encoding = 'utf-8') {
    const socket = net_1.createConnection(port, '127.0.0.1');
    return [
        new messageReader_1.SocketMessageReader(socket, encoding),
        new messageWriter_1.SocketMessageWriter(socket, encoding)
    ];
}
exports.createServerSocketTransport = createServerSocketTransport;


/***/ })

}]);
//# sourceMappingURL=8.bundle.js.map