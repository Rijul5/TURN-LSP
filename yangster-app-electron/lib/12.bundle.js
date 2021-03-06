(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[12],{

/***/ "../node_modules/@theia/filesystem/lib/browser/download/file-download-command-contribution.js":
/*!****************************************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/download/file-download-command-contribution.js ***!
  \****************************************************************************************************/
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var objects_1 = __webpack_require__(/*! @theia/core/lib/common/objects */ "../node_modules/@theia/core/lib/common/objects.js");
var selection_1 = __webpack_require__(/*! @theia/core/lib/common/selection */ "../node_modules/@theia/core/lib/common/selection.js");
var selection_service_1 = __webpack_require__(/*! @theia/core/lib/common/selection-service */ "../node_modules/@theia/core/lib/common/selection-service.js");
var uri_command_handler_1 = __webpack_require__(/*! @theia/core/lib/common/uri-command-handler */ "../node_modules/@theia/core/lib/common/uri-command-handler.js");
var file_download_service_1 = __webpack_require__(/*! ./file-download-service */ "../node_modules/@theia/filesystem/lib/browser/download/file-download-service.js");
var FileDownloadCommandContribution = /** @class */ (function () {
    function FileDownloadCommandContribution() {
    }
    FileDownloadCommandContribution.prototype.registerCommands = function (registry) {
        var handler = new uri_command_handler_1.UriAwareCommandHandler(this.selectionService, this.downloadHandler(), { multi: true });
        registry.registerCommand(FileDownloadCommands.DOWNLOAD, handler);
    };
    FileDownloadCommandContribution.prototype.downloadHandler = function () {
        var _this = this;
        return {
            execute: function (uris) { return _this.executeDownload(uris); },
            isEnabled: function (uris) { return _this.isDownloadEnabled(uris); },
            isVisible: function (uris) { return _this.isDownloadVisible(uris); },
        };
    };
    FileDownloadCommandContribution.prototype.executeDownload = function (uris) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.downloadService.download(uris);
                return [2 /*return*/];
            });
        });
    };
    FileDownloadCommandContribution.prototype.isDownloadEnabled = function (uris) {
        return uris.length > 0 && uris.every(function (u) { return u.scheme === 'file'; });
    };
    FileDownloadCommandContribution.prototype.isDownloadVisible = function (uris) {
        return this.isDownloadEnabled(uris);
    };
    FileDownloadCommandContribution.prototype.getUris = function (uri) {
        var _this = this;
        if (uri === undefined) {
            return [];
        }
        return (Array.isArray(uri) ? uri : [uri]).map(function (u) { return _this.getUri(u); }).filter(objects_1.notEmpty);
    };
    FileDownloadCommandContribution.prototype.getUri = function (uri) {
        if (uri instanceof uri_1.default) {
            return uri;
        }
        if (selection_1.UriSelection.is(uri)) {
            return uri.uri;
        }
        return undefined;
    };
    __decorate([
        inversify_1.inject(file_download_service_1.FileDownloadService),
        __metadata("design:type", file_download_service_1.FileDownloadService)
    ], FileDownloadCommandContribution.prototype, "downloadService", void 0);
    __decorate([
        inversify_1.inject(selection_service_1.SelectionService),
        __metadata("design:type", selection_service_1.SelectionService)
    ], FileDownloadCommandContribution.prototype, "selectionService", void 0);
    FileDownloadCommandContribution = __decorate([
        inversify_1.injectable()
    ], FileDownloadCommandContribution);
    return FileDownloadCommandContribution;
}());
exports.FileDownloadCommandContribution = FileDownloadCommandContribution;
var FileDownloadCommands;
(function (FileDownloadCommands) {
    FileDownloadCommands.DOWNLOAD = {
        id: 'file.download'
    };
})(FileDownloadCommands = exports.FileDownloadCommands || (exports.FileDownloadCommands = {}));


/***/ }),

/***/ "../node_modules/@theia/filesystem/lib/browser/download/file-download-service.js":
/*!***************************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/download/file-download-service.js ***!
  \***************************************************************************************/
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
var logger_1 = __webpack_require__(/*! @theia/core/lib/common/logger */ "../node_modules/@theia/core/lib/common/logger.js");
var endpoint_1 = __webpack_require__(/*! @theia/core/lib/browser/endpoint */ "../node_modules/@theia/core/lib/browser/endpoint.js");
var status_bar_1 = __webpack_require__(/*! @theia/core/lib/browser/status-bar */ "../node_modules/@theia/core/lib/browser/status-bar/index.js");
var filesystem_1 = __webpack_require__(/*! ../../common/filesystem */ "../node_modules/@theia/filesystem/lib/common/filesystem.js");
var FileDownloadService = /** @class */ (function () {
    function FileDownloadService() {
        this.downloadQueue = [];
        this.downloadCounter = 0;
    }
    FileDownloadService_1 = FileDownloadService;
    FileDownloadService.prototype.download = function (uris) {
        return __awaiter(this, void 0, void 0, function () {
            var downloadId, response, title, status_1, statusText, e_1, indexOf;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (uris.length === 0) {
                            return [2 /*return*/];
                        }
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 10, 11, 12]);
                        downloadId = this.downloadCounter++;
                        if (!(this.downloadQueue.length === 0)) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.statusBar.setElement(FileDownloadService_1.PREPARING_DOWNLOAD_ID, {
                                alignment: status_bar_1.StatusBarAlignment.RIGHT,
                                text: '$(spinner~spin) Preparing download...',
                                tooltip: 'Preparing download...',
                                priority: 1
                            })];
                    case 2:
                        _a.sent();
                        _a.label = 3;
                    case 3:
                        this.downloadQueue.push(downloadId);
                        return [4 /*yield*/, fetch(this.request(uris))];
                    case 4:
                        response = _a.sent();
                        return [4 /*yield*/, this.statusBar.removeElement(FileDownloadService_1.PREPARING_DOWNLOAD_ID)];
                    case 5:
                        _a.sent();
                        return [4 /*yield*/, this.title(response, uris)];
                    case 6:
                        title = _a.sent();
                        status_1 = response.status, statusText = response.statusText;
                        if (!(status_1 === 200)) return [3 /*break*/, 8];
                        return [4 /*yield*/, this.forceDownload(response, title)];
                    case 7:
                        _a.sent();
                        return [3 /*break*/, 9];
                    case 8: throw new Error("Received unexpected status code: " + status_1 + ". [" + statusText + "]");
                    case 9: return [3 /*break*/, 12];
                    case 10:
                        e_1 = _a.sent();
                        this.logger.error("Error occurred when downloading: " + uris.map(function (u) { return u.toString(true); }) + ".", e_1);
                        return [3 /*break*/, 12];
                    case 11:
                        if (downloadId !== undefined) {
                            indexOf = this.downloadQueue.indexOf(downloadId);
                            if (indexOf !== -1) {
                                this.downloadQueue.splice(indexOf, 1);
                            }
                            if (this.downloadQueue.length === 0) {
                                this.statusBar.removeElement(FileDownloadService_1.PREPARING_DOWNLOAD_ID);
                            }
                        }
                        return [7 /*endfinally*/];
                    case 12: return [2 /*return*/];
                }
            });
        });
    };
    FileDownloadService.prototype.forceDownload = function (response, title) {
        return __awaiter(this, void 0, void 0, function () {
            var url, blob;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, , 2, 3]);
                        return [4 /*yield*/, response.blob()];
                    case 1:
                        blob = _a.sent();
                        url = URL.createObjectURL(blob);
                        if (this.anchor === undefined) {
                            this.anchor = document.createElement('a');
                            this.anchor.style.display = 'none';
                        }
                        this.anchor.href = url;
                        this.anchor.download = title;
                        this.anchor.click();
                        return [3 /*break*/, 3];
                    case 2:
                        if (url) {
                            URL.revokeObjectURL(url);
                        }
                        return [7 /*endfinally*/];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    FileDownloadService.prototype.title = function (response, uris) {
        return __awaiter(this, void 0, void 0, function () {
            var title, _a, uri, stat;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        title = (response.headers.get('Content-Disposition') || '').split('attachment; filename=').pop();
                        if (title) {
                            return [2 /*return*/, title];
                        }
                        _a = __read(uris, 1), uri = _a[0];
                        if (!(uris.length === 1)) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.fileSystem.getFileStat(uri.toString())];
                    case 1:
                        stat = _b.sent();
                        if (stat === undefined) {
                            throw new Error("Unexpected error occurred when downloading file. Files does not exist. URI: " + uri.toString(true) + ".");
                        }
                        title = uri.path.base;
                        return [2 /*return*/, stat.isDirectory ? title + ".tar" : title];
                    case 2: return [2 /*return*/, uri.parent.path.name + ".tar"];
                }
            });
        });
    };
    FileDownloadService.prototype.request = function (uris) {
        var url = this.url(uris);
        var init = this.requestInit(uris);
        return new Request(url, init);
    };
    FileDownloadService.prototype.requestInit = function (uris) {
        if (uris.length === 1) {
            return {
                body: undefined,
                method: 'GET'
            };
        }
        return {
            method: 'PUT',
            body: JSON.stringify(this.body(uris)),
            headers: new Headers({ 'Content-Type': 'application/json' }),
        };
    };
    FileDownloadService.prototype.body = function (uris) {
        return {
            uris: uris.map(function (u) { return u.toString(true); })
        };
    };
    FileDownloadService.prototype.url = function (uris) {
        var endpoint = this.endpoint();
        if (uris.length === 1) {
            // tslint:disable-next-line:whitespace
            var _a = __read(uris, 1), uri = _a[0];
            return endpoint + "/?uri=" + uri.toString();
        }
        return endpoint;
    };
    FileDownloadService.prototype.endpoint = function () {
        var url = new endpoint_1.Endpoint({ path: 'files' }).getRestUrl().toString();
        return url.endsWith('/') ? url.slice(0, -1) : url;
    };
    var FileDownloadService_1;
    FileDownloadService.PREPARING_DOWNLOAD_ID = 'theia-preparing-download';
    __decorate([
        inversify_1.inject(logger_1.ILogger),
        __metadata("design:type", Object)
    ], FileDownloadService.prototype, "logger", void 0);
    __decorate([
        inversify_1.inject(filesystem_1.FileSystem),
        __metadata("design:type", Object)
    ], FileDownloadService.prototype, "fileSystem", void 0);
    __decorate([
        inversify_1.inject(status_bar_1.StatusBar),
        __metadata("design:type", Object)
    ], FileDownloadService.prototype, "statusBar", void 0);
    FileDownloadService = FileDownloadService_1 = __decorate([
        inversify_1.injectable()
    ], FileDownloadService);
    return FileDownloadService;
}());
exports.FileDownloadService = FileDownloadService;


/***/ })

}]);
//# sourceMappingURL=12.bundle.js.map