(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[28],{

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-browser-module.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-browser-module.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
exports.ContainerModule = inversify_1.ContainerModule;
var monaco_loader_1 = __webpack_require__(/*! ./monaco-loader */ "../node_modules/@theia/monaco/lib/browser/monaco-loader.js");
exports.default = monaco_loader_1.loadVsRequire(window)
    .then(function (vsRequire) { return monaco_loader_1.loadMonaco(vsRequire); })
    .then(function () {
    return Promise.resolve().then(function () { return __webpack_require__(/*! ./monaco-frontend-module */ "../node_modules/@theia/monaco/lib/browser/monaco-frontend-module.js"); });
}).then(function (module) {
    return module.default;
});


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var monaco_editor_1 = __webpack_require__(/*! ./monaco-editor */ "../node_modules/@theia/monaco/lib/browser/monaco-editor.js");
var MonacoCommandRegistry = /** @class */ (function () {
    function MonacoCommandRegistry(commands, editorManager, selectionService) {
        this.commands = commands;
        this.editorManager = editorManager;
        this.selectionService = selectionService;
    }
    MonacoCommandRegistry_1 = MonacoCommandRegistry;
    MonacoCommandRegistry.prototype.prefix = function (command) {
        return MonacoCommandRegistry_1.MONACO_COMMAND_PREFIX + command;
    };
    MonacoCommandRegistry.prototype.validate = function (command) {
        var monacoCommand = this.prefix(command);
        return this.commands.commandIds.indexOf(monacoCommand) !== -1 ? monacoCommand : undefined;
    };
    MonacoCommandRegistry.prototype.registerCommand = function (command, handler) {
        this.commands.registerCommand(__assign({}, command, { id: this.prefix(command.id) }), this.newHandler(handler));
    };
    MonacoCommandRegistry.prototype.registerHandler = function (command, handler) {
        this.commands.registerHandler(command, this.newHandler(handler));
    };
    MonacoCommandRegistry.prototype.newHandler = function (monacoHandler) {
        var _this = this;
        return {
            execute: function () {
                var args = [];
                for (var _i = 0; _i < arguments.length; _i++) {
                    args[_i] = arguments[_i];
                }
                return _this.execute.apply(_this, __spread([monacoHandler], args));
            },
            isEnabled: function () {
                var args = [];
                for (var _i = 0; _i < arguments.length; _i++) {
                    args[_i] = arguments[_i];
                }
                return _this.isEnabled.apply(_this, __spread([monacoHandler], args));
            },
            isVisible: function () {
                var args = [];
                for (var _i = 0; _i < arguments.length; _i++) {
                    args[_i] = arguments[_i];
                }
                return _this.isVisible.apply(_this, __spread([monacoHandler], args));
            }
        };
    };
    // tslint:disable-next-line:no-any
    MonacoCommandRegistry.prototype.execute = function (monacoHandler) {
        var args = [];
        for (var _i = 1; _i < arguments.length; _i++) {
            args[_i - 1] = arguments[_i];
        }
        var editor = monaco_editor_1.MonacoEditor.getCurrent(this.editorManager);
        if (editor) {
            editor.focus();
            return Promise.resolve(monacoHandler.execute.apply(monacoHandler, __spread([editor], args)));
        }
        return Promise.resolve();
    };
    // tslint:disable-next-line:no-any
    MonacoCommandRegistry.prototype.isEnabled = function (monacoHandler) {
        var args = [];
        for (var _i = 1; _i < arguments.length; _i++) {
            args[_i - 1] = arguments[_i];
        }
        var editor = monaco_editor_1.MonacoEditor.getCurrent(this.editorManager);
        return !!editor && (!monacoHandler.isEnabled || monacoHandler.isEnabled.apply(monacoHandler, __spread([editor], args)));
    };
    // tslint:disable-next-line:no-any
    MonacoCommandRegistry.prototype.isVisible = function (monacoHandler) {
        var args = [];
        for (var _i = 1; _i < arguments.length; _i++) {
            args[_i - 1] = arguments[_i];
        }
        return browser_1.TextEditorSelection.is(this.selectionService.selection);
    };
    var MonacoCommandRegistry_1;
    MonacoCommandRegistry.MONACO_COMMAND_PREFIX = 'monaco.';
    MonacoCommandRegistry = MonacoCommandRegistry_1 = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(core_1.CommandRegistry)),
        __param(1, inversify_1.inject(browser_1.EditorManager)),
        __param(2, inversify_1.inject(core_1.SelectionService)),
        __metadata("design:paramtypes", [core_1.CommandRegistry,
            browser_1.EditorManager,
            core_1.SelectionService])
    ], MonacoCommandRegistry);
    return MonacoCommandRegistry;
}());
exports.MonacoCommandRegistry = MonacoCommandRegistry;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-command.js":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-command.js ***!
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
var lib_1 = __webpack_require__(/*! monaco-languageclient/lib */ "../node_modules/monaco-languageclient/lib/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var quick_open_service_1 = __webpack_require__(/*! @theia/core/lib/browser/quick-open/quick-open-service */ "../node_modules/@theia/core/lib/browser/quick-open/quick-open-service.js");
var quick_open_model_1 = __webpack_require__(/*! @theia/core/lib/browser/quick-open/quick-open-model */ "../node_modules/@theia/core/lib/browser/quick-open/quick-open-model.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var monaco_command_registry_1 = __webpack_require__(/*! ./monaco-command-registry */ "../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js");
var MenuRegistry = monaco.actions.MenuRegistry;
var MenuId = monaco.actions.MenuId;
var MonacoCommands;
(function (MonacoCommands) {
    var e_1, _a, e_2, _b;
    MonacoCommands.UNDO = 'undo';
    MonacoCommands.REDO = 'redo';
    MonacoCommands.COMMON_KEYBOARD_ACTIONS = new Set([MonacoCommands.UNDO, MonacoCommands.REDO]);
    MonacoCommands.COMMON_ACTIONS = {};
    MonacoCommands.COMMON_ACTIONS[MonacoCommands.UNDO] = browser_1.CommonCommands.UNDO.id;
    MonacoCommands.COMMON_ACTIONS[MonacoCommands.REDO] = browser_1.CommonCommands.REDO.id;
    MonacoCommands.COMMON_ACTIONS['actions.find'] = browser_1.CommonCommands.FIND.id;
    MonacoCommands.COMMON_ACTIONS['editor.action.startFindReplaceAction'] = browser_1.CommonCommands.REPLACE.id;
    MonacoCommands.SELECTION_SELECT_ALL = 'editor.action.select.all';
    MonacoCommands.SELECTION_EXPAND_SELECTION = 'editor.action.smartSelect.grow';
    MonacoCommands.SELECTION_SHRINK_SELECTION = 'editor.action.smartSelect.shrink';
    MonacoCommands.SELECTION_COPY_LINE_UP = 'editor.action.copyLinesUpAction';
    MonacoCommands.SELECTION_COPY_LINE_DOWN = 'editor.action.copyLinesDownAction';
    MonacoCommands.SELECTION_MOVE_LINE_UP = 'editor.action.moveLinesUpAction';
    MonacoCommands.SELECTION_MOVE_LINE_DOWN = 'editor.action.moveLinesDownAction';
    MonacoCommands.SELECTION_ADD_CURSOR_ABOVE = 'editor.action.insertCursorAbove';
    MonacoCommands.SELECTION_ADD_CURSOR_BELOW = 'editor.action.insertCursorBelow';
    MonacoCommands.SELECTION_ADD_CURSOR_TO_LINE_END = 'editor.action.insertCursorAtEndOfEachLineSelected';
    MonacoCommands.SELECTION_ADD_NEXT_OCCURRENCE = 'editor.action.addSelectionToNextFindMatch';
    MonacoCommands.SELECTION_ADD_PREVIOUS_OCCURRENCE = 'editor.action.addSelectionToPreviousFindMatch';
    MonacoCommands.SELECTION_SELECT_ALL_OCCURRENCES = 'editor.action.selectHighlights';
    MonacoCommands.ACTIONS = [
        { id: MonacoCommands.SELECTION_SELECT_ALL, label: 'Select All', delegate: 'editor.action.selectAll' }
    ];
    MonacoCommands.EXCLUDE_ACTIONS = new Set(__spread(Object.keys(MonacoCommands.COMMON_ACTIONS), [
        'editor.action.quickCommand',
        'editor.action.clipboardCutAction',
        'editor.action.clipboardCopyAction',
        'editor.action.clipboardPasteAction',
        'editor.action.goToImplementation',
        'editor.action.toggleTabFocusMode',
        'find.history.showNext',
        'find.history.showPrevious',
    ]));
    var iconClasses = new Map();
    try {
        for (var _c = __values(MenuRegistry.getMenuItems(MenuId.EditorContext)), _d = _c.next(); !_d.done; _d = _c.next()) {
            var menuItem = _d.value;
            if (menuItem.command.iconClass) {
                iconClasses.set(menuItem.command.id, menuItem.command.iconClass);
            }
        }
    }
    catch (e_1_1) { e_1 = { error: e_1_1 }; }
    finally {
        try {
            if (_d && !_d.done && (_a = _c.return)) _a.call(_c);
        }
        finally { if (e_1) throw e_1.error; }
    }
    try {
        for (var _e = __values(monaco.editorExtensions.EditorExtensionsRegistry.getEditorActions()), _f = _e.next(); !_f.done; _f = _e.next()) {
            var command = _f.value;
            var id = command.id;
            if (!MonacoCommands.EXCLUDE_ACTIONS.has(id)) {
                var label = command.label;
                var iconClass = iconClasses.get(id);
                MonacoCommands.ACTIONS.push({ id: id, label: label, iconClass: iconClass });
            }
        }
    }
    catch (e_2_1) { e_2 = { error: e_2_1 }; }
    finally {
        try {
            if (_f && !_f.done && (_b = _e.return)) _b.call(_e);
        }
        finally { if (e_2) throw e_2.error; }
    }
})(MonacoCommands = exports.MonacoCommands || (exports.MonacoCommands = {}));
var MonacoEditorCommandHandlers = /** @class */ (function () {
    function MonacoEditorCommandHandlers() {
    }
    MonacoEditorCommandHandlers.prototype.registerCommands = function () {
        this.registerCommonCommandHandlers();
        this.registerEditorCommandHandlers();
        this.registerMonacoActionCommands();
    };
    MonacoEditorCommandHandlers.prototype.registerCommonCommandHandlers = function () {
        // tslint:disable-next-line:forin
        for (var action in MonacoCommands.COMMON_ACTIONS) {
            var command = MonacoCommands.COMMON_ACTIONS[action];
            var handler = this.newCommonActionHandler(action);
            this.registry.registerHandler(command, handler);
        }
    };
    MonacoEditorCommandHandlers.prototype.newCommonActionHandler = function (action) {
        return this.isCommonKeyboardAction(action) ? this.newKeyboardHandler(action) : this.newActionHandler(action);
    };
    MonacoEditorCommandHandlers.prototype.isCommonKeyboardAction = function (action) {
        return MonacoCommands.COMMON_KEYBOARD_ACTIONS.has(action);
    };
    MonacoEditorCommandHandlers.prototype.registerEditorCommandHandlers = function () {
        this.registry.registerHandler(browser_2.EditorCommands.SHOW_REFERENCES.id, this.newShowReferenceHandler());
        this.registry.registerHandler(browser_2.EditorCommands.CONFIG_INDENTATION.id, this.newConfigIndentationHandler());
        this.registry.registerHandler(browser_2.EditorCommands.INDENT_USING_SPACES.id, this.newConfigTabSizeHandler(true));
        this.registry.registerHandler(browser_2.EditorCommands.INDENT_USING_TABS.id, this.newConfigTabSizeHandler(false));
    };
    MonacoEditorCommandHandlers.prototype.newShowReferenceHandler = function () {
        var _this = this;
        return {
            execute: function (editor, uri, position, locations) {
                editor.commandService.executeCommand('editor.action.showReferences', monaco.Uri.parse(uri), _this.p2m.asPosition(position), locations.map(function (l) { return _this.p2m.asLocation(l); }));
            }
        };
    };
    MonacoEditorCommandHandlers.prototype.newConfigIndentationHandler = function () {
        var _this = this;
        return {
            execute: function (editor) { return _this.configureIndentation(editor); }
        };
    };
    MonacoEditorCommandHandlers.prototype.configureIndentation = function (editor) {
        var _this = this;
        var options = [true, false].map(function (useSpaces) {
            return new quick_open_model_1.QuickOpenItem({
                label: "Indent Using " + (useSpaces ? 'Spaces' : 'Tabs'),
                run: function (mode) {
                    if (mode === quick_open_model_1.QuickOpenMode.OPEN) {
                        _this.configureTabSize(editor, useSpaces);
                    }
                    return false;
                }
            });
        });
        this.quickOpenService.open({ onType: function (_, acceptor) { return acceptor(options); } }, {
            placeholder: 'Select Action',
            fuzzyMatchLabel: true
        });
    };
    MonacoEditorCommandHandlers.prototype.newConfigTabSizeHandler = function (useSpaces) {
        var _this = this;
        return {
            execute: function (editor) { return _this.configureTabSize(editor, useSpaces); }
        };
    };
    MonacoEditorCommandHandlers.prototype.configureTabSize = function (editor, useSpaces) {
        var model = editor.document && editor.document.textEditorModel;
        if (model) {
            var tabSize_1 = model.getOptions().tabSize;
            var sizes = Array.from(Array(8), function (_, x) { return x + 1; });
            var tabSizeOptions_1 = sizes.map(function (size) {
                return new quick_open_model_1.QuickOpenItem({
                    label: size === tabSize_1 ? size + "   Configured Tab Size" : size.toString(),
                    run: function (mode) {
                        if (mode !== quick_open_model_1.QuickOpenMode.OPEN) {
                            return false;
                        }
                        model.updateOptions({
                            tabSize: size || tabSize_1,
                            insertSpaces: useSpaces
                        });
                        return true;
                    }
                });
            });
            this.quickOpenService.open({ onType: function (_, acceptor) { return acceptor(tabSizeOptions_1); } }, {
                placeholder: 'Select Tab Size for Current File',
                fuzzyMatchLabel: true,
                selectIndex: function (lookFor) {
                    if (!lookFor || lookFor === '') {
                        return tabSize_1 - 1;
                    }
                    return 0;
                }
            });
        }
    };
    MonacoEditorCommandHandlers.prototype.registerMonacoActionCommands = function () {
        var e_3, _a;
        try {
            for (var _b = __values(MonacoCommands.ACTIONS), _c = _b.next(); !_c.done; _c = _b.next()) {
                var action = _c.value;
                var handler = this.newMonacoActionHandler(action);
                this.registry.registerCommand(action, handler);
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_3) throw e_3.error; }
        }
    };
    MonacoEditorCommandHandlers.prototype.newMonacoActionHandler = function (action) {
        var delegate = action.delegate;
        return delegate ? this.newCommandHandler(delegate) : this.newActionHandler(action.id);
    };
    MonacoEditorCommandHandlers.prototype.newKeyboardHandler = function (action) {
        return {
            execute: function (editor) {
                var args = [];
                for (var _i = 1; _i < arguments.length; _i++) {
                    args[_i - 1] = arguments[_i];
                }
                return editor.getControl().cursor.trigger('keyboard', action, args);
            }
        };
    };
    MonacoEditorCommandHandlers.prototype.newCommandHandler = function (action) {
        return {
            execute: function (editor) {
                var args = [];
                for (var _i = 1; _i < arguments.length; _i++) {
                    args[_i - 1] = arguments[_i];
                }
                var _a;
                return (_a = editor.commandService).executeCommand.apply(_a, __spread([action], args));
            }
        };
    };
    MonacoEditorCommandHandlers.prototype.newActionHandler = function (action) {
        return {
            execute: function (editor) { return editor.runAction(action); },
            isEnabled: function (editor) { return editor.isActionSupported(action); }
        };
    };
    __decorate([
        inversify_1.inject(monaco_command_registry_1.MonacoCommandRegistry),
        __metadata("design:type", monaco_command_registry_1.MonacoCommandRegistry)
    ], MonacoEditorCommandHandlers.prototype, "registry", void 0);
    __decorate([
        inversify_1.inject(lib_1.ProtocolToMonacoConverter),
        __metadata("design:type", lib_1.ProtocolToMonacoConverter)
    ], MonacoEditorCommandHandlers.prototype, "p2m", void 0);
    __decorate([
        inversify_1.inject(quick_open_service_1.QuickOpenService),
        __metadata("design:type", quick_open_service_1.QuickOpenService)
    ], MonacoEditorCommandHandlers.prototype, "quickOpenService", void 0);
    MonacoEditorCommandHandlers = __decorate([
        inversify_1.injectable()
    ], MonacoEditorCommandHandlers);
    return MonacoEditorCommandHandlers;
}());
exports.MonacoEditorCommandHandlers = MonacoEditorCommandHandlers;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-frontend-application-contribution.js":
/*!*********************************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-frontend-application-contribution.js ***!
  \*********************************************************************************************/
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
var theming_1 = __webpack_require__(/*! @theia/core/lib/browser/theming */ "../node_modules/@theia/core/lib/browser/theming.js");
var MonacoFrontendApplicationContribution = /** @class */ (function () {
    function MonacoFrontendApplicationContribution() {
    }
    MonacoFrontendApplicationContribution.prototype.initialize = function () {
        return __awaiter(this, void 0, void 0, function () {
            var currentTheme;
            var _this = this;
            return __generator(this, function (_a) {
                currentTheme = this.themeService.getCurrentTheme();
                this.changeTheme(currentTheme.editorTheme);
                this.themeService.onThemeChange(function (event) { return _this.changeTheme(event.newTheme.editorTheme); });
                return [2 /*return*/];
            });
        });
    };
    MonacoFrontendApplicationContribution.prototype.changeTheme = function (editorTheme) {
        var monacoTheme = editorTheme || this.themeService.defaultTheme.id;
        monaco.editor.setTheme(monacoTheme);
        document.body.classList.add(monacoTheme);
    };
    __decorate([
        inversify_1.inject(theming_1.ThemeService),
        __metadata("design:type", theming_1.ThemeService)
    ], MonacoFrontendApplicationContribution.prototype, "themeService", void 0);
    MonacoFrontendApplicationContribution = __decorate([
        inversify_1.injectable()
    ], MonacoFrontendApplicationContribution);
    return MonacoFrontendApplicationContribution;
}());
exports.MonacoFrontendApplicationContribution = MonacoFrontendApplicationContribution;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-frontend-module.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-frontend-module.js ***!
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
var browser_2 = __webpack_require__(/*! @theia/languages/lib/browser */ "../node_modules/@theia/languages/lib/browser/index.js");
var browser_3 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var editor_keybinding_contexts_1 = __webpack_require__(/*! @theia/editor/lib/browser/editor-keybinding-contexts */ "../node_modules/@theia/editor/lib/browser/editor-keybinding-contexts.js");
var monaco_languageclient_1 = __webpack_require__(/*! monaco-languageclient */ "../node_modules/monaco-languageclient/lib/index.js");
var monaco_editor_provider_1 = __webpack_require__(/*! ./monaco-editor-provider */ "../node_modules/@theia/monaco/lib/browser/monaco-editor-provider.js");
var monaco_menu_1 = __webpack_require__(/*! ./monaco-menu */ "../node_modules/@theia/monaco/lib/browser/monaco-menu.js");
var monaco_command_1 = __webpack_require__(/*! ./monaco-command */ "../node_modules/@theia/monaco/lib/browser/monaco-command.js");
var monaco_keybinding_1 = __webpack_require__(/*! ./monaco-keybinding */ "../node_modules/@theia/monaco/lib/browser/monaco-keybinding.js");
var monaco_languages_1 = __webpack_require__(/*! ./monaco-languages */ "../node_modules/@theia/monaco/lib/browser/monaco-languages.js");
var monaco_workspace_1 = __webpack_require__(/*! ./monaco-workspace */ "../node_modules/@theia/monaco/lib/browser/monaco-workspace.js");
var monaco_configurations_1 = __webpack_require__(/*! ./monaco-configurations */ "../node_modules/@theia/monaco/lib/browser/monaco-configurations.js");
var monaco_editor_service_1 = __webpack_require__(/*! ./monaco-editor-service */ "../node_modules/@theia/monaco/lib/browser/monaco-editor-service.js");
var monaco_text_model_service_1 = __webpack_require__(/*! ./monaco-text-model-service */ "../node_modules/@theia/monaco/lib/browser/monaco-text-model-service.js");
var monaco_context_menu_1 = __webpack_require__(/*! ./monaco-context-menu */ "../node_modules/@theia/monaco/lib/browser/monaco-context-menu.js");
var monaco_outline_contribution_1 = __webpack_require__(/*! ./monaco-outline-contribution */ "../node_modules/@theia/monaco/lib/browser/monaco-outline-contribution.js");
var monaco_status_bar_contribution_1 = __webpack_require__(/*! ./monaco-status-bar-contribution */ "../node_modules/@theia/monaco/lib/browser/monaco-status-bar-contribution.js");
var monaco_command_service_1 = __webpack_require__(/*! ./monaco-command-service */ "../node_modules/@theia/monaco/lib/browser/monaco-command-service.js");
var monaco_command_registry_1 = __webpack_require__(/*! ./monaco-command-registry */ "../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js");
var monaco_quick_open_service_1 = __webpack_require__(/*! ./monaco-quick-open-service */ "../node_modules/@theia/monaco/lib/browser/monaco-quick-open-service.js");
var monaco_diff_navigator_factory_1 = __webpack_require__(/*! ./monaco-diff-navigator-factory */ "../node_modules/@theia/monaco/lib/browser/monaco-diff-navigator-factory.js");
var monaco_keybinding_contexts_1 = __webpack_require__(/*! ./monaco-keybinding-contexts */ "../node_modules/@theia/monaco/lib/browser/monaco-keybinding-contexts.js");
var monaco_frontend_application_contribution_1 = __webpack_require__(/*! ./monaco-frontend-application-contribution */ "../node_modules/@theia/monaco/lib/browser/monaco-frontend-application-contribution.js");
var monaco_textmate_frontend_bindings_1 = __webpack_require__(/*! ./textmate/monaco-textmate-frontend-bindings */ "../node_modules/@theia/monaco/lib/browser/textmate/monaco-textmate-frontend-bindings.js");
var monaco_quick_input_service_1 = __webpack_require__(/*! ./monaco-quick-input-service */ "../node_modules/@theia/monaco/lib/browser/monaco-quick-input-service.js");
var monaco_semantic_highlighting_service_1 = __webpack_require__(/*! ./monaco-semantic-highlighting-service */ "../node_modules/@theia/monaco/lib/browser/monaco-semantic-highlighting-service.js");
var semantic_highlighting_service_1 = __webpack_require__(/*! @theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service */ "../node_modules/@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service.js");
var monaco_bulk_edit_service_1 = __webpack_require__(/*! ./monaco-bulk-edit-service */ "../node_modules/@theia/monaco/lib/browser/monaco-bulk-edit-service.js");
inversify_1.decorate(inversify_1.injectable(), monaco_languageclient_1.MonacoToProtocolConverter);
inversify_1.decorate(inversify_1.injectable(), monaco_languageclient_1.ProtocolToMonacoConverter);
__webpack_require__(/*! ../../src/browser/style/index.css */ "../node_modules/@theia/monaco/src/browser/style/index.css");
__webpack_require__(/*! ../../src/browser/style/symbol-sprite.svg */ "../node_modules/@theia/monaco/src/browser/style/symbol-sprite.svg");
__webpack_require__(/*! ../../src/browser/style/symbol-icons.css */ "../node_modules/@theia/monaco/src/browser/style/symbol-icons.css");
exports.default = new inversify_1.ContainerModule(function (bind, unbind, isBound, rebind) {
    bind(browser_1.FrontendApplicationContribution).to(monaco_frontend_application_contribution_1.MonacoFrontendApplicationContribution).inSingletonScope();
    bind(monaco_languageclient_1.MonacoToProtocolConverter).toSelf().inSingletonScope();
    bind(monaco_languageclient_1.ProtocolToMonacoConverter).toSelf().inSingletonScope();
    bind(monaco_languages_1.MonacoLanguages).toSelf().inSingletonScope();
    bind(browser_2.Languages).toService(monaco_languages_1.MonacoLanguages);
    bind(monaco_configurations_1.MonacoConfigurations).toSelf().inSingletonScope();
    bind(monaco_workspace_1.MonacoWorkspace).toSelf().inSingletonScope();
    bind(browser_2.Workspace).toService(monaco_workspace_1.MonacoWorkspace);
    bind(monaco_bulk_edit_service_1.MonacoBulkEditService).toSelf().inSingletonScope();
    bind(monaco_editor_service_1.MonacoEditorService).toSelf().inSingletonScope();
    bind(monaco_text_model_service_1.MonacoTextModelService).toSelf().inSingletonScope();
    bind(monaco_context_menu_1.MonacoContextMenuService).toSelf().inSingletonScope();
    bind(monaco_editor_provider_1.MonacoEditorProvider).toSelf().inSingletonScope();
    bind(monaco_command_service_1.MonacoCommandService).toSelf().inTransientScope();
    bind(monaco_command_service_1.MonacoCommandServiceFactory).toAutoFactory(monaco_command_service_1.MonacoCommandService);
    bind(browser_3.TextEditorProvider).toProvider(function (context) {
        return function (uri) { return context.container.get(monaco_editor_provider_1.MonacoEditorProvider).get(uri); };
    });
    bind(monaco_diff_navigator_factory_1.MonacoDiffNavigatorFactory).toSelf().inSingletonScope();
    bind(browser_3.DiffNavigatorProvider).toFactory(function (context) {
        return function (editor) { return context.container.get(monaco_editor_provider_1.MonacoEditorProvider).getDiffNavigator(editor); };
    });
    bind(monaco_outline_contribution_1.MonacoOutlineContribution).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(monaco_outline_contribution_1.MonacoOutlineContribution);
    bind(monaco_status_bar_contribution_1.MonacoStatusBarContribution).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(monaco_status_bar_contribution_1.MonacoStatusBarContribution);
    bind(monaco_command_registry_1.MonacoCommandRegistry).toSelf().inSingletonScope();
    bind(common_1.CommandContribution).to(monaco_command_1.MonacoEditorCommandHandlers).inSingletonScope();
    bind(common_1.MenuContribution).to(monaco_menu_1.MonacoEditorMenuContribution).inSingletonScope();
    bind(browser_1.KeybindingContribution).to(monaco_keybinding_1.MonacoKeybindingContribution).inSingletonScope();
    rebind(editor_keybinding_contexts_1.StrictEditorTextFocusContext).to(monaco_keybinding_contexts_1.MonacoStrictEditorTextFocusContext).inSingletonScope();
    bind(monaco_quick_open_service_1.MonacoQuickOpenService).toSelf().inSingletonScope();
    rebind(browser_1.QuickOpenService).toService(monaco_quick_open_service_1.MonacoQuickOpenService);
    monaco_textmate_frontend_bindings_1.default(bind, unbind, isBound, rebind);
    bind(monaco_quick_input_service_1.QuickInputService).toSelf().inSingletonScope();
    bind(monaco_semantic_highlighting_service_1.MonacoSemanticHighlightingService).toSelf().inSingletonScope();
    rebind(semantic_highlighting_service_1.SemanticHighlightingService).to(monaco_semantic_highlighting_service_1.MonacoSemanticHighlightingService).inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-keybinding-contexts.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-keybinding-contexts.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var editor_keybinding_contexts_1 = __webpack_require__(/*! @theia/editor/lib/browser/editor-keybinding-contexts */ "../node_modules/@theia/editor/lib/browser/editor-keybinding-contexts.js");
var monaco_editor_1 = __webpack_require__(/*! ./monaco-editor */ "../node_modules/@theia/monaco/lib/browser/monaco-editor.js");
/**
 * Besides checking whether this editor is the currently active one and has the focus, it also checks the followings:
 *  - the suggest widget is visible
 *  - the find (and replace) widget is visible.
 *  - the rename input widget (which we use for refactoring and not find and replace) is visible.
 *
 * If any of the above-mentioned additional checks evaluates to `true` the `canHandle` will evaluate to `false`.
 *
 * See: https://github.com/eamodio/vscode-gitlens/blob/57226d54d1e929be04b02ee31ca294c50305481b/package.json#L2857
 */
var MonacoStrictEditorTextFocusContext = /** @class */ (function (_super) {
    __extends(MonacoStrictEditorTextFocusContext, _super);
    function MonacoStrictEditorTextFocusContext() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MonacoStrictEditorTextFocusContext.prototype.canHandle = function (widget) {
        var editor = widget.editor;
        if (editor instanceof monaco_editor_1.MonacoEditor) {
            return editor.isFocused({ strict: true });
        }
        return _super.prototype.canHandle.call(this, widget);
    };
    MonacoStrictEditorTextFocusContext = __decorate([
        inversify_1.injectable()
    ], MonacoStrictEditorTextFocusContext);
    return MonacoStrictEditorTextFocusContext;
}(editor_keybinding_contexts_1.StrictEditorTextFocusContext));
exports.MonacoStrictEditorTextFocusContext = MonacoStrictEditorTextFocusContext;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-keybinding.js":
/*!**********************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-keybinding.js ***!
  \**********************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var monaco_command_1 = __webpack_require__(/*! ./monaco-command */ "../node_modules/@theia/monaco/lib/browser/monaco-command.js");
var monaco_command_registry_1 = __webpack_require__(/*! ./monaco-command-registry */ "../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js");
var monaco_keycode_map_1 = __webpack_require__(/*! ./monaco-keycode-map */ "../node_modules/@theia/monaco/lib/browser/monaco-keycode-map.js");
var KeybindingsRegistry = monaco.keybindings.KeybindingsRegistry;
function monaco2BrowserKeyCode(keyCode) {
    for (var i = 0; i < monaco_keycode_map_1.KEY_CODE_MAP.length; i++) {
        if (monaco_keycode_map_1.KEY_CODE_MAP[i] === keyCode) {
            return i;
        }
    }
    return -1;
}
var MonacoKeybindingContribution = /** @class */ (function () {
    function MonacoKeybindingContribution() {
    }
    MonacoKeybindingContribution.prototype.registerKeybindings = function (registry) {
        var e_1, _a;
        try {
            for (var _b = __values(KeybindingsRegistry.getDefaultKeybindings()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var item = _c.value;
                var command = this.commands.validate(item.command);
                if (command) {
                    var raw = item.keybinding;
                    if (raw.type === 1 /* Simple */) {
                        var keybinding = raw;
                        // TODO: remove this temporary workaround after updating to monaco including the fix for https://github.com/Microsoft/vscode/issues/49225
                        if (command === 'monaco.editor.action.refactor') {
                            if (monaco.platform.OS !== 2 /* Macintosh */) {
                                keybinding = __assign({}, keybinding, { ctrlKey: true, metaKey: false });
                            }
                        }
                        registry.registerKeybinding({
                            command: command,
                            keybinding: this.keyCode(keybinding).toString(),
                            context: browser_2.EditorKeybindingContexts.editorTextFocus
                        });
                    }
                    else {
                        // FIXME support chord keybindings properly, KeyCode does not allow it right now
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
        // `Select All` is not an editor action just like everything else.
        var selectAllCommand = this.commands.validate(monaco_command_1.MonacoCommands.SELECTION_SELECT_ALL);
        if (selectAllCommand) {
            registry.registerKeybinding({
                command: selectAllCommand,
                keybinding: 'ctrlcmd+a',
                context: browser_2.EditorKeybindingContexts.editorTextFocus
            });
        }
    };
    MonacoKeybindingContribution.prototype.keyCode = function (keybinding) {
        var keyCode = keybinding.keyCode;
        var sequence = {
            first: browser_1.Key.getKey(monaco2BrowserKeyCode(keyCode & 255)),
            modifiers: []
        };
        if (keybinding.ctrlKey) {
            sequence.modifiers.push(browser_1.KeyModifier.CtrlCmd);
        }
        if (keybinding.shiftKey) {
            sequence.modifiers.push(browser_1.KeyModifier.Shift);
        }
        if (keybinding.altKey) {
            sequence.modifiers.push(browser_1.KeyModifier.Alt);
        }
        if (keybinding.metaKey) {
            sequence.modifiers.push(browser_1.KeyModifier.MacCtrl);
        }
        return browser_1.KeyCode.createKeyCode(sequence);
    };
    __decorate([
        inversify_1.inject(monaco_command_registry_1.MonacoCommandRegistry),
        __metadata("design:type", monaco_command_registry_1.MonacoCommandRegistry)
    ], MonacoKeybindingContribution.prototype, "commands", void 0);
    MonacoKeybindingContribution = __decorate([
        inversify_1.injectable()
    ], MonacoKeybindingContribution);
    return MonacoKeybindingContribution;
}());
exports.MonacoKeybindingContribution = MonacoKeybindingContribution;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-languages.js":
/*!*********************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-languages.js ***!
  \*********************************************************************/
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
var __spread = (this && this.__spread) || function () {
    for (var ar = [], i = 0; i < arguments.length; i++) ar = ar.concat(__read(arguments[i]));
    return ar;
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var monaco_languageclient_1 = __webpack_require__(/*! monaco-languageclient */ "../node_modules/monaco-languageclient/lib/index.js");
var problem_manager_1 = __webpack_require__(/*! @theia/markers/lib/browser/problem/problem-manager */ "../node_modules/@theia/markers/lib/browser/problem/problem-manager.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var disposable_1 = __webpack_require__(/*! @theia/core/lib/common/disposable */ "../node_modules/@theia/core/lib/common/disposable.js");
var monaco_diagnostic_collection_1 = __webpack_require__(/*! monaco-languageclient/lib/monaco-diagnostic-collection */ "../node_modules/monaco-languageclient/lib/monaco-diagnostic-collection.js");
inversify_1.decorate(inversify_1.injectable(), monaco_languageclient_1.MonacoLanguages);
inversify_1.decorate(inversify_1.inject(monaco_languageclient_1.ProtocolToMonacoConverter), monaco_languageclient_1.MonacoLanguages, 0);
inversify_1.decorate(inversify_1.inject(monaco_languageclient_1.MonacoToProtocolConverter), monaco_languageclient_1.MonacoLanguages, 1);
var MonacoLanguages = /** @class */ (function (_super) {
    __extends(MonacoLanguages, _super);
    function MonacoLanguages(p2m, m2p, problemManager) {
        var e_1, _a;
        var _this = _super.call(this, p2m, m2p) || this;
        _this.problemManager = problemManager;
        _this.workspaceSymbolProviders = [];
        _this.makers = new Map();
        try {
            for (var _b = __values(_this.problemManager.getUris()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var uri = _c.value;
                _this.updateMarkers(new uri_1.default(uri));
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_1) throw e_1.error; }
        }
        _this.problemManager.onDidChangeMarkers(function (uri) { return _this.updateMarkers(uri); });
        return _this;
    }
    MonacoLanguages.prototype.updateMarkers = function (uri) {
        var e_2, _a, e_3, _b, e_4, _c;
        var uriString = uri.toString();
        var owners = new Map();
        try {
            for (var _d = __values(this.problemManager.findMarkers({ uri: uri })), _e = _d.next(); !_e.done; _e = _d.next()) {
                var marker = _e.value;
                var diagnostics = owners.get(marker.owner) || [];
                diagnostics.push(marker.data);
                owners.set(marker.owner, diagnostics);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_e && !_e.done && (_a = _d.return)) _a.call(_d);
            }
            finally { if (e_2) throw e_2.error; }
        }
        var toClean = new Set(this.makers.keys());
        try {
            for (var owners_1 = __values(owners), owners_1_1 = owners_1.next(); !owners_1_1.done; owners_1_1 = owners_1.next()) {
                var _f = __read(owners_1_1.value, 2), owner = _f[0], diagnostics = _f[1];
                toClean.delete(owner);
                var collection = this.makers.get(owner) || new monaco_diagnostic_collection_1.MonacoDiagnosticCollection(owner, this.p2m);
                collection.set(uriString, diagnostics);
                this.makers.set(owner, collection);
            }
        }
        catch (e_3_1) { e_3 = { error: e_3_1 }; }
        finally {
            try {
                if (owners_1_1 && !owners_1_1.done && (_b = owners_1.return)) _b.call(owners_1);
            }
            finally { if (e_3) throw e_3.error; }
        }
        try {
            for (var toClean_1 = __values(toClean), toClean_1_1 = toClean_1.next(); !toClean_1_1.done; toClean_1_1 = toClean_1.next()) {
                var owner = toClean_1_1.value;
                var collection = this.makers.get(owner);
                if (collection) {
                    collection.set(uriString, []);
                }
            }
        }
        catch (e_4_1) { e_4 = { error: e_4_1 }; }
        finally {
            try {
                if (toClean_1_1 && !toClean_1_1.done && (_c = toClean_1.return)) _c.call(toClean_1);
            }
            finally { if (e_4) throw e_4.error; }
        }
    };
    MonacoLanguages.prototype.createDiagnosticCollection = function (name) {
        var _this = this;
        var owner = name || 'default';
        var uris = [];
        return {
            set: function (uri, diagnostics) {
                _this.problemManager.setMarkers(new uri_1.default(uri), owner, diagnostics);
                uris.push(uri);
            },
            dispose: function () {
                var e_5, _a;
                try {
                    for (var uris_1 = __values(uris), uris_1_1 = uris_1.next(); !uris_1_1.done; uris_1_1 = uris_1.next()) {
                        var uri = uris_1_1.value;
                        _this.problemManager.setMarkers(new uri_1.default(uri), owner, []);
                    }
                }
                catch (e_5_1) { e_5 = { error: e_5_1 }; }
                finally {
                    try {
                        if (uris_1_1 && !uris_1_1.done && (_a = uris_1.return)) _a.call(uris_1);
                    }
                    finally { if (e_5) throw e_5.error; }
                }
            }
        };
    };
    MonacoLanguages.prototype.registerWorkspaceSymbolProvider = function (provider) {
        var _this = this;
        this.workspaceSymbolProviders.push(provider);
        return disposable_1.Disposable.create(function () {
            var index = _this.workspaceSymbolProviders.indexOf(provider);
            if (index !== -1) {
                _this.workspaceSymbolProviders.splice(index, 1);
            }
        });
    };
    Object.defineProperty(MonacoLanguages.prototype, "languages", {
        get: function () {
            return __spread(this.mergeLanguages(monaco.languages.getLanguages()).values());
        },
        enumerable: true,
        configurable: true
    });
    MonacoLanguages.prototype.getLanguage = function (languageId) {
        return this.mergeLanguages(monaco.languages.getLanguages().filter(function (language) { return language.id === languageId; })).get(languageId);
    };
    MonacoLanguages.prototype.mergeLanguages = function (registered) {
        var e_6, _a, e_7, _b, e_8, _c, e_9, _d;
        var languages = new Map();
        try {
            for (var registered_1 = __values(registered), registered_1_1 = registered_1.next(); !registered_1_1.done; registered_1_1 = registered_1.next()) {
                var _e = registered_1_1.value, id = _e.id, aliases = _e.aliases, extensions = _e.extensions, filenames = _e.filenames;
                var merged = languages.get(id) || {
                    id: id,
                    name: '',
                    extensions: new Set(),
                    filenames: new Set()
                };
                if (!merged.name && aliases && aliases.length) {
                    merged.name = aliases[0];
                }
                if (extensions && extensions.length) {
                    try {
                        for (var extensions_1 = __values(extensions), extensions_1_1 = extensions_1.next(); !extensions_1_1.done; extensions_1_1 = extensions_1.next()) {
                            var extension = extensions_1_1.value;
                            merged.extensions.add(extension);
                        }
                    }
                    catch (e_7_1) { e_7 = { error: e_7_1 }; }
                    finally {
                        try {
                            if (extensions_1_1 && !extensions_1_1.done && (_b = extensions_1.return)) _b.call(extensions_1);
                        }
                        finally { if (e_7) throw e_7.error; }
                    }
                }
                if (filenames && filenames.length) {
                    try {
                        for (var filenames_1 = __values(filenames), filenames_1_1 = filenames_1.next(); !filenames_1_1.done; filenames_1_1 = filenames_1.next()) {
                            var filename = filenames_1_1.value;
                            merged.filenames.add(filename);
                        }
                    }
                    catch (e_8_1) { e_8 = { error: e_8_1 }; }
                    finally {
                        try {
                            if (filenames_1_1 && !filenames_1_1.done && (_c = filenames_1.return)) _c.call(filenames_1);
                        }
                        finally { if (e_8) throw e_8.error; }
                    }
                }
                languages.set(id, merged);
            }
        }
        catch (e_6_1) { e_6 = { error: e_6_1 }; }
        finally {
            try {
                if (registered_1_1 && !registered_1_1.done && (_a = registered_1.return)) _a.call(registered_1);
            }
            finally { if (e_6) throw e_6.error; }
        }
        try {
            for (var languages_1 = __values(languages), languages_1_1 = languages_1.next(); !languages_1_1.done; languages_1_1 = languages_1.next()) {
                var _f = __read(languages_1_1.value, 2), id = _f[0], language = _f[1];
                if (!language.name) {
                    language.name = id;
                }
            }
        }
        catch (e_9_1) { e_9 = { error: e_9_1 }; }
        finally {
            try {
                if (languages_1_1 && !languages_1_1.done && (_d = languages_1.return)) _d.call(languages_1);
            }
            finally { if (e_9) throw e_9.error; }
        }
        return languages;
    };
    MonacoLanguages = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(monaco_languageclient_1.ProtocolToMonacoConverter)),
        __param(1, inversify_1.inject(monaco_languageclient_1.MonacoToProtocolConverter)),
        __param(2, inversify_1.inject(problem_manager_1.ProblemManager)),
        __metadata("design:paramtypes", [monaco_languageclient_1.ProtocolToMonacoConverter,
            monaco_languageclient_1.MonacoToProtocolConverter,
            problem_manager_1.ProblemManager])
    ], MonacoLanguages);
    return MonacoLanguages;
}(monaco_languageclient_1.MonacoLanguages));
exports.MonacoLanguages = MonacoLanguages;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-loader.js":
/*!******************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-loader.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
// tslint:disable:no-any
function loadVsRequire(context) {
    // Monaco uses a custom amd loader that over-rides node's require.
    // Keep a reference to an original require so we can restore it after executing the amd loader file.
    var originalRequire = context.require;
    return new Promise(function (resolve) {
        return window.addEventListener('load', function () {
            var vsLoader = document.createElement('script');
            vsLoader.type = 'text/javascript';
            vsLoader.src = './vs/loader.js';
            vsLoader.charset = 'utf-8';
            vsLoader.addEventListener('load', function () {
                // Save Monaco's amd require and restore the original require
                var amdRequire = context.require;
                if (originalRequire) {
                    context.require = originalRequire;
                }
                resolve(amdRequire);
            });
            document.body.appendChild(vsLoader);
        }, { once: true });
    });
}
exports.loadVsRequire = loadVsRequire;
function loadMonaco(vsRequire) {
    return new Promise(function (resolve) {
        vsRequire(['vs/editor/editor.main'], function () {
            vsRequire([
                'vs/language/css/monaco.contribution',
                'vs/language/html/monaco.contribution',
                'vs/platform/commands/common/commands',
                'vs/platform/actions/common/actions',
                'vs/platform/keybinding/common/keybindingsRegistry',
                'vs/platform/keybinding/common/keybindingResolver',
                'vs/platform/keybinding/common/usLayoutResolvedKeybinding',
                'vs/base/common/keyCodes',
                'vs/editor/browser/editorExtensions',
                'vs/editor/standalone/browser/simpleServices',
                'vs/editor/standalone/browser/standaloneServices',
                'vs/base/parts/quickopen/common/quickOpen',
                'vs/base/parts/quickopen/browser/quickOpenWidget',
                'vs/base/parts/quickopen/browser/quickOpenModel',
                'vs/base/common/filters',
                'vs/platform/theme/common/styler',
                'vs/base/common/platform',
                'vs/editor/common/modes',
                'vs/base/common/cancellation',
                'vs/editor/contrib/suggest/suggestController',
                'vs/editor/contrib/find/findController',
                'vs/editor/contrib/rename/rename',
                'vs/editor/contrib/snippet/snippetParser',
                'vs/editor/browser/services/codeEditorServiceImpl'
            ], function (css, html, commands, actions, registry, resolver, resolvedKeybinding, keyCodes, editorExtensions, simpleServices, standaloneServices, quickOpen, quickOpenWidget, quickOpenModel, filters, styler, platform, modes, cancellation, suggestController, findController, rename, snippetParser, codeEditorServiceImpl) {
                var global = self;
                global.monaco.commands = commands;
                global.monaco.actions = actions;
                global.monaco.keybindings = Object.assign({}, registry, resolver, resolvedKeybinding, keyCodes);
                global.monaco.services = Object.assign({}, simpleServices, standaloneServices, codeEditorServiceImpl);
                global.monaco.quickOpen = Object.assign({}, quickOpen, quickOpenWidget, quickOpenModel);
                global.monaco.filters = filters;
                global.monaco.theme = styler;
                global.monaco.platform = platform;
                global.monaco.editorExtensions = editorExtensions;
                global.monaco.modes = modes;
                global.monaco.cancellation = cancellation;
                global.monaco.suggestController = suggestController;
                global.monaco.findController = findController;
                global.monaco.rename = rename;
                global.monaco.snippetParser = snippetParser;
                resolve();
            });
        });
    });
}
exports.loadMonaco = loadMonaco;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-menu.js":
/*!****************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-menu.js ***!
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
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var monaco_command_1 = __webpack_require__(/*! ./monaco-command */ "../node_modules/@theia/monaco/lib/browser/monaco-command.js");
var monaco_command_registry_1 = __webpack_require__(/*! ./monaco-command-registry */ "../node_modules/@theia/monaco/lib/browser/monaco-command-registry.js");
var MenuRegistry = monaco.actions.MenuRegistry;
var MenuId = monaco.actions.MenuId;
var MonacoMenus;
(function (MonacoMenus) {
    MonacoMenus.SELECTION = __spread(common_1.MAIN_MENU_BAR, ['3_selection']);
    MonacoMenus.SELECTION_GROUP = {
        id: '1_selection_group',
        actions: [
            monaco_command_1.MonacoCommands.SELECTION_SELECT_ALL,
            monaco_command_1.MonacoCommands.SELECTION_EXPAND_SELECTION,
            monaco_command_1.MonacoCommands.SELECTION_SHRINK_SELECTION
        ]
    };
    MonacoMenus.SELECTION_MOVE_GROUP = {
        id: '2_copy_move_group',
        actions: [
            monaco_command_1.MonacoCommands.SELECTION_COPY_LINE_UP,
            monaco_command_1.MonacoCommands.SELECTION_COPY_LINE_DOWN,
            monaco_command_1.MonacoCommands.SELECTION_MOVE_LINE_UP,
            monaco_command_1.MonacoCommands.SELECTION_MOVE_LINE_DOWN
        ]
    };
    MonacoMenus.SELECTION_CURSOR_GROUP = {
        id: '3_cursor_group',
        actions: [
            monaco_command_1.MonacoCommands.SELECTION_ADD_CURSOR_ABOVE,
            monaco_command_1.MonacoCommands.SELECTION_ADD_CURSOR_BELOW,
            monaco_command_1.MonacoCommands.SELECTION_ADD_CURSOR_TO_LINE_END,
            monaco_command_1.MonacoCommands.SELECTION_ADD_NEXT_OCCURRENCE,
            monaco_command_1.MonacoCommands.SELECTION_ADD_PREVIOUS_OCCURRENCE,
            monaco_command_1.MonacoCommands.SELECTION_SELECT_ALL_OCCURRENCES
        ]
    };
    MonacoMenus.SELECTION_GROUPS = [
        MonacoMenus.SELECTION_GROUP,
        MonacoMenus.SELECTION_MOVE_GROUP,
        MonacoMenus.SELECTION_CURSOR_GROUP
    ];
})(MonacoMenus = exports.MonacoMenus || (exports.MonacoMenus = {}));
var MonacoEditorMenuContribution = /** @class */ (function () {
    function MonacoEditorMenuContribution(commands) {
        this.commands = commands;
    }
    MonacoEditorMenuContribution.prototype.registerMenus = function (registry) {
        var _this = this;
        var e_1, _a, e_2, _b;
        try {
            for (var _c = __values(MenuRegistry.getMenuItems(MenuId.EditorContext)), _d = _c.next(); !_d.done; _d = _c.next()) {
                var item = _d.value;
                var commandId = this.commands.validate(item.command.id);
                if (commandId) {
                    var menuPath = __spread(browser_1.EDITOR_CONTEXT_MENU, [(item.group || '')]);
                    registry.registerMenuAction(menuPath, { commandId: commandId });
                }
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (_d && !_d.done && (_a = _c.return)) _a.call(_c);
            }
            finally { if (e_1) throw e_1.error; }
        }
        registry.registerSubmenu(MonacoMenus.SELECTION, 'Selection');
        var _loop_1 = function (group) {
            group.actions.forEach(function (action, index) {
                var commandId = _this.commands.validate(action);
                if (commandId) {
                    var path = __spread(MonacoMenus.SELECTION, [group.id]);
                    var order = index.toString();
                    registry.registerMenuAction(path, { commandId: commandId, order: order });
                }
            });
        };
        try {
            for (var _e = __values(MonacoMenus.SELECTION_GROUPS), _f = _e.next(); !_f.done; _f = _e.next()) {
                var group = _f.value;
                _loop_1(group);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_f && !_f.done && (_b = _e.return)) _b.call(_e);
            }
            finally { if (e_2) throw e_2.error; }
        }
    };
    MonacoEditorMenuContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(monaco_command_registry_1.MonacoCommandRegistry)),
        __metadata("design:paramtypes", [monaco_command_registry_1.MonacoCommandRegistry])
    ], MonacoEditorMenuContribution);
    return MonacoEditorMenuContribution;
}());
exports.MonacoEditorMenuContribution = MonacoEditorMenuContribution;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-outline-contribution.js":
/*!********************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-outline-contribution.js ***!
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
var __spread = (this && this.__spread) || function () {
    for (var ar = [], i = 0; i < arguments.length; i++) ar = ar.concat(__read(arguments[i]));
    return ar;
};
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var SymbolKind = monaco.languages.SymbolKind;
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var DocumentSymbolProviderRegistry = monaco.modes.DocumentSymbolProviderRegistry;
var CancellationTokenSource = monaco.cancellation.CancellationTokenSource;
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var outline_view_service_1 = __webpack_require__(/*! @theia/outline-view/lib/browser/outline-view-service */ "../node_modules/@theia/outline-view/lib/browser/outline-view-service.js");
var outline_view_widget_1 = __webpack_require__(/*! @theia/outline-view/lib/browser/outline-view-widget */ "../node_modules/@theia/outline-view/lib/browser/outline-view-widget.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var monaco_editor_1 = __webpack_require__(/*! ./monaco-editor */ "../node_modules/@theia/monaco/lib/browser/monaco-editor.js");
var debounce = __webpack_require__(/*! lodash.debounce */ "../node_modules/lodash.debounce/index.js");
var MonacoOutlineContribution = /** @class */ (function () {
    function MonacoOutlineContribution() {
        this.toDisposeOnClose = new core_1.DisposableCollection();
        this.toDisposeOnEditor = new core_1.DisposableCollection();
        this.canUpdateOutline = true;
        this.tokenSource = new CancellationTokenSource();
    }
    MonacoOutlineContribution.prototype.onStart = function (app) {
        var _this = this;
        this.outlineViewService.onDidChangeOpenState(function (open) { return __awaiter(_this, void 0, void 0, function () {
            var _this = this;
            return __generator(this, function (_a) {
                if (open) {
                    this.toDisposeOnClose.push(this.toDisposeOnEditor);
                    this.toDisposeOnClose.push(DocumentSymbolProviderRegistry.onDidChange(debounce(function () { return _this.updateOutline(); })));
                    this.toDisposeOnClose.push(this.editorManager.onCurrentEditorChanged(debounce(function () { return _this.handleCurrentEditorChanged(); }, 50)));
                    this.handleCurrentEditorChanged();
                }
                else {
                    this.toDisposeOnClose.dispose();
                }
                return [2 /*return*/];
            });
        }); });
        this.outlineViewService.onDidSelect(function (node) { return __awaiter(_this, void 0, void 0, function () {
            var options;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!(MonacoOutlineSymbolInformationNode.is(node) && node.parent)) return [3 /*break*/, 2];
                        options = {
                            mode: 'reveal',
                            selection: node.range
                        };
                        return [4 /*yield*/, this.selectInEditor(node, options)];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        }); });
        this.outlineViewService.onDidOpen(function (node) { return __awaiter(_this, void 0, void 0, function () {
            var options;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!MonacoOutlineSymbolInformationNode.is(node)) return [3 /*break*/, 2];
                        options = {
                            selection: {
                                start: node.range.start
                            }
                        };
                        return [4 /*yield*/, this.selectInEditor(node, options)];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        }); });
    };
    MonacoOutlineContribution.prototype.selectInEditor = function (node, options) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        // Avoid cyclic updates: Outline -> Editor -> Outline.
                        this.canUpdateOutline = false;
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, , 3, 4]);
                        return [4 /*yield*/, this.editorManager.open(node.uri, options)];
                    case 2:
                        _a.sent();
                        return [3 /*break*/, 4];
                    case 3:
                        this.canUpdateOutline = true;
                        return [7 /*endfinally*/];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    MonacoOutlineContribution.prototype.handleCurrentEditorChanged = function () {
        var _this = this;
        this.toDisposeOnEditor.dispose();
        if (this.toDisposeOnClose.disposed) {
            return;
        }
        this.toDisposeOnClose.push(this.toDisposeOnEditor);
        this.toDisposeOnEditor.push(core_1.Disposable.create(function () { return _this.roots = undefined; }));
        var editor = this.editorManager.currentEditor;
        if (editor) {
            var model = monaco_editor_1.MonacoEditor.get(editor).getControl().getModel();
            this.toDisposeOnEditor.push(model.onDidChangeContent(function () {
                _this.roots = undefined; // Invalidate the previously resolved roots.
                _this.updateOutline();
            }));
            this.toDisposeOnEditor.push(editor.editor.onSelectionChanged(function (selection) { return _this.updateOutline(selection); }));
        }
        this.updateOutline();
    };
    MonacoOutlineContribution.prototype.updateOutline = function (editorSelection) {
        return __awaiter(this, void 0, void 0, function () {
            var token, editor, model, roots, _a;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!this.canUpdateOutline) {
                            return [2 /*return*/];
                        }
                        this.tokenSource.cancel();
                        this.tokenSource = new CancellationTokenSource();
                        token = this.tokenSource.token;
                        editor = monaco_editor_1.MonacoEditor.get(this.editorManager.currentEditor);
                        model = editor && editor.getControl().getModel();
                        _a = model;
                        if (!_a) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.createRoots(model, token, editorSelection)];
                    case 1:
                        _a = (_b.sent());
                        _b.label = 2;
                    case 2:
                        roots = _a;
                        if (token.isCancellationRequested) {
                            return [2 /*return*/];
                        }
                        this.outlineViewService.publish(roots || []);
                        return [2 /*return*/];
                }
            });
        });
    };
    MonacoOutlineContribution.prototype.createRoots = function (model, token, editorSelection) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, _b, resetSelection_1, providers, uri, providers_1, providers_1_1, provider, symbols, nodes, _c, e_1_1;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        if (!(this.roots && this.roots.length > 0)) return [3 /*break*/, 1];
                        resetSelection_1 = function (node) {
                            node.selected = false;
                            node.children.forEach(resetSelection_1);
                        };
                        this.roots.forEach(resetSelection_1);
                        return [3 /*break*/, 12];
                    case 1:
                        this.roots = [];
                        return [4 /*yield*/, DocumentSymbolProviderRegistry.all(model)];
                    case 2:
                        providers = _d.sent();
                        if (token.isCancellationRequested) {
                            return [2 /*return*/, []];
                        }
                        uri = new uri_1.default(model.uri.toString());
                        _d.label = 3;
                    case 3:
                        _d.trys.push([3, 10, 11, 12]);
                        providers_1 = __values(providers), providers_1_1 = providers_1.next();
                        _d.label = 4;
                    case 4:
                        if (!!providers_1_1.done) return [3 /*break*/, 9];
                        provider = providers_1_1.value;
                        _d.label = 5;
                    case 5:
                        _d.trys.push([5, 7, , 8]);
                        return [4 /*yield*/, provider.provideDocumentSymbols(model, token)];
                    case 6:
                        symbols = _d.sent();
                        if (token.isCancellationRequested) {
                            return [2 /*return*/, []];
                        }
                        nodes = this.createNodes(uri, symbols);
                        (_b = this.roots).push.apply(_b, __spread(nodes));
                        return [3 /*break*/, 8];
                    case 7:
                        _c = _d.sent();
                        return [3 /*break*/, 8];
                    case 8:
                        providers_1_1 = providers_1.next();
                        return [3 /*break*/, 4];
                    case 9: return [3 /*break*/, 12];
                    case 10:
                        e_1_1 = _d.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 12];
                    case 11:
                        try {
                            if (providers_1_1 && !providers_1_1.done && (_a = providers_1.return)) _a.call(providers_1);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 12:
                        this.applySelection(this.roots, editorSelection);
                        return [2 /*return*/, this.roots];
                }
            });
        });
    };
    MonacoOutlineContribution.prototype.createNodes = function (uri, symbols) {
        var _this = this;
        var e_2, _a, e_3, _b;
        var rangeBased = false;
        var ids = new Map();
        var roots = [];
        var nodesByName = symbols.sort(this.orderByPosition).reduce(function (result, symbol) {
            var node = _this.createNode(uri, symbol, ids);
            if (symbol.children) {
                MonacoOutlineSymbolInformationNode.insert(roots, node);
            }
            else {
                rangeBased = rangeBased || symbol.range.startLineNumber !== symbol.range.endLineNumber;
                var values = result.get(symbol.name) || [];
                values.push({ symbol: symbol, node: node });
                result.set(symbol.name, values);
            }
            return result;
        }, new Map());
        try {
            for (var _c = __values(nodesByName.values()), _d = _c.next(); !_d.done; _d = _c.next()) {
                var nodes = _d.value;
                var _loop_1 = function (node, symbol) {
                    if (!symbol.containerName) {
                        MonacoOutlineSymbolInformationNode.insert(roots, node);
                    }
                    else {
                        var possibleParents = nodesByName.get(symbol.containerName);
                        if (possibleParents) {
                            var parent_1 = possibleParents.find(function (possibleParent) { return _this.parentContains(symbol, possibleParent.symbol, rangeBased); });
                            if (parent_1) {
                                node.parent = parent_1.node;
                                MonacoOutlineSymbolInformationNode.insert(parent_1.node.children, node);
                            }
                        }
                    }
                };
                try {
                    for (var nodes_1 = __values(nodes), nodes_1_1 = nodes_1.next(); !nodes_1_1.done; nodes_1_1 = nodes_1.next()) {
                        var _e = nodes_1_1.value, node = _e.node, symbol = _e.symbol;
                        _loop_1(node, symbol);
                    }
                }
                catch (e_3_1) { e_3 = { error: e_3_1 }; }
                finally {
                    try {
                        if (nodes_1_1 && !nodes_1_1.done && (_b = nodes_1.return)) _b.call(nodes_1);
                    }
                    finally { if (e_3) throw e_3.error; }
                }
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_d && !_d.done && (_a = _c.return)) _a.call(_c);
            }
            finally { if (e_2) throw e_2.error; }
        }
        if (!roots.length) {
            var nodes = nodesByName.values().next().value;
            if (nodes && !nodes[0].node.parent) {
                return [nodes[0].node];
            }
            return [];
        }
        return roots;
    };
    /**
     * Sets the selection on the sub-trees based on the optional editor selection.
     * Select the narrowest node that is strictly contains the editor selection.
     */
    MonacoOutlineContribution.prototype.applySelection = function (roots, editorSelection) {
        var e_4, _a;
        if (editorSelection) {
            try {
                for (var roots_1 = __values(roots), roots_1_1 = roots_1.next(); !roots_1_1.done; roots_1_1 = roots_1.next()) {
                    var root = roots_1_1.value;
                    if (this.parentContains(editorSelection, root.fullRange, true)) {
                        var children = root.children;
                        root.selected = !root.expanded || !this.applySelection(children, editorSelection);
                        return true;
                    }
                }
            }
            catch (e_4_1) { e_4 = { error: e_4_1 }; }
            finally {
                try {
                    if (roots_1_1 && !roots_1_1.done && (_a = roots_1.return)) _a.call(roots_1);
                }
                finally { if (e_4) throw e_4.error; }
            }
        }
        return false;
    };
    /**
     * Returns `true` if `candidate` is strictly contained inside `parent`
     *
     * If the argument is a `DocumentSymbol`, then `getFullRange` will be used to retrieve the range of the underlying symbol.
     */
    MonacoOutlineContribution.prototype.parentContains = function (candidate, parent, rangeBased) {
        // TODO: move this code to the `monaco-languageclient`: https://github.com/theia-ide/theia/pull/2885#discussion_r217800446
        var candidateRange = browser_1.Range.is(candidate) ? candidate : this.getFullRange(candidate);
        var parentRange = browser_1.Range.is(parent) ? parent : this.getFullRange(parent);
        var sameStartLine = candidateRange.start.line === parentRange.start.line;
        var startColGreaterOrEqual = candidateRange.start.character >= parentRange.start.character;
        var startLineGreater = candidateRange.start.line > parentRange.start.line;
        var sameEndLine = candidateRange.end.line === parentRange.end.line;
        var endColSmallerOrEqual = candidateRange.end.character <= parentRange.end.character;
        var endLineSmaller = candidateRange.end.line < parentRange.end.line;
        return (((sameStartLine && startColGreaterOrEqual || startLineGreater) &&
            (sameEndLine && endColSmallerOrEqual || endLineSmaller)) || !rangeBased);
    };
    /**
     * `monaco` to LSP `Range` converter. Converts the `1-based` location indices into `0-based` ones.
     */
    MonacoOutlineContribution.prototype.asRange = function (range) {
        var startLineNumber = range.startLineNumber, startColumn = range.startColumn, endLineNumber = range.endLineNumber, endColumn = range.endColumn;
        return {
            start: {
                line: startLineNumber - 1,
                character: startColumn - 1
            },
            end: {
                line: endLineNumber - 1,
                character: endColumn - 1
            }
        };
    };
    /**
     * Returns with a range enclosing this symbol not including leading/trailing whitespace but everything else like comments.
     * This information is typically used to determine if the clients cursor is inside the symbol to reveal in the symbol in the UI.
     * This allows to obtain the range including the associated comments.
     *
     * See: [`DocumentSymbol#range`](https://microsoft.github.io/language-server-protocol/specification#textDocument_documentSymbol) for more details.
     */
    MonacoOutlineContribution.prototype.getFullRange = function (documentSymbol) {
        return this.asRange(documentSymbol.range);
    };
    /**
     * The range that should be selected and revealed when this symbol is being picked, e.g the name of a function. Must be contained by the `getSelectionRange`.
     *
     * See: [`DocumentSymbol#selectionRange`](https://microsoft.github.io/language-server-protocol/specification#textDocument_documentSymbol) for more details.
     */
    MonacoOutlineContribution.prototype.getNameRange = function (documentSymbol) {
        return this.asRange(documentSymbol.selectionRange);
    };
    MonacoOutlineContribution.prototype.createNode = function (uri, symbol, ids, parent) {
        var e_5, _a;
        var id = this.createId(symbol.name, ids);
        var children = [];
        var node = {
            children: children,
            id: id,
            iconClass: SymbolKind[symbol.kind].toString().toLowerCase(),
            name: this.getName(symbol),
            parent: parent,
            uri: uri,
            range: this.getNameRange(symbol),
            fullRange: this.getFullRange(symbol),
            selected: false,
            expanded: this.shouldExpand(symbol)
        };
        if (symbol.children) {
            try {
                for (var _b = __values(symbol.children), _c = _b.next(); !_c.done; _c = _b.next()) {
                    var child = _c.value;
                    MonacoOutlineSymbolInformationNode.insert(children, this.createNode(uri, child, ids, node));
                }
            }
            catch (e_5_1) { e_5 = { error: e_5_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                }
                finally { if (e_5) throw e_5.error; }
            }
        }
        return node;
    };
    MonacoOutlineContribution.prototype.getName = function (symbol) {
        return symbol.name + (symbol.detail || '');
    };
    MonacoOutlineContribution.prototype.createId = function (name, ids) {
        var counter = ids.get(name);
        var index = typeof counter === 'number' ? counter + 1 : 0;
        ids.set(name, index);
        return name + '_' + index;
    };
    MonacoOutlineContribution.prototype.shouldExpand = function (symbol) {
        return [SymbolKind.Class,
            SymbolKind.Enum, SymbolKind.File,
            SymbolKind.Interface, SymbolKind.Module,
            SymbolKind.Namespace, SymbolKind.Object,
            SymbolKind.Package, SymbolKind.Struct].indexOf(symbol.kind) !== -1;
    };
    MonacoOutlineContribution.prototype.orderByPosition = function (symbol, symbol2) {
        var startLineComparison = symbol.range.startLineNumber - symbol2.range.startLineNumber;
        if (startLineComparison !== 0) {
            return startLineComparison;
        }
        var startOffsetComparison = symbol.range.startColumn - symbol2.range.startColumn;
        if (startOffsetComparison !== 0) {
            return startOffsetComparison;
        }
        var endLineComparison = symbol.range.endLineNumber - symbol2.range.endLineNumber;
        if (endLineComparison !== 0) {
            return endLineComparison;
        }
        return symbol.range.endColumn - symbol2.range.endColumn;
    };
    __decorate([
        inversify_1.inject(outline_view_service_1.OutlineViewService),
        __metadata("design:type", outline_view_service_1.OutlineViewService)
    ], MonacoOutlineContribution.prototype, "outlineViewService", void 0);
    __decorate([
        inversify_1.inject(browser_1.EditorManager),
        __metadata("design:type", browser_1.EditorManager)
    ], MonacoOutlineContribution.prototype, "editorManager", void 0);
    MonacoOutlineContribution = __decorate([
        inversify_1.injectable()
    ], MonacoOutlineContribution);
    return MonacoOutlineContribution;
}());
exports.MonacoOutlineContribution = MonacoOutlineContribution;
var MonacoOutlineSymbolInformationNode;
(function (MonacoOutlineSymbolInformationNode) {
    function is(node) {
        return outline_view_widget_1.OutlineSymbolInformationNode.is(node) && 'uri' in node && 'range' in node;
    }
    MonacoOutlineSymbolInformationNode.is = is;
    function insert(nodes, node) {
        var index = nodes.findIndex(function (current) { return compare(node, current) < 0; });
        if (index === -1) {
            nodes.push(node);
        }
        else {
            nodes.splice(index, 0, node);
        }
    }
    MonacoOutlineSymbolInformationNode.insert = insert;
    function compare(node, node2) {
        var startLineComparison = node.range.start.line - node2.range.start.line;
        if (startLineComparison !== 0) {
            return startLineComparison;
        }
        var startColumnComparison = node.range.start.character - node2.range.start.character;
        if (startColumnComparison !== 0) {
            return startColumnComparison;
        }
        var endLineComparison = node2.range.end.line - node.range.end.line;
        if (endLineComparison !== 0) {
            return endLineComparison;
        }
        return node2.range.end.character - node.range.end.character;
    }
    MonacoOutlineSymbolInformationNode.compare = compare;
})(MonacoOutlineSymbolInformationNode = exports.MonacoOutlineSymbolInformationNode || (exports.MonacoOutlineSymbolInformationNode = {}));


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-quick-input-service.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-quick-input-service.js ***!
  \*******************************************************************************/
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var monaco_quick_open_service_1 = __webpack_require__(/*! ./monaco-quick-open-service */ "../node_modules/@theia/monaco/lib/browser/monaco-quick-open-service.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var promptMessage = "Press 'Enter' to confirm your input or 'Escape' to cancel";
var QuickInputService = /** @class */ (function () {
    function QuickInputService() {
    }
    QuickInputService.prototype.open = function (options) {
        var _this = this;
        options.prompt = this.createPrompt(options.prompt);
        var inputItem = new InputOpenItemOptions(options.prompt);
        this.opts = new MonacoQuickInputControllerOptsImpl({
            onType: function (s, a) { return _this.validateInput(s, a, inputItem); }
        }, options, {
            prefix: options.value,
            placeholder: options.placeHolder ? options.placeHolder : '',
            onClose: function () { return inputItem.resolve(undefined); }
        });
        this.quickOpenService.internalOpen(this.opts);
        return new Promise(function (r) {
            inputItem.resolve = r;
        });
    };
    QuickInputService.prototype.createPrompt = function (prompt) {
        if (prompt) {
            return prompt + " (" + promptMessage + ")";
        }
        else {
            return promptMessage;
        }
    };
    QuickInputService.prototype.validateInput = function (str, acceptor, inputItem) {
        var _this = this;
        inputItem.currentText = str;
        acceptor([new browser_1.QuickOpenItem(inputItem)]);
        if (this.opts && this.opts.validateInput) {
            var hint = this.opts.validateInput(str);
            if (hint) {
                if (typeof hint !== 'string') {
                    hint.then(function (p) {
                        if (p) {
                            _this.setValidationState(inputItem, p, false);
                        }
                        else {
                            _this.setValidationState(inputItem, _this.opts.prompt, true);
                        }
                    });
                }
                else {
                    this.setValidationState(inputItem, hint, false);
                }
            }
            else {
                this.setValidationState(inputItem, this.opts.prompt, true);
            }
        }
    };
    QuickInputService.prototype.setValidationState = function (inputItem, label, isValid) {
        this.quickOpenService.clearInputDecoration();
        inputItem.isValid = isValid;
        inputItem.label = label;
        if (isValid) {
            this.quickOpenService.clearInputDecoration();
        }
        else {
            this.quickOpenService.showInputDecoration(monaco.MarkerSeverity.Error);
        }
    };
    __decorate([
        inversify_1.inject(monaco_quick_open_service_1.MonacoQuickOpenService),
        __metadata("design:type", monaco_quick_open_service_1.MonacoQuickOpenService)
    ], QuickInputService.prototype, "quickOpenService", void 0);
    QuickInputService = __decorate([
        inversify_1.injectable()
    ], QuickInputService);
    return QuickInputService;
}());
exports.QuickInputService = QuickInputService;
var InputOpenItemOptions = /** @class */ (function () {
    function InputOpenItemOptions(label) {
        this.label = label;
        this.isValid = true;
    }
    InputOpenItemOptions.prototype.run = function (mode) {
        if (this.isValid && mode === browser_1.QuickOpenMode.OPEN) {
            this.resolve(this.currentText);
            return true;
        }
        return false;
    };
    return InputOpenItemOptions;
}());
var MonacoQuickInputControllerOptsImpl = /** @class */ (function (_super) {
    __extends(MonacoQuickInputControllerOptsImpl, _super);
    function MonacoQuickInputControllerOptsImpl(model, inputOptions, options) {
        var _this = _super.call(this, model, options) || this;
        if (inputOptions.password) {
            _this.password = inputOptions.password;
        }
        if (inputOptions.prompt) {
            _this.prompt = inputOptions.prompt;
        }
        if (inputOptions.ignoreFocusOut) {
            _this.ignoreFocusOut = inputOptions.ignoreFocusOut;
        }
        if (inputOptions.validateInput) {
            _this.validateInput = inputOptions.validateInput;
        }
        return _this;
    }
    return MonacoQuickInputControllerOptsImpl;
}(monaco_quick_open_service_1.MonacoQuickOpenControllerOptsImpl));


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-semantic-highlighting-service.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-semantic-highlighting-service.js ***!
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var logger_1 = __webpack_require__(/*! @theia/core/lib/common/logger */ "../node_modules/@theia/core/lib/common/logger.js");
var editor_manager_1 = __webpack_require__(/*! @theia/editor/lib/browser/editor-manager */ "../node_modules/@theia/editor/lib/browser/editor-manager.js");
var disposable_1 = __webpack_require__(/*! @theia/core/lib/common/disposable */ "../node_modules/@theia/core/lib/common/disposable.js");
var semantic_highlighting_service_1 = __webpack_require__(/*! @theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service */ "../node_modules/@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service.js");
var monaco_editor_1 = __webpack_require__(/*! ./monaco-editor */ "../node_modules/@theia/monaco/lib/browser/monaco-editor.js");
var MonacoSemanticHighlightingService = /** @class */ (function (_super) {
    __extends(MonacoSemanticHighlightingService, _super);
    function MonacoSemanticHighlightingService() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.decorations = new Map();
        _this.toDisposeOnEditorClose = new Map();
        return _this;
    }
    MonacoSemanticHighlightingService.prototype.decorate = function (languageId, uri, ranges) {
        return __awaiter(this, void 0, void 0, function () {
            var editor, key, newDecorations, oldDecorations, newState, decorationIds;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.editor(uri)];
                    case 1:
                        editor = _a.sent();
                        if (!editor) {
                            return [2 /*return*/];
                        }
                        key = uri.toString();
                        if (!this.toDisposeOnEditorClose.has(key)) {
                            this.toDisposeOnEditorClose.set(key, new disposable_1.DisposableCollection(editor.onDispose(function () { return _this.deleteDecorations(key, editor); })));
                        }
                        newDecorations = ranges.map(function (range) { return _this.toDecoration(languageId, range); });
                        oldDecorations = this.oldDecorations(key, editor, ranges);
                        newState = editor.deltaDecorations({
                            newDecorations: newDecorations,
                            oldDecorations: oldDecorations
                        });
                        decorationIds = this.decorationIds(key);
                        newState.forEach(function (id) { return decorationIds.add(id); });
                        this.decorations.set(key, decorationIds);
                        return [2 /*return*/];
                }
            });
        });
    };
    MonacoSemanticHighlightingService.prototype.dispose = function () {
        Array.from(this.toDisposeOnEditorClose.values()).forEach(function (disposable) { return disposable.dispose(); });
    };
    MonacoSemanticHighlightingService.prototype.decorationIds = function (uri) {
        return this.decorations.get(typeof uri === 'string' ? uri : uri.toString()) || new Set();
    };
    MonacoSemanticHighlightingService.prototype.editor = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var editorWidget;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.editorManager.getByUri(typeof uri === 'string' ? new uri_1.default(uri) : uri)];
                    case 1:
                        editorWidget = _a.sent();
                        if (!!editorWidget && editorWidget.editor instanceof monaco_editor_1.MonacoEditor) {
                            return [2 /*return*/, editorWidget.editor];
                        }
                        return [2 /*return*/, undefined];
                }
            });
        });
    };
    MonacoSemanticHighlightingService.prototype.model = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var editor;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.editor(uri)];
                    case 1:
                        editor = _a.sent();
                        if (editor) {
                            return [2 /*return*/, editor.getControl().getModel()];
                        }
                        return [2 /*return*/, undefined];
                }
            });
        });
    };
    /**
     * Returns all the semantic highlighting decoration IDs that are affected by any of the range arguments.
     */
    MonacoSemanticHighlightingService.prototype.oldDecorations = function (uri, editor, ranges) {
        var ids = this.decorationIds(uri);
        var affectedLines = Array.from(new Set(ranges.map(function (r) { return [r.start.line, r.end.line]; }).reduce(function (prev, curr) { return prev.concat(curr); }, [])));
        return affectedLines
            .map(function (line) { return editor.getLinesDecorations(line, line); })
            .reduce(function (prev, curr) { return prev.concat(curr); }, [])
            .map(function (decoration) { return decoration.id; })
            .filter(function (id) { return ids.has(id); });
    };
    MonacoSemanticHighlightingService.prototype.deleteDecorations = function (uri, editor) {
        var ids = this.decorations.get(uri);
        if (ids) {
            var oldDecorations = Array.from(ids);
            editor.deltaDecorations({
                newDecorations: [],
                oldDecorations: oldDecorations
            });
            this.decorations.delete(uri);
        }
        var disposable = this.toDisposeOnEditorClose.get(uri);
        if (disposable) {
            disposable.dispose();
        }
        this.toDisposeOnEditorClose.delete(uri);
    };
    MonacoSemanticHighlightingService.prototype.toDecoration = function (languageId, range) {
        var start = range.start, end = range.end;
        var scopes = range.scope !== undefined ? this.scopesFor(languageId, range.scope) : [];
        var options = this.toOptions(scopes);
        return {
            range: semantic_highlighting_service_1.Range.create(start, end),
            options: options
        };
    };
    MonacoSemanticHighlightingService.prototype.toOptions = function (scopes) {
        var e_1, _a;
        try {
            // TODO: why for-of? How to pick the right scope? Is it fine to get the first element (with the narrowest scope)?
            for (var scopes_1 = __values(scopes), scopes_1_1 = scopes_1.next(); !scopes_1_1.done; scopes_1_1 = scopes_1.next()) {
                var scope = scopes_1_1.value;
                var metadata = this.tokenTheme().match(undefined, scope);
                var inlineClassName = monaco.modes.TokenMetadata.getClassNameFromMetadata(metadata);
                return {
                    inlineClassName: inlineClassName
                };
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (scopes_1_1 && !scopes_1_1.done && (_a = scopes_1.return)) _a.call(scopes_1);
            }
            finally { if (e_1) throw e_1.error; }
        }
        return {};
    };
    MonacoSemanticHighlightingService.prototype.tokenTheme = function () {
        return monaco.services.StaticServices.standaloneThemeService.get().getTheme().tokenTheme;
    };
    __decorate([
        inversify_1.inject(logger_1.ILogger),
        __metadata("design:type", Object)
    ], MonacoSemanticHighlightingService.prototype, "logger", void 0);
    __decorate([
        inversify_1.inject(editor_manager_1.EditorManager),
        __metadata("design:type", editor_manager_1.EditorManager)
    ], MonacoSemanticHighlightingService.prototype, "editorManager", void 0);
    MonacoSemanticHighlightingService = __decorate([
        inversify_1.injectable()
    ], MonacoSemanticHighlightingService);
    return MonacoSemanticHighlightingService;
}(semantic_highlighting_service_1.SemanticHighlightingService));
exports.MonacoSemanticHighlightingService = MonacoSemanticHighlightingService;


/***/ }),

/***/ "../node_modules/@theia/monaco/lib/browser/monaco-status-bar-contribution.js":
/*!***********************************************************************************!*\
  !*** ../node_modules/@theia/monaco/lib/browser/monaco-status-bar-contribution.js ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

/********************************************************************************
 * Copyright (C) 2018 Ericsson
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var monaco_editor_1 = __webpack_require__(/*! ./monaco-editor */ "../node_modules/@theia/monaco/lib/browser/monaco-editor.js");
var MonacoStatusBarContribution = /** @class */ (function () {
    function MonacoStatusBarContribution(editorManager, statusBar) {
        this.editorManager = editorManager;
        this.statusBar = statusBar;
        this.toDispose = new core_1.DisposableCollection();
    }
    MonacoStatusBarContribution.prototype.onStart = function (app) {
        var _this = this;
        this.updateStatusBar();
        this.editorManager.onCurrentEditorChanged(function () { return _this.updateStatusBar(); });
    };
    MonacoStatusBarContribution.prototype.updateStatusBar = function () {
        var _this = this;
        var editor = this.editorManager.currentEditor;
        var editorModel = this.getModel(editor);
        if (editor && editorModel) {
            this.setConfigTabSizeWidget();
            this.toDispose.dispose();
            this.toDispose.push(editorModel.onDidChangeOptions(function () {
                _this.setConfigTabSizeWidget();
            }));
        }
        else {
            this.removeConfigTabSizeWidget();
        }
    };
    MonacoStatusBarContribution.prototype.setConfigTabSizeWidget = function () {
        var editor = this.editorManager.currentEditor;
        var editorModel = this.getModel(editor);
        if (editor && editorModel) {
            var modelOptions = editorModel.getOptions();
            var tabSize = modelOptions.tabSize;
            var useSpaceOrTab = modelOptions.insertSpaces ? 'Spaces' : 'Tab Size';
            this.statusBar.setElement('editor-status-tabbing-config', {
                text: useSpaceOrTab + ": " + tabSize,
                alignment: browser_1.StatusBarAlignment.RIGHT,
                priority: 10,
                command: browser_2.EditorCommands.CONFIG_INDENTATION.id
            });
        }
    };
    MonacoStatusBarContribution.prototype.removeConfigTabSizeWidget = function () {
        this.statusBar.removeElement('editor-status-tabbing-config');
    };
    MonacoStatusBarContribution.prototype.getModel = function (editor) {
        var monacoEditor = monaco_editor_1.MonacoEditor.get(editor);
        return monacoEditor && monacoEditor.getControl().getModel();
    };
    MonacoStatusBarContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_2.EditorManager)),
        __param(1, inversify_1.inject(browser_1.StatusBar)),
        __metadata("design:paramtypes", [browser_2.EditorManager, Object])
    ], MonacoStatusBarContribution);
    return MonacoStatusBarContribution;
}());
exports.MonacoStatusBarContribution = MonacoStatusBarContribution;


/***/ }),

/***/ "../node_modules/@theia/monaco/src/browser/style/index.css":
/*!*****************************************************************!*\
  !*** ../node_modules/@theia/monaco/src/browser/style/index.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/monaco/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/monaco/src/browser/style/symbol-icons.css":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/monaco/src/browser/style/symbol-icons.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./symbol-icons.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/monaco/src/browser/style/symbol-icons.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/monaco/src/browser/style/symbol-sprite.svg":
/*!*************************************************************************!*\
  !*** ../node_modules/@theia/monaco/src/browser/style/symbol-sprite.svg ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "cf2aabacdc2b3a5768b03545cb1d8330.svg";

/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/monaco/src/browser/style/index.css":
/*!********************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/monaco/src/browser/style/index.css ***!
  \********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/* FIXME when https://github.com/Microsoft/monaco-editor/issues/113#issuecomment-240406949 is fixed */\n.monaco-editor .inputarea {\n    position: fixed !important;\n    top: 0 !important;\n    left: 0 !important;\n}\n\n.monaco-editor {\n    padding-bottom: 5.6px;\n    font-family: var(--theia-ui-font-family);\n    font-size: inherit !important;\n}\n\n.monaco-editor, .monaco-editor-background {\n    background: var(--theia-layout-color0);\n}\n\n.monaco-editor .margin {\n    background: var(--theia-layout-color0);\n}\n\n.monaco-keybinding-key {\n    color: var(--theia-ui-font-color1) !important;\n}\n\n/* \n * set z-index to 0, so tabs are not above overlay widgets \n */\n.p-TabBar.theia-app-centers {\n    z-index: 0;\n    display: flex;\n}\n\n/*\n * we need to disable the background image when using font awesome icons\n */\n.monaco-quick-open-widget .quick-open-tree .quick-open-entry .quick-open-entry-icon.fa {\n    background-image: none;    \n    margin-right: 0px;\n}\n\n/*\n * we need to disable the background image when using file-icons\n */\n.monaco-quick-open-widget .quick-open-tree .quick-open-entry .quick-open-entry-icon.file-icon {\n    background-image: none;    \n    margin-right: 0px;\n}\n\n.monaco-tree-row  {\n    padding-right: 11px;\n}\n\n.quick-open-entry .quick-open-row .monaco-icon-label .monaco-icon-label-description-container .monaco-highlighted-label .highlight {\n    color: var(--theia-accent-color1);\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/monaco/src/browser/style/symbol-icons.css":
/*!***************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/monaco/src/browser/style/symbol-icons.css ***!
  \***************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var escape = __webpack_require__(/*! ../../../../../css-loader/lib/url/escape.js */ "../node_modules/css-loader/lib/url/escape.js");
exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".symbol-icon {\n    background-image: url(" + escape(__webpack_require__(/*! ./symbol-sprite.svg */ "../node_modules/@theia/monaco/src/browser/style/symbol-sprite.svg")) + ");\n    background-repeat: no-repeat;\n    overflow: hidden;\n    min-width: 16px;\n    height: 16px;\n    margin-right: 4px;\n}\n\n.symbol-icon-center {\n    align-self: center;\n}\n\n.symbol-icon.method {\n    background-position: 0 calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.constant,\n.symbol-icon.variable {\n    background-position: -22px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.class {\n    background-position: -42px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.interface {\n    background-position: -62px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.module {\n    background-position: -82px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.property {\n    background-position: -102px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.enum {\n    background-position: -122px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.rule {\n    background-position: -242px calc(var(--theia-sprite-y-offset));\n}\n\n.symbol-icon.file {\n    background-position: -262px calc(var(--theia-sprite-y-offset));\n}", ""]);

// exports


/***/ })

}]);
//# sourceMappingURL=28.bundle.js.map