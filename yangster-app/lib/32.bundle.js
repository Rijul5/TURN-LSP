(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[32],{

/***/ "../node_modules/@theia/filesystem/lib/browser/filesystem-frontend-contribution.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/filesystem-frontend-contribution.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var filesystem_watcher_1 = __webpack_require__(/*! ./filesystem-watcher */ "../node_modules/@theia/filesystem/lib/browser/filesystem-watcher.js");
var FileSystemFrontendContribution = /** @class */ (function () {
    function FileSystemFrontendContribution() {
        this.pendingOperation = Promise.resolve();
        this.deletedSuffix = ' (deleted from disk)';
    }
    FileSystemFrontendContribution.prototype.initialize = function () {
        var _this = this;
        this.fileSystemWatcher.onFilesChanged(function (event) { return _this.run(function () { return _this.updateWidgets(event); }); });
        this.fileSystemWatcher.onDidMove(function (event) { return _this.run(function () { return _this.moveWidgets(event); }); });
    };
    FileSystemFrontendContribution.prototype.run = function (operation) {
        var _this = this;
        return this.pendingOperation = this.pendingOperation.then(function () { return __awaiter(_this, void 0, void 0, function () {
            var e_1;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, operation()];
                    case 1:
                        _a.sent();
                        return [3 /*break*/, 3];
                    case 2:
                        e_1 = _a.sent();
                        console.error(e_1);
                        return [3 /*break*/, 3];
                    case 3: return [2 /*return*/];
                }
            });
        }); });
    };
    FileSystemFrontendContribution.prototype.moveWidgets = function (event) {
        return __awaiter(this, void 0, void 0, function () {
            var e_2, _a, promises, _b, _c, _d, resourceUri, widget;
            return __generator(this, function (_e) {
                switch (_e.label) {
                    case 0:
                        promises = [];
                        try {
                            for (_b = __values(browser_1.NavigatableWidget.get(this.shell.widgets)), _c = _b.next(); !_c.done; _c = _b.next()) {
                                _d = __read(_c.value, 2), resourceUri = _d[0], widget = _d[1];
                                promises.push(this.moveWidget(resourceUri, widget, event));
                            }
                        }
                        catch (e_2_1) { e_2 = { error: e_2_1 }; }
                        finally {
                            try {
                                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                            }
                            finally { if (e_2) throw e_2.error; }
                        }
                        return [4 /*yield*/, Promise.all(promises)];
                    case 1:
                        _e.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    FileSystemFrontendContribution.prototype.moveWidget = function (resourceUri, widget, event) {
        return __awaiter(this, void 0, void 0, function () {
            var newResourceUri, description, factoryId, options, newWidget, oldState, area;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        newResourceUri = this.createMoveToUri(resourceUri, widget, event);
                        if (!newResourceUri) {
                            return [2 /*return*/];
                        }
                        description = this.widgetManager.getDescription(widget);
                        if (!description) {
                            return [2 /*return*/];
                        }
                        factoryId = description.factoryId, options = description.options;
                        if (!browser_1.NavigatableWidgetOptions.is(options)) {
                            return [2 /*return*/];
                        }
                        return [4 /*yield*/, this.widgetManager.getOrCreateWidget(factoryId, __assign({}, options, { uri: newResourceUri.toString() }))];
                    case 1:
                        newWidget = _a.sent();
                        oldState = browser_1.StatefulWidget.is(widget) ? widget.storeState() : undefined;
                        if (oldState && browser_1.StatefulWidget.is(newWidget)) {
                            newWidget.restoreState(oldState);
                        }
                        area = this.shell.getAreaFor(widget) || 'main';
                        this.shell.addWidget(newWidget, {
                            area: area, ref: widget
                        });
                        if (this.shell.activeWidget === widget) {
                            this.shell.activateWidget(newWidget.id);
                        }
                        else if (widget.isVisible) {
                            this.shell.revealWidget(newWidget.id);
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    FileSystemFrontendContribution.prototype.createMoveToUri = function (resourceUri, widget, event) {
        var path = event.sourceUri.relative(resourceUri);
        var targetUri = path && event.targetUri.resolve(path);
        return targetUri && widget.createMoveToUri(targetUri);
    };
    FileSystemFrontendContribution.prototype.updateWidgets = function (event) {
        var relevantEvent = event.filter(function (_a) {
            var type = _a.type;
            return type !== filesystem_watcher_1.FileChangeType.UPDATED;
        });
        if (relevantEvent.length) {
            this.doUpdateWidgets(relevantEvent);
        }
    };
    FileSystemFrontendContribution.prototype.doUpdateWidgets = function (event) {
        var e_3, _a, e_4, _b, e_5, _c;
        var dirty = new Set();
        var toClose = new Map();
        try {
            for (var _d = __values(browser_1.NavigatableWidget.get(this.shell.widgets)), _e = _d.next(); !_e.done; _e = _d.next()) {
                var _f = __read(_e.value, 2), uri = _f[0], widget = _f[1];
                this.updateWidget(uri, widget, event, { dirty: dirty, toClose: toClose });
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (_e && !_e.done && (_a = _d.return)) _a.call(_d);
            }
            finally { if (e_3) throw e_3.error; }
        }
        try {
            for (var _g = __values(toClose.entries()), _h = _g.next(); !_h.done; _h = _g.next()) {
                var _j = __read(_h.value, 2), uriString = _j[0], widgets = _j[1];
                if (!dirty.has(uriString)) {
                    try {
                        for (var widgets_1 = __values(widgets), widgets_1_1 = widgets_1.next(); !widgets_1_1.done; widgets_1_1 = widgets_1.next()) {
                            var widget = widgets_1_1.value;
                            widget.close();
                        }
                    }
                    catch (e_5_1) { e_5 = { error: e_5_1 }; }
                    finally {
                        try {
                            if (widgets_1_1 && !widgets_1_1.done && (_c = widgets_1.return)) _c.call(widgets_1);
                        }
                        finally { if (e_5) throw e_5.error; }
                    }
                }
            }
        }
        catch (e_4_1) { e_4 = { error: e_4_1 }; }
        finally {
            try {
                if (_h && !_h.done && (_b = _g.return)) _b.call(_g);
            }
            finally { if (e_4) throw e_4.error; }
        }
    };
    FileSystemFrontendContribution.prototype.updateWidget = function (uri, widget, event, _a) {
        var dirty = _a.dirty, toClose = _a.toClose;
        var label = widget.title.label;
        var deleted = label.endsWith(this.deletedSuffix);
        if (filesystem_watcher_1.FileChangeEvent.isDeleted(event, uri)) {
            var uriString = uri.toString();
            if (browser_1.Saveable.isDirty(widget)) {
                if (!deleted) {
                    widget.title.label += this.deletedSuffix;
                }
                dirty.add(uriString);
            }
            var widgets = toClose.get(uriString) || [];
            widgets.push(widget);
            toClose.set(uriString, widgets);
        }
        else if (filesystem_watcher_1.FileChangeEvent.isAdded(event, uri)) {
            if (deleted) {
                widget.title.label = widget.title.label.substr(0, label.length - this.deletedSuffix.length);
            }
        }
    };
    __decorate([
        inversify_1.inject(browser_1.ApplicationShell),
        __metadata("design:type", browser_1.ApplicationShell)
    ], FileSystemFrontendContribution.prototype, "shell", void 0);
    __decorate([
        inversify_1.inject(browser_1.WidgetManager),
        __metadata("design:type", browser_1.WidgetManager)
    ], FileSystemFrontendContribution.prototype, "widgetManager", void 0);
    __decorate([
        inversify_1.inject(filesystem_watcher_1.FileSystemWatcher),
        __metadata("design:type", filesystem_watcher_1.FileSystemWatcher)
    ], FileSystemFrontendContribution.prototype, "fileSystemWatcher", void 0);
    FileSystemFrontendContribution = __decorate([
        inversify_1.injectable()
    ], FileSystemFrontendContribution);
    return FileSystemFrontendContribution;
}());
exports.FileSystemFrontendContribution = FileSystemFrontendContribution;


/***/ }),

/***/ "../node_modules/@theia/filesystem/lib/browser/filesystem-frontend-module.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/@theia/filesystem/lib/browser/filesystem-frontend-module.js ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2017-2018 TypeFox and others.
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var common_2 = __webpack_require__(/*! ../common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var filesystem_watcher_protocol_1 = __webpack_require__(/*! ../common/filesystem-watcher-protocol */ "../node_modules/@theia/filesystem/lib/common/filesystem-watcher-protocol.js");
var file_resource_1 = __webpack_require__(/*! ./file-resource */ "../node_modules/@theia/filesystem/lib/browser/file-resource.js");
var filesystem_preferences_1 = __webpack_require__(/*! ./filesystem-preferences */ "../node_modules/@theia/filesystem/lib/browser/filesystem-preferences.js");
var filesystem_watcher_1 = __webpack_require__(/*! ./filesystem-watcher */ "../node_modules/@theia/filesystem/lib/browser/filesystem-watcher.js");
var filesystem_frontend_contribution_1 = __webpack_require__(/*! ./filesystem-frontend-contribution */ "../node_modules/@theia/filesystem/lib/browser/filesystem-frontend-contribution.js");
__webpack_require__(/*! ../../src/browser/style/index.css */ "../node_modules/@theia/filesystem/src/browser/style/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    filesystem_preferences_1.bindFileSystemPreferences(bind);
    bind(filesystem_watcher_protocol_1.FileSystemWatcherServerProxy).toDynamicValue(function (ctx) {
        return browser_1.WebSocketConnectionProvider.createProxy(ctx.container, filesystem_watcher_protocol_1.fileSystemWatcherPath);
    });
    bind(filesystem_watcher_protocol_1.FileSystemWatcherServer).to(filesystem_watcher_protocol_1.ReconnectingFileSystemWatcherServer);
    bind(filesystem_watcher_1.FileSystemWatcher).toSelf().inSingletonScope();
    bind(common_2.FileShouldOverwrite).toFunction(function (file, stat) {
        return __awaiter(this, void 0, void 0, function () {
            var dialog;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        dialog = new browser_1.ConfirmDialog({
                            title: "The file '" + file.uri + "' has been changed on the file system.",
                            msg: 'Do you want to overwrite the changes made on the file system?',
                            ok: 'Yes',
                            cancel: 'No'
                        });
                        return [4 /*yield*/, dialog.open()];
                    case 1: return [2 /*return*/, !!(_a.sent())];
                }
            });
        });
    });
    bind(common_2.FileSystem).toDynamicValue(function (ctx) {
        return browser_1.WebSocketConnectionProvider.createProxy(ctx.container, common_2.fileSystemPath);
    }).inSingletonScope();
    bind(file_resource_1.FileResourceResolver).toSelf().inSingletonScope();
    bind(common_1.ResourceResolver).toDynamicValue(function (ctx) { return ctx.container.get(file_resource_1.FileResourceResolver); });
    bind(browser_1.FrontendApplicationContribution).to(filesystem_frontend_contribution_1.FileSystemFrontendContribution).inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/filesystem/src/browser/style/index.css":
/*!*********************************************************************!*\
  !*** ../node_modules/@theia/filesystem/src/browser/style/index.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/file-dialog.css":
/*!******************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/filesystem/src/browser/style/file-dialog.css ***!
  \******************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n /*\n  * Open and Save file dialogs\n  */\n\n.dialogContent .theia-FileDialog,\n.dialogContent .theia-SaveFileDialog {\n    width: 500px;\n}\n\n.dialogContent .theia-FileDialog {\n    height: 500px;\n}\n\n.dialogContent .theia-SaveFileDialog {\n    height: 450px;\n}\n\n.dialogContent .theia-NavigationPanel,\n.dialogContent .theia-FiltersPanel,\n.dialogContent .theia-FileNamePanel {\n    display: block;\n    position: relative;\n    overflow: hidden;\n}\n\n.dialogContent .theia-NavigationPanel,\n.dialogContent .theia-FiltersPanel {\n    height: 27px;\n}\n\n.dialogContent .theia-FileNamePanel {\n    height: 31px;\n}\n\n/*\n * Navigation panel items\n */\n\n.dialogContent .theia-NavigationBack,\n.dialogContent .theia-NavigationForward,\n.dialogContent .theia-NavigationHome {\n    position: absolute;\n    top: 0px;\n    line-height: 23px;\n    cursor: pointer;\n    outline: none;\n}\n\n.dialogContent .theia-NavigationBack:focus,\n.dialogContent .theia-NavigationForward:focus,\n.dialogContent .theia-NavigationHome:focus {\n    outline: none;\n    border: none;\n    box-shadow: none;\n}\n\n.dialogContent .theia-NavigationBack {\n    left: auto;\n}\n\n.dialogContent .theia-NavigationForward {\n    left: 21px;\n}\n\n.dialogContent .theia-NavigationHome {\n    left: 41px;\n}\n\n.dialogContent .theia-LocationListPanel {\n    position: absolute;\n    left: 72px;\n    top: 1px;\n}\n\n.dialogContent .theia-LocationList {\n    width: 427px;\n    height: 21px;\n    background: var(--theia-layout-color2)!important;\n}\n\n/*\n * Filters panel items\n */\n\n.dialogContent .theia-FiltersLabel {\n    position: absolute;\n    left: 1px;\n    top: 0px;\n    line-height: 27px;\n}\n\n.dialogContent .theia-FiltersListPanel {\n    position: absolute;\n    left: 72px;\n    top: 3px;\n}\n\n.dialogContent .theia-FileTreeFiltersList {\n    width: 427px;\n    height: 21px;\n    background: var(--theia-layout-color2)!important;\n}\n\n/*\n * File name panel items\n */\n\n.dialogContent .theia-FileNameLabel {\n    position: absolute;\n    left: 1px;\n    top: 0px;\n    line-height: 23px;\n}\n\n.dialogContent .theia-FileNameTextField {\n    position: absolute;\n    left: 72px;\n    top: 0px;\n    width: 420px;\n}\n\n/*\n * Control panel items\n */\n\n.dialogContent .theia-ControlPanel {\n    display: flex;\n    flex-direction: row;\n    justify-content: flex-end;\n    margin-bottom: 0px;\n}\n\n.dialogContent .theia-ControlPanel > * {\n    margin-left: 4px;\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/file-icons.css":
/*!*****************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/filesystem/src/browser/style/file-icons.css ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.file-icon {\n    max-height: calc(var(--theia-content-font-size) * 0.8);\n    /*\n    Here, the `line-height` ensures that FontAwesome and `file-icons-js` container has the same height.\n    Ideally, it would be 1 em, but since we set the max height above (and other places too) with 0.8\n    multiplier, we use 0.8 em here too.\n     */\n    line-height: 0.8em;\n}\n\n.file-icon:before {\n    font-size: calc(var(--theia-content-font-size) * 0.8);\n    text-align: center;\n    margin-right: 4px;\n}", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/index.css":
/*!************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/filesystem/src/browser/style/index.css ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports
exports.i(__webpack_require__(/*! -!../../../../../css-loader!./file-dialog.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/file-dialog.css"), "");
exports.i(__webpack_require__(/*! -!../../../../../css-loader!./file-icons.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/filesystem/src/browser/style/file-icons.css"), "");

// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2017 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=32.bundle.js.map