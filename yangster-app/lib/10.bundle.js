(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[10],{

/***/ "../node_modules/@theia/editor/lib/browser/editor-command.js":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-command.js ***!
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/languages/lib/browser */ "../node_modules/@theia/languages/lib/browser/index.js");
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var EditorCommands;
(function (EditorCommands) {
    var EDITOR_CATEGORY = 'Editor';
    /**
     * Show editor references
     */
    EditorCommands.SHOW_REFERENCES = {
        id: 'textEditor.commands.showReferences'
    };
    /**
     * Change indentation configuration (i.e., indent using tabs / spaces, and how many spaces per tab)
     */
    EditorCommands.CONFIG_INDENTATION = {
        id: 'textEditor.commands.configIndentation'
    };
    EditorCommands.INDENT_USING_SPACES = {
        id: 'textEditor.commands.indentUsingSpaces',
        category: EDITOR_CATEGORY,
        label: 'Indent Using Spaces'
    };
    EditorCommands.INDENT_USING_TABS = {
        id: 'textEditor.commands.indentUsingTabs',
        category: EDITOR_CATEGORY,
        label: 'Indent Using Tabs'
    };
    EditorCommands.CHANGE_LANGUAGE = {
        id: 'textEditor.change.language',
        category: EDITOR_CATEGORY,
        label: 'Change Language Mode'
    };
    /**
     * Command for going back to the last editor navigation location.
     */
    EditorCommands.GO_BACK = {
        id: 'textEditor.commands.go.back',
        category: EDITOR_CATEGORY,
        label: 'Go Back'
    };
    /**
     * Command for going to the forthcoming editor navigation location.
     */
    EditorCommands.GO_FORWARD = {
        id: 'textEditor.commands.go.forward',
        category: EDITOR_CATEGORY,
        label: 'Go Forward'
    };
    /**
     * Command that reveals the last text edit location, if any.
     */
    EditorCommands.GO_LAST_EDIT = {
        id: 'textEditor.commands.go.lastEdit',
        category: EDITOR_CATEGORY,
        label: 'Go to Last Edit Location'
    };
})(EditorCommands = exports.EditorCommands || (exports.EditorCommands = {}));
var EditorCommandContribution = /** @class */ (function () {
    function EditorCommandContribution() {
    }
    EditorCommandContribution_1 = EditorCommandContribution;
    EditorCommandContribution.prototype.registerCommands = function (registry) {
        var _this = this;
        registry.registerCommand(EditorCommands.SHOW_REFERENCES);
        registry.registerCommand(EditorCommands.CONFIG_INDENTATION);
        registry.registerCommand(EditorCommands.INDENT_USING_SPACES);
        registry.registerCommand(EditorCommands.INDENT_USING_TABS);
        registry.registerCommand(EditorCommands.CHANGE_LANGUAGE, {
            isEnabled: function () { return _this.canConfigureLanguage(); },
            isVisible: function () { return _this.canConfigureLanguage(); },
            execute: function () { return _this.configureLanguage(); }
        });
        registry.registerCommand(EditorCommands.GO_BACK);
        registry.registerCommand(EditorCommands.GO_FORWARD);
        registry.registerCommand(EditorCommands.GO_LAST_EDIT);
        registry.registerCommand(browser_1.CommonCommands.AUTO_SAVE, {
            isToggled: function () { return _this.isAutoSaveOn(); },
            execute: function () { return _this.toggleAutoSave(); }
        });
    };
    EditorCommandContribution.prototype.canConfigureLanguage = function () {
        var widget = this.editorManager.currentEditor;
        var editor = widget && widget.editor;
        return !!editor && !!this.languages.languages;
    };
    EditorCommandContribution.prototype.configureLanguage = function () {
        return __awaiter(this, void 0, void 0, function () {
            var widget, editor, current, items, _a, selected;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        widget = this.editorManager.currentEditor;
                        editor = widget && widget.editor;
                        if (!editor || !this.languages.languages) {
                            return [2 /*return*/];
                        }
                        current = editor.document.languageId;
                        _a = [[
                                { label: 'Auto Detect', value: 'autoDetect' },
                                { type: 'separator', label: 'languages (identifier)' }
                            ]];
                        return [4 /*yield*/, Promise.all(this.languages.languages.map(function (language) { return _this.toQuickPickLanguage(language, current); }))];
                    case 1:
                        items = __spread.apply(void 0, _a.concat([(_b.sent()).sort(function (e, e2) { return e.label.localeCompare(e2.label); })]));
                        return [4 /*yield*/, this.quickPick.show(items, {
                                placeholder: 'Select Language Mode'
                            })];
                    case 2:
                        selected = _b.sent();
                        if (selected === 'autoDetect') {
                            editor.detectLanguage();
                        }
                        else if (selected) {
                            editor.setLanguage(selected.id);
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    EditorCommandContribution.prototype.toQuickPickLanguage = function (value, current) {
        return __awaiter(this, void 0, void 0, function () {
            var languageUri, iconClass;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        languageUri = this.toLanguageUri(value);
                        return [4 /*yield*/, this.labelProvider.getIcon(languageUri)];
                    case 1:
                        iconClass = (_a.sent()) + ' file-icon';
                        return [2 /*return*/, {
                                value: value,
                                label: value.name,
                                description: "(" + value.id + ")" + (current === value.id ? ' - Configured Language' : ''),
                                iconClass: iconClass
                            }];
                }
            });
        });
    };
    EditorCommandContribution.prototype.toLanguageUri = function (language) {
        var extension = language.extensions.values().next();
        if (extension.value) {
            return new uri_1.default('file:///' + extension.value);
        }
        var filename = language.filenames.values().next();
        if (filename.value) {
            return new uri_1.default('file:///' + filename.value);
        }
        return new uri_1.default('file:///.txt');
    };
    EditorCommandContribution.prototype.isAutoSaveOn = function () {
        var autoSave = this.preferencesService.get(EditorCommandContribution_1.AUTOSAVE_PREFERENCE);
        return autoSave === 'on' || autoSave === undefined;
    };
    EditorCommandContribution.prototype.toggleAutoSave = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.preferencesService.set(EditorCommandContribution_1.AUTOSAVE_PREFERENCE, this.isAutoSaveOn() ? 'off' : 'on');
                return [2 /*return*/];
            });
        });
    };
    var EditorCommandContribution_1;
    EditorCommandContribution.AUTOSAVE_PREFERENCE = 'editor.autoSave';
    __decorate([
        inversify_1.inject(browser_1.PreferenceService),
        __metadata("design:type", Object)
    ], EditorCommandContribution.prototype, "preferencesService", void 0);
    __decorate([
        inversify_1.inject(browser_1.QuickPickService),
        __metadata("design:type", browser_1.QuickPickService)
    ], EditorCommandContribution.prototype, "quickPick", void 0);
    __decorate([
        inversify_1.inject(browser_1.LabelProvider),
        __metadata("design:type", browser_1.LabelProvider)
    ], EditorCommandContribution.prototype, "labelProvider", void 0);
    __decorate([
        inversify_1.inject(browser_2.Languages),
        __metadata("design:type", Object)
    ], EditorCommandContribution.prototype, "languages", void 0);
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], EditorCommandContribution.prototype, "editorManager", void 0);
    EditorCommandContribution = EditorCommandContribution_1 = __decorate([
        inversify_1.injectable()
    ], EditorCommandContribution);
    return EditorCommandContribution;
}());
exports.EditorCommandContribution = EditorCommandContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-contribution.js":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-contribution.js ***!
  \************************************************************************/
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
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var status_bar_1 = __webpack_require__(/*! @theia/core/lib/browser/status-bar/status-bar */ "../node_modules/@theia/core/lib/browser/status-bar/status-bar.js");
var browser_1 = __webpack_require__(/*! @theia/languages/lib/browser */ "../node_modules/@theia/languages/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var editor_command_1 = __webpack_require__(/*! ./editor-command */ "../node_modules/@theia/editor/lib/browser/editor-command.js");
var EditorContribution = /** @class */ (function () {
    function EditorContribution() {
        this.toDisposeOnCurrentEditorChanged = new core_1.DisposableCollection();
    }
    EditorContribution.prototype.onStart = function () {
        var _this = this;
        this.updateStatusBar();
        this.editorManager.onCurrentEditorChanged(function () { return _this.updateStatusBar(); });
    };
    EditorContribution.prototype.updateStatusBar = function () {
        var _this = this;
        this.toDisposeOnCurrentEditorChanged.dispose();
        var widget = this.editorManager.currentEditor;
        var editor = widget && widget.editor;
        this.updateLanguageStatus(editor);
        this.setCursorPositionStatus(editor);
        if (editor) {
            this.toDisposeOnCurrentEditorChanged.pushAll([
                editor.onLanguageChanged(function () { return _this.updateLanguageStatus(editor); }),
                editor.onCursorPositionChanged(function () { return _this.setCursorPositionStatus(editor); })
            ]);
        }
    };
    EditorContribution.prototype.updateLanguageStatus = function (editor) {
        if (!editor) {
            this.statusBar.removeElement('editor-status-language');
            return;
        }
        var language = this.languages.getLanguage && this.languages.getLanguage(editor.document.languageId);
        var languageName = language ? language.name : '';
        this.statusBar.setElement('editor-status-language', {
            text: languageName,
            alignment: status_bar_1.StatusBarAlignment.RIGHT,
            priority: 1,
            command: editor_command_1.EditorCommands.CHANGE_LANGUAGE.id
        });
    };
    EditorContribution.prototype.setCursorPositionStatus = function (editor) {
        if (!editor) {
            this.statusBar.removeElement('editor-status-cursor-position');
            return;
        }
        var cursor = editor.cursor;
        this.statusBar.setElement('editor-status-cursor-position', {
            text: "Ln " + (cursor.line + 1) + ", Col " + editor.getVisibleColumn(cursor),
            alignment: status_bar_1.StatusBarAlignment.RIGHT,
            priority: 100
        });
    };
    __decorate([
        inversify_1.inject(status_bar_1.StatusBar),
        __metadata("design:type", Object)
    ], EditorContribution.prototype, "statusBar", void 0);
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], EditorContribution.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(browser_1.Languages),
        __metadata("design:type", Object)
    ], EditorContribution.prototype, "languages", void 0);
    EditorContribution = __decorate([
        inversify_1.injectable()
    ], EditorContribution);
    return EditorContribution;
}());
exports.EditorContribution = EditorContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-frontend-module.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-frontend-module.js ***!
  \***************************************************************************/
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/variable-resolver/lib/browser */ "../node_modules/@theia/variable-resolver/lib/browser/index.js");
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var editor_contribution_1 = __webpack_require__(/*! ./editor-contribution */ "../node_modules/@theia/editor/lib/browser/editor-contribution.js");
var editor_menu_1 = __webpack_require__(/*! ./editor-menu */ "../node_modules/@theia/editor/lib/browser/editor-menu.js");
var editor_command_1 = __webpack_require__(/*! ./editor-command */ "../node_modules/@theia/editor/lib/browser/editor-command.js");
var editor_keybinding_contexts_1 = __webpack_require__(/*! ./editor-keybinding-contexts */ "../node_modules/@theia/editor/lib/browser/editor-keybinding-contexts.js");
var editor_keybinding_1 = __webpack_require__(/*! ./editor-keybinding */ "../node_modules/@theia/editor/lib/browser/editor-keybinding.js");
var editor_preferences_1 = __webpack_require__(/*! ./editor-preferences */ "../node_modules/@theia/editor/lib/browser/editor-preferences.js");
var editor_widget_factory_1 = __webpack_require__(/*! ./editor-widget-factory */ "../node_modules/@theia/editor/lib/browser/editor-widget-factory.js");
var editor_navigation_contribution_1 = __webpack_require__(/*! ./editor-navigation-contribution */ "../node_modules/@theia/editor/lib/browser/editor-navigation-contribution.js");
var navigation_location_updater_1 = __webpack_require__(/*! ./navigation/navigation-location-updater */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location-updater.js");
var navigation_location_service_1 = __webpack_require__(/*! ./navigation/navigation-location-service */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location-service.js");
var navigation_location_similarity_1 = __webpack_require__(/*! ./navigation/navigation-location-similarity */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location-similarity.js");
var editor_variable_contribution_1 = __webpack_require__(/*! ./editor-variable-contribution */ "../node_modules/@theia/editor/lib/browser/editor-variable-contribution.js");
var semantic_highlighting_service_1 = __webpack_require__(/*! ./semantic-highlight/semantic-highlighting-service */ "../node_modules/@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    editor_preferences_1.bindEditorPreferences(bind);
    bind(browser_1.WidgetFactory).to(editor_widget_factory_1.EditorWidgetFactory).inSingletonScope();
    bind(editor_manager_1.EditorManager).toSelf().inSingletonScope();
    bind(browser_1.OpenHandler).toService(editor_manager_1.EditorManager);
    bind(common_1.CommandContribution).to(editor_command_1.EditorCommandContribution).inSingletonScope();
    bind(common_1.MenuContribution).to(editor_menu_1.EditorMenuContribution).inSingletonScope();
    bind(editor_keybinding_contexts_1.StrictEditorTextFocusContext).toSelf().inSingletonScope();
    bind(browser_1.KeybindingContext).toService(editor_keybinding_contexts_1.StrictEditorTextFocusContext);
    bind(browser_1.KeybindingContext).to(editor_keybinding_contexts_1.EditorTextFocusContext).inSingletonScope();
    bind(browser_1.KeybindingContribution).to(editor_keybinding_1.EditorKeybindingContribution).inSingletonScope();
    bind(editor_contribution_1.EditorContribution).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(editor_contribution_1.EditorContribution);
    bind(editor_navigation_contribution_1.EditorNavigationContribution).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(editor_navigation_contribution_1.EditorNavigationContribution);
    bind(navigation_location_service_1.NavigationLocationService).toSelf().inSingletonScope();
    bind(navigation_location_updater_1.NavigationLocationUpdater).toSelf().inSingletonScope();
    bind(navigation_location_similarity_1.NavigationLocationSimilarity).toSelf().inSingletonScope();
    bind(browser_2.VariableContribution).to(editor_variable_contribution_1.EditorVariableContribution).inSingletonScope();
    bind(semantic_highlighting_service_1.SemanticHighlightingService).toSelf().inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-keybinding-contexts.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-keybinding-contexts.js ***!
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var EditorKeybindingContexts;
(function (EditorKeybindingContexts) {
    /**
     * ID of a keybinding context that is enabled when the active text editor has the focus.
     */
    EditorKeybindingContexts.editorTextFocus = 'editorTextFocus';
    /**
     * Unique identifier of a keybinding context that is enabled if the active editor has the focus but it does not have any overlaying widgets, such as the content assist widget.
     */
    EditorKeybindingContexts.strictEditorTextFocus = 'strictEditorTextFocus';
})(EditorKeybindingContexts = exports.EditorKeybindingContexts || (exports.EditorKeybindingContexts = {}));
var EditorTextFocusContext = /** @class */ (function () {
    function EditorTextFocusContext() {
        this.id = EditorKeybindingContexts.editorTextFocus;
    }
    EditorTextFocusContext.prototype.isEnabled = function () {
        return !!this.getEditor();
    };
    EditorTextFocusContext.prototype.getEditor = function () {
        var widget = this.editorManager.activeEditor;
        if (widget && this.canHandle(widget)) {
            return widget;
        }
        return undefined;
    };
    EditorTextFocusContext.prototype.canHandle = function (widget) {
        return widget.editor.isFocused();
    };
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], EditorTextFocusContext.prototype, "editorManager", void 0);
    EditorTextFocusContext = __decorate([
        inversify_1.injectable()
    ], EditorTextFocusContext);
    return EditorTextFocusContext;
}());
exports.EditorTextFocusContext = EditorTextFocusContext;
/**
 * Keybinding context that is enabled when the active text editor has the focus **AND** it does not
 * have any widgets (for example, the content assist widget) overlaying the active editor.
 */
var StrictEditorTextFocusContext = /** @class */ (function (_super) {
    __extends(StrictEditorTextFocusContext, _super);
    function StrictEditorTextFocusContext() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.id = EditorKeybindingContexts.strictEditorTextFocus;
        return _this;
    }
    StrictEditorTextFocusContext = __decorate([
        inversify_1.injectable()
    ], StrictEditorTextFocusContext);
    return StrictEditorTextFocusContext;
}(EditorTextFocusContext));
exports.StrictEditorTextFocusContext = StrictEditorTextFocusContext;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-keybinding.js":
/*!**********************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-keybinding.js ***!
  \**********************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var os_1 = __webpack_require__(/*! @theia/core/lib/common/os */ "../node_modules/@theia/core/lib/common/os.js");
var editor_command_1 = __webpack_require__(/*! ./editor-command */ "../node_modules/@theia/editor/lib/browser/editor-command.js");
var EditorKeybindingContribution = /** @class */ (function () {
    function EditorKeybindingContribution() {
    }
    EditorKeybindingContribution.prototype.registerKeybindings = function (registry) {
        registry.registerKeybindings({
            command: editor_command_1.EditorCommands.GO_BACK.id,
            keybinding: os_1.isOSX ? 'ctrl+-' : os_1.isWindows ? 'alt+left' : /*isLinux*/ 'ctrl+alt+-'
        }, {
            command: editor_command_1.EditorCommands.GO_FORWARD.id,
            keybinding: os_1.isOSX ? 'ctrl+shift+-' : os_1.isWindows ? 'alt+right' : /*isLinux*/ 'ctrl+shift+-'
        }, {
            command: editor_command_1.EditorCommands.GO_LAST_EDIT.id,
            keybinding: 'ctrl+alt+q'
        });
    };
    EditorKeybindingContribution = __decorate([
        inversify_1.injectable()
    ], EditorKeybindingContribution);
    return EditorKeybindingContribution;
}());
exports.EditorKeybindingContribution = EditorKeybindingContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-manager.js":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-manager.js ***!
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var editor_widget_1 = __webpack_require__(/*! ./editor-widget */ "../node_modules/@theia/editor/lib/browser/editor-widget.js");
var editor_1 = __webpack_require__(/*! ./editor */ "../node_modules/@theia/editor/lib/browser/editor.js");
var editor_widget_factory_1 = __webpack_require__(/*! ./editor-widget-factory */ "../node_modules/@theia/editor/lib/browser/editor-widget-factory.js");
var EditorManager = /** @class */ (function (_super) {
    __extends(EditorManager, _super);
    function EditorManager() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.id = editor_widget_factory_1.EditorWidgetFactory.ID;
        _this.label = 'Code Editor';
        _this.onActiveEditorChangedEmitter = new common_1.Emitter();
        /**
         * Emit when the active editor is changed.
         */
        _this.onActiveEditorChanged = _this.onActiveEditorChangedEmitter.event;
        _this.onCurrentEditorChangedEmitter = new common_1.Emitter();
        /**
         * Emit when the current editor is changed.
         */
        _this.onCurrentEditorChanged = _this.onCurrentEditorChangedEmitter.event;
        return _this;
    }
    EditorManager.prototype.init = function () {
        var _this = this;
        _super.prototype.init.call(this);
        this.shell.activeChanged.connect(function () { return _this.updateActiveEditor(); });
        this.shell.currentChanged.connect(function () { return _this.updateCurrentEditor(); });
        this.onCreated(function (widget) { return widget.disposed.connect(function () { return _this.updateCurrentEditor(); }); });
    };
    Object.defineProperty(EditorManager.prototype, "activeEditor", {
        /**
         * The active editor.
         * If there is an active editor (one that has focus), active and current are the same.
         */
        get: function () {
            return this._activeEditor;
        },
        enumerable: true,
        configurable: true
    });
    EditorManager.prototype.setActiveEditor = function (active) {
        if (this._activeEditor !== active) {
            this._activeEditor = active;
            this.onActiveEditorChangedEmitter.fire(this._activeEditor);
        }
    };
    EditorManager.prototype.updateActiveEditor = function () {
        var widget = this.shell.activeWidget;
        this.setActiveEditor(widget instanceof editor_widget_1.EditorWidget ? widget : undefined);
    };
    Object.defineProperty(EditorManager.prototype, "currentEditor", {
        /**
         * The most recently activated editor (which might not have the focus anymore, hence it is not active).
         * If no editor has focus, e.g. when a context menu is shown, the active editor is `undefined`, but current might be the editor that was active before the menu popped up.
         */
        get: function () {
            return this._currentEditor;
        },
        enumerable: true,
        configurable: true
    });
    EditorManager.prototype.setCurrentEditor = function (current) {
        if (this._currentEditor !== current) {
            this._currentEditor = current;
            this.onCurrentEditorChangedEmitter.fire(this._currentEditor);
        }
    };
    EditorManager.prototype.updateCurrentEditor = function () {
        var widget = this.shell.currentWidget;
        if (widget instanceof editor_widget_1.EditorWidget) {
            this.setCurrentEditor(widget);
        }
        else if (!this._currentEditor || !this._currentEditor.isVisible) {
            this.setCurrentEditor(undefined);
        }
    };
    EditorManager.prototype.canHandle = function (uri, options) {
        return 100;
    };
    EditorManager.prototype.open = function (uri, options) {
        return __awaiter(this, void 0, void 0, function () {
            var editor;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, _super.prototype.open.call(this, uri, options)];
                    case 1:
                        editor = _a.sent();
                        this.revealSelection(editor, options);
                        return [2 /*return*/, editor];
                }
            });
        });
    };
    EditorManager.prototype.revealSelection = function (widget, input) {
        if (input && input.selection) {
            var editor = widget.editor;
            var selection = this.getSelection(widget, input.selection);
            if (editor_1.Position.is(selection)) {
                editor.cursor = selection;
                editor.revealPosition(selection);
            }
            else if (editor_1.Range.is(selection)) {
                editor.cursor = selection.end;
                editor.selection = selection;
                editor.revealRange(selection);
            }
        }
    };
    EditorManager.prototype.getSelection = function (widget, selection) {
        var start = selection.start, end = selection.end;
        var line = start && start.line !== undefined && start.line >= 0 ? start.line : undefined;
        if (line === undefined) {
            return undefined;
        }
        var character = start && start.character !== undefined && start.character >= 0 ? start.character : widget.editor.document.getLineMaxColumn(line);
        var endLine = end && end.line !== undefined && end.line >= 0 ? end.line : undefined;
        if (endLine === undefined) {
            return { line: line, character: character };
        }
        var endCharacter = end && end.character !== undefined && end.character >= 0 ? end.character : widget.editor.document.getLineMaxColumn(endLine);
        return {
            start: { line: line, character: character },
            end: { line: endLine, character: endCharacter }
        };
    };
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], EditorManager.prototype, "init", null);
    EditorManager = __decorate([
        inversify_1.injectable()
    ], EditorManager);
    return EditorManager;
}(browser_1.NavigatableWidgetOpenHandler));
exports.EditorManager = EditorManager;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-menu.js":
/*!****************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-menu.js ***!
  \****************************************************************/
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var editor_command_1 = __webpack_require__(/*! ./editor-command */ "../node_modules/@theia/editor/lib/browser/editor-command.js");
exports.EDITOR_CONTEXT_MENU = ['editor_context_menu'];
var EditorContextMenu;
(function (EditorContextMenu) {
    EditorContextMenu.UNDO_REDO = __spread(exports.EDITOR_CONTEXT_MENU, ['1_undo']);
    EditorContextMenu.CUT_COPY_PASTE = __spread(exports.EDITOR_CONTEXT_MENU, ['2_cut_copy_paste']);
    EditorContextMenu.NAVIGATION = __spread(exports.EDITOR_CONTEXT_MENU, ['navigation']);
})(EditorContextMenu = exports.EditorContextMenu || (exports.EditorContextMenu = {}));
var EditorMainMenu;
(function (EditorMainMenu) {
    /**
     * The main `Go` menu item.
     */
    EditorMainMenu.GO = __spread(core_1.MAIN_MENU_BAR, ['5_go']);
    /**
     * Navigation menu group in the `Go` menu.
     */
    EditorMainMenu.NAVIGATION_GROUP = __spread(EditorMainMenu.GO, ['1_navigation_group']);
})(EditorMainMenu = exports.EditorMainMenu || (exports.EditorMainMenu = {}));
var EditorMenuContribution = /** @class */ (function () {
    function EditorMenuContribution() {
    }
    EditorMenuContribution.prototype.registerMenus = function (registry) {
        registry.registerMenuAction(EditorContextMenu.UNDO_REDO, {
            commandId: browser_1.CommonCommands.UNDO.id
        });
        registry.registerMenuAction(EditorContextMenu.UNDO_REDO, {
            commandId: browser_1.CommonCommands.REDO.id
        });
        registry.registerMenuAction(EditorContextMenu.CUT_COPY_PASTE, {
            commandId: browser_1.CommonCommands.CUT.id,
            order: '0'
        });
        registry.registerMenuAction(EditorContextMenu.CUT_COPY_PASTE, {
            commandId: browser_1.CommonCommands.COPY.id,
            order: '1'
        });
        registry.registerMenuAction(EditorContextMenu.CUT_COPY_PASTE, {
            commandId: browser_1.CommonCommands.PASTE.id,
            order: '2'
        });
        // Editor navigation. Go > Back and Go > Forward.
        registry.registerSubmenu(EditorMainMenu.GO, 'Go');
        registry.registerMenuAction(EditorMainMenu.NAVIGATION_GROUP, {
            commandId: editor_command_1.EditorCommands.GO_BACK.id,
            label: 'Back'
        });
        registry.registerMenuAction(EditorMainMenu.NAVIGATION_GROUP, {
            commandId: editor_command_1.EditorCommands.GO_FORWARD.id,
            label: 'Forward'
        });
        registry.registerMenuAction(EditorMainMenu.NAVIGATION_GROUP, {
            commandId: editor_command_1.EditorCommands.GO_LAST_EDIT.id,
            label: 'Last Edit Location'
        });
    };
    EditorMenuContribution = __decorate([
        inversify_1.injectable()
    ], EditorMenuContribution);
    return EditorMenuContribution;
}());
exports.EditorMenuContribution = EditorMenuContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-navigation-contribution.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-navigation-contribution.js ***!
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
var logger_1 = __webpack_require__(/*! @theia/core/lib/common/logger */ "../node_modules/@theia/core/lib/common/logger.js");
var storage_service_1 = __webpack_require__(/*! @theia/core/lib/browser/storage-service */ "../node_modules/@theia/core/lib/browser/storage-service.js");
var disposable_1 = __webpack_require__(/*! @theia/core/lib/common/disposable */ "../node_modules/@theia/core/lib/common/disposable.js");
var command_1 = __webpack_require__(/*! @theia/core/lib/common/command */ "../node_modules/@theia/core/lib/common/command.js");
var editor_command_1 = __webpack_require__(/*! ./editor-command */ "../node_modules/@theia/editor/lib/browser/editor-command.js");
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var navigation_location_1 = __webpack_require__(/*! ./navigation/navigation-location */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location.js");
var navigation_location_service_1 = __webpack_require__(/*! ./navigation/navigation-location-service */ "../node_modules/@theia/editor/lib/browser/navigation/navigation-location-service.js");
var EditorNavigationContribution = /** @class */ (function () {
    function EditorNavigationContribution() {
        this.toDispose = new disposable_1.DisposableCollection();
        this.toDisposePerCurrentEditor = new disposable_1.DisposableCollection();
    }
    EditorNavigationContribution_1 = EditorNavigationContribution;
    EditorNavigationContribution.prototype.init = function () {
        var _this = this;
        this.toDispose.pushAll([
            // TODO listen on file resource changes, if a file gets deleted, remove the corresponding navigation locations (if any).
            // This would require introducing the FS dependency in the editor extension.
            this.editorManager.onCurrentEditorChanged(this.onCurrentEditorChanged.bind(this))
        ]);
        this.commandRegistry.registerHandler(editor_command_1.EditorCommands.GO_BACK.id, {
            execute: function () { return _this.locationStack.back(); },
            isEnabled: function () { return _this.locationStack.canGoBack(); }
        });
        this.commandRegistry.registerHandler(editor_command_1.EditorCommands.GO_FORWARD.id, {
            execute: function () { return _this.locationStack.forward(); },
            isEnabled: function () { return _this.locationStack.canGoForward(); }
        });
        this.commandRegistry.registerHandler(editor_command_1.EditorCommands.GO_LAST_EDIT.id, {
            execute: function () { return _this.locationStack.reveal(_this.locationStack.lastEditLocation()); },
            isEnabled: function () { return !!_this.locationStack.lastEditLocation(); }
        });
    };
    EditorNavigationContribution.prototype.onStart = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.restoreState()];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    EditorNavigationContribution.prototype.onStop = function () {
        this.storeState();
        this.dispose();
    };
    EditorNavigationContribution.prototype.dispose = function () {
        this.toDispose.dispose();
    };
    EditorNavigationContribution.prototype.onCurrentEditorChanged = function (editorWidget) {
        var _this = this;
        this.toDisposePerCurrentEditor.dispose();
        if (editorWidget) {
            var editor_1 = editorWidget.editor;
            this.toDisposePerCurrentEditor.pushAll([
                // Instead of registering an `onCursorPositionChanged` listener, we treat the zero length selection as a cursor position change.
                // Otherwise we would have two events for a single cursor change interaction.
                editor_1.onSelectionChanged(function (selection) { return _this.onSelectionChanged(editor_1, selection); }),
                editor_1.onDocumentContentChanged(function (event) { return _this.onDocumentContentChanged(editor_1, event); })
            ]);
        }
    };
    EditorNavigationContribution.prototype.onCursorPositionChanged = function (editor, position) {
        this.locationStack.register(navigation_location_1.NavigationLocation.create(editor, position));
    };
    EditorNavigationContribution.prototype.onSelectionChanged = function (editor, selection) {
        if (this.isZeroLengthRange(selection)) {
            this.onCursorPositionChanged(editor, selection.start);
        }
        else {
            this.locationStack.register(navigation_location_1.NavigationLocation.create(editor, selection));
        }
    };
    EditorNavigationContribution.prototype.onDocumentContentChanged = function (editor, event) {
        if (event.contentChanges.length > 0) {
            this.locationStack.register(navigation_location_1.NavigationLocation.create(editor, event.contentChanges[0]));
        }
    };
    /**
     * `true` if the `range` argument has zero length. In other words, the `start` and the `end` positions are the same. Otherwise, `false`.
     */
    EditorNavigationContribution.prototype.isZeroLengthRange = function (range) {
        var start = range.start, end = range.end;
        return start.line === end.line && start.character === end.character;
    };
    EditorNavigationContribution.prototype.storeState = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.storageService.setData(EditorNavigationContribution_1.ID, {
                    locations: this.locationStack.locations().map(navigation_location_1.NavigationLocation.toObject)
                });
                return [2 /*return*/];
            });
        });
    };
    EditorNavigationContribution.prototype.restoreState = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _a, raw, locations, i, location_1;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0: return [4 /*yield*/, this.storageService.getData(EditorNavigationContribution_1.ID)];
                    case 1:
                        raw = _b.sent();
                        if (raw && raw.locations) {
                            locations = [];
                            for (i = 0; i < raw.locations.length; i++) {
                                location_1 = navigation_location_1.NavigationLocation.fromObject(raw.locations[i]);
                                if (location_1) {
                                    locations.push(location_1);
                                }
                                else {
                                    this.logger.warn('Could not restore the state of the editor navigation history.');
                                    return [2 /*return*/];
                                }
                            }
                            (_a = this.locationStack).register.apply(_a, __spread(locations));
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    var EditorNavigationContribution_1;
    EditorNavigationContribution.ID = 'editor-navigation-contribution';
    __decorate([
        inversify_1.inject(logger_1.ILogger),
        __metadata("design:type", Object)
    ], EditorNavigationContribution.prototype, "logger", void 0);
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], EditorNavigationContribution.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(navigation_location_service_1.NavigationLocationService),
        __metadata("design:type", navigation_location_service_1.NavigationLocationService)
    ], EditorNavigationContribution.prototype, "locationStack", void 0);
    __decorate([
        inversify_1.inject(storage_service_1.StorageService),
        __metadata("design:type", Object)
    ], EditorNavigationContribution.prototype, "storageService", void 0);
    __decorate([
        inversify_1.inject(command_1.CommandRegistry),
        __metadata("design:type", command_1.CommandRegistry)
    ], EditorNavigationContribution.prototype, "commandRegistry", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], EditorNavigationContribution.prototype, "init", null);
    EditorNavigationContribution = EditorNavigationContribution_1 = __decorate([
        inversify_1.injectable()
    ], EditorNavigationContribution);
    return EditorNavigationContribution;
}());
exports.EditorNavigationContribution = EditorNavigationContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-preferences.js":
/*!***********************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-preferences.js ***!
  \***********************************************************************/
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
var preferences_1 = __webpack_require__(/*! @theia/core/lib/browser/preferences */ "../node_modules/@theia/core/lib/browser/preferences/index.js");
var os_1 = __webpack_require__(/*! @theia/core/lib/common/os */ "../node_modules/@theia/core/lib/common/os.js");
exports.editorPreferenceSchema = {
    'type': 'object',
    'properties': {
        'editor.tabSize': {
            'type': 'number',
            'minimum': 1,
            'default': 4,
            'description': 'Configure the tab size in the editor.'
        },
        'editor.fontSize': {
            'type': 'number',
            'default': (os_1.isOSX) ? 12 : 14,
            'description': 'Configure the editor font size.'
        },
        'editor.lineNumbers': {
            'enum': [
                'on',
                'off',
                'relative',
                'interval'
            ],
            'default': 'on',
            'description': 'Control the rendering of line numbers.'
        },
        'editor.renderWhitespace': {
            'enum': [
                'none',
                'boundary',
                'all'
            ],
            'default': 'none',
            'description': 'Control the rendering of whitespaces in the editor.'
        },
        'editor.autoSave': {
            'enum': [
                'on',
                'off'
            ],
            'default': 'on',
            'description': 'Configure whether the editor should be auto saved.'
        },
        'editor.autoSaveDelay': {
            'type': 'number',
            'default': 500,
            'description': 'Configure the auto save delay in milliseconds.'
        },
        'editor.rulers': {
            'type': 'array',
            'default': [],
            'description': 'Render vertical lines at the specified columns.'
        },
        'editor.wordSeparators': {
            'type': 'string',
            'default': "`~!@#$%^&*()-=+[{]}\\|;:'\",.<>/",
            'description': 'A string containing the word separators used when doing word navigation.'
        },
        'editor.glyphMargin': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable the rendering of the glyph margin.'
        },
        'editor.roundedSelection': {
            'type': 'boolean',
            'default': true,
            'description': 'Render the editor selection with rounded borders.'
        },
        'editor.minimap.enabled': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable or disable the minimap.'
        },
        'editor.minimap.showSlider': {
            'enum': [
                'mouseover',
                'always'
            ],
            'default': 'mouseover',
            'description': 'Controls whether the minimap slider is automatically hidden.'
        },
        'editor.minimap.renderCharacters': {
            'type': 'boolean',
            'default': true,
            'description': 'Render the actual characters on a line (as opposed to color blocks).'
        },
        'editor.minimap.maxColumn': {
            'type': 'number',
            'default': 120,
            'description': 'Limit the width of the minimap to render at most a certain number of columns.'
        },
        'editor.minimap.side': {
            'enum': [
                'right',
                'left'
            ],
            'default': 'right',
            'description': 'Control the side of the minimap in editor.'
        },
        'editor.overviewRulerLanes': {
            'type': 'number',
            'default': 2,
            'description': 'The number of vertical lanes the overview ruler should render.'
        },
        'editor.overviewRulerBorder': {
            'type': 'boolean',
            'default': true,
            'description': 'Controls if a border should be drawn around the overview ruler.'
        },
        'editor.cursorBlinking': {
            'enum': [
                'blink',
                'smooth',
                'phase',
                'expand',
                'solid'
            ],
            'default': 'blink',
            'description': "Control the cursor animation style, possible values are 'blink', 'smooth', 'phase', 'expand' and 'solid'."
        },
        'editor.mouseWheelZoom': {
            'type': 'boolean',
            'default': false,
            'description': 'Zoom the font in the editor when using the mouse wheel in combination with holding Ctrl.'
        },
        'editor.cursorStyle': {
            'enum': [
                'line',
                'block'
            ],
            'default': 'line',
            'description': "Control the cursor style, either 'block' or 'line'."
        },
        'editor.fontLigatures': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable font ligatures.'
        },
        'editor.hideCursorInOverviewRuler': {
            'type': 'boolean',
            'default': false,
            'description': 'Should the cursor be hidden in the overview ruler.'
        },
        'editor.scrollBeyondLastLine': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable that scrolling can go one screen size after the last line.'
        },
        'editor.wordWrap': {
            'enum': [
                'off',
                'on',
                'wordWrapColumn',
                'bounded'
            ],
            'default': 'off',
            'description': 'Control the wrapping of the editor.'
        },
        'editor.wordWrapColumn': {
            'type': 'number',
            'default': 80,
            'description': 'Control the wrapping of the editor.'
        },
        'editor.wrappingIndent': {
            'enum': [
                'same',
                'indent',
                'deepIndent',
                'none'
            ],
            'default': 'same',
            'description': 'Control indentation of wrapped lines.'
        },
        'editor.links': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable detecting links and making them clickable.'
        },
        'editor.mouseWheelScrollSensitivity': {
            'type': 'number',
            'default': 1,
            'description': 'A multiplier to be used on the `deltaX` and `deltaY` of mouse wheel scroll events.'
        },
        'editor.multiCursorModifier': {
            'enum': [
                'alt',
                'ctrlCmd'
            ],
            'default': 'alt',
            'description': 'The modifier to be used to add multiple cursors with the mouse.'
        },
        'editor.accessibilitySupport': {
            'enum': [
                'auto',
                'on',
                'off'
            ],
            'default': 'auto',
            'description': "Configure the editor's accessibility support."
        },
        'editor.quickSuggestions': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable quick suggestions (shadow suggestions).'
        },
        'editor.quickSuggestionsDelay': {
            'type': 'number',
            'default': 500,
            'description': 'Quick suggestions show delay (in ms).'
        },
        'editor.parameterHints': {
            'type': 'boolean',
            'default': true,
            'description': 'Enables parameter hints.'
        },
        'editor.autoClosingBrackets': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable auto closing brackets.'
        },
        'editor.autoIndent': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable auto indentation adjustment.'
        },
        'editor.formatOnType': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable format on type.'
        },
        'editor.formatOnPaste': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable format on paste.'
        },
        'editor.dragAndDrop': {
            'type': 'boolean',
            'default': false,
            'description': 'Controls if the editor should allow to move selections via drag and drop.'
        },
        'editor.suggestOnTriggerCharacters': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable the suggestion box to pop-up on trigger characters.'
        },
        'editor.acceptSuggestionOnEnter': {
            'enum': [
                'on',
                'smart',
                'off'
            ],
            'default': 'on',
            'description': 'Accept suggestions on ENTER.'
        },
        'editor.acceptSuggestionOnCommitCharacter': {
            'type': 'boolean',
            'default': true,
            'description': 'Accept suggestions on provider defined characters.'
        },
        'editor.snippetSuggestions': {
            'enum': [
                'inline',
                'top',
                'bottom',
                'none'
            ],
            'default': 'inline',
            'description': 'Enable snippet suggestions.'
        },
        'editor.emptySelectionClipboard': {
            'type': 'boolean',
            'default': true,
            'description': 'Copying without a selection copies the current line.'
        },
        'editor.wordBasedSuggestions': {
            'type': 'boolean',
            'default': true,
            'description': "Enable word based suggestions. Defaults to 'true'."
        },
        'editor.selectionHighlight': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable selection highlight.'
        },
        'editor.occurrencesHighlight': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable semantic occurrences highlight.'
        },
        'editor.codeLens': {
            'type': 'boolean',
            'default': true,
            'description': 'Show code lens.'
        },
        'editor.folding': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable code folding.'
        },
        'editor.foldingStrategy': {
            'enum': [
                'auto',
                'indentation'
            ],
            'default': 'auto',
            'description': 'Selects the folding strategy.'
                + '\'auto\' uses the strategies contributed for the current document, \'indentation\' uses the indentation based folding strategy. '
        },
        'editor.showFoldingControls': {
            'enum': [
                'mouseover',
                'always'
            ],
            'default': 'mouseover',
            'description': 'Controls whether the fold actions in the gutter stay always visible or hide unless the mouse is over the gutter.'
        },
        'editor.matchBrackets': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable highlighting of matching brackets.'
        },
        'editor.renderControlCharacters': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable rendering of control characters.'
        },
        'editor.renderIndentGuides': {
            'type': 'boolean',
            'default': false,
            'description': 'Enable rendering of indent guides.'
        },
        'editor.renderLineHighlight': {
            'enum': [
                'all',
                'gutter',
                'line',
                'none'
            ],
            'default': 'all',
            'description': 'Enable rendering of current line highlight.'
        },
        'editor.useTabStops': {
            'type': 'boolean',
            'default': true,
            'description': 'Inserting and deleting whitespace follows tab stops.'
        },
        'editor.insertSpaces': {
            'type': 'boolean',
            'default': true,
            'description': 'Using whitespaces to replace tabs when tabbing.'
        },
        'editor.colorDecorators': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable inline color decorators and color picker rendering.'
        },
        'editor.highlightActiveIndentGuide': {
            'type': 'boolean',
            'default': true,
            'description': 'Enable highlighting of the active indent guide.'
        },
        'editor.iconsInSuggestions': {
            'type': 'boolean',
            'default': true,
            'description': 'Render icons in suggestions box.'
        },
        'editor.showUnused': {
            'type': 'boolean',
            'default': true,
            'description': 'Controls fading out of unused variables.',
        },
        'editor.scrollBeyondLastColumn': {
            'type': 'number',
            'default': 5,
            'description': 'Enable that scrolling can go beyond the last column by a number of columns.'
        },
        'editor.suggestSelection': {
            'enum': [
                'first',
                'recentlyUsed',
                'recentlyUsedByPrefix'
            ],
            'default': 'first',
            'description': 'The history mode for suggestions'
        },
        'editor.fontWeight': {
            'enum': [
                'normal',
                'bold',
                'bolder',
                'lighter',
                'initial',
                'inherit',
                '100',
                '200',
                '300',
                '400',
                '500',
                '600',
                '700',
                '800',
                '900'
            ],
            'default': 'normal',
            'description': 'Controls the editor\'s font weight.'
        },
        'diffEditor.renderSideBySide': {
            'type': 'boolean',
            'description': 'Render the differences in two side-by-side editors.',
            'default': true
        },
        'diffEditor.ignoreTrimWhitespace': {
            'type': 'boolean',
            'description': 'Compute the diff by ignoring leading/trailing whitespace.',
            'default': true
        },
        'diffEditor.renderIndicators': {
            'type': 'boolean',
            'description': 'Render +/- indicators for added/deleted changes.',
            'default': true
        },
        'diffEditor.followsCaret': {
            'type': 'boolean',
            'description': 'Resets the navigator state when the user selects something in the editor.',
            'default': true
        },
        'diffEditor.ignoreCharChanges': {
            'type': 'boolean',
            'description': 'Jump from line to line.',
            'default': true
        },
        'diffEditor.alwaysRevealFirst': {
            'type': 'boolean',
            'description': 'Reveal first change.',
            'default': true
        }
    }
};
exports.EditorPreferences = Symbol('EditorPreferences');
function createEditorPreferences(preferences) {
    return preferences_1.createPreferenceProxy(preferences, exports.editorPreferenceSchema);
}
exports.createEditorPreferences = createEditorPreferences;
function bindEditorPreferences(bind) {
    bind(exports.EditorPreferences).toDynamicValue(function (ctx) {
        var preferences = ctx.container.get(preferences_1.PreferenceService);
        return createEditorPreferences(preferences);
    }).inSingletonScope();
    bind(preferences_1.PreferenceContribution).toConstantValue({ schema: exports.editorPreferenceSchema });
}
exports.bindEditorPreferences = bindEditorPreferences;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-variable-contribution.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-variable-contribution.js ***!
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
var editor_manager_1 = __webpack_require__(/*! ./editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var EditorVariableContribution = /** @class */ (function () {
    function EditorVariableContribution() {
    }
    EditorVariableContribution.prototype.registerVariables = function (variables) {
        var _this = this;
        variables.registerVariable({
            name: 'lineNumber',
            description: 'The current line number in the currently opened file',
            resolve: function () {
                var editor = _this.getCurrentEditor();
                return editor ? "" + (editor.cursor.line + 1) : undefined;
            }
        });
    };
    EditorVariableContribution.prototype.getCurrentEditor = function () {
        var currentEditor = this.editorManager.currentEditor;
        if (!currentEditor) {
            return undefined;
        }
        return currentEditor.editor;
    };
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], EditorVariableContribution.prototype, "editorManager", void 0);
    EditorVariableContribution = __decorate([
        inversify_1.injectable()
    ], EditorVariableContribution);
    return EditorVariableContribution;
}());
exports.EditorVariableContribution = EditorVariableContribution;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-widget-factory.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-widget-factory.js ***!
  \**************************************************************************/
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var editor_widget_1 = __webpack_require__(/*! ./editor-widget */ "../node_modules/@theia/editor/lib/browser/editor-widget.js");
var editor_1 = __webpack_require__(/*! ./editor */ "../node_modules/@theia/editor/lib/browser/editor.js");
var EditorWidgetFactory = /** @class */ (function () {
    function EditorWidgetFactory() {
        this.id = EditorWidgetFactory_1.ID;
    }
    EditorWidgetFactory_1 = EditorWidgetFactory;
    EditorWidgetFactory.prototype.createWidget = function (options) {
        var uri = new uri_1.default(options.uri);
        return this.createEditor(uri);
    };
    EditorWidgetFactory.prototype.createEditor = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var icon;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.labelProvider.getIcon(uri)];
                    case 1:
                        icon = _a.sent();
                        return [2 /*return*/, this.editorProvider(uri).then(function (textEditor) {
                                var newEditor = new editor_widget_1.EditorWidget(textEditor, _this.selectionService);
                                newEditor.id = _this.id + ':' + uri.toString();
                                newEditor.title.closable = true;
                                newEditor.title.label = _this.labelProvider.getName(uri);
                                newEditor.title.iconClass = icon + ' file-icon';
                                newEditor.title.caption = _this.labelProvider.getLongName(uri);
                                return newEditor;
                            })];
                }
            });
        });
    };
    var EditorWidgetFactory_1;
    EditorWidgetFactory.ID = 'code-editor-opener';
    __decorate([
        inversify_1.inject(browser_1.LabelProvider),
        __metadata("design:type", browser_1.LabelProvider)
    ], EditorWidgetFactory.prototype, "labelProvider", void 0);
    __decorate([
        inversify_1.inject(editor_1.TextEditorProvider),
        __metadata("design:type", Function)
    ], EditorWidgetFactory.prototype, "editorProvider", void 0);
    __decorate([
        inversify_1.inject(common_1.SelectionService),
        __metadata("design:type", common_1.SelectionService)
    ], EditorWidgetFactory.prototype, "selectionService", void 0);
    EditorWidgetFactory = EditorWidgetFactory_1 = __decorate([
        inversify_1.injectable()
    ], EditorWidgetFactory);
    return EditorWidgetFactory;
}());
exports.EditorWidgetFactory = EditorWidgetFactory;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/editor-widget.js":
/*!******************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/editor-widget.js ***!
  \******************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var EditorWidget = /** @class */ (function (_super) {
    __extends(EditorWidget, _super);
    function EditorWidget(editor, selectionService) {
        var _this = _super.call(this, editor) || this;
        _this.editor = editor;
        _this.selectionService = selectionService;
        _this.toDispose.push(_this.editor);
        _this.toDispose.push(_this.editor.onSelectionChanged(function () {
            if (_this.editor.isFocused()) {
                _this.selectionService.selection = _this.editor;
            }
        }));
        return _this;
    }
    Object.defineProperty(EditorWidget.prototype, "saveable", {
        get: function () {
            return this.editor.document;
        },
        enumerable: true,
        configurable: true
    });
    EditorWidget.prototype.getResourceUri = function () {
        var uri = this.editor.uri;
        if (browser_1.DiffUris.isDiffUri(uri)) {
            return browser_1.DiffUris.decode(uri)[0];
        }
        return uri;
    };
    EditorWidget.prototype.createMoveToUri = function (resourceUri) {
        var uri = this.editor.uri;
        if (browser_1.DiffUris.isDiffUri(uri)) {
            var _a = __read(browser_1.DiffUris.decode(uri), 2), left = _a[0], right = _a[1];
            return browser_1.DiffUris.encode(left.withPath(resourceUri.path), right.withPath(resourceUri.path));
        }
        return uri.withPath(resourceUri.path);
    };
    EditorWidget.prototype.onActivateRequest = function (msg) {
        _super.prototype.onActivateRequest.call(this, msg);
        this.editor.focus();
        this.selectionService.selection = this.editor;
    };
    EditorWidget.prototype.onAfterAttach = function (msg) {
        _super.prototype.onAfterAttach.call(this, msg);
        if (this.isVisible) {
            this.editor.refresh();
        }
    };
    EditorWidget.prototype.onAfterShow = function (msg) {
        _super.prototype.onAfterShow.call(this, msg);
        this.editor.refresh();
    };
    EditorWidget.prototype.onResize = function (msg) {
        if (msg.width < 0 || msg.height < 0) {
            this.editor.resizeToFit();
        }
        else {
            this.editor.setSize(msg);
        }
    };
    EditorWidget.prototype.storeState = function () {
        return this.editor.storeViewState();
    };
    EditorWidget.prototype.restoreState = function (oldState) {
        this.editor.restoreViewState(oldState);
    };
    return EditorWidget;
}(browser_1.BaseWidget));
exports.EditorWidget = EditorWidget;


/***/ }),

/***/ "../node_modules/@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service.js":
/*!*****************************************************************************************************!*\
  !*** ../node_modules/@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service.js ***!
  \*****************************************************************************************************/
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
var base64_arraybuffer_1 = __webpack_require__(/*! base64-arraybuffer */ "../node_modules/base64-arraybuffer/lib/base64-arraybuffer.js");
var vscode_languageserver_types_1 = __webpack_require__(/*! vscode-languageserver-types */ "../node_modules/vscode-languageserver-types/lib/esm/main.js");
exports.Position = vscode_languageserver_types_1.Position;
exports.Range = vscode_languageserver_types_1.Range;
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var disposable_1 = __webpack_require__(/*! @theia/core/lib/common/disposable */ "../node_modules/@theia/core/lib/common/disposable.js");
var logger_1 = __webpack_require__(/*! @theia/core/lib/common/logger */ "../node_modules/@theia/core/lib/common/logger.js");
var semantic_highlighting_feature_1 = __webpack_require__(/*! @theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-feature */ "../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-feature.js");
/**
 * Service for registering and managing semantic highlighting decorations in the code editors for multiple languages.
 *
 * The current, default implementation does nothing at all, because the unique identifier of the `EditorDecoration` is not
 * exposed via the API. A working example is available as the `MonacoSemanticHighlightingService` from the `@theia/monaco` extension.
 */
var SemanticHighlightingService = /** @class */ (function () {
    function SemanticHighlightingService() {
        this.scopes = new Map();
    }
    /**
     * Registers the supported highlighting scopes for the given language. Returns with a disposable that will unregister the scopes from this service on `dispose`.
     * @param languageId the unique identifier of the language.
     * @param scopes a lookup table of the supported (TextMate) scopes received from the server. Semantic highlighting will be be supported for a language if the `scopes` is empty.
     */
    SemanticHighlightingService.prototype.register = function (languageId, scopes) {
        if (scopes && scopes.length > 0) {
            this.logger.info("Registering scopes for language: " + languageId + ".");
            if (this.scopes.has(languageId)) {
                this.logger.warn("The scopes are already registered for language: " + languageId + ".");
            }
            this.scopes.set(languageId, scopes.map(function (scope) { return scope.slice(0); }));
            this.logger.info("The scopes have been successfully registered for " + languageId + ".");
            var unregister_1 = this.unregister.bind(this);
            return disposable_1.Disposable.create(function () { return unregister_1(languageId); });
        }
        return disposable_1.Disposable.NULL;
    };
    SemanticHighlightingService.prototype.unregister = function (languageId) {
        this.logger.info("Unregistering scopes for language: " + languageId + ".");
        if (!this.scopes.has(languageId)) {
            this.logger.warn("No scopes were registered for language: " + languageId + ".");
        }
        this.scopes.delete(languageId);
        this.logger.info("The scopes have been successfully unregistered for " + languageId + ".");
    };
    /**
     * An array for TextMate scopes for the language.
     * @param languageId the unique ID of the language.
     * @param index the index of the TextMate scopes for the language.
     */
    SemanticHighlightingService.prototype.scopesFor = function (languageId, index) {
        if (index < 0) {
            throw new Error("index >= 0. " + index);
        }
        var scopes = this.scopes.get(languageId);
        if (!scopes) {
            throw new Error("No scopes were registered for language: " + languageId + ".");
        }
        if (scopes.length <= index) {
            throw new Error("Cannot find scopes by index. Language ID: " + languageId + ". Index: " + index + ". Scopes: " + scopes);
        }
        return scopes[index];
    };
    /**
     * Decorates the editor with the semantic highlighting scopes.
     * @param languageId the unique identifier of the language the resource belongs to.
     * @param uri the URI of the resource to decorate in the editor.
     * @param ranges the decoration ranges.
     */
    SemanticHighlightingService.prototype.decorate = function (languageId, uri, ranges) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                return [2 /*return*/];
            });
        });
    };
    /**
     * Disposes the service.
     */
    SemanticHighlightingService.prototype.dispose = function () {
        // NOOP
    };
    __decorate([
        inversify_1.inject(logger_1.ILogger),
        __metadata("design:type", Object)
    ], SemanticHighlightingService.prototype, "logger", void 0);
    SemanticHighlightingService = __decorate([
        inversify_1.injectable()
    ], SemanticHighlightingService);
    return SemanticHighlightingService;
}());
exports.SemanticHighlightingService = SemanticHighlightingService;
(function (SemanticHighlightingService) {
    var LENGTH_SHIFT = 0x0000010;
    var SCOPE_MASK = 0x000FFFF;
    var Token;
    (function (Token) {
        function fromArray(tokens) {
            if (tokens.length % 3 !== 0) {
                throw new Error("\"Invalid tokens. 'tokens.length % 3 !== 0' Tokens length was: \" + " + tokens.length + ".");
            }
            var result = [];
            for (var i = 0; i < tokens.length; i = i + 3) {
                result.push({
                    character: tokens[i],
                    length: tokens[i + 1],
                    scope: tokens[i + 2]
                });
            }
            return result;
        }
        Token.fromArray = fromArray;
    })(Token = SemanticHighlightingService.Token || (SemanticHighlightingService.Token = {}));
    /**
     * Converts the compact, `base64` string token into an array of tokens.
     */
    function decode(tokens) {
        if (!tokens) {
            return [];
        }
        var buffer = base64_arraybuffer_1.decode(tokens);
        var dataView = new DataView(buffer);
        var result = [];
        for (var i = 0; i < buffer.byteLength / Uint32Array.BYTES_PER_ELEMENT; i = i + 2) {
            var character = dataView.getUint32(i * Uint32Array.BYTES_PER_ELEMENT);
            var lengthAndScope = dataView.getUint32((i + 1) * Uint32Array.BYTES_PER_ELEMENT);
            var length_1 = lengthAndScope >>> LENGTH_SHIFT;
            var scope = lengthAndScope & SCOPE_MASK;
            result.push({
                character: character,
                length: length_1,
                scope: scope
            });
        }
        return result;
    }
    SemanticHighlightingService.decode = decode;
    /**
     * Encodes the array of tokens into a compact `base64` string representation.
     */
    function encode(tokens) {
        if (!tokens || tokens.length === 0) {
            return '';
        }
        var buffer = new ArrayBuffer(tokens.length * 2 * Uint32Array.BYTES_PER_ELEMENT);
        var dataView = new DataView(buffer);
        var j = 0;
        for (var i = 0; i < tokens.length; i++) {
            var _a = tokens[i], character = _a.character, length_2 = _a.length, scope = _a.scope;
            var lengthAndScope = length_2;
            lengthAndScope = lengthAndScope << LENGTH_SHIFT;
            lengthAndScope |= scope;
            dataView.setUint32(j++ * Uint32Array.BYTES_PER_ELEMENT, character);
            dataView.setUint32(j++ * Uint32Array.BYTES_PER_ELEMENT, lengthAndScope);
        }
        return base64_arraybuffer_1.encode(buffer);
    }
    SemanticHighlightingService.encode = encode;
    /**
     * Creates a new text document feature to handle the semantic highlighting capabilities of the protocol.
     * When the feature gets initialized, it delegates to the semantic highlighting service and registers the TextMate scopes received as part of the server capabilities.
     * Plus, each time when a notification is received by the client, the semantic highlighting service will be used as the consumer and the highlighting information
     * will be used to decorate the text editor.
     */
    function createNewFeature(service, client) {
        var languageId = client.languageId;
        var initializeCallback = function (id, scopes) { return service.register(id, scopes); };
        var consumer = function (params) {
            var toRanges = function (tuple) {
                var _a = __read(tuple, 2), line = _a[0], tokens = _a[1];
                if (!tokens) {
                    return [
                        {
                            start: vscode_languageserver_types_1.Position.create(line, 0),
                            end: vscode_languageserver_types_1.Position.create(line, 0),
                        }
                    ];
                }
                return SemanticHighlightingService.decode(tokens).map(function (token) { return ({
                    start: vscode_languageserver_types_1.Position.create(line, token.character),
                    end: vscode_languageserver_types_1.Position.create(line, token.character + token.length),
                    scope: token.scope
                }); });
            };
            var ranges = params.lines.map(function (line) { return [line.line, line.tokens]; }).map(toRanges).reduce(function (acc, current) { return acc.concat(current); }, []);
            var uri = new uri_1.default(params.textDocument.uri);
            service.decorate(languageId, uri, ranges);
        };
        return new semantic_highlighting_feature_1.SemanticHighlightFeature(client, initializeCallback, consumer);
    }
    SemanticHighlightingService.createNewFeature = createNewFeature;
})(SemanticHighlightingService = exports.SemanticHighlightingService || (exports.SemanticHighlightingService = {}));
exports.SemanticHighlightingService = SemanticHighlightingService;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/index.js":
/*!*************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/index.js ***!
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
__export(__webpack_require__(/*! ./language-client-services */ "../node_modules/@theia/languages/lib/browser/language-client-services.js"));
__export(__webpack_require__(/*! ./language-client-factory */ "../node_modules/@theia/languages/lib/browser/language-client-factory.js"));
__export(__webpack_require__(/*! ./language-client-contribution */ "../node_modules/@theia/languages/lib/browser/language-client-contribution.js"));
__export(__webpack_require__(/*! ./languages-frontend-contribution */ "../node_modules/@theia/languages/lib/browser/languages-frontend-contribution.js"));
__export(__webpack_require__(/*! ./languages-frontend-module */ "../node_modules/@theia/languages/lib/browser/languages-frontend-module.js"));


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-feature.js":
/*!***********************************************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-feature.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var uuid_1 = __webpack_require__(/*! uuid */ "../node_modules/uuid/index.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common/ */ "../node_modules/@theia/core/lib/common/index.js");
var __1 = __webpack_require__(/*! ../ */ "../node_modules/@theia/languages/lib/browser/index.js");
var semantic_highlighting_protocol_1 = __webpack_require__(/*! ./semantic-highlighting-protocol */ "../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-protocol.js");
// NOTE: This module can be removed, or at least can be simplified once the semantic highlighting will become the part of the LSP.
// https://github.com/Microsoft/vscode-languageserver-node/issues/368
var SemanticHighlightFeature = /** @class */ (function (_super) {
    __extends(SemanticHighlightFeature, _super);
    function SemanticHighlightFeature(client, initializeCallback, consumer) {
        var _this = _super.call(this, client, semantic_highlighting_protocol_1.SemanticHighlight.type) || this;
        _this.initializeCallback = initializeCallback;
        _this.consumer = consumer;
        _this.languageId = client.languageId;
        _this.toDispose = new common_1.DisposableCollection();
        return _this;
    }
    SemanticHighlightFeature.prototype.fillClientCapabilities = function (capabilities) {
        if (!capabilities.textDocument) {
            capabilities.textDocument = {};
        }
        // tslint:disable-next-line:no-any
        capabilities.textDocument.semanticHighlightingCapabilities = {
            semanticHighlighting: true
        };
    };
    SemanticHighlightFeature.prototype.initialize = function (capabilities, documentSelector) {
        if (!documentSelector) {
            return;
        }
        var capabilitiesExt = capabilities;
        if (capabilitiesExt.semanticHighlighting) {
            var scopes = capabilitiesExt.semanticHighlighting.scopes;
            if (scopes && scopes.length > 0) {
                this.toDispose.push(this.initializeCallback(this.languageId, scopes));
                var id = uuid_1.v4();
                this.register(this.messages, {
                    id: id,
                    registerOptions: Object.assign({}, { documentSelector: documentSelector }, capabilitiesExt.semanticHighlighting)
                });
            }
        }
    };
    SemanticHighlightFeature.prototype.registerLanguageProvider = function () {
        var _this = this;
        this._client.onNotification(semantic_highlighting_protocol_1.SemanticHighlight.type, this.consumeSemanticHighlighting.bind(this));
        return __1.Disposable.create(function () { return _this.toDispose.dispose(); });
    };
    SemanticHighlightFeature.prototype.consumeSemanticHighlighting = function (params) {
        this.consumer(params);
    };
    return SemanticHighlightFeature;
}(__1.TextDocumentFeature));
exports.SemanticHighlightFeature = SemanticHighlightFeature;


/***/ }),

/***/ "../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-protocol.js":
/*!************************************************************************************************************!*\
  !*** ../node_modules/@theia/languages/lib/browser/semantic-highlighting/semantic-highlighting-protocol.js ***!
  \************************************************************************************************************/
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
var vscode_jsonrpc_1 = __webpack_require__(/*! vscode-jsonrpc */ "../node_modules/vscode-jsonrpc/lib/main.js");
var SemanticHighlight;
(function (SemanticHighlight) {
    SemanticHighlight.type = new vscode_jsonrpc_1.NotificationType('textDocument/semanticHighlighting');
})(SemanticHighlight = exports.SemanticHighlight || (exports.SemanticHighlight = {}));


/***/ }),

/***/ "../node_modules/base64-arraybuffer/lib/base64-arraybuffer.js":
/*!********************************************************************!*\
  !*** ../node_modules/base64-arraybuffer/lib/base64-arraybuffer.js ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

/*
 * base64-arraybuffer
 * https://github.com/niklasvh/base64-arraybuffer
 *
 * Copyright (c) 2012 Niklas von Hertzen
 * Licensed under the MIT license.
 */
(function(){
  "use strict";

  var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

  // Use a lookup table to find the index.
  var lookup = new Uint8Array(256);
  for (var i = 0; i < chars.length; i++) {
    lookup[chars.charCodeAt(i)] = i;
  }

  exports.encode = function(arraybuffer) {
    var bytes = new Uint8Array(arraybuffer),
    i, len = bytes.length, base64 = "";

    for (i = 0; i < len; i+=3) {
      base64 += chars[bytes[i] >> 2];
      base64 += chars[((bytes[i] & 3) << 4) | (bytes[i + 1] >> 4)];
      base64 += chars[((bytes[i + 1] & 15) << 2) | (bytes[i + 2] >> 6)];
      base64 += chars[bytes[i + 2] & 63];
    }

    if ((len % 3) === 2) {
      base64 = base64.substring(0, base64.length - 1) + "=";
    } else if (len % 3 === 1) {
      base64 = base64.substring(0, base64.length - 2) + "==";
    }

    return base64;
  };

  exports.decode =  function(base64) {
    var bufferLength = base64.length * 0.75,
    len = base64.length, i, p = 0,
    encoded1, encoded2, encoded3, encoded4;

    if (base64[base64.length - 1] === "=") {
      bufferLength--;
      if (base64[base64.length - 2] === "=") {
        bufferLength--;
      }
    }

    var arraybuffer = new ArrayBuffer(bufferLength),
    bytes = new Uint8Array(arraybuffer);

    for (i = 0; i < len; i+=4) {
      encoded1 = lookup[base64.charCodeAt(i)];
      encoded2 = lookup[base64.charCodeAt(i+1)];
      encoded3 = lookup[base64.charCodeAt(i+2)];
      encoded4 = lookup[base64.charCodeAt(i+3)];

      bytes[p++] = (encoded1 << 2) | (encoded2 >> 4);
      bytes[p++] = ((encoded2 & 15) << 4) | (encoded3 >> 2);
      bytes[p++] = ((encoded3 & 3) << 6) | (encoded4 & 63);
    }

    return arraybuffer;
  };
})();


/***/ }),

/***/ "../node_modules/uuid/index.js":
/*!*************************************!*\
  !*** ../node_modules/uuid/index.js ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var v1 = __webpack_require__(/*! ./v1 */ "../node_modules/uuid/v1.js");
var v4 = __webpack_require__(/*! ./v4 */ "../node_modules/uuid/v4.js");

var uuid = v4;
uuid.v1 = v1;
uuid.v4 = v4;

module.exports = uuid;


/***/ }),

/***/ "../node_modules/uuid/lib/bytesToUuid.js":
/*!***********************************************!*\
  !*** ../node_modules/uuid/lib/bytesToUuid.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

/**
 * Convert array of 16 byte values to UUID string format of the form:
 * XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
 */
var byteToHex = [];
for (var i = 0; i < 256; ++i) {
  byteToHex[i] = (i + 0x100).toString(16).substr(1);
}

function bytesToUuid(buf, offset) {
  var i = offset || 0;
  var bth = byteToHex;
  // join used to fix memory issue caused by concatenation: https://bugs.chromium.org/p/v8/issues/detail?id=3175#c4
  return ([bth[buf[i++]], bth[buf[i++]], 
	bth[buf[i++]], bth[buf[i++]], '-',
	bth[buf[i++]], bth[buf[i++]], '-',
	bth[buf[i++]], bth[buf[i++]], '-',
	bth[buf[i++]], bth[buf[i++]], '-',
	bth[buf[i++]], bth[buf[i++]],
	bth[buf[i++]], bth[buf[i++]],
	bth[buf[i++]], bth[buf[i++]]]).join('');
}

module.exports = bytesToUuid;


/***/ }),

/***/ "../node_modules/uuid/lib/rng-browser.js":
/*!***********************************************!*\
  !*** ../node_modules/uuid/lib/rng-browser.js ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

// Unique ID creation requires a high quality random # generator.  In the
// browser this is a little complicated due to unknown quality of Math.random()
// and inconsistent support for the `crypto` API.  We do the best we can via
// feature-detection

// getRandomValues needs to be invoked in a context where "this" is a Crypto
// implementation. Also, find the complete implementation of crypto on IE11.
var getRandomValues = (typeof(crypto) != 'undefined' && crypto.getRandomValues && crypto.getRandomValues.bind(crypto)) ||
                      (typeof(msCrypto) != 'undefined' && typeof window.msCrypto.getRandomValues == 'function' && msCrypto.getRandomValues.bind(msCrypto));

if (getRandomValues) {
  // WHATWG crypto RNG - http://wiki.whatwg.org/wiki/Crypto
  var rnds8 = new Uint8Array(16); // eslint-disable-line no-undef

  module.exports = function whatwgRNG() {
    getRandomValues(rnds8);
    return rnds8;
  };
} else {
  // Math.random()-based (RNG)
  //
  // If all else fails, use Math.random().  It's fast, but is of unspecified
  // quality.
  var rnds = new Array(16);

  module.exports = function mathRNG() {
    for (var i = 0, r; i < 16; i++) {
      if ((i & 0x03) === 0) r = Math.random() * 0x100000000;
      rnds[i] = r >>> ((i & 0x03) << 3) & 0xff;
    }

    return rnds;
  };
}


/***/ }),

/***/ "../node_modules/uuid/v1.js":
/*!**********************************!*\
  !*** ../node_modules/uuid/v1.js ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var rng = __webpack_require__(/*! ./lib/rng */ "../node_modules/uuid/lib/rng-browser.js");
var bytesToUuid = __webpack_require__(/*! ./lib/bytesToUuid */ "../node_modules/uuid/lib/bytesToUuid.js");

// **`v1()` - Generate time-based UUID**
//
// Inspired by https://github.com/LiosK/UUID.js
// and http://docs.python.org/library/uuid.html

var _nodeId;
var _clockseq;

// Previous uuid creation time
var _lastMSecs = 0;
var _lastNSecs = 0;

// See https://github.com/broofa/node-uuid for API details
function v1(options, buf, offset) {
  var i = buf && offset || 0;
  var b = buf || [];

  options = options || {};
  var node = options.node || _nodeId;
  var clockseq = options.clockseq !== undefined ? options.clockseq : _clockseq;

  // node and clockseq need to be initialized to random values if they're not
  // specified.  We do this lazily to minimize issues related to insufficient
  // system entropy.  See #189
  if (node == null || clockseq == null) {
    var seedBytes = rng();
    if (node == null) {
      // Per 4.5, create and 48-bit node id, (47 random bits + multicast bit = 1)
      node = _nodeId = [
        seedBytes[0] | 0x01,
        seedBytes[1], seedBytes[2], seedBytes[3], seedBytes[4], seedBytes[5]
      ];
    }
    if (clockseq == null) {
      // Per 4.2.2, randomize (14 bit) clockseq
      clockseq = _clockseq = (seedBytes[6] << 8 | seedBytes[7]) & 0x3fff;
    }
  }

  // UUID timestamps are 100 nano-second units since the Gregorian epoch,
  // (1582-10-15 00:00).  JSNumbers aren't precise enough for this, so
  // time is handled internally as 'msecs' (integer milliseconds) and 'nsecs'
  // (100-nanoseconds offset from msecs) since unix epoch, 1970-01-01 00:00.
  var msecs = options.msecs !== undefined ? options.msecs : new Date().getTime();

  // Per 4.2.1.2, use count of uuid's generated during the current clock
  // cycle to simulate higher resolution clock
  var nsecs = options.nsecs !== undefined ? options.nsecs : _lastNSecs + 1;

  // Time since last uuid creation (in msecs)
  var dt = (msecs - _lastMSecs) + (nsecs - _lastNSecs)/10000;

  // Per 4.2.1.2, Bump clockseq on clock regression
  if (dt < 0 && options.clockseq === undefined) {
    clockseq = clockseq + 1 & 0x3fff;
  }

  // Reset nsecs if clock regresses (new clockseq) or we've moved onto a new
  // time interval
  if ((dt < 0 || msecs > _lastMSecs) && options.nsecs === undefined) {
    nsecs = 0;
  }

  // Per 4.2.1.2 Throw error if too many uuids are requested
  if (nsecs >= 10000) {
    throw new Error('uuid.v1(): Can\'t create more than 10M uuids/sec');
  }

  _lastMSecs = msecs;
  _lastNSecs = nsecs;
  _clockseq = clockseq;

  // Per 4.1.4 - Convert from unix epoch to Gregorian epoch
  msecs += 12219292800000;

  // `time_low`
  var tl = ((msecs & 0xfffffff) * 10000 + nsecs) % 0x100000000;
  b[i++] = tl >>> 24 & 0xff;
  b[i++] = tl >>> 16 & 0xff;
  b[i++] = tl >>> 8 & 0xff;
  b[i++] = tl & 0xff;

  // `time_mid`
  var tmh = (msecs / 0x100000000 * 10000) & 0xfffffff;
  b[i++] = tmh >>> 8 & 0xff;
  b[i++] = tmh & 0xff;

  // `time_high_and_version`
  b[i++] = tmh >>> 24 & 0xf | 0x10; // include version
  b[i++] = tmh >>> 16 & 0xff;

  // `clock_seq_hi_and_reserved` (Per 4.2.2 - include variant)
  b[i++] = clockseq >>> 8 | 0x80;

  // `clock_seq_low`
  b[i++] = clockseq & 0xff;

  // `node`
  for (var n = 0; n < 6; ++n) {
    b[i + n] = node[n];
  }

  return buf ? buf : bytesToUuid(b);
}

module.exports = v1;


/***/ }),

/***/ "../node_modules/uuid/v4.js":
/*!**********************************!*\
  !*** ../node_modules/uuid/v4.js ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var rng = __webpack_require__(/*! ./lib/rng */ "../node_modules/uuid/lib/rng-browser.js");
var bytesToUuid = __webpack_require__(/*! ./lib/bytesToUuid */ "../node_modules/uuid/lib/bytesToUuid.js");

function v4(options, buf, offset) {
  var i = buf && offset || 0;

  if (typeof(options) == 'string') {
    buf = options === 'binary' ? new Array(16) : null;
    options = null;
  }
  options = options || {};

  var rnds = options.random || (options.rng || rng)();

  // Per 4.4, set bits for version and `clock_seq_hi_and_reserved`
  rnds[6] = (rnds[6] & 0x0f) | 0x40;
  rnds[8] = (rnds[8] & 0x3f) | 0x80;

  // Copy bytes to buffer, if provided
  if (buf) {
    for (var ii = 0; ii < 16; ++ii) {
      buf[i + ii] = rnds[ii];
    }
  }

  return buf || bytesToUuid(rnds);
}

module.exports = v4;


/***/ })

}]);
//# sourceMappingURL=10.bundle.js.map