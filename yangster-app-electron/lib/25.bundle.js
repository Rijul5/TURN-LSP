(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[25],{

/***/ "../node_modules/@theia/core/lib/node/file-uri.js":
/*!********************************************************!*\
  !*** ../node_modules/@theia/core/lib/node/file-uri.js ***!
  \********************************************************/
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
var vscode_uri_1 = __webpack_require__(/*! vscode-uri */ "../node_modules/vscode-uri/lib/esm/index.js");
var uri_1 = __webpack_require__(/*! ../common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var FileUri;
(function (FileUri) {
    /**
     * Creates a new file URI from the filesystem path argument.
     * @param fsPath the filesystem path.
     */
    function create(fsPath_) {
        return new uri_1.default(vscode_uri_1.default.file(fsPath_));
    }
    FileUri.create = create;
    /**
     * Returns with the platform specific FS path that is represented by the URI argument.
     *
     * @param uri the file URI that has to be resolved to a platform specific FS path.
     */
    function fsPath(uri) {
        if (typeof uri === 'string') {
            return fsPath(new uri_1.default(uri));
        }
        else {
            return uri.codeUri.fsPath;
        }
    }
    FileUri.fsPath = fsPath;
})(FileUri = exports.FileUri || (exports.FileUri = {}));


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/blame/blame-contribution.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/blame/blame-contribution.js ***!
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
var blame_decorator_1 = __webpack_require__(/*! ./blame-decorator */ "../node_modules/@theia/git/lib/browser/blame/blame-decorator.js");
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var blame_manager_1 = __webpack_require__(/*! ./blame-manager */ "../node_modules/@theia/git/lib/browser/blame/blame-manager.js");
var git_view_contribution_1 = __webpack_require__(/*! ../git-view-contribution */ "../node_modules/@theia/git/lib/browser/git-view-contribution.js");
var debounce = __webpack_require__(/*! lodash.debounce */ "../node_modules/lodash.debounce/index.js");
var BlameCommands;
(function (BlameCommands) {
    BlameCommands.TOGGLE_GIT_ANNOTATIONS = {
        id: 'git.editor.toggle.annotations',
        label: 'Git: Toggle Blame Annotations'
    };
    BlameCommands.CLEAR_GIT_ANNOTATIONS = {
        id: 'git.editor.clear.annotations'
    };
})(BlameCommands = exports.BlameCommands || (exports.BlameCommands = {}));
var BlameContribution = /** @class */ (function () {
    function BlameContribution() {
        this.appliedDecorations = new Map();
    }
    BlameContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(BlameCommands.TOGGLE_GIT_ANNOTATIONS, {
            execute: function () {
                var editorWidget = _this.currentFileEditorWidget;
                if (editorWidget) {
                    if (_this.showsBlameAnnotations(editorWidget.editor.uri)) {
                        _this.clearBlame(editorWidget.editor.uri);
                    }
                    else {
                        _this.showBlame(editorWidget);
                    }
                }
            },
            isVisible: function () {
                return !!_this.currentFileEditorWidget;
            },
            isEnabled: function () {
                var editorWidget = _this.currentFileEditorWidget;
                return !!editorWidget && _this.isBlameable(editorWidget.editor.uri);
            }
        });
        commands.registerCommand(BlameCommands.CLEAR_GIT_ANNOTATIONS, {
            execute: function () {
                var editorWidget = _this.currentFileEditorWidget;
                if (editorWidget) {
                    _this.clearBlame(editorWidget.editor.uri);
                }
            },
            isVisible: function () {
                return !!_this.currentFileEditorWidget;
            },
            isEnabled: function () {
                var editorWidget = _this.currentFileEditorWidget;
                var enabled = !!editorWidget && _this.showsBlameAnnotations(editorWidget.editor.uri);
                return enabled;
            }
        });
    };
    BlameContribution.prototype.showsBlameAnnotations = function (uri) {
        return this.appliedDecorations.has(uri.toString());
    };
    Object.defineProperty(BlameContribution.prototype, "currentFileEditorWidget", {
        get: function () {
            var editorWidget = this.editorManager.currentEditor;
            if (editorWidget) {
                if (editorWidget.editor.uri.scheme === 'file') {
                    return editorWidget;
                }
            }
            return undefined;
        },
        enumerable: true,
        configurable: true
    });
    BlameContribution.prototype.isBlameable = function (uri) {
        return this.blameManager.isBlameable(uri.toString());
    };
    BlameContribution.prototype.showBlame = function (editorWidget) {
        return __awaiter(this, void 0, void 0, function () {
            var uri, editor, document, content, blame, toDispose_1;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        uri = editorWidget.editor.uri.toString();
                        if (this.appliedDecorations.get(uri)) {
                            return [2 /*return*/];
                        }
                        editor = editorWidget.editor;
                        document = editor.document;
                        content = document.dirty ? document.getText() : undefined;
                        return [4 /*yield*/, this.blameManager.getBlame(uri, content)];
                    case 1:
                        blame = _a.sent();
                        if (blame) {
                            toDispose_1 = new common_1.DisposableCollection();
                            this.appliedDecorations.set(uri, toDispose_1);
                            toDispose_1.push(this.decorator.decorate(blame, editor, editor.cursor.line));
                            toDispose_1.push(editor.onDocumentContentChanged(function () { return _this.clearBlame(uri); }));
                            toDispose_1.push(editor.onCursorPositionChanged(debounce(function (_position) {
                                if (!toDispose_1.disposed) {
                                    _this.decorator.decorate(blame, editor, editor.cursor.line);
                                }
                            }, 50)));
                            editorWidget.disposed.connect(function () { return _this.clearBlame(uri); });
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    BlameContribution.prototype.clearBlame = function (uri) {
        var decorations = this.appliedDecorations.get(uri.toString());
        if (decorations) {
            this.appliedDecorations.delete(uri.toString());
            decorations.dispose();
        }
    };
    BlameContribution.prototype.registerMenus = function (menus) {
        menus.registerMenuAction(git_view_contribution_1.EDITOR_CONTEXT_MENU_GIT, {
            commandId: BlameCommands.TOGGLE_GIT_ANNOTATIONS.id,
            label: BlameCommands.TOGGLE_GIT_ANNOTATIONS.label.slice('Git: '.length)
        });
    };
    BlameContribution.prototype.registerKeybindings = function (keybindings) {
        keybindings.registerKeybinding({
            command: BlameCommands.TOGGLE_GIT_ANNOTATIONS.id,
            context: browser_1.EditorKeybindingContexts.editorTextFocus,
            keybinding: 'alt+b'
        });
        keybindings.registerKeybinding({
            command: BlameCommands.CLEAR_GIT_ANNOTATIONS.id,
            context: BlameAnnotationsKeybindingContext.showsBlameAnnotations,
            keybinding: 'esc'
        });
    };
    __decorate([
        inversify_1.inject(browser_1.EditorManager),
        __metadata("design:type", browser_1.EditorManager)
    ], BlameContribution.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(blame_decorator_1.BlameDecorator),
        __metadata("design:type", blame_decorator_1.BlameDecorator)
    ], BlameContribution.prototype, "decorator", void 0);
    __decorate([
        inversify_1.inject(blame_manager_1.BlameManager),
        __metadata("design:type", blame_manager_1.BlameManager)
    ], BlameContribution.prototype, "blameManager", void 0);
    BlameContribution = __decorate([
        inversify_1.injectable()
    ], BlameContribution);
    return BlameContribution;
}());
exports.BlameContribution = BlameContribution;
var BlameAnnotationsKeybindingContext = /** @class */ (function (_super) {
    __extends(BlameAnnotationsKeybindingContext, _super);
    function BlameAnnotationsKeybindingContext() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.id = BlameAnnotationsKeybindingContext_1.showsBlameAnnotations;
        return _this;
    }
    BlameAnnotationsKeybindingContext_1 = BlameAnnotationsKeybindingContext;
    BlameAnnotationsKeybindingContext.prototype.canHandle = function (widget) {
        return this.base.isEnabled() && this.blameContribution.showsBlameAnnotations(widget.editor.uri);
    };
    var BlameAnnotationsKeybindingContext_1;
    __decorate([
        inversify_1.inject(BlameContribution),
        __metadata("design:type", BlameContribution)
    ], BlameAnnotationsKeybindingContext.prototype, "blameContribution", void 0);
    __decorate([
        inversify_1.inject(browser_1.StrictEditorTextFocusContext),
        __metadata("design:type", browser_1.StrictEditorTextFocusContext)
    ], BlameAnnotationsKeybindingContext.prototype, "base", void 0);
    BlameAnnotationsKeybindingContext = BlameAnnotationsKeybindingContext_1 = __decorate([
        inversify_1.injectable()
    ], BlameAnnotationsKeybindingContext);
    return BlameAnnotationsKeybindingContext;
}(browser_1.EditorTextFocusContext));
exports.BlameAnnotationsKeybindingContext = BlameAnnotationsKeybindingContext;
(function (BlameAnnotationsKeybindingContext) {
    BlameAnnotationsKeybindingContext.showsBlameAnnotations = 'showsBlameAnnotations';
})(BlameAnnotationsKeybindingContext = exports.BlameAnnotationsKeybindingContext || (exports.BlameAnnotationsKeybindingContext = {}));
exports.BlameAnnotationsKeybindingContext = BlameAnnotationsKeybindingContext;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/blame/blame-decorator.js":
/*!***********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/blame/blame-decorator.js ***!
  \***********************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var moment = __webpack_require__(/*! moment */ "../node_modules/moment/moment.js");
var browser_2 = __webpack_require__(/*! @theia/languages/lib/browser */ "../node_modules/@theia/languages/lib/browser/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var BlameDecorator = /** @class */ (function () {
    function BlameDecorator() {
        this.emptyHover = { contents: '' };
        this.appliedDecorations = new Map();
        this.now = moment();
    }
    BlameDecorator_1 = BlameDecorator;
    BlameDecorator.prototype.registerHoverProvider = function (uri) {
        if (this.languages.registerHoverProvider) {
            return this.languages.registerHoverProvider([{ pattern: new uri_1.default(uri).withoutScheme().toString() }], this);
        }
        return core_1.Disposable.NULL;
    };
    BlameDecorator.prototype.provideHover = function (params, token) {
        return __awaiter(this, void 0, void 0, function () {
            var line, uri, applications, blame, commitLine, sha, commit, date, commitMessage, message, hover;
            return __generator(this, function (_a) {
                line = params.position.line;
                uri = params.textDocument.uri;
                applications = this.appliedDecorations.get(uri);
                if (!applications) {
                    return [2 /*return*/, this.emptyHover];
                }
                blame = applications.blame;
                if (!blame) {
                    return [2 /*return*/, this.emptyHover];
                }
                commitLine = blame.lines.find(function (l) { return l.line === line; });
                if (!commitLine) {
                    return [2 /*return*/, this.emptyHover];
                }
                sha = commitLine.sha;
                commit = blame.commits.find(function (c) { return c.sha === sha; });
                date = new Date(commit.author.timestamp);
                commitMessage = commit.summary + '\n' + (commit.body || '');
                commitMessage = commitMessage.replace(/[`\>\#\*\_\-\+]/g, '\\$&').replace(/\n/g, '  \n');
                message = commit.sha + "\n \n " + commit.author.name + ", " + date.toString() + "\n \n> " + commitMessage;
                hover = {
                    contents: [message],
                    range: browser_1.Range.create(browser_1.Position.create(line, 0), browser_1.Position.create(line, 10 ^ 10))
                };
                return [2 /*return*/, hover];
            });
        });
    };
    BlameDecorator.prototype.decorate = function (blame, editor, highlightLine) {
        var _this = this;
        var _a;
        var uri = editor.uri.toString();
        var applications = this.appliedDecorations.get(uri);
        if (!applications) {
            var that_1 = applications = new AppliedBlameDecorations();
            this.appliedDecorations.set(uri, applications);
            applications.toDispose.push(this.registerHoverProvider(uri));
            applications.toDispose.push(core_1.Disposable.create(function () {
                _this.appliedDecorations.delete(uri);
            }));
            applications.toDispose.push(core_1.Disposable.create(function () {
                editor.deltaDecorations({ oldDecorations: that_1.previousDecorations, newDecorations: [] });
            }));
        }
        if (applications.highlightedSha) {
            var sha = this.getShaForLine(blame, highlightLine);
            if (applications.highlightedSha === sha) {
                return applications;
            }
            applications.highlightedSha = sha;
        }
        var blameDecorations = this.toDecorations(blame, highlightLine);
        applications.previousStyles.dispose();
        applications.previousStyles.pushAll(blameDecorations.styles);
        var newDecorations = blameDecorations.editorDecorations;
        var oldDecorations = applications.previousDecorations;
        var appliedDecorations = editor.deltaDecorations({ oldDecorations: oldDecorations, newDecorations: newDecorations });
        applications.previousDecorations.length = 0;
        (_a = applications.previousDecorations).push.apply(_a, __spread(appliedDecorations));
        applications.blame = blame;
        return applications;
    };
    BlameDecorator.prototype.getShaForLine = function (blame, line) {
        var commitLines = blame.lines;
        var commitLine = commitLines.find(function (c) { return c.line === line; });
        return commitLine ? commitLine.sha : undefined;
    };
    BlameDecorator.prototype.toDecorations = function (blame, highlightLine) {
        var e_1, _a, e_2, _b;
        var beforeContentStyles = new Map();
        var commits = blame.commits;
        var _loop_1 = function (commit) {
            var sha = commit.sha;
            var commitTime = moment(commit.author.timestamp);
            var heat = this_1.getHeatColor(commitTime);
            var content = this_1.formatContentLine(commit, commitTime);
            var short = sha.substr(0, 7);
            var selector = 'git-' + short + '::before';
            beforeContentStyles.set(sha, new browser_1.EditorDecorationStyle(selector, function (style) {
                browser_1.EditorDecorationStyle.copyStyle(BlameDecorator_1.defaultGutterStyles, style);
                style.content = "'" + content + "'";
                style.borderColor = heat;
            }));
        };
        var this_1 = this;
        try {
            for (var commits_1 = __values(commits), commits_1_1 = commits_1.next(); !commits_1_1.done; commits_1_1 = commits_1.next()) {
                var commit = commits_1_1.value;
                _loop_1(commit);
            }
        }
        catch (e_1_1) { e_1 = { error: e_1_1 }; }
        finally {
            try {
                if (commits_1_1 && !commits_1_1.done && (_a = commits_1.return)) _a.call(commits_1);
            }
            finally { if (e_1) throw e_1.error; }
        }
        var commitLines = blame.lines;
        var highlightedSha = this.getShaForLine(blame, highlightLine) || '';
        var previousLineSha = '';
        var editorDecorations = [];
        try {
            for (var commitLines_1 = __values(commitLines), commitLines_1_1 = commitLines_1.next(); !commitLines_1_1.done; commitLines_1_1 = commitLines_1.next()) {
                var commitLine = commitLines_1_1.value;
                var line = commitLine.line, sha = commitLine.sha;
                var beforeContentClassName = beforeContentStyles.get(sha).className;
                var options = {
                    beforeContentClassName: beforeContentClassName,
                };
                if (sha === highlightedSha) {
                    options.beforeContentClassName += ' ' + BlameDecorator_1.highlightStyle.className;
                }
                if (sha === previousLineSha) {
                    options.beforeContentClassName += ' ' + BlameDecorator_1.continuationStyle.className;
                }
                previousLineSha = sha;
                var range = browser_1.Range.create(browser_1.Position.create(line, 0), browser_1.Position.create(line, 0));
                editorDecorations.push({ range: range, options: options });
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (commitLines_1_1 && !commitLines_1_1.done && (_b = commitLines_1.return)) _b.call(commitLines_1);
            }
            finally { if (e_2) throw e_2.error; }
        }
        var styles = __spread(beforeContentStyles.values());
        return { editorDecorations: editorDecorations, styles: styles };
    };
    BlameDecorator.prototype.formatContentLine = function (commit, commitTime) {
        var when = commitTime.fromNow();
        var contentWidth = BlameDecorator_1.maxWidth - when.length - 2;
        var content = commit.summary.substring(0, contentWidth + 1);
        content = content.replace('\n', '↩︎');
        if (content.length > contentWidth) {
            var cropAt = content.lastIndexOf(' ', contentWidth - 4);
            if (cropAt < contentWidth / 2) {
                cropAt = contentWidth - 3;
            }
            content = content.substring(0, cropAt) + '...';
        }
        if (content.length < contentWidth) {
            content = content + '\u2007'.repeat(contentWidth - content.length); // fill up with blanks
        }
        return content + " " + when;
    };
    BlameDecorator.prototype.getHeatColor = function (commitTime) {
        var daysFromNow = this.now.diff(commitTime, 'days');
        if (daysFromNow <= 2) {
            return 'var(--md-orange-50)';
        }
        if (daysFromNow <= 5) {
            return 'var(--md-orange-100)';
        }
        if (daysFromNow <= 10) {
            return 'var(--md-orange-200)';
        }
        if (daysFromNow <= 15) {
            return 'var(--md-orange-300)';
        }
        if (daysFromNow <= 60) {
            return 'var(--md-orange-400)';
        }
        if (daysFromNow <= 180) {
            return 'var(--md-deep-orange-600)';
        }
        if (daysFromNow <= 365) {
            return 'var(--md-deep-orange-700)';
        }
        if (daysFromNow <= 720) {
            return 'var(--md-deep-orange-800)';
        }
        return 'var(--md-deep-orange-900)';
    };
    var BlameDecorator_1;
    __decorate([
        inversify_1.inject(browser_1.EditorManager),
        __metadata("design:type", browser_1.EditorManager)
    ], BlameDecorator.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(browser_2.Languages),
        __metadata("design:type", Object)
    ], BlameDecorator.prototype, "languages", void 0);
    BlameDecorator = BlameDecorator_1 = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], BlameDecorator);
    return BlameDecorator;
}());
exports.BlameDecorator = BlameDecorator;
(function (BlameDecorator) {
    BlameDecorator.maxWidth = 50; // character
    BlameDecorator.defaultGutterStyles = {
        width: BlameDecorator.maxWidth + "ch",
        color: 'var(--theia-ui-font-color0)',
        backgroundColor: 'var(--theia-layout-color1)',
        height: '100%',
        margin: '0 26px -1px 0',
        display: 'inline-block',
        borderRight: '2px solid',
    };
    BlameDecorator.continuationStyle = new browser_1.EditorDecorationStyle('git-blame-continuation-line::before', function (style) {
        style.content = "'\u2007'"; // blank
    });
    BlameDecorator.highlightStyle = new browser_1.EditorDecorationStyle('git-blame-highlight::before', function (style) {
        style.backgroundColor = 'var(--theia-layout-color2)';
    });
})(BlameDecorator = exports.BlameDecorator || (exports.BlameDecorator = {}));
exports.BlameDecorator = BlameDecorator;
var AppliedBlameDecorations = /** @class */ (function () {
    function AppliedBlameDecorations() {
        this.toDispose = new core_1.DisposableCollection();
        this.previousStyles = new core_1.DisposableCollection();
        this.previousDecorations = [];
    }
    AppliedBlameDecorations.prototype.dispose = function () {
        this.previousStyles.dispose();
        this.toDispose.dispose();
        this.blame = undefined;
    };
    return AppliedBlameDecorations;
}());
exports.AppliedBlameDecorations = AppliedBlameDecorations;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/blame/blame-manager.js":
/*!*********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/blame/blame-manager.js ***!
  \*********************************************************************/
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
var common_1 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_repository_tracker_1 = __webpack_require__(/*! ../git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var BlameManager = /** @class */ (function () {
    function BlameManager() {
    }
    BlameManager.prototype.isBlameable = function (uri) {
        return !!this.repositoryTracker.getPath(new uri_1.default(uri));
    };
    BlameManager.prototype.getBlame = function (uri, content) {
        return __awaiter(this, void 0, void 0, function () {
            var repository;
            return __generator(this, function (_a) {
                repository = this.repositoryTracker.selectedRepository;
                if (!repository) {
                    return [2 /*return*/, undefined];
                }
                return [2 /*return*/, this.git.blame(repository, uri, { content: content })];
            });
        });
    };
    __decorate([
        inversify_1.inject(common_1.Git),
        __metadata("design:type", Object)
    ], BlameManager.prototype, "git", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], BlameManager.prototype, "repositoryTracker", void 0);
    BlameManager = __decorate([
        inversify_1.injectable()
    ], BlameManager);
    return BlameManager;
}());
exports.BlameManager = BlameManager;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/blame/blame-module.js":
/*!********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/blame/blame-module.js ***!
  \********************************************************************/
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
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var blame_contribution_1 = __webpack_require__(/*! ./blame-contribution */ "../node_modules/@theia/git/lib/browser/blame/blame-contribution.js");
var blame_decorator_1 = __webpack_require__(/*! ./blame-decorator */ "../node_modules/@theia/git/lib/browser/blame/blame-decorator.js");
var blame_manager_1 = __webpack_require__(/*! ./blame-manager */ "../node_modules/@theia/git/lib/browser/blame/blame-manager.js");
function bindBlame(bind) {
    var e_1, _a;
    bind(blame_contribution_1.BlameContribution).toSelf().inSingletonScope();
    bind(blame_manager_1.BlameManager).toSelf().inSingletonScope();
    bind(blame_decorator_1.BlameDecorator).toSelf().inSingletonScope();
    try {
        for (var _b = __values([common_1.CommandContribution, browser_1.KeybindingContribution, common_1.MenuContribution]), _c = _b.next(); !_c.done; _c = _b.next()) {
            var serviceIdentifier = _c.value;
            bind(serviceIdentifier).toService(blame_contribution_1.BlameContribution);
        }
    }
    catch (e_1_1) { e_1 = { error: e_1_1 }; }
    finally {
        try {
            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
        }
        finally { if (e_1) throw e_1.error; }
    }
    bind(blame_contribution_1.BlameAnnotationsKeybindingContext).toSelf().inSingletonScope();
    bind(browser_1.KeybindingContext).toService(blame_contribution_1.BlameAnnotationsKeybindingContext);
}
exports.bindBlame = bindBlame;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/diff/git-diff-contribution.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/diff/git-diff-contribution.js ***!
  \****************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var widget_manager_1 = __webpack_require__(/*! @theia/core/lib/browser/widget-manager */ "../node_modules/@theia/core/lib/browser/widget-manager.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var git_diff_widget_1 = __webpack_require__(/*! ./git-diff-widget */ "../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js");
var browser_2 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var navigator_contribution_1 = __webpack_require__(/*! @theia/navigator/lib/browser/navigator-contribution */ "../node_modules/@theia/navigator/lib/browser/navigator-contribution.js");
var uri_command_handler_1 = __webpack_require__(/*! @theia/core/lib/common/uri-command-handler */ "../node_modules/@theia/core/lib/common/uri-command-handler.js");
var git_quick_open_service_1 = __webpack_require__(/*! ../git-quick-open-service */ "../node_modules/@theia/git/lib/browser/git-quick-open-service.js");
var common_2 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var diff_uris_1 = __webpack_require__(/*! @theia/core/lib/browser/diff-uris */ "../node_modules/@theia/core/lib/browser/diff-uris.js");
var git_resource_1 = __webpack_require__(/*! ../git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var git_repository_provider_1 = __webpack_require__(/*! ../git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var GitDiffCommands;
(function (GitDiffCommands) {
    GitDiffCommands.OPEN_FILE_DIFF = {
        id: 'git-diff:open-file-diff',
        label: 'Diff: Compare With...'
    };
})(GitDiffCommands = exports.GitDiffCommands || (exports.GitDiffCommands = {}));
var GitDiffContribution = /** @class */ (function (_super) {
    __extends(GitDiffContribution, _super);
    function GitDiffContribution(selectionService, widgetManager, app, quickOpenService, fileSystem, openerService, notifications, repositoryProvider) {
        var _this = _super.call(this, {
            widgetId: git_diff_widget_1.GIT_DIFF,
            widgetName: 'Git diff',
            defaultWidgetOptions: {
                area: 'left',
                rank: 400
            }
        }) || this;
        _this.selectionService = selectionService;
        _this.widgetManager = widgetManager;
        _this.app = app;
        _this.quickOpenService = quickOpenService;
        _this.fileSystem = fileSystem;
        _this.openerService = openerService;
        _this.notifications = notifications;
        _this.repositoryProvider = repositoryProvider;
        return _this;
    }
    GitDiffContribution.prototype.registerMenus = function (menus) {
        menus.registerMenuAction(__spread(navigator_contribution_1.NAVIGATOR_CONTEXT_MENU, ['5_diff']), {
            commandId: GitDiffCommands.OPEN_FILE_DIFF.id
        });
    };
    GitDiffContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(GitDiffCommands.OPEN_FILE_DIFF, this.newUriAwareCommandHandler({
            execute: function (fileUri) { return __awaiter(_this, void 0, void 0, function () {
                var _this = this;
                return __generator(this, function (_a) {
                    switch (_a.label) {
                        case 0: return [4 /*yield*/, this.quickOpenService.chooseTagsAndBranches(function (fromRevision, toRevision) { return __awaiter(_this, void 0, void 0, function () {
                                var uri, fileStat, options, fromURI, toURI, diffUri;
                                var _this = this;
                                return __generator(this, function (_a) {
                                    switch (_a.label) {
                                        case 0:
                                            uri = fileUri.toString();
                                            return [4 /*yield*/, this.fileSystem.getFileStat(uri)];
                                        case 1:
                                            fileStat = _a.sent();
                                            options = {
                                                uri: uri,
                                                range: {
                                                    fromRevision: fromRevision
                                                }
                                            };
                                            if (fileStat) {
                                                if (fileStat.isDirectory) {
                                                    this.showWidget(options);
                                                }
                                                else {
                                                    fromURI = fileUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(fromRevision);
                                                    toURI = fileUri;
                                                    diffUri = diff_uris_1.DiffUris.encode(fromURI, toURI, fileUri.displayName);
                                                    if (diffUri) {
                                                        browser_2.open(this.openerService, diffUri).catch(function (e) {
                                                            _this.notifications.error(e.message);
                                                        });
                                                    }
                                                }
                                            }
                                            return [2 /*return*/];
                                    }
                                });
                            }); }, this.repositoryProvider.findRepository(fileUri))];
                        case 1:
                            _a.sent();
                            return [2 /*return*/];
                    }
                });
            }); }
        }));
    };
    GitDiffContribution.prototype.showWidget = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var widget;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.widget];
                    case 1:
                        widget = _a.sent();
                        return [4 /*yield*/, widget.setContent(options)];
                    case 2:
                        _a.sent();
                        return [2 /*return*/, this.openView({
                                activate: true
                            })];
                }
            });
        });
    };
    GitDiffContribution.prototype.newUriAwareCommandHandler = function (handler) {
        return new uri_command_handler_1.UriAwareCommandHandler(this.selectionService, handler);
    };
    GitDiffContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.SelectionService)),
        __param(1, inversify_1.inject(widget_manager_1.WidgetManager)),
        __param(2, inversify_1.inject(browser_1.FrontendApplication)),
        __param(3, inversify_1.inject(git_quick_open_service_1.GitQuickOpenService)),
        __param(4, inversify_1.inject(common_2.FileSystem)),
        __param(5, inversify_1.inject(browser_2.OpenerService)),
        __param(6, inversify_1.inject(common_1.MessageService)),
        __param(7, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __metadata("design:paramtypes", [common_1.SelectionService,
            widget_manager_1.WidgetManager,
            browser_1.FrontendApplication,
            git_quick_open_service_1.GitQuickOpenService, Object, Object, common_1.MessageService,
            git_repository_provider_1.GitRepositoryProvider])
    ], GitDiffContribution);
    return GitDiffContribution;
}(browser_1.AbstractViewContribution));
exports.GitDiffContribution = GitDiffContribution;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/diff/git-diff-frontend-module.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/diff/git-diff-frontend-module.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var git_diff_contribution_1 = __webpack_require__(/*! ./git-diff-contribution */ "../node_modules/@theia/git/lib/browser/diff/git-diff-contribution.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var git_diff_widget_1 = __webpack_require__(/*! ./git-diff-widget */ "../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js");
__webpack_require__(/*! ../../../src/browser/style/diff.css */ "../node_modules/@theia/git/src/browser/style/diff.css");
function bindGitDiffModule(bind) {
    bind(git_diff_widget_1.GitDiffWidget).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (ctx) { return ({
        id: git_diff_widget_1.GIT_DIFF,
        createWidget: function () { return ctx.container.get(git_diff_widget_1.GitDiffWidget); }
    }); });
    browser_1.bindViewContribution(bind, git_diff_contribution_1.GitDiffContribution);
}
exports.bindGitDiffModule = bindGitDiffModule;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js":
/*!**********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js ***!
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var common_1 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/git/lib/common/index.js");
var common_2 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_resource_1 = __webpack_require__(/*! ../git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var git_navigable_list_widget_1 = __webpack_require__(/*! ../git-navigable-list-widget */ "../node_modules/@theia/git/lib/browser/git-navigable-list-widget.js");
var git_widget_1 = __webpack_require__(/*! ../git-widget */ "../node_modules/@theia/git/lib/browser/git-widget.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
// tslint:disable:no-null-keyword
exports.GIT_DIFF = 'git-diff';
var GitDiffWidget = /** @class */ (function (_super) {
    __extends(GitDiffWidget, _super);
    function GitDiffWidget() {
        var _this = _super.call(this) || this;
        _this.showPreviousChange = function () { return _this.doShowPreviousChange(); };
        _this.showNextChange = function () { return _this.doShowNextChange(); };
        _this.addGitDiffListKeyListeners = function (id) { return _this.doAddGitDiffListKeyListeners(id); };
        _this.id = exports.GIT_DIFF;
        _this.scrollContainer = 'git-diff-list-container';
        _this.title.label = 'Diff';
        _this.addClass('theia-git');
        return _this;
    }
    GitDiffWidget.prototype.init = function () {
        var _this = this;
        this.toDispose.push(this.gitWatcher.onGitEvent(function (gitEvent) { return __awaiter(_this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                if (this.options) {
                    this.setContent(this.options);
                }
                return [2 /*return*/];
            });
        }); }));
    };
    Object.defineProperty(GitDiffWidget.prototype, "toRevision", {
        get: function () {
            return this.options.range && this.options.range.toRevision;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitDiffWidget.prototype, "fromRevision", {
        get: function () {
            return this.options.range && this.options.range.fromRevision;
        },
        enumerable: true,
        configurable: true
    });
    GitDiffWidget.prototype.setContent = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, repository, fileChanges, fileChangeNodes, fileChanges_1, fileChanges_1_1, fileChange, fileChangeUri, _b, icon, label, description, caption, e_1_1;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0:
                        this.options = options;
                        repository = this.repositoryProvider.findRepositoryOrSelected(options);
                        if (!repository) return [3 /*break*/, 10];
                        return [4 /*yield*/, this.git.diff(repository, {
                                range: options.range,
                                uri: options.uri
                            })];
                    case 1:
                        fileChanges = _c.sent();
                        fileChangeNodes = [];
                        _c.label = 2;
                    case 2:
                        _c.trys.push([2, 7, 8, 9]);
                        fileChanges_1 = __values(fileChanges), fileChanges_1_1 = fileChanges_1.next();
                        _c.label = 3;
                    case 3:
                        if (!!fileChanges_1_1.done) return [3 /*break*/, 6];
                        fileChange = fileChanges_1_1.value;
                        fileChangeUri = new uri_1.default(fileChange.uri);
                        return [4 /*yield*/, Promise.all([
                                this.labelProvider.getIcon(fileChangeUri),
                                this.labelProvider.getName(fileChangeUri),
                                this.relativePath(fileChangeUri.parent)
                            ])];
                    case 4:
                        _b = __read.apply(void 0, [_c.sent(), 3]), icon = _b[0], label = _b[1], description = _b[2];
                        caption = this.computeCaption(fileChange);
                        fileChangeNodes.push(__assign({}, fileChange, { icon: icon, label: label, description: description, caption: caption }));
                        _c.label = 5;
                    case 5:
                        fileChanges_1_1 = fileChanges_1.next();
                        return [3 /*break*/, 3];
                    case 6: return [3 /*break*/, 9];
                    case 7:
                        e_1_1 = _c.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 9];
                    case 8:
                        try {
                            if (fileChanges_1_1 && !fileChanges_1_1.done && (_a = fileChanges_1.return)) _a.call(fileChanges_1);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 9:
                        this.fileChangeNodes = fileChangeNodes;
                        this.update();
                        _c.label = 10;
                    case 10: return [2 /*return*/];
                }
            });
        });
    };
    GitDiffWidget.prototype.storeState = function () {
        var _a = this, fileChangeNodes = _a.fileChangeNodes, options = _a.options;
        return {
            fileChangeNodes: fileChangeNodes,
            options: options
        };
    };
    // tslint:disable-next-line:no-any
    GitDiffWidget.prototype.restoreState = function (oldState) {
        this.fileChangeNodes = oldState['fileChangeNodes'];
        this.options = oldState['options'];
        this.update();
    };
    GitDiffWidget.prototype.onActivateRequest = function (msg) {
        _super.prototype.onActivateRequest.call(this, msg);
        if (this.listView) {
            this.listView.focus();
        }
    };
    GitDiffWidget.prototype.render = function () {
        this.gitNodes = this.fileChangeNodes;
        var commitishBar = this.renderDiffListHeader();
        var fileChangeList = this.renderFileChangeList();
        return React.createElement("div", { className: 'git-diff-container' },
            commitishBar,
            fileChangeList);
    };
    GitDiffWidget.prototype.renderDiffListHeader = function () {
        return this.doRenderDiffListHeader(this.renderRepositoryHeader(), this.renderPathHeader(), this.renderRevisionHeader(), this.renderToolbar());
    };
    GitDiffWidget.prototype.doRenderDiffListHeader = function () {
        var children = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            children[_i] = arguments[_i];
        }
        return React.createElement("div", { className: 'diff-header' }, children);
    };
    GitDiffWidget.prototype.renderRepositoryHeader = function () {
        if (this.options && this.options.uri) {
            return this.renderHeaderRow({ name: 'repository', value: this.getRepositoryLabel(this.options.uri) });
        }
        return undefined;
    };
    GitDiffWidget.prototype.renderPathHeader = function () {
        return this.renderHeaderRow({
            name: 'path',
            value: this.renderPath()
        });
    };
    GitDiffWidget.prototype.renderPath = function () {
        if (this.options.uri) {
            var path = this.relativePath(this.options.uri);
            if (path.length > 0) {
                return '/' + path;
            }
            else {
                return this.labelProvider.getLongName(new uri_1.default(this.options.uri));
            }
        }
        return null;
    };
    GitDiffWidget.prototype.renderRevisionHeader = function () {
        return this.renderHeaderRow({
            name: 'revision: ',
            value: this.renderRevision()
        });
    };
    GitDiffWidget.prototype.renderRevision = function () {
        if (!this.fromRevision) {
            return null;
        }
        if (typeof this.fromRevision === 'string') {
            return this.fromRevision;
        }
        return (this.toRevision || 'HEAD') + '~' + this.fromRevision;
    };
    GitDiffWidget.prototype.renderToolbar = function () {
        return this.doRenderToolbar(this.renderNavigationLeft(), this.renderNavigationRight());
    };
    GitDiffWidget.prototype.doRenderToolbar = function () {
        var children = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            children[_i] = arguments[_i];
        }
        return this.renderHeaderRow({
            classNames: ['space-between'],
            name: 'Files changed',
            value: React.createElement("div", { className: 'lrBtns' }, children)
        });
    };
    GitDiffWidget.prototype.doShowPreviousChange = function () {
        this.navigateLeft();
    };
    GitDiffWidget.prototype.renderNavigationLeft = function () {
        return React.createElement("span", { key: 'lnav', className: 'fa fa-arrow-left', title: 'Previous Change', onClick: this.showPreviousChange });
    };
    GitDiffWidget.prototype.doShowNextChange = function () {
        this.navigateRight();
    };
    GitDiffWidget.prototype.renderNavigationRight = function () {
        return React.createElement("span", { key: 'rnav', className: 'fa fa-arrow-right', title: 'Next Change', onClick: this.showNextChange });
    };
    GitDiffWidget.prototype.renderFileChangeList = function () {
        var _this = this;
        var e_2, _a;
        var files = [];
        try {
            for (var _b = __values(this.fileChangeNodes), _c = _b.next(); !_c.done; _c = _b.next()) {
                var fileChange = _c.value;
                var fileChangeElement = this.renderGitItem(fileChange);
                files.push(fileChangeElement);
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
        return React.createElement(GitDiffListContainer, { ref: function (ref) { return _this.listView = ref || undefined; }, id: this.scrollContainer, files: files, addDiffListKeyListeners: this.addGitDiffListKeyListeners });
    };
    GitDiffWidget.prototype.doAddGitDiffListKeyListeners = function (id) {
        var container = document.getElementById(id);
        if (container) {
            this.addGitListNavigationKeyListeners(container);
        }
    };
    GitDiffWidget.prototype.renderGitItem = function (change) {
        var _this = this;
        return React.createElement("div", { key: change.uri.toString(), className: "gitItem noselect" + (change.selected ? ' ' + browser_1.SELECTED_CLASS : '') },
            React.createElement("div", { title: change.caption, className: 'noWrapInfo', onDoubleClick: function () {
                    _this.revealChange(change);
                }, onClick: function () {
                    _this.selectNode(change);
                } },
                React.createElement("span", { className: change.icon + ' file-icon' }),
                React.createElement("span", { className: 'name' }, change.label + ' '),
                React.createElement("span", { className: 'path' }, change.description)),
            change.extraIconClassName ? React.createElement("div", { title: change.caption, className: change.extraIconClassName })
                : '',
            React.createElement("div", { title: change.caption, className: 'status staged ' + common_1.GitFileStatus[change.status].toLowerCase() }, this.getStatusCaption(change.status, true).charAt(0)));
    };
    GitDiffWidget.prototype.navigateRight = function () {
        var _this = this;
        var selected = this.getSelected();
        if (selected && git_widget_1.GitFileChangeNode.is(selected)) {
            var uri = this.getUriToOpen(selected);
            this.editorManager.getByUri(uri).then(function (widget) {
                if (widget) {
                    var diffNavigator = _this.diffNavigatorProvider(widget.editor);
                    if (diffNavigator.canNavigate() && diffNavigator.hasNext()) {
                        diffNavigator.next();
                    }
                    else {
                        _this.selectNextNode();
                        _this.openSelected();
                    }
                }
                else {
                    _this.revealChange(selected);
                }
            });
        }
        else if (this.gitNodes.length > 0) {
            this.selectNode(this.gitNodes[0]);
            this.openSelected();
        }
    };
    GitDiffWidget.prototype.navigateLeft = function () {
        var _this = this;
        var selected = this.getSelected();
        if (git_widget_1.GitFileChangeNode.is(selected)) {
            var uri = this.getUriToOpen(selected);
            this.editorManager.getByUri(uri).then(function (widget) {
                if (widget) {
                    var diffNavigator = _this.diffNavigatorProvider(widget.editor);
                    if (diffNavigator.canNavigate() && diffNavigator.hasPrevious()) {
                        diffNavigator.previous();
                    }
                    else {
                        _this.selectPreviousNode();
                        _this.openSelected();
                    }
                }
                else {
                    _this.revealChange(selected);
                }
            });
        }
    };
    GitDiffWidget.prototype.selectNextNode = function () {
        var idx = this.indexOfSelected;
        if (idx >= 0 && idx < this.gitNodes.length - 1) {
            this.selectNode(this.gitNodes[idx + 1]);
        }
        else if (this.gitNodes.length > 0 && (idx === -1 || idx === this.gitNodes.length - 1)) {
            this.selectNode(this.gitNodes[0]);
        }
    };
    GitDiffWidget.prototype.selectPreviousNode = function () {
        var idx = this.indexOfSelected;
        if (idx > 0) {
            this.selectNode(this.gitNodes[idx - 1]);
        }
        else if (idx === 0) {
            this.selectNode(this.gitNodes[this.gitNodes.length - 1]);
        }
    };
    GitDiffWidget.prototype.handleListEnter = function () {
        this.openSelected();
    };
    GitDiffWidget.prototype.openSelected = function () {
        var selected = this.getSelected();
        if (selected) {
            this.revealChange(selected);
        }
    };
    GitDiffWidget.prototype.getUriToOpen = function (change) {
        var uri = new uri_1.default(change.uri);
        var fromURI = uri;
        if (change.oldUri) { // set on renamed and copied
            fromURI = new uri_1.default(change.oldUri);
        }
        if (this.fromRevision !== undefined) {
            if (typeof this.fromRevision !== 'number') {
                fromURI = fromURI.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(this.fromRevision);
            }
            else {
                fromURI = fromURI.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(this.toRevision + '~' + this.fromRevision);
            }
        }
        else {
            // default is to compare with previous revision
            fromURI = fromURI.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(this.toRevision + '~1');
        }
        var toURI = uri;
        if (this.toRevision) {
            toURI = toURI.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(this.toRevision);
        }
        var uriToOpen = uri;
        if (change.status === common_1.GitFileStatus.Deleted) {
            uriToOpen = fromURI;
        }
        else if (change.status === common_1.GitFileStatus.New) {
            uriToOpen = toURI;
        }
        else {
            uriToOpen = browser_1.DiffUris.encode(fromURI, toURI, uri.displayName);
        }
        return uriToOpen;
    };
    GitDiffWidget.prototype.openChanges = function (uri, options) {
        return __awaiter(this, void 0, void 0, function () {
            var stringUri, change;
            return __generator(this, function (_a) {
                stringUri = uri.toString();
                change = this.fileChangeNodes.find(function (n) { return n.uri.toString() === stringUri; });
                return [2 /*return*/, change && this.openChange(change, options)];
            });
        });
    };
    GitDiffWidget.prototype.openChange = function (change, options) {
        var uriToOpen = this.getUriToOpen(change);
        return this.editorManager.open(uriToOpen, options);
    };
    GitDiffWidget.prototype.revealChange = function (change) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.openChange(change, { mode: 'reveal' })];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(common_1.Git),
        __metadata("design:type", Object)
    ], GitDiffWidget.prototype, "git", void 0);
    __decorate([
        inversify_1.inject(browser_2.DiffNavigatorProvider),
        __metadata("design:type", Function)
    ], GitDiffWidget.prototype, "diffNavigatorProvider", void 0);
    __decorate([
        inversify_1.inject(browser_2.EditorManager),
        __metadata("design:type", browser_2.EditorManager)
    ], GitDiffWidget.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(common_2.GitWatcher),
        __metadata("design:type", common_2.GitWatcher)
    ], GitDiffWidget.prototype, "gitWatcher", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], GitDiffWidget.prototype, "init", null);
    GitDiffWidget = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], GitDiffWidget);
    return GitDiffWidget;
}(git_navigable_list_widget_1.GitNavigableListWidget));
exports.GitDiffWidget = GitDiffWidget;
var GitDiffListContainer = /** @class */ (function (_super) {
    __extends(GitDiffListContainer, _super);
    function GitDiffListContainer() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    GitDiffListContainer.prototype.render = function () {
        var _this = this;
        var _a = this.props, id = _a.id, files = _a.files;
        return React.createElement("div", { ref: function (ref) { return _this.listContainer = ref || undefined; }, className: 'listContainer', id: id, tabIndex: 0 }, files);
    };
    GitDiffListContainer.prototype.componentDidMount = function () {
        this.props.addDiffListKeyListeners(this.props.id);
    };
    GitDiffListContainer.prototype.focus = function () {
        if (this.listContainer) {
            this.listContainer.focus();
        }
    };
    return GitDiffListContainer;
}(React.Component));
exports.GitDiffListContainer = GitDiffListContainer;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/content-lines.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/content-lines.js ***!
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
var ContentLines;
(function (ContentLines) {
    var NL = '\n'.charCodeAt(0);
    var CR = '\r'.charCodeAt(0);
    function fromString(content) {
        var computeLineStarts = function (s) {
            var result = [0];
            for (var i = 0; i < s.length; i++) {
                var chr = s.charCodeAt(i);
                if (chr === CR) {
                    if (i + 1 < s.length && s.charCodeAt(i + 1) === NL) {
                        result[result.length] = i + 2;
                        i++;
                    }
                    else {
                        result[result.length] = i + 1;
                    }
                }
                else if (chr === NL) {
                    result[result.length] = i + 1;
                }
            }
            return result;
        };
        var lineStarts = computeLineStarts(content);
        return {
            length: lineStarts.length,
            getLineContent: function (line) {
                if (line >= lineStarts.length) {
                    throw new Error('line index out of bounds');
                }
                var start = lineStarts[line];
                var end = (line === lineStarts.length - 1) ? undefined : lineStarts[line + 1] - 1;
                if (!!end && content.charCodeAt(end - 1) === CR) {
                    end--; // ignore CR at the end
                }
                var lineContent = content.substring(start, end);
                return lineContent;
            }
        };
    }
    ContentLines.fromString = fromString;
    function arrayLike(lines) {
        return new Proxy(lines, getProxyHandler());
    }
    ContentLines.arrayLike = arrayLike;
    function getProxyHandler() {
        return {
            get: function (target, p) {
                switch (p) {
                    case 'prototype':
                        return undefined;
                    case 'length':
                        return target.length;
                    case 'slice':
                        return function (start, end) {
                            if (start !== undefined) {
                                return [start, (end !== undefined ? end - 1 : target.length - 1)];
                            }
                            return [0, target.length - 1];
                        };
                    case Symbol.iterator:
                        return function () {
                            var i;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        i = 0;
                                        _a.label = 1;
                                    case 1:
                                        if (!(i < target.length)) return [3 /*break*/, 4];
                                        return [4 /*yield*/, target.getLineContent(i)];
                                    case 2:
                                        _a.sent();
                                        _a.label = 3;
                                    case 3:
                                        i++;
                                        return [3 /*break*/, 1];
                                    case 4: return [2 /*return*/];
                                }
                            });
                        };
                }
                // tslint:disable-next-line:no-any
                var index = Number.parseInt(p);
                if (Number.isInteger(index)) {
                    if (index >= 0 && index < target.length) {
                        var value = target.getLineContent(index);
                        if (value === undefined) {
                            console.log(target);
                        }
                        return value;
                    }
                    else {
                        return undefined;
                    }
                }
                throw new Error("get " + String(p) + " not implemented");
            }
        };
    }
})(ContentLines = exports.ContentLines || (exports.ContentLines = {}));


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/diff-computer.js":
/*!**************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/diff-computer.js ***!
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
var jsdiff = __webpack_require__(/*! diff */ "../node_modules/diff/dist/diff.js");
var DiffComputer = /** @class */ (function () {
    function DiffComputer() {
    }
    DiffComputer.prototype.computeDiff = function (previous, current) {
        var diffResult = diffArrays(previous, current);
        return diffResult;
    };
    DiffComputer.prototype.computeDirtyDiff = function (previous, current) {
        var added = [];
        var removed = [];
        var modified = [];
        var changes = this.computeDiff(previous, current);
        var lastLine = -1;
        for (var i = 0; i < changes.length; i++) {
            var change = changes[i];
            var next = changes[i + 1];
            if (change.added) {
                // case: addition
                var start = lastLine + 1;
                var end = lastLine + change.count;
                added.push({ start: start, end: end });
                lastLine = end;
            }
            else if (change.removed && next && next.added) {
                var isFirstChange = i === 0;
                var isLastChange = i === changes.length - 2;
                var isNextEmptyLine = next.value.length > 0 && current[next.value[0]].length === 0;
                var isPrevEmptyLine = change.value.length > 0 && previous[change.value[0]].length === 0;
                if (isFirstChange && isNextEmptyLine) {
                    // special case: removing at the beginning
                    removed.push(0);
                }
                else if (isFirstChange && isPrevEmptyLine) {
                    // special case: adding at the beginning
                    var start = 0;
                    var end = next.count - 1;
                    added.push({ start: start, end: end });
                    lastLine = end;
                }
                else if (isLastChange && isNextEmptyLine) {
                    removed.push(lastLine + 1 /* = empty line */);
                }
                else {
                    // default case is a modification
                    var start = lastLine + 1;
                    var end = lastLine + next.count;
                    modified.push({ start: start, end: end });
                    lastLine = end;
                }
                i++; // consume next eagerly
            }
            else if (change.removed && !(next && next.added)) {
                removed.push(Math.max(0, lastLine));
            }
            else {
                lastLine += change.count;
            }
        }
        return { added: added, removed: removed, modified: modified };
    };
    return DiffComputer;
}());
exports.DiffComputer = DiffComputer;
var ArrayDiff = /** @class */ (function (_super) {
    __extends(ArrayDiff, _super);
    function ArrayDiff() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    // tslint:disable-next-line:no-any
    ArrayDiff.prototype.tokenize = function (value) {
        return value;
    };
    // tslint:disable-next-line:no-any
    ArrayDiff.prototype.join = function (value) {
        return value;
    };
    // tslint:disable-next-line:no-any
    ArrayDiff.prototype.removeEmpty = function (value) {
        return value;
    };
    return ArrayDiff;
}(jsdiff.Diff));
var arrayDiff = new ArrayDiff();
/**
 * Computes diff without copying data.
 */
// tslint:disable-next-line:no-any
function diffArrays(oldArr, newArr) {
    // tslint:disable-next-line:no-any
    return arrayDiff.diff(oldArr, newArr);
}


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-contribution.js":
/*!************************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-contribution.js ***!
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
var dirty_diff_manager_1 = __webpack_require__(/*! ./dirty-diff-manager */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-manager.js");
var dirty_diff_decorator_1 = __webpack_require__(/*! ./dirty-diff-decorator */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-decorator.js");
var DirtyDiffContribution = /** @class */ (function () {
    function DirtyDiffContribution(dirtyDiffManager, dirtyDiffDecorator) {
        this.dirtyDiffManager = dirtyDiffManager;
        this.dirtyDiffDecorator = dirtyDiffDecorator;
    }
    DirtyDiffContribution.prototype.onStart = function (app) {
        var _this = this;
        this.dirtyDiffManager.onDirtyDiffUpdate(function (update) { return _this.dirtyDiffDecorator.applyDecorations(update); });
    };
    DirtyDiffContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(dirty_diff_manager_1.DirtyDiffManager)),
        __param(1, inversify_1.inject(dirty_diff_decorator_1.DirtyDiffDecorator)),
        __metadata("design:paramtypes", [dirty_diff_manager_1.DirtyDiffManager,
            dirty_diff_decorator_1.DirtyDiffDecorator])
    ], DirtyDiffContribution);
    return DirtyDiffContribution;
}());
exports.DirtyDiffContribution = DirtyDiffContribution;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-decorator.js":
/*!*********************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-decorator.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var DirtyDiffDecorationType;
(function (DirtyDiffDecorationType) {
    DirtyDiffDecorationType["AddedLine"] = "dirty-diff-added-line";
    DirtyDiffDecorationType["RemovedLine"] = "dirty-diff-removed-line";
    DirtyDiffDecorationType["ModifiedLine"] = "dirty-diff-modified-line";
})(DirtyDiffDecorationType = exports.DirtyDiffDecorationType || (exports.DirtyDiffDecorationType = {}));
var AddedLineDecoration = {
    linesDecorationsClassName: 'dirty-diff-glyph dirty-diff-added-line',
    overviewRuler: {
        color: 'rgba(0, 255, 0, 0.8)',
        position: browser_1.OverviewRulerLane.Left,
    }
};
var RemovedLineDecoration = {
    linesDecorationsClassName: 'dirty-diff-glyph dirty-diff-removed-line',
    overviewRuler: {
        color: 'rgba(230, 0, 0, 0.8)',
        position: browser_1.OverviewRulerLane.Left,
    }
};
var ModifiedLineDecoration = {
    linesDecorationsClassName: 'dirty-diff-glyph dirty-diff-modified-line',
    overviewRuler: {
        color: 'rgba(0, 100, 150, 0.8)',
        position: browser_1.OverviewRulerLane.Left,
    }
};
var DirtyDiffDecorator = /** @class */ (function (_super) {
    __extends(DirtyDiffDecorator, _super);
    function DirtyDiffDecorator() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    DirtyDiffDecorator.prototype.applyDecorations = function (update) {
        var _this = this;
        var modifications = update.modified.map(function (range) { return _this.toDeltaDecoration(range, ModifiedLineDecoration); });
        var additions = update.added.map(function (range) { return _this.toDeltaDecoration(range, AddedLineDecoration); });
        var removals = update.removed.map(function (line) { return _this.toDeltaDecoration(line, RemovedLineDecoration); });
        var decorations = __spread(modifications, additions, removals);
        this.setDecorations(update.editor, decorations);
    };
    DirtyDiffDecorator.prototype.toDeltaDecoration = function (from, options) {
        var _a = __read((typeof from === 'number') ? [from, from] : [from.start, from.end], 2), start = _a[0], end = _a[1];
        var range = browser_1.Range.create(browser_1.Position.create(start, 0), browser_1.Position.create(end, 0));
        return { range: range, options: options };
    };
    DirtyDiffDecorator = __decorate([
        inversify_1.injectable()
    ], DirtyDiffDecorator);
    return DirtyDiffDecorator;
}(browser_1.EditorDecorator));
exports.DirtyDiffDecorator = DirtyDiffDecorator;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-manager.js":
/*!*******************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-manager.js ***!
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
var browser_1 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var diff_computer_1 = __webpack_require__(/*! ./diff-computer */ "../node_modules/@theia/git/lib/browser/dirty-diff/diff-computer.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var git_preferences_1 = __webpack_require__(/*! ../git-preferences */ "../node_modules/@theia/git/lib/browser/git-preferences.js");
var git_resource_1 = __webpack_require__(/*! ../git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var common_1 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_repository_tracker_1 = __webpack_require__(/*! ../git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var content_lines_1 = __webpack_require__(/*! ./content-lines */ "../node_modules/@theia/git/lib/browser/dirty-diff/content-lines.js");
var throttle = __webpack_require__(/*! lodash.throttle */ "../node_modules/lodash.throttle/index.js");
var DirtyDiffManager = /** @class */ (function () {
    function DirtyDiffManager() {
        this.models = new Map();
        this.onDirtyDiffUpdateEmitter = new core_1.Emitter();
        this.onDirtyDiffUpdate = this.onDirtyDiffUpdateEmitter.event;
    }
    DirtyDiffManager.prototype.initialize = function () {
        return __awaiter(this, void 0, void 0, function () {
            var gitStatus, repository;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.editorManager.onCreated(function (e) { return __awaiter(_this, void 0, void 0, function () { return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0: return [4 /*yield*/, this.handleEditorCreated(e)];
                                case 1: return [2 /*return*/, _a.sent()];
                            }
                        }); }); });
                        this.repositoryTracker.onGitEvent(throttle(function (event) { return __awaiter(_this, void 0, void 0, function () { return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0: return [4 /*yield*/, this.handleGitStatusUpdate(event.source, event.status)];
                                case 1: return [2 /*return*/, _a.sent()];
                            }
                        }); }); }, 500));
                        gitStatus = this.repositoryTracker.selectedRepositoryStatus;
                        repository = this.repositoryTracker.selectedRepository;
                        if (!(gitStatus && repository)) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.handleGitStatusUpdate(repository, gitStatus)];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    DirtyDiffManager.prototype.handleEditorCreated = function (editorWidget) {
        return __awaiter(this, void 0, void 0, function () {
            var editor, uri, toDispose, model, gitStatus, repository, changes;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        editor = editorWidget.editor;
                        uri = editor.uri.toString();
                        if (editor.uri.scheme !== 'file') {
                            return [2 /*return*/];
                        }
                        toDispose = new core_1.DisposableCollection();
                        model = this.createNewModel(editor);
                        toDispose.push(model);
                        this.models.set(uri, model);
                        toDispose.push(editor.onDocumentContentChanged(throttle(function (event) { return model.handleDocumentChanged(event.document); }, 1000)));
                        editorWidget.disposed.connect(function () {
                            _this.models.delete(uri);
                            toDispose.dispose();
                        });
                        gitStatus = this.repositoryTracker.selectedRepositoryStatus;
                        repository = this.repositoryTracker.selectedRepository;
                        if (!(gitStatus && repository)) return [3 /*break*/, 2];
                        changes = gitStatus.changes.filter(function (c) { return c.uri === uri; });
                        return [4 /*yield*/, model.handleGitStatusUpdate(repository, changes)];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2:
                        model.handleDocumentChanged(editor.document);
                        return [2 /*return*/];
                }
            });
        });
    };
    DirtyDiffManager.prototype.createNewModel = function (editor) {
        var _this = this;
        var previousRevision = this.createPreviousFileRevision(editor.uri);
        var model = new DirtyDiffModel(editor, this.preferences, previousRevision);
        model.onDirtyDiffUpdate(function (e) { return _this.onDirtyDiffUpdateEmitter.fire(e); });
        return model;
    };
    DirtyDiffManager.prototype.createPreviousFileRevision = function (fileUri) {
        var _this = this;
        return {
            fileUri: fileUri,
            getContents: function (staged) { return __awaiter(_this, void 0, void 0, function () {
                var query, uri, gitResource;
                return __generator(this, function (_a) {
                    switch (_a.label) {
                        case 0:
                            query = staged ? '' : 'HEAD';
                            uri = fileUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(query);
                            return [4 /*yield*/, this.gitResourceResolver.getResource(uri)];
                        case 1:
                            gitResource = _a.sent();
                            return [2 /*return*/, gitResource.readContents()];
                    }
                });
            }); },
            isVersionControlled: function () { return __awaiter(_this, void 0, void 0, function () {
                var repository;
                return __generator(this, function (_a) {
                    repository = this.repositoryTracker.selectedRepository;
                    if (repository) {
                        return [2 /*return*/, this.git.lsFiles(repository, fileUri.toString(), { errorUnmatch: true })];
                    }
                    return [2 /*return*/, false];
                });
            }); }
        };
    };
    DirtyDiffManager.prototype.handleGitStatusUpdate = function (repository, status) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, uris, relevantChanges, _loop_1, _b, _c, model, e_1_1;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        uris = new Set(this.models.keys());
                        relevantChanges = status.changes.filter(function (c) { return uris.has(c.uri); });
                        _loop_1 = function (model) {
                            var uri, changes;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        uri = model.editor.uri.toString();
                                        changes = relevantChanges.filter(function (c) { return c.uri === uri; });
                                        return [4 /*yield*/, model.handleGitStatusUpdate(repository, changes)];
                                    case 1:
                                        _a.sent();
                                        return [2 /*return*/];
                                }
                            });
                        };
                        _d.label = 1;
                    case 1:
                        _d.trys.push([1, 6, 7, 8]);
                        _b = __values(this.models.values()), _c = _b.next();
                        _d.label = 2;
                    case 2:
                        if (!!_c.done) return [3 /*break*/, 5];
                        model = _c.value;
                        return [5 /*yield**/, _loop_1(model)];
                    case 3:
                        _d.sent();
                        _d.label = 4;
                    case 4:
                        _c = _b.next();
                        return [3 /*break*/, 2];
                    case 5: return [3 /*break*/, 8];
                    case 6:
                        e_1_1 = _d.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 8];
                    case 7:
                        try {
                            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 8: return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(common_1.Git),
        __metadata("design:type", Object)
    ], DirtyDiffManager.prototype, "git", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], DirtyDiffManager.prototype, "repositoryTracker", void 0);
    __decorate([
        inversify_1.inject(git_resource_1.GitResourceResolver),
        __metadata("design:type", git_resource_1.GitResourceResolver)
    ], DirtyDiffManager.prototype, "gitResourceResolver", void 0);
    __decorate([
        inversify_1.inject(browser_1.EditorManager),
        __metadata("design:type", browser_1.EditorManager)
    ], DirtyDiffManager.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(git_preferences_1.GitPreferences),
        __metadata("design:type", Object)
    ], DirtyDiffManager.prototype, "preferences", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", Promise)
    ], DirtyDiffManager.prototype, "initialize", null);
    DirtyDiffManager = __decorate([
        inversify_1.injectable()
    ], DirtyDiffManager);
    return DirtyDiffManager;
}());
exports.DirtyDiffManager = DirtyDiffManager;
var DirtyDiffModel = /** @class */ (function () {
    function DirtyDiffModel(editor, preferences, previousRevision) {
        var _this = this;
        this.editor = editor;
        this.preferences = preferences;
        this.previousRevision = previousRevision;
        this.toDispose = new core_1.DisposableCollection();
        this.enabled = true;
        this.onDirtyDiffUpdateEmitter = new core_1.Emitter();
        this.onDirtyDiffUpdate = this.onDirtyDiffUpdateEmitter.event;
        this.toDispose.push(this.preferences.onPreferenceChanged(function (e) { return _this.handlePreferenceChange(e); }));
    }
    DirtyDiffModel.prototype.handlePreferenceChange = function (event) {
        return __awaiter(this, void 0, void 0, function () {
            var preferenceName, newValue, enabled;
            return __generator(this, function (_a) {
                preferenceName = event.preferenceName, newValue = event.newValue;
                if (preferenceName === 'git.editor.decorations.enabled') {
                    enabled = !!newValue;
                    this.enabled = enabled;
                    this.update();
                }
                if (preferenceName === 'git.editor.dirtydiff.linesLimit') {
                    this.update();
                }
                return [2 /*return*/];
            });
        });
    };
    Object.defineProperty(DirtyDiffModel.prototype, "linesLimit", {
        get: function () {
            var limit = this.preferences['git.editor.dirtydiff.linesLimit'];
            return limit > 0 ? limit : Number.MAX_SAFE_INTEGER;
        },
        enumerable: true,
        configurable: true
    });
    DirtyDiffModel.prototype.shouldRender = function () {
        if (!this.enabled || !this.previousContent || !this.currentContent) {
            return false;
        }
        var limit = this.linesLimit;
        return this.previousContent.length < limit && this.currentContent.length < limit;
    };
    DirtyDiffModel.prototype.update = function () {
        var _this = this;
        var editor = this.editor;
        if (!this.shouldRender()) {
            this.onDirtyDiffUpdateEmitter.fire({ editor: editor, added: [], removed: [], modified: [] });
            return;
        }
        if (this.updateTimeout) {
            window.clearTimeout(this.updateTimeout);
        }
        this.updateTimeout = window.setTimeout(function () {
            var previous = _this.previousContent;
            var current = _this.currentContent;
            if (!previous || !current) {
                return;
            }
            _this.updateTimeout = undefined;
            var dirtyDiff = DirtyDiffModel.computeDirtyDiff(previous, current);
            if (!dirtyDiff) {
                // if the computation fails, it might be because of changes in the editor, in that case
                // a new update task should be scheduled anyway.
                return;
            }
            var dirtyDiffUpdate = __assign({ editor: editor }, dirtyDiff);
            _this.onDirtyDiffUpdateEmitter.fire(dirtyDiffUpdate);
        }, 100);
    };
    DirtyDiffModel.prototype.handleDocumentChanged = function (document) {
        this.currentContent = DirtyDiffModel.documentContentLines(document);
        this.update();
    };
    DirtyDiffModel.prototype.handleGitStatusUpdate = function (repository, relevantChanges) {
        return __awaiter(this, void 0, void 0, function () {
            var noRelevantChanges, isNewAndStaged, isNewAndUnstaged, modifiedChange, isModified, readPreviousRevisionContent, inGitRepository;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        noRelevantChanges = relevantChanges.length === 0;
                        isNewAndStaged = relevantChanges.some(function (c) { return c.status === common_1.GitFileStatus.New && !!c.staged; });
                        isNewAndUnstaged = relevantChanges.some(function (c) { return c.status === common_1.GitFileStatus.New && !c.staged; });
                        modifiedChange = relevantChanges.find(function (c) { return c.status === common_1.GitFileStatus.Modified; });
                        isModified = !!modifiedChange;
                        readPreviousRevisionContent = function () { return __awaiter(_this, void 0, void 0, function () {
                            var _a, _b;
                            return __generator(this, function (_c) {
                                switch (_c.label) {
                                    case 0:
                                        _c.trys.push([0, 2, , 3]);
                                        _a = this;
                                        return [4 /*yield*/, this.getPreviousRevisionContent()];
                                    case 1:
                                        _a.previousContent = _c.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        _b = _c.sent();
                                        this.previousContent = undefined;
                                        return [3 /*break*/, 3];
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); };
                        if (!(isModified || isNewAndStaged)) return [3 /*break*/, 2];
                        this.staged = isNewAndStaged || modifiedChange.staged || false;
                        return [4 /*yield*/, readPreviousRevisionContent()];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2:
                        if (isNewAndUnstaged && !isNewAndStaged) {
                            this.previousContent = undefined;
                        }
                        if (!noRelevantChanges) return [3 /*break*/, 5];
                        return [4 /*yield*/, this.isInGitRepository(repository)];
                    case 3:
                        inGitRepository = _a.sent();
                        if (!inGitRepository) return [3 /*break*/, 5];
                        return [4 /*yield*/, readPreviousRevisionContent()];
                    case 4:
                        _a.sent();
                        _a.label = 5;
                    case 5:
                        this.update();
                        return [2 /*return*/];
                }
            });
        });
    };
    DirtyDiffModel.prototype.isInGitRepository = function (repository) {
        return __awaiter(this, void 0, void 0, function () {
            var modelUri, repoUri, _a;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        modelUri = this.editor.uri.withoutScheme().toString();
                        repoUri = new uri_1.default(repository.localUri).withoutScheme().toString();
                        _a = modelUri.startsWith(repoUri);
                        if (!_a) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.previousRevision.isVersionControlled()];
                    case 1:
                        _a = (_b.sent());
                        _b.label = 2;
                    case 2: return [2 /*return*/, _a];
                }
            });
        });
    };
    DirtyDiffModel.prototype.getPreviousRevisionContent = function () {
        return __awaiter(this, void 0, void 0, function () {
            var contents;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.previousRevision.getContents(this.staged)];
                    case 1:
                        contents = _a.sent();
                        return [2 /*return*/, contents ? content_lines_1.ContentLines.fromString(contents) : undefined];
                }
            });
        });
    };
    DirtyDiffModel.prototype.dispose = function () {
        this.toDispose.dispose();
        this.onDirtyDiffUpdateEmitter.dispose();
    };
    return DirtyDiffModel;
}());
exports.DirtyDiffModel = DirtyDiffModel;
(function (DirtyDiffModel) {
    var diffComputer = new diff_computer_1.DiffComputer();
    /**
     * Returns an eventually consistent result. E.g. it can happen, that lines are deleted during the computation,
     * which will internally produce 'line out of bound' errors, then it will return `undefined`.
     *
     * `ContentLines` are to avoid copying contents which improves the performance, therefore handling of the `undefined`
     * result, and rescheduling of the computation should be done by caller.
     */
    function computeDirtyDiff(previous, current) {
        try {
            return diffComputer.computeDirtyDiff(content_lines_1.ContentLines.arrayLike(previous), content_lines_1.ContentLines.arrayLike(current));
        }
        catch (_a) {
            return undefined;
        }
    }
    DirtyDiffModel.computeDirtyDiff = computeDirtyDiff;
    function documentContentLines(document) {
        return {
            length: document.lineCount,
            getLineContent: function (line) { return document.getLineContent(line + 1); },
        };
    }
    DirtyDiffModel.documentContentLines = documentContentLines;
})(DirtyDiffModel = exports.DirtyDiffModel || (exports.DirtyDiffModel = {}));
exports.DirtyDiffModel = DirtyDiffModel;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-module.js":
/*!******************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-module.js ***!
  \******************************************************************************/
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
var dirty_diff_contribution_1 = __webpack_require__(/*! ./dirty-diff-contribution */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-contribution.js");
var dirty_diff_manager_1 = __webpack_require__(/*! ./dirty-diff-manager */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-manager.js");
var dirty_diff_decorator_1 = __webpack_require__(/*! ./dirty-diff-decorator */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-decorator.js");
__webpack_require__(/*! ../../../src/browser/style/dirty-diff.css */ "../node_modules/@theia/git/src/browser/style/dirty-diff.css");
function bindDirtyDiff(bind) {
    bind(dirty_diff_manager_1.DirtyDiffManager).toSelf().inSingletonScope();
    bind(dirty_diff_contribution_1.DirtyDiffContribution).toSelf().inSingletonScope();
    bind(dirty_diff_decorator_1.DirtyDiffDecorator).toSelf().inSingletonScope();
    bind(browser_1.FrontendApplicationContribution).toService(dirty_diff_contribution_1.DirtyDiffContribution);
}
exports.bindDirtyDiff = bindDirtyDiff;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-commit-message-validator.js":
/*!******************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-commit-message-validator.js ***!
  \******************************************************************************/
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
var GitCommitMessageValidator = /** @class */ (function () {
    function GitCommitMessageValidator() {
    }
    GitCommitMessageValidator_1 = GitCommitMessageValidator;
    /**
     * Validates the input and returns with either a validation result with the status and message, or `undefined` if everything went fine.
     */
    GitCommitMessageValidator.prototype.validate = function (input) {
        if (input) {
            var lines = input.split(/\r?\n/);
            for (var i = 0; i < lines.length; i++) {
                var line = lines[i];
                var result = this.isLineValid(line, i);
                if (!!result) {
                    return result;
                }
            }
        }
        return undefined;
    };
    GitCommitMessageValidator.prototype.isLineValid = function (line, index) {
        if (index === 1 && line.length !== 0) {
            return {
                status: 'warning',
                message: 'The second line should be empty to separate the commit message from the body'
            };
        }
        var diff = line.length - this.maxCharsPerLine();
        if (diff > 0) {
            return {
                status: 'warning',
                message: diff + " characters over " + this.maxCharsPerLine() + " in current line"
            };
        }
        return undefined;
    };
    GitCommitMessageValidator.prototype.maxCharsPerLine = function () {
        return GitCommitMessageValidator_1.MAX_CHARS_PER_LINE;
    };
    var GitCommitMessageValidator_1;
    GitCommitMessageValidator.MAX_CHARS_PER_LINE = 72;
    GitCommitMessageValidator = GitCommitMessageValidator_1 = __decorate([
        inversify_1.injectable()
    ], GitCommitMessageValidator);
    return GitCommitMessageValidator;
}());
exports.GitCommitMessageValidator = GitCommitMessageValidator;
(function (GitCommitMessageValidator) {
    var Result;
    (function (Result) {
        /**
         * `true` if the `message` and the `status` properties are the same on both `left` and `right`. Or both arguments are `undefined`. Otherwise, `false`.
         */
        function equal(left, right) {
            if (left && right) {
                return left.message === right.message && left.status === right.status;
            }
            return left === right;
        }
        Result.equal = equal;
    })(Result = GitCommitMessageValidator.Result || (GitCommitMessageValidator.Result = {}));
})(GitCommitMessageValidator = exports.GitCommitMessageValidator || (exports.GitCommitMessageValidator = {}));
exports.GitCommitMessageValidator = GitCommitMessageValidator;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-decorator.js":
/*!***************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-decorator.js ***!
  \***************************************************************/
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var logger_1 = __webpack_require__(/*! @theia/core/lib/common/logger */ "../node_modules/@theia/core/lib/common/logger.js");
var event_1 = __webpack_require__(/*! @theia/core/lib/common/event */ "../node_modules/@theia/core/lib/common/event.js");
var tree_iterator_1 = __webpack_require__(/*! @theia/core/lib/browser/tree/tree-iterator */ "../node_modules/@theia/core/lib/browser/tree/tree-iterator.js");
var git_1 = __webpack_require__(/*! ../common/git */ "../node_modules/@theia/git/lib/common/git.js");
var git_model_1 = __webpack_require__(/*! ../common/git-model */ "../node_modules/@theia/git/lib/common/git-model.js");
var git_preferences_1 = __webpack_require__(/*! ./git-preferences */ "../node_modules/@theia/git/lib/browser/git-preferences.js");
var git_repository_tracker_1 = __webpack_require__(/*! ./git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var browser_1 = __webpack_require__(/*! @theia/filesystem/lib/browser */ "../node_modules/@theia/filesystem/lib/browser/index.js");
var GitDecorator = /** @class */ (function () {
    function GitDecorator() {
        this.id = 'theia-git-decorator';
        this.emitter = new event_1.Emitter();
    }
    GitDecorator.prototype.init = function () {
        var _this = this;
        this.repositories.onGitEvent(function (event) { return _this.fireDidChangeDecorations(function (tree) { return _this.collectDecorators(tree, event.status); }); });
        this.preferences.onPreferenceChanged(function (event) { return _this.handlePreferenceChange(event); });
        this.enabled = this.preferences['git.decorations.enabled'];
        this.showColors = this.preferences['git.decorations.colors'];
    };
    GitDecorator.prototype.decorations = function (tree) {
        return __awaiter(this, void 0, void 0, function () {
            var status;
            return __generator(this, function (_a) {
                status = this.repositories.selectedRepositoryStatus;
                if (status) {
                    return [2 /*return*/, this.collectDecorators(tree, status)];
                }
                return [2 /*return*/, new Map()];
            });
        });
    };
    Object.defineProperty(GitDecorator.prototype, "onDidChangeDecorations", {
        get: function () {
            return this.emitter.event;
        },
        enumerable: true,
        configurable: true
    });
    GitDecorator.prototype.fireDidChangeDecorations = function (event) {
        this.emitter.fire(event);
    };
    GitDecorator.prototype.collectDecorators = function (tree, status) {
        var _this = this;
        var e_1, _a;
        var result = new Map();
        if (tree.root === undefined || !this.enabled) {
            return result;
        }
        var markers = this.appendContainerChanges(tree, status.changes);
        try {
            for (var _b = __values(new tree_iterator_1.DepthFirstTreeIterator(tree.root)), _c = _b.next(); !_c.done; _c = _b.next()) {
                var treeNode = _c.value;
                var uri = browser_1.FileStatNode.getUri(treeNode);
                if (uri) {
                    var marker = markers.get(uri);
                    if (marker) {
                        result.set(treeNode.id, marker);
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
        return new Map(Array.from(result.entries()).map(function (m) { return [m[0], _this.toDecorator(m[1])]; }));
    };
    GitDecorator.prototype.appendContainerChanges = function (tree, changes) {
        var e_2, _a;
        var result = new Map();
        try {
            // We traverse up and assign the highest Git file change status the container directory.
            // Note, instead of stopping at the WS root, we traverse up the driver root.
            // We will filter them later based on the expansion state of the tree.
            for (var _b = __values(new Map(changes.map(function (m) { return [new uri_1.default(m.uri), m]; })).entries()), _c = _b.next(); !_c.done; _c = _b.next()) {
                var _d = __read(_c.value, 2), uri = _d[0], change = _d[1];
                var uriString = uri.toString();
                result.set(uriString, change);
                var parentUri = uri.parent;
                while (parentUri && !parentUri.path.isRoot) {
                    var parentUriString = parentUri.toString();
                    var existing = result.get(parentUriString);
                    if (existing === undefined || this.compare(existing, change) < 0) {
                        result.set(parentUriString, {
                            uri: parentUriString,
                            status: change.status,
                            staged: !!change.staged
                        });
                        parentUri = parentUri.parent;
                    }
                    else {
                        parentUri = undefined;
                    }
                }
            }
        }
        catch (e_2_1) { e_2 = { error: e_2_1 }; }
        finally {
            try {
                if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
            }
            finally { if (e_2) throw e_2.error; }
        }
        return result;
    };
    GitDecorator.prototype.toDecorator = function (change) {
        var data = git_model_1.GitFileStatus.toAbbreviation(change.status, change.staged);
        var color = this.getDecorationColor(change.status, change.staged);
        var tooltip = git_model_1.GitFileStatus.toString(change.status, change.staged);
        var decorationData = {
            tailDecorations: [
                {
                    data: data,
                    fontData: {
                        color: color
                    },
                    tooltip: tooltip
                }
            ]
        };
        if (this.showColors) {
            decorationData = __assign({}, decorationData, { fontData: {
                    color: color
                } });
        }
        return decorationData;
    };
    GitDecorator.prototype.compare = function (left, right) {
        return git_model_1.GitFileStatus.statusCompare(left.status, right.status);
    };
    GitDecorator.prototype.getDecorationColor = function (status, staged) {
        switch (status) {
            case git_model_1.GitFileStatus.New: return 'var(--theia-success-color0)';
            case git_model_1.GitFileStatus.Renamed: // Fall through.
            case git_model_1.GitFileStatus.Copied: // Fall through.
            case git_model_1.GitFileStatus.Modified: return 'var(--theia-brand-color0)';
            case git_model_1.GitFileStatus.Deleted: return 'var(--theia-warn-color0)';
            case git_model_1.GitFileStatus.Conflicted: return 'var(--theia-error-color0)';
        }
    };
    GitDecorator.prototype.handlePreferenceChange = function (event) {
        return __awaiter(this, void 0, void 0, function () {
            var refresh, preferenceName, newValue, enabled, showColors, status;
            var _this = this;
            return __generator(this, function (_a) {
                refresh = false;
                preferenceName = event.preferenceName, newValue = event.newValue;
                if (preferenceName === 'git.decorations.enabled') {
                    enabled = !!newValue;
                    if (this.enabled !== enabled) {
                        this.enabled = enabled;
                        refresh = true;
                    }
                }
                if (preferenceName === 'git.decorations.colors') {
                    showColors = !!newValue;
                    if (this.showColors !== showColors) {
                        this.showColors = showColors;
                        refresh = true;
                    }
                }
                status = this.repositories.selectedRepositoryStatus;
                if (refresh && status) {
                    this.fireDidChangeDecorations(function (tree) { return _this.collectDecorators(tree, status); });
                }
                return [2 /*return*/];
            });
        });
    };
    __decorate([
        inversify_1.inject(git_1.Git),
        __metadata("design:type", Object)
    ], GitDecorator.prototype, "git", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], GitDecorator.prototype, "repositories", void 0);
    __decorate([
        inversify_1.inject(git_preferences_1.GitPreferences),
        __metadata("design:type", Object)
    ], GitDecorator.prototype, "preferences", void 0);
    __decorate([
        inversify_1.inject(logger_1.ILogger),
        __metadata("design:type", Object)
    ], GitDecorator.prototype, "logger", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], GitDecorator.prototype, "init", null);
    GitDecorator = __decorate([
        inversify_1.injectable()
    ], GitDecorator);
    return GitDecorator;
}());
exports.GitDecorator = GitDecorator;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-error-handler.js":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-error-handler.js ***!
  \*******************************************************************/
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var GitErrorHandler = /** @class */ (function () {
    function GitErrorHandler() {
    }
    // tslint:disable-next-line:no-any
    GitErrorHandler.prototype.handleError = function (error) {
        var message = error instanceof Error ? error.message : error;
        if (message) {
            this.messageService.error(message, { timeout: 0 });
        }
    };
    __decorate([
        inversify_1.inject(core_1.MessageService),
        __metadata("design:type", core_1.MessageService)
    ], GitErrorHandler.prototype, "messageService", void 0);
    GitErrorHandler = __decorate([
        inversify_1.injectable()
    ], GitErrorHandler);
    return GitErrorHandler;
}());
exports.GitErrorHandler = GitErrorHandler;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-frontend-module.js":
/*!*********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-frontend-module.js ***!
  \*********************************************************************/
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
var browser_2 = __webpack_require__(/*! @theia/navigator/lib/browser */ "../node_modules/@theia/navigator/lib/browser/index.js");
var common_2 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_view_contribution_1 = __webpack_require__(/*! ./git-view-contribution */ "../node_modules/@theia/git/lib/browser/git-view-contribution.js");
var git_diff_frontend_module_1 = __webpack_require__(/*! ./diff/git-diff-frontend-module */ "../node_modules/@theia/git/lib/browser/diff/git-diff-frontend-module.js");
var git_history_frontend_module_1 = __webpack_require__(/*! ./history/git-history-frontend-module */ "../node_modules/@theia/git/lib/browser/history/git-history-frontend-module.js");
var git_widget_1 = __webpack_require__(/*! ./git-widget */ "../node_modules/@theia/git/lib/browser/git-widget.js");
var git_resource_1 = __webpack_require__(/*! ./git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var git_quick_open_service_1 = __webpack_require__(/*! ./git-quick-open-service */ "../node_modules/@theia/git/lib/browser/git-quick-open-service.js");
var git_uri_label_contribution_1 = __webpack_require__(/*! ./git-uri-label-contribution */ "../node_modules/@theia/git/lib/browser/git-uri-label-contribution.js");
var git_decorator_1 = __webpack_require__(/*! ./git-decorator */ "../node_modules/@theia/git/lib/browser/git-decorator.js");
var git_preferences_1 = __webpack_require__(/*! ./git-preferences */ "../node_modules/@theia/git/lib/browser/git-preferences.js");
var dirty_diff_module_1 = __webpack_require__(/*! ./dirty-diff/dirty-diff-module */ "../node_modules/@theia/git/lib/browser/dirty-diff/dirty-diff-module.js");
var blame_module_1 = __webpack_require__(/*! ./blame/blame-module */ "../node_modules/@theia/git/lib/browser/blame/blame-module.js");
var git_repository_tracker_1 = __webpack_require__(/*! ./git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var git_commit_message_validator_1 = __webpack_require__(/*! ./git-commit-message-validator */ "../node_modules/@theia/git/lib/browser/git-commit-message-validator.js");
var git_sync_service_1 = __webpack_require__(/*! ./git-sync-service */ "../node_modules/@theia/git/lib/browser/git-sync-service.js");
var git_error_handler_1 = __webpack_require__(/*! ./git-error-handler */ "../node_modules/@theia/git/lib/browser/git-error-handler.js");
__webpack_require__(/*! ../../src/browser/style/index.css */ "../node_modules/@theia/git/src/browser/style/index.css");
exports.default = new inversify_1.ContainerModule(function (bind) {
    git_preferences_1.bindGitPreferences(bind);
    git_diff_frontend_module_1.bindGitDiffModule(bind);
    git_history_frontend_module_1.bindGitHistoryModule(bind);
    dirty_diff_module_1.bindDirtyDiff(bind);
    blame_module_1.bindBlame(bind);
    bind(git_repository_tracker_1.GitRepositoryTracker).toSelf().inSingletonScope();
    bind(common_2.GitWatcherServerProxy).toDynamicValue(function (context) { return browser_1.WebSocketConnectionProvider.createProxy(context.container, common_2.GitWatcherPath); }).inSingletonScope();
    bind(common_2.GitWatcherServer).to(common_2.ReconnectingGitWatcherServer).inSingletonScope();
    bind(common_2.GitWatcher).toSelf().inSingletonScope();
    bind(common_2.Git).toDynamicValue(function (context) { return browser_1.WebSocketConnectionProvider.createProxy(context.container, common_2.GitPath); }).inSingletonScope();
    browser_1.bindViewContribution(bind, git_view_contribution_1.GitViewContribution);
    bind(browser_1.FrontendApplicationContribution).toService(git_view_contribution_1.GitViewContribution);
    bind(git_widget_1.GitWidget).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (context) { return ({
        id: git_view_contribution_1.GIT_WIDGET_FACTORY_ID,
        createWidget: function () { return context.container.get(git_widget_1.GitWidget); }
    }); }).inSingletonScope();
    bind(git_resource_1.GitResourceResolver).toSelf().inSingletonScope();
    bind(common_1.ResourceResolver).toService(git_resource_1.GitResourceResolver);
    bind(git_repository_provider_1.GitRepositoryProvider).toSelf().inSingletonScope();
    bind(git_quick_open_service_1.GitQuickOpenService).toSelf().inSingletonScope();
    bind(browser_1.LabelProviderContribution).to(git_uri_label_contribution_1.GitUriLabelProviderContribution).inSingletonScope();
    bind(browser_2.NavigatorTreeDecorator).to(git_decorator_1.GitDecorator).inSingletonScope();
    bind(git_commit_message_validator_1.GitCommitMessageValidator).toSelf().inSingletonScope();
    bind(git_sync_service_1.GitSyncService).toSelf().inSingletonScope();
    bind(git_error_handler_1.GitErrorHandler).toSelf().inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-navigable-list-widget.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-navigable-list-widget.js ***!
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
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
var domutils_1 = __webpack_require__(/*! @phosphor/domutils */ "../node_modules/@phosphor/domutils/lib/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var react_widget_1 = __webpack_require__(/*! @theia/core/lib/browser/widgets/react-widget */ "../node_modules/@theia/core/lib/browser/widgets/react-widget.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var GitNavigableListWidget = /** @class */ (function (_super) {
    __extends(GitNavigableListWidget, _super);
    function GitNavigableListWidget() {
        var _this = _super.call(this) || this;
        _this.node.tabIndex = 0;
        return _this;
    }
    GitNavigableListWidget.prototype.onActivateRequest = function (msg) {
        _super.prototype.onActivateRequest.call(this, msg);
        this.update();
        this.node.focus();
    };
    Object.defineProperty(GitNavigableListWidget.prototype, "scrollContainer", {
        get: function () {
            return this._scrollContainer;
        },
        set: function (id) {
            this._scrollContainer = id + Date.now();
        },
        enumerable: true,
        configurable: true
    });
    GitNavigableListWidget.prototype.onUpdateRequest = function (msg) {
        var _this = this;
        if (!this.isAttached || !this.isVisible) {
            return;
        }
        _super.prototype.onUpdateRequest.call(this, msg);
        (function () { return __awaiter(_this, void 0, void 0, function () {
            var selected;
            return __generator(this, function (_a) {
                selected = this.node.getElementsByClassName(browser_1.SELECTED_CLASS)[0];
                if (selected) {
                    domutils_1.ElementExt.scrollIntoViewIfNeeded(this.node, selected);
                }
                return [2 /*return*/];
            });
        }); })();
    };
    GitNavigableListWidget.prototype.getStatusCaption = function (status, staged) {
        return common_1.GitFileStatus.toString(status, staged);
    };
    GitNavigableListWidget.prototype.getAbbreviatedStatusCaption = function (status, staged) {
        return common_1.GitFileStatus.toAbbreviation(status, staged);
    };
    GitNavigableListWidget.prototype.relativePath = function (uri) {
        var parsedUri = typeof uri === 'string' ? new uri_1.default(uri) : uri;
        var repo = this.repositoryProvider.findRepository(parsedUri);
        if (repo) {
            return common_1.Repository.relativePath(repo, parsedUri).toString();
        }
        else {
            return this.labelProvider.getLongName(parsedUri);
        }
    };
    GitNavigableListWidget.prototype.getRepositoryLabel = function (uri) {
        var repository = this.repositoryProvider.findRepository(new uri_1.default(uri));
        var isSelectedRepo = this.repositoryProvider.selectedRepository && repository && this.repositoryProvider.selectedRepository.localUri === repository.localUri;
        return repository && !isSelectedRepo ? this.labelProvider.getLongName(new uri_1.default(repository.localUri)) : undefined;
    };
    GitNavigableListWidget.prototype.computeCaption = function (fileChange) {
        var result = this.relativePath(fileChange.uri) + " - " + this.getStatusCaption(fileChange.status, true);
        if (fileChange.oldUri) {
            result = this.relativePath(fileChange.oldUri) + " -> " + result;
        }
        return result;
    };
    GitNavigableListWidget.prototype.renderHeaderRow = function (_a) {
        var name = _a.name, value = _a.value, classNames = _a.classNames;
        if (!value) {
            return;
        }
        var className = __spread(['header-row'], (classNames || [])).join(' ');
        return React.createElement("div", { key: name, className: className },
            React.createElement("div", { className: 'theia-header' }, name),
            React.createElement("div", { className: 'header-value' }, value));
    };
    GitNavigableListWidget.prototype.addGitListNavigationKeyListeners = function (container) {
        var _this = this;
        this.addKeyListener(container, browser_1.Key.ARROW_LEFT, function () { return _this.navigateLeft(); });
        this.addKeyListener(container, browser_1.Key.ARROW_RIGHT, function () { return _this.navigateRight(); });
        this.addKeyListener(container, browser_1.Key.ARROW_UP, function () { return _this.navigateUp(); });
        this.addKeyListener(container, browser_1.Key.ARROW_DOWN, function () { return _this.navigateDown(); });
        this.addKeyListener(container, browser_1.Key.ENTER, function () { return _this.handleListEnter(); });
    };
    GitNavigableListWidget.prototype.navigateLeft = function () {
        this.selectPreviousNode();
    };
    GitNavigableListWidget.prototype.navigateRight = function () {
        this.selectNextNode();
    };
    GitNavigableListWidget.prototype.navigateUp = function () {
        this.selectPreviousNode();
    };
    GitNavigableListWidget.prototype.navigateDown = function () {
        this.selectNextNode();
    };
    GitNavigableListWidget.prototype.handleListEnter = function () {
    };
    GitNavigableListWidget.prototype.getSelected = function () {
        return this.gitNodes ? this.gitNodes.find(function (c) { return c.selected || false; }) : undefined;
    };
    GitNavigableListWidget.prototype.selectNode = function (node) {
        var n = this.getSelected();
        if (n) {
            n.selected = false;
        }
        node.selected = true;
        this.update();
    };
    GitNavigableListWidget.prototype.selectNextNode = function () {
        var idx = this.indexOfSelected;
        if (idx >= 0 && idx < this.gitNodes.length - 1) {
            this.selectNode(this.gitNodes[idx + 1]);
        }
        else if (this.gitNodes.length > 0 && idx === -1) {
            this.selectNode(this.gitNodes[0]);
        }
    };
    GitNavigableListWidget.prototype.selectPreviousNode = function () {
        var idx = this.indexOfSelected;
        if (idx > 0) {
            this.selectNode(this.gitNodes[idx - 1]);
        }
    };
    Object.defineProperty(GitNavigableListWidget.prototype, "indexOfSelected", {
        get: function () {
            if (this.gitNodes && this.gitNodes.length > 0) {
                return this.gitNodes.findIndex(function (c) { return c.selected || false; });
            }
            return -1;
        },
        enumerable: true,
        configurable: true
    });
    __decorate([
        inversify_1.inject(git_repository_provider_1.GitRepositoryProvider),
        __metadata("design:type", git_repository_provider_1.GitRepositoryProvider)
    ], GitNavigableListWidget.prototype, "repositoryProvider", void 0);
    __decorate([
        inversify_1.inject(label_provider_1.LabelProvider),
        __metadata("design:type", label_provider_1.LabelProvider)
    ], GitNavigableListWidget.prototype, "labelProvider", void 0);
    GitNavigableListWidget = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], GitNavigableListWidget);
    return GitNavigableListWidget;
}(react_widget_1.ReactWidget));
exports.GitNavigableListWidget = GitNavigableListWidget;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-preferences.js":
/*!*****************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-preferences.js ***!
  \*****************************************************************/
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
exports.GitConfigSchema = {
    'type': 'object',
    'properties': {
        'git.decorations.enabled': {
            'type': 'boolean',
            'description': 'Show Git file status in the navigator.',
            'default': true
        },
        'git.decorations.colors': {
            'type': 'boolean',
            'description': 'Use color decoration in the navigator.',
            'default': false
        },
        'git.editor.decorations.enabled': {
            'type': 'boolean',
            'description': 'Show git decorations in the editor.',
            'default': true
        },
        'git.editor.dirtydiff.linesLimit': {
            'type': 'number',
            'description': 'Do not show dirty diff decorations, if editor\'s line count exceeds this limit.',
            'default': 1000
        }
    }
};
exports.GitPreferences = Symbol('GitPreferences');
function createGitPreferences(preferences) {
    return browser_1.createPreferenceProxy(preferences, exports.GitConfigSchema);
}
exports.createGitPreferences = createGitPreferences;
function bindGitPreferences(bind) {
    bind(exports.GitPreferences).toDynamicValue(function (ctx) {
        var preferences = ctx.container.get(browser_1.PreferenceService);
        return createGitPreferences(preferences);
    });
    bind(browser_1.PreferenceContribution).toConstantValue({ schema: exports.GitConfigSchema });
}
exports.bindGitPreferences = bindGitPreferences;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-quick-open-service.js":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-quick-open-service.js ***!
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var quick_open_model_1 = __webpack_require__(/*! @theia/core/lib/browser/quick-open/quick-open-model */ "../node_modules/@theia/core/lib/browser/quick-open/quick-open-model.js");
var quick_open_service_1 = __webpack_require__(/*! @theia/core/lib/browser/quick-open/quick-open-service */ "../node_modules/@theia/core/lib/browser/quick-open/quick-open-service.js");
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var message_service_1 = __webpack_require__(/*! @theia/core/lib/common/message-service */ "../node_modules/@theia/core/lib/common/message-service.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var workspace_service_1 = __webpack_require__(/*! @theia/workspace/lib/browser/workspace-service */ "../node_modules/@theia/workspace/lib/browser/workspace-service.js");
var file_uri_1 = __webpack_require__(/*! @theia/core/lib/node/file-uri */ "../node_modules/@theia/core/lib/node/file-uri.js");
var common_2 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var git_error_handler_1 = __webpack_require__(/*! ./git-error-handler */ "../node_modules/@theia/git/lib/browser/git-error-handler.js");
/**
 * Service delegating into the `Quick Open Service`, so that the Git commands can be further refined.
 * For instance, the `remote` can be specified for `pull`, `push`, and `fetch`. And the branch can be
 * specified for `git merge`.
 */
var GitQuickOpenService = /** @class */ (function () {
    function GitQuickOpenService(git, repositoryProvider, quickOpenService, messageService, workspaceService, fileSystem) {
        this.git = git;
        this.repositoryProvider = repositoryProvider;
        this.quickOpenService = quickOpenService;
        this.messageService = messageService;
        this.workspaceService = workspaceService;
        this.fileSystem = fileSystem;
    }
    GitQuickOpenService.prototype.clone = function (url, folder, branch) {
        return __awaiter(this, void 0, void 0, function () {
            var roots, repo, _a, _b, _c, _d, gitCloneLocalTargetFolder, gitQuickOpenService, cloneRepoModel;
            return __generator(this, function (_e) {
                switch (_e.label) {
                    case 0:
                        if (!!folder) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.workspaceService.roots];
                    case 1:
                        roots = _e.sent();
                        folder = roots[0].uri;
                        _e.label = 2;
                    case 2:
                        if (!url) return [3 /*break*/, 5];
                        _b = (_a = this.git).clone;
                        _c = [url];
                        _d = {};
                        return [4 /*yield*/, this.buildDefaultProjectPath(folder, url)];
                    case 3: return [4 /*yield*/, _b.apply(_a, _c.concat([(_d.localUri = _e.sent(),
                                _d.branch = branch,
                                _d)]))];
                    case 4:
                        repo = _e.sent();
                        return [2 /*return*/, repo.localUri];
                    case 5:
                        gitCloneLocalTargetFolder = folder;
                        gitQuickOpenService = this;
                        cloneRepoModel = {
                            onType: function (lookFor, acceptor) {
                                var _this = this;
                                var dynamicItems = [];
                                var suffix = "Press 'Enter' to confirm or 'Escape' to cancel.";
                                if (lookFor === undefined || lookFor.length === 0) {
                                    dynamicItems.push(new SingleStringInputOpenItem("Please provide a Git repository location. " + suffix, function () { }, function () { return false; }));
                                }
                                else {
                                    dynamicItems.push(new SingleStringInputOpenItem("Clone the Git repository: " + lookFor + ". " + suffix, function () { return __awaiter(_this, void 0, void 0, function () {
                                        var _a, _b, _c, _d, error_1;
                                        return __generator(this, function (_e) {
                                            switch (_e.label) {
                                                case 0:
                                                    _e.trys.push([0, 3, , 4]);
                                                    _b = (_a = gitQuickOpenService.git).clone;
                                                    _c = [lookFor];
                                                    _d = {};
                                                    return [4 /*yield*/, gitQuickOpenService.buildDefaultProjectPath(gitCloneLocalTargetFolder, lookFor)];
                                                case 1: return [4 /*yield*/, _b.apply(_a, _c.concat([(_d.localUri = _e.sent(), _d)]))];
                                                case 2:
                                                    _e.sent();
                                                    return [3 /*break*/, 4];
                                                case 3:
                                                    error_1 = _e.sent();
                                                    gitQuickOpenService.gitErrorHandler.handleError(error_1);
                                                    return [3 /*break*/, 4];
                                                case 4: return [2 /*return*/];
                                            }
                                        });
                                    }); }));
                                }
                                acceptor(dynamicItems);
                            }
                        };
                        this.quickOpenService.open(cloneRepoModel, this.getOptions('Git repository location:', false));
                        return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.buildDefaultProjectPath = function (folderPath, gitURI) {
        return __awaiter(this, void 0, void 0, function () {
            var uriSplitted, projectPath;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.fileSystem.exists(folderPath)];
                    case 1:
                        if (!(_a.sent())) {
                            // user specifies its own project path, doesn't want us to guess it
                            return [2 /*return*/, folderPath];
                        }
                        uriSplitted = gitURI.split('/');
                        projectPath = folderPath + '/' + (uriSplitted.pop() || uriSplitted.pop());
                        if (projectPath.endsWith('.git')) {
                            projectPath = projectPath.substring(0, projectPath.length - '.git'.length);
                        }
                        return [2 /*return*/, projectPath];
                }
            });
        });
    };
    GitQuickOpenService.prototype.fetch = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, remotes, execute_1, items;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        repository = this.getRepository();
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.getRemotes()];
                    case 1:
                        remotes = _a.sent();
                        execute_1 = function (item) { return __awaiter(_this, void 0, void 0, function () {
                            var error_2;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        _a.trys.push([0, 2, , 3]);
                                        return [4 /*yield*/, this.git.fetch(repository, { remote: item.getLabel() })];
                                    case 1:
                                        _a.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        error_2 = _a.sent();
                                        this.gitErrorHandler.handleError(error_2);
                                        return [3 /*break*/, 3];
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); };
                        items = remotes.map(function (remote) { return new GitQuickOpenItem(remote, execute_1); });
                        this.open(items, 'Pick a remote to fetch from:');
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.push = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, _a, remotes, currentBranch, execute_2, items, branchName;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        repository = this.getRepository();
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, Promise.all([this.getRemotes(), this.getCurrentBranch()])];
                    case 1:
                        _a = __read.apply(void 0, [_b.sent(), 2]), remotes = _a[0], currentBranch = _a[1];
                        execute_2 = function (item) { return __awaiter(_this, void 0, void 0, function () {
                            var error_3;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        _a.trys.push([0, 2, , 3]);
                                        return [4 /*yield*/, this.git.push(repository, { remote: item.getLabel() })];
                                    case 1:
                                        _a.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        error_3 = _a.sent();
                                        this.gitErrorHandler.handleError(error_3);
                                        return [3 /*break*/, 3];
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); };
                        items = remotes.map(function (remote) { return new GitQuickOpenItem(remote, execute_2); });
                        branchName = currentBranch ? "'" + currentBranch.name + "' " : '';
                        this.open(items, "Pick a remote to push the currently active branch " + branchName + "to:");
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.pull = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, remotes, defaultRemote_1, executeRemote_1, remoteItems;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        repository = this.getRepository();
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.getRemotes()];
                    case 1:
                        remotes = _a.sent();
                        defaultRemote_1 = remotes[0];
                        executeRemote_1 = function (remoteItem) { return __awaiter(_this, void 0, void 0, function () {
                            var error_4, branches, executeBranch_1, toLabel_1, branchItems;
                            var _this = this;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        if (!(remoteItem.ref === defaultRemote_1)) return [3 /*break*/, 5];
                                        _a.label = 1;
                                    case 1:
                                        _a.trys.push([1, 3, , 4]);
                                        return [4 /*yield*/, this.git.pull(repository, { remote: remoteItem.getLabel() })];
                                    case 2:
                                        _a.sent();
                                        return [3 /*break*/, 4];
                                    case 3:
                                        error_4 = _a.sent();
                                        this.gitErrorHandler.handleError(error_4);
                                        return [3 /*break*/, 4];
                                    case 4: return [3 /*break*/, 7];
                                    case 5: return [4 /*yield*/, this.getBranches()];
                                    case 6:
                                        branches = _a.sent();
                                        executeBranch_1 = function (branchItem) { return __awaiter(_this, void 0, void 0, function () {
                                            var error_5;
                                            return __generator(this, function (_a) {
                                                switch (_a.label) {
                                                    case 0:
                                                        _a.trys.push([0, 2, , 3]);
                                                        return [4 /*yield*/, this.git.pull(repository, { remote: remoteItem.ref, branch: branchItem.ref.nameWithoutRemote })];
                                                    case 1:
                                                        _a.sent();
                                                        return [3 /*break*/, 3];
                                                    case 2:
                                                        error_5 = _a.sent();
                                                        this.gitErrorHandler.handleError(error_5);
                                                        return [3 /*break*/, 3];
                                                    case 3: return [2 /*return*/];
                                                }
                                            });
                                        }); };
                                        toLabel_1 = function (branchItem) { return branchItem.ref.name; };
                                        branchItems = branches
                                            .filter(function (branch) { return branch.type === common_1.BranchType.Remote; })
                                            .filter(function (branch) { return (branch.name || '').startsWith(remoteItem.ref + "/"); })
                                            .map(function (branch) { return new GitQuickOpenItem(branch, executeBranch_1, toLabel_1); });
                                        this.open(branchItems, 'Select the branch to pull the changes from:');
                                        _a.label = 7;
                                    case 7: return [2 /*return*/];
                                }
                            });
                        }); };
                        remoteItems = remotes.map(function (remote) { return new GitQuickOpenItem(remote, executeRemote_1); });
                        this.open(remoteItems, 'Pick a remote to pull the branch from:');
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.merge = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, _a, branches, currentBranch, execute_3, toLabel_2, items, branchName;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        repository = this.getRepository();
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, Promise.all([this.getBranches(), this.getCurrentBranch()])];
                    case 1:
                        _a = __read.apply(void 0, [_b.sent(), 2]), branches = _a[0], currentBranch = _a[1];
                        execute_3 = function (item) { return __awaiter(_this, void 0, void 0, function () {
                            var error_6;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        _a.trys.push([0, 2, , 3]);
                                        return [4 /*yield*/, this.git.merge(repository, { branch: item.getLabel() })];
                                    case 1:
                                        _a.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        error_6 = _a.sent();
                                        this.gitErrorHandler.handleError(error_6);
                                        return [3 /*break*/, 3];
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); };
                        toLabel_2 = function (item) { return item.ref.name; };
                        items = branches.map(function (branch) { return new GitQuickOpenItem(branch, execute_3, toLabel_2); });
                        branchName = currentBranch ? "'" + currentBranch.name + "' " : '';
                        this.open(items, "Pick a branch to merge into the currently active " + branchName + "branch:");
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.checkout = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, _a, branches, currentBranch_1, index, switchBranch_1, toLabel_3, toDescription_1, items, createBranchItem;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        repository = this.getRepository();
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, Promise.all([this.getBranches(), this.getCurrentBranch()])];
                    case 1:
                        _a = __read.apply(void 0, [_b.sent(), 2]), branches = _a[0], currentBranch_1 = _a[1];
                        if (currentBranch_1) {
                            index = branches.findIndex(function (branch) { return branch && branch.name === currentBranch_1.name; });
                            branches.splice(index, 1);
                        }
                        switchBranch_1 = function (item) { return __awaiter(_this, void 0, void 0, function () {
                            var error_7;
                            return __generator(this, function (_a) {
                                switch (_a.label) {
                                    case 0:
                                        _a.trys.push([0, 2, , 3]);
                                        return [4 /*yield*/, this.git.checkout(repository, { branch: item.ref.nameWithoutRemote })];
                                    case 1:
                                        _a.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        error_7 = _a.sent();
                                        this.gitErrorHandler.handleError(error_7);
                                        return [3 /*break*/, 3];
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); };
                        toLabel_3 = function (item) {
                            var branch = item.ref;
                            return branch.type === common_1.BranchType.Remote ? branch.name : branch.nameWithoutRemote;
                        };
                        toDescription_1 = function (item) {
                            var branch = item.ref;
                            // We have only the long SHA1, but getting the first seven characters is the same.
                            var tip = branch.tip.sha.length > 8 ? " " + branch.tip.sha.slice(0, 7) : '';
                            return branch.type === common_1.BranchType.Remote ? "Remote branch at" + tip : "" + tip;
                        };
                        items = branches.map(function (branch) { return new GitQuickOpenItem(branch, switchBranch_1, toLabel_3, toDescription_1); });
                        createBranchItem = function (item) {
                            var gitQuickOpenService = _this;
                            var createBranchModel = {
                                onType: function (lookFor, acceptor) {
                                    var _this = this;
                                    var dynamicItems = [];
                                    var suffix = "Press 'Enter' to confirm or 'Escape' to cancel.";
                                    if (lookFor === undefined || lookFor.length === 0) {
                                        dynamicItems.push(new SingleStringInputOpenItem("Please provide a branch name. " + suffix, function () { }, function () { return false; }));
                                    }
                                    else {
                                        dynamicItems.push(new SingleStringInputOpenItem("Create a new local branch with name: " + lookFor + ". " + suffix, function () { return __awaiter(_this, void 0, void 0, function () {
                                            var error_8;
                                            return __generator(this, function (_a) {
                                                switch (_a.label) {
                                                    case 0:
                                                        _a.trys.push([0, 3, , 4]);
                                                        return [4 /*yield*/, gitQuickOpenService.git.branch(repository, { toCreate: lookFor })];
                                                    case 1:
                                                        _a.sent();
                                                        return [4 /*yield*/, gitQuickOpenService.git.checkout(repository, { branch: lookFor })];
                                                    case 2:
                                                        _a.sent();
                                                        return [3 /*break*/, 4];
                                                    case 3:
                                                        error_8 = _a.sent();
                                                        gitQuickOpenService.gitErrorHandler.handleError(error_8);
                                                        return [3 /*break*/, 4];
                                                    case 4: return [2 /*return*/];
                                                }
                                            });
                                        }); }));
                                    }
                                    acceptor(dynamicItems);
                                }
                            };
                            _this.quickOpenService.open(createBranchModel, _this.getOptions('The name of the branch:', false));
                        };
                        items.unshift(new SingleStringInputOpenItem('Create new branch...', createBranchItem, function (mode) { return mode === quick_open_model_1.QuickOpenMode.OPEN; }, function () { return false; }));
                        this.open(items, 'Select a ref to checkout or create a new local branch:');
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.changeRepository = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repositories, items;
            var _this = this;
            return __generator(this, function (_a) {
                repositories = this.repositoryProvider.allRepositories;
                if (repositories.length > 1) {
                    items = repositories.map(function (repository) {
                        var uri = new uri_1.default(repository.localUri);
                        var execute = function () { return _this.repositoryProvider.selectedRepository = repository; };
                        var toLabel = function () { return uri.path.base; };
                        var toDescription = function () { return file_uri_1.FileUri.fsPath(uri); };
                        return new GitQuickOpenItem(repository, execute, toLabel, toDescription);
                    });
                    this.open(items, 'Select a local Git repository to work with:');
                }
                return [2 /*return*/];
            });
        });
    };
    GitQuickOpenService.prototype.chooseTagsAndBranches = function (execFunc, repository) {
        if (repository === void 0) { repository = this.getRepository(); }
        return __awaiter(this, void 0, void 0, function () {
            var _a, branches, tags, currentBranch_2, execute_4, toLabel_4, branchItems, branchName, tagItems;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, Promise.all([this.getBranches(repository), this.getTags(repository), this.getCurrentBranch(repository)])];
                    case 1:
                        _a = __read.apply(void 0, [_b.sent(), 3]), branches = _a[0], tags = _a[1], currentBranch_2 = _a[2];
                        execute_4 = function (item) { return __awaiter(_this, void 0, void 0, function () {
                            return __generator(this, function (_a) {
                                execFunc(item.ref.name, currentBranch_2 ? currentBranch_2.name : '');
                                return [2 /*return*/];
                            });
                        }); };
                        toLabel_4 = function (item) { return item.ref.name; };
                        branchItems = branches.map(function (branch) { return new GitQuickOpenItem(branch, execute_4, toLabel_4); });
                        branchName = currentBranch_2 ? "'" + currentBranch_2.name + "' " : '';
                        tagItems = tags.map(function (tag) { return new GitQuickOpenItem(tag, execute_4, toLabel_4); });
                        this.open(__spread(branchItems, tagItems), "Pick a branch or tag to compare with the currently active " + branchName + " branch:");
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.commitMessageForAmend = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, lastMessage, message;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        repository = this.getRepository();
                        if (repository === undefined) {
                            throw new Error('No repositories were selected.');
                        }
                        return [4 /*yield*/, this.git.exec(repository, ['log', '--format=%B', '-n', '1'])];
                    case 1:
                        lastMessage = (_a.sent()).stdout.trim();
                        if (lastMessage.length === 0) {
                            throw new Error("Repository " + repository.localUri + " is not yet initialized.");
                        }
                        message = lastMessage.replace(/[\r\n]+/g, ' ');
                        return [2 /*return*/, new Promise(function (resolve, reject) {
                                var createEditCommitMessageModel = {
                                    onType: function (lookFor, acceptor) {
                                        var dynamicItems = [];
                                        if (!lookFor) {
                                            var description_1 = "To reuse the last commit message, press 'Enter' or 'Escape' to cancel.";
                                            dynamicItems.push(new GitQuickOpenItem(description_1, function () { return resolve(lastMessage); }, function () { return description_1; }));
                                        }
                                        else {
                                            dynamicItems.push(new GitQuickOpenItem("Rewrite previous commit message. Press 'Enter' to confirm or 'Escape' to cancel.", function (item) { return resolve(lookFor); }));
                                        }
                                        acceptor(dynamicItems);
                                    },
                                };
                                var onClose = function (canceled) {
                                    if (canceled) {
                                        reject(new Error('User abort.'));
                                    }
                                };
                                _this.quickOpenService.open(createEditCommitMessageModel, _this.getOptions(message, false, onClose));
                            })];
                }
            });
        });
    };
    GitQuickOpenService.prototype.open = function (items, placeholder) {
        this.quickOpenService.open(this.getModel(Array.isArray(items) ? items : [items]), this.getOptions(placeholder));
    };
    GitQuickOpenService.prototype.getOptions = function (placeholder, fuzzyMatchLabel, onClose) {
        if (fuzzyMatchLabel === void 0) { fuzzyMatchLabel = true; }
        if (onClose === void 0) { onClose = function () { }; }
        return quick_open_service_1.QuickOpenOptions.resolve({
            placeholder: placeholder,
            fuzzyMatchLabel: fuzzyMatchLabel,
            fuzzySort: false,
            onClose: onClose
        });
    };
    GitQuickOpenService.prototype.getModel = function (items) {
        return {
            onType: function (lookFor, acceptor) {
                acceptor(Array.isArray(items) ? items : [items]);
            }
        };
    };
    GitQuickOpenService.prototype.getRepository = function () {
        return this.repositoryProvider.selectedRepository;
    };
    GitQuickOpenService.prototype.getRemotes = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, _a, error_9;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        repository = this.getRepository();
                        _b.label = 1;
                    case 1:
                        _b.trys.push([1, 5, , 6]);
                        if (!repository) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.git.remote(repository)];
                    case 2:
                        _a = _b.sent();
                        return [3 /*break*/, 4];
                    case 3:
                        _a = [];
                        _b.label = 4;
                    case 4: return [2 /*return*/, _a];
                    case 5:
                        error_9 = _b.sent();
                        this.gitErrorHandler.handleError(error_9);
                        return [2 /*return*/, []];
                    case 6: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.getTags = function (repository) {
        if (repository === void 0) { repository = this.getRepository(); }
        return __awaiter(this, void 0, void 0, function () {
            var result;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!repository) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.git.exec(repository, ['tag', '--sort=-creatordate'])];
                    case 1:
                        result = _a.sent();
                        return [2 /*return*/, result.stdout !== '' ? result.stdout.trim().split('\n').map(function (tag) { return ({ name: tag }); }) : []];
                    case 2: return [2 /*return*/, []];
                }
            });
        });
    };
    GitQuickOpenService.prototype.getBranches = function (repository) {
        if (repository === void 0) { repository = this.getRepository(); }
        return __awaiter(this, void 0, void 0, function () {
            var _a, local, remote, error_10;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!repository) {
                            return [2 /*return*/, []];
                        }
                        _b.label = 1;
                    case 1:
                        _b.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, Promise.all([
                                this.git.branch(repository, { type: 'local' }),
                                this.git.branch(repository, { type: 'remote' })
                            ])];
                    case 2:
                        _a = __read.apply(void 0, [_b.sent(), 2]), local = _a[0], remote = _a[1];
                        return [2 /*return*/, __spread(local, remote)];
                    case 3:
                        error_10 = _b.sent();
                        this.gitErrorHandler.handleError(error_10);
                        return [2 /*return*/, []];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    GitQuickOpenService.prototype.getCurrentBranch = function (repository) {
        if (repository === void 0) { repository = this.getRepository(); }
        return __awaiter(this, void 0, void 0, function () {
            var error_11;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!repository) {
                            return [2 /*return*/, undefined];
                        }
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, this.git.branch(repository, { type: 'current' })];
                    case 2: return [2 /*return*/, _a.sent()];
                    case 3:
                        error_11 = _a.sent();
                        this.gitErrorHandler.handleError(error_11);
                        return [2 /*return*/, undefined];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(git_error_handler_1.GitErrorHandler),
        __metadata("design:type", git_error_handler_1.GitErrorHandler)
    ], GitQuickOpenService.prototype, "gitErrorHandler", void 0);
    GitQuickOpenService = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.Git)),
        __param(1, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __param(2, inversify_1.inject(quick_open_service_1.QuickOpenService)),
        __param(3, inversify_1.inject(message_service_1.MessageService)),
        __param(4, inversify_1.inject(workspace_service_1.WorkspaceService)),
        __param(5, inversify_1.inject(common_2.FileSystem)),
        __metadata("design:paramtypes", [Object, git_repository_provider_1.GitRepositoryProvider,
            quick_open_service_1.QuickOpenService,
            message_service_1.MessageService,
            workspace_service_1.WorkspaceService, Object])
    ], GitQuickOpenService);
    return GitQuickOpenService;
}());
exports.GitQuickOpenService = GitQuickOpenService;
/**
 * Git specific quick open item that wraps a branch a remote name or something else.
 */
var GitQuickOpenItem = /** @class */ (function (_super) {
    __extends(GitQuickOpenItem, _super);
    function GitQuickOpenItem(ref, execute, toLabel, toDescription) {
        if (toLabel === void 0) { toLabel = function (item) { return "" + ref; }; }
        if (toDescription === void 0) { toDescription = function (item) { return undefined; }; }
        var _this = _super.call(this) || this;
        _this.ref = ref;
        _this.execute = execute;
        _this.toLabel = toLabel;
        _this.toDescription = toDescription;
        return _this;
    }
    GitQuickOpenItem.prototype.run = function (mode) {
        if (mode !== quick_open_model_1.QuickOpenMode.OPEN) {
            return false;
        }
        this.execute(this);
        return true;
    };
    GitQuickOpenItem.prototype.getLabel = function () {
        return this.toLabel(this);
    };
    GitQuickOpenItem.prototype.getDescription = function () {
        return this.toDescription(this);
    };
    return GitQuickOpenItem;
}(quick_open_model_1.QuickOpenItem));
var SingleStringInputOpenItem = /** @class */ (function (_super) {
    __extends(SingleStringInputOpenItem, _super);
    function SingleStringInputOpenItem(label, execute, canRun, canClose) {
        if (execute === void 0) { execute = function () { }; }
        if (canRun === void 0) { canRun = function (mode) { return mode === quick_open_model_1.QuickOpenMode.OPEN; }; }
        if (canClose === void 0) { canClose = function (mode) { return true; }; }
        var _this = _super.call(this) || this;
        _this.label = label;
        _this.execute = execute;
        _this.canRun = canRun;
        _this.canClose = canClose;
        return _this;
    }
    SingleStringInputOpenItem.prototype.getLabel = function () {
        return this.label;
    };
    SingleStringInputOpenItem.prototype.run = function (mode) {
        if (!this.canRun(mode)) {
            return false;
        }
        this.execute(this);
        return this.canClose(mode);
    };
    return SingleStringInputOpenItem;
}(quick_open_model_1.QuickOpenItem));


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-repository-provider.js":
/*!*************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-repository-provider.js ***!
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
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var workspace_service_1 = __webpack_require__(/*! @theia/workspace/lib/browser/workspace-service */ "../node_modules/@theia/workspace/lib/browser/workspace-service.js");
var common_2 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var GitRepositoryProvider = /** @class */ (function () {
    function GitRepositoryProvider(git, workspaceService, fileSystem, storageService) {
        this.git = git;
        this.workspaceService = workspaceService;
        this.fileSystem = fileSystem;
        this.storageService = storageService;
        this.onDidChangeRepositoryEmitter = new core_1.Emitter();
        this.selectedRepoStorageKey = 'theia-git-selected-repository';
        this.allRepoStorageKey = 'theia-git-all-repositories';
        this.initialize();
    }
    GitRepositoryProvider.prototype.initialize = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _a, _b;
            var _this = this;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0:
                        this.workspaceService.onWorkspaceChanged(function (event) {
                            _this.refresh();
                        });
                        _a = this;
                        return [4 /*yield*/, this.storageService.getData(this.selectedRepoStorageKey)];
                    case 1:
                        _a._selectedRepository = _c.sent();
                        _b = this;
                        return [4 /*yield*/, this.storageService.getData(this.allRepoStorageKey)];
                    case 2:
                        _b._allRepositories = _c.sent();
                        if (!!this._allRepositories) return [3 /*break*/, 4];
                        return [4 /*yield*/, this.refresh({ maxCount: 1 })];
                    case 3:
                        _c.sent();
                        _c.label = 4;
                    case 4: return [4 /*yield*/, this.refresh()];
                    case 5:
                        _c.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    Object.defineProperty(GitRepositoryProvider.prototype, "selectedRepository", {
        /**
         * Returns with the previously selected repository, or if no repository has been selected yet,
         * it picks the first available repository from the backend and sets it as the selected one and returns with that.
         * If no repositories are available, returns `undefined`.
         */
        get: function () {
            return this._selectedRepository;
        },
        /**
         * Sets or un-sets the repository.
         */
        set: function (repository) {
            this._selectedRepository = repository;
            this.storageService.setData(this.selectedRepoStorageKey, repository);
            this.fireDidChangeRepository();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitRepositoryProvider.prototype, "onDidChangeRepository", {
        get: function () {
            return this.onDidChangeRepositoryEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    GitRepositoryProvider.prototype.fireDidChangeRepository = function () {
        this.onDidChangeRepositoryEmitter.fire(this._selectedRepository);
    };
    Object.defineProperty(GitRepositoryProvider.prototype, "allRepositories", {
        /**
         * Returns with all know repositories.
         */
        get: function () {
            return this._allRepositories || [];
        },
        enumerable: true,
        configurable: true
    });
    GitRepositoryProvider.prototype.findRepository = function (uri) {
        var reposSorted = this._allRepositories ? this._allRepositories.sort(common_1.Repository.sortComparator) : [];
        return reposSorted.find(function (repo) { return new uri_1.default(repo.localUri).isEqualOrParent(uri); });
    };
    GitRepositoryProvider.prototype.findRepositoryOrSelected = function (arg) {
        var uri;
        if (arg) {
            if (arg instanceof uri_1.default || typeof arg === 'string') {
                uri = arg;
            }
            else if (typeof arg === 'object' && 'uri' in arg && arg.uri) {
                uri = arg.uri;
            }
            if (uri) {
                if (typeof uri === 'string') {
                    uri = new uri_1.default(uri);
                }
                return this.findRepository(uri);
            }
        }
        return this.selectedRepository;
    };
    GitRepositoryProvider.prototype.refresh = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, roots, _b, _c, root, e_1_1, repoUris, reposOfRoots, selectedRepository;
            var _this = this;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        roots = [];
                        _d.label = 1;
                    case 1:
                        _d.trys.push([1, 7, 8, 9]);
                        return [4 /*yield*/, this.workspaceService.roots];
                    case 2:
                        _b = __values.apply(void 0, [_d.sent()]), _c = _b.next();
                        _d.label = 3;
                    case 3:
                        if (!!_c.done) return [3 /*break*/, 6];
                        root = _c.value;
                        return [4 /*yield*/, this.fileSystem.exists(root.uri)];
                    case 4:
                        if (_d.sent()) {
                            roots.push(root);
                        }
                        _d.label = 5;
                    case 5:
                        _c = _b.next();
                        return [3 /*break*/, 3];
                    case 6: return [3 /*break*/, 9];
                    case 7:
                        e_1_1 = _d.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 9];
                    case 8:
                        try {
                            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 9:
                        repoUris = new Map();
                        return [4 /*yield*/, Promise.all(roots.map(function (r) { return _this.git.repositories(r.uri, __assign({}, options)); }))];
                    case 10:
                        reposOfRoots = _d.sent();
                        reposOfRoots.forEach(function (reposPerRoot) {
                            reposPerRoot.forEach(function (repoOfOneRoot) {
                                repoUris.set(repoOfOneRoot.localUri, repoOfOneRoot);
                            });
                        });
                        this._allRepositories = Array.from(repoUris.values());
                        this.storageService.setData(this.allRepoStorageKey, this._allRepositories);
                        selectedRepository = this._selectedRepository;
                        if (!selectedRepository || !this.exists(selectedRepository)) {
                            this.selectedRepository = this._allRepositories[0];
                        }
                        else {
                            this.fireDidChangeRepository();
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    GitRepositoryProvider.prototype.exists = function (repository) {
        return !!this._allRepositories && this._allRepositories.some(function (repository2) { return common_1.Repository.equal(repository, repository2); });
    };
    GitRepositoryProvider = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.Git)),
        __param(1, inversify_1.inject(workspace_service_1.WorkspaceService)),
        __param(2, inversify_1.inject(common_2.FileSystem)),
        __param(3, inversify_1.inject(browser_1.LocalStorageService)),
        __metadata("design:paramtypes", [Object, workspace_service_1.WorkspaceService, Object, browser_1.LocalStorageService])
    ], GitRepositoryProvider);
    return GitRepositoryProvider;
}());
exports.GitRepositoryProvider = GitRepositoryProvider;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-repository-tracker.js ***!
  \************************************************************************/
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
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var git_watcher_1 = __webpack_require__(/*! ../common/git-watcher */ "../node_modules/@theia/git/lib/common/git-watcher.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
/**
 * The repository tracker watches the selected repository for status changes. It provides a convenient way to listen on status updates.
 */
var GitRepositoryTracker = /** @class */ (function () {
    function GitRepositoryTracker(git, repositoryProvider, gitWatcher) {
        this.git = git;
        this.repositoryProvider = repositoryProvider;
        this.gitWatcher = gitWatcher;
        this.toDispose = new core_1.DisposableCollection();
        this.onGitEventEmitter = new core_1.Emitter();
    }
    GitRepositoryTracker.prototype.init = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _a;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        this.repositoryProvider.onDidChangeRepository(function (repository) { return __awaiter(_this, void 0, void 0, function () {
                            var _a, _b, _c;
                            var _this = this;
                            return __generator(this, function (_d) {
                                switch (_d.label) {
                                    case 0:
                                        this.workingDirectoryStatus = undefined;
                                        this.toDispose.dispose();
                                        if (!repository) return [3 /*break*/, 3];
                                        _b = (_a = this.toDispose).push;
                                        return [4 /*yield*/, this.gitWatcher.watchGitChanges(repository)];
                                    case 1:
                                        _b.apply(_a, [_d.sent()]);
                                        this.toDispose.push(this.gitWatcher.onGitEvent(function (event) {
                                            _this.workingDirectoryStatus = event.status;
                                            _this.onGitEventEmitter.fire(event);
                                        }));
                                        _c = this;
                                        return [4 /*yield*/, this.git.status(repository)];
                                    case 2:
                                        _c.workingDirectoryStatus = _d.sent();
                                        _d.label = 3;
                                    case 3: return [2 /*return*/];
                                }
                            });
                        }); });
                        if (!(this.repositoryProvider.allRepositories.length === 0)) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.repositoryProvider.refresh()];
                    case 1:
                        _b.sent();
                        _b.label = 2;
                    case 2:
                        if (!this.selectedRepository) return [3 /*break*/, 4];
                        _a = this;
                        return [4 /*yield*/, this.git.status(this.selectedRepository)];
                    case 3:
                        _a.workingDirectoryStatus = _b.sent();
                        _b.label = 4;
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    Object.defineProperty(GitRepositoryTracker.prototype, "selectedRepository", {
        /**
         * Returns the selected repository, or `undefined` if no repositories are available.
         */
        get: function () {
            return this.repositoryProvider.selectedRepository;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitRepositoryTracker.prototype, "allRepositories", {
        /**
         * Returns all known repositories.
         */
        get: function () {
            return this.repositoryProvider.allRepositories;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitRepositoryTracker.prototype, "selectedRepositoryStatus", {
        /**
         * Returns the last known status of the selected respository, or `undefined` if no repositories are available.
         */
        get: function () {
            return this.workingDirectoryStatus;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitRepositoryTracker.prototype, "onDidChangeRepository", {
        /**
         * Emits when the selected repository has changed.
         */
        get: function () {
            return this.repositoryProvider.onDidChangeRepository;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(GitRepositoryTracker.prototype, "onGitEvent", {
        /**
         * Emits when status has changed in the selected repository.
         */
        get: function () {
            return this.onGitEventEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    GitRepositoryTracker.prototype.getPath = function (uri) {
        var repositoryUri = this.repositoryUri;
        var relativePath = repositoryUri && repositoryUri.relative(uri);
        return relativePath && relativePath.toString();
    };
    GitRepositoryTracker.prototype.getUri = function (path) {
        var repositoryUri = this.repositoryUri;
        return repositoryUri && repositoryUri.resolve(path);
    };
    Object.defineProperty(GitRepositoryTracker.prototype, "repositoryUri", {
        get: function () {
            var repository = this.selectedRepository;
            return repository && new uri_1.default(repository.localUri);
        },
        enumerable: true,
        configurable: true
    });
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", Promise)
    ], GitRepositoryTracker.prototype, "init", null);
    GitRepositoryTracker = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.Git)),
        __param(1, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __param(2, inversify_1.inject(git_watcher_1.GitWatcher)),
        __metadata("design:paramtypes", [Object, git_repository_provider_1.GitRepositoryProvider,
            git_watcher_1.GitWatcher])
    ], GitRepositoryTracker);
    return GitRepositoryTracker;
}());
exports.GitRepositoryTracker = GitRepositoryTracker;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-resource.js":
/*!**************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-resource.js ***!
  \**************************************************************/
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
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
exports.GIT_RESOURCE_SCHEME = 'gitrev';
var GitResource = /** @class */ (function () {
    function GitResource(uri, repository, git) {
        this.uri = uri;
        this.repository = repository;
        this.git = git;
    }
    GitResource.prototype.readContents = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var commitish;
            return __generator(this, function (_a) {
                if (this.repository) {
                    commitish = this.uri.query;
                    return [2 /*return*/, this.git.show(this.repository, this.uri.toString(), Object.assign({ commitish: commitish }, options))];
                }
                return [2 /*return*/, ''];
            });
        });
    };
    GitResource.prototype.dispose = function () { };
    return GitResource;
}());
exports.GitResource = GitResource;
var GitResourceResolver = /** @class */ (function () {
    function GitResourceResolver(git, repositoryProvider) {
        this.git = git;
        this.repositoryProvider = repositoryProvider;
    }
    GitResourceResolver.prototype.resolve = function (uri) {
        if (uri.scheme !== exports.GIT_RESOURCE_SCHEME) {
            throw new Error("Expected a URI with " + exports.GIT_RESOURCE_SCHEME + " scheme. Was: " + uri + ".");
        }
        return this.getResource(uri);
    };
    GitResourceResolver.prototype.getResource = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var repository;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.getRepository(uri)];
                    case 1:
                        repository = _a.sent();
                        return [2 /*return*/, new GitResource(uri, repository, this.git)];
                }
            });
        });
    };
    GitResourceResolver.prototype.getRepository = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, uriWithoutScheme, repositories, sortedRepositories, sortedRepositories_1, sortedRepositories_1_1, repository, localUri, localUriStr;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        uriWithoutScheme = uri.withoutScheme();
                        repositories = this.repositoryProvider.allRepositories;
                        if (!(repositories.length === 0)) return [3 /*break*/, 2];
                        // So let's make sure, the repository provider state is in sync with the backend.
                        return [4 /*yield*/, this.repositoryProvider.refresh()];
                    case 1:
                        // So let's make sure, the repository provider state is in sync with the backend.
                        _b.sent();
                        repositories.push.apply(repositories, __spread(this.repositoryProvider.allRepositories));
                        _b.label = 2;
                    case 2:
                        sortedRepositories = repositories.sort(function (a, b) { return b.localUri.length - a.localUri.length; });
                        try {
                            for (sortedRepositories_1 = __values(sortedRepositories), sortedRepositories_1_1 = sortedRepositories_1.next(); !sortedRepositories_1_1.done; sortedRepositories_1_1 = sortedRepositories_1.next()) {
                                repository = sortedRepositories_1_1.value;
                                localUri = new uri_1.default(repository.localUri);
                                localUriStr = localUri.withoutScheme().toString();
                                if (uriWithoutScheme.toString().startsWith(localUriStr)) {
                                    return [2 /*return*/, { localUri: localUriStr }];
                                }
                            }
                        }
                        catch (e_1_1) { e_1 = { error: e_1_1 }; }
                        finally {
                            try {
                                if (sortedRepositories_1_1 && !sortedRepositories_1_1.done && (_a = sortedRepositories_1.return)) _a.call(sortedRepositories_1);
                            }
                            finally { if (e_1) throw e_1.error; }
                        }
                        return [2 /*return*/, undefined];
                }
            });
        });
    };
    GitResourceResolver = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.Git)),
        __param(1, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __metadata("design:paramtypes", [Object, git_repository_provider_1.GitRepositoryProvider])
    ], GitResourceResolver);
    return GitResourceResolver;
}());
exports.GitResourceResolver = GitResourceResolver;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-sync-service.js":
/*!******************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-sync-service.js ***!
  \******************************************************************/
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var git_repository_tracker_1 = __webpack_require__(/*! ./git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_error_handler_1 = __webpack_require__(/*! ./git-error-handler */ "../node_modules/@theia/git/lib/browser/git-error-handler.js");
var GitSyncService = /** @class */ (function () {
    function GitSyncService() {
        this.onDidChangeEmitter = new core_1.Emitter();
        this.onDidChange = this.onDidChangeEmitter.event;
        this.syncing = false;
    }
    GitSyncService.prototype.fireDidChange = function () {
        this.onDidChangeEmitter.fire(undefined);
    };
    GitSyncService.prototype.isSyncing = function () {
        return this.syncing;
    };
    GitSyncService.prototype.setSyncing = function (syncing) {
        this.syncing = syncing;
        this.fireDidChange();
    };
    GitSyncService.prototype.canSync = function () {
        if (this.isSyncing()) {
            return false;
        }
        var status = this.repositoryTracker.selectedRepositoryStatus;
        return !!status && !!status.branch && !!status.upstreamBranch;
    };
    GitSyncService.prototype.sync = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, status_1, method, error_1;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        repository = this.repositoryTracker.selectedRepository;
                        if (!this.canSync() || !repository) {
                            return [2 /*return*/];
                        }
                        this.setSyncing(true);
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 10, 11, 12]);
                        return [4 /*yield*/, this.git.fetch(repository)];
                    case 2:
                        _a.sent();
                        return [4 /*yield*/, this.git.status(repository)];
                    case 3:
                        status_1 = _a.sent();
                        this.setSyncing(false);
                        return [4 /*yield*/, this.getSyncMethod(status_1)];
                    case 4:
                        method = _a.sent();
                        if (method === undefined) {
                            return [2 /*return*/];
                        }
                        this.setSyncing(true);
                        if (!(method === 'pull-push' || method === 'rebase-push')) return [3 /*break*/, 7];
                        return [4 /*yield*/, this.git.pull(repository, {
                                rebase: method === 'rebase-push'
                            })];
                    case 5:
                        _a.sent();
                        return [4 /*yield*/, this.git.status(repository)];
                    case 6:
                        status_1 = _a.sent();
                        _a.label = 7;
                    case 7:
                        if (!this.shouldPush(status_1)) return [3 /*break*/, 9];
                        return [4 /*yield*/, this.git.push(repository, {
                                force: method === 'force-push'
                            })];
                    case 8:
                        _a.sent();
                        _a.label = 9;
                    case 9: return [3 /*break*/, 12];
                    case 10:
                        error_1 = _a.sent();
                        this.gitErrorHandler.handleError(error_1);
                        return [3 /*break*/, 12];
                    case 11:
                        this.setSyncing(false);
                        return [7 /*endfinally*/];
                    case 12: return [2 /*return*/];
                }
            });
        });
    };
    GitSyncService.prototype.getSyncMethod = function (status) {
        return __awaiter(this, void 0, void 0, function () {
            var branch, upstreamBranch, methods, method, _a;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!status.upstreamBranch || !status.branch) {
                            return [2 /*return*/, undefined];
                        }
                        branch = status.branch, upstreamBranch = status.upstreamBranch;
                        if (!this.shouldPull(status) && !this.shouldPush(status)) {
                            this.messageService.info(branch + " is already in sync with " + upstreamBranch);
                            return [2 /*return*/, undefined];
                        }
                        methods = [{
                                label: "Pull and push commits from and to '" + upstreamBranch + "'",
                                warning: "This action will pull and push commits from and to '" + upstreamBranch + "'.",
                                value: 'pull-push'
                            }, {
                                label: "Fetch, rebase and push commits from and to '" + upstreamBranch + "'",
                                warning: "This action will fetch, rebase and push commits from and to '" + upstreamBranch + "'.",
                                value: 'rebase-push'
                            }, {
                                label: "Force push commits to '" + upstreamBranch + "'",
                                warning: "This action will override commits in '" + upstreamBranch + "'.",
                                value: 'force-push'
                            }];
                        return [4 /*yield*/, this.quickPickService.show(methods, {
                                placeholder: 'Pick how changes should be synchronized:'
                            })];
                    case 1:
                        method = _b.sent();
                        _a = method;
                        if (!_a) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.confirm('Synchronize Changes', methods.find(function (_a) {
                                var value = _a.value;
                                return value === method;
                            }).warning)];
                    case 2:
                        _a = (_b.sent());
                        _b.label = 3;
                    case 3:
                        if (_a) {
                            return [2 /*return*/, method];
                        }
                        return [2 /*return*/, undefined];
                }
            });
        });
    };
    GitSyncService.prototype.canPublish = function () {
        if (this.isSyncing()) {
            return false;
        }
        var status = this.repositoryTracker.selectedRepositoryStatus;
        return !!status && !!status.branch && !status.upstreamBranch;
    };
    GitSyncService.prototype.publish = function () {
        return __awaiter(this, void 0, void 0, function () {
            var repository, status, localBranch, remote, _a, error_2;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        repository = this.repositoryTracker.selectedRepository;
                        status = this.repositoryTracker.selectedRepositoryStatus;
                        localBranch = status && status.branch;
                        if (!this.canPublish() || !repository || !localBranch) {
                            return [2 /*return*/];
                        }
                        return [4 /*yield*/, this.getRemote(repository, localBranch)];
                    case 1:
                        remote = _b.sent();
                        _a = remote;
                        if (!_a) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.confirm('Publish changes', "This action will push commits to '" + remote + "/" + localBranch + "' and track it as an upstream branch.")];
                    case 2:
                        _a = (_b.sent());
                        _b.label = 3;
                    case 3:
                        if (!_a) return [3 /*break*/, 7];
                        _b.label = 4;
                    case 4:
                        _b.trys.push([4, 6, , 7]);
                        return [4 /*yield*/, this.git.push(repository, {
                                remote: remote, localBranch: localBranch, setUpstream: true
                            })];
                    case 5:
                        _b.sent();
                        return [3 /*break*/, 7];
                    case 6:
                        error_2 = _b.sent();
                        this.gitErrorHandler.handleError(error_2);
                        return [3 /*break*/, 7];
                    case 7: return [2 /*return*/];
                }
            });
        });
    };
    GitSyncService.prototype.getRemote = function (repository, branch) {
        return __awaiter(this, void 0, void 0, function () {
            var remotes;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.git.remote(repository)];
                    case 1:
                        remotes = _a.sent();
                        if (remotes.length === 0) {
                            this.messageService.warn('Your repository has no remotes configured to publish to.');
                        }
                        return [2 /*return*/, this.quickPickService.show(remotes, {
                                placeholder: "Pick a remote to publish the branch " + branch + " to:"
                            })];
                }
            });
        });
    };
    GitSyncService.prototype.shouldPush = function (status) {
        return status.aheadBehind ? status.aheadBehind.ahead > 0 : true;
    };
    GitSyncService.prototype.shouldPull = function (status) {
        return status.aheadBehind ? status.aheadBehind.behind > 0 : true;
    };
    GitSyncService.prototype.confirm = function (title, msg) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, new browser_1.ConfirmDialog({ title: title, msg: msg, }).open()];
                    case 1: return [2 /*return*/, !!(_a.sent())];
                }
            });
        });
    };
    __decorate([
        inversify_1.inject(common_1.Git),
        __metadata("design:type", Object)
    ], GitSyncService.prototype, "git", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], GitSyncService.prototype, "repositoryTracker", void 0);
    __decorate([
        inversify_1.inject(core_1.MessageService),
        __metadata("design:type", core_1.MessageService)
    ], GitSyncService.prototype, "messageService", void 0);
    __decorate([
        inversify_1.inject(git_error_handler_1.GitErrorHandler),
        __metadata("design:type", git_error_handler_1.GitErrorHandler)
    ], GitSyncService.prototype, "gitErrorHandler", void 0);
    __decorate([
        inversify_1.inject(browser_1.QuickPickService),
        __metadata("design:type", browser_1.QuickPickService)
    ], GitSyncService.prototype, "quickPickService", void 0);
    GitSyncService = __decorate([
        inversify_1.injectable()
    ], GitSyncService);
    return GitSyncService;
}());
exports.GitSyncService = GitSyncService;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-uri-label-contribution.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-uri-label-contribution.js ***!
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
var label_provider_1 = __webpack_require__(/*! @theia/core/lib/browser/label-provider */ "../node_modules/@theia/core/lib/browser/label-provider.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var git_resource_1 = __webpack_require__(/*! ./git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var GitUriLabelProviderContribution = /** @class */ (function () {
    function GitUriLabelProviderContribution(labelProvider) {
        this.labelProvider = labelProvider;
    }
    GitUriLabelProviderContribution.prototype.canHandle = function (element) {
        if (element instanceof uri_1.default && element.scheme === git_resource_1.GIT_RESOURCE_SCHEME) {
            return 20;
        }
        return 0;
    };
    GitUriLabelProviderContribution.prototype.getLongName = function (uri) {
        return this.labelProvider.getLongName(this.toFileUri(uri).withoutQuery().withoutFragment());
    };
    GitUriLabelProviderContribution.prototype.getName = function (uri) {
        return this.labelProvider.getName(this.toFileUri(uri)) + this.getTagSuffix(uri);
    };
    GitUriLabelProviderContribution.prototype.getIcon = function (uri) {
        return this.labelProvider.getIcon(this.toFileUri(uri));
    };
    GitUriLabelProviderContribution.prototype.toFileUri = function (uri) {
        return uri.withScheme('file');
    };
    GitUriLabelProviderContribution.prototype.getTagSuffix = function (uri) {
        if (uri.query) {
            return " (" + uri.query + ")";
        }
        else {
            return '';
        }
    };
    GitUriLabelProviderContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(label_provider_1.LabelProvider)),
        __metadata("design:paramtypes", [label_provider_1.LabelProvider])
    ], GitUriLabelProviderContribution);
    return GitUriLabelProviderContribution;
}());
exports.GitUriLabelProviderContribution = GitUriLabelProviderContribution;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-view-contribution.js":
/*!***********************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-view-contribution.js ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

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
Object.defineProperty(exports, "__esModule", { value: true });
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_widget_1 = __webpack_require__(/*! ./git-widget */ "../node_modules/@theia/git/lib/browser/git-widget.js");
var git_repository_tracker_1 = __webpack_require__(/*! ./git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var git_quick_open_service_1 = __webpack_require__(/*! ./git-quick-open-service */ "../node_modules/@theia/git/lib/browser/git-quick-open-service.js");
var git_sync_service_1 = __webpack_require__(/*! ./git-sync-service */ "../node_modules/@theia/git/lib/browser/git-sync-service.js");
exports.GIT_WIDGET_FACTORY_ID = 'git';
exports.EDITOR_CONTEXT_MENU_GIT = __spread(browser_2.EDITOR_CONTEXT_MENU, ['3_git']);
var GIT_COMMANDS;
(function (GIT_COMMANDS) {
    GIT_COMMANDS.CLONE = {
        id: 'git.clone',
        label: 'Git: Clone...'
    };
    GIT_COMMANDS.FETCH = {
        id: 'git.fetch',
        label: 'Git: Fetch...'
    };
    GIT_COMMANDS.PULL = {
        id: 'git.pull',
        label: 'Git: Pull...'
    };
    GIT_COMMANDS.PUSH = {
        id: 'git.push',
        label: 'Git: Push...'
    };
    GIT_COMMANDS.MERGE = {
        id: 'git.merge',
        label: 'Git: Merge...'
    };
    GIT_COMMANDS.CHECKOUT = {
        id: 'git.checkout',
        label: 'Git: Checkout'
    };
    GIT_COMMANDS.COMMIT_AMEND = {
        id: 'git.commit.amend'
    };
    GIT_COMMANDS.COMMIT_SIGN_OFF = {
        id: 'git.commit.signOff'
    };
    GIT_COMMANDS.CHANGE_REPOSITORY = {
        id: 'git.change.repository',
        label: 'Git: Change Repository...'
    };
    GIT_COMMANDS.OPEN_FILE = {
        id: 'git.open.file',
        label: 'Git: Open File'
    };
    GIT_COMMANDS.OPEN_CHANGES = {
        id: 'git.open.changes',
        label: 'Git: Open Changes'
    };
    GIT_COMMANDS.SYNC = {
        id: 'git.sync',
        label: 'Git: Sync'
    };
    GIT_COMMANDS.PUBLISH = {
        id: 'git.publish',
        label: 'Git: Publish Branch'
    };
})(GIT_COMMANDS = exports.GIT_COMMANDS || (exports.GIT_COMMANDS = {}));
var GitViewContribution = /** @class */ (function (_super) {
    __extends(GitViewContribution, _super);
    function GitViewContribution() {
        var _this = _super.call(this, {
            widgetId: exports.GIT_WIDGET_FACTORY_ID,
            widgetName: 'Git',
            defaultWidgetOptions: {
                area: 'left',
                rank: 200
            },
            toggleCommandId: 'gitView:toggle',
            toggleKeybinding: 'ctrlcmd+shift+g'
        }) || this;
        _this.toDispose = new core_1.DisposableCollection();
        return _this;
    }
    GitViewContribution_1 = GitViewContribution;
    GitViewContribution.prototype.initializeLayout = function (app) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.openView()];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    GitViewContribution.prototype.onStart = function () {
        var _this = this;
        this.repositoryTracker.onDidChangeRepository(function (repository) {
            if (repository) {
                if (_this.hasMultipleRepositories()) {
                    var path = new uri_1.default(repository.localUri).path;
                    _this.statusBar.setElement(GitViewContribution_1.GIT_SELECTED_REPOSITORY, {
                        text: "$(database) " + path.base,
                        alignment: browser_1.StatusBarAlignment.LEFT,
                        priority: 102,
                        command: GIT_COMMANDS.CHANGE_REPOSITORY.id,
                        tooltip: path.toString()
                    });
                }
                else {
                    _this.statusBar.removeElement(GitViewContribution_1.GIT_SELECTED_REPOSITORY);
                }
            }
            else {
                _this.statusBar.removeElement(GitViewContribution_1.GIT_SELECTED_REPOSITORY);
                _this.statusBar.removeElement(GitViewContribution_1.GIT_REPOSITORY_STATUS);
                _this.statusBar.removeElement(GitViewContribution_1.GIT_SYNC_STATUS);
            }
        });
        this.repositoryTracker.onGitEvent(function (event) {
            var status = event.status;
            var branch = status.branch ? status.branch : 'NO-HEAD';
            var dirty = '';
            if (status.changes.length > 0) {
                var conflicts = _this.hasConflicts(status.changes);
                var staged = _this.allStaged(status.changes);
                if (conflicts || staged) {
                    if (conflicts) {
                        dirty = '!';
                    }
                    else if (staged) {
                        dirty = '+';
                    }
                }
                else {
                    dirty = '*';
                }
            }
            _this.statusBar.setElement(GitViewContribution_1.GIT_REPOSITORY_STATUS, {
                text: "$(code-fork) " + branch + dirty,
                alignment: browser_1.StatusBarAlignment.LEFT,
                priority: 101,
                command: GIT_COMMANDS.CHECKOUT.id
            });
            _this.updateSyncStatusBarEntry();
        });
        this.syncService.onDidChange(function () { return _this.updateSyncStatusBarEntry(); });
    };
    GitViewContribution.prototype.registerMenus = function (menus) {
        _super.prototype.registerMenus.call(this, menus);
        [GIT_COMMANDS.FETCH, GIT_COMMANDS.PULL, GIT_COMMANDS.PUSH, GIT_COMMANDS.MERGE].forEach(function (command) {
            return menus.registerMenuAction(git_widget_1.GitWidget.ContextMenu.OTHER_GROUP, {
                commandId: command.id,
                label: command.label.slice('Git: '.length)
            });
        });
        menus.registerMenuAction(git_widget_1.GitWidget.ContextMenu.COMMIT_GROUP, {
            commandId: GIT_COMMANDS.COMMIT_AMEND.id,
            label: 'Commit (Amend)'
        });
        menus.registerMenuAction(git_widget_1.GitWidget.ContextMenu.COMMIT_GROUP, {
            commandId: GIT_COMMANDS.COMMIT_SIGN_OFF.id,
            label: 'Commit (Signed Off)'
        });
        menus.registerMenuAction(browser_2.EditorContextMenu.NAVIGATION, {
            commandId: GIT_COMMANDS.OPEN_FILE.id
        });
        menus.registerMenuAction(browser_2.EditorContextMenu.NAVIGATION, {
            commandId: GIT_COMMANDS.OPEN_CHANGES.id
        });
    };
    GitViewContribution.prototype.registerCommands = function (registry) {
        var _this = this;
        _super.prototype.registerCommands.call(this, registry);
        registry.registerCommand(GIT_COMMANDS.FETCH, {
            execute: function () { return _this.quickOpenService.fetch(); },
            isEnabled: function () { return !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.PULL, {
            execute: function () { return _this.quickOpenService.pull(); },
            isEnabled: function () { return !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.PUSH, {
            execute: function () { return _this.quickOpenService.push(); },
            isEnabled: function () { return !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.MERGE, {
            execute: function () { return _this.quickOpenService.merge(); },
            isEnabled: function () { return !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.CHECKOUT, {
            execute: function () { return _this.quickOpenService.checkout(); },
            isEnabled: function () { return !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.COMMIT_SIGN_OFF, {
            execute: function () { return _this.tryGetWidget().doCommit(_this.repositoryTracker.selectedRepository, 'sign-off'); },
            isEnabled: function () { return !!_this.tryGetWidget() && !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.COMMIT_AMEND, {
            execute: function () { return __awaiter(_this, void 0, void 0, function () {
                var widget, selectedRepository, message, e_1;
                return __generator(this, function (_a) {
                    switch (_a.label) {
                        case 0:
                            widget = this.tryGetWidget();
                            selectedRepository = this.repositoryTracker.selectedRepository;
                            if (!(!!widget && !!selectedRepository)) return [3 /*break*/, 4];
                            _a.label = 1;
                        case 1:
                            _a.trys.push([1, 3, , 4]);
                            return [4 /*yield*/, this.quickOpenService.commitMessageForAmend()];
                        case 2:
                            message = _a.sent();
                            widget.doCommit(selectedRepository, 'amend', message);
                            return [3 /*break*/, 4];
                        case 3:
                            e_1 = _a.sent();
                            if (!(e_1 instanceof Error) || e_1.message !== 'User abort.') {
                                throw e_1;
                            }
                            return [3 /*break*/, 4];
                        case 4: return [2 /*return*/];
                    }
                });
            }); },
            isEnabled: function () { return !!_this.tryGetWidget() && !!_this.repositoryTracker.selectedRepository; }
        });
        registry.registerCommand(GIT_COMMANDS.CHANGE_REPOSITORY, {
            execute: function () { return _this.quickOpenService.changeRepository(); },
            isEnabled: function () { return _this.hasMultipleRepositories(); }
        });
        registry.registerCommand(GIT_COMMANDS.OPEN_FILE, {
            execute: function () { return _this.openFile(); },
            isEnabled: function () { return !!_this.openFileOptions; },
            isVisible: function () { return !!_this.openFileOptions; }
        });
        registry.registerCommand(GIT_COMMANDS.OPEN_CHANGES, {
            execute: function () { return _this.openChanges(); },
            isEnabled: function () { return !!_this.openChangesOptions; },
            isVisible: function () { return !!_this.openChangesOptions; }
        });
        registry.registerCommand(GIT_COMMANDS.SYNC, {
            execute: function () { return _this.syncService.sync(); },
            isEnabled: function () { return _this.syncService.canSync(); },
            isVisible: function () { return _this.syncService.canSync(); }
        });
        registry.registerCommand(GIT_COMMANDS.PUBLISH, {
            execute: function () { return _this.syncService.publish(); },
            isEnabled: function () { return _this.syncService.canPublish(); },
            isVisible: function () { return _this.syncService.canPublish(); }
        });
        registry.registerCommand(GIT_COMMANDS.CLONE, {
            execute: function (args) {
                var _a;
                var url = undefined;
                var folder = undefined;
                var branch = undefined;
                if (args) {
                    _a = __read(args, 3), url = _a[0], folder = _a[1], branch = _a[2];
                }
                return _this.quickOpenService.clone(url, folder, branch);
            }
        });
    };
    GitViewContribution.prototype.hasConflicts = function (changes) {
        return changes.some(function (c) { return c.status === common_1.GitFileStatus.Conflicted; });
    };
    GitViewContribution.prototype.allStaged = function (changes) {
        return !changes.some(function (c) { return !c.staged; });
    };
    GitViewContribution.prototype.openFile = function () {
        return __awaiter(this, void 0, void 0, function () {
            var options;
            return __generator(this, function (_a) {
                options = this.openFileOptions;
                return [2 /*return*/, options && this.editorManager.open(options.uri, options.options)];
            });
        });
    };
    Object.defineProperty(GitViewContribution.prototype, "openFileOptions", {
        get: function () {
            var widget = this.editorManager.currentEditor;
            if (widget && browser_1.DiffUris.isDiffUri(widget.editor.uri)) {
                var _a = __read(browser_1.DiffUris.decode(widget.editor.uri), 2), right = _a[1];
                var uri = right.withScheme('file');
                var selection = widget.editor.selection;
                return { uri: uri, options: { selection: selection } };
            }
            return undefined;
        },
        enumerable: true,
        configurable: true
    });
    GitViewContribution.prototype.openChanges = function () {
        return __awaiter(this, void 0, void 0, function () {
            var options, view;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        options = this.openChangesOptions;
                        if (!options) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.widget];
                    case 1:
                        view = _a.sent();
                        return [2 /*return*/, view.openChange(options.change, options.options)];
                    case 2: return [2 /*return*/, undefined];
                }
            });
        });
    };
    Object.defineProperty(GitViewContribution.prototype, "openChangesOptions", {
        get: function () {
            var view = this.tryGetWidget();
            if (!view) {
                return undefined;
            }
            var widget = this.editorManager.currentEditor;
            if (widget && !browser_1.DiffUris.isDiffUri(widget.editor.uri)) {
                var uri = widget.editor.uri;
                var change = view.findChange(uri);
                if (change) {
                    var selection = widget.editor.selection;
                    return { change: change, options: { selection: selection } };
                }
            }
            return undefined;
        },
        enumerable: true,
        configurable: true
    });
    GitViewContribution.prototype.hasMultipleRepositories = function () {
        return this.repositoryTracker.allRepositories.length > 1;
    };
    GitViewContribution.prototype.updateSyncStatusBarEntry = function () {
        var entry = this.getStatusBarEntry();
        if (entry) {
            this.statusBar.setElement(GitViewContribution_1.GIT_SYNC_STATUS, __assign({ alignment: browser_1.StatusBarAlignment.LEFT, priority: 100 }, entry));
        }
        else {
            this.statusBar.removeElement(GitViewContribution_1.GIT_SYNC_STATUS);
        }
    };
    GitViewContribution.prototype.getStatusBarEntry = function () {
        var status = this.repositoryTracker.selectedRepositoryStatus;
        if (!status || !status.branch) {
            return undefined;
        }
        if (this.syncService.isSyncing()) {
            return {
                text: '$(refresh~spin)',
                tooltip: 'Synchronizing Changes...'
            };
        }
        var upstreamBranch = status.upstreamBranch, aheadBehind = status.aheadBehind;
        if (upstreamBranch) {
            return {
                text: '$(refresh)' + (aheadBehind ? " " + aheadBehind.behind + "\u2193 " + aheadBehind.ahead + "\u2191" : ''),
                command: GIT_COMMANDS.SYNC.id,
                tooltip: 'Synchronize Changes'
            };
        }
        return {
            text: '$(cloud-upload)',
            command: GIT_COMMANDS.PUBLISH.id,
            tooltip: 'Publish Changes'
        };
    };
    var GitViewContribution_1;
    GitViewContribution.GIT_SELECTED_REPOSITORY = 'git-selected-repository';
    GitViewContribution.GIT_REPOSITORY_STATUS = 'git-repository-status';
    GitViewContribution.GIT_SYNC_STATUS = 'git-sync-status';
    __decorate([
        inversify_1.inject(browser_1.StatusBar),
        __metadata("design:type", Object)
    ], GitViewContribution.prototype, "statusBar", void 0);
    __decorate([
        inversify_1.inject(browser_2.EditorManager),
        __metadata("design:type", browser_2.EditorManager)
    ], GitViewContribution.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(git_quick_open_service_1.GitQuickOpenService),
        __metadata("design:type", git_quick_open_service_1.GitQuickOpenService)
    ], GitViewContribution.prototype, "quickOpenService", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], GitViewContribution.prototype, "repositoryTracker", void 0);
    __decorate([
        inversify_1.inject(git_sync_service_1.GitSyncService),
        __metadata("design:type", git_sync_service_1.GitSyncService)
    ], GitViewContribution.prototype, "syncService", void 0);
    GitViewContribution = GitViewContribution_1 = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], GitViewContribution);
    return GitViewContribution;
}(browser_1.AbstractViewContribution));
exports.GitViewContribution = GitViewContribution;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/git-widget.js":
/*!************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/git-widget.js ***!
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var browser_2 = __webpack_require__(/*! @theia/editor/lib/browser */ "../node_modules/@theia/editor/lib/browser/index.js");
var browser_3 = __webpack_require__(/*! @theia/workspace/lib/browser */ "../node_modules/@theia/workspace/lib/browser/index.js");
var common_1 = __webpack_require__(/*! ../common */ "../node_modules/@theia/git/lib/common/index.js");
var git_watcher_1 = __webpack_require__(/*! ../common/git-watcher */ "../node_modules/@theia/git/lib/common/git-watcher.js");
var git_resource_1 = __webpack_require__(/*! ./git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var git_repository_provider_1 = __webpack_require__(/*! ./git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var git_commit_message_validator_1 = __webpack_require__(/*! ./git-commit-message-validator */ "../node_modules/@theia/git/lib/browser/git-commit-message-validator.js");
var git_avatar_service_1 = __webpack_require__(/*! ./history/git-avatar-service */ "../node_modules/@theia/git/lib/browser/history/git-avatar-service.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var git_error_handler_1 = __webpack_require__(/*! ./git-error-handler */ "../node_modules/@theia/git/lib/browser/git-error-handler.js");
var git_diff_widget_1 = __webpack_require__(/*! ./diff/git-diff-widget */ "../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js");
var GitFileChangeNode;
(function (GitFileChangeNode) {
    function is(node) {
        return !!node && 'uri' in node && 'status' in node && 'description' in node && 'label' in node && 'icon' in node;
    }
    GitFileChangeNode.is = is;
})(GitFileChangeNode = exports.GitFileChangeNode || (exports.GitFileChangeNode = {}));
var GitWidget = /** @class */ (function (_super) {
    __extends(GitWidget, _super);
    function GitWidget(git, gitWatcher, contextMenuRenderer, resourceProvider, commandService, repositoryProvider, labelProvider, avatarService, commitMessageValidator) {
        var _this = _super.call(this) || this;
        _this.git = git;
        _this.gitWatcher = gitWatcher;
        _this.contextMenuRenderer = contextMenuRenderer;
        _this.resourceProvider = resourceProvider;
        _this.commandService = commandService;
        _this.repositoryProvider = repositoryProvider;
        _this.labelProvider = labelProvider;
        _this.avatarService = avatarService;
        _this.commitMessageValidator = commitMessageValidator;
        _this.stagedChanges = [];
        _this.unstagedChanges = [];
        _this.mergeChanges = [];
        _this.message = '';
        _this.messageBoxHeight = GitWidget_1.MESSAGE_BOX_MIN_HEIGHT;
        _this.selectChange = function (change) { return _this.selectNode(change); };
        _this.addGitListKeyListeners = function (id) { return _this.doAddGitListKeyListeners(id); };
        _this.stageOrUnstage = function () { return _this.doStageOrUnstage(); };
        _this.handleBackspace = function () { return _this.doHandleBackspace(); };
        _this.openFile = function (uri) { return _this.doOpenFile(uri); };
        _this.handleListFocus = function (e) { return _this.doHandleListFocus(e); };
        _this.refresh = function () { return _this.doRefresh(); };
        _this.showMoreToolButtons = function (event) { return _this.doShowMoreToolButtons(event); };
        _this.signOff = function () { return _this.doSignOff(); };
        _this.commit = function (repository) { return _this.doCommit.bind(_this)(repository); };
        _this.unstage = function (repository, change) { return _this.doUnstage(repository, change); };
        _this.discard = function (repository, change) { return _this.doDiscard(repository, change); };
        _this.stage = function (repository, change) { return _this.doStage(repository, change); };
        _this.handleOpenChange = function (change, options) { return __awaiter(_this, void 0, void 0, function () { return __generator(this, function (_a) {
            return [2 /*return*/, this.openChange(change, options)];
        }); }); };
        _this.id = 'theia-gitContainer';
        _this.title.label = 'Git';
        _this.title.caption = 'Git';
        _this.title.iconClass = 'fa git-tab-icon';
        _this.scrollContainer = GitWidget_1.Styles.CHANGES_CONTAINER;
        _this.addClass('theia-git');
        _this.node.tabIndex = 0;
        return _this;
    }
    GitWidget_1 = GitWidget;
    GitWidget.prototype.init = function () {
        var _this = this;
        this.toDispose.push(this.repositoryProvider.onDidChangeRepository(function (repository) {
            return _this.initialize(repository);
        }));
        this.initialize(this.repositoryProvider.selectedRepository);
        this.gitNodes = [];
        this.update();
    };
    GitWidget.prototype.initialize = function (repository) {
        return __awaiter(this, void 0, void 0, function () {
            var _a, _b;
            var _this = this;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0:
                        if (!repository) return [3 /*break*/, 2];
                        this.toDispose.dispose();
                        _b = (_a = this.toDispose).push;
                        return [4 /*yield*/, this.gitWatcher.watchGitChanges(repository)];
                    case 1:
                        _b.apply(_a, [_c.sent()]);
                        this.toDispose.push(this.gitWatcher.onGitEvent(function (gitEvent) { return __awaiter(_this, void 0, void 0, function () {
                            var _a, _b;
                            return __generator(this, function (_c) {
                                switch (_c.label) {
                                    case 0:
                                        if (!git_watcher_1.GitStatusChangeEvent.is(gitEvent)) return [3 /*break*/, 5];
                                        if (!(gitEvent.status.currentHead !== this.lastHead)) return [3 /*break*/, 4];
                                        this.lastHead = gitEvent.status.currentHead;
                                        _a = this;
                                        if (!gitEvent.status.currentHead) return [3 /*break*/, 2];
                                        return [4 /*yield*/, this.getLastCommit()];
                                    case 1:
                                        _b = _c.sent();
                                        return [3 /*break*/, 3];
                                    case 2:
                                        _b = undefined;
                                        _c.label = 3;
                                    case 3:
                                        _a.lastCommit = _b;
                                        _c.label = 4;
                                    case 4:
                                        this.status = gitEvent.status;
                                        this.updateView(gitEvent.status);
                                        _c.label = 5;
                                    case 5: return [2 /*return*/];
                                }
                            });
                        }); }));
                        _c.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.doAddGitListKeyListeners = function (id) {
        var container = document.getElementById(id);
        if (container) {
            this.addGitListNavigationKeyListeners(container);
            this.addKeyListener(container, browser_1.Key.SPACE, this.stageOrUnstage);
            this.addKeyListener(container, browser_1.Key.BACKSPACE, this.handleBackspace);
        }
    };
    GitWidget.prototype.onActivateRequest = function (msg) {
        _super.prototype.onActivateRequest.call(this, msg);
        var messageInput = document.getElementById(GitWidget_1.Styles.COMMIT_MESSAGE);
        if (messageInput) {
            messageInput.focus();
        }
    };
    GitWidget.prototype.storeState = function () {
        var messageBoxHeight = this.messageBoxHeight ? this.messageBoxHeight : GitWidget_1.MESSAGE_BOX_MIN_HEIGHT;
        return {
            message: this.message,
            commitMessageValidationResult: this.commitMessageValidationResult,
            messageBoxHeight: messageBoxHeight
        };
    };
    // tslint:disable-next-line:no-any
    GitWidget.prototype.restoreState = function (oldState) {
        this.message = oldState.message;
        // Do not restore the validation message if the commit message is undefined or empty.
        this.commitMessageValidationResult = this.message ? oldState.commitMessageValidationResult : undefined;
        this.messageBoxHeight = oldState.messageBoxHeight || GitWidget_1.MESSAGE_BOX_MIN_HEIGHT;
    };
    GitWidget.prototype.doStageOrUnstage = function () {
        var change = this.getSelected();
        if (change && this.repositoryProvider.selectedRepository) {
            this.setLastSelectedNode(change);
            var repository = this.repositoryProvider.selectedRepository;
            if (!change.staged) {
                this.stage(repository, change);
            }
            else {
                this.unstage(repository, change);
            }
        }
    };
    GitWidget.prototype.doHandleBackspace = function () {
        return __awaiter(this, void 0, void 0, function () {
            var change;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        change = this.getSelected();
                        if (!(change && this.repositoryProvider.selectedRepository)) return [3 /*break*/, 2];
                        this.setLastSelectedNode(change);
                        return [4 /*yield*/, this.discard(this.repositoryProvider.selectedRepository, change)];
                    case 1:
                        _a.sent();
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.setLastSelectedNode = function (change) {
        this.lastSelectedNode = {
            id: this.indexOfSelected,
            node: change
        };
    };
    GitWidget.prototype.amend = function () {
        return __awaiter(this, void 0, void 0, function () {
            var selectedRepository, message, commitTextArea;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        selectedRepository = this.repositoryProvider.selectedRepository;
                        if (!selectedRepository) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.git.exec(selectedRepository, ['log', '-n', '1', '--format=%B'])];
                    case 1:
                        message = (_a.sent()).stdout.trim();
                        commitTextArea = document.getElementById(GitWidget_1.Styles.COMMIT_MESSAGE);
                        return [4 /*yield*/, this.git.exec(selectedRepository, ['reset', 'HEAD~', '--soft'])];
                    case 2:
                        _a.sent();
                        if (commitTextArea) {
                            this.message = message;
                            commitTextArea.value = message;
                            this.resize(commitTextArea);
                            commitTextArea.focus();
                        }
                        _a.label = 3;
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.doCommit = function (repository, options, message) {
        if (message === void 0) { message = this.message; }
        return __awaiter(this, void 0, void 0, function () {
            var _a, signOff, amend, status_1, error_1, messageInput;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!repository) return [3 /*break*/, 9];
                        this.commitMessageValidationResult = undefined;
                        if (message.trim().length === 0) {
                            this.commitMessageValidationResult = {
                                status: 'error',
                                message: 'Please provide a commit message'
                            };
                        }
                        _a = this.commitMessageValidationResult === undefined;
                        if (!_a) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.git.status(repository)];
                    case 1:
                        _a = !(_b.sent()).changes.some(function (c) { return c.staged === true; });
                        _b.label = 2;
                    case 2:
                        if (_a) {
                            this.commitMessageValidationResult = {
                                status: 'error',
                                message: 'No changes added to commit'
                            };
                        }
                        if (!(this.commitMessageValidationResult === undefined)) return [3 /*break*/, 8];
                        _b.label = 3;
                    case 3:
                        _b.trys.push([3, 6, , 7]);
                        signOff = options === 'sign-off';
                        amend = options === 'amend';
                        return [4 /*yield*/, this.git.commit(repository, message, { signOff: signOff, amend: amend })];
                    case 4:
                        _b.sent();
                        return [4 /*yield*/, this.git.status(repository)];
                    case 5:
                        status_1 = _b.sent();
                        this.resetCommitMessages();
                        this.updateView(status_1);
                        return [3 /*break*/, 7];
                    case 6:
                        error_1 = _b.sent();
                        this.gitErrorHandler.handleError(error_1);
                        return [3 /*break*/, 7];
                    case 7: return [3 /*break*/, 9];
                    case 8:
                        messageInput = document.getElementById(GitWidget_1.Styles.COMMIT_MESSAGE);
                        if (messageInput) {
                            this.update();
                            messageInput.focus();
                        }
                        _b.label = 9;
                    case 9: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.updateView = function (status) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, stagedChanges, unstagedChanges, mergeChanges, _b, _c, change, uri, repository, _d, icon, label, description, e_1_1, sort;
            return __generator(this, function (_e) {
                switch (_e.label) {
                    case 0:
                        stagedChanges = [];
                        unstagedChanges = [];
                        mergeChanges = [];
                        if (!status) return [3 /*break*/, 9];
                        _e.label = 1;
                    case 1:
                        _e.trys.push([1, 6, 7, 8]);
                        _b = __values(status.changes), _c = _b.next();
                        _e.label = 2;
                    case 2:
                        if (!!_c.done) return [3 /*break*/, 5];
                        change = _c.value;
                        uri = new uri_1.default(change.uri);
                        repository = this.repositoryProvider.selectedRepository;
                        return [4 /*yield*/, Promise.all([
                                this.labelProvider.getIcon(uri),
                                this.labelProvider.getName(uri),
                                repository ? common_1.Repository.relativePath(repository, uri.parent).toString() : this.labelProvider.getLongName(uri.parent)
                            ])];
                    case 3:
                        _d = __read.apply(void 0, [_e.sent(), 3]), icon = _d[0], label = _d[1], description = _d[2];
                        if (common_1.GitFileStatus[common_1.GitFileStatus.Conflicted.valueOf()] !== common_1.GitFileStatus[change.status]) {
                            if (change.staged) {
                                stagedChanges.push(__assign({ icon: icon, label: label, description: description }, change));
                            }
                            else {
                                unstagedChanges.push(__assign({ icon: icon, label: label, description: description }, change));
                            }
                        }
                        else {
                            if (!change.staged) {
                                mergeChanges.push(__assign({ icon: icon, label: label, description: description }, change));
                            }
                        }
                        _e.label = 4;
                    case 4:
                        _c = _b.next();
                        return [3 /*break*/, 2];
                    case 5: return [3 /*break*/, 8];
                    case 6:
                        e_1_1 = _e.sent();
                        e_1 = { error: e_1_1 };
                        return [3 /*break*/, 8];
                    case 7:
                        try {
                            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
                        }
                        finally { if (e_1) throw e_1.error; }
                        return [7 /*endfinally*/];
                    case 8:
                        this.incomplete = status.incomplete;
                        _e.label = 9;
                    case 9:
                        sort = function (l, r) { return l.label.localeCompare(r.label); };
                        this.stagedChanges = stagedChanges.sort(sort);
                        this.unstagedChanges = unstagedChanges.sort(sort);
                        this.mergeChanges = mergeChanges.sort(sort);
                        this.gitNodes = __spread(this.mergeChanges, this.stagedChanges, this.unstagedChanges);
                        this.setNodeSelection();
                        this.update();
                        return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.setNodeSelection = function () {
        if (this.lastSelectedNode) {
            var newId = this.lastSelectedNode.id;
            if (this.lastSelectedNode.node.staged) {
                newId -= 1;
                if (newId < 0) {
                    newId = 0;
                }
                this.gitNodes[newId].selected = true;
            }
            else {
                if (this.gitNodes[newId] && this.gitNodes[newId].staged && this.gitNodes[newId + 1]) {
                    newId += 1;
                }
                else if (!this.gitNodes[newId]) {
                    newId = this.gitNodes.length - 1;
                }
                this.gitNodes[newId].selected = true;
            }
            this.lastSelectedNode = undefined;
        }
    };
    GitWidget.prototype.renderCommitMessage = function () {
        var validationStatus = this.commitMessageValidationResult ? this.commitMessageValidationResult.status : 'idle';
        var validationMessage = this.commitMessageValidationResult ? this.commitMessageValidationResult.message : '';
        return React.createElement("div", { className: GitWidget_1.Styles.COMMIT_MESSAGE_CONTAINER },
            React.createElement("textarea", { className: GitWidget_1.Styles.COMMIT_MESSAGE + " theia-git-commit-message-" + validationStatus, style: { height: this.messageBoxHeight, overflow: this.messageBoxHeight > GitWidget_1.MESSAGE_BOX_MIN_HEIGHT ? 'auto' : 'hidden' }, autoFocus: true, onInput: this.onCommitMessageChange.bind(this), placeholder: 'Commit message', id: GitWidget_1.Styles.COMMIT_MESSAGE, defaultValue: this.message, tabIndex: 1 }),
            React.createElement("div", { className: GitWidget_1.Styles.VALIDATION_MESSAGE + " " + GitWidget_1.Styles.NO_SELECT + "\n                    theia-git-validation-message-" + validationStatus + " theia-git-commit-message-" + validationStatus, style: {
                    display: !!this.commitMessageValidationResult ? 'block' : 'none'
                } }, validationMessage));
    };
    GitWidget.prototype.onCommitMessageChange = function (e) {
        var _this = this;
        var target = e.target;
        if (target instanceof HTMLTextAreaElement) {
            var value = target.value;
            this.message = value;
            this.resize(target);
            this.validateCommitMessage(value).then(function (result) {
                if (!git_commit_message_validator_1.GitCommitMessageValidator.Result.equal(_this.commitMessageValidationResult, result)) {
                    _this.commitMessageValidationResult = result;
                    _this.update();
                }
            });
        }
    };
    GitWidget.prototype.resize = function (textArea) {
        // tslint:disable-next-line:no-null-keyword
        var fontSize = Number.parseInt(window.getComputedStyle(textArea, undefined).getPropertyValue('font-size').split('px')[0] || '0', 10);
        var value = textArea.value;
        if (Number.isInteger(fontSize) && fontSize > 0) {
            var requiredHeight = fontSize * value.split(/\r?\n/).length;
            if (requiredHeight < textArea.scrollHeight) {
                textArea.style.height = requiredHeight + "px";
            }
        }
        if (textArea.clientHeight < textArea.scrollHeight) {
            textArea.style.height = textArea.scrollHeight + "px";
            if (textArea.clientHeight < textArea.scrollHeight) {
                textArea.style.height = (textArea.scrollHeight * 2 - textArea.clientHeight) + "px";
            }
        }
        var updatedHeight = textArea.style.height;
        if (updatedHeight) {
            this.messageBoxHeight = parseInt(updatedHeight, 10) || GitWidget_1.MESSAGE_BOX_MIN_HEIGHT;
            if (this.messageBoxHeight > GitWidget_1.MESSAGE_BOX_MIN_HEIGHT) {
                textArea.style.overflow = 'auto';
            }
            else {
                // Hide the scroll-bar if we shrink down the size.
                textArea.style.overflow = 'hidden';
            }
        }
    };
    GitWidget.prototype.validateCommitMessage = function (input) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                return [2 /*return*/, this.commitMessageValidator.validate(input)];
            });
        });
    };
    GitWidget.prototype.render = function () {
        var _this = this;
        var repository = this.repositoryProvider.selectedRepository;
        return React.createElement("div", { className: GitWidget_1.Styles.MAIN_CONTAINER },
            React.createElement("div", { className: 'headerContainer' },
                this.renderCommitMessage(),
                this.renderCommandBar(repository)),
            this.incomplete ?
                React.createElement("div", { className: GitWidget_1.Styles.MESSAGE_CONTAINER + " " + GitWidget_1.Styles.WARNING_MESSAGE }, "There are too many active changes, only a subset is shown.")
                : '',
            React.createElement(GitChangesListContainer, { ref: function (ref) { return _this.listContainer = ref || undefined; }, id: this.scrollContainer, repository: repository, openChange: this.handleOpenChange, openFile: this.openFile, selectChange: this.selectChange, discard: this.discard, unstage: this.unstage, stage: this.stage, mergeChanges: this.mergeChanges, stagedChanges: this.stagedChanges, unstagedChanges: this.unstagedChanges, addGitListKeyListeners: this.addGitListKeyListeners, onFocus: this.handleListFocus }),
            this.lastCommit ?
                React.createElement("div", null,
                    React.createElement("div", { className: GitWidget_1.Styles.LAST_COMMIT_CONTAINER }, this.renderLastCommit()))
                : '');
    };
    GitWidget.prototype.doOpenFile = function (uri) {
        this.editorManager.open(uri, { mode: 'reveal' });
    };
    GitWidget.prototype.doHandleListFocus = function (e) {
        var selected = this.getSelected();
        if (!selected && this.gitNodes.length > 0) {
            this.selectNode(this.gitNodes[0]);
        }
    };
    GitWidget.prototype.getLastCommit = function () {
        return __awaiter(this, void 0, void 0, function () {
            var selectedRepository, commits, commit, avatar;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        selectedRepository = this.repositoryProvider.selectedRepository;
                        if (!selectedRepository) return [3 /*break*/, 3];
                        return [4 /*yield*/, this.git.log(selectedRepository, { maxCount: 1, shortSha: true })];
                    case 1:
                        commits = _a.sent();
                        if (!(commits.length > 0)) return [3 /*break*/, 3];
                        commit = commits[0];
                        return [4 /*yield*/, this.avatarService.getAvatar(commit.author.email)];
                    case 2:
                        avatar = _a.sent();
                        return [2 /*return*/, { commit: commit, avatar: avatar }];
                    case 3: return [2 /*return*/, undefined];
                }
            });
        });
    };
    GitWidget.prototype.renderLastCommit = function () {
        var _this = this;
        if (!this.lastCommit) {
            return '';
        }
        var _a = this.lastCommit, commit = _a.commit, avatar = _a.avatar;
        return React.createElement(React.Fragment, null,
            React.createElement("div", { className: GitWidget_1.Styles.LAST_COMMIT_MESSAGE_AVATAR },
                React.createElement("img", { src: avatar })),
            React.createElement("div", { className: GitWidget_1.Styles.LAST_COMMIT_DETAILS },
                React.createElement("div", { className: GitWidget_1.Styles.LAST_COMMIT_MESSAGE_SUMMARY }, commit.summary),
                React.createElement("div", { className: GitWidget_1.Styles.LAST_COMMIT_MESSAGE_TIME }, commit.authorDateRelative + " by " + commit.author.name)),
            React.createElement("div", { className: GitWidget_1.Styles.FLEX_CENTER },
                React.createElement("button", { className: 'theia-button', title: 'Amend last commit', onClick: function () { return _this.amend.bind(_this)(); } }, "Amend")));
    };
    GitWidget.prototype.doRefresh = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.repositoryProvider.refresh()];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.doShowMoreToolButtons = function (event) {
        var el = event.target.parentElement;
        if (el) {
            this.contextMenuRenderer.render(GitWidget_1.ContextMenu.PATH, {
                x: el.getBoundingClientRect().left,
                y: el.getBoundingClientRect().top + el.offsetHeight
            });
        }
    };
    GitWidget.prototype.doSignOff = function () {
        return __awaiter(this, void 0, void 0, function () {
            var selectedRepository, _a, username, email, signOff, commitTextArea, content;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        selectedRepository = this.repositoryProvider.selectedRepository;
                        if (!selectedRepository) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.getUserConfig(selectedRepository)];
                    case 1:
                        _a = __read.apply(void 0, [_b.sent(), 2]), username = _a[0], email = _a[1];
                        signOff = "\n\nSigned-off-by: " + username + " <" + email + ">";
                        commitTextArea = document.getElementById(GitWidget_1.Styles.COMMIT_MESSAGE);
                        if (commitTextArea) {
                            content = commitTextArea.value;
                            if (content.endsWith(signOff)) {
                                commitTextArea.value = content.substr(0, content.length - signOff.length);
                            }
                            else {
                                commitTextArea.value = "" + content + signOff;
                            }
                            this.resize(commitTextArea);
                            this.message = commitTextArea.value;
                            commitTextArea.focus();
                        }
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.renderCommandBar = function (repository) {
        var _this = this;
        return React.createElement("div", { id: 'commandBar', className: 'flexcontainer' },
            React.createElement("div", { className: 'buttons' },
                React.createElement("a", { className: 'toolbar-button', title: 'Refresh', onClick: this.refresh },
                    React.createElement("i", { className: 'fa fa-refresh' })),
                repository ?
                    React.createElement(React.Fragment, null,
                        React.createElement("a", { className: 'toolbar-button', title: 'Add Signed-off-by', onClick: this.signOff },
                            React.createElement("i", { className: 'fa fa-pencil-square-o ' })),
                        React.createElement("a", { className: 'toolbar-button', title: 'More...', onClick: this.showMoreToolButtons },
                            React.createElement("i", { className: 'fa fa-ellipsis-h' })))
                    : ''),
            React.createElement("div", { className: 'placeholder' }),
            React.createElement("div", { className: 'buttons' },
                React.createElement("button", { className: 'theia-button', title: 'Commit all the staged changes', onClick: function () { return _this.commit(repository); } }, "Commit")));
    };
    GitWidget.prototype.getUserConfig = function (repository) {
        return __awaiter(this, void 0, void 0, function () {
            var _a, username, email;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0: return [4 /*yield*/, Promise.all([
                            this.git.exec(repository, ['config', 'user.name']),
                            this.git.exec(repository, ['config', 'user.email'])
                        ])];
                    case 1:
                        _a = __read.apply(void 0, [(_b.sent()).map(function (result) { return result.stdout.trim(); }), 2]), username = _a[0], email = _a[1];
                        return [2 /*return*/, [username, email]];
                }
            });
        });
    };
    GitWidget.prototype.doUnstage = function (repository, change) {
        return __awaiter(this, void 0, void 0, function () {
            var error_2;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, this.git.unstage(repository, change.uri)];
                    case 1:
                        _a.sent();
                        return [3 /*break*/, 3];
                    case 2:
                        error_2 = _a.sent();
                        this.gitErrorHandler.handleError(error_2);
                        return [3 /*break*/, 3];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.doDiscard = function (repository, change) {
        return __awaiter(this, void 0, void 0, function () {
            var error_3;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.git.lsFiles(repository, change.uri, { errorUnmatch: true })];
                    case 1:
                        if (!_a.sent()) return [3 /*break*/, 7];
                        return [4 /*yield*/, this.confirm(change.uri)];
                    case 2:
                        if (!_a.sent()) return [3 /*break*/, 6];
                        _a.label = 3;
                    case 3:
                        _a.trys.push([3, 5, , 6]);
                        return [4 /*yield*/, this.git.unstage(repository, change.uri, { treeish: 'HEAD', reset: 'working-tree' })];
                    case 4:
                        _a.sent();
                        return [3 /*break*/, 6];
                    case 5:
                        error_3 = _a.sent();
                        this.gitErrorHandler.handleError(error_3);
                        return [3 /*break*/, 6];
                    case 6: return [3 /*break*/, 9];
                    case 7: return [4 /*yield*/, this.commandService.executeCommand(browser_3.WorkspaceCommands.FILE_DELETE.id, new uri_1.default(change.uri))];
                    case 8:
                        _a.sent();
                        _a.label = 9;
                    case 9:
                        if (this.listContainer) {
                            this.listContainer.focus();
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.confirm = function (path) {
        var uri = new uri_1.default(path);
        return new browser_1.ConfirmDialog({
            title: 'Discard changes',
            msg: "Do you really want to discard changes in " + uri.displayName
        }).open();
    };
    GitWidget.prototype.doStage = function (repository, change) {
        return __awaiter(this, void 0, void 0, function () {
            var error_4;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, this.git.add(repository, change.uri)];
                    case 1:
                        _a.sent();
                        return [3 /*break*/, 3];
                    case 2:
                        error_4 = _a.sent();
                        this.gitErrorHandler.handleError(error_4);
                        return [3 /*break*/, 3];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    GitWidget.prototype.findChange = function (uri) {
        var stringUri = uri.toString();
        var merge = this.mergeChanges.find(function (c) { return c.uri.toString() === stringUri; });
        if (merge) {
            return merge;
        }
        var unstaged = this.unstagedChanges.find(function (c) { return c.uri.toString() === stringUri; });
        if (unstaged) {
            return unstaged;
        }
        return this.stagedChanges.find(function (c) { return c.uri.toString() === stringUri; });
    };
    GitWidget.prototype.getUriToOpen = function (change) {
        var changeUri = new uri_1.default(change.uri);
        if (change.status !== common_1.GitFileStatus.New) {
            if (change.staged) {
                return browser_1.DiffUris.encode(changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery('HEAD'), changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME), changeUri.displayName + ' (Index)');
            }
            if (this.stagedChanges.find(function (c) { return c.uri === change.uri; })) {
                return browser_1.DiffUris.encode(changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME), changeUri, changeUri.displayName + ' (Working tree)');
            }
            if (this.mergeChanges.find(function (c) { return c.uri === change.uri; })) {
                return changeUri;
            }
            return browser_1.DiffUris.encode(changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery('HEAD'), changeUri, changeUri.displayName + ' (Working tree)');
        }
        if (change.staged) {
            return changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME);
        }
        if (this.stagedChanges.find(function (c) { return c.uri === change.uri; })) {
            return browser_1.DiffUris.encode(changeUri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME), changeUri, changeUri.displayName + ' (Working tree)');
        }
        return changeUri;
    };
    GitWidget.prototype.resetCommitMessages = function () {
        this.message = '';
        var messageInput = document.getElementById(GitWidget_1.Styles.COMMIT_MESSAGE);
        messageInput.value = '';
        this.resize(messageInput);
    };
    var GitWidget_1;
    GitWidget.MESSAGE_BOX_MIN_HEIGHT = 25;
    __decorate([
        inversify_1.inject(browser_2.EditorManager),
        __metadata("design:type", browser_2.EditorManager)
    ], GitWidget.prototype, "editorManager", void 0);
    __decorate([
        inversify_1.inject(git_error_handler_1.GitErrorHandler),
        __metadata("design:type", git_error_handler_1.GitErrorHandler)
    ], GitWidget.prototype, "gitErrorHandler", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], GitWidget.prototype, "init", null);
    GitWidget = GitWidget_1 = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.Git)),
        __param(1, inversify_1.inject(git_watcher_1.GitWatcher)),
        __param(2, inversify_1.inject(browser_1.ContextMenuRenderer)),
        __param(3, inversify_1.inject(core_1.ResourceProvider)),
        __param(4, inversify_1.inject(core_1.CommandService)),
        __param(5, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __param(6, inversify_1.inject(browser_1.LabelProvider)),
        __param(7, inversify_1.inject(git_avatar_service_1.GitAvatarService)),
        __param(8, inversify_1.inject(git_commit_message_validator_1.GitCommitMessageValidator)),
        __metadata("design:paramtypes", [Object, git_watcher_1.GitWatcher, Object, Function, Object, git_repository_provider_1.GitRepositoryProvider,
            browser_1.LabelProvider,
            git_avatar_service_1.GitAvatarService,
            git_commit_message_validator_1.GitCommitMessageValidator])
    ], GitWidget);
    return GitWidget;
}(git_diff_widget_1.GitDiffWidget));
exports.GitWidget = GitWidget;
(function (GitWidget) {
    var ContextMenu;
    (function (ContextMenu) {
        ContextMenu.PATH = ['git-widget-context-menu'];
        ContextMenu.OTHER_GROUP = __spread(ContextMenu.PATH, ['1_other']);
        ContextMenu.COMMIT_GROUP = __spread(ContextMenu.PATH, ['2_commit']);
    })(ContextMenu = GitWidget.ContextMenu || (GitWidget.ContextMenu = {}));
    var Styles;
    (function (Styles) {
        Styles.MAIN_CONTAINER = 'theia-git-main-container';
        Styles.CHANGES_CONTAINER = 'changesOuterContainer';
        Styles.COMMIT_MESSAGE_CONTAINER = 'theia-git-commit-message-container';
        Styles.COMMIT_MESSAGE = 'theia-git-commit-message';
        Styles.MESSAGE_CONTAINER = 'theia-git-message';
        Styles.WARNING_MESSAGE = 'theia-git-message-warning';
        Styles.VALIDATION_MESSAGE = 'theia-git-commit-validation-message';
        Styles.LAST_COMMIT_CONTAINER = 'theia-git-last-commit-container';
        Styles.LAST_COMMIT_DETAILS = 'theia-git-last-commit-details';
        Styles.LAST_COMMIT_MESSAGE_AVATAR = 'theia-git-last-commit-message-avatar';
        Styles.LAST_COMMIT_MESSAGE_SUMMARY = 'theia-git-last-commit-message-summary';
        Styles.LAST_COMMIT_MESSAGE_TIME = 'theia-git-last-commit-message-time';
        Styles.FLEX_CENTER = 'flex-container-center';
        Styles.NO_SELECT = 'no-select';
    })(Styles = GitWidget.Styles || (GitWidget.Styles = {}));
})(GitWidget = exports.GitWidget || (exports.GitWidget = {}));
exports.GitWidget = GitWidget;
var GitItem = /** @class */ (function (_super) {
    __extends(GitItem, _super);
    function GitItem() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.openChange = function () { return _this.props.openChange(_this.props.change, { mode: 'reveal' }); };
        _this.selectChange = function () { return _this.props.selectChange(_this.props.change); };
        _this.doGitAction = function (action) { return _this.props[action](_this.props.repository, _this.props.change); };
        _this.doOpenFile = function () { return _this.props.openFile(new uri_1.default(_this.props.change.uri)); };
        return _this;
    }
    GitItem.prototype.render = function () {
        var change = this.props.change;
        return React.createElement("div", { className: "gitItem " + GitWidget.Styles.NO_SELECT + (change.selected ? ' ' + browser_1.SELECTED_CLASS : '') },
            React.createElement("div", { className: 'noWrapInfo', onDoubleClick: this.openChange, onClick: this.selectChange },
                React.createElement("span", { className: change.icon + ' file-icon' }),
                React.createElement("span", { className: 'name' }, change.label + ' '),
                React.createElement("span", { className: 'path' }, change.description)),
            React.createElement("div", { className: 'itemButtonsContainer' },
                this.renderGitItemButtons(),
                React.createElement("div", { title: common_1.GitFileStatus.toString(change.status, change.staged), className: "status " + (change.staged ? 'staged ' : '') + " " + common_1.GitFileStatus[change.status].toLowerCase() }, common_1.GitFileStatus.toAbbreviation(change.status, change.staged))));
    };
    GitItem.prototype.renderGitItemButtons = function () {
        var _this = this;
        return React.createElement("div", { className: 'buttons' },
            React.createElement("a", { className: 'toolbar-button', title: 'Open File', onClick: function () { return _this.doOpenFile(); } },
                React.createElement("i", { className: 'open-file' })),
            this.props.change.staged ?
                React.createElement("a", { className: 'toolbar-button', title: 'Unstage Changes', onClick: function () { return _this.doGitAction('unstage'); } },
                    React.createElement("i", { className: 'fa fa-minus' })) :
                React.createElement(React.Fragment, null,
                    React.createElement("a", { className: 'toolbar-button', title: 'Discard Changes', onClick: function () { return _this.doGitAction('discard'); } },
                        React.createElement("i", { className: 'fa fa-undo' })),
                    React.createElement("a", { className: 'toolbar-button', title: 'Stage Changes', onClick: function () { return _this.doGitAction('stage'); } },
                        React.createElement("i", { className: 'fa fa-plus' }))));
    };
    return GitItem;
}(React.Component));
exports.GitItem = GitItem;
var GitChangesListContainer = /** @class */ (function (_super) {
    __extends(GitChangesListContainer, _super);
    function GitChangesListContainer() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.handleOnFocus = function (e) {
            _this.props.onFocus(e);
        };
        return _this;
    }
    GitChangesListContainer.prototype.render = function () {
        var _this = this;
        return (React.createElement("div", { ref: function (ref) { return _this.listContainer = ref || undefined; }, className: GitWidget.Styles.CHANGES_CONTAINER, id: this.props.id, onFocus: this.handleOnFocus, tabIndex: 2 },
            this.renderMergeChanges(this.props.repository) || '',
            this.renderStagedChanges(this.props.repository) || '',
            this.renderUnstagedChanges(this.props.repository) || ''));
    };
    GitChangesListContainer.prototype.componentDidMount = function () {
        this.props.addGitListKeyListeners(this.props.id);
    };
    GitChangesListContainer.prototype.focus = function () {
        if (this.listContainer) {
            this.listContainer.focus();
        }
    };
    GitChangesListContainer.prototype.renderGitItem = function (change, repository) {
        if (!repository) {
            return '';
        }
        return React.createElement(GitItem, { key: change.uri + change.status, repository: repository, change: change, openChange: this.props.openChange, discard: this.props.discard, stage: this.props.stage, unstage: this.props.unstage, selectChange: this.props.selectChange, openFile: this.props.openFile });
    };
    GitChangesListContainer.prototype.renderMergeChanges = function (repository) {
        var _this = this;
        if (this.props.mergeChanges.length > 0) {
            return React.createElement("div", { id: 'mergeChanges', className: 'changesContainer' },
                React.createElement("div", { className: 'theia-header' }, "Merge Changes"),
                this.props.mergeChanges.map(function (change) { return _this.renderGitItem(change, repository); }));
        }
        else {
            return undefined;
        }
    };
    GitChangesListContainer.prototype.renderStagedChanges = function (repository) {
        var _this = this;
        if (this.props.stagedChanges.length > 0) {
            return React.createElement("div", { id: 'stagedChanges', className: 'changesContainer' },
                React.createElement("div", { className: 'theia-header' }, "Staged Changes"),
                this.props.stagedChanges.map(function (change) { return _this.renderGitItem(change, repository); }));
        }
        else {
            return undefined;
        }
    };
    GitChangesListContainer.prototype.renderUnstagedChanges = function (repository) {
        var _this = this;
        if (this.props.unstagedChanges.length > 0) {
            return React.createElement("div", { id: 'unstagedChanges', className: 'changesContainer' },
                React.createElement("div", { className: 'theia-header' }, "Changed"),
                this.props.unstagedChanges.map(function (change) { return _this.renderGitItem(change, repository); }));
        }
        return undefined;
    };
    return GitChangesListContainer;
}(React.Component));
exports.GitChangesListContainer = GitChangesListContainer;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-avatar-service.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-avatar-service.js ***!
  \****************************************************************************/
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
var ts_md5_1 = __webpack_require__(/*! ts-md5 */ "../node_modules/ts-md5/dist/md5.js");
var GitAvatarService = /** @class */ (function () {
    function GitAvatarService() {
    }
    GitAvatarService.prototype.getAvatar = function (email) {
        return __awaiter(this, void 0, void 0, function () {
            var hash;
            return __generator(this, function (_a) {
                hash = ts_md5_1.Md5.hashStr(email);
                return [2 /*return*/, "https://www.gravatar.com/avatar/" + hash + "?d=robohash"];
            });
        });
    };
    GitAvatarService = __decorate([
        inversify_1.injectable()
    ], GitAvatarService);
    return GitAvatarService;
}());
exports.GitAvatarService = GitAvatarService;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-open-handler.js":
/*!****************************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-commit-detail-open-handler.js ***!
  \****************************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var git_commit_detail_widget_1 = __webpack_require__(/*! ./git-commit-detail-widget */ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-widget.js");
var GitCommitDetailUri;
(function (GitCommitDetailUri) {
    GitCommitDetailUri.scheme = git_commit_detail_widget_1.GIT_COMMIT_DETAIL;
    function toUri(commitSha) {
        return new uri_1.default('').withScheme(GitCommitDetailUri.scheme).withFragment(commitSha);
    }
    GitCommitDetailUri.toUri = toUri;
    function toCommitSha(uri) {
        if (uri.scheme === GitCommitDetailUri.scheme) {
            return uri.fragment;
        }
        throw new Error('The given uri is not an commit detail URI, uri: ' + uri);
    }
    GitCommitDetailUri.toCommitSha = toCommitSha;
})(GitCommitDetailUri = exports.GitCommitDetailUri || (exports.GitCommitDetailUri = {}));
var GitCommitDetailOpenHandler = /** @class */ (function (_super) {
    __extends(GitCommitDetailOpenHandler, _super);
    function GitCommitDetailOpenHandler() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.id = git_commit_detail_widget_1.GIT_COMMIT_DETAIL;
        return _this;
    }
    GitCommitDetailOpenHandler.prototype.canHandle = function (uri) {
        try {
            GitCommitDetailUri.toCommitSha(uri);
            return 200;
        }
        catch (_a) {
            return 0;
        }
    };
    GitCommitDetailOpenHandler.prototype.doOpen = function (widget, options) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        widget.setContent({ range: options.range });
                        return [4 /*yield*/, _super.prototype.doOpen.call(this, widget, options)];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    GitCommitDetailOpenHandler.prototype.createWidgetOptions = function (uri, commit) {
        return this.getCommitDetailWidgetOptions(commit);
    };
    GitCommitDetailOpenHandler.prototype.getCommitDetailWidgetOptions = function (commit) {
        var range = {
            fromRevision: commit.commitSha + '~1',
            toRevision: commit.commitSha
        };
        return {
            range: range,
            authorAvatar: commit.authorAvatar,
            authorDate: commit.authorDate,
            authorDateRelative: commit.authorDateRelative,
            authorEmail: commit.authorEmail,
            authorName: commit.authorName,
            commitMessage: commit.commitMessage,
            fileChangeNodes: commit.fileChangeNodes,
            messageBody: commit.messageBody,
            commitSha: commit.commitSha
        };
    };
    GitCommitDetailOpenHandler = __decorate([
        inversify_1.injectable()
    ], GitCommitDetailOpenHandler);
    return GitCommitDetailOpenHandler;
}(browser_1.WidgetOpenHandler));
exports.GitCommitDetailOpenHandler = GitCommitDetailOpenHandler;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-widget.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-commit-detail-widget.js ***!
  \**********************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var widgets_1 = __webpack_require__(/*! @phosphor/widgets */ "../node_modules/@phosphor/widgets/lib/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var git_diff_widget_1 = __webpack_require__(/*! ../diff/git-diff-widget */ "../node_modules/@theia/git/lib/browser/diff/git-diff-widget.js");
var git_repository_provider_1 = __webpack_require__(/*! ../git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
exports.GIT_COMMIT_DETAIL = 'git-commit-detail-widget';
exports.GitCommitDetailWidgetOptions = Symbol('GitCommitDetailWidgetOptions');
var GitCommitDetailWidget = /** @class */ (function (_super) {
    __extends(GitCommitDetailWidget, _super);
    function GitCommitDetailWidget(repositoryProvider, labelProvider, commitDetailOptions) {
        var _this = _super.call(this) || this;
        _this.repositoryProvider = repositoryProvider;
        _this.labelProvider = labelProvider;
        _this.commitDetailOptions = commitDetailOptions;
        _this.id = 'commit' + commitDetailOptions.commitSha;
        _this.title.label = commitDetailOptions.commitSha;
        _this.options = { range: commitDetailOptions.range };
        _this.title.closable = true;
        _this.title.iconClass = 'icon-git-commit tab-git-icon';
        return _this;
    }
    GitCommitDetailWidget.prototype.renderDiffListHeader = function () {
        var authorEMail = this.commitDetailOptions.authorEmail;
        var subject = React.createElement("div", { className: 'subject' }, this.commitDetailOptions.commitMessage);
        var body = React.createElement("div", { className: 'body' }, this.commitDetailOptions.messageBody || '');
        var subjectRow = React.createElement("div", { className: 'header-row' },
            React.createElement("div", { className: 'subjectContainer' },
                subject,
                body));
        var author = React.createElement("div", { className: 'author header-value noWrapInfo' }, this.commitDetailOptions.authorName);
        var mail = React.createElement("div", { className: 'mail header-value noWrapInfo' }, "<" + authorEMail + ">");
        var authorRow = React.createElement("div", { className: 'header-row noWrapInfo' },
            React.createElement("div", { className: 'theia-header' }, "author: "),
            author);
        var mailRow = React.createElement("div", { className: 'header-row noWrapInfo' },
            React.createElement("div", { className: 'theia-header' }, "e-mail: "),
            mail);
        var authorDate = this.commitDetailOptions.authorDate;
        var dateStr = authorDate.toLocaleDateString('en', {
            month: 'short',
            day: 'numeric',
            year: 'numeric',
            hour12: true,
            hour: 'numeric',
            minute: 'numeric'
        });
        var date = React.createElement("div", { className: 'date header-value noWrapInfo' }, dateStr);
        var dateRow = React.createElement("div", { className: 'header-row noWrapInfo' },
            React.createElement("div", { className: 'theia-header' }, "date: "),
            date);
        var revisionRow = React.createElement("div", { className: 'header-row noWrapInfo' },
            React.createElement("div", { className: 'theia-header' }, "revision: "),
            React.createElement("div", { className: 'header-value noWrapInfo' }, this.commitDetailOptions.commitSha));
        var gravatar = React.createElement("div", { className: 'image-container' },
            React.createElement("img", { className: 'gravatar', src: this.commitDetailOptions.authorAvatar }));
        var commitInfo = React.createElement("div", { className: 'header-row commit-info-row' },
            gravatar,
            React.createElement("div", { className: 'commit-info' },
                authorRow,
                mailRow,
                dateRow,
                revisionRow));
        var header = React.createElement("div", { className: 'theia-header' }, "Files changed");
        return React.createElement("div", { className: 'diff-header' },
            subjectRow,
            commitInfo,
            header);
    };
    GitCommitDetailWidget.prototype.revealChange = function (change) {
        return __awaiter(this, void 0, void 0, function () {
            var ref, widget;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        ref = this.ref;
                        return [4 /*yield*/, this.openChange(change, {
                                mode: 'reveal',
                                widgetOptions: ref ?
                                    { area: 'main', mode: 'tab-after', ref: ref } :
                                    { area: 'main', mode: 'split-right', ref: this }
                            })];
                    case 1:
                        widget = _a.sent();
                        this.ref = widget instanceof widgets_1.Widget ? widget : undefined;
                        if (this.ref) {
                            this.ref.disposed.connect(function () {
                                if (_this.ref === widget) {
                                    _this.ref = undefined;
                                }
                            });
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    GitCommitDetailWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(git_repository_provider_1.GitRepositoryProvider)),
        __param(1, inversify_1.inject(browser_1.LabelProvider)),
        __param(2, inversify_1.inject(exports.GitCommitDetailWidgetOptions)),
        __metadata("design:paramtypes", [git_repository_provider_1.GitRepositoryProvider,
            browser_1.LabelProvider, Object])
    ], GitCommitDetailWidget);
    return GitCommitDetailWidget;
}(git_diff_widget_1.GitDiffWidget));
exports.GitCommitDetailWidget = GitCommitDetailWidget;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-history-contribution.js":
/*!**********************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-history-contribution.js ***!
  \**********************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var navigator_contribution_1 = __webpack_require__(/*! @theia/navigator/lib/browser/navigator-contribution */ "../node_modules/@theia/navigator/lib/browser/navigator-contribution.js");
var uri_command_handler_1 = __webpack_require__(/*! @theia/core/lib/common/uri-command-handler */ "../node_modules/@theia/core/lib/common/uri-command-handler.js");
var git_repository_tracker_1 = __webpack_require__(/*! ../git-repository-tracker */ "../node_modules/@theia/git/lib/browser/git-repository-tracker.js");
var git_repository_provider_1 = __webpack_require__(/*! ../git-repository-provider */ "../node_modules/@theia/git/lib/browser/git-repository-provider.js");
var git_view_contribution_1 = __webpack_require__(/*! ../git-view-contribution */ "../node_modules/@theia/git/lib/browser/git-view-contribution.js");
var GitHistoryCommands;
(function (GitHistoryCommands) {
    GitHistoryCommands.OPEN_FILE_HISTORY = {
        id: 'git-history:open-file-history',
        label: 'Git History'
    };
    GitHistoryCommands.OPEN_BRANCH_HISTORY = {
        id: 'git-history:open-branch-history'
    };
})(GitHistoryCommands = exports.GitHistoryCommands || (exports.GitHistoryCommands = {}));
exports.GIT_HISTORY = 'git-history';
exports.GIT_HISTORY_MAX_COUNT = 100;
var GitHistoryContribution = /** @class */ (function (_super) {
    __extends(GitHistoryContribution, _super);
    function GitHistoryContribution() {
        return _super.call(this, {
            widgetId: exports.GIT_HISTORY,
            widgetName: 'Git History',
            defaultWidgetOptions: {
                area: 'left',
                rank: 400
            },
            toggleCommandId: GitHistoryCommands.OPEN_BRANCH_HISTORY.id,
            toggleKeybinding: 'alt+h'
        }) || this;
    }
    GitHistoryContribution.prototype.init = function () {
        var _this = this;
        this.repositoryTracker.onDidChangeRepository(function (repository) { return __awaiter(_this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.refreshWidget(repository ? repository.localUri : undefined);
                return [2 /*return*/];
            });
        }); });
        this.repositoryTracker.onGitEvent(function (event) {
            var source = event.source, status = event.status, oldStatus = event.oldStatus;
            var isBranchChanged = false;
            var isHeaderChanged = false;
            if (oldStatus) {
                isBranchChanged = status.branch !== oldStatus.branch;
                isHeaderChanged = status.currentHead !== oldStatus.currentHead;
            }
            if (isBranchChanged || isHeaderChanged || oldStatus === undefined) {
                _this.refreshWidget(source.localUri);
            }
        });
    };
    GitHistoryContribution.prototype.registerMenus = function (menus) {
        menus.registerMenuAction(__spread(navigator_contribution_1.NAVIGATOR_CONTEXT_MENU, ['5_history']), {
            commandId: GitHistoryCommands.OPEN_FILE_HISTORY.id
        });
        menus.registerMenuAction(git_view_contribution_1.EDITOR_CONTEXT_MENU_GIT, {
            commandId: GitHistoryCommands.OPEN_FILE_HISTORY.id
        });
        _super.prototype.registerMenus.call(this, menus);
    };
    GitHistoryContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(GitHistoryCommands.OPEN_FILE_HISTORY, this.newUriAwareCommandHandler({
            execute: function (uri) { return __awaiter(_this, void 0, void 0, function () { return __generator(this, function (_a) {
                return [2 /*return*/, this.showWidget(uri.toString())];
            }); }); },
            isEnabled: function (uri) { return !!_this.repositoryProvider.findRepository(uri); }
        }));
        commands.registerCommand(GitHistoryCommands.OPEN_BRANCH_HISTORY, {
            execute: function () { return _this.showWidget(undefined); }
        });
    };
    GitHistoryContribution.prototype.showWidget = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.openView({
                            activate: true
                        })];
                    case 1:
                        _a.sent();
                        this.refreshWidget(uri);
                        return [2 /*return*/];
                }
            });
        });
    };
    GitHistoryContribution.prototype.refreshWidget = function (uri) {
        return __awaiter(this, void 0, void 0, function () {
            var widget, options;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        widget = this.tryGetWidget();
                        if (!widget) {
                            // the widget doesn't exist, so don't wake it up
                            return [2 /*return*/];
                        }
                        options = {
                            uri: uri,
                            maxCount: exports.GIT_HISTORY_MAX_COUNT,
                            shortSha: true
                        };
                        return [4 /*yield*/, widget.setContent(options)];
                    case 1:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    GitHistoryContribution.prototype.newUriAwareCommandHandler = function (handler) {
        return new uri_command_handler_1.UriAwareCommandHandler(this.selectionService, handler);
    };
    __decorate([
        inversify_1.inject(core_1.SelectionService),
        __metadata("design:type", core_1.SelectionService)
    ], GitHistoryContribution.prototype, "selectionService", void 0);
    __decorate([
        inversify_1.inject(git_repository_tracker_1.GitRepositoryTracker),
        __metadata("design:type", git_repository_tracker_1.GitRepositoryTracker)
    ], GitHistoryContribution.prototype, "repositoryTracker", void 0);
    __decorate([
        inversify_1.inject(git_repository_provider_1.GitRepositoryProvider),
        __metadata("design:type", git_repository_provider_1.GitRepositoryProvider)
    ], GitHistoryContribution.prototype, "repositoryProvider", void 0);
    __decorate([
        inversify_1.postConstruct(),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], GitHistoryContribution.prototype, "init", null);
    GitHistoryContribution = __decorate([
        inversify_1.injectable(),
        __metadata("design:paramtypes", [])
    ], GitHistoryContribution);
    return GitHistoryContribution;
}(browser_1.AbstractViewContribution));
exports.GitHistoryContribution = GitHistoryContribution;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-history-frontend-module.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-history-frontend-module.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var git_history_contribution_1 = __webpack_require__(/*! ./git-history-contribution */ "../node_modules/@theia/git/lib/browser/history/git-history-contribution.js");
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var git_history_widget_1 = __webpack_require__(/*! ./git-history-widget */ "../node_modules/@theia/git/lib/browser/history/git-history-widget.js");
var git_commit_detail_widget_1 = __webpack_require__(/*! ./git-commit-detail-widget */ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-widget.js");
var git_avatar_service_1 = __webpack_require__(/*! ./git-avatar-service */ "../node_modules/@theia/git/lib/browser/history/git-avatar-service.js");
__webpack_require__(/*! ../../../src/browser/style/history.css */ "../node_modules/@theia/git/src/browser/style/history.css");
__webpack_require__(/*! ../../../src/browser/style/git-icons.css */ "../node_modules/@theia/git/src/browser/style/git-icons.css");
var git_commit_detail_open_handler_1 = __webpack_require__(/*! ./git-commit-detail-open-handler */ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-open-handler.js");
function bindGitHistoryModule(bind) {
    bind(git_avatar_service_1.GitAvatarService).toSelf().inSingletonScope();
    bind(git_history_widget_1.GitHistoryWidget).toSelf();
    bind(browser_1.WidgetFactory).toDynamicValue(function (ctx) { return ({
        id: git_history_contribution_1.GIT_HISTORY,
        createWidget: function () { return ctx.container.get(git_history_widget_1.GitHistoryWidget); }
    }); });
    bind(browser_1.WidgetFactory).toDynamicValue(function (ctx) { return ({
        id: git_commit_detail_widget_1.GIT_COMMIT_DETAIL,
        createWidget: function (options) {
            var child = new inversify_1.Container({ defaultScope: 'Singleton' });
            child.parent = ctx.container;
            child.bind(git_commit_detail_widget_1.GitCommitDetailWidget).toSelf();
            child.bind(git_commit_detail_widget_1.GitCommitDetailWidgetOptions).toConstantValue(options);
            return child.get(git_commit_detail_widget_1.GitCommitDetailWidget);
        }
    }); });
    bind(git_commit_detail_open_handler_1.GitCommitDetailOpenHandler).toSelf();
    bind(browser_1.OpenHandler).toDynamicValue(function (ctx) { return ctx.container.get(git_commit_detail_open_handler_1.GitCommitDetailOpenHandler); });
    browser_1.bindViewContribution(bind, git_history_contribution_1.GitHistoryContribution);
}
exports.bindGitHistoryModule = bindGitHistoryModule;


/***/ }),

/***/ "../node_modules/@theia/git/lib/browser/history/git-history-widget.js":
/*!****************************************************************************!*\
  !*** ../node_modules/@theia/git/lib/browser/history/git-history-widget.js ***!
  \****************************************************************************/
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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var diff_uris_1 = __webpack_require__(/*! @theia/core/lib/browser/diff-uris */ "../node_modules/@theia/core/lib/browser/diff-uris.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var cancellation_1 = __webpack_require__(/*! @theia/core/lib/common/cancellation */ "../node_modules/@theia/core/lib/common/cancellation.js");
var react_virtualized_1 = __webpack_require__(/*! react-virtualized */ "../node_modules/react-virtualized/dist/es/index.js");
var git_resource_1 = __webpack_require__(/*! ../git-resource */ "../node_modules/@theia/git/lib/browser/git-resource.js");
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var git_history_contribution_1 = __webpack_require__(/*! ./git-history-contribution */ "../node_modules/@theia/git/lib/browser/history/git-history-contribution.js");
var common_1 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/git/lib/common/index.js");
var common_2 = __webpack_require__(/*! @theia/filesystem/lib/common */ "../node_modules/@theia/filesystem/lib/common/index.js");
var git_diff_contribution_1 = __webpack_require__(/*! ../diff/git-diff-contribution */ "../node_modules/@theia/git/lib/browser/diff/git-diff-contribution.js");
var git_avatar_service_1 = __webpack_require__(/*! ./git-avatar-service */ "../node_modules/@theia/git/lib/browser/history/git-avatar-service.js");
var git_commit_detail_open_handler_1 = __webpack_require__(/*! ./git-commit-detail-open-handler */ "../node_modules/@theia/git/lib/browser/history/git-commit-detail-open-handler.js");
var git_navigable_list_widget_1 = __webpack_require__(/*! ../git-navigable-list-widget */ "../node_modules/@theia/git/lib/browser/git-navigable-list-widget.js");
var git_widget_1 = __webpack_require__(/*! ../git-widget */ "../node_modules/@theia/git/lib/browser/git-widget.js");
var React = __webpack_require__(/*! react */ "../node_modules/react/index.js");
var GitCommitNode;
(function (GitCommitNode) {
    function is(node) {
        return !!node && 'commitSha' in node && 'commitMessage' in node && 'fileChangeNodes' in node;
    }
    GitCommitNode.is = is;
})(GitCommitNode = exports.GitCommitNode || (exports.GitCommitNode = {}));
var GitHistoryWidget = /** @class */ (function (_super) {
    __extends(GitHistoryWidget, _super);
    function GitHistoryWidget(openerService, detailOpenHandler, shell, fileSystem, git, avatarService, widgetManager, diffContribution) {
        var _this = _super.call(this) || this;
        _this.openerService = openerService;
        _this.detailOpenHandler = detailOpenHandler;
        _this.shell = shell;
        _this.fileSystem = fileSystem;
        _this.git = git;
        _this.avatarService = avatarService;
        _this.widgetManager = widgetManager;
        _this.diffContribution = diffContribution;
        _this.handleScroll = function (info) { return _this.doHandleScroll(info); };
        _this.loadMoreRows = function (params) { return _this.doLoadMoreRows(params); };
        _this.renderCommit = function (commit) { return _this.doRenderCommit(commit); };
        _this.renderFileChangeList = function (fileChange) { return _this.doRenderFileChangeList(fileChange); };
        _this.id = git_history_contribution_1.GIT_HISTORY;
        _this.scrollContainer = 'git-history-list-container';
        _this.title.label = 'Git History';
        _this.title.caption = 'Git History';
        _this.title.iconClass = 'fa git-history-tab-icon';
        _this.addClass('theia-git');
        _this.resetState();
        _this.cancelIndicator = new cancellation_1.CancellationTokenSource();
        return _this;
    }
    GitHistoryWidget.prototype.onAfterAttach = function (msg) {
        var _this = this;
        _super.prototype.onAfterAttach.call(this, msg);
        this.addGitListNavigationKeyListeners(this.node);
        this.addEventListener(this.node, 'ps-scroll-y', function (e) {
            if (_this.listView && _this.listView.list && _this.listView.list.Grid) {
                var scrollTop = e.target.scrollTop;
                _this.listView.list.Grid.handleScrollEvent({ scrollTop: scrollTop });
            }
        });
    };
    GitHistoryWidget.prototype.update = function () {
        if (this.listView && this.listView.list) {
            this.listView.list.forceUpdateGrid();
        }
        _super.prototype.update.call(this);
    };
    GitHistoryWidget.prototype.setContent = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var fileStat;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        this.resetState(options);
                        this.ready = false;
                        if (!(options && options.uri)) return [3 /*break*/, 2];
                        return [4 /*yield*/, this.fileSystem.getFileStat(options.uri)];
                    case 1:
                        fileStat = _a.sent();
                        this.singleFileMode = !!fileStat && !fileStat.isDirectory;
                        _a.label = 2;
                    case 2: return [4 /*yield*/, this.addCommits(options)];
                    case 3:
                        _a.sent();
                        this.onDataReady();
                        if (this.gitNodes.length > 0) {
                            this.selectNode(this.gitNodes[0]);
                        }
                        return [2 /*return*/];
                }
            });
        });
    };
    GitHistoryWidget.prototype.resetState = function (options) {
        this.options = options || {};
        this.commits = [];
        this.gitNodes = [];
        this.hasMoreCommits = true;
        this.allowScrollToSelected = true;
    };
    GitHistoryWidget.prototype.addCommits = function (options) {
        return __awaiter(this, void 0, void 0, function () {
            var repository, resolver, token, log;
            var _this = this;
            return __generator(this, function (_a) {
                repository = this.repositoryProvider.findRepositoryOrSelected(options);
                this.errorMessage = undefined;
                this.cancelIndicator.cancel();
                this.cancelIndicator = new cancellation_1.CancellationTokenSource();
                token = this.cancelIndicator.token;
                if (repository) {
                    log = this.git.log(repository, options);
                    log.catch(function (reason) {
                        _this.errorMessage = reason.message;
                        resolver();
                    });
                    log.then(function (changes) { return __awaiter(_this, void 0, void 0, function () {
                        var e_1, _a, _b, commits, changes_1, changes_1_1, commit, fileChangeNodes, avatarUrl, e_1_1, pathIsUnderVersionControl;
                        return __generator(this, function (_c) {
                            switch (_c.label) {
                                case 0:
                                    if (token.isCancellationRequested || !this.hasMoreCommits) {
                                        return [2 /*return*/];
                                    }
                                    if (options && ((options.maxCount && changes.length < options.maxCount) || (!options.maxCount && this.commits))) {
                                        this.hasMoreCommits = false;
                                    }
                                    if (this.commits.length > 0) {
                                        changes = changes.slice(1);
                                    }
                                    if (!(changes.length > 0)) return [3 /*break*/, 9];
                                    commits = [];
                                    _c.label = 1;
                                case 1:
                                    _c.trys.push([1, 6, 7, 8]);
                                    changes_1 = __values(changes), changes_1_1 = changes_1.next();
                                    _c.label = 2;
                                case 2:
                                    if (!!changes_1_1.done) return [3 /*break*/, 5];
                                    commit = changes_1_1.value;
                                    fileChangeNodes = [];
                                    return [4 /*yield*/, this.avatarService.getAvatar(commit.author.email)];
                                case 3:
                                    avatarUrl = _c.sent();
                                    commits.push({
                                        authorName: commit.author.name,
                                        authorDate: new Date(commit.author.timestamp),
                                        authorEmail: commit.author.email,
                                        authorDateRelative: commit.authorDateRelative,
                                        authorAvatar: avatarUrl,
                                        commitSha: commit.sha,
                                        commitMessage: commit.summary,
                                        messageBody: commit.body,
                                        fileChangeNodes: fileChangeNodes,
                                        fileChanges: commit.fileChanges,
                                        expanded: false,
                                        selected: false
                                    });
                                    _c.label = 4;
                                case 4:
                                    changes_1_1 = changes_1.next();
                                    return [3 /*break*/, 2];
                                case 5: return [3 /*break*/, 8];
                                case 6:
                                    e_1_1 = _c.sent();
                                    e_1 = { error: e_1_1 };
                                    return [3 /*break*/, 8];
                                case 7:
                                    try {
                                        if (changes_1_1 && !changes_1_1.done && (_a = changes_1.return)) _a.call(changes_1);
                                    }
                                    finally { if (e_1) throw e_1.error; }
                                    return [7 /*endfinally*/];
                                case 8:
                                    (_b = this.commits).push.apply(_b, __spread(commits));
                                    return [3 /*break*/, 11];
                                case 9:
                                    if (!(options && options.uri && repository)) return [3 /*break*/, 11];
                                    return [4 /*yield*/, this.git.lsFiles(repository, options.uri, { errorUnmatch: true })];
                                case 10:
                                    pathIsUnderVersionControl = _c.sent();
                                    if (!pathIsUnderVersionControl) {
                                        this.errorMessage = React.createElement(React.Fragment, null, "It is not under version control.");
                                    }
                                    _c.label = 11;
                                case 11:
                                    resolver();
                                    return [2 /*return*/];
                            }
                        });
                    }); });
                }
                else {
                    setTimeout(function () {
                        _this.commits = [];
                        _this.errorMessage = React.createElement(React.Fragment, null, "There is no repository selected in this workspace.");
                        resolver();
                    });
                }
                return [2 /*return*/, new Promise(function (resolve) { return resolver = resolve; })];
            });
        });
    };
    GitHistoryWidget.prototype.addOrRemoveFileChangeNodes = function (commit) {
        return __awaiter(this, void 0, void 0, function () {
            var id;
            return __generator(this, function (_a) {
                id = this.gitNodes.findIndex(function (node) { return node === commit; });
                if (commit.expanded) {
                    this.removeFileChangeNodes(commit, id);
                }
                else {
                    this.addFileChangeNodes(commit, id);
                }
                commit.expanded = !commit.expanded;
                this.update();
                return [2 /*return*/];
            });
        });
    };
    GitHistoryWidget.prototype.addFileChangeNodes = function (commit, gitNodesArrayIndex) {
        return __awaiter(this, void 0, void 0, function () {
            var _a, fileChangeNodes_1;
            var _this = this;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        if (!commit.fileChanges) return [3 /*break*/, 2];
                        fileChangeNodes_1 = [];
                        return [4 /*yield*/, Promise.all(commit.fileChanges.map(function (fileChange) { return __awaiter(_this, void 0, void 0, function () {
                                var fileChangeUri, icon, label, description, caption;
                                return __generator(this, function (_a) {
                                    switch (_a.label) {
                                        case 0:
                                            fileChangeUri = new uri_1.default(fileChange.uri);
                                            return [4 /*yield*/, this.labelProvider.getIcon(fileChangeUri)];
                                        case 1:
                                            icon = _a.sent();
                                            label = this.labelProvider.getName(fileChangeUri);
                                            description = this.relativePath(fileChangeUri.parent);
                                            caption = this.computeCaption(fileChange);
                                            fileChangeNodes_1.push(__assign({}, fileChange, { icon: icon, label: label, description: description, caption: caption, commitSha: commit.commitSha }));
                                            return [2 /*return*/];
                                    }
                                });
                            }); }))];
                    case 1:
                        _b.sent();
                        (_a = this.gitNodes).splice.apply(_a, __spread([gitNodesArrayIndex + 1, 0], fileChangeNodes_1));
                        _b.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    GitHistoryWidget.prototype.removeFileChangeNodes = function (commit, gitNodesArrayIndex) {
        if (commit.fileChanges) {
            this.gitNodes.splice(gitNodesArrayIndex + 1, commit.fileChanges.length);
        }
    };
    GitHistoryWidget.prototype.storeState = function () {
        var _a = this, options = _a.options, singleFileMode = _a.singleFileMode;
        return {
            options: options,
            singleFileMode: singleFileMode
        };
    };
    // tslint:disable-next-line:no-any
    GitHistoryWidget.prototype.restoreState = function (oldState) {
        this.options = oldState['options'];
        this.singleFileMode = oldState['singleFileMode'];
        this.setContent(this.options);
    };
    GitHistoryWidget.prototype.onDataReady = function () {
        this.ready = true;
        this.gitNodes = this.commits;
        this.update();
    };
    GitHistoryWidget.prototype.render = function () {
        var content;
        if (this.ready && this.gitNodes.length > 0) {
            content = React.createElement(React.Fragment, null,
                this.renderHistoryHeader(),
                this.renderCommitList());
        }
        else if (this.errorMessage) {
            var path = '';
            var reason = void 0;
            reason = this.errorMessage;
            if (this.options.uri) {
                var relPath = this.relativePath(this.options.uri);
                var repo = this.repositoryProvider.findRepository(new uri_1.default(this.options.uri));
                var repoName = repo ? " in " + new uri_1.default(repo.localUri).displayName : '';
                path = React.createElement(React.Fragment, null,
                    " for ",
                    React.createElement("i", null,
                        "/",
                        decodeURIComponent(relPath)),
                    repoName);
            }
            content = React.createElement("div", { className: 'message-container' },
                React.createElement("div", { className: 'no-history-message' },
                    React.createElement("div", null,
                        "There is no Git history available",
                        path,
                        "."),
                    React.createElement("div", null, reason)));
        }
        else {
            content = React.createElement("div", { className: 'spinnerContainer' },
                React.createElement("span", { className: 'fa fa-spinner fa-pulse fa-3x fa-fw' }));
        }
        return React.createElement("div", { className: 'git-diff-container' }, content);
    };
    GitHistoryWidget.prototype.renderHistoryHeader = function () {
        if (this.options.uri) {
            var path = this.relativePath(this.options.uri);
            return React.createElement("div", { className: 'diff-header' },
                this.renderHeaderRow({ name: 'repository', value: this.getRepositoryLabel(this.options.uri) }),
                this.renderHeaderRow({ name: 'path', value: path }),
                React.createElement("div", { className: 'theia-header' }, "Commits"));
        }
    };
    GitHistoryWidget.prototype.renderCommitList = function () {
        var _this = this;
        var list = React.createElement("div", { className: 'listContainer', id: this.scrollContainer },
            React.createElement(GitHistoryList, { ref: function (listView) { return _this.listView = (listView || undefined); }, rows: this.gitNodes, hasMoreRows: this.hasMoreCommits, indexOfSelected: this.allowScrollToSelected ? this.indexOfSelected : -1, handleScroll: this.handleScroll, loadMoreRows: this.loadMoreRows, renderCommit: this.renderCommit, renderFileChangeList: this.renderFileChangeList }));
        this.allowScrollToSelected = true;
        return list;
    };
    GitHistoryWidget.prototype.doHandleScroll = function (info) {
        this.node.scrollTo({ top: info.scrollTop });
    };
    GitHistoryWidget.prototype.doLoadMoreRows = function (params) {
        var _this = this;
        var resolver;
        var promise = new Promise(function (resolve) { return resolver = resolve; });
        var lastRow = this.gitNodes[params.stopIndex - 1];
        if (GitCommitNode.is(lastRow)) {
            var toRevision = lastRow.commitSha;
            this.addCommits({
                range: { toRevision: toRevision },
                maxCount: git_history_contribution_1.GIT_HISTORY_MAX_COUNT,
                uri: this.options.uri
            }).then(function () {
                _this.allowScrollToSelected = false;
                _this.onDataReady();
                resolver();
            });
        }
        return promise;
    };
    GitHistoryWidget.prototype.doRenderCommit = function (commit) {
        var _this = this;
        var expansionToggleIcon = 'caret-right';
        if (commit && commit.expanded) {
            expansionToggleIcon = 'caret-down';
        }
        return React.createElement("div", { className: "containerHead" + (commit.selected ? ' ' + browser_1.SELECTED_CLASS : ''), onClick: function (e) {
                if (commit.selected && !_this.singleFileMode) {
                    _this.addOrRemoveFileChangeNodes(commit);
                    _this.update();
                }
                else {
                    _this.selectNode(commit);
                }
                e.preventDefault();
            }, onDoubleClick: function (e) {
                if (_this.singleFileMode && commit.fileChanges && commit.fileChanges.length > 0) {
                    _this.openFile(commit.fileChanges[0], commit.commitSha);
                }
                e.preventDefault();
            } },
            React.createElement("div", { className: 'headContent' },
                React.createElement("div", { className: 'image-container' },
                    React.createElement("img", { className: 'gravatar', src: commit.authorAvatar })),
                React.createElement("div", { className: "headLabelContainer" + (this.singleFileMode ? ' singleFileMode' : '') },
                    React.createElement("div", { className: 'headLabel noWrapInfo noselect' }, commit.commitMessage),
                    React.createElement("div", { className: 'commitTime noWrapInfo noselect' }, commit.authorDateRelative + ' by ' + commit.authorName)),
                React.createElement("div", { className: 'fa fa-eye detailButton', onClick: function () { return _this.openDetailWidget(commit); } }),
                !this.singleFileMode ? React.createElement("div", { className: 'expansionToggle noselect' },
                    React.createElement("div", { className: 'toggle' },
                        React.createElement("div", { className: 'number' }, (commit.fileChanges && commit.fileChanges.length || commit.fileChangeNodes.length).toString()),
                        React.createElement("div", { className: 'icon fa fa-' + expansionToggleIcon })))
                    : ''));
    };
    GitHistoryWidget.prototype.openDetailWidget = function (commit) {
        return __awaiter(this, void 0, void 0, function () {
            var commitDetails;
            return __generator(this, function (_a) {
                commitDetails = this.detailOpenHandler.getCommitDetailWidgetOptions(commit);
                this.detailOpenHandler.open(git_commit_detail_open_handler_1.GitCommitDetailUri.toUri(commit.commitSha), __assign({}, commitDetails));
                return [2 /*return*/];
            });
        });
    };
    GitHistoryWidget.prototype.doRenderFileChangeList = function (fileChange) {
        var fileChangeElement = this.renderGitItem(fileChange, fileChange.commitSha || '');
        return fileChangeElement;
    };
    GitHistoryWidget.prototype.renderGitItem = function (change, commitSha) {
        var _this = this;
        return React.createElement("div", { key: change.uri.toString(), className: "gitItem noselect" + (change.selected ? ' ' + browser_1.SELECTED_CLASS : '') },
            React.createElement("div", { title: change.caption, className: 'noWrapInfo', onDoubleClick: function () {
                    _this.openFile(change, commitSha);
                }, onClick: function () {
                    _this.selectNode(change);
                } },
                React.createElement("span", { className: change.icon + ' file-icon' }),
                React.createElement("span", { className: 'name' }, change.label + ' '),
                React.createElement("span", { className: 'path' }, change.description)),
            change.extraIconClassName ? React.createElement("div", { title: change.caption, className: change.extraIconClassName })
                : '',
            React.createElement("div", { title: change.caption, className: 'status staged ' + common_1.GitFileStatus[change.status].toLowerCase() }, this.getStatusCaption(change.status, true).charAt(0)));
    };
    GitHistoryWidget.prototype.navigateLeft = function () {
        var selected = this.getSelected();
        if (selected) {
            var idx = this.commits.findIndex(function (c) { return c.commitSha === selected.commitSha; });
            if (GitCommitNode.is(selected)) {
                if (selected.expanded) {
                    this.addOrRemoveFileChangeNodes(selected);
                }
                else {
                    if (idx > 0) {
                        this.selectNode(this.commits[idx - 1]);
                    }
                }
            }
            else if (git_widget_1.GitFileChangeNode.is(selected)) {
                this.selectNode(this.commits[idx]);
            }
        }
        this.update();
    };
    GitHistoryWidget.prototype.navigateRight = function () {
        var selected = this.getSelected();
        if (selected) {
            if (GitCommitNode.is(selected) && !selected.expanded && !this.singleFileMode) {
                this.addOrRemoveFileChangeNodes(selected);
            }
            else {
                this.selectNextNode();
            }
        }
        this.update();
    };
    GitHistoryWidget.prototype.handleListEnter = function () {
        var selected = this.getSelected();
        if (selected) {
            if (GitCommitNode.is(selected)) {
                if (this.singleFileMode) {
                    this.openFile(selected.fileChangeNodes[0], selected.commitSha);
                }
                else {
                    this.openDetailWidget(selected);
                }
            }
            else if (git_widget_1.GitFileChangeNode.is(selected)) {
                this.openFile(selected, selected.commitSha || '');
            }
        }
        this.update();
    };
    GitHistoryWidget.prototype.openFile = function (change, commitSha) {
        var uri = new uri_1.default(change.uri);
        var fromURI = change.oldUri ? new uri_1.default(change.oldUri) : uri; // set oldUri on renamed and copied
        fromURI = fromURI.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(commitSha + '~1');
        var toURI = uri.withScheme(git_resource_1.GIT_RESOURCE_SCHEME).withQuery(commitSha);
        var uriToOpen = uri;
        if (change.status === common_1.GitFileStatus.Deleted) {
            uriToOpen = fromURI;
        }
        else if (change.status === common_1.GitFileStatus.New) {
            uriToOpen = toURI;
        }
        else {
            uriToOpen = diff_uris_1.DiffUris.encode(fromURI, toURI, uri.displayName);
        }
        browser_1.open(this.openerService, uriToOpen, { mode: 'reveal' });
    };
    GitHistoryWidget = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_1.OpenerService)),
        __param(1, inversify_1.inject(git_commit_detail_open_handler_1.GitCommitDetailOpenHandler)),
        __param(2, inversify_1.inject(browser_1.ApplicationShell)),
        __param(3, inversify_1.inject(common_2.FileSystem)),
        __param(4, inversify_1.inject(common_1.Git)),
        __param(5, inversify_1.inject(git_avatar_service_1.GitAvatarService)),
        __param(6, inversify_1.inject(browser_1.WidgetManager)),
        __param(7, inversify_1.inject(git_diff_contribution_1.GitDiffContribution)),
        __metadata("design:paramtypes", [Object, git_commit_detail_open_handler_1.GitCommitDetailOpenHandler,
            browser_1.ApplicationShell, Object, Object, git_avatar_service_1.GitAvatarService,
            browser_1.WidgetManager,
            git_diff_contribution_1.GitDiffContribution])
    ], GitHistoryWidget);
    return GitHistoryWidget;
}(git_navigable_list_widget_1.GitNavigableListWidget));
exports.GitHistoryWidget = GitHistoryWidget;
var GitHistoryList = /** @class */ (function (_super) {
    __extends(GitHistoryList, _super);
    function GitHistoryList() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.commitHeight = 50;
        _this.fileChangeHeight = 21;
        _this.lastFileChangeHeight = 31;
        _this.checkIfRowIsLoaded = function (opts) { return _this.doCheckIfRowIsLoaded(opts); };
        _this.renderRow = function (_a) {
            var index = _a.index, key = _a.key, style = _a.style;
            if (_this.checkIfRowIsLoaded({ index: index })) {
                var row = _this.props.rows[index];
                if (GitCommitNode.is(row)) {
                    var head = _this.props.renderCommit(row);
                    return React.createElement("div", { key: key, style: style, className: "commitListElement" + (index === 0 ? ' first' : '') }, head);
                }
                else if (git_widget_1.GitFileChangeNode.is(row)) {
                    return React.createElement("div", { key: key, style: style, className: 'fileChangeListElement' }, _this.props.renderFileChangeList(row));
                }
            }
            else {
                return React.createElement("div", { key: key, style: style, className: "commitListElement" + (index === 0 ? ' first' : '') },
                    React.createElement("span", { className: 'fa fa-spinner fa-pulse fa-fw' }));
            }
        };
        _this.calcRowHeight = function (options) {
            var row = _this.props.rows[options.index];
            if (git_widget_1.GitFileChangeNode.is(row)) {
                var nextIsCommit = GitCommitNode.is(_this.props.rows[options.index + 1]);
                return nextIsCommit ? _this.lastFileChangeHeight : _this.fileChangeHeight;
            }
            return _this.commitHeight;
        };
        return _this;
    }
    GitHistoryList.prototype.doCheckIfRowIsLoaded = function (opts) {
        var row = this.props.rows[opts.index];
        return !!row;
    };
    GitHistoryList.prototype.render = function () {
        var _this = this;
        return React.createElement(react_virtualized_1.InfiniteLoader, { isRowLoaded: this.checkIfRowIsLoaded, loadMoreRows: this.props.loadMoreRows, rowCount: this.props.rows.length + 1, threshold: 15 }, function (_a) {
            var onRowsRendered = _a.onRowsRendered, registerChild = _a.registerChild;
            return (React.createElement(react_virtualized_1.AutoSizer, null, function (_a) {
                var width = _a.width, height = _a.height;
                return React.createElement(react_virtualized_1.List, { className: 'commitList', ref: function (list) {
                        _this.list = (list || undefined);
                        registerChild(list);
                    }, width: width, height: height, onRowsRendered: onRowsRendered, rowRenderer: _this.renderRow, rowHeight: _this.calcRowHeight, rowCount: _this.props.hasMoreRows ? _this.props.rows.length + 1 : _this.props.rows.length, tabIndex: -1, onScroll: _this.props.handleScroll, scrollToIndex: _this.props.indexOfSelected, style: {
                        overflowY: 'visible',
                        overflowX: 'visible'
                    } });
            }));
        });
    };
    GitHistoryList.prototype.componentDidUpdate = function () {
        if (this.list) {
            this.list.recomputeRowHeights(this.props.indexOfSelected);
        }
    };
    return GitHistoryList;
}(React.Component));
exports.GitHistoryList = GitHistoryList;


/***/ }),

/***/ "../node_modules/@theia/git/lib/common/git-model.js":
/*!**********************************************************!*\
  !*** ../node_modules/@theia/git/lib/common/git-model.js ***!
  \**********************************************************/
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
var uri_1 = __webpack_require__(/*! @theia/core/lib/common/uri */ "../node_modules/@theia/core/lib/common/uri.js");
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var WorkingDirectoryStatus;
(function (WorkingDirectoryStatus) {
    /**
     * `true` if the directory statuses are deep equal, otherwise `false`.
     */
    function equals(left, right) {
        if (left && right) {
            return left.exists === right.exists
                && left.branch === right.branch
                && left.upstreamBranch === right.upstreamBranch
                && left.currentHead === right.currentHead
                && (left.aheadBehind ? left.aheadBehind.ahead : -1) === (right.aheadBehind ? right.aheadBehind.ahead : -1)
                && (left.aheadBehind ? left.aheadBehind.behind : -1) === (right.aheadBehind ? right.aheadBehind.behind : -1)
                && left.changes.length === right.changes.length
                && !!left.incomplete === !!right.incomplete
                && JSON.stringify(left) === JSON.stringify(right);
        }
        else {
            return left === right;
        }
    }
    WorkingDirectoryStatus.equals = equals;
})(WorkingDirectoryStatus = exports.WorkingDirectoryStatus || (exports.WorkingDirectoryStatus = {}));
/**
 * Enumeration of states that a file resource can have in the working directory.
 */
var GitFileStatus;
(function (GitFileStatus) {
    GitFileStatus[GitFileStatus["New"] = 0] = "New";
    GitFileStatus[GitFileStatus["Copied"] = 1] = "Copied";
    GitFileStatus[GitFileStatus["Modified"] = 2] = "Modified";
    GitFileStatus[GitFileStatus["Renamed"] = 3] = "Renamed";
    GitFileStatus[GitFileStatus["Deleted"] = 4] = "Deleted";
    GitFileStatus[GitFileStatus["Conflicted"] = 5] = "Conflicted";
})(GitFileStatus = exports.GitFileStatus || (exports.GitFileStatus = {}));
(function (GitFileStatus) {
    /**
     * Compares the statuses based on the natural order of the enumeration.
     */
    GitFileStatus.statusCompare = function (left, right) { return left - right; };
    /**
     * Returns with human readable representation of the Git file status argument. If the `staged` argument is `undefined`,
     * it will be treated as `false`.
     */
    GitFileStatus.toString = function (status, staged) {
        switch (status) {
            case GitFileStatus.New: return !!staged ? 'Added' : 'Unstaged';
            case GitFileStatus.Renamed: return 'Renamed';
            case GitFileStatus.Copied: return 'Copied';
            case GitFileStatus.Modified: return 'Modified';
            case GitFileStatus.Deleted: return 'Deleted';
            case GitFileStatus.Conflicted: return 'Conflicted';
            default: throw new Error("Unexpected Git file stats: " + status + ".");
        }
    };
    /**
     * Returns with the human readable abbreviation of the Git file status argument. `staged` argument defaults to `false`.
     */
    GitFileStatus.toAbbreviation = function (status, staged) { return GitFileStatus.toString(status, staged).charAt(0); };
})(GitFileStatus = exports.GitFileStatus || (exports.GitFileStatus = {}));
var Repository;
(function (Repository) {
    function equal(repository, repository2) {
        if (repository && repository2) {
            return repository.localUri === repository2.localUri;
        }
        return repository === repository2;
    }
    Repository.equal = equal;
    function is(repository) {
        return !!repository && 'localUri' in repository;
    }
    Repository.is = is;
    function relativePath(repository, uri) {
        var repositoryUri = new uri_1.default(Repository.is(repository) ? repository.localUri : repository);
        return new core_1.Path(uri.toString().substr(repositoryUri.toString().length + 1));
    }
    Repository.relativePath = relativePath;
    Repository.sortComparator = function (ra, rb) { return rb.localUri.length - ra.localUri.length; };
})(Repository = exports.Repository || (exports.Repository = {}));
/**
 * The branch type. Either local or remote.
 * The order matters.
 */
var BranchType;
(function (BranchType) {
    /**
     * The local branch type.
     */
    BranchType[BranchType["Local"] = 0] = "Local";
    /**
     * The remote branch type.
     */
    BranchType[BranchType["Remote"] = 1] = "Remote";
})(BranchType = exports.BranchType || (exports.BranchType = {}));
/**
 * The Git errors which can be parsed from failed Git commands.
 */
var GitError;
(function (GitError) {
    GitError[GitError["SSHKeyAuditUnverified"] = 0] = "SSHKeyAuditUnverified";
    GitError[GitError["SSHAuthenticationFailed"] = 1] = "SSHAuthenticationFailed";
    GitError[GitError["SSHPermissionDenied"] = 2] = "SSHPermissionDenied";
    GitError[GitError["HTTPSAuthenticationFailed"] = 3] = "HTTPSAuthenticationFailed";
    GitError[GitError["RemoteDisconnection"] = 4] = "RemoteDisconnection";
    GitError[GitError["HostDown"] = 5] = "HostDown";
    GitError[GitError["RebaseConflicts"] = 6] = "RebaseConflicts";
    GitError[GitError["MergeConflicts"] = 7] = "MergeConflicts";
    GitError[GitError["HTTPSRepositoryNotFound"] = 8] = "HTTPSRepositoryNotFound";
    GitError[GitError["SSHRepositoryNotFound"] = 9] = "SSHRepositoryNotFound";
    GitError[GitError["PushNotFastForward"] = 10] = "PushNotFastForward";
    GitError[GitError["BranchDeletionFailed"] = 11] = "BranchDeletionFailed";
    GitError[GitError["DefaultBranchDeletionFailed"] = 12] = "DefaultBranchDeletionFailed";
    GitError[GitError["RevertConflicts"] = 13] = "RevertConflicts";
    GitError[GitError["EmptyRebasePatch"] = 14] = "EmptyRebasePatch";
    GitError[GitError["NoMatchingRemoteBranch"] = 15] = "NoMatchingRemoteBranch";
    GitError[GitError["NothingToCommit"] = 16] = "NothingToCommit";
    GitError[GitError["NoSubmoduleMapping"] = 17] = "NoSubmoduleMapping";
    GitError[GitError["SubmoduleRepositoryDoesNotExist"] = 18] = "SubmoduleRepositoryDoesNotExist";
    GitError[GitError["InvalidSubmoduleSHA"] = 19] = "InvalidSubmoduleSHA";
    GitError[GitError["LocalPermissionDenied"] = 20] = "LocalPermissionDenied";
    GitError[GitError["InvalidMerge"] = 21] = "InvalidMerge";
    GitError[GitError["InvalidRebase"] = 22] = "InvalidRebase";
    GitError[GitError["NonFastForwardMergeIntoEmptyHead"] = 23] = "NonFastForwardMergeIntoEmptyHead";
    GitError[GitError["PatchDoesNotApply"] = 24] = "PatchDoesNotApply";
    GitError[GitError["BranchAlreadyExists"] = 25] = "BranchAlreadyExists";
    GitError[GitError["BadRevision"] = 26] = "BadRevision";
    GitError[GitError["NotAGitRepository"] = 27] = "NotAGitRepository";
    GitError[GitError["CannotMergeUnrelatedHistories"] = 28] = "CannotMergeUnrelatedHistories";
    GitError[GitError["LFSAttributeDoesNotMatch"] = 29] = "LFSAttributeDoesNotMatch";
    GitError[GitError["BranchRenameFailed"] = 30] = "BranchRenameFailed";
    GitError[GitError["PathDoesNotExist"] = 31] = "PathDoesNotExist";
    GitError[GitError["InvalidObjectName"] = 32] = "InvalidObjectName";
    GitError[GitError["OutsideRepository"] = 33] = "OutsideRepository";
    GitError[GitError["LockFileAlreadyExists"] = 34] = "LockFileAlreadyExists";
    // GitHub-specific error codes
    GitError[GitError["PushWithFileSizeExceedingLimit"] = 35] = "PushWithFileSizeExceedingLimit";
    GitError[GitError["HexBranchNameRejected"] = 36] = "HexBranchNameRejected";
    GitError[GitError["ForcePushRejected"] = 37] = "ForcePushRejected";
    GitError[GitError["InvalidRefLength"] = 38] = "InvalidRefLength";
    GitError[GitError["ProtectedBranchRequiresReview"] = 39] = "ProtectedBranchRequiresReview";
    GitError[GitError["ProtectedBranchForcePush"] = 40] = "ProtectedBranchForcePush";
    GitError[GitError["ProtectedBranchDeleteRejected"] = 41] = "ProtectedBranchDeleteRejected";
    GitError[GitError["ProtectedBranchRequiredStatus"] = 42] = "ProtectedBranchRequiredStatus";
    GitError[GitError["PushWithPrivateEmail"] = 43] = "PushWithPrivateEmail";
})(GitError = exports.GitError || (exports.GitError = {}));


/***/ }),

/***/ "../node_modules/@theia/git/lib/common/git-watcher.js":
/*!************************************************************!*\
  !*** ../node_modules/@theia/git/lib/common/git-watcher.js ***!
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
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var GitStatusChangeEvent;
(function (GitStatusChangeEvent) {
    /**
     * `true` if the argument is a `GitStatusEvent`, otherwise `false`.
     * @param event the argument to check whether it is a Git status change event or not.
     */
    function is(event) {
        return !!event && ('source' in event) && ('status' in event);
    }
    GitStatusChangeEvent.is = is;
})(GitStatusChangeEvent = exports.GitStatusChangeEvent || (exports.GitStatusChangeEvent = {}));
/**
 * The symbol of the Git watcher backend for DI.
 */
exports.GitWatcherServer = Symbol('GitWatcherServer');
exports.GitWatcherServerProxy = Symbol('GitWatcherServerProxy');
var ReconnectingGitWatcherServer = /** @class */ (function () {
    function ReconnectingGitWatcherServer(proxy) {
        var _this = this;
        this.proxy = proxy;
        this.watcherSequence = 1;
        this.watchParams = new Map();
        this.localToRemoteWatcher = new Map();
        this.proxy.onDidOpenConnection(function () { return _this.reconnect(); });
    }
    ReconnectingGitWatcherServer.prototype.watchGitChanges = function (repository) {
        return __awaiter(this, void 0, void 0, function () {
            var watcher;
            return __generator(this, function (_a) {
                watcher = this.watcherSequence++;
                this.watchParams.set(watcher, repository);
                return [2 /*return*/, this.doWatchGitChanges([watcher, repository])];
            });
        });
    };
    ReconnectingGitWatcherServer.prototype.unwatchGitChanges = function (watcher) {
        return __awaiter(this, void 0, void 0, function () {
            var remote;
            return __generator(this, function (_a) {
                this.watchParams.delete(watcher);
                remote = this.localToRemoteWatcher.get(watcher);
                if (remote) {
                    this.localToRemoteWatcher.delete(remote);
                    return [2 /*return*/, this.proxy.unwatchGitChanges(remote)];
                }
                else {
                    throw new Error("No Git watchers were registered with ID: " + watcher + ".");
                }
                return [2 /*return*/];
            });
        });
    };
    ReconnectingGitWatcherServer.prototype.dispose = function () {
        this.proxy.dispose();
    };
    ReconnectingGitWatcherServer.prototype.setClient = function (client) {
        this.proxy.setClient(client);
    };
    ReconnectingGitWatcherServer.prototype.reconnect = function () {
        var _this = this;
        __spread(this.watchParams.entries()).forEach(function (entry) { return _this.doWatchGitChanges(entry); });
    };
    ReconnectingGitWatcherServer.prototype.doWatchGitChanges = function (entry) {
        return __awaiter(this, void 0, void 0, function () {
            var _a, watcher, repository, remote;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        _a = __read(entry, 2), watcher = _a[0], repository = _a[1];
                        return [4 /*yield*/, this.proxy.watchGitChanges(repository)];
                    case 1:
                        remote = _b.sent();
                        this.localToRemoteWatcher.set(watcher, remote);
                        return [2 /*return*/, watcher];
                }
            });
        });
    };
    ReconnectingGitWatcherServer = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(exports.GitWatcherServerProxy)),
        __metadata("design:paramtypes", [Object])
    ], ReconnectingGitWatcherServer);
    return ReconnectingGitWatcherServer;
}());
exports.ReconnectingGitWatcherServer = ReconnectingGitWatcherServer;
/**
 * Unique WS endpoint path to the Git watcher service.
 */
exports.GitWatcherPath = '/services/git-watcher';
var GitWatcher = /** @class */ (function () {
    function GitWatcher(server) {
        var _this = this;
        this.server = server;
        this.toDispose = new common_1.DisposableCollection();
        this.onGitEventEmitter = new common_1.Emitter();
        this.toDispose.push(this.onGitEventEmitter);
        this.server.setClient({ onGitChanged: function (e) { return _this.onGitChanged(e); } });
    }
    GitWatcher.prototype.dispose = function () {
        this.toDispose.dispose();
    };
    Object.defineProperty(GitWatcher.prototype, "onGitEvent", {
        get: function () {
            return this.onGitEventEmitter.event;
        },
        enumerable: true,
        configurable: true
    });
    GitWatcher.prototype.onGitChanged = function (event) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                this.onGitEventEmitter.fire(event);
                return [2 /*return*/];
            });
        });
    };
    GitWatcher.prototype.watchGitChanges = function (repository) {
        return __awaiter(this, void 0, void 0, function () {
            var watcher, toDispose;
            var _this = this;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.server.watchGitChanges(repository)];
                    case 1:
                        watcher = _a.sent();
                        toDispose = new common_1.DisposableCollection();
                        toDispose.push(common_1.Disposable.create(function () { return _this.server.unwatchGitChanges(watcher); }));
                        return [2 /*return*/, toDispose];
                }
            });
        });
    };
    GitWatcher = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(exports.GitWatcherServer)),
        __metadata("design:paramtypes", [Object])
    ], GitWatcher);
    return GitWatcher;
}());
exports.GitWatcher = GitWatcher;


/***/ }),

/***/ "../node_modules/@theia/git/lib/common/git.js":
/*!****************************************************!*\
  !*** ../node_modules/@theia/git/lib/common/git.js ***!
  \****************************************************/
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
var git_model_1 = __webpack_require__(/*! ./git-model */ "../node_modules/@theia/git/lib/common/git-model.js");
/**
 * The WS endpoint path to the Git service.
 */
exports.GitPath = '/services/git';
/**
 * Git symbol for DI.
 */
exports.Git = Symbol('Git');
/**
 * Contains a set of utility functions for [Git](#Git).
 */
var GitUtils;
(function (GitUtils) {
    /**
     * `true` if the argument is an option for renaming an existing branch in the repository.
     */
    // tslint:disable-next-line:no-any
    function isBranchRename(arg) {
        return !!arg && ('newName' in arg);
    }
    GitUtils.isBranchRename = isBranchRename;
    /**
     * `true` if the argument is an option for deleting an existing branch in the repository.
     */
    // tslint:disable-next-line:no-any
    function isBranchDelete(arg) {
        return !!arg && ('toDelete' in arg);
    }
    GitUtils.isBranchDelete = isBranchDelete;
    /**
     * `true` if the argument is an option for creating a new branch in the repository.
     */
    // tslint:disable-next-line:no-any
    function isBranchCreate(arg) {
        return !!arg && ('toCreate' in arg);
    }
    GitUtils.isBranchCreate = isBranchCreate;
    /**
     * `true` if the argument is an option for listing the branches in a repository.
     */
    // tslint:disable-next-line:no-any
    function isBranchList(arg) {
        return !!arg && ('type' in arg);
    }
    GitUtils.isBranchList = isBranchList;
    /**
     * `true` if the argument is an option for checking out a new local branch.
     */
    // tslint:disable-next-line:no-any
    function isBranchCheckout(arg) {
        return !!arg && ('branch' in arg);
    }
    GitUtils.isBranchCheckout = isBranchCheckout;
    /**
     * `true` if the argument is an option for checking out a working tree file.
     */
    // tslint:disable-next-line:no-any
    function isWorkingTreeFileCheckout(arg) {
        return !!arg && ('paths' in arg);
    }
    GitUtils.isWorkingTreeFileCheckout = isWorkingTreeFileCheckout;
    /**
     * The error code for when the path to a repository doesn't exist.
     */
    var RepositoryDoesNotExistErrorCode = 'repository-does-not-exist-error';
    /**
     * `true` if the argument is an error indicating the absence of a local Git repository.
     * Otherwise, `false`.
     */
    // tslint:disable-next-line:no-any
    function isRepositoryDoesNotExistError(error) {
        // TODO this is odd here.This piece of code is already implementation specific, so this should go to the Git API.
        // But how can we ensure that the `any` type error is serializable?
        if (error instanceof Error && ('code' in error)) {
            // tslint:disable-next-line:no-any
            return error.code === RepositoryDoesNotExistErrorCode;
        }
        return false;
    }
    GitUtils.isRepositoryDoesNotExistError = isRepositoryDoesNotExistError;
    /**
     * Maps the raw status text from Git to a Git file status enumeration.
     */
    function mapStatus(rawStatus) {
        var status = rawStatus.trim();
        if (status === 'M') {
            return git_model_1.GitFileStatus.Modified;
        } // modified
        if (status === 'A') {
            return git_model_1.GitFileStatus.New;
        } // added
        if (status === 'D') {
            return git_model_1.GitFileStatus.Deleted;
        } // deleted
        if (status === 'R') {
            return git_model_1.GitFileStatus.Renamed;
        } // renamed
        if (status === 'C') {
            return git_model_1.GitFileStatus.Copied;
        } // copied
        // git log -M --name-status will return a RXXX - where XXX is a percentage
        if (status.match(/R[0-9]+/)) {
            return git_model_1.GitFileStatus.Renamed;
        }
        // git log -C --name-status will return a CXXX - where XXX is a percentage
        if (status.match(/C[0-9]+/)) {
            return git_model_1.GitFileStatus.Copied;
        }
        return git_model_1.GitFileStatus.Modified;
    }
    GitUtils.mapStatus = mapStatus;
    /**
     * `true` if the argument is a raw Git status with similarity percentage. Otherwise, `false`.
     */
    function isSimilarityStatus(rawStatus) {
        return !!rawStatus.match(/R[0-9][0-9][0-9]/) || !!rawStatus.match(/C[0-9][0-9][0-9]/);
    }
    GitUtils.isSimilarityStatus = isSimilarityStatus;
})(GitUtils = exports.GitUtils || (exports.GitUtils = {}));


/***/ }),

/***/ "../node_modules/@theia/git/lib/common/index.js":
/*!******************************************************!*\
  !*** ../node_modules/@theia/git/lib/common/index.js ***!
  \******************************************************/
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
__export(__webpack_require__(/*! ./git */ "../node_modules/@theia/git/lib/common/git.js"));
__export(__webpack_require__(/*! ./git-model */ "../node_modules/@theia/git/lib/common/git-model.js"));
__export(__webpack_require__(/*! ./git-watcher */ "../node_modules/@theia/git/lib/common/git-watcher.js"));


/***/ }),

/***/ "../node_modules/@theia/git/src/browser/style/diff.css":
/*!*************************************************************!*\
  !*** ../node_modules/@theia/git/src/browser/style/diff.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./diff.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/diff.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/git/src/browser/style/dirty-diff.css":
/*!*******************************************************************!*\
  !*** ../node_modules/@theia/git/src/browser/style/dirty-diff.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./dirty-diff.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/dirty-diff.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/git/src/browser/style/git-icons.css":
/*!******************************************************************!*\
  !*** ../node_modules/@theia/git/src/browser/style/git-icons.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./git-icons.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/git-icons.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/git/src/browser/style/history.css":
/*!****************************************************************!*\
  !*** ../node_modules/@theia/git/src/browser/style/history.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./history.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/history.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/git/src/browser/style/index.css":
/*!**************************************************************!*\
  !*** ../node_modules/@theia/git/src/browser/style/index.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(/*! !../../../../../css-loader!./index.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/index.css");
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(/*! ../../../../../style-loader/addStyles.js */ "../node_modules/style-loader/addStyles.js")(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {}

/***/ }),

/***/ "../node_modules/@theia/navigator/lib/browser/index.js":
/*!*************************************************************!*\
  !*** ../node_modules/@theia/navigator/lib/browser/index.js ***!
  \*************************************************************/
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
__export(__webpack_require__(/*! ./navigator-model */ "../node_modules/@theia/navigator/lib/browser/navigator-model.js"));
__export(__webpack_require__(/*! ./navigator-widget */ "../node_modules/@theia/navigator/lib/browser/navigator-widget.js"));
__export(__webpack_require__(/*! ./navigator-decorator-service */ "../node_modules/@theia/navigator/lib/browser/navigator-decorator-service.js"));


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
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
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

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/diff.css":
/*!****************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/diff.css ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-git {\n    color: var(--theia-ui-font-color1);\n}\n\n.theia-git .git-diff-container {\n    display: flex;\n    flex-direction: column;\n    position: relative;\n    height: 100%;\n}\n\n.theia-git .revision .row-title {\n    width: 35px;\n    display: inline-block;\n}\n\n.theia-git .diff-header {\n    flex-shrink: 0;\n}\n\n.theia-git .header-row {\n    display: flex;\n    flex-direction: row; \n}\n\n.theia-git .header-value {\n    margin: 9px 0px 5px 5px;\n}\n\n.theia-git .gitItem.diff-file {\n    margin: 1px 0 !important;\n    padding: 0 !important;\n}\n\n.theia-git .gitItem.diff-file:hover {\n    background-color: inherit !important;\n    cursor: inherit !important;\n}\n\n.theia-git .lrBtns {\n    display:flex;\n    align-items: center;\n    margin-right: 2px;\n}\n\n.theia-git .lrBtns span {\n    display: inline-block;\n    margin-left: 10px;\n    cursor: pointer;\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/dirty-diff-decorator.css":
/*!********************************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/dirty-diff-decorator.css ***!
  \********************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/*---------------------------------------------------------------------------------------------\n *  Copyright (c) Microsoft Corporation. All rights reserved.\n *  Licensed under the MIT License. See License.txt in the project root for license information.\n *--------------------------------------------------------------------------------------------*/\n\n.dirty-diff-glyph {\n\tmargin-left: 5px;\n\tcursor: pointer;\n}\n\n.dirty-diff-removed-line:after {\n\tcontent: '';\n\tposition: absolute;\n\tbottom: -4px;\n\tbox-sizing: border-box;\n\twidth: 4px;\n\theight: 0;\n\tz-index: 9;\n\tborder-top: 4px solid transparent;\n\tborder-bottom: 4px solid transparent;\n\ttransition: border-top-width 80ms linear, border-bottom-width 80ms linear, bottom 80ms linear;\n}\n\n.dirty-diff-glyph:before {\n\tposition: absolute;\n\tcontent: '';\n\theight: 100%;\n\twidth: 0;\n\tleft: -2px;\n\ttransition: width 80ms linear, left 80ms linear;\n}\n\n.dirty-diff-removed-line:before {\n\tmargin-left: 3px;\n\theight: 0;\n\tbottom: 0;\n\ttransition: height 80ms linear;\n}\n\n.margin-view-overlays > div:hover > .dirty-diff-glyph:before {\n\tposition: absolute;\n\tcontent: '';\n\theight: 100%;\n\twidth: 9px;\n\tleft: -6px;\n}\n\n.margin-view-overlays > div:hover > .dirty-diff-removed-line:after {\n\tbottom: 0;\n\tborder-top-width: 0;\n\tborder-bottom-width: 0;\n}", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/dirty-diff.css":
/*!**********************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/dirty-diff.css ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports
exports.i(__webpack_require__(/*! -!../../../../../css-loader!./dirty-diff-decorator.css */ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/dirty-diff-decorator.css"), "");

// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.dirty-diff-added-line {\n\tborder-left: 3px solid var(--theia-added-color0);\n}\n.dirty-diff-added-line:before {\n\tbackground: var(--theia-added-color0);\n}\n\n.dirty-diff-removed-line:after {\n\tborder-left: 4px solid var(--theia-removed-color0);\n}\n.dirty-diff-removed-line:before {\n\tbackground: var(--theia-removed-color0);\n}\n\n.dirty-diff-modified-line {\n\tborder-left: 3px solid var(--theia-modified-color0);\n}\n.dirty-diff-modified-line:before {\n\tbackground: var(--theia-modified-color0);\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/git-icons.css":
/*!*********************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/git-icons.css ***!
  \*********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var escape = __webpack_require__(/*! ../../../../../css-loader/lib/url/escape.js */ "../node_modules/css-loader/lib/url/escape.js");
exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n \n.icon-git-commit {\n    mask-repeat: no-repeat;\n    mask-position: center;\n    background-color: var(--theia-ui-font-color1);\n    -webkit-mask-repeat: no-repeat;\n    -webkit-mask-position: center;\n    mask-image: url(" + escape(__webpack_require__(/*! octicons/build/svg/git-commit.svg */ "../node_modules/octicons/build/svg/git-commit.svg")) + ");\n    -webkit-mask-image: url(" + escape(__webpack_require__(/*! octicons/build/svg/git-commit.svg */ "../node_modules/octicons/build/svg/git-commit.svg")) + ");\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/history.css":
/*!*******************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/history.css ***!
  \*******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-git .commitListContainer .commitList .commitListElement {\n    margin: 3px 0;\n}\n\n.theia-git .commitListElement {\n    border-top: 1px solid var(--theia-layout-color4);\n}\n\n.theia-git .commitListElement.first {\n    border: none;\n}\n\n.theia-git .commitListElement .containerHead {\n    width: calc(100% - 5px);\n    height: 50px;\n    display: flex;\n    align-items: center;\n}\n\n.theia-git .commitListElement .containerHead:hover {\n    cursor: pointer;\n}\n\n.theia-git .commitListElement .containerHead .headContent {\n    display: flex;\n    width: 100%;\n    box-sizing: border-box;\n    padding: 0 8px 0 2px;\n}\n\n.theia-git .commitListElement .containerHead .headContent .image-container{\n    margin-right: 5px;\n}\n\n.theia-git .commitListElement .containerHead .headContent .image-container img{\n    width: 27px;\n}\n\n.theia-git .commitListElement .containerHead .headContent .headLabelContainer{\n    min-width: calc(100% - 93px);\n}\n\n.theia-git .commitListElement .containerHead .headContent .headLabelContainer.singleFileMode{\n    width: 100%;\n}\n\n.theia-git .commitListElement .containerHead .headContent .expansionToggle{\n    display: flex;\n    align-items: center;\n}\n\n.theia-git .commitListElement .containerHead .headContent .detailButton{\n    display: flex;\n    align-items: center;\n    visibility: hidden;\n    margin: 0 5px;\n}\n\n.theia-git .commitListElement .containerHead:hover .headContent .detailButton {\n    visibility: visible;\n}\n\n.theia-git .commitListElement .containerHead .headContent .expansionToggle > .toggle{\n    display: flex;\n    background: var(--theia-ui-expand-button-color);\n    padding: 5px;\n    border-radius: 7px;\n    margin-left: 5px;\n    align-items: center;\n    justify-content: flex-end;\n    min-width: 30px;\n    color: var(--theia-ui-expand-button-font-color);\n}\n\n.theia-git .commitBody {\n    padding-bottom: 10px;\n}\n\n.theia-git .commitFileList .theia-header {\n    margin-top: 5px;\n}\n\n.theia-git .commitTime {\n    color: var(--theia-ui-font-color2);\n    font-size: smaller;\n}\n\n.theia-git .git-diff-container .listContainer {\n    flex: 1;\n}\n\n.theia-git .git-diff-container .listContainer .commitList {\n    height: 100%;\n}\n\n.theia-git .git-diff-container .history-lazy-loading {\n    position: absolute;\n    height: 50px;\n    width: 100%;\n    bottom: -80px;\n    opacity: 0;\n    font-weight: bold;\n    justify-content: center;\n    align-items: center;\n    display: flex;\n    background: var(--theia-layout-color4);\n    border: var(--theia-border-width) var(--theia-border-color2) solid;\n    box-sizing: border-box;\n}\n\n.theia-git .git-diff-container .history-lazy-loading.show {\n    bottom: 0px;\n    opacity:0;\n    animation: showFrames ease-out 0.2s forwards;\n    -webkit-animation: showFrames ease-out 0.2s forwards;\n  }\n\n  @keyframes showFrames{\n    0% {\n      opacity:0;\n      bottom:-80px  ;\n    }\n    100% {\n      opacity:1;\n      bottom:0px;\n    }\n  }\n\n.theia-git .git-diff-container .history-lazy-loading.hide {\n    bottom: 80px;\n    opacity:1;\n    animation: hideFrames ease-out 0.2s forwards;\n    -webkit-animation: hideFrames ease-out 0.2s forwards;\n  }\n\n  @keyframes hideFrames{\n    0% {\n      opacity:1;\n      bottom:  0px  ;\n    }\n    100% {\n      opacity:0;\n      bottom: -80px  ;\n    }\n  }\n\n.theia-git .git-diff-container .subject {\n    font-size: var(--theia-ui-font-size2);\n    font-weight: bold;\n}\n\n.theia-git .git-diff-container .commit-info {\n    padding-left: 10px;\n    box-sizing: border-box;\n    overflow: hidden;\n}\n\n.theia-git .git-diff-container .commit-info-row {\n    align-items: center;\n    margin-top: 10px;\n}\n\n.theia-git .commit-info .header-row {\n    margin: 4px 0;\n}\n\n.theia-git .commit-info .header-row .theia-header {\n    margin: 1px 0;\n}\n\n.theia-git .commit-info .header-row .header-value {\n    margin: 0 0 0 5px;\n}\n\n.theia-git .commit-info-row .image-container {\n    display: flex;\n}\n\n.tab-git-icon {\n    width: 20px!important;\n    height: 20px;\n}\n\n.theia-git .no-history-message {\n    background-color: var(--theia-warn-color0) !important;\n    color: var(--theia-warn-font-color0);\n    padding: 5px;\n}\n\n.theia-git .no-history-message div {\n    margin: 5px;\n}\n\n.theia-git .message-container {\n    height: 100%;\n    display: flex;\n    align-items: flex-start;\n    justify-content: center;\n}\n\n.git-history-tab-icon::before {\n    content: \"\\F1DA\"\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/css-loader/index.js!../node_modules/@theia/git/src/browser/style/index.css":
/*!*****************************************************************************************!*\
  !*** ../node_modules/css-loader!../node_modules/@theia/git/src/browser/style/index.css ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../../css-loader/lib/css-base.js */ "../node_modules/css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/********************************************************************************\n * Copyright (C) 2018 TypeFox and others.\n *\n * This program and the accompanying materials are made available under the\n * terms of the Eclipse Public License v. 2.0 which is available at\n * http://www.eclipse.org/legal/epl-2.0.\n *\n * This Source Code may also be made available under the following Secondary\n * Licenses when the conditions for such availability set forth in the Eclipse\n * Public License v. 2.0 are satisfied: GNU General Public License, version 2\n * with the GNU Classpath Exception which is available at\n * https://www.gnu.org/software/classpath/license.html.\n *\n * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0\n ********************************************************************************/\n\n.theia-git {\n    color: var(--theia-ui-font-color1);\n    padding: 5px;\n    box-sizing: border-box;\n    background: var(--theia-layout-color0);\n}\n\n.theia-git:focus, .theia-git :focus {\n    outline: 0;\n    box-shadow: none;\n    border: none;\n}\n\n#theia-gitContainer .flexcontainer {\n    display: flex;\n}\n\n#theia-gitContainer .row {\n    width: 100%;\n    margin-bottom: 5px;\n}\n\n.theia-git .noWrapInfo {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    width: 100%;\n}\n\n.theia-git .space-between {\n    justify-content: space-between;\n}\n\n.theia-git .gitItem {\n    margin: 1px 0 1px 3px;\n    padding: 2px;\n    font-size: var(--theia-ui-font-size1);\n    display: flex;\n    justify-content: space-between;\n}\n\n.theia-git .gitItem .file-icon {\n    display: initial;\n}\n\n.theia-git .gitItem:hover {\n    background-color: var(--theia-layout-color2);\n    cursor: pointer;\n}\n\n.theia-git .gitItem .path {\n    color: var(--theia-ui-font-color2);\n    font-size: var(--theia-ui-font-size0);\n    margin-left: 3px;\n}\n\n.theia-git .gitItem .itemButtonsContainer {\n    display: flex;\n    justify-content: flex-end;\n    margin-left: 3px;\n}\n\n.theia-git .gitItem .status {\n    padding: 2px 4px;\n    font-size: var(--theia-ui-font-size0);\n}\n\n.theia-git .gitItem .status.new {\n    color: var(--theia-success-color0);\n}\n\n.theia-git .gitItem .status.new.staged {\n    color: var(--theia-success-color0);\n}\n\n.theia-git .gitItem .status.modified {\n    color: var(--theia-brand-color0);\n}\n\n.theia-git .gitItem .status.deleted {\n    color: var(--theia-warn-color0);\n}\n\n.theia-git .gitItem .status.renamed {\n    color: var(--theia-brand-color0);\n}\n\n.theia-git .gitItem .status.conflicted {\n    color: var(--theia-error-color0);\n}\n\n.theia-git .gitItem .status.copied {\n    color: var(--theia-brand-color0);\n}\n\n#theia-gitContainer .buttons {\n    display: flex;\n}\n\n#theia-gitContainer .buttons .toolbar-button {\n    margin: 0 2px;\n    cursor: pointer;\n    display: flex;\n    align-items: center;\n    padding: 3px 3px;\n}\n\n#theia-gitContainer .itemButtonsContainer .buttons .toolbar-button {\n    padding: 0 3px;\n}\n\n#theia-gitContainer .buttons .toolbar-button:hover {\n    background: var(--theia-content-font-color3);\n}\n\n#theia-gitContainer .buttons .toolbar-button .open-file {\n    height: 16px;\n    width: 12px;\n    background: var(--theia-icon-open-file) no-repeat center center;\n}\n\n#theia-gitContainer .gitItem .itemButtonsContainer .buttons {\n    display: none;\n    margin: 0 3px;\n}\n\n#theia-gitContainer .gitItem:hover .itemButtonsContainer .buttons {\n    display: flex;\n}\n\n#theia-gitContainer .changesHeader {\n    font-weight: bold;\n}\n\n#theia-gitContainer .changesContainer {\n    margin: 5px 0;\n}\n\n#theia-gitContainer #messageInputContainer {\n    position: relative;\n}\n\n#theia-gitContainer #repositoryListContainer {\n    display: flex;\n    margin-bottom: 5px;\n    flex: 1;\n}\n\n#theia-gitContainer #commandBar {\n    margin-bottom: 5px;\n    align-items: baseline;\n}\n\n#theia-gitContainer .changesOuterContainer {\n    overflow-y: auto;\n    border-top: 1px solid var(--theia-layout-color4);\n    width: 100%;\n    flex-grow: 1;\n}\n\n#theia-gitContainer .warn {\n    background-color: var(--theia-error-color2) !important;\n}\n\n#theia-gitContainer .placeholder {\n    width: 100%;\n}\n\n.theia-git div:focus .theia-mod-selected{\n    background: var(--theia-accent-color3);\n}\n\n.theia-git .theia-mod-selected{\n    background: var(--theia-accent-color4);\n}\n\n.theia-git-main-container {\n    display: flex;\n    flex-direction: column;\n    height: 100%;\n}\n\n.theia-git-last-commit-container {\n    display: flex;\n    border-top: 1px solid var(--theia-layout-color4);\n    width: 100%;\n    padding-top: 6px;\n}\n\n.theia-git-last-commit-container img {\n    width: 27px;\n}\n\n.theia-git-last-commit-details {\n    display: flex;\n    flex-direction: column;\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    width: 100%;\n}\n\n.theia-git-last-commit-message-avatar {\n    margin-right: 5px;\n}\n\n.theia-git-last-commit-message-summary {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n}\n\n.theia-git-last-commit-message-time {\n    white-space: nowrap;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    color: var(--theia-ui-font-color2);\n    font-size: smaller;\n}\n\n.theia-git-commit-message-container {\n    display: flex;\n    flex-direction: column;\n    margin: 0px 0px 7px 0px;\n    max-height: 400px;\n}\n\n.flex-container-center {\n    display: flex;\n    align-items: center;\n}\n\n.theia-git-commit-message-container textarea {\n    line-height: var(--theia-content-line-height);\n    font-size: var(--theia-ui-font-size1);\n    color: var(--theia-ui-font-color1);\n    background: var(--theia-layout-color2);\n    border-style: solid;\n    border-width: 1px;\n    resize: none;\n    box-sizing: border-box;\n    padding-left: 4px;\n}\n\n.theia-git-commit-message {\n    width: 100%;\n}\n\n.theia-git-commit-message-idle {\n    border-color: var(--theia-border-color0);\n}\n\n.theia-git-commit-message-info {\n    border-color: var(--theia-info-color0);\n}\n\n.theia-git-commit-message-success {\n    border-color: var(--theia-success-color0);\n}\n\n.theia-git-commit-message-warning {\n    border-color: var(--theia-warn-color0);\n}\n\n.theia-git-commit-message-error {\n    border-color: var(--theia-error-color0) !important;\n}\n\n.theia-git-message,\n.theia-git-commit-validation-message {\n    padding: 4px 4px 4px 4px;\n}\n\n.theia-git-validation-message-idle {\n    background-color: var(--theia-border-color0) !important;\n}\n\n.theia-git-validation-message-info {\n    background-color: var(--theia-info-color0) !important;\n    color: var(--theia-info-font-color0);\n}\n\n.theia-git-validation-message-success {\n    background-color: var(--theia-success-color0) !important;\n    color: var(--theia-success-font-color0);\n}\n\n.theia-git-message-warning,\n.theia-git-validation-message-warning {\n    background-color: var(--theia-warn-color0) !important;\n    color: var(--theia-warn-font-color0);\n}\n\n.theia-git-validation-message-error {\n    background-color: var(--theia-error-color0) !important;\n    color: var(--theia-error-font-color0);\n}\n\n.no-select {\n    cursor: default;\n    -webkit-user-select: none;\n    -webkit-touch-callout: none;\n    -khtml-user-select: none;\n    -moz-user-select: none;\n    -ms-user-select: none;\n    -o-user-select: none;\n }\n\n .no-select:focus {\n    outline: none;\n }\n\n.git-tab-icon::before {\n    content: \"\\F126\"\n}\n", ""]);

// exports


/***/ }),

/***/ "../node_modules/diff/dist/diff.js":
/*!*****************************************!*\
  !*** ../node_modules/diff/dist/diff.js ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

/*!

 diff v3.5.0

Software License Agreement (BSD License)

Copyright (c) 2009-2015, Kevin Decker <kpdecker@gmail.com>

All rights reserved.

Redistribution and use of this software in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above
  copyright notice, this list of conditions and the
  following disclaimer.

* Redistributions in binary form must reproduce the above
  copyright notice, this list of conditions and the
  following disclaimer in the documentation and/or other
  materials provided with the distribution.

* Neither the name of Kevin Decker nor the names of its
  contributors may be used to endorse or promote products
  derived from this software without specific prior
  written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
@license
*/
(function webpackUniversalModuleDefinition(root, factory) {
	if(true)
		module.exports = factory();
	else {}
})(this, function() {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.canonicalize = exports.convertChangesToXML = exports.convertChangesToDMP = exports.merge = exports.parsePatch = exports.applyPatches = exports.applyPatch = exports.createPatch = exports.createTwoFilesPatch = exports.structuredPatch = exports.diffArrays = exports.diffJson = exports.diffCss = exports.diffSentences = exports.diffTrimmedLines = exports.diffLines = exports.diffWordsWithSpace = exports.diffWords = exports.diffChars = exports.Diff = undefined;

	/*istanbul ignore end*/var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	/*istanbul ignore end*/var /*istanbul ignore start*/_character = __webpack_require__(2) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_word = __webpack_require__(3) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_line = __webpack_require__(5) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_sentence = __webpack_require__(6) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_css = __webpack_require__(7) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_json = __webpack_require__(8) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_array = __webpack_require__(9) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_apply = __webpack_require__(10) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_parse = __webpack_require__(11) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_merge = __webpack_require__(13) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_create = __webpack_require__(14) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_dmp = __webpack_require__(16) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_xml = __webpack_require__(17) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/* See LICENSE file for terms of use */

	/*
	 * Text diff implementation.
	 *
	 * This library supports the following APIS:
	 * JsDiff.diffChars: Character by character diff
	 * JsDiff.diffWords: Word (as defined by \b regex) diff which ignores whitespace
	 * JsDiff.diffLines: Line based diff
	 *
	 * JsDiff.diffCss: Diff targeted at CSS content
	 *
	 * These methods are based on the implementation proposed in
	 * "An O(ND) Difference Algorithm and its Variations" (Myers, 1986).
	 * http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.4.6927
	 */
	exports. /*istanbul ignore end*/Diff = _base2['default'];
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffChars = _character.diffChars;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffWords = _word.diffWords;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffWordsWithSpace = _word.diffWordsWithSpace;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffLines = _line.diffLines;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffTrimmedLines = _line.diffTrimmedLines;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffSentences = _sentence.diffSentences;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffCss = _css.diffCss;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffJson = _json.diffJson;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffArrays = _array.diffArrays;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/structuredPatch = _create.structuredPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/createTwoFilesPatch = _create.createTwoFilesPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/createPatch = _create.createPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/applyPatch = _apply.applyPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/applyPatches = _apply.applyPatches;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/parsePatch = _parse.parsePatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/merge = _merge.merge;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/convertChangesToDMP = _dmp.convertChangesToDMP;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/convertChangesToXML = _xml.convertChangesToXML;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/canonicalize = _json.canonicalize;
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uL3NyYy9pbmRleC5qcyJdLCJuYW1lcyI6WyJEaWZmIiwiZGlmZkNoYXJzIiwiZGlmZldvcmRzIiwiZGlmZldvcmRzV2l0aFNwYWNlIiwiZGlmZkxpbmVzIiwiZGlmZlRyaW1tZWRMaW5lcyIsImRpZmZTZW50ZW5jZXMiLCJkaWZmQ3NzIiwiZGlmZkpzb24iLCJkaWZmQXJyYXlzIiwic3RydWN0dXJlZFBhdGNoIiwiY3JlYXRlVHdvRmlsZXNQYXRjaCIsImNyZWF0ZVBhdGNoIiwiYXBwbHlQYXRjaCIsImFwcGx5UGF0Y2hlcyIsInBhcnNlUGF0Y2giLCJtZXJnZSIsImNvbnZlcnRDaGFuZ2VzVG9ETVAiLCJjb252ZXJ0Q2hhbmdlc1RvWE1MIiwiY2Fub25pY2FsaXplIl0sIm1hcHBpbmdzIjoiOzs7Ozt1QkFnQkE7Ozs7dUJBQ0E7O0FBQ0E7O0FBQ0E7O0FBQ0E7O0FBRUE7O0FBQ0E7O0FBRUE7O0FBRUE7O0FBQ0E7O0FBQ0E7O0FBQ0E7O0FBRUE7O0FBQ0E7Ozs7QUFqQ0E7O0FBRUE7Ozs7Ozs7Ozs7Ozs7O2dDQWtDRUEsSTt5REFFQUMsUzt5REFDQUMsUzt5REFDQUMsa0I7eURBQ0FDLFM7eURBQ0FDLGdCO3lEQUNBQyxhO3lEQUVBQyxPO3lEQUNBQyxRO3lEQUVBQyxVO3lEQUVBQyxlO3lEQUNBQyxtQjt5REFDQUMsVzt5REFDQUMsVTt5REFDQUMsWTt5REFDQUMsVTt5REFDQUMsSzt5REFDQUMsbUI7eURBQ0FDLG1CO3lEQUNBQyxZIiwiZmlsZSI6ImluZGV4LmpzIiwic291cmNlc0NvbnRlbnQiOlsiLyogU2VlIExJQ0VOU0UgZmlsZSBmb3IgdGVybXMgb2YgdXNlICovXG5cbi8qXG4gKiBUZXh0IGRpZmYgaW1wbGVtZW50YXRpb24uXG4gKlxuICogVGhpcyBsaWJyYXJ5IHN1cHBvcnRzIHRoZSBmb2xsb3dpbmcgQVBJUzpcbiAqIEpzRGlmZi5kaWZmQ2hhcnM6IENoYXJhY3RlciBieSBjaGFyYWN0ZXIgZGlmZlxuICogSnNEaWZmLmRpZmZXb3JkczogV29yZCAoYXMgZGVmaW5lZCBieSBcXGIgcmVnZXgpIGRpZmYgd2hpY2ggaWdub3JlcyB3aGl0ZXNwYWNlXG4gKiBKc0RpZmYuZGlmZkxpbmVzOiBMaW5lIGJhc2VkIGRpZmZcbiAqXG4gKiBKc0RpZmYuZGlmZkNzczogRGlmZiB0YXJnZXRlZCBhdCBDU1MgY29udGVudFxuICpcbiAqIFRoZXNlIG1ldGhvZHMgYXJlIGJhc2VkIG9uIHRoZSBpbXBsZW1lbnRhdGlvbiBwcm9wb3NlZCBpblxuICogXCJBbiBPKE5EKSBEaWZmZXJlbmNlIEFsZ29yaXRobSBhbmQgaXRzIFZhcmlhdGlvbnNcIiAoTXllcnMsIDE5ODYpLlxuICogaHR0cDovL2NpdGVzZWVyeC5pc3QucHN1LmVkdS92aWV3ZG9jL3N1bW1hcnk/ZG9pPTEwLjEuMS40LjY5MjdcbiAqL1xuaW1wb3J0IERpZmYgZnJvbSAnLi9kaWZmL2Jhc2UnO1xuaW1wb3J0IHtkaWZmQ2hhcnN9IGZyb20gJy4vZGlmZi9jaGFyYWN0ZXInO1xuaW1wb3J0IHtkaWZmV29yZHMsIGRpZmZXb3Jkc1dpdGhTcGFjZX0gZnJvbSAnLi9kaWZmL3dvcmQnO1xuaW1wb3J0IHtkaWZmTGluZXMsIGRpZmZUcmltbWVkTGluZXN9IGZyb20gJy4vZGlmZi9saW5lJztcbmltcG9ydCB7ZGlmZlNlbnRlbmNlc30gZnJvbSAnLi9kaWZmL3NlbnRlbmNlJztcblxuaW1wb3J0IHtkaWZmQ3NzfSBmcm9tICcuL2RpZmYvY3NzJztcbmltcG9ydCB7ZGlmZkpzb24sIGNhbm9uaWNhbGl6ZX0gZnJvbSAnLi9kaWZmL2pzb24nO1xuXG5pbXBvcnQge2RpZmZBcnJheXN9IGZyb20gJy4vZGlmZi9hcnJheSc7XG5cbmltcG9ydCB7YXBwbHlQYXRjaCwgYXBwbHlQYXRjaGVzfSBmcm9tICcuL3BhdGNoL2FwcGx5JztcbmltcG9ydCB7cGFyc2VQYXRjaH0gZnJvbSAnLi9wYXRjaC9wYXJzZSc7XG5pbXBvcnQge21lcmdlfSBmcm9tICcuL3BhdGNoL21lcmdlJztcbmltcG9ydCB7c3RydWN0dXJlZFBhdGNoLCBjcmVhdGVUd29GaWxlc1BhdGNoLCBjcmVhdGVQYXRjaH0gZnJvbSAnLi9wYXRjaC9jcmVhdGUnO1xuXG5pbXBvcnQge2NvbnZlcnRDaGFuZ2VzVG9ETVB9IGZyb20gJy4vY29udmVydC9kbXAnO1xuaW1wb3J0IHtjb252ZXJ0Q2hhbmdlc1RvWE1MfSBmcm9tICcuL2NvbnZlcnQveG1sJztcblxuZXhwb3J0IHtcbiAgRGlmZixcblxuICBkaWZmQ2hhcnMsXG4gIGRpZmZXb3JkcyxcbiAgZGlmZldvcmRzV2l0aFNwYWNlLFxuICBkaWZmTGluZXMsXG4gIGRpZmZUcmltbWVkTGluZXMsXG4gIGRpZmZTZW50ZW5jZXMsXG5cbiAgZGlmZkNzcyxcbiAgZGlmZkpzb24sXG5cbiAgZGlmZkFycmF5cyxcblxuICBzdHJ1Y3R1cmVkUGF0Y2gsXG4gIGNyZWF0ZVR3b0ZpbGVzUGF0Y2gsXG4gIGNyZWF0ZVBhdGNoLFxuICBhcHBseVBhdGNoLFxuICBhcHBseVBhdGNoZXMsXG4gIHBhcnNlUGF0Y2gsXG4gIG1lcmdlLFxuICBjb252ZXJ0Q2hhbmdlc1RvRE1QLFxuICBjb252ZXJ0Q2hhbmdlc1RvWE1MLFxuICBjYW5vbmljYWxpemVcbn07XG4iXX0=


/***/ }),
/* 1 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports['default'] = /*istanbul ignore end*/Diff;
	function Diff() {}

	Diff.prototype = {
	  /*istanbul ignore start*/ /*istanbul ignore end*/diff: function diff(oldString, newString) {
	    /*istanbul ignore start*/var /*istanbul ignore end*/options = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

	    var callback = options.callback;
	    if (typeof options === 'function') {
	      callback = options;
	      options = {};
	    }
	    this.options = options;

	    var self = this;

	    function done(value) {
	      if (callback) {
	        setTimeout(function () {
	          callback(undefined, value);
	        }, 0);
	        return true;
	      } else {
	        return value;
	      }
	    }

	    // Allow subclasses to massage the input prior to running
	    oldString = this.castInput(oldString);
	    newString = this.castInput(newString);

	    oldString = this.removeEmpty(this.tokenize(oldString));
	    newString = this.removeEmpty(this.tokenize(newString));

	    var newLen = newString.length,
	        oldLen = oldString.length;
	    var editLength = 1;
	    var maxEditLength = newLen + oldLen;
	    var bestPath = [{ newPos: -1, components: [] }];

	    // Seed editLength = 0, i.e. the content starts with the same values
	    var oldPos = this.extractCommon(bestPath[0], newString, oldString, 0);
	    if (bestPath[0].newPos + 1 >= newLen && oldPos + 1 >= oldLen) {
	      // Identity per the equality and tokenizer
	      return done([{ value: this.join(newString), count: newString.length }]);
	    }

	    // Main worker method. checks all permutations of a given edit length for acceptance.
	    function execEditLength() {
	      for (var diagonalPath = -1 * editLength; diagonalPath <= editLength; diagonalPath += 2) {
	        var basePath = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;
	        var addPath = bestPath[diagonalPath - 1],
	            removePath = bestPath[diagonalPath + 1],
	            _oldPos = (removePath ? removePath.newPos : 0) - diagonalPath;
	        if (addPath) {
	          // No one else is going to attempt to use this value, clear it
	          bestPath[diagonalPath - 1] = undefined;
	        }

	        var canAdd = addPath && addPath.newPos + 1 < newLen,
	            canRemove = removePath && 0 <= _oldPos && _oldPos < oldLen;
	        if (!canAdd && !canRemove) {
	          // If this path is a terminal then prune
	          bestPath[diagonalPath] = undefined;
	          continue;
	        }

	        // Select the diagonal that we want to branch from. We select the prior
	        // path whose position in the new string is the farthest from the origin
	        // and does not pass the bounds of the diff graph
	        if (!canAdd || canRemove && addPath.newPos < removePath.newPos) {
	          basePath = clonePath(removePath);
	          self.pushComponent(basePath.components, undefined, true);
	        } else {
	          basePath = addPath; // No need to clone, we've pulled it from the list
	          basePath.newPos++;
	          self.pushComponent(basePath.components, true, undefined);
	        }

	        _oldPos = self.extractCommon(basePath, newString, oldString, diagonalPath);

	        // If we have hit the end of both strings, then we are done
	        if (basePath.newPos + 1 >= newLen && _oldPos + 1 >= oldLen) {
	          return done(buildValues(self, basePath.components, newString, oldString, self.useLongestToken));
	        } else {
	          // Otherwise track this path as a potential candidate and continue.
	          bestPath[diagonalPath] = basePath;
	        }
	      }

	      editLength++;
	    }

	    // Performs the length of edit iteration. Is a bit fugly as this has to support the
	    // sync and async mode which is never fun. Loops over execEditLength until a value
	    // is produced.
	    if (callback) {
	      (function exec() {
	        setTimeout(function () {
	          // This should not happen, but we want to be safe.
	          /* istanbul ignore next */
	          if (editLength > maxEditLength) {
	            return callback();
	          }

	          if (!execEditLength()) {
	            exec();
	          }
	        }, 0);
	      })();
	    } else {
	      while (editLength <= maxEditLength) {
	        var ret = execEditLength();
	        if (ret) {
	          return ret;
	        }
	      }
	    }
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/pushComponent: function pushComponent(components, added, removed) {
	    var last = components[components.length - 1];
	    if (last && last.added === added && last.removed === removed) {
	      // We need to clone here as the component clone operation is just
	      // as shallow array clone
	      components[components.length - 1] = { count: last.count + 1, added: added, removed: removed };
	    } else {
	      components.push({ count: 1, added: added, removed: removed });
	    }
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/extractCommon: function extractCommon(basePath, newString, oldString, diagonalPath) {
	    var newLen = newString.length,
	        oldLen = oldString.length,
	        newPos = basePath.newPos,
	        oldPos = newPos - diagonalPath,
	        commonCount = 0;
	    while (newPos + 1 < newLen && oldPos + 1 < oldLen && this.equals(newString[newPos + 1], oldString[oldPos + 1])) {
	      newPos++;
	      oldPos++;
	      commonCount++;
	    }

	    if (commonCount) {
	      basePath.components.push({ count: commonCount });
	    }

	    basePath.newPos = newPos;
	    return oldPos;
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/equals: function equals(left, right) {
	    if (this.options.comparator) {
	      return this.options.comparator(left, right);
	    } else {
	      return left === right || this.options.ignoreCase && left.toLowerCase() === right.toLowerCase();
	    }
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/removeEmpty: function removeEmpty(array) {
	    var ret = [];
	    for (var i = 0; i < array.length; i++) {
	      if (array[i]) {
	        ret.push(array[i]);
	      }
	    }
	    return ret;
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/castInput: function castInput(value) {
	    return value;
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/tokenize: function tokenize(value) {
	    return value.split('');
	  },
	  /*istanbul ignore start*/ /*istanbul ignore end*/join: function join(chars) {
	    return chars.join('');
	  }
	};

	function buildValues(diff, components, newString, oldString, useLongestToken) {
	  var componentPos = 0,
	      componentLen = components.length,
	      newPos = 0,
	      oldPos = 0;

	  for (; componentPos < componentLen; componentPos++) {
	    var component = components[componentPos];
	    if (!component.removed) {
	      if (!component.added && useLongestToken) {
	        var value = newString.slice(newPos, newPos + component.count);
	        value = value.map(function (value, i) {
	          var oldValue = oldString[oldPos + i];
	          return oldValue.length > value.length ? oldValue : value;
	        });

	        component.value = diff.join(value);
	      } else {
	        component.value = diff.join(newString.slice(newPos, newPos + component.count));
	      }
	      newPos += component.count;

	      // Common case
	      if (!component.added) {
	        oldPos += component.count;
	      }
	    } else {
	      component.value = diff.join(oldString.slice(oldPos, oldPos + component.count));
	      oldPos += component.count;

	      // Reverse add and remove so removes are output first to match common convention
	      // The diffing algorithm is tied to add then remove output and this is the simplest
	      // route to get the desired output with minimal overhead.
	      if (componentPos && components[componentPos - 1].added) {
	        var tmp = components[componentPos - 1];
	        components[componentPos - 1] = components[componentPos];
	        components[componentPos] = tmp;
	      }
	    }
	  }

	  // Special case handle for when one terminal is ignored (i.e. whitespace).
	  // For this case we merge the terminal into the prior string and drop the change.
	  // This is only available for string mode.
	  var lastComponent = components[componentLen - 1];
	  if (componentLen > 1 && typeof lastComponent.value === 'string' && (lastComponent.added || lastComponent.removed) && diff.equals('', lastComponent.value)) {
	    components[componentLen - 2].value += lastComponent.value;
	    components.pop();
	  }

	  return components;
	}

	function clonePath(path) {
	  return { newPos: path.newPos, components: path.components.slice(0) };
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2Jhc2UuanMiXSwibmFtZXMiOlsiRGlmZiIsInByb3RvdHlwZSIsImRpZmYiLCJvbGRTdHJpbmciLCJuZXdTdHJpbmciLCJvcHRpb25zIiwiY2FsbGJhY2siLCJzZWxmIiwiZG9uZSIsInZhbHVlIiwic2V0VGltZW91dCIsInVuZGVmaW5lZCIsImNhc3RJbnB1dCIsInJlbW92ZUVtcHR5IiwidG9rZW5pemUiLCJuZXdMZW4iLCJsZW5ndGgiLCJvbGRMZW4iLCJlZGl0TGVuZ3RoIiwibWF4RWRpdExlbmd0aCIsImJlc3RQYXRoIiwibmV3UG9zIiwiY29tcG9uZW50cyIsIm9sZFBvcyIsImV4dHJhY3RDb21tb24iLCJqb2luIiwiY291bnQiLCJleGVjRWRpdExlbmd0aCIsImRpYWdvbmFsUGF0aCIsImJhc2VQYXRoIiwiYWRkUGF0aCIsInJlbW92ZVBhdGgiLCJjYW5BZGQiLCJjYW5SZW1vdmUiLCJjbG9uZVBhdGgiLCJwdXNoQ29tcG9uZW50IiwiYnVpbGRWYWx1ZXMiLCJ1c2VMb25nZXN0VG9rZW4iLCJleGVjIiwicmV0IiwiYWRkZWQiLCJyZW1vdmVkIiwibGFzdCIsInB1c2giLCJjb21tb25Db3VudCIsImVxdWFscyIsImxlZnQiLCJyaWdodCIsImNvbXBhcmF0b3IiLCJpZ25vcmVDYXNlIiwidG9Mb3dlckNhc2UiLCJhcnJheSIsImkiLCJzcGxpdCIsImNoYXJzIiwiY29tcG9uZW50UG9zIiwiY29tcG9uZW50TGVuIiwiY29tcG9uZW50Iiwic2xpY2UiLCJtYXAiLCJvbGRWYWx1ZSIsInRtcCIsImxhc3RDb21wb25lbnQiLCJwb3AiLCJwYXRoIl0sIm1hcHBpbmdzIjoiOzs7NENBQXdCQSxJO0FBQVQsU0FBU0EsSUFBVCxHQUFnQixDQUFFOztBQUVqQ0EsS0FBS0MsU0FBTCxHQUFpQjtBQUFBLG1EQUNmQyxJQURlLGdCQUNWQyxTQURVLEVBQ0NDLFNBREQsRUFDMEI7QUFBQSx3REFBZEMsT0FBYyx1RUFBSixFQUFJOztBQUN2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RUFBd0JBLFNBQVNrQyxVQUFVL0IsS0FBM0MsQ0FBVixDQUFsQjtBQUNBSCxnQkFBVWtDLFVBQVUvQixLQUFwQjs7QUFFQTtBQUNBO0FBQ0E7QUFDQSxVQUFJNkIsZ0JBQWdCakMsV0FBV2lDLGVBQWUsQ0FBMUIsRUFBNkJmLEtBQWpELEVBQXdEO0FBQ3RELFlBQUlxQixNQUFNdkMsV0FBV2lDLGVBQWUsQ0FBMUIsQ0FBVjtBQUNBakMsbUJBQVdpQyxlQUFlLENBQTFCLElBQStCakMsV0FBV2lDLFlBQVgsQ0FBL0I7QUFDQWpDLG1CQUFXaUMsWUFBWCxJQUEyQk0sR0FBM0I7QUFDRDtBQUNGO0FBQ0Y7O0FBRUQ7QUFDQTtBQUNBO0FBQ0EsTUFBSUMsZ0JBQWdCeEMsV0FBV2tDLGVBQWUsQ0FBMUIsQ0FBcEI7QUFDQSxNQUFJQSxlQUFlLENBQWYsSUFDRyxPQUFPTSxjQUFjckQsS0FBckIsS0FBK0IsUUFEbEMsS0FFSXFELGNBQWN0QixLQUFkLElBQXVCc0IsY0FBY3JCLE9BRnpDLEtBR0d2QyxLQUFLMkMsTUFBTCxDQUFZLEVBQVosRUFBZ0JpQixjQUFjckQsS0FBOUIsQ0FIUCxFQUc2QztBQUMzQ2EsZUFBV2tDLGVBQWUsQ0FBMUIsRUFBNkIvQyxLQUE3QixJQUFzQ3FELGNBQWNyRCxLQUFwRDtBQUNBYSxlQUFXeUMsR0FBWDtBQUNEOztBQUVELFNBQU96QyxVQUFQO0FBQ0Q7O0FBRUQsU0FBU1ksU0FBVCxDQUFtQjhCLElBQW5CLEVBQXlCO0FBQ3ZCLFNBQU8sRUFBRTNDLFFBQVEyQyxLQUFLM0MsTUFBZixFQUF1QkMsWUFBWTBDLEtBQUsxQyxVQUFMLENBQWdCb0MsS0FBaEIsQ0FBc0IsQ0FBdEIsQ0FBbkMsRUFBUDtBQUNEIiwiZmlsZSI6ImJhc2UuanMiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgZGVmYXVsdCBmdW5jdGlvbiBEaWZmKCkge31cblxuRGlmZi5wcm90b3R5cGUgPSB7XG4gIGRpZmYob2xkU3RyaW5nLCBuZXdTdHJpbmcsIG9wdGlvbnMgPSB7fSkge1xuICAgIGxldCBjYWxsYmFjayA9IG9wdGlvbnMuY2FsbGJhY2s7XG4gICAgaWYgKHR5cGVvZiBvcHRpb25zID09PSAnZnVuY3Rpb24nKSB7XG4gICAgICBjYWxsYmFjayA9IG9wdGlvbnM7XG4gICAgICBvcHRpb25zID0ge307XG4gICAgfVxuICAgIHRoaXMub3B0aW9ucyA9IG9wdGlvbnM7XG5cbiAgICBsZXQgc2VsZiA9IHRoaXM7XG5cbiAgICBmdW5jdGlvbiBkb25lKHZhbHVlKSB7XG4gICAgICBpZiAoY2FsbGJhY2spIHtcbiAgICAgICAgc2V0VGltZW91dChmdW5jdGlvbigpIHsgY2FsbGJhY2sodW5kZWZpbmVkLCB2YWx1ZSk7IH0sIDApO1xuICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiB2YWx1ZTtcbiAgICAgIH1cbiAgICB9XG5cbiAgICAvLyBBbGxvdyBzdWJjbGFzc2VzIHRvIG1hc3NhZ2UgdGhlIGlucHV0IHByaW9yIHRvIHJ1bm5pbmdcbiAgICBvbGRTdHJpbmcgPSB0aGlzLmNhc3RJbnB1dChvbGRTdHJpbmcpO1xuICAgIG5ld1N0cmluZyA9IHRoaXMuY2FzdElucHV0KG5ld1N0cmluZyk7XG5cbiAgICBvbGRTdHJpbmcgPSB0aGlzLnJlbW92ZUVtcHR5KHRoaXMudG9rZW5pemUob2xkU3RyaW5nKSk7XG4gICAgbmV3U3RyaW5nID0gdGhpcy5yZW1vdmVFbXB0eSh0aGlzLnRva2VuaXplKG5ld1N0cmluZykpO1xuXG4gICAgbGV0IG5ld0xlbiA9IG5ld1N0cmluZy5sZW5ndGgsIG9sZExlbiA9IG9sZFN0cmluZy5sZW5ndGg7XG4gICAgbGV0IGVkaXRMZW5ndGggPSAxO1xuICAgIGxldCBtYXhFZGl0TGVuZ3RoID0gbmV3TGVuICsgb2xkTGVuO1xuICAgIGxldCBiZXN0UGF0aCA9IFt7IG5ld1BvczogLTEsIGNvbXBvbmVudHM6IFtdIH1dO1xuXG4gICAgLy8gU2VlZCBlZGl0TGVuZ3RoID0gMCwgaS5lLiB0aGUgY29udGVudCBzdGFydHMgd2l0aCB0aGUgc2FtZSB2YWx1ZXNcbiAgICBsZXQgb2xkUG9zID0gdGhpcy5leHRyYWN0Q29tbW9uKGJlc3RQYXRoWzBdLCBuZXdTdHJpbmcsIG9sZFN0cmluZywgMCk7XG4gICAgaWYgKGJlc3RQYXRoWzBdLm5ld1BvcyArIDEgPj0gbmV3TGVuICYmIG9sZFBvcyArIDEgPj0gb2xkTGVuKSB7XG4gICAgICAvLyBJZGVudGl0eSBwZXIgdGhlIGVxdWFsaXR5IGFuZCB0b2tlbml6ZXJcbiAgICAgIHJldHVybiBkb25lKFt7dmFsdWU6IHRoaXMuam9pbihuZXdTdHJpbmcpLCBjb3VudDogbmV3U3RyaW5nLmxlbmd0aH1dKTtcbiAgICB9XG5cbiAgICAvLyBNYWluIHdvcmtlciBtZXRob2QuIGNoZWNrcyBhbGwgcGVybXV0YXRpb25zIG9mIGEgZ2l2ZW4gZWRpdCBsZW5ndGggZm9yIGFjY2VwdGFuY2UuXG4gICAgZnVuY3Rpb24gZXhlY0VkaXRMZW5ndGgoKSB7XG4gICAgICBmb3IgKGxldCBkaWFnb25hbFBhdGggPSAtMSAqIGVkaXRMZW5ndGg7IGRpYWdvbmFsUGF0aCA8PSBlZGl0TGVuZ3RoOyBkaWFnb25hbFBhdGggKz0gMikge1xuICAgICAgICBsZXQgYmFzZVBhdGg7XG4gICAgICAgIGxldCBhZGRQYXRoID0gYmVzdFBhdGhbZGlhZ29uYWxQYXRoIC0gMV0sXG4gICAgICAgICAgICByZW1vdmVQYXRoID0gYmVzdFBhdGhbZGlhZ29uYWxQYXRoICsgMV0sXG4gICAgICAgICAgICBvbGRQb3MgPSAocmVtb3ZlUGF0aCA/IHJlbW92ZVBhdGgubmV3UG9zIDogMCkgLSBkaWFnb25hbFBhdGg7XG4gICAgICAgIGlmIChhZGRQYXRoKSB7XG4gICAgICAgICAgLy8gTm8gb25lIGVsc2UgaXMgZ29pbmcgdG8gYXR0ZW1wdCB0byB1c2UgdGhpcyB2YWx1ZSwgY2xlYXIgaXRcbiAgICAgICAgICBiZXN0UGF0aFtkaWFnb25hbFBhdGggLSAxXSA9IHVuZGVmaW5lZDtcbiAgICAgICAgfVxuXG4gICAgICAgIGxldCBjYW5BZGQgPSBhZGRQYXRoICYmIGFkZFBhdGgubmV3UG9zICsgMSA8IG5ld0xlbixcbiAgICAgICAgICAgIGNhblJlbW92ZSA9IHJlbW92ZVBhdGggJiYgMCA8PSBvbGRQb3MgJiYgb2xkUG9zIDwgb2xkTGVuO1xuICAgICAgICBpZiAoIWNhbkFkZCAmJiAhY2FuUmVtb3ZlKSB7XG4gICAgICAgICAgLy8gSWYgdGhpcyBwYXRoIGlzIGEgdGVybWluYWwgdGhlbiBwcnVuZVxuICAgICAgICAgIGJlc3RQYXRoW2RpYWdvbmFsUGF0aF0gPSB1bmRlZmluZWQ7XG4gICAgICAgICAgY29udGludWU7XG4gICAgICAgIH1cblxuICAgICAgICAvLyBTZWxlY3QgdGhlIGRpYWdvbmFsIHRoYXQgd2Ugd2FudCB0byBicmFuY2ggZnJvbS4gV2Ugc2VsZWN0IHRoZSBwcmlvclxuICAgICAgICAvLyBwYXRoIHdob3NlIHBvc2l0aW9uIGluIHRoZSBuZXcgc3RyaW5nIGlzIHRoZSBmYXJ0aGVzdCBmcm9tIHRoZSBvcmlnaW5cbiAgICAgICAgLy8gYW5kIGRvZXMgbm90IHBhc3MgdGhlIGJvdW5kcyBvZiB0aGUgZGlmZiBncmFwaFxuICAgICAgICBpZiAoIWNhbkFkZCB8fCAoY2FuUmVtb3ZlICYmIGFkZFBhdGgubmV3UG9zIDwgcmVtb3ZlUGF0aC5uZXdQb3MpKSB7XG4gICAgICAgICAgYmFzZVBhdGggPSBjbG9uZVBhdGgocmVtb3ZlUGF0aCk7XG4gICAgICAgICAgc2VsZi5wdXNoQ29tcG9uZW50KGJhc2VQYXRoLmNvbXBvbmVudHMsIHVuZGVmaW5lZCwgdHJ1ZSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgYmFzZVBhdGggPSBhZGRQYXRoOyAgIC8vIE5vIG5lZWQgdG8gY2xvbmUsIHdlJ3ZlIHB1bGxlZCBpdCBmcm9tIHRoZSBsaXN0XG4gICAgICAgICAgYmFzZVBhdGgubmV3UG9zKys7XG4gICAgICAgICAgc2VsZi5wdXNoQ29tcG9uZW50KGJhc2VQYXRoLmNvbXBvbmVudHMsIHRydWUsIHVuZGVmaW5lZCk7XG4gICAgICAgIH1cblxuICAgICAgICBvbGRQb3MgPSBzZWxmLmV4dHJhY3RDb21tb24oYmFzZVBhdGgsIG5ld1N0cmluZywgb2xkU3RyaW5nLCBkaWFnb25hbFBhdGgpO1xuXG4gICAgICAgIC8vIElmIHdlIGhhdmUgaGl0IHRoZSBlbmQgb2YgYm90aCBzdHJpbmdzLCB0aGVuIHdlIGFyZSBkb25lXG4gICAgICAgIGlmIChiYXNlUGF0aC5uZXdQb3MgKyAxID49IG5ld0xlbiAmJiBvbGRQb3MgKyAxID49IG9sZExlbikge1xuICAgICAgICAgIHJldHVybiBkb25lKGJ1aWxkVmFsdWVzKHNlbGYsIGJhc2VQYXRoLmNvbXBvbmVudHMsIG5ld1N0cmluZywgb2xkU3RyaW5nLCBzZWxmLnVzZUxvbmdlc3RUb2tlbikpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIC8vIE90aGVyd2lzZSB0cmFjayB0aGlzIHBhdGggYXMgYSBwb3RlbnRpYWwgY2FuZGlkYXRlIGFuZCBjb250aW51ZS5cbiAgICAgICAgICBiZXN0UGF0aFtkaWFnb25hbFBhdGhdID0gYmFzZVBhdGg7XG4gICAgICAgIH1cbiAgICAgIH1cblxuICAgICAgZWRpdExlbmd0aCsrO1xuICAgIH1cblxuICAgIC8vIFBlcmZvcm1zIHRoZSBsZW5ndGggb2YgZWRpdCBpdGVyYXRpb24uIElzIGEgYml0IGZ1Z2x5IGFzIHRoaXMgaGFzIHRvIHN1cHBvcnQgdGhlXG4gICAgLy8gc3luYyBhbmQgYXN5bmMgbW9kZSB3aGljaCBpcyBuZXZlciBmdW4uIExvb3BzIG92ZXIgZXhlY0VkaXRMZW5ndGggdW50aWwgYSB2YWx1ZVxuICAgIC8vIGlzIHByb2R1Y2VkLlxuICAgIGlmIChjYWxsYmFjaykge1xuICAgICAgKGZ1bmN0aW9uIGV4ZWMoKSB7XG4gICAgICAgIHNldFRpbWVvdXQoZnVuY3Rpb24oKSB7XG4gICAgICAgICAgLy8gVGhpcyBzaG91bGQgbm90IGhhcHBlbiwgYnV0IHdlIHdhbnQgdG8gYmUgc2FmZS5cbiAgICAgICAgICAvKiBpc3RhbmJ1bCBpZ25vcmUgbmV4dCAqL1xuICAgICAgICAgIGlmIChlZGl0TGVuZ3RoID4gbWF4RWRpdExlbmd0aCkge1xuICAgICAgICAgICAgcmV0dXJuIGNhbGxiYWNrKCk7XG4gICAgICAgICAgfVxuXG4gICAgICAgICAgaWYgKCFleGVjRWRpdExlbmd0aCgpKSB7XG4gICAgICAgICAgICBleGVjKCk7XG4gICAgICAgICAgfVxuICAgICAgICB9LCAwKTtcbiAgICAgIH0oKSk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHdoaWxlIChlZGl0TGVuZ3RoIDw9IG1heEVkaXRMZW5ndGgpIHtcbiAgICAgICAgbGV0IHJldCA9IGV4ZWNFZGl0TGVuZ3RoKCk7XG4gICAgICAgIGlmIChyZXQpIHtcbiAgICAgICAgICByZXR1cm4gcmV0O1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuICB9LFxuXG4gIHB1c2hDb21wb25lbnQoY29tcG9uZW50cywgYWRkZWQsIHJlbW92ZWQpIHtcbiAgICBsZXQgbGFzdCA9IGNvbXBvbmVudHNbY29tcG9uZW50cy5sZW5ndGggLSAxXTtcbiAgICBpZiAobGFzdCAmJiBsYXN0LmFkZGVkID09PSBhZGRlZCAmJiBsYXN0LnJlbW92ZWQgPT09IHJlbW92ZWQpIHtcbiAgICAgIC8vIFdlIG5lZWQgdG8gY2xvbmUgaGVyZSBhcyB0aGUgY29tcG9uZW50IGNsb25lIG9wZXJhdGlvbiBpcyBqdXN0XG4gICAgICAvLyBhcyBzaGFsbG93IGFycmF5IGNsb25lXG4gICAgICBjb21wb25lbnRzW2NvbXBvbmVudHMubGVuZ3RoIC0gMV0gPSB7Y291bnQ6IGxhc3QuY291bnQgKyAxLCBhZGRlZDogYWRkZWQsIHJlbW92ZWQ6IHJlbW92ZWQgfTtcbiAgICB9IGVsc2Uge1xuICAgICAgY29tcG9uZW50cy5wdXNoKHtjb3VudDogMSwgYWRkZWQ6IGFkZGVkLCByZW1vdmVkOiByZW1vdmVkIH0pO1xuICAgIH1cbiAgfSxcbiAgZXh0cmFjdENvbW1vbihiYXNlUGF0aCwgbmV3U3RyaW5nLCBvbGRTdHJpbmcsIGRpYWdvbmFsUGF0aCkge1xuICAgIGxldCBuZXdMZW4gPSBuZXdTdHJpbmcubGVuZ3RoLFxuICAgICAgICBvbGRMZW4gPSBvbGRTdHJpbmcubGVuZ3RoLFxuICAgICAgICBuZXdQb3MgPSBiYXNlUGF0aC5uZXdQb3MsXG4gICAgICAgIG9sZFBvcyA9IG5ld1BvcyAtIGRpYWdvbmFsUGF0aCxcblxuICAgICAgICBjb21tb25Db3VudCA9IDA7XG4gICAgd2hpbGUgKG5ld1BvcyArIDEgPCBuZXdMZW4gJiYgb2xkUG9zICsgMSA8IG9sZExlbiAmJiB0aGlzLmVxdWFscyhuZXdTdHJpbmdbbmV3UG9zICsgMV0sIG9sZFN0cmluZ1tvbGRQb3MgKyAxXSkpIHtcbiAgICAgIG5ld1BvcysrO1xuICAgICAgb2xkUG9zKys7XG4gICAgICBjb21tb25Db3VudCsrO1xuICAgIH1cblxuICAgIGlmIChjb21tb25Db3VudCkge1xuICAgICAgYmFzZVBhdGguY29tcG9uZW50cy5wdXNoKHtjb3VudDogY29tbW9uQ291bnR9KTtcbiAgICB9XG5cbiAgICBiYXNlUGF0aC5uZXdQb3MgPSBuZXdQb3M7XG4gICAgcmV0dXJuIG9sZFBvcztcbiAgfSxcblxuICBlcXVhbHMobGVmdCwgcmlnaHQpIHtcbiAgICBpZiAodGhpcy5vcHRpb25zLmNvbXBhcmF0b3IpIHtcbiAgICAgIHJldHVybiB0aGlzLm9wdGlvbnMuY29tcGFyYXRvcihsZWZ0LCByaWdodCk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHJldHVybiBsZWZ0ID09PSByaWdodFxuICAgICAgICB8fCAodGhpcy5vcHRpb25zLmlnbm9yZUNhc2UgJiYgbGVmdC50b0xvd2VyQ2FzZSgpID09PSByaWdodC50b0xvd2VyQ2FzZSgpKTtcbiAgICB9XG4gIH0sXG4gIHJlbW92ZUVtcHR5KGFycmF5KSB7XG4gICAgbGV0IHJldCA9IFtdO1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgYXJyYXkubGVuZ3RoOyBpKyspIHtcbiAgICAgIGlmIChhcnJheVtpXSkge1xuICAgICAgICByZXQucHVzaChhcnJheVtpXSk7XG4gICAgICB9XG4gICAgfVxuICAgIHJldHVybiByZXQ7XG4gIH0sXG4gIGNhc3RJbnB1dCh2YWx1ZSkge1xuICAgIHJldHVybiB2YWx1ZTtcbiAgfSxcbiAgdG9rZW5pemUodmFsdWUpIHtcbiAgICByZXR1cm4gdmFsdWUuc3BsaXQoJycpO1xuICB9LFxuICBqb2luKGNoYXJzKSB7XG4gICAgcmV0dXJuIGNoYXJzLmpvaW4oJycpO1xuICB9XG59O1xuXG5mdW5jdGlvbiBidWlsZFZhbHVlcyhkaWZmLCBjb21wb25lbnRzLCBuZXdTdHJpbmcsIG9sZFN0cmluZywgdXNlTG9uZ2VzdFRva2VuKSB7XG4gIGxldCBjb21wb25lbnRQb3MgPSAwLFxuICAgICAgY29tcG9uZW50TGVuID0gY29tcG9uZW50cy5sZW5ndGgsXG4gICAgICBuZXdQb3MgPSAwLFxuICAgICAgb2xkUG9zID0gMDtcblxuICBmb3IgKDsgY29tcG9uZW50UG9zIDwgY29tcG9uZW50TGVuOyBjb21wb25lbnRQb3MrKykge1xuICAgIGxldCBjb21wb25lbnQgPSBjb21wb25lbnRzW2NvbXBvbmVudFBvc107XG4gICAgaWYgKCFjb21wb25lbnQucmVtb3ZlZCkge1xuICAgICAgaWYgKCFjb21wb25lbnQuYWRkZWQgJiYgdXNlTG9uZ2VzdFRva2VuKSB7XG4gICAgICAgIGxldCB2YWx1ZSA9IG5ld1N0cmluZy5zbGljZShuZXdQb3MsIG5ld1BvcyArIGNvbXBvbmVudC5jb3VudCk7XG4gICAgICAgIHZhbHVlID0gdmFsdWUubWFwKGZ1bmN0aW9uKHZhbHVlLCBpKSB7XG4gICAgICAgICAgbGV0IG9sZFZhbHVlID0gb2xkU3RyaW5nW29sZFBvcyArIGldO1xuICAgICAgICAgIHJldHVybiBvbGRWYWx1ZS5sZW5ndGggPiB2YWx1ZS5sZW5ndGggPyBvbGRWYWx1ZSA6IHZhbHVlO1xuICAgICAgICB9KTtcblxuICAgICAgICBjb21wb25lbnQudmFsdWUgPSBkaWZmLmpvaW4odmFsdWUpO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgY29tcG9uZW50LnZhbHVlID0gZGlmZi5qb2luKG5ld1N0cmluZy5zbGljZShuZXdQb3MsIG5ld1BvcyArIGNvbXBvbmVudC5jb3VudCkpO1xuICAgICAgfVxuICAgICAgbmV3UG9zICs9IGNvbXBvbmVudC5jb3VudDtcblxuICAgICAgLy8gQ29tbW9uIGNhc2VcbiAgICAgIGlmICghY29tcG9uZW50LmFkZGVkKSB7XG4gICAgICAgIG9sZFBvcyArPSBjb21wb25lbnQuY291bnQ7XG4gICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgIGNvbXBvbmVudC52YWx1ZSA9IGRpZmYuam9pbihvbGRTdHJpbmcuc2xpY2Uob2xkUG9zLCBvbGRQb3MgKyBjb21wb25lbnQuY291bnQpKTtcbiAgICAgIG9sZFBvcyArPSBjb21wb25lbnQuY291bnQ7XG5cbiAgICAgIC8vIFJldmVyc2UgYWRkIGFuZCByZW1vdmUgc28gcmVtb3ZlcyBhcmUgb3V0cHV0IGZpcnN0IHRvIG1hdGNoIGNvbW1vbiBjb252ZW50aW9uXG4gICAgICAvLyBUaGUgZGlmZmluZyBhbGdvcml0aG0gaXMgdGllZCB0byBhZGQgdGhlbiByZW1vdmUgb3V0cHV0IGFuZCB0aGlzIGlzIHRoZSBzaW1wbGVzdFxuICAgICAgLy8gcm91dGUgdG8gZ2V0IHRoZSBkZXNpcmVkIG91dHB1dCB3aXRoIG1pbmltYWwgb3ZlcmhlYWQuXG4gICAgICBpZiAoY29tcG9uZW50UG9zICYmIGNvbXBvbmVudHNbY29tcG9uZW50UG9zIC0gMV0uYWRkZWQpIHtcbiAgICAgICAgbGV0IHRtcCA9IGNvbXBvbmVudHNbY29tcG9uZW50UG9zIC0gMV07XG4gICAgICAgIGNvbXBvbmVudHNbY29tcG9uZW50UG9zIC0gMV0gPSBjb21wb25lbnRzW2NvbXBvbmVudFBvc107XG4gICAgICAgIGNvbXBvbmVudHNbY29tcG9uZW50UG9zXSA9IHRtcDtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAvLyBTcGVjaWFsIGNhc2UgaGFuZGxlIGZvciB3aGVuIG9uZSB0ZXJtaW5hbCBpcyBpZ25vcmVkIChpLmUuIHdoaXRlc3BhY2UpLlxuICAvLyBGb3IgdGhpcyBjYXNlIHdlIG1lcmdlIHRoZSB0ZXJtaW5hbCBpbnRvIHRoZSBwcmlvciBzdHJpbmcgYW5kIGRyb3AgdGhlIGNoYW5nZS5cbiAgLy8gVGhpcyBpcyBvbmx5IGF2YWlsYWJsZSBmb3Igc3RyaW5nIG1vZGUuXG4gIGxldCBsYXN0Q29tcG9uZW50ID0gY29tcG9uZW50c1tjb21wb25lbnRMZW4gLSAxXTtcbiAgaWYgKGNvbXBvbmVudExlbiA+IDFcbiAgICAgICYmIHR5cGVvZiBsYXN0Q29tcG9uZW50LnZhbHVlID09PSAnc3RyaW5nJ1xuICAgICAgJiYgKGxhc3RDb21wb25lbnQuYWRkZWQgfHwgbGFzdENvbXBvbmVudC5yZW1vdmVkKVxuICAgICAgJiYgZGlmZi5lcXVhbHMoJycsIGxhc3RDb21wb25lbnQudmFsdWUpKSB7XG4gICAgY29tcG9uZW50c1tjb21wb25lbnRMZW4gLSAyXS52YWx1ZSArPSBsYXN0Q29tcG9uZW50LnZhbHVlO1xuICAgIGNvbXBvbmVudHMucG9wKCk7XG4gIH1cblxuICByZXR1cm4gY29tcG9uZW50cztcbn1cblxuZnVuY3Rpb24gY2xvbmVQYXRoKHBhdGgpIHtcbiAgcmV0dXJuIHsgbmV3UG9zOiBwYXRoLm5ld1BvcywgY29tcG9uZW50czogcGF0aC5jb21wb25lbnRzLnNsaWNlKDApIH07XG59XG4iXX0=


/***/ }),
/* 2 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.characterDiff = undefined;
	exports. /*istanbul ignore end*/diffChars = diffChars;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var characterDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/characterDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	function diffChars(oldStr, newStr, options) {
	  return characterDiff.diff(oldStr, newStr, options);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2NoYXJhY3Rlci5qcyJdLCJuYW1lcyI6WyJkaWZmQ2hhcnMiLCJjaGFyYWN0ZXJEaWZmIiwib2xkU3RyIiwibmV3U3RyIiwib3B0aW9ucyIsImRpZmYiXSwibWFwcGluZ3MiOiI7Ozs7Z0NBR2dCQSxTLEdBQUFBLFM7O0FBSGhCOzs7Ozs7dUJBRU8sSUFBTUMseUZBQWdCLHdFQUF0QjtBQUNBLFNBQVNELFNBQVQsQ0FBbUJFLE1BQW5CLEVBQTJCQyxNQUEzQixFQUFtQ0MsT0FBbkMsRUFBNEM7QUFBRSxTQUFPSCxjQUFjSSxJQUFkLENBQW1CSCxNQUFuQixFQUEyQkMsTUFBM0IsRUFBbUNDLE9BQW5DLENBQVA7QUFBcUQiLCJmaWxlIjoiY2hhcmFjdGVyLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IERpZmYgZnJvbSAnLi9iYXNlJztcblxuZXhwb3J0IGNvbnN0IGNoYXJhY3RlckRpZmYgPSBuZXcgRGlmZigpO1xuZXhwb3J0IGZ1bmN0aW9uIGRpZmZDaGFycyhvbGRTdHIsIG5ld1N0ciwgb3B0aW9ucykgeyByZXR1cm4gY2hhcmFjdGVyRGlmZi5kaWZmKG9sZFN0ciwgbmV3U3RyLCBvcHRpb25zKTsgfVxuIl19


/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.wordDiff = undefined;
	exports. /*istanbul ignore end*/diffWords = diffWords;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffWordsWithSpace = diffWordsWithSpace;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	/*istanbul ignore end*/var /*istanbul ignore start*/_params = __webpack_require__(4) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/ // Based on https://en.wikipedia.org/wiki/Latin_script_in_Unicode
	//
	// Ranges and exceptions:
	// Latin-1 Supplement, 0080–00FF
	//  - U+00D7  × Multiplication sign
	//  - U+00F7  ÷ Division sign
	// Latin Extended-A, 0100–017F
	// Latin Extended-B, 0180–024F
	// IPA Extensions, 0250–02AF
	// Spacing Modifier Letters, 02B0–02FF
	//  - U+02C7  ˇ &#711;  Caron
	//  - U+02D8  ˘ &#728;  Breve
	//  - U+02D9  ˙ &#729;  Dot Above
	//  - U+02DA  ˚ &#730;  Ring Above
	//  - U+02DB  ˛ &#731;  Ogonek
	//  - U+02DC  ˜ &#732;  Small Tilde
	//  - U+02DD  ˝ &#733;  Double Acute Accent
	// Latin Extended Additional, 1E00–1EFF
	var extendedWordChars = /^[A-Za-z\xC0-\u02C6\u02C8-\u02D7\u02DE-\u02FF\u1E00-\u1EFF]+$/;

	var reWhitespace = /\S/;

	var wordDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/wordDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	wordDiff.equals = function (left, right) {
	  if (this.options.ignoreCase) {
	    left = left.toLowerCase();
	    right = right.toLowerCase();
	  }
	  return left === right || this.options.ignoreWhitespace && !reWhitespace.test(left) && !reWhitespace.test(right);
	};
	wordDiff.tokenize = function (value) {
	  var tokens = value.split(/(\s+|\b)/);

	  // Join the boundary splits that we do not consider to be boundaries. This is primarily the extended Latin character set.
	  for (var i = 0; i < tokens.length - 1; i++) {
	    // If we have an empty string in the next field and we have only word chars before and after, merge
	    if (!tokens[i + 1] && tokens[i + 2] && extendedWordChars.test(tokens[i]) && extendedWordChars.test(tokens[i + 2])) {
	      tokens[i] += tokens[i + 2];
	      tokens.splice(i + 1, 2);
	      i--;
	    }
	  }

	  return tokens;
	};

	function diffWords(oldStr, newStr, options) {
	  options = /*istanbul ignore start*/(0, _params.generateOptions) /*istanbul ignore end*/(options, { ignoreWhitespace: true });
	  return wordDiff.diff(oldStr, newStr, options);
	}

	function diffWordsWithSpace(oldStr, newStr, options) {
	  return wordDiff.diff(oldStr, newStr, options);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL3dvcmQuanMiXSwibmFtZXMiOlsiZGlmZldvcmRzIiwiZGlmZldvcmRzV2l0aFNwYWNlIiwiZXh0ZW5kZWRXb3JkQ2hhcnMiLCJyZVdoaXRlc3BhY2UiLCJ3b3JkRGlmZiIsImVxdWFscyIsImxlZnQiLCJyaWdodCIsIm9wdGlvbnMiLCJpZ25vcmVDYXNlIiwidG9Mb3dlckNhc2UiLCJpZ25vcmVXaGl0ZXNwYWNlIiwidGVzdCIsInRva2VuaXplIiwidmFsdWUiLCJ0b2tlbnMiLCJzcGxpdCIsImkiLCJsZW5ndGgiLCJzcGxpY2UiLCJvbGRTdHIiLCJuZXdTdHIiLCJkaWZmIl0sIm1hcHBpbmdzIjoiOzs7O2dDQW1EZ0JBLFMsR0FBQUEsUzt5REFLQUMsa0IsR0FBQUEsa0I7O0FBeERoQjs7Ozt1QkFDQTs7Ozt3QkFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQSxJQUFNQyxvQkFBb0IsK0RBQTFCOztBQUVBLElBQU1DLGVBQWUsSUFBckI7O0FBRU8sSUFBTUMsK0VBQVcsd0VBQWpCO0FBQ1BBLFNBQVNDLE1BQVQsR0FBa0IsVUFBU0MsSUFBVCxFQUFlQyxLQUFmLEVBQXNCO0FBQ3RDLE1BQUksS0FBS0MsT0FBTCxDQUFhQyxVQUFqQixFQUE2QjtBQUMzQkgsV0FBT0EsS0FBS0ksV0FBTCxFQUFQO0FBQ0FILFlBQVFBLE1BQU1HLFdBQU4sRUFBUjtBQUNEO0FBQ0QsU0FBT0osU0FBU0MsS0FBVCxJQUFtQixLQUFLQyxPQUFMLENBQWFHLGdCQUFiLElBQWlDLENBQUNSLGFBQWFTLElBQWIsQ0FBa0JOLElBQWxCLENBQWxDLElBQTZELENBQUNILGFBQWFTLElBQWIsQ0FBa0JMLEtBQWxCLENBQXhGO0FBQ0QsQ0FORDtBQU9BSCxTQUFTUyxRQUFULEdBQW9CLFVBQVNDLEtBQVQsRUFBZ0I7QUFDbEMsTUFBSUMsU0FBU0QsTUFBTUUsS0FBTixDQUFZLFVBQVosQ0FBYjs7QUFFQTtBQUNBLE9BQUssSUFBSUMsSUFBSSxDQUFiLEVBQWdCQSxJQUFJRixPQUFPRyxNQUFQLEdBQWdCLENBQXBDLEVBQXVDRCxHQUF2QyxFQUE0QztBQUMxQztBQUNBLFFBQUksQ0FBQ0YsT0FBT0UsSUFBSSxDQUFYLENBQUQsSUFBa0JGLE9BQU9FLElBQUksQ0FBWCxDQUFsQixJQUNLZixrQkFBa0JVLElBQWxCLENBQXVCRyxPQUFPRSxDQUFQLENBQXZCLENBREwsSUFFS2Ysa0JBQWtCVSxJQUFsQixDQUF1QkcsT0FBT0UsSUFBSSxDQUFYLENBQXZCLENBRlQsRUFFZ0Q7QUFDOUNGLGFBQU9FLENBQVAsS0FBYUYsT0FBT0UsSUFBSSxDQUFYLENBQWI7QUFDQUYsYUFBT0ksTUFBUCxDQUFjRixJQUFJLENBQWxCLEVBQXFCLENBQXJCO0FBQ0FBO0FBQ0Q7QUFDRjs7QUFFRCxTQUFPRixNQUFQO0FBQ0QsQ0FoQkQ7O0FBa0JPLFNBQVNmLFNBQVQsQ0FBbUJvQixNQUFuQixFQUEyQkMsTUFBM0IsRUFBbUNiLE9BQW5DLEVBQTRDO0FBQ2pEQSxZQUFVLDhFQUFnQkEsT0FBaEIsRUFBeUIsRUFBQ0csa0JBQWtCLElBQW5CLEVBQXpCLENBQVY7QUFDQSxTQUFPUCxTQUFTa0IsSUFBVCxDQUFjRixNQUFkLEVBQXNCQyxNQUF0QixFQUE4QmIsT0FBOUIsQ0FBUDtBQUNEOztBQUVNLFNBQVNQLGtCQUFULENBQTRCbUIsTUFBNUIsRUFBb0NDLE1BQXBDLEVBQTRDYixPQUE1QyxFQUFxRDtBQUMxRCxTQUFPSixTQUFTa0IsSUFBVCxDQUFjRixNQUFkLEVBQXNCQyxNQUF0QixFQUE4QmIsT0FBOUIsQ0FBUDtBQUNEIiwiZmlsZSI6IndvcmQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgRGlmZiBmcm9tICcuL2Jhc2UnO1xuaW1wb3J0IHtnZW5lcmF0ZU9wdGlvbnN9IGZyb20gJy4uL3V0aWwvcGFyYW1zJztcblxuLy8gQmFzZWQgb24gaHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvTGF0aW5fc2NyaXB0X2luX1VuaWNvZGVcbi8vXG4vLyBSYW5nZXMgYW5kIGV4Y2VwdGlvbnM6XG4vLyBMYXRpbi0xIFN1cHBsZW1lbnQsIDAwODDigJMwMEZGXG4vLyAgLSBVKzAwRDcgIMOXIE11bHRpcGxpY2F0aW9uIHNpZ25cbi8vICAtIFUrMDBGNyAgw7cgRGl2aXNpb24gc2lnblxuLy8gTGF0aW4gRXh0ZW5kZWQtQSwgMDEwMOKAkzAxN0Zcbi8vIExhdGluIEV4dGVuZGVkLUIsIDAxODDigJMwMjRGXG4vLyBJUEEgRXh0ZW5zaW9ucywgMDI1MOKAkzAyQUZcbi8vIFNwYWNpbmcgTW9kaWZpZXIgTGV0dGVycywgMDJCMOKAkzAyRkZcbi8vICAtIFUrMDJDNyAgy4cgJiM3MTE7ICBDYXJvblxuLy8gIC0gVSswMkQ4ICDLmCAmIzcyODsgIEJyZXZlXG4vLyAgLSBVKzAyRDkgIMuZICYjNzI5OyAgRG90IEFib3ZlXG4vLyAgLSBVKzAyREEgIMuaICYjNzMwOyAgUmluZyBBYm92ZVxuLy8gIC0gVSswMkRCICDLmyAmIzczMTsgIE9nb25la1xuLy8gIC0gVSswMkRDICDLnCAmIzczMjsgIFNtYWxsIFRpbGRlXG4vLyAgLSBVKzAyREQgIMudICYjNzMzOyAgRG91YmxlIEFjdXRlIEFjY2VudFxuLy8gTGF0aW4gRXh0ZW5kZWQgQWRkaXRpb25hbCwgMUUwMOKAkzFFRkZcbmNvbnN0IGV4dGVuZGVkV29yZENoYXJzID0gL15bYS16QS1aXFx1e0MwfS1cXHV7RkZ9XFx1e0Q4fS1cXHV7RjZ9XFx1e0Y4fS1cXHV7MkM2fVxcdXsyQzh9LVxcdXsyRDd9XFx1ezJERX0tXFx1ezJGRn1cXHV7MUUwMH0tXFx1ezFFRkZ9XSskL3U7XG5cbmNvbnN0IHJlV2hpdGVzcGFjZSA9IC9cXFMvO1xuXG5leHBvcnQgY29uc3Qgd29yZERpZmYgPSBuZXcgRGlmZigpO1xud29yZERpZmYuZXF1YWxzID0gZnVuY3Rpb24obGVmdCwgcmlnaHQpIHtcbiAgaWYgKHRoaXMub3B0aW9ucy5pZ25vcmVDYXNlKSB7XG4gICAgbGVmdCA9IGxlZnQudG9Mb3dlckNhc2UoKTtcbiAgICByaWdodCA9IHJpZ2h0LnRvTG93ZXJDYXNlKCk7XG4gIH1cbiAgcmV0dXJuIGxlZnQgPT09IHJpZ2h0IHx8ICh0aGlzLm9wdGlvbnMuaWdub3JlV2hpdGVzcGFjZSAmJiAhcmVXaGl0ZXNwYWNlLnRlc3QobGVmdCkgJiYgIXJlV2hpdGVzcGFjZS50ZXN0KHJpZ2h0KSk7XG59O1xud29yZERpZmYudG9rZW5pemUgPSBmdW5jdGlvbih2YWx1ZSkge1xuICBsZXQgdG9rZW5zID0gdmFsdWUuc3BsaXQoLyhcXHMrfFxcYikvKTtcblxuICAvLyBKb2luIHRoZSBib3VuZGFyeSBzcGxpdHMgdGhhdCB3ZSBkbyBub3QgY29uc2lkZXIgdG8gYmUgYm91bmRhcmllcy4gVGhpcyBpcyBwcmltYXJpbHkgdGhlIGV4dGVuZGVkIExhdGluIGNoYXJhY3RlciBzZXQuXG4gIGZvciAobGV0IGkgPSAwOyBpIDwgdG9rZW5zLmxlbmd0aCAtIDE7IGkrKykge1xuICAgIC8vIElmIHdlIGhhdmUgYW4gZW1wdHkgc3RyaW5nIGluIHRoZSBuZXh0IGZpZWxkIGFuZCB3ZSBoYXZlIG9ubHkgd29yZCBjaGFycyBiZWZvcmUgYW5kIGFmdGVyLCBtZXJnZVxuICAgIGlmICghdG9rZW5zW2kgKyAxXSAmJiB0b2tlbnNbaSArIDJdXG4gICAgICAgICAgJiYgZXh0ZW5kZWRXb3JkQ2hhcnMudGVzdCh0b2tlbnNbaV0pXG4gICAgICAgICAgJiYgZXh0ZW5kZWRXb3JkQ2hhcnMudGVzdCh0b2tlbnNbaSArIDJdKSkge1xuICAgICAgdG9rZW5zW2ldICs9IHRva2Vuc1tpICsgMl07XG4gICAgICB0b2tlbnMuc3BsaWNlKGkgKyAxLCAyKTtcbiAgICAgIGktLTtcbiAgICB9XG4gIH1cblxuICByZXR1cm4gdG9rZW5zO1xufTtcblxuZXhwb3J0IGZ1bmN0aW9uIGRpZmZXb3JkcyhvbGRTdHIsIG5ld1N0ciwgb3B0aW9ucykge1xuICBvcHRpb25zID0gZ2VuZXJhdGVPcHRpb25zKG9wdGlvbnMsIHtpZ25vcmVXaGl0ZXNwYWNlOiB0cnVlfSk7XG4gIHJldHVybiB3b3JkRGlmZi5kaWZmKG9sZFN0ciwgbmV3U3RyLCBvcHRpb25zKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGRpZmZXb3Jkc1dpdGhTcGFjZShvbGRTdHIsIG5ld1N0ciwgb3B0aW9ucykge1xuICByZXR1cm4gd29yZERpZmYuZGlmZihvbGRTdHIsIG5ld1N0ciwgb3B0aW9ucyk7XG59XG4iXX0=


/***/ }),
/* 4 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/generateOptions = generateOptions;
	function generateOptions(options, defaults) {
	  if (typeof options === 'function') {
	    defaults.callback = options;
	  } else if (options) {
	    for (var name in options) {
	      /* istanbul ignore else */
	      if (options.hasOwnProperty(name)) {
	        defaults[name] = options[name];
	      }
	    }
	  }
	  return defaults;
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy91dGlsL3BhcmFtcy5qcyJdLCJuYW1lcyI6WyJnZW5lcmF0ZU9wdGlvbnMiLCJvcHRpb25zIiwiZGVmYXVsdHMiLCJjYWxsYmFjayIsIm5hbWUiLCJoYXNPd25Qcm9wZXJ0eSJdLCJtYXBwaW5ncyI6Ijs7O2dDQUFnQkEsZSxHQUFBQSxlO0FBQVQsU0FBU0EsZUFBVCxDQUF5QkMsT0FBekIsRUFBa0NDLFFBQWxDLEVBQTRDO0FBQ2pELE1BQUksT0FBT0QsT0FBUCxLQUFtQixVQUF2QixFQUFtQztBQUNqQ0MsYUFBU0MsUUFBVCxHQUFvQkYsT0FBcEI7QUFDRCxHQUZELE1BRU8sSUFBSUEsT0FBSixFQUFhO0FBQ2xCLFNBQUssSUFBSUcsSUFBVCxJQUFpQkgsT0FBakIsRUFBMEI7QUFDeEI7QUFDQSxVQUFJQSxRQUFRSSxjQUFSLENBQXVCRCxJQUF2QixDQUFKLEVBQWtDO0FBQ2hDRixpQkFBU0UsSUFBVCxJQUFpQkgsUUFBUUcsSUFBUixDQUFqQjtBQUNEO0FBQ0Y7QUFDRjtBQUNELFNBQU9GLFFBQVA7QUFDRCIsImZpbGUiOiJwYXJhbXMuanMiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgZnVuY3Rpb24gZ2VuZXJhdGVPcHRpb25zKG9wdGlvbnMsIGRlZmF1bHRzKSB7XG4gIGlmICh0eXBlb2Ygb3B0aW9ucyA9PT0gJ2Z1bmN0aW9uJykge1xuICAgIGRlZmF1bHRzLmNhbGxiYWNrID0gb3B0aW9ucztcbiAgfSBlbHNlIGlmIChvcHRpb25zKSB7XG4gICAgZm9yIChsZXQgbmFtZSBpbiBvcHRpb25zKSB7XG4gICAgICAvKiBpc3RhbmJ1bCBpZ25vcmUgZWxzZSAqL1xuICAgICAgaWYgKG9wdGlvbnMuaGFzT3duUHJvcGVydHkobmFtZSkpIHtcbiAgICAgICAgZGVmYXVsdHNbbmFtZV0gPSBvcHRpb25zW25hbWVdO1xuICAgICAgfVxuICAgIH1cbiAgfVxuICByZXR1cm4gZGVmYXVsdHM7XG59XG4iXX0=


/***/ }),
/* 5 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.lineDiff = undefined;
	exports. /*istanbul ignore end*/diffLines = diffLines;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/diffTrimmedLines = diffTrimmedLines;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	/*istanbul ignore end*/var /*istanbul ignore start*/_params = __webpack_require__(4) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var lineDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/lineDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	lineDiff.tokenize = function (value) {
	  var retLines = [],
	      linesAndNewlines = value.split(/(\n|\r\n)/);

	  // Ignore the final empty token that occurs if the string ends with a new line
	  if (!linesAndNewlines[linesAndNewlines.length - 1]) {
	    linesAndNewlines.pop();
	  }

	  // Merge the content and line separators into single tokens
	  for (var i = 0; i < linesAndNewlines.length; i++) {
	    var line = linesAndNewlines[i];

	    if (i % 2 && !this.options.newlineIsToken) {
	      retLines[retLines.length - 1] += line;
	    } else {
	      if (this.options.ignoreWhitespace) {
	        line = line.trim();
	      }
	      retLines.push(line);
	    }
	  }

	  return retLines;
	};

	function diffLines(oldStr, newStr, callback) {
	  return lineDiff.diff(oldStr, newStr, callback);
	}
	function diffTrimmedLines(oldStr, newStr, callback) {
	  var options = /*istanbul ignore start*/(0, _params.generateOptions) /*istanbul ignore end*/(callback, { ignoreWhitespace: true });
	  return lineDiff.diff(oldStr, newStr, options);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2xpbmUuanMiXSwibmFtZXMiOlsiZGlmZkxpbmVzIiwiZGlmZlRyaW1tZWRMaW5lcyIsImxpbmVEaWZmIiwidG9rZW5pemUiLCJ2YWx1ZSIsInJldExpbmVzIiwibGluZXNBbmROZXdsaW5lcyIsInNwbGl0IiwibGVuZ3RoIiwicG9wIiwiaSIsImxpbmUiLCJvcHRpb25zIiwibmV3bGluZUlzVG9rZW4iLCJpZ25vcmVXaGl0ZXNwYWNlIiwidHJpbSIsInB1c2giLCJvbGRTdHIiLCJuZXdTdHIiLCJjYWxsYmFjayIsImRpZmYiXSwibWFwcGluZ3MiOiI7Ozs7Z0NBOEJnQkEsUyxHQUFBQSxTO3lEQUNBQyxnQixHQUFBQSxnQjs7QUEvQmhCOzs7O3VCQUNBOzs7O3VCQUVPLElBQU1DLCtFQUFXLHdFQUFqQjtBQUNQQSxTQUFTQyxRQUFULEdBQW9CLFVBQVNDLEtBQVQsRUFBZ0I7QUFDbEMsTUFBSUMsV0FBVyxFQUFmO0FBQUEsTUFDSUMsbUJBQW1CRixNQUFNRyxLQUFOLENBQVksV0FBWixDQUR2Qjs7QUFHQTtBQUNBLE1BQUksQ0FBQ0QsaUJBQWlCQSxpQkFBaUJFLE1BQWpCLEdBQTBCLENBQTNDLENBQUwsRUFBb0Q7QUFDbERGLHFCQUFpQkcsR0FBakI7QUFDRDs7QUFFRDtBQUNBLE9BQUssSUFBSUMsSUFBSSxDQUFiLEVBQWdCQSxJQUFJSixpQkFBaUJFLE1BQXJDLEVBQTZDRSxHQUE3QyxFQUFrRDtBQUNoRCxRQUFJQyxPQUFPTCxpQkFBaUJJLENBQWpCLENBQVg7O0FBRUEsUUFBSUEsSUFBSSxDQUFKLElBQVMsQ0FBQyxLQUFLRSxPQUFMLENBQWFDLGNBQTNCLEVBQTJDO0FBQ3pDUixlQUFTQSxTQUFTRyxNQUFULEdBQWtCLENBQTNCLEtBQWlDRyxJQUFqQztBQUNELEtBRkQsTUFFTztBQUNMLFVBQUksS0FBS0MsT0FBTCxDQUFhRSxnQkFBakIsRUFBbUM7QUFDakNILGVBQU9BLEtBQUtJLElBQUwsRUFBUDtBQUNEO0FBQ0RWLGVBQVNXLElBQVQsQ0FBY0wsSUFBZDtBQUNEO0FBQ0Y7O0FBRUQsU0FBT04sUUFBUDtBQUNELENBeEJEOztBQTBCTyxTQUFTTCxTQUFULENBQW1CaUIsTUFBbkIsRUFBMkJDLE1BQTNCLEVBQW1DQyxRQUFuQyxFQUE2QztBQUFFLFNBQU9qQixTQUFTa0IsSUFBVCxDQUFjSCxNQUFkLEVBQXNCQyxNQUF0QixFQUE4QkMsUUFBOUIsQ0FBUDtBQUFpRDtBQUNoRyxTQUFTbEIsZ0JBQVQsQ0FBMEJnQixNQUExQixFQUFrQ0MsTUFBbEMsRUFBMENDLFFBQTFDLEVBQW9EO0FBQ3pELE1BQUlQLFVBQVUsOEVBQWdCTyxRQUFoQixFQUEwQixFQUFDTCxrQkFBa0IsSUFBbkIsRUFBMUIsQ0FBZDtBQUNBLFNBQU9aLFNBQVNrQixJQUFULENBQWNILE1BQWQsRUFBc0JDLE1BQXRCLEVBQThCTixPQUE5QixDQUFQO0FBQ0QiLCJmaWxlIjoibGluZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBEaWZmIGZyb20gJy4vYmFzZSc7XG5pbXBvcnQge2dlbmVyYXRlT3B0aW9uc30gZnJvbSAnLi4vdXRpbC9wYXJhbXMnO1xuXG5leHBvcnQgY29uc3QgbGluZURpZmYgPSBuZXcgRGlmZigpO1xubGluZURpZmYudG9rZW5pemUgPSBmdW5jdGlvbih2YWx1ZSkge1xuICBsZXQgcmV0TGluZXMgPSBbXSxcbiAgICAgIGxpbmVzQW5kTmV3bGluZXMgPSB2YWx1ZS5zcGxpdCgvKFxcbnxcXHJcXG4pLyk7XG5cbiAgLy8gSWdub3JlIHRoZSBmaW5hbCBlbXB0eSB0b2tlbiB0aGF0IG9jY3VycyBpZiB0aGUgc3RyaW5nIGVuZHMgd2l0aCBhIG5ldyBsaW5lXG4gIGlmICghbGluZXNBbmROZXdsaW5lc1tsaW5lc0FuZE5ld2xpbmVzLmxlbmd0aCAtIDFdKSB7XG4gICAgbGluZXNBbmROZXdsaW5lcy5wb3AoKTtcbiAgfVxuXG4gIC8vIE1lcmdlIHRoZSBjb250ZW50IGFuZCBsaW5lIHNlcGFyYXRvcnMgaW50byBzaW5nbGUgdG9rZW5zXG4gIGZvciAobGV0IGkgPSAwOyBpIDwgbGluZXNBbmROZXdsaW5lcy5sZW5ndGg7IGkrKykge1xuICAgIGxldCBsaW5lID0gbGluZXNBbmROZXdsaW5lc1tpXTtcblxuICAgIGlmIChpICUgMiAmJiAhdGhpcy5vcHRpb25zLm5ld2xpbmVJc1Rva2VuKSB7XG4gICAgICByZXRMaW5lc1tyZXRMaW5lcy5sZW5ndGggLSAxXSArPSBsaW5lO1xuICAgIH0gZWxzZSB7XG4gICAgICBpZiAodGhpcy5vcHRpb25zLmlnbm9yZVdoaXRlc3BhY2UpIHtcbiAgICAgICAgbGluZSA9IGxpbmUudHJpbSgpO1xuICAgICAgfVxuICAgICAgcmV0TGluZXMucHVzaChsaW5lKTtcbiAgICB9XG4gIH1cblxuICByZXR1cm4gcmV0TGluZXM7XG59O1xuXG5leHBvcnQgZnVuY3Rpb24gZGlmZkxpbmVzKG9sZFN0ciwgbmV3U3RyLCBjYWxsYmFjaykgeyByZXR1cm4gbGluZURpZmYuZGlmZihvbGRTdHIsIG5ld1N0ciwgY2FsbGJhY2spOyB9XG5leHBvcnQgZnVuY3Rpb24gZGlmZlRyaW1tZWRMaW5lcyhvbGRTdHIsIG5ld1N0ciwgY2FsbGJhY2spIHtcbiAgbGV0IG9wdGlvbnMgPSBnZW5lcmF0ZU9wdGlvbnMoY2FsbGJhY2ssIHtpZ25vcmVXaGl0ZXNwYWNlOiB0cnVlfSk7XG4gIHJldHVybiBsaW5lRGlmZi5kaWZmKG9sZFN0ciwgbmV3U3RyLCBvcHRpb25zKTtcbn1cbiJdfQ==


/***/ }),
/* 6 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.sentenceDiff = undefined;
	exports. /*istanbul ignore end*/diffSentences = diffSentences;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var sentenceDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/sentenceDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	sentenceDiff.tokenize = function (value) {
	  return value.split(/(\S.+?[.!?])(?=\s+|$)/);
	};

	function diffSentences(oldStr, newStr, callback) {
	  return sentenceDiff.diff(oldStr, newStr, callback);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL3NlbnRlbmNlLmpzIl0sIm5hbWVzIjpbImRpZmZTZW50ZW5jZXMiLCJzZW50ZW5jZURpZmYiLCJ0b2tlbml6ZSIsInZhbHVlIiwic3BsaXQiLCJvbGRTdHIiLCJuZXdTdHIiLCJjYWxsYmFjayIsImRpZmYiXSwibWFwcGluZ3MiOiI7Ozs7Z0NBUWdCQSxhLEdBQUFBLGE7O0FBUmhCOzs7Ozs7dUJBR08sSUFBTUMsdUZBQWUsd0VBQXJCO0FBQ1BBLGFBQWFDLFFBQWIsR0FBd0IsVUFBU0MsS0FBVCxFQUFnQjtBQUN0QyxTQUFPQSxNQUFNQyxLQUFOLENBQVksdUJBQVosQ0FBUDtBQUNELENBRkQ7O0FBSU8sU0FBU0osYUFBVCxDQUF1QkssTUFBdkIsRUFBK0JDLE1BQS9CLEVBQXVDQyxRQUF2QyxFQUFpRDtBQUFFLFNBQU9OLGFBQWFPLElBQWIsQ0FBa0JILE1BQWxCLEVBQTBCQyxNQUExQixFQUFrQ0MsUUFBbEMsQ0FBUDtBQUFxRCIsImZpbGUiOiJzZW50ZW5jZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBEaWZmIGZyb20gJy4vYmFzZSc7XG5cblxuZXhwb3J0IGNvbnN0IHNlbnRlbmNlRGlmZiA9IG5ldyBEaWZmKCk7XG5zZW50ZW5jZURpZmYudG9rZW5pemUgPSBmdW5jdGlvbih2YWx1ZSkge1xuICByZXR1cm4gdmFsdWUuc3BsaXQoLyhcXFMuKz9bLiE/XSkoPz1cXHMrfCQpLyk7XG59O1xuXG5leHBvcnQgZnVuY3Rpb24gZGlmZlNlbnRlbmNlcyhvbGRTdHIsIG5ld1N0ciwgY2FsbGJhY2spIHsgcmV0dXJuIHNlbnRlbmNlRGlmZi5kaWZmKG9sZFN0ciwgbmV3U3RyLCBjYWxsYmFjayk7IH1cbiJdfQ==


/***/ }),
/* 7 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.cssDiff = undefined;
	exports. /*istanbul ignore end*/diffCss = diffCss;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var cssDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/cssDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	cssDiff.tokenize = function (value) {
	  return value.split(/([{}:;,]|\s+)/);
	};

	function diffCss(oldStr, newStr, callback) {
	  return cssDiff.diff(oldStr, newStr, callback);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2Nzcy5qcyJdLCJuYW1lcyI6WyJkaWZmQ3NzIiwiY3NzRGlmZiIsInRva2VuaXplIiwidmFsdWUiLCJzcGxpdCIsIm9sZFN0ciIsIm5ld1N0ciIsImNhbGxiYWNrIiwiZGlmZiJdLCJtYXBwaW5ncyI6Ijs7OztnQ0FPZ0JBLE8sR0FBQUEsTzs7QUFQaEI7Ozs7Ozt1QkFFTyxJQUFNQyw2RUFBVSx3RUFBaEI7QUFDUEEsUUFBUUMsUUFBUixHQUFtQixVQUFTQyxLQUFULEVBQWdCO0FBQ2pDLFNBQU9BLE1BQU1DLEtBQU4sQ0FBWSxlQUFaLENBQVA7QUFDRCxDQUZEOztBQUlPLFNBQVNKLE9BQVQsQ0FBaUJLLE1BQWpCLEVBQXlCQyxNQUF6QixFQUFpQ0MsUUFBakMsRUFBMkM7QUFBRSxTQUFPTixRQUFRTyxJQUFSLENBQWFILE1BQWIsRUFBcUJDLE1BQXJCLEVBQTZCQyxRQUE3QixDQUFQO0FBQWdEIiwiZmlsZSI6ImNzcy5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBEaWZmIGZyb20gJy4vYmFzZSc7XG5cbmV4cG9ydCBjb25zdCBjc3NEaWZmID0gbmV3IERpZmYoKTtcbmNzc0RpZmYudG9rZW5pemUgPSBmdW5jdGlvbih2YWx1ZSkge1xuICByZXR1cm4gdmFsdWUuc3BsaXQoLyhbe306OyxdfFxccyspLyk7XG59O1xuXG5leHBvcnQgZnVuY3Rpb24gZGlmZkNzcyhvbGRTdHIsIG5ld1N0ciwgY2FsbGJhY2spIHsgcmV0dXJuIGNzc0RpZmYuZGlmZihvbGRTdHIsIG5ld1N0ciwgY2FsbGJhY2spOyB9XG4iXX0=


/***/ }),
/* 8 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.jsonDiff = undefined;

	var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

	exports. /*istanbul ignore end*/diffJson = diffJson;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/canonicalize = canonicalize;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	/*istanbul ignore end*/var /*istanbul ignore start*/_line = __webpack_require__(5) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var objectPrototypeToString = Object.prototype.toString;

	var jsonDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/jsonDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	// Discriminate between two lines of pretty-printed, serialized JSON where one of them has a
	// dangling comma and the other doesn't. Turns out including the dangling comma yields the nicest output:
	jsonDiff.useLongestToken = true;

	jsonDiff.tokenize = /*istanbul ignore start*/_line.lineDiff /*istanbul ignore end*/.tokenize;
	jsonDiff.castInput = function (value) {
	  /*istanbul ignore start*/var _options = /*istanbul ignore end*/this.options,
	      undefinedReplacement = _options.undefinedReplacement,
	      _options$stringifyRep = _options.stringifyReplacer,
	      stringifyReplacer = _options$stringifyRep === undefined ? function (k, v) /*istanbul ignore start*/{
	    return (/*istanbul ignore end*/typeof v === 'undefined' ? undefinedReplacement : v
	    );
	  } : _options$stringifyRep;


	  return typeof value === 'string' ? value : JSON.stringify(canonicalize(value, null, null, stringifyReplacer), stringifyReplacer, '  ');
	};
	jsonDiff.equals = function (left, right) {
	  return (/*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/.prototype.equals.call(jsonDiff, left.replace(/,([\r\n])/g, '$1'), right.replace(/,([\r\n])/g, '$1'))
	  );
	};

	function diffJson(oldObj, newObj, options) {
	  return jsonDiff.diff(oldObj, newObj, options);
	}

	// This function handles the presence of circular references by bailing out when encountering an
	// object that is already on the "stack" of items being processed. Accepts an optional replacer
	function canonicalize(obj, stack, replacementStack, replacer, key) {
	  stack = stack || [];
	  replacementStack = replacementStack || [];

	  if (replacer) {
	    obj = replacer(key, obj);
	  }

	  var i = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;

	  for (i = 0; i < stack.length; i += 1) {
	    if (stack[i] === obj) {
	      return replacementStack[i];
	    }
	  }

	  var canonicalizedObj = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;

	  if ('[object Array]' === objectPrototypeToString.call(obj)) {
	    stack.push(obj);
	    canonicalizedObj = new Array(obj.length);
	    replacementStack.push(canonicalizedObj);
	    for (i = 0; i < obj.length; i += 1) {
	      canonicalizedObj[i] = canonicalize(obj[i], stack, replacementStack, replacer, key);
	    }
	    stack.pop();
	    replacementStack.pop();
	    return canonicalizedObj;
	  }

	  if (obj && obj.toJSON) {
	    obj = obj.toJSON();
	  }

	  if ( /*istanbul ignore start*/(typeof /*istanbul ignore end*/obj === 'undefined' ? 'undefined' : _typeof(obj)) === 'object' && obj !== null) {
	    stack.push(obj);
	    canonicalizedObj = {};
	    replacementStack.push(canonicalizedObj);
	    var sortedKeys = [],
	        _key = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;
	    for (_key in obj) {
	      /* istanbul ignore else */
	      if (obj.hasOwnProperty(_key)) {
	        sortedKeys.push(_key);
	      }
	    }
	    sortedKeys.sort();
	    for (i = 0; i < sortedKeys.length; i += 1) {
	      _key = sortedKeys[i];
	      canonicalizedObj[_key] = canonicalize(obj[_key], stack, replacementStack, replacer, _key);
	    }
	    stack.pop();
	    replacementStack.pop();
	  } else {
	    canonicalizedObj = obj;
	  }
	  return canonicalizedObj;
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2pzb24uanMiXSwibmFtZXMiOlsiZGlmZkpzb24iLCJjYW5vbmljYWxpemUiLCJvYmplY3RQcm90b3R5cGVUb1N0cmluZyIsIk9iamVjdCIsInByb3RvdHlwZSIsInRvU3RyaW5nIiwianNvbkRpZmYiLCJ1c2VMb25nZXN0VG9rZW4iLCJ0b2tlbml6ZSIsImNhc3RJbnB1dCIsInZhbHVlIiwib3B0aW9ucyIsInVuZGVmaW5lZFJlcGxhY2VtZW50Iiwic3RyaW5naWZ5UmVwbGFjZXIiLCJrIiwidiIsIkpTT04iLCJzdHJpbmdpZnkiLCJlcXVhbHMiLCJsZWZ0IiwicmlnaHQiLCJjYWxsIiwicmVwbGFjZSIsIm9sZE9iaiIsIm5ld09iaiIsImRpZmYiLCJvYmoiLCJzdGFjayIsInJlcGxhY2VtZW50U3RhY2siLCJyZXBsYWNlciIsImtleSIsImkiLCJsZW5ndGgiLCJjYW5vbmljYWxpemVkT2JqIiwicHVzaCIsIkFycmF5IiwicG9wIiwidG9KU09OIiwic29ydGVkS2V5cyIsImhhc093blByb3BlcnR5Iiwic29ydCJdLCJtYXBwaW5ncyI6Ijs7Ozs7OztnQ0FxQmdCQSxRLEdBQUFBLFE7eURBSUFDLFksR0FBQUEsWTs7QUF6QmhCOzs7O3VCQUNBOzs7O3VCQUVBLElBQU1DLDBCQUEwQkMsT0FBT0MsU0FBUCxDQUFpQkMsUUFBakQ7O0FBR08sSUFBTUMsK0VBQVcsd0VBQWpCO0FBQ1A7QUFDQTtBQUNBQSxTQUFTQyxlQUFULEdBQTJCLElBQTNCOztBQUVBRCxTQUFTRSxRQUFULEdBQW9CLGdFQUFTQSxRQUE3QjtBQUNBRixTQUFTRyxTQUFULEdBQXFCLFVBQVNDLEtBQVQsRUFBZ0I7QUFBQSxpRUFDK0UsS0FBS0MsT0FEcEY7QUFBQSxNQUM1QkMsb0JBRDRCLFlBQzVCQSxvQkFENEI7QUFBQSx1Q0FDTkMsaUJBRE07QUFBQSxNQUNOQSxpQkFETSx5Q0FDYyxVQUFDQyxDQUFELEVBQUlDLENBQUo7QUFBQSxtQ0FBVSxPQUFPQSxDQUFQ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QUFLVCxJQUFJLENBQVQsRUFBWUEsSUFBSU8sV0FBV04sTUFBM0IsRUFBbUNELEtBQUssQ0FBeEMsRUFBMkM7QUFDekNELGFBQU1RLFdBQVdQLENBQVgsQ0FBTjtBQUNBRSx1QkFBaUJILElBQWpCLElBQXdCN0IsYUFBYXlCLElBQUlJLElBQUosQ0FBYixFQUF1QkgsS0FBdkIsRUFBOEJDLGdCQUE5QixFQUFnREMsUUFBaEQsRUFBMERDLElBQTFELENBQXhCO0FBQ0Q7QUFDREgsVUFBTVMsR0FBTjtBQUNBUixxQkFBaUJRLEdBQWpCO0FBQ0QsR0FuQkQsTUFtQk87QUFDTEgsdUJBQW1CUCxHQUFuQjtBQUNEO0FBQ0QsU0FBT08sZ0JBQVA7QUFDRCIsImZpbGUiOiJqc29uLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IERpZmYgZnJvbSAnLi9iYXNlJztcbmltcG9ydCB7bGluZURpZmZ9IGZyb20gJy4vbGluZSc7XG5cbmNvbnN0IG9iamVjdFByb3RvdHlwZVRvU3RyaW5nID0gT2JqZWN0LnByb3RvdHlwZS50b1N0cmluZztcblxuXG5leHBvcnQgY29uc3QganNvbkRpZmYgPSBuZXcgRGlmZigpO1xuLy8gRGlzY3JpbWluYXRlIGJldHdlZW4gdHdvIGxpbmVzIG9mIHByZXR0eS1wcmludGVkLCBzZXJpYWxpemVkIEpTT04gd2hlcmUgb25lIG9mIHRoZW0gaGFzIGFcbi8vIGRhbmdsaW5nIGNvbW1hIGFuZCB0aGUgb3RoZXIgZG9lc24ndC4gVHVybnMgb3V0IGluY2x1ZGluZyB0aGUgZGFuZ2xpbmcgY29tbWEgeWllbGRzIHRoZSBuaWNlc3Qgb3V0cHV0OlxuanNvbkRpZmYudXNlTG9uZ2VzdFRva2VuID0gdHJ1ZTtcblxuanNvbkRpZmYudG9rZW5pemUgPSBsaW5lRGlmZi50b2tlbml6ZTtcbmpzb25EaWZmLmNhc3RJbnB1dCA9IGZ1bmN0aW9uKHZhbHVlKSB7XG4gIGNvbnN0IHt1bmRlZmluZWRSZXBsYWNlbWVudCwgc3RyaW5naWZ5UmVwbGFjZXIgPSAoaywgdikgPT4gdHlwZW9mIHYgPT09ICd1bmRlZmluZWQnID8gdW5kZWZpbmVkUmVwbGFjZW1lbnQgOiB2fSA9IHRoaXMub3B0aW9ucztcblxuICByZXR1cm4gdHlwZW9mIHZhbHVlID09PSAnc3RyaW5nJyA/IHZhbHVlIDogSlNPTi5zdHJpbmdpZnkoY2Fub25pY2FsaXplKHZhbHVlLCBudWxsLCBudWxsLCBzdHJpbmdpZnlSZXBsYWNlciksIHN0cmluZ2lmeVJlcGxhY2VyLCAnICAnKTtcbn07XG5qc29uRGlmZi5lcXVhbHMgPSBmdW5jdGlvbihsZWZ0LCByaWdodCkge1xuICByZXR1cm4gRGlmZi5wcm90b3R5cGUuZXF1YWxzLmNhbGwoanNvbkRpZmYsIGxlZnQucmVwbGFjZSgvLChbXFxyXFxuXSkvZywgJyQxJyksIHJpZ2h0LnJlcGxhY2UoLywoW1xcclxcbl0pL2csICckMScpKTtcbn07XG5cbmV4cG9ydCBmdW5jdGlvbiBkaWZmSnNvbihvbGRPYmosIG5ld09iaiwgb3B0aW9ucykgeyByZXR1cm4ganNvbkRpZmYuZGlmZihvbGRPYmosIG5ld09iaiwgb3B0aW9ucyk7IH1cblxuLy8gVGhpcyBmdW5jdGlvbiBoYW5kbGVzIHRoZSBwcmVzZW5jZSBvZiBjaXJjdWxhciByZWZlcmVuY2VzIGJ5IGJhaWxpbmcgb3V0IHdoZW4gZW5jb3VudGVyaW5nIGFuXG4vLyBvYmplY3QgdGhhdCBpcyBhbHJlYWR5IG9uIHRoZSBcInN0YWNrXCIgb2YgaXRlbXMgYmVpbmcgcHJvY2Vzc2VkLiBBY2NlcHRzIGFuIG9wdGlvbmFsIHJlcGxhY2VyXG5leHBvcnQgZnVuY3Rpb24gY2Fub25pY2FsaXplKG9iaiwgc3RhY2ssIHJlcGxhY2VtZW50U3RhY2ssIHJlcGxhY2VyLCBrZXkpIHtcbiAgc3RhY2sgPSBzdGFjayB8fCBbXTtcbiAgcmVwbGFjZW1lbnRTdGFjayA9IHJlcGxhY2VtZW50U3RhY2sgfHwgW107XG5cbiAgaWYgKHJlcGxhY2VyKSB7XG4gICAgb2JqID0gcmVwbGFjZXIoa2V5LCBvYmopO1xuICB9XG5cbiAgbGV0IGk7XG5cbiAgZm9yIChpID0gMDsgaSA8IHN0YWNrLmxlbmd0aDsgaSArPSAxKSB7XG4gICAgaWYgKHN0YWNrW2ldID09PSBvYmopIHtcbiAgICAgIHJldHVybiByZXBsYWNlbWVudFN0YWNrW2ldO1xuICAgIH1cbiAgfVxuXG4gIGxldCBjYW5vbmljYWxpemVkT2JqO1xuXG4gIGlmICgnW29iamVjdCBBcnJheV0nID09PSBvYmplY3RQcm90b3R5cGVUb1N0cmluZy5jYWxsKG9iaikpIHtcbiAgICBzdGFjay5wdXNoKG9iaik7XG4gICAgY2Fub25pY2FsaXplZE9iaiA9IG5ldyBBcnJheShvYmoubGVuZ3RoKTtcbiAgICByZXBsYWNlbWVudFN0YWNrLnB1c2goY2Fub25pY2FsaXplZE9iaik7XG4gICAgZm9yIChpID0gMDsgaSA8IG9iai5sZW5ndGg7IGkgKz0gMSkge1xuICAgICAgY2Fub25pY2FsaXplZE9ialtpXSA9IGNhbm9uaWNhbGl6ZShvYmpbaV0sIHN0YWNrLCByZXBsYWNlbWVudFN0YWNrLCByZXBsYWNlciwga2V5KTtcbiAgICB9XG4gICAgc3RhY2sucG9wKCk7XG4gICAgcmVwbGFjZW1lbnRTdGFjay5wb3AoKTtcbiAgICByZXR1cm4gY2Fub25pY2FsaXplZE9iajtcbiAgfVxuXG4gIGlmIChvYmogJiYgb2JqLnRvSlNPTikge1xuICAgIG9iaiA9IG9iai50b0pTT04oKTtcbiAgfVxuXG4gIGlmICh0eXBlb2Ygb2JqID09PSAnb2JqZWN0JyAmJiBvYmogIT09IG51bGwpIHtcbiAgICBzdGFjay5wdXNoKG9iaik7XG4gICAgY2Fub25pY2FsaXplZE9iaiA9IHt9O1xuICAgIHJlcGxhY2VtZW50U3RhY2sucHVzaChjYW5vbmljYWxpemVkT2JqKTtcbiAgICBsZXQgc29ydGVkS2V5cyA9IFtdLFxuICAgICAgICBrZXk7XG4gICAgZm9yIChrZXkgaW4gb2JqKSB7XG4gICAgICAvKiBpc3RhbmJ1bCBpZ25vcmUgZWxzZSAqL1xuICAgICAgaWYgKG9iai5oYXNPd25Qcm9wZXJ0eShrZXkpKSB7XG4gICAgICAgIHNvcnRlZEtleXMucHVzaChrZXkpO1xuICAgICAgfVxuICAgIH1cbiAgICBzb3J0ZWRLZXlzLnNvcnQoKTtcbiAgICBmb3IgKGkgPSAwOyBpIDwgc29ydGVkS2V5cy5sZW5ndGg7IGkgKz0gMSkge1xuICAgICAga2V5ID0gc29ydGVkS2V5c1tpXTtcbiAgICAgIGNhbm9uaWNhbGl6ZWRPYmpba2V5XSA9IGNhbm9uaWNhbGl6ZShvYmpba2V5XSwgc3RhY2ssIHJlcGxhY2VtZW50U3RhY2ssIHJlcGxhY2VyLCBrZXkpO1xuICAgIH1cbiAgICBzdGFjay5wb3AoKTtcbiAgICByZXBsYWNlbWVudFN0YWNrLnBvcCgpO1xuICB9IGVsc2Uge1xuICAgIGNhbm9uaWNhbGl6ZWRPYmogPSBvYmo7XG4gIH1cbiAgcmV0dXJuIGNhbm9uaWNhbGl6ZWRPYmo7XG59XG4iXX0=


/***/ }),
/* 9 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports.arrayDiff = undefined;
	exports. /*istanbul ignore end*/diffArrays = diffArrays;

	var /*istanbul ignore start*/_base = __webpack_require__(1) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _base2 = _interopRequireDefault(_base);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/var arrayDiff = /*istanbul ignore start*/exports. /*istanbul ignore end*/arrayDiff = new /*istanbul ignore start*/_base2['default'] /*istanbul ignore end*/();
	arrayDiff.tokenize = function (value) {
	  return value.slice();
	};
	arrayDiff.join = arrayDiff.removeEmpty = function (value) {
	  return value;
	};

	function diffArrays(oldArr, newArr, callback) {
	  return arrayDiff.diff(oldArr, newArr, callback);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9kaWZmL2FycmF5LmpzIl0sIm5hbWVzIjpbImRpZmZBcnJheXMiLCJhcnJheURpZmYiLCJ0b2tlbml6ZSIsInZhbHVlIiwic2xpY2UiLCJqb2luIiwicmVtb3ZlRW1wdHkiLCJvbGRBcnIiLCJuZXdBcnIiLCJjYWxsYmFjayIsImRpZmYiXSwibWFwcGluZ3MiOiI7Ozs7Z0NBVWdCQSxVLEdBQUFBLFU7O0FBVmhCOzs7Ozs7dUJBRU8sSUFBTUMsaUZBQVksd0VBQWxCO0FBQ1BBLFVBQVVDLFFBQVYsR0FBcUIsVUFBU0MsS0FBVCxFQUFnQjtBQUNuQyxTQUFPQSxNQUFNQyxLQUFOLEVBQVA7QUFDRCxDQUZEO0FBR0FILFVBQVVJLElBQVYsR0FBaUJKLFVBQVVLLFdBQVYsR0FBd0IsVUFBU0gsS0FBVCxFQUFnQjtBQUN2RCxTQUFPQSxLQUFQO0FBQ0QsQ0FGRDs7QUFJTyxTQUFTSCxVQUFULENBQW9CTyxNQUFwQixFQUE0QkMsTUFBNUIsRUFBb0NDLFFBQXBDLEVBQThDO0FBQUUsU0FBT1IsVUFBVVMsSUFBVixDQUFlSCxNQUFmLEVBQXVCQyxNQUF2QixFQUErQkMsUUFBL0IsQ0FBUDtBQUFrRCIsImZpbGUiOiJhcnJheS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBEaWZmIGZyb20gJy4vYmFzZSc7XG5cbmV4cG9ydCBjb25zdCBhcnJheURpZmYgPSBuZXcgRGlmZigpO1xuYXJyYXlEaWZmLnRva2VuaXplID0gZnVuY3Rpb24odmFsdWUpIHtcbiAgcmV0dXJuIHZhbHVlLnNsaWNlKCk7XG59O1xuYXJyYXlEaWZmLmpvaW4gPSBhcnJheURpZmYucmVtb3ZlRW1wdHkgPSBmdW5jdGlvbih2YWx1ZSkge1xuICByZXR1cm4gdmFsdWU7XG59O1xuXG5leHBvcnQgZnVuY3Rpb24gZGlmZkFycmF5cyhvbGRBcnIsIG5ld0FyciwgY2FsbGJhY2spIHsgcmV0dXJuIGFycmF5RGlmZi5kaWZmKG9sZEFyciwgbmV3QXJyLCBjYWxsYmFjayk7IH1cbiJdfQ==


/***/ }),
/* 10 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/applyPatch = applyPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/applyPatches = applyPatches;

	var /*istanbul ignore start*/_parse = __webpack_require__(11) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_distanceIterator = __webpack_require__(12) /*istanbul ignore end*/;

	/*istanbul ignore start*/var _distanceIterator2 = _interopRequireDefault(_distanceIterator);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }

	/*istanbul ignore end*/function applyPatch(source, uniDiff) {
	  /*istanbul ignore start*/var /*istanbul ignore end*/options = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};

	  if (typeof uniDiff === 'string') {
	    uniDiff = /*istanbul ignore start*/(0, _parse.parsePatch) /*istanbul ignore end*/(uniDiff);
	  }

	  if (Array.isArray(uniDiff)) {
	    if (uniDiff.length > 1) {
	      throw new Error('applyPatch only works with a single input.');
	    }

	    uniDiff = uniDiff[0];
	  }

	  // Apply the diff to the input
	  var lines = source.split(/\r\n|[\n\v\f\r\x85]/),
	      delimiters = source.match(/\r\n|[\n\v\f\r\x85]/g) || [],
	      hunks = uniDiff.hunks,
	      compareLine = options.compareLine || function (lineNumber, line, operation, patchContent) /*istanbul ignore start*/{
	    return (/*istanbul ignore end*/line === patchContent
	    );
	  },
	      errorCount = 0,
	      fuzzFactor = options.fuzzFactor || 0,
	      minLine = 0,
	      offset = 0,
	      removeEOFNL = /*istanbul ignore start*/void 0 /*istanbul ignore end*/,
	      addEOFNL = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;

	  /**
	   * Checks if the hunk exactly fits on the provided location
	   */
	  function hunkFits(hunk, toPos) {
	    for (var j = 0; j < hunk.lines.length; j++) {
	      var line = hunk.lines[j],
	          operation = line.length > 0 ? line[0] : ' ',
	          content = line.length > 0 ? line.substr(1) : line;

	      if (operation === ' ' || operation === '-') {
	        // Context sanity check
	        if (!compareLine(toPos + 1, lines[toPos], operation, content)) {
	          errorCount++;

	          if (errorCount > fuzzFactor) {
	            return false;
	          }
	        }
	        toPos++;
	      }
	    }

	    return true;
	  }

	  // Search best fit offsets for each hunk based on the previous ones
	  for (var i = 0; i < hunks.length; i++) {
	    var hunk = hunks[i],
	        maxLine = lines.length - hunk.oldLines,
	        localOffset = 0,
	        toPos = offset + hunk.oldStart - 1;

	    var iterator = /*istanbul ignore start*/(0, _distanceIterator2['default']) /*istanbul ignore end*/(toPos, minLine, maxLine);

	    for (; localOffset !== undefined; localOffset = iterator()) {
	      if (hunkFits(hunk, toPos + localOffset)) {
	        hunk.offset = offset += localOffset;
	        break;
	      }
	    }

	    if (localOffset === undefined) {
	      return false;
	    }

	    // Set lower text limit to end of the current hunk, so next ones don't try
	    // to fit over already patched text
	    minLine = hunk.offset + hunk.oldStart + hunk.oldLines;
	  }

	  // Apply patch hunks
	  var diffOffset = 0;
	  for (var _i = 0; _i < hunks.length; _i++) {
	    var _hunk = hunks[_i],
	        _toPos = _hunk.oldStart + _hunk.offset + diffOffset - 1;
	    diffOffset += _hunk.newLines - _hunk.oldLines;

	    if (_toPos < 0) {
	      // Creating a new file
	      _toPos = 0;
	    }

	    for (var j = 0; j < _hunk.lines.length; j++) {
	      var line = _hunk.lines[j],
	          operation = line.length > 0 ? line[0] : ' ',
	          content = line.length > 0 ? line.substr(1) : line,
	          delimiter = _hunk.linedelimiters[j];

	      if (operation === ' ') {
	        _toPos++;
	      } else if (operation === '-') {
	        lines.splice(_toPos, 1);
	        delimiters.splice(_toPos, 1);
	        /* istanbul ignore else */
	      } else if (operation === '+') {
	        lines.splice(_toPos, 0, content);
	        delimiters.splice(_toPos, 0, delimiter);
	        _toPos++;
	      } else if (operation === '\\') {
	        var previousOperation = _hunk.lines[j - 1] ? _hunk.lines[j - 1][0] : null;
	        if (previousOperation === '+') {
	          removeEOFNL = true;
	        } else if (previousOperation === '-') {
	          addEOFNL = true;
	        }
	      }
	    }
	  }

	  // Handle EOFNL insertion/removal
	  if (removeEOFNL) {
	    while (!lines[lines.length - 1]) {
	      lines.pop();
	      delimiters.pop();
	    }
	  } else if (addEOFNL) {
	    lines.push('');
	    delimiters.push('\n');
	  }
	  for (var _k = 0; _k < lines.length - 1; _k++) {
	    lines[_k] = lines[_k] + delimiters[_k];
	  }
	  return lines.join('');
	}

	// Wrapper that supports multiple file patches via callbacks.
	function applyPatches(uniDiff, options) {
	  if (typeof uniDiff === 'string') {
	    uniDiff = /*istanbul ignore start*/(0, _parse.parsePatch) /*istanbul ignore end*/(uniDiff);
	  }

	  var currentIndex = 0;
	  function processIndex() {
	    var index = uniDiff[currentIndex++];
	    if (!index) {
	      return options.complete();
	    }

	    options.loadFile(index, function (err, data) {
	      if (err) {
	        return options.complete(err);
	      }

	      var updatedContent = applyPatch(data, index, options);
	      options.patched(index, updatedContent, function (err) {
	        if (err) {
	          return options.complete(err);
	        }

	        processIndex();
	      });
	    });
	  }
	  processIndex();
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9wYXRjaC9hcHBseS5qcyJdLCJuYW1lcyI6WyJhcHBseVBhdGNoIiwiYXBwbHlQYXRjaGVzIiwic291cmNlIiwidW5pRGlmZiIsIm9wdGlvbnMiLCJBcnJheSIsImlzQXJyYXkiLCJsZW5ndGgiLCJFcnJvciIsImxpbmVzIiwic3BsaXQiLCJkZWxpbWl0ZXJzIiwibWF0Y2giLCJodW5rcyIsImNvbXBhcmVMaW5lIiwibGluZU51bWJlciIsImxpbmUiLCJvcGVyYXRpb24iLCJwYXRjaENvbnRlbnQiLCJlcnJvckNvdW50IiwiZnV6ekZhY3RvciIsIm1pbkxpbmUiLCJvZmZzZXQiLCJyZW1vdmVFT0ZOTCIsImFkZEVPRk5MIiwiaHVua0ZpdHMiLCJodW5rIiwidG9Qb3MiLCJqIiwiY29udGVudCIsInN1YnN0ciIsImkiLCJtYXhMaW5lIiwib2xkTGluZXMiLCJsb2NhbE9mZnNldCIsIm9sZFN0YXJ0IiwiaXRlcmF0b3IiLCJ1bmRlZmluZWQiLCJkaWZmT2Zmc2V0IiwibmV3TGluZXMiLCJkZWxpbWl0ZXIiLCJsaW5lZGVsaW1pdGVycyIsInNwbGljZSIsInByZXZpb3VzT3BlcmF0aW9uIiwicG9wIiwicHVzaCIsIl9rIiwiam9pbiIsImN1cnJlbnRJbmRleCIsInByb2Nlc3NJbmRleCIsImluZGV4IiwiY29tcGxldGUiLCJsb2FkRmlsZSIsImVyciIsImRhdGEiLCJ1cGRhdGVkQ29udGVudCIsInBhdGNoZWQiXSwibWFwcGluZ3MiOiI7OztnQ0FHZ0JBLFUsR0FBQUEsVTt5REFvSUFDLFksR0FBQUEsWTs7QUF2SWhCOztBQUNBOzs7Ozs7dUJBRU8sU0FBU0QsVUFBVCxDQUFvQkUsTUFBcEIsRUFBNEJDLE9BQTVCLEVBQW1EO0FBQUEsc0RBQWRDLE9BQWMsdUVBQUosRUFBSTs7QUFDeEQsTUFBSSxPQUFPRCxPQUFQLEtBQW1CLFFBQXZCLEVBQWlDO0FBQy9CQSxjQUFVLHdFQUFXQSxPQUFYLENBQVY7QUFDRDs7QUFFRCxNQUFJRSxNQUFNQyxP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QUFZO0FBQ1YsYUFBTzlDLFFBQVErQyxRQUFSLEVBQVA7QUFDRDs7QUFFRC9DLFlBQVFnRCxRQUFSLENBQWlCRixLQUFqQixFQUF3QixVQUFTRyxHQUFULEVBQWNDLElBQWQsRUFBb0I7QUFDMUMsVUFBSUQsR0FBSixFQUFTO0FBQ1AsZUFBT2pELFFBQVErQyxRQUFSLENBQWlCRSxHQUFqQixDQUFQO0FBQ0Q7O0FBRUQsVUFBSUUsaUJBQWlCdkQsV0FBV3NELElBQVgsRUFBaUJKLEtBQWpCLEVBQXdCOUMsT0FBeEIsQ0FBckI7QUFDQUEsY0FBUW9ELE9BQVIsQ0FBZ0JOLEtBQWhCLEVBQXVCSyxjQUF2QixFQUF1QyxVQUFTRixHQUFULEVBQWM7QUFDbkQsWUFBSUEsR0FBSixFQUFTO0FBQ1AsaUJBQU9qRCxRQUFRK0MsUUFBUixDQUFpQkUsR0FBakIsQ0FBUDtBQUNEOztBQUVESjtBQUNELE9BTkQ7QUFPRCxLQWJEO0FBY0Q7QUFDREE7QUFDRCIsImZpbGUiOiJhcHBseS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7cGFyc2VQYXRjaH0gZnJvbSAnLi9wYXJzZSc7XG5pbXBvcnQgZGlzdGFuY2VJdGVyYXRvciBmcm9tICcuLi91dGlsL2Rpc3RhbmNlLWl0ZXJhdG9yJztcblxuZXhwb3J0IGZ1bmN0aW9uIGFwcGx5UGF0Y2goc291cmNlLCB1bmlEaWZmLCBvcHRpb25zID0ge30pIHtcbiAgaWYgKHR5cGVvZiB1bmlEaWZmID09PSAnc3RyaW5nJykge1xuICAgIHVuaURpZmYgPSBwYXJzZVBhdGNoKHVuaURpZmYpO1xuICB9XG5cbiAgaWYgKEFycmF5LmlzQXJyYXkodW5pRGlmZikpIHtcbiAgICBpZiAodW5pRGlmZi5sZW5ndGggPiAxKSB7XG4gICAgICB0aHJvdyBuZXcgRXJyb3IoJ2FwcGx5UGF0Y2ggb25seSB3b3JrcyB3aXRoIGEgc2luZ2xlIGlucHV0LicpO1xuICAgIH1cblxuICAgIHVuaURpZmYgPSB1bmlEaWZmWzBdO1xuICB9XG5cbiAgLy8gQXBwbHkgdGhlIGRpZmYgdG8gdGhlIGlucHV0XG4gIGxldCBsaW5lcyA9IHNvdXJjZS5zcGxpdCgvXFxyXFxufFtcXG5cXHZcXGZcXHJcXHg4NV0vKSxcbiAgICAgIGRlbGltaXRlcnMgPSBzb3VyY2UubWF0Y2goL1xcclxcbnxbXFxuXFx2XFxmXFxyXFx4ODVdL2cpIHx8IFtdLFxuICAgICAgaHVua3MgPSB1bmlEaWZmLmh1bmtzLFxuXG4gICAgICBjb21wYXJlTGluZSA9IG9wdGlvbnMuY29tcGFyZUxpbmUgfHwgKChsaW5lTnVtYmVyLCBsaW5lLCBvcGVyYXRpb24sIHBhdGNoQ29udGVudCkgPT4gbGluZSA9PT0gcGF0Y2hDb250ZW50KSxcbiAgICAgIGVycm9yQ291bnQgPSAwLFxuICAgICAgZnV6ekZhY3RvciA9IG9wdGlvbnMuZnV6ekZhY3RvciB8fCAwLFxuICAgICAgbWluTGluZSA9IDAsXG4gICAgICBvZmZzZXQgPSAwLFxuXG4gICAgICByZW1vdmVFT0ZOTCxcbiAgICAgIGFkZEVPRk5MO1xuXG4gIC8qKlxuICAgKiBDaGVja3MgaWYgdGhlIGh1bmsgZXhhY3RseSBmaXRzIG9uIHRoZSBwcm92aWRlZCBsb2NhdGlvblxuICAgKi9cbiAgZnVuY3Rpb24gaHVua0ZpdHMoaHVuaywgdG9Qb3MpIHtcbiAgICBmb3IgKGxldCBqID0gMDsgaiA8IGh1bmsubGluZXMubGVuZ3RoOyBqKyspIHtcbiAgICAgIGxldCBsaW5lID0gaHVuay5saW5lc1tqXSxcbiAgICAgICAgICBvcGVyYXRpb24gPSAobGluZS5sZW5ndGggPiAwID8gbGluZVswXSA6ICcgJyksXG4gICAgICAgICAgY29udGVudCA9IChsaW5lLmxlbmd0aCA+IDAgPyBsaW5lLnN1YnN0cigxKSA6IGxpbmUpO1xuXG4gICAgICBpZiAob3BlcmF0aW9uID09PSAnICcgfHwgb3BlcmF0aW9uID09PSAnLScpIHtcbiAgICAgICAgLy8gQ29udGV4dCBzYW5pdHkgY2hlY2tcbiAgICAgICAgaWYgKCFjb21wYXJlTGluZSh0b1BvcyArIDEsIGxpbmVzW3RvUG9zXSwgb3BlcmF0aW9uLCBjb250ZW50KSkge1xuICAgICAgICAgIGVycm9yQ291bnQrKztcblxuICAgICAgICAgIGlmIChlcnJvckNvdW50ID4gZnV6ekZhY3Rvcikge1xuICAgICAgICAgICAgcmV0dXJuIGZhbHNlO1xuICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICB0b1BvcysrO1xuICAgICAgfVxuICAgIH1cblxuICAgIHJldHVybiB0cnVlO1xuICB9XG5cbiAgLy8gU2VhcmNoIGJlc3QgZml0IG9mZnNldHMgZm9yIGVhY2ggaHVuayBiYXNlZCBvbiB0aGUgcHJldmlvdXMgb25lc1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGh1bmtzLmxlbmd0aDsgaSsrKSB7XG4gICAgbGV0IGh1bmsgPSBodW5rc1tpXSxcbiAgICAgICAgbWF4TGluZSA9IGxpbmVzLmxlbmd0aCAtIGh1bmsub2xkTGluZXMsXG4gICAgICAgIGxvY2FsT2Zmc2V0ID0gMCxcbiAgICAgICAgdG9Qb3MgPSBvZmZzZXQgKyBodW5rLm9sZFN0YXJ0IC0gMTtcblxuICAgIGxldCBpdGVyYXRvciA9IGRpc3RhbmNlSXRlcmF0b3IodG9Qb3MsIG1pbkxpbmUsIG1heExpbmUpO1xuXG4gICAgZm9yICg7IGxvY2FsT2Zmc2V0ICE9PSB1bmRlZmluZWQ7IGxvY2FsT2Zmc2V0ID0gaXRlcmF0b3IoKSkge1xuICAgICAgaWYgKGh1bmtGaXRzKGh1bmssIHRvUG9zICsgbG9jYWxPZmZzZXQpKSB7XG4gICAgICAgIGh1bmsub2Zmc2V0ID0gb2Zmc2V0ICs9IGxvY2FsT2Zmc2V0O1xuICAgICAgICBicmVhaztcbiAgICAgIH1cbiAgICB9XG5cbiAgICBpZiAobG9jYWxPZmZzZXQgPT09IHVuZGVmaW5lZCkge1xuICAgICAgcmV0dXJuIGZhbHNlO1xuICAgIH1cblxuICAgIC8vIFNldCBsb3dlciB0ZXh0IGxpbWl0IHRvIGVuZCBvZiB0aGUgY3VycmVudCBodW5rLCBzbyBuZXh0IG9uZXMgZG9uJ3QgdHJ5XG4gICAgLy8gdG8gZml0IG92ZXIgYWxyZWFkeSBwYXRjaGVkIHRleHRcbiAgICBtaW5MaW5lID0gaHVuay5vZmZzZXQgKyBodW5rLm9sZFN0YXJ0ICsgaHVuay5vbGRMaW5lcztcbiAgfVxuXG4gIC8vIEFwcGx5IHBhdGNoIGh1bmtzXG4gIGxldCBkaWZmT2Zmc2V0ID0gMDtcbiAgZm9yIChsZXQgaSA9IDA7IGkgPCBodW5rcy5sZW5ndGg7IGkrKykge1xuICAgIGxldCBodW5rID0gaHVua3NbaV0sXG4gICAgICAgIHRvUG9zID0gaHVuay5vbGRTdGFydCArIGh1bmsub2Zmc2V0ICsgZGlmZk9mZnNldCAtIDE7XG4gICAgZGlmZk9mZnNldCArPSBodW5rLm5ld0xpbmVzIC0gaHVuay5vbGRMaW5lcztcblxuICAgIGlmICh0b1BvcyA8IDApIHsgLy8gQ3JlYXRpbmcgYSBuZXcgZmlsZVxuICAgICAgdG9Qb3MgPSAwO1xuICAgIH1cblxuICAgIGZvciAobGV0IGogPSAwOyBqIDwgaHVuay5saW5lcy5sZW5ndGg7IGorKykge1xuICAgICAgbGV0IGxpbmUgPSBodW5rLmxpbmVzW2pdLFxuICAgICAgICAgIG9wZXJhdGlvbiA9IChsaW5lLmxlbmd0aCA+IDAgPyBsaW5lWzBdIDogJyAnKSxcbiAgICAgICAgICBjb250ZW50ID0gKGxpbmUubGVuZ3RoID4gMCA/IGxpbmUuc3Vic3RyKDEpIDogbGluZSksXG4gICAgICAgICAgZGVsaW1pdGVyID0gaHVuay5saW5lZGVsaW1pdGVyc1tqXTtcblxuICAgICAgaWYgKG9wZXJhdGlvbiA9PT0gJyAnKSB7XG4gICAgICAgIHRvUG9zKys7XG4gICAgICB9IGVsc2UgaWYgKG9wZXJhdGlvbiA9PT0gJy0nKSB7XG4gICAgICAgIGxpbmVzLnNwbGljZSh0b1BvcywgMSk7XG4gICAgICAgIGRlbGltaXRlcnMuc3BsaWNlKHRvUG9zLCAxKTtcbiAgICAgIC8qIGlzdGFuYnVsIGlnbm9yZSBlbHNlICovXG4gICAgICB9IGVsc2UgaWYgKG9wZXJhdGlvbiA9PT0gJysnKSB7XG4gICAgICAgIGxpbmVzLnNwbGljZSh0b1BvcywgMCwgY29udGVudCk7XG4gICAgICAgIGRlbGltaXRlcnMuc3BsaWNlKHRvUG9zLCAwLCBkZWxpbWl0ZXIpO1xuICAgICAgICB0b1BvcysrO1xuICAgICAgfSBlbHNlIGlmIChvcGVyYXRpb24gPT09ICdcXFxcJykge1xuICAgICAgICBsZXQgcHJldmlvdXNPcGVyYXRpb24gPSBodW5rLmxpbmVzW2ogLSAxXSA/IGh1bmsubGluZXNbaiAtIDFdWzBdIDogbnVsbDtcbiAgICAgICAgaWYgKHByZXZpb3VzT3BlcmF0aW9uID09PSAnKycpIHtcbiAgICAgICAgICByZW1vdmVFT0ZOTCA9IHRydWU7XG4gICAgICAgIH0gZWxzZSBpZiAocHJldmlvdXNPcGVyYXRpb24gPT09ICctJykge1xuICAgICAgICAgIGFkZEVPRk5MID0gdHJ1ZTtcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gIC8vIEhhbmRsZSBFT0ZOTCBpbnNlcnRpb24vcmVtb3ZhbFxuICBpZiAocmVtb3ZlRU9GTkwpIHtcbiAgICB3aGlsZSAoIWxpbmVzW2xpbmVzLmxlbmd0aCAtIDFdKSB7XG4gICAgICBsaW5lcy5wb3AoKTtcbiAgICAgIGRlbGltaXRlcnMucG9wKCk7XG4gICAgfVxuICB9IGVsc2UgaWYgKGFkZEVPRk5MKSB7XG4gICAgbGluZXMucHVzaCgnJyk7XG4gICAgZGVsaW1pdGVycy5wdXNoKCdcXG4nKTtcbiAgfVxuICBmb3IgKGxldCBfayA9IDA7IF9rIDwgbGluZXMubGVuZ3RoIC0gMTsgX2srKykge1xuICAgIGxpbmVzW19rXSA9IGxpbmVzW19rXSArIGRlbGltaXRlcnNbX2tdO1xuICB9XG4gIHJldHVybiBsaW5lcy5qb2luKCcnKTtcbn1cblxuLy8gV3JhcHBlciB0aGF0IHN1cHBvcnRzIG11bHRpcGxlIGZpbGUgcGF0Y2hlcyB2aWEgY2FsbGJhY2tzLlxuZXhwb3J0IGZ1bmN0aW9uIGFwcGx5UGF0Y2hlcyh1bmlEaWZmLCBvcHRpb25zKSB7XG4gIGlmICh0eXBlb2YgdW5pRGlmZiA9PT0gJ3N0cmluZycpIHtcbiAgICB1bmlEaWZmID0gcGFyc2VQYXRjaCh1bmlEaWZmKTtcbiAgfVxuXG4gIGxldCBjdXJyZW50SW5kZXggPSAwO1xuICBmdW5jdGlvbiBwcm9jZXNzSW5kZXgoKSB7XG4gICAgbGV0IGluZGV4ID0gdW5pRGlmZltjdXJyZW50SW5kZXgrK107XG4gICAgaWYgKCFpbmRleCkge1xuICAgICAgcmV0dXJuIG9wdGlvbnMuY29tcGxldGUoKTtcbiAgICB9XG5cbiAgICBvcHRpb25zLmxvYWRGaWxlKGluZGV4LCBmdW5jdGlvbihlcnIsIGRhdGEpIHtcbiAgICAgIGlmIChlcnIpIHtcbiAgICAgICAgcmV0dXJuIG9wdGlvbnMuY29tcGxldGUoZXJyKTtcbiAgICAgIH1cblxuICAgICAgbGV0IHVwZGF0ZWRDb250ZW50ID0gYXBwbHlQYXRjaChkYXRhLCBpbmRleCwgb3B0aW9ucyk7XG4gICAgICBvcHRpb25zLnBhdGNoZWQoaW5kZXgsIHVwZGF0ZWRDb250ZW50LCBmdW5jdGlvbihlcnIpIHtcbiAgICAgICAgaWYgKGVycikge1xuICAgICAgICAgIHJldHVybiBvcHRpb25zLmNvbXBsZXRlKGVycik7XG4gICAgICAgIH1cblxuICAgICAgICBwcm9jZXNzSW5kZXgoKTtcbiAgICAgIH0pO1xuICAgIH0pO1xuICB9XG4gIHByb2Nlc3NJbmRleCgpO1xufVxuIl19


/***/ }),
/* 11 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/parsePatch = parsePatch;
	function parsePatch(uniDiff) {
	  /*istanbul ignore start*/var /*istanbul ignore end*/options = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

	  var diffstr = uniDiff.split(/\r\n|[\n\v\f\r\x85]/),
	      delimiters = uniDiff.match(/\r\n|[\n\v\f\r\x85]/g) || [],
	      list = [],
	      i = 0;

	  function parseIndex() {
	    var index = {};
	    list.push(index);

	    // Parse diff metadata
	    while (i < diffstr.length) {
	      var line = diffstr[i];

	      // File header found, end parsing diff metadata
	      if (/^(\-\-\-|\+\+\+|@@)\s/.test(line)) {
	        break;
	      }

	      // Diff index
	      var header = /^(?:Index:|diff(?: -r \w+)+)\s+(.+?)\s*$/.exec(line);
	      if (header) {
	        index.index = header[1];
	      }

	      i++;
	    }

	    // Parse file headers if they are defined. Unified diff requires them, but
	    // there's no technical issues to have an isolated hunk without file header
	    parseFileHeader(index);
	    parseFileHeader(index);

	    // Parse hunks
	    index.hunks = [];

	    while (i < diffstr.length) {
	      var _line = diffstr[i];

	      if (/^(Index:|diff|\-\-\-|\+\+\+)\s/.test(_line)) {
	        break;
	      } else if (/^@@/.test(_line)) {
	        index.hunks.push(parseHunk());
	      } else if (_line && options.strict) {
	        // Ignore unexpected content unless in strict mode
	        throw new Error('Unknown line ' + (i + 1) + ' ' + JSON.stringify(_line));
	      } else {
	        i++;
	      }
	    }
	  }

	  // Parses the --- and +++ headers, if none are found, no lines
	  // are consumed.
	  function parseFileHeader(index) {
	    var fileHeader = /^(---|\+\+\+)\s+(.*)$/.exec(diffstr[i]);
	    if (fileHeader) {
	      var keyPrefix = fileHeader[1] === '---' ? 'old' : 'new';
	      var data = fileHeader[2].split('\t', 2);
	      var fileName = data[0].replace(/\\\\/g, '\\');
	      if (/^".*"$/.test(fileName)) {
	        fileName = fileName.substr(1, fileName.length - 2);
	      }
	      index[keyPrefix + 'FileName'] = fileName;
	      index[keyPrefix + 'Header'] = (data[1] || '').trim();

	      i++;
	    }
	  }

	  // Parses a hunk
	  // This assumes that we are at the start of a hunk.
	  function parseHunk() {
	    var chunkHeaderIndex = i,
	        chunkHeaderLine = diffstr[i++],
	        chunkHeader = chunkHeaderLine.split(/@@ -(\d+)(?:,(\d+))? \+(\d+)(?:,(\d+))? @@/);

	    var hunk = {
	      oldStart: +chunkHeader[1],
	      oldLines: +chunkHeader[2] || 1,
	      newStart: +chunkHeader[3],
	      newLines: +chunkHeader[4] || 1,
	      lines: [],
	      linedelimiters: []
	    };

	    var addCount = 0,
	        removeCount = 0;
	    for (; i < diffstr.length; i++) {
	      // Lines starting with '---' could be mistaken for the "remove line" operation
	      // But they could be the header for the next file. Therefore prune such cases out.
	      if (diffstr[i].indexOf('--- ') === 0 && i + 2 < diffstr.length && diffstr[i + 1].indexOf('+++ ') === 0 && diffstr[i + 2].indexOf('@@') === 0) {
	        break;
	      }
	      var operation = diffstr[i].length == 0 && i != diffstr.length - 1 ? ' ' : diffstr[i][0];

	      if (operation === '+' || operation === '-' || operation === ' ' || operation === '\\') {
	        hunk.lines.push(diffstr[i]);
	        hunk.linedelimiters.push(delimiters[i] || '\n');

	        if (operation === '+') {
	          addCount++;
	        } else if (operation === '-') {
	          removeCount++;
	        } else if (operation === ' ') {
	          addCount++;
	          removeCount++;
	        }
	      } else {
	        break;
	      }
	    }

	    // Handle the empty block count case
	    if (!addCount && hunk.newLines === 1) {
	      hunk.newLines = 0;
	    }
	    if (!removeCount && hunk.oldLines === 1) {
	      hunk.oldLines = 0;
	    }

	    // Perform optional sanity checking
	    if (options.strict) {
	      if (addCount !== hunk.newLines) {
	        throw new Error('Added line count did not match for hunk at line ' + (chunkHeaderIndex + 1));
	      }
	      if (removeCount !== hunk.oldLines) {
	        throw new Error('Removed line count did not match for hunk at line ' + (chunkHeaderIndex + 1));
	      }
	    }

	    return hunk;
	  }

	  while (i < diffstr.length) {
	    parseIndex();
	  }

	  return list;
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9wYXRjaC9wYXJzZS5qcyJdLCJuYW1lcyI6WyJwYXJzZVBhdGNoIiwidW5pRGlmZiIsIm9wdGlvbnMiLCJkaWZmc3RyIiwic3BsaXQiLCJkZWxpbWl0ZXJzIiwibWF0Y2giLCJsaXN0IiwiaSIsInBhcnNlSW5kZXgiLCJpbmRleCIsInB1c2giLCJsZW5ndGgiLCJsaW5lIiwidGVzdCIsImhlYWRlciIsImV4ZWMiLCJwYXJzZUZpbGVIZWFkZXIiLCJodW5rcyIsInBhcnNlSHVuayIsInN0cmljdCIsIkVycm9yIiwiSlNPTiIsInN0cmluZ2lmeSIsImZpbGVIZWFkZXIiLCJrZXlQcmVmaXgiLCJkYXRhIiwiZmlsZU5hbWUiLCJyZXBsYWNlIiwic3Vic3RyIiwidHJpbSIsImNodW5rSGVhZGVySW5kZXgiLCJjaHVua0hlYWRlckxpbmUiLCJjaHVua0hlYWRlciIsImh1bmsiLCJvbGRTdGFydCIsIm9sZExpbmVzIiwibmV3U3RhcnQiLCJuZXdMaW5lcyIsImxpbmVzIiwibGluZWRlbGltaXRlcnMiLCJhZGRDb3VudCIsInJlbW92ZUNvdW50IiwiaW5kZXhPZiIsIm9wZXJhdGlvbiJdLCJtYXBwaW5ncyI6Ijs7O2dDQUFnQkEsVSxHQUFBQSxVO0FBQVQsU0FBU0EsVUFBVCxDQUFvQkMsT0FBcEIsRUFBMkM7QUFBQSxzREFBZEMsT0FBYyx1RUFBSixFQUFJOztBQUNoRCxNQUFJQyxVQUFVRixRQUFRRyxLQUFSLENBQWMscUJBQWQsQ0FBZDtBQUFBLE1BQ0lDLGFBQWFKLFFBQVFLLEtBQVIsQ0FBYyxzQkFBZCxLQUF5QyxFQUQxRDtBQUFBLE1BRUlDLE9BQU8sRUFGWDtBQUFBLE1BR0lDLElBQUksQ0FIUjs7QUFLQSxXQUFTQyxVQUFULEdBQXNCO0FBQ3BCLFFBQUlDLFFBQVEsRUFBWjtBQUNBSCxTQUFLSSxJQUFMLENBQVVELEtBQVY7O0FBRUE7QUFDQSxXQUFPRixJQUFJTCxRQUFRUyxNQUFuQixFQUEyQjtBQUN6QixVQUFJQyxPQUFPVixRQUFR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QW9CO0FBQ2xCLFVBQUlxQixhQUFhUCxLQUFLSSxRQUF0QixFQUFnQztBQUM5QixjQUFNLElBQUlqQixLQUFKLENBQVUsc0RBQXNEVSxtQkFBbUIsQ0FBekUsQ0FBVixDQUFOO0FBQ0Q7QUFDRCxVQUFJVyxnQkFBZ0JSLEtBQUtFLFFBQXpCLEVBQW1DO0FBQ2pDLGNBQU0sSUFBSWYsS0FBSixDQUFVLHdEQUF3RFUsbUJBQW1CLENBQTNFLENBQVYsQ0FBTjtBQUNEO0FBQ0Y7O0FBRUQsV0FBT0csSUFBUDtBQUNEOztBQUVELFNBQU8xQixJQUFJTCxRQUFRUyxNQUFuQixFQUEyQjtBQUN6Qkg7QUFDRDs7QUFFRCxTQUFPRixJQUFQO0FBQ0QiLCJmaWxlIjoicGFyc2UuanMiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgZnVuY3Rpb24gcGFyc2VQYXRjaCh1bmlEaWZmLCBvcHRpb25zID0ge30pIHtcbiAgbGV0IGRpZmZzdHIgPSB1bmlEaWZmLnNwbGl0KC9cXHJcXG58W1xcblxcdlxcZlxcclxceDg1XS8pLFxuICAgICAgZGVsaW1pdGVycyA9IHVuaURpZmYubWF0Y2goL1xcclxcbnxbXFxuXFx2XFxmXFxyXFx4ODVdL2cpIHx8IFtdLFxuICAgICAgbGlzdCA9IFtdLFxuICAgICAgaSA9IDA7XG5cbiAgZnVuY3Rpb24gcGFyc2VJbmRleCgpIHtcbiAgICBsZXQgaW5kZXggPSB7fTtcbiAgICBsaXN0LnB1c2goaW5kZXgpO1xuXG4gICAgLy8gUGFyc2UgZGlmZiBtZXRhZGF0YVxuICAgIHdoaWxlIChpIDwgZGlmZnN0ci5sZW5ndGgpIHtcbiAgICAgIGxldCBsaW5lID0gZGlmZnN0cltpXTtcblxuICAgICAgLy8gRmlsZSBoZWFkZXIgZm91bmQsIGVuZCBwYXJzaW5nIGRpZmYgbWV0YWRhdGFcbiAgICAgIGlmICgvXihcXC1cXC1cXC18XFwrXFwrXFwrfEBAKVxccy8udGVzdChsaW5lKSkge1xuICAgICAgICBicmVhaztcbiAgICAgIH1cblxuICAgICAgLy8gRGlmZiBpbmRleFxuICAgICAgbGV0IGhlYWRlciA9ICgvXig/OkluZGV4OnxkaWZmKD86IC1yIFxcdyspKylcXHMrKC4rPylcXHMqJC8pLmV4ZWMobGluZSk7XG4gICAgICBpZiAoaGVhZGVyKSB7XG4gICAgICAgIGluZGV4LmluZGV4ID0gaGVhZGVyWzFdO1xuICAgICAgfVxuXG4gICAgICBpKys7XG4gICAgfVxuXG4gICAgLy8gUGFyc2UgZmlsZSBoZWFkZXJzIGlmIHRoZXkgYXJlIGRlZmluZWQuIFVuaWZpZWQgZGlmZiByZXF1aXJlcyB0aGVtLCBidXRcbiAgICAvLyB0aGVyZSdzIG5vIHRlY2huaWNhbCBpc3N1ZXMgdG8gaGF2ZSBhbiBpc29sYXRlZCBodW5rIHdpdGhvdXQgZmlsZSBoZWFkZXJcbiAgICBwYXJzZUZpbGVIZWFkZXIoaW5kZXgpO1xuICAgIHBhcnNlRmlsZUhlYWRlcihpbmRleCk7XG5cbiAgICAvLyBQYXJzZSBodW5rc1xuICAgIGluZGV4Lmh1bmtzID0gW107XG5cbiAgICB3aGlsZSAoaSA8IGRpZmZzdHIubGVuZ3RoKSB7XG4gICAgICBsZXQgbGluZSA9IGRpZmZzdHJbaV07XG5cbiAgICAgIGlmICgvXihJbmRleDp8ZGlmZnxcXC1cXC1cXC18XFwrXFwrXFwrKVxccy8udGVzdChsaW5lKSkge1xuICAgICAgICBicmVhaztcbiAgICAgIH0gZWxzZSBpZiAoL15AQC8udGVzdChsaW5lKSkge1xuICAgICAgICBpbmRleC5odW5rcy5wdXNoKHBhcnNlSHVuaygpKTtcbiAgICAgIH0gZWxzZSBpZiAobGluZSAmJiBvcHRpb25zLnN0cmljdCkge1xuICAgICAgICAvLyBJZ25vcmUgdW5leHBlY3RlZCBjb250ZW50IHVubGVzcyBpbiBzdHJpY3QgbW9kZVxuICAgICAgICB0aHJvdyBuZXcgRXJyb3IoJ1Vua25vd24gbGluZSAnICsgKGkgKyAxKSArICcgJyArIEpTT04uc3RyaW5naWZ5KGxpbmUpKTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIGkrKztcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAvLyBQYXJzZXMgdGhlIC0tLSBhbmQgKysrIGhlYWRlcnMsIGlmIG5vbmUgYXJlIGZvdW5kLCBubyBsaW5lc1xuICAvLyBhcmUgY29uc3VtZWQuXG4gIGZ1bmN0aW9uIHBhcnNlRmlsZUhlYWRlcihpbmRleCkge1xuICAgIGNvbnN0IGZpbGVIZWFkZXIgPSAoL14oLS0tfFxcK1xcK1xcKylcXHMrKC4qKSQvKS5leGVjKGRpZmZzdHJbaV0pO1xuICAgIGlmIChmaWxlSGVhZGVyKSB7XG4gICAgICBsZXQga2V5UHJlZml4ID0gZmlsZUhlYWRlclsxXSA9PT0gJy0tLScgPyAnb2xkJyA6ICduZXcnO1xuICAgICAgY29uc3QgZGF0YSA9IGZpbGVIZWFkZXJbMl0uc3BsaXQoJ1xcdCcsIDIpO1xuICAgICAgbGV0IGZpbGVOYW1lID0gZGF0YVswXS5yZXBsYWNlKC9cXFxcXFxcXC9nLCAnXFxcXCcpO1xuICAgICAgaWYgKC9eXCIuKlwiJC8udGVzdChmaWxlTmFtZSkpIHtcbiAgICAgICAgZmlsZU5hbWUgPSBmaWxlTmFtZS5zdWJzdHIoMSwgZmlsZU5hbWUubGVuZ3RoIC0gMik7XG4gICAgICB9XG4gICAgICBpbmRleFtrZXlQcmVmaXggKyAnRmlsZU5hbWUnXSA9IGZpbGVOYW1lO1xuICAgICAgaW5kZXhba2V5UHJlZml4ICsgJ0hlYWRlciddID0gKGRhdGFbMV0gfHwgJycpLnRyaW0oKTtcblxuICAgICAgaSsrO1xuICAgIH1cbiAgfVxuXG4gIC8vIFBhcnNlcyBhIGh1bmtcbiAgLy8gVGhpcyBhc3N1bWVzIHRoYXQgd2UgYXJlIGF0IHRoZSBzdGFydCBvZiBhIGh1bmsuXG4gIGZ1bmN0aW9uIHBhcnNlSHVuaygpIHtcbiAgICBsZXQgY2h1bmtIZWFkZXJJbmRleCA9IGksXG4gICAgICAgIGNodW5rSGVhZGVyTGluZSA9IGRpZmZzdHJbaSsrXSxcbiAgICAgICAgY2h1bmtIZWFkZXIgPSBjaHVua0hlYWRlckxpbmUuc3BsaXQoL0BAIC0oXFxkKykoPzosKFxcZCspKT8gXFwrKFxcZCspKD86LChcXGQrKSk/IEBALyk7XG5cbiAgICBsZXQgaHVuayA9IHtcbiAgICAgIG9sZFN0YXJ0OiArY2h1bmtIZWFkZXJbMV0sXG4gICAgICBvbGRMaW5lczogK2NodW5rSGVhZGVyWzJdIHx8IDEsXG4gICAgICBuZXdTdGFydDogK2NodW5rSGVhZGVyWzNdLFxuICAgICAgbmV3TGluZXM6ICtjaHVua0hlYWRlcls0XSB8fCAxLFxuICAgICAgbGluZXM6IFtdLFxuICAgICAgbGluZWRlbGltaXRlcnM6IFtdXG4gICAgfTtcblxuICAgIGxldCBhZGRDb3VudCA9IDAsXG4gICAgICAgIHJlbW92ZUNvdW50ID0gMDtcbiAgICBmb3IgKDsgaSA8IGRpZmZzdHIubGVuZ3RoOyBpKyspIHtcbiAgICAgIC8vIExpbmVzIHN0YXJ0aW5nIHdpdGggJy0tLScgY291bGQgYmUgbWlzdGFrZW4gZm9yIHRoZSBcInJlbW92ZSBsaW5lXCIgb3BlcmF0aW9uXG4gICAgICAvLyBCdXQgdGhleSBjb3VsZCBiZSB0aGUgaGVhZGVyIGZvciB0aGUgbmV4dCBmaWxlLiBUaGVyZWZvcmUgcHJ1bmUgc3VjaCBjYXNlcyBvdXQuXG4gICAgICBpZiAoZGlmZnN0cltpXS5pbmRleE9mKCctLS0gJykgPT09IDBcbiAgICAgICAgICAgICYmIChpICsgMiA8IGRpZmZzdHIubGVuZ3RoKVxuICAgICAgICAgICAgJiYgZGlmZnN0cltpICsgMV0uaW5kZXhPZignKysrICcpID09PSAwXG4gICAgICAgICAgICAmJiBkaWZmc3RyW2kgKyAyXS5pbmRleE9mKCdAQCcpID09PSAwKSB7XG4gICAgICAgICAgYnJlYWs7XG4gICAgICB9XG4gICAgICBsZXQgb3BlcmF0aW9uID0gKGRpZmZzdHJbaV0ubGVuZ3RoID09IDAgJiYgaSAhPSAoZGlmZnN0ci5sZW5ndGggLSAxKSkgPyAnICcgOiBkaWZmc3RyW2ldWzBdO1xuXG4gICAgICBpZiAob3BlcmF0aW9uID09PSAnKycgfHwgb3BlcmF0aW9uID09PSAnLScgfHwgb3BlcmF0aW9uID09PSAnICcgfHwgb3BlcmF0aW9uID09PSAnXFxcXCcpIHtcbiAgICAgICAgaHVuay5saW5lcy5wdXNoKGRpZmZzdHJbaV0pO1xuICAgICAgICBodW5rLmxpbmVkZWxpbWl0ZXJzLnB1c2goZGVsaW1pdGVyc1tpXSB8fCAnXFxuJyk7XG5cbiAgICAgICAgaWYgKG9wZXJhdGlvbiA9PT0gJysnKSB7XG4gICAgICAgICAgYWRkQ291bnQrKztcbiAgICAgICAgfSBlbHNlIGlmIChvcGVyYXRpb24gPT09ICctJykge1xuICAgICAgICAgIHJlbW92ZUNvdW50Kys7XG4gICAgICAgIH0gZWxzZSBpZiAob3BlcmF0aW9uID09PSAnICcpIHtcbiAgICAgICAgICBhZGRDb3VudCsrO1xuICAgICAgICAgIHJlbW92ZUNvdW50Kys7XG4gICAgICAgIH1cbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIGJyZWFrO1xuICAgICAgfVxuICAgIH1cblxuICAgIC8vIEhhbmRsZSB0aGUgZW1wdHkgYmxvY2sgY291bnQgY2FzZVxuICAgIGlmICghYWRkQ291bnQgJiYgaHVuay5uZXdMaW5lcyA9PT0gMSkge1xuICAgICAgaHVuay5uZXdMaW5lcyA9IDA7XG4gICAgfVxuICAgIGlmICghcmVtb3ZlQ291bnQgJiYgaHVuay5vbGRMaW5lcyA9PT0gMSkge1xuICAgICAgaHVuay5vbGRMaW5lcyA9IDA7XG4gICAgfVxuXG4gICAgLy8gUGVyZm9ybSBvcHRpb25hbCBzYW5pdHkgY2hlY2tpbmdcbiAgICBpZiAob3B0aW9ucy5zdHJpY3QpIHtcbiAgICAgIGlmIChhZGRDb3VudCAhPT0gaHVuay5uZXdMaW5lcykge1xuICAgICAgICB0aHJvdyBuZXcgRXJyb3IoJ0FkZGVkIGxpbmUgY291bnQgZGlkIG5vdCBtYXRjaCBmb3IgaHVuayBhdCBsaW5lICcgKyAoY2h1bmtIZWFkZXJJbmRleCArIDEpKTtcbiAgICAgIH1cbiAgICAgIGlmIChyZW1vdmVDb3VudCAhPT0gaHVuay5vbGRMaW5lcykge1xuICAgICAgICB0aHJvdyBuZXcgRXJyb3IoJ1JlbW92ZWQgbGluZSBjb3VudCBkaWQgbm90IG1hdGNoIGZvciBodW5rIGF0IGxpbmUgJyArIChjaHVua0hlYWRlckluZGV4ICsgMSkpO1xuICAgICAgfVxuICAgIH1cblxuICAgIHJldHVybiBodW5rO1xuICB9XG5cbiAgd2hpbGUgKGkgPCBkaWZmc3RyLmxlbmd0aCkge1xuICAgIHBhcnNlSW5kZXgoKTtcbiAgfVxuXG4gIHJldHVybiBsaXN0O1xufVxuIl19


/***/ }),
/* 12 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/"use strict";

	exports.__esModule = true;

	exports["default"] = /*istanbul ignore end*/function (start, minLine, maxLine) {
	  var wantForward = true,
	      backwardExhausted = false,
	      forwardExhausted = false,
	      localOffset = 1;

	  return function iterator() {
	    if (wantForward && !forwardExhausted) {
	      if (backwardExhausted) {
	        localOffset++;
	      } else {
	        wantForward = false;
	      }

	      // Check if trying to fit beyond text length, and if not, check it fits
	      // after offset location (or desired location on first iteration)
	      if (start + localOffset <= maxLine) {
	        return localOffset;
	      }

	      forwardExhausted = true;
	    }

	    if (!backwardExhausted) {
	      if (!forwardExhausted) {
	        wantForward = true;
	      }

	      // Check if trying to fit before text beginning, and if not, check it fits
	      // before offset location
	      if (minLine <= start - localOffset) {
	        return -localOffset++;
	      }

	      backwardExhausted = true;
	      return iterator();
	    }

	    // We tried to fit hunk before text beginning and beyond text length, then
	    // hunk can't fit on the text. Return undefined
	  };
	};
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy91dGlsL2Rpc3RhbmNlLWl0ZXJhdG9yLmpzIl0sIm5hbWVzIjpbInN0YXJ0IiwibWluTGluZSIsIm1heExpbmUiLCJ3YW50Rm9yd2FyZCIsImJhY2t3YXJkRXhoYXVzdGVkIiwiZm9yd2FyZEV4aGF1c3RlZCIsImxvY2FsT2Zmc2V0IiwiaXRlcmF0b3IiXSwibWFwcGluZ3MiOiI7Ozs7NENBR2UsVUFBU0EsS0FBVCxFQUFnQkMsT0FBaEIsRUFBeUJDLE9BQXpCLEVBQWtDO0FBQy9DLE1BQUlDLGNBQWMsSUFBbEI7QUFBQSxNQUNJQyxvQkFBb0IsS0FEeEI7QUFBQSxNQUVJQyxtQkFBbUIsS0FGdkI7QUFBQSxNQUdJQyxjQUFjLENBSGxCOztBQUtBLFNBQU8sU0FBU0MsUUFBVCxHQUFvQjtBQUN6QixRQUFJSixlQUFlLENBQUNFLGdCQUFwQixFQUFzQztBQUNwQyxVQUFJRCxpQkFBSixFQUF1QjtBQUNyQkU7QUFDRCxPQUZELE1BRU87QUFDTEgsc0JBQWMsS0FBZDtBQUNEOztBQUVEO0FBQ0E7QUFDQSxVQUFJSCxRQUFRTSxXQUFSLElBQXVCSixPQUEzQixFQUFvQztBQUNsQyxlQUFPSSxXQUFQO0FBQ0Q7O0FBRURELHlCQUFtQixJQUFuQjtBQUNEOztBQUVELFFBQUksQ0FBQ0QsaUJBQUwsRUFBd0I7QUFDdEIsVUFBSSxDQUFDQyxnQkFBTCxFQUF1QjtBQUNyQkYsc0JBQWMsSUFBZDtBQUNEOztBQUVEO0FBQ0E7QUFDQSxVQUFJRixXQUFXRCxRQUFRTSxXQUF2QixFQUFvQztBQUNsQyxlQUFPLENBQUNBLGFBQVI7QUFDRDs7QUFFREYsMEJBQW9CLElBQXBCO0FBQ0EsYUFBT0csVUFBUDtBQUNEOztBQUVEO0FBQ0E7QUFDRCxHQWxDRDtBQW1DRCxDIiwiZmlsZSI6ImRpc3RhbmNlLWl0ZXJhdG9yLmpzIiwic291cmNlc0NvbnRlbnQiOlsiLy8gSXRlcmF0b3IgdGhhdCB0cmF2ZXJzZXMgaW4gdGhlIHJhbmdlIG9mIFttaW4sIG1heF0sIHN0ZXBwaW5nXG4vLyBieSBkaXN0YW5jZSBmcm9tIGEgZ2l2ZW4gc3RhcnQgcG9zaXRpb24uIEkuZS4gZm9yIFswLCA0XSwgd2l0aFxuLy8gc3RhcnQgb2YgMiwgdGhpcyB3aWxsIGl0ZXJhdGUgMiwgMywgMSwgNCwgMC5cbmV4cG9ydCBkZWZhdWx0IGZ1bmN0aW9uKHN0YXJ0LCBtaW5MaW5lLCBtYXhMaW5lKSB7XG4gIGxldCB3YW50Rm9yd2FyZCA9IHRydWUsXG4gICAgICBiYWNrd2FyZEV4aGF1c3RlZCA9IGZhbHNlLFxuICAgICAgZm9yd2FyZEV4aGF1c3RlZCA9IGZhbHNlLFxuICAgICAgbG9jYWxPZmZzZXQgPSAxO1xuXG4gIHJldHVybiBmdW5jdGlvbiBpdGVyYXRvcigpIHtcbiAgICBpZiAod2FudEZvcndhcmQgJiYgIWZvcndhcmRFeGhhdXN0ZWQpIHtcbiAgICAgIGlmIChiYWNrd2FyZEV4aGF1c3RlZCkge1xuICAgICAgICBsb2NhbE9mZnNldCsrO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgd2FudEZvcndhcmQgPSBmYWxzZTtcbiAgICAgIH1cblxuICAgICAgLy8gQ2hlY2sgaWYgdHJ5aW5nIHRvIGZpdCBiZXlvbmQgdGV4dCBsZW5ndGgsIGFuZCBpZiBub3QsIGNoZWNrIGl0IGZpdHNcbiAgICAgIC8vIGFmdGVyIG9mZnNldCBsb2NhdGlvbiAob3IgZGVzaXJlZCBsb2NhdGlvbiBvbiBmaXJzdCBpdGVyYXRpb24pXG4gICAgICBpZiAoc3RhcnQgKyBsb2NhbE9mZnNldCA8PSBtYXhMaW5lKSB7XG4gICAgICAgIHJldHVybiBsb2NhbE9mZnNldDtcbiAgICAgIH1cblxuICAgICAgZm9yd2FyZEV4aGF1c3RlZCA9IHRydWU7XG4gICAgfVxuXG4gICAgaWYgKCFiYWNrd2FyZEV4aGF1c3RlZCkge1xuICAgICAgaWYgKCFmb3J3YXJkRXhoYXVzdGVkKSB7XG4gICAgICAgIHdhbnRGb3J3YXJkID0gdHJ1ZTtcbiAgICAgIH1cblxuICAgICAgLy8gQ2hlY2sgaWYgdHJ5aW5nIHRvIGZpdCBiZWZvcmUgdGV4dCBiZWdpbm5pbmcsIGFuZCBpZiBub3QsIGNoZWNrIGl0IGZpdHNcbiAgICAgIC8vIGJlZm9yZSBvZmZzZXQgbG9jYXRpb25cbiAgICAgIGlmIChtaW5MaW5lIDw9IHN0YXJ0IC0gbG9jYWxPZmZzZXQpIHtcbiAgICAgICAgcmV0dXJuIC1sb2NhbE9mZnNldCsrO1xuICAgICAgfVxuXG4gICAgICBiYWNrd2FyZEV4aGF1c3RlZCA9IHRydWU7XG4gICAgICByZXR1cm4gaXRlcmF0b3IoKTtcbiAgICB9XG5cbiAgICAvLyBXZSB0cmllZCB0byBmaXQgaHVuayBiZWZvcmUgdGV4dCBiZWdpbm5pbmcgYW5kIGJleW9uZCB0ZXh0IGxlbmd0aCwgdGhlblxuICAgIC8vIGh1bmsgY2FuJ3QgZml0IG9uIHRoZSB0ZXh0LiBSZXR1cm4gdW5kZWZpbmVkXG4gIH07XG59XG4iXX0=


/***/ }),
/* 13 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/calcLineCount = calcLineCount;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/merge = merge;

	var /*istanbul ignore start*/_create = __webpack_require__(14) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_parse = __webpack_require__(11) /*istanbul ignore end*/;

	var /*istanbul ignore start*/_array = __webpack_require__(15) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

	/*istanbul ignore end*/function calcLineCount(hunk) {
	  /*istanbul ignore start*/var _calcOldNewLineCount = /*istanbul ignore end*/calcOldNewLineCount(hunk.lines),
	      oldLines = _calcOldNewLineCount.oldLines,
	      newLines = _calcOldNewLineCount.newLines;

	  if (oldLines !== undefined) {
	    hunk.oldLines = oldLines;
	  } else {
	    delete hunk.oldLines;
	  }

	  if (newLines !== undefined) {
	    hunk.newLines = newLines;
	  } else {
	    delete hunk.newLines;
	  }
	}

	function merge(mine, theirs, base) {
	  mine = loadPatch(mine, base);
	  theirs = loadPatch(theirs, base);

	  var ret = {};

	  // For index we just let it pass through as it doesn't have any necessary meaning.
	  // Leaving sanity checks on this to the API consumer that may know more about the
	  // meaning in their own context.
	  if (mine.index || theirs.index) {
	    ret.index = mine.index || theirs.index;
	  }

	  if (mine.newFileName || theirs.newFileName) {
	    if (!fileNameChanged(mine)) {
	      // No header or no change in ours, use theirs (and ours if theirs does not exist)
	      ret.oldFileName = theirs.oldFileName || mine.oldFileName;
	      ret.newFileName = theirs.newFileName || mine.newFileName;
	      ret.oldHeader = theirs.oldHeader || mine.oldHeader;
	      ret.newHeader = theirs.newHeader || mine.newHeader;
	    } else if (!fileNameChanged(theirs)) {
	      // No header or no change in theirs, use ours
	      ret.oldFileName = mine.oldFileName;
	      ret.newFileName = mine.newFileName;
	      ret.oldHeader = mine.oldHeader;
	      ret.newHeader = mine.newHeader;
	    } else {
	      // Both changed... figure it out
	      ret.oldFileName = selectField(ret, mine.oldFileName, theirs.oldFileName);
	      ret.newFileName = selectField(ret, mine.newFileName, theirs.newFileName);
	      ret.oldHeader = selectField(ret, mine.oldHeader, theirs.oldHeader);
	      ret.newHeader = selectField(ret, mine.newHeader, theirs.newHeader);
	    }
	  }

	  ret.hunks = [];

	  var mineIndex = 0,
	      theirsIndex = 0,
	      mineOffset = 0,
	      theirsOffset = 0;

	  while (mineIndex < mine.hunks.length || theirsIndex < theirs.hunks.length) {
	    var mineCurrent = mine.hunks[mineIndex] || { oldStart: Infinity },
	        theirsCurrent = theirs.hunks[theirsIndex] || { oldStart: Infinity };

	    if (hunkBefore(mineCurrent, theirsCurrent)) {
	      // This patch does not overlap with any of the others, yay.
	      ret.hunks.push(cloneHunk(mineCurrent, mineOffset));
	      mineIndex++;
	      theirsOffset += mineCurrent.newLines - mineCurrent.oldLines;
	    } else if (hunkBefore(theirsCurrent, mineCurrent)) {
	      // This patch does not overlap with any of the others, yay.
	      ret.hunks.push(cloneHunk(theirsCurrent, theirsOffset));
	      theirsIndex++;
	      mineOffset += theirsCurrent.newLines - theirsCurrent.oldLines;
	    } else {
	      // Overlap, merge as best we can
	      var mergedHunk = {
	        oldStart: Math.min(mineCurrent.oldStart, theirsCurrent.oldStart),
	        oldLines: 0,
	        newStart: Math.min(mineCurrent.newStart + mineOffset, theirsCurrent.oldStart + theirsOffset),
	        newLines: 0,
	        lines: []
	      };
	      mergeLines(mergedHunk, mineCurrent.oldStart, mineCurrent.lines, theirsCurrent.oldStart, theirsCurrent.lines);
	      theirsIndex++;
	      mineIndex++;

	      ret.hunks.push(mergedHunk);
	    }
	  }

	  return ret;
	}

	function loadPatch(param, base) {
	  if (typeof param === 'string') {
	    if (/^@@/m.test(param) || /^Index:/m.test(param)) {
	      return (/*istanbul ignore start*/(0, _parse.parsePatch) /*istanbul ignore end*/(param)[0]
	      );
	    }

	    if (!base) {
	      throw new Error('Must provide a base reference or pass in a patch');
	    }
	    return (/*istanbul ignore start*/(0, _create.structuredPatch) /*istanbul ignore end*/(undefined, undefined, base, param)
	    );
	  }

	  return param;
	}

	function fileNameChanged(patch) {
	  return patch.newFileName && patch.newFileName !== patch.oldFileName;
	}

	function selectField(index, mine, theirs) {
	  if (mine === theirs) {
	    return mine;
	  } else {
	    index.conflict = true;
	    return { mine: mine, theirs: theirs };
	  }
	}

	function hunkBefore(test, check) {
	  return test.oldStart < check.oldStart && test.oldStart + test.oldLines < check.oldStart;
	}

	function cloneHunk(hunk, offset) {
	  return {
	    oldStart: hunk.oldStart, oldLines: hunk.oldLines,
	    newStart: hunk.newStart + offset, newLines: hunk.newLines,
	    lines: hunk.lines
	  };
	}

	function mergeLines(hunk, mineOffset, mineLines, theirOffset, theirLines) {
	  // This will generally result in a conflicted hunk, but there are cases where the context
	  // is the only overlap where we can successfully merge the content here.
	  var mine = { offset: mineOffset, lines: mineLines, index: 0 },
	      their = { offset: theirOffset, lines: theirLines, index: 0 };

	  // Handle any leading content
	  insertLeading(hunk, mine, their);
	  insertLeading(hunk, their, mine);

	  // Now in the overlap content. Scan through and select the best changes from each.
	  while (mine.index < mine.lines.length && their.index < their.lines.length) {
	    var mineCurrent = mine.lines[mine.index],
	        theirCurrent = their.lines[their.index];

	    if ((mineCurrent[0] === '-' || mineCurrent[0] === '+') && (theirCurrent[0] === '-' || theirCurrent[0] === '+')) {
	      // Both modified ...
	      mutualChange(hunk, mine, their);
	    } else if (mineCurrent[0] === '+' && theirCurrent[0] === ' ') {
	      /*istanbul ignore start*/var _hunk$lines;

	      /*istanbul ignore end*/ // Mine inserted
	      /*istanbul ignore start*/(_hunk$lines = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/collectChange(mine)));
	    } else if (theirCurrent[0] === '+' && mineCurrent[0] === ' ') {
	      /*istanbul ignore start*/var _hunk$lines2;

	      /*istanbul ignore end*/ // Theirs inserted
	      /*istanbul ignore start*/(_hunk$lines2 = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines2 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/collectChange(their)));
	    } else if (mineCurrent[0] === '-' && theirCurrent[0] === ' ') {
	      // Mine removed or edited
	      removal(hunk, mine, their);
	    } else if (theirCurrent[0] === '-' && mineCurrent[0] === ' ') {
	      // Their removed or edited
	      removal(hunk, their, mine, true);
	    } else if (mineCurrent === theirCurrent) {
	      // Context identity
	      hunk.lines.push(mineCurrent);
	      mine.index++;
	      their.index++;
	    } else {
	      // Context mismatch
	      conflict(hunk, collectChange(mine), collectChange(their));
	    }
	  }

	  // Now push anything that may be remaining
	  insertTrailing(hunk, mine);
	  insertTrailing(hunk, their);

	  calcLineCount(hunk);
	}

	function mutualChange(hunk, mine, their) {
	  var myChanges = collectChange(mine),
	      theirChanges = collectChange(their);

	  if (allRemoves(myChanges) && allRemoves(theirChanges)) {
	    // Special case for remove changes that are supersets of one another
	    if ( /*istanbul ignore start*/(0, _array.arrayStartsWith) /*istanbul ignore end*/(myChanges, theirChanges) && skipRemoveSuperset(their, myChanges, myChanges.length - theirChanges.length)) {
	      /*istanbul ignore start*/var _hunk$lines3;

	      /*istanbul ignore end*/ /*istanbul ignore start*/(_hunk$lines3 = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines3 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/myChanges));
	      return;
	    } else if ( /*istanbul ignore start*/(0, _array.arrayStartsWith) /*istanbul ignore end*/(theirChanges, myChanges) && skipRemoveSuperset(mine, theirChanges, theirChanges.length - myChanges.length)) {
	      /*istanbul ignore start*/var _hunk$lines4;

	      /*istanbul ignore end*/ /*istanbul ignore start*/(_hunk$lines4 = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines4 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/theirChanges));
	      return;
	    }
	  } else if ( /*istanbul ignore start*/(0, _array.arrayEqual) /*istanbul ignore end*/(myChanges, theirChanges)) {
	    /*istanbul ignore start*/var _hunk$lines5;

	    /*istanbul ignore end*/ /*istanbul ignore start*/(_hunk$lines5 = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines5 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/myChanges));
	    return;
	  }

	  conflict(hunk, myChanges, theirChanges);
	}

	function removal(hunk, mine, their, swap) {
	  var myChanges = collectChange(mine),
	      theirChanges = collectContext(their, myChanges);
	  if (theirChanges.merged) {
	    /*istanbul ignore start*/var _hunk$lines6;

	    /*istanbul ignore end*/ /*istanbul ignore start*/(_hunk$lines6 = /*istanbul ignore end*/hunk.lines).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_hunk$lines6 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/theirChanges.merged));
	  } else {
	    conflict(hunk, swap ? theirChanges : myChanges, swap ? myChanges : theirChanges);
	  }
	}

	function conflict(hunk, mine, their) {
	  hunk.conflict = true;
	  hunk.lines.push({
	    conflict: true,
	    mine: mine,
	    theirs: their
	  });
	}

	function insertLeading(hunk, insert, their) {
	  while (insert.offset < their.offset && insert.index < insert.lines.length) {
	    var line = insert.lines[insert.index++];
	    hunk.lines.push(line);
	    insert.offset++;
	  }
	}
	function insertTrailing(hunk, insert) {
	  while (insert.index < insert.lines.length) {
	    var line = insert.lines[insert.index++];
	    hunk.lines.push(line);
	  }
	}

	function collectChange(state) {
	  var ret = [],
	      operation = state.lines[state.index][0];
	  while (state.index < state.lines.length) {
	    var line = state.lines[state.index];

	    // Group additions that are immediately after subtractions and treat them as one "atomic" modify change.
	    if (operation === '-' && line[0] === '+') {
	      operation = '+';
	    }

	    if (operation === line[0]) {
	      ret.push(line);
	      state.index++;
	    } else {
	      break;
	    }
	  }

	  return ret;
	}
	function collectContext(state, matchChanges) {
	  var changes = [],
	      merged = [],
	      matchIndex = 0,
	      contextChanges = false,
	      conflicted = false;
	  while (matchIndex < matchChanges.length && state.index < state.lines.length) {
	    var change = state.lines[state.index],
	        match = matchChanges[matchIndex];

	    // Once we've hit our add, then we are done
	    if (match[0] === '+') {
	      break;
	    }

	    contextChanges = contextChanges || change[0] !== ' ';

	    merged.push(match);
	    matchIndex++;

	    // Consume any additions in the other block as a conflict to attempt
	    // to pull in the remaining context after this
	    if (change[0] === '+') {
	      conflicted = true;

	      while (change[0] === '+') {
	        changes.push(change);
	        change = state.lines[++state.index];
	      }
	    }

	    if (match.substr(1) === change.substr(1)) {
	      changes.push(change);
	      state.index++;
	    } else {
	      conflicted = true;
	    }
	  }

	  if ((matchChanges[matchIndex] || '')[0] === '+' && contextChanges) {
	    conflicted = true;
	  }

	  if (conflicted) {
	    return changes;
	  }

	  while (matchIndex < matchChanges.length) {
	    merged.push(matchChanges[matchIndex++]);
	  }

	  return {
	    merged: merged,
	    changes: changes
	  };
	}

	function allRemoves(changes) {
	  return changes.reduce(function (prev, change) {
	    return prev && change[0] === '-';
	  }, true);
	}
	function skipRemoveSuperset(state, removeChanges, delta) {
	  for (var i = 0; i < delta; i++) {
	    var changeContent = removeChanges[removeChanges.length - delta + i].substr(1);
	    if (state.lines[state.index + i] !== ' ' + changeContent) {
	      return false;
	    }
	  }

	  state.index += delta;
	  return true;
	}

	function calcOldNewLineCount(lines) {
	  var oldLines = 0;
	  var newLines = 0;

	  lines.forEach(function (line) {
	    if (typeof line !== 'string') {
	      var myCount = calcOldNewLineCount(line.mine);
	      var theirCount = calcOldNewLineCount(line.theirs);

	      if (oldLines !== undefined) {
	        if (myCount.oldLines === theirCount.oldLines) {
	          oldLines += myCount.oldLines;
	        } else {
	          oldLines = undefined;
	        }
	      }

	      if (newLines !== undefined) {
	        if (myCount.newLines === theirCount.newLines) {
	          newLines += myCount.newLines;
	        } else {
	          newLines = undefined;
	        }
	      }
	    } else {
	      if (newLines !== undefined && (line[0] === '+' || line[0] === ' ')) {
	        newLines++;
	      }
	      if (oldLines !== undefined && (line[0] === '-' || line[0] === ' ')) {
	        oldLines++;
	      }
	    }
	  });

	  return { oldLines: oldLines, newLines: newLines };
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9wYXRjaC9tZXJnZS5qcyJdLCJuYW1lcyI6WyJjYWxjTGluZUNvdW50IiwibWVyZ2UiLCJodW5rIiwiY2FsY09sZE5ld0xpbmVDb3VudCIsImxpbmVzIiwib2xkTGluZXMiLCJuZXdMaW5lcyIsInVuZGVmaW5lZCIsIm1pbmUiLCJ0aGVpcnMiLCJiYXNlIiwibG9hZFBhdGNoIiwicmV0IiwiaW5kZXgiLCJuZXdGaWxlTmFtZSIsImZpbGVOYW1lQ2hhbmdlZCIsIm9sZEZpbGVOYW1lIiwib2xkSGVhZGVyIiwibmV3SGVhZGVyIiwic2VsZWN0RmllbGQiLCJodW5rcyIsIm1pbmVJbmRleCIsInRoZWlyc0luZGV4IiwibWluZU9mZnNldCIsInRoZWlyc09mZnNldCIsImxlbmd0aCIsIm1pbmVDdXJyZW50Iiwib2xkU3RhcnQiLCJJbmZpbml0eSIsInRoZWlyc0N1cnJlbnQiLCJodW5rQmVmb3JlIiwicHVzaCIsImNsb25lSHVuayIsIm1lcmdlZEh1bmsiLCJNYXRoIiwibWluIiwibmV3U3RhcnQiLCJtZXJnZUxpbmVzIiwicGFyYW0iLCJ0ZXN0IiwiRXJyb3IiLCJwYXRjaCIsImNvbmZsaWN0IiwiY2hlY2siLCJvZmZzZXQiLCJtaW5lTGluZXMiLCJ0aGVpck9mZnNldCIsInRoZWlyTGluZXMiLCJ0aGVpciIsImluc2VydExlYWRpbmciLCJ0aGVpckN1cnJlbnQiLCJtdXR1YWxDaGFuZ2UiLCJjb2xsZWN0Q2hhbmdlIiwicmVtb3ZhbCIsImluc2VydFRyYWlsaW5nIiwibXlDaGFuZ2VzIiwidGhlaXJDaGFuZ2VzIiwiYWxsUmVtb3ZlcyIsInNraXBSZW1vdmVTdXBlcnNldCIsInN3YXAiLCJjb2xsZWN0Q29udGV4dCIsIm1lcmdlZCIsImluc2VydCIsImxpbmUiLCJzdGF0ZSIsIm9wZXJhdGlvbiIsIm1hdGNoQ2hhbmdlcyIsImNoYW5nZXMiLCJtYXRjaEluZGV4IiwiY29udGV4dENoYW5nZXMiLCJjb25mbGljdGVkIiwiY2hhbmdlIiwibWF0Y2giLCJzdWJzdHIiLCJyZWR1Y2UiLCJwcmV2IiwicmVtb3ZlQ2hhbmdlcyIsImRlbHRhIiwiaSIsImNoYW5nZUNvbnRlbnQiLCJmb3JFYWNoIiwibXlDb3VudCIsInRoZWlyQ291bnQiXSwibWFwcGluZ3MiOiI7OztnQ0FLZ0JBLGEsR0FBQUEsYTt5REFnQkFDLEssR0FBQUEsSzs7QUFyQmhCOztBQUNBOztBQUVBOzs7O3VCQUVPLFNBQVNELGFBQVQsQ0FBdUJFLElBQXZCLEVBQTZCO0FBQUEsNkVBQ0xDLG9CQUFvQkQsS0FBS0UsS0FBekIsQ0FESztBQUFBLE1BQzNCQyxRQUQyQix3QkFDM0JBLFFBRDJCO0FBQUEsTUFDakJDLFFBRGlCLHdCQUNqQkEsUUFEaUI7O0FBR2xDLE1BQUlELGFBQWFFLFNBQWpCLEVBQTRCO0FBQzFCTCxTQUFLRyxRQUFMLEdBQWdCQSxRQUFoQjtBQUNELEdBRkQsTUFFTztBQUNMLFdBQU9ILEtBQUtHLFFBQVo7QUFDRDs7QUFFRCxNQUFJQyxhQUFhQyxTQUFqQixFQUE0QjtBQUMxQkwsU0FBS0ksUUFBTCxHQUFnQkEsUUFBaEI7QUFDRCxHQUZELE1BRU87QUFDTCxXQUFPSixLQUFLSSxRQUFaO0FBQ0Q7QUFDRjs7QUFFTSxTQUFTTCxLQUFULENBQWVPLElBQWYsRUFBcUJDLE1BQXJCLEVBQTZCQyxJQUE3QixFQUFtQztBQUN4Q0YsU0FBT0csVUFBVUgsSUFBVixFQUFnQkUsSUFBaEIsQ0FBUDtBQUNBRCxXQUFTRSxVQUFVRixNQUFWLEVBQWtCQyxJQUFsQixDQUFUOztBQUVBLE1BQUlFLE1BQU0sRUFBVjs7QUFFQTtBQUNBO0FBQ0E7QUFDQSxNQUFJSixLQUFLSyxLQUFMLElBQWNKLE9BQU9JLEtBQXpCLEVBQWdDO0FBQzlCRCxRQUFJQyxLQUFKLEdBQVlMLEtBQUtLLEtBQUwsSUFBY0osT0FBT0ksS0FBakM7QUFDRDs7QUFFRCxNQUFJTCxLQUFLTSxXQUFMLElBQW9CTCxPQUFPSyxXQUEvQixFQUE0QztBQUMxQyxRQUFJLENBQUNDLGdCQUFnQlAsSUFBaEIsQ0FBTCxF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Q0Q7QUFDRjs7QUFFRCxVQUFJRCxhQUFhQyxTQUFqQixFQUE0QjtBQUMxQixZQUFJMEUsUUFBUTNFLFFBQVIsS0FBcUI0RSxXQUFXNUUsUUFBcEMsRUFBOEM7QUFDNUNBLHNCQUFZMkUsUUFBUTNFLFFBQXBCO0FBQ0QsU0FGRCxNQUVPO0FBQ0xBLHFCQUFXQyxTQUFYO0FBQ0Q7QUFDRjtBQUNGLEtBbkJELE1BbUJPO0FBQ0wsVUFBSUQsYUFBYUMsU0FBYixLQUEyQndELEtBQUssQ0FBTCxNQUFZLEdBQVosSUFBbUJBLEtBQUssQ0FBTCxNQUFZLEdBQTFELENBQUosRUFBb0U7QUFDbEV6RDtBQUNEO0FBQ0QsVUFBSUQsYUFBYUUsU0FBYixLQUEyQndELEtBQUssQ0FBTCxNQUFZLEdBQVosSUFBbUJBLEtBQUssQ0FBTCxNQUFZLEdBQTFELENBQUosRUFBb0U7QUFDbEUxRDtBQUNEO0FBQ0Y7QUFDRixHQTVCRDs7QUE4QkEsU0FBTyxFQUFDQSxrQkFBRCxFQUFXQyxrQkFBWCxFQUFQO0FBQ0QiLCJmaWxlIjoibWVyZ2UuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge3N0cnVjdHVyZWRQYXRjaH0gZnJvbSAnLi9jcmVhdGUnO1xuaW1wb3J0IHtwYXJzZVBhdGNofSBmcm9tICcuL3BhcnNlJztcblxuaW1wb3J0IHthcnJheUVxdWFsLCBhcnJheVN0YXJ0c1dpdGh9IGZyb20gJy4uL3V0aWwvYXJyYXknO1xuXG5leHBvcnQgZnVuY3Rpb24gY2FsY0xpbmVDb3VudChodW5rKSB7XG4gIGNvbnN0IHtvbGRMaW5lcywgbmV3TGluZXN9ID0gY2FsY09sZE5ld0xpbmVDb3VudChodW5rLmxpbmVzKTtcblxuICBpZiAob2xkTGluZXMgIT09IHVuZGVmaW5lZCkge1xuICAgIGh1bmsub2xkTGluZXMgPSBvbGRMaW5lcztcbiAgfSBlbHNlIHtcbiAgICBkZWxldGUgaHVuay5vbGRMaW5lcztcbiAgfVxuXG4gIGlmIChuZXdMaW5lcyAhPT0gdW5kZWZpbmVkKSB7XG4gICAgaHVuay5uZXdMaW5lcyA9IG5ld0xpbmVzO1xuICB9IGVsc2Uge1xuICAgIGRlbGV0ZSBodW5rLm5ld0xpbmVzO1xuICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBtZXJnZShtaW5lLCB0aGVpcnMsIGJhc2UpIHtcbiAgbWluZSA9IGxvYWRQYXRjaChtaW5lLCBiYXNlKTtcbiAgdGhlaXJzID0gbG9hZFBhdGNoKHRoZWlycywgYmFzZSk7XG5cbiAgbGV0IHJldCA9IHt9O1xuXG4gIC8vIEZvciBpbmRleCB3ZSBqdXN0IGxldCBpdCBwYXNzIHRocm91Z2ggYXMgaXQgZG9lc24ndCBoYXZlIGFueSBuZWNlc3NhcnkgbWVhbmluZy5cbiAgLy8gTGVhdmluZyBzYW5pdHkgY2hlY2tzIG9uIHRoaXMgdG8gdGhlIEFQSSBjb25zdW1lciB0aGF0IG1heSBrbm93IG1vcmUgYWJvdXQgdGhlXG4gIC8vIG1lYW5pbmcgaW4gdGhlaXIgb3duIGNvbnRleHQuXG4gIGlmIChtaW5lLmluZGV4IHx8IHRoZWlycy5pbmRleCkge1xuICAgIHJldC5pbmRleCA9IG1pbmUuaW5kZXggfHwgdGhlaXJzLmluZGV4O1xuICB9XG5cbiAgaWYgKG1pbmUubmV3RmlsZU5hbWUgfHwgdGhlaXJzLm5ld0ZpbGVOYW1lKSB7XG4gICAgaWYgKCFmaWxlTmFtZUNoYW5nZWQobWluZSkpIHtcbiAgICAgIC8vIE5vIGhlYWRlciBvciBubyBjaGFuZ2UgaW4gb3VycywgdXNlIHRoZWlycyAoYW5kIG91cnMgaWYgdGhlaXJzIGRvZXMgbm90IGV4aXN0KVxuICAgICAgcmV0Lm9sZEZpbGVOYW1lID0gdGhlaXJzLm9sZEZpbGVOYW1lIHx8IG1pbmUub2xkRmlsZU5hbWU7XG4gICAgICByZXQubmV3RmlsZU5hbWUgPSB0aGVpcnMubmV3RmlsZU5hbWUgfHwgbWluZS5uZXdGaWxlTmFtZTtcbiAgICAgIHJldC5vbGRIZWFkZXIgPSB0aGVpcnMub2xkSGVhZGVyIHx8IG1pbmUub2xkSGVhZGVyO1xuICAgICAgcmV0Lm5ld0hlYWRlciA9IHRoZWlycy5uZXdIZWFkZXIgfHwgbWluZS5uZXdIZWFkZXI7XG4gICAgfSBlbHNlIGlmICghZmlsZU5hbWVDaGFuZ2VkKHRoZWlycykpIHtcbiAgICAgIC8vIE5vIGhlYWRlciBvciBubyBjaGFuZ2UgaW4gdGhlaXJzLCB1c2Ugb3Vyc1xuICAgICAgcmV0Lm9sZEZpbGVOYW1lID0gbWluZS5vbGRGaWxlTmFtZTtcbiAgICAgIHJldC5uZXdGaWxlTmFtZSA9IG1pbmUubmV3RmlsZU5hbWU7XG4gICAgICByZXQub2xkSGVhZGVyID0gbWluZS5vbGRIZWFkZXI7XG4gICAgICByZXQubmV3SGVhZGVyID0gbWluZS5uZXdIZWFkZXI7XG4gICAgfSBlbHNlIHtcbiAgICAgIC8vIEJvdGggY2hhbmdlZC4uLiBmaWd1cmUgaXQgb3V0XG4gICAgICByZXQub2xkRmlsZU5hbWUgPSBzZWxlY3RGaWVsZChyZXQsIG1pbmUub2xkRmlsZU5hbWUsIHRoZWlycy5vbGRGaWxlTmFtZSk7XG4gICAgICByZXQubmV3RmlsZU5hbWUgPSBzZWxlY3RGaWVsZChyZXQsIG1pbmUubmV3RmlsZU5hbWUsIHRoZWlycy5uZXdGaWxlTmFtZSk7XG4gICAgICByZXQub2xkSGVhZGVyID0gc2VsZWN0RmllbGQocmV0LCBtaW5lLm9sZEhlYWRlciwgdGhlaXJzLm9sZEhlYWRlcik7XG4gICAgICByZXQubmV3SGVhZGVyID0gc2VsZWN0RmllbGQocmV0LCBtaW5lLm5ld0hlYWRlciwgdGhlaXJzLm5ld0hlYWRlcik7XG4gICAgfVxuICB9XG5cbiAgcmV0Lmh1bmtzID0gW107XG5cbiAgbGV0IG1pbmVJbmRleCA9IDAsXG4gICAgICB0aGVpcnNJbmRleCA9IDAsXG4gICAgICBtaW5lT2Zmc2V0ID0gMCxcbiAgICAgIHRoZWlyc09mZnNldCA9IDA7XG5cbiAgd2hpbGUgKG1pbmVJbmRleCA8IG1pbmUuaHVua3MubGVuZ3RoIHx8IHRoZWlyc0luZGV4IDwgdGhlaXJzLmh1bmtzLmxlbmd0aCkge1xuICAgIGxldCBtaW5lQ3VycmVudCA9IG1pbmUuaHVua3NbbWluZUluZGV4XSB8fCB7b2xkU3RhcnQ6IEluZmluaXR5fSxcbiAgICAgICAgdGhlaXJzQ3VycmVudCA9IHRoZWlycy5odW5rc1t0aGVpcnNJbmRleF0gfHwge29sZFN0YXJ0OiBJbmZpbml0eX07XG5cbiAgICBpZiAoaHVua0JlZm9yZShtaW5lQ3VycmVudCwgdGhlaXJzQ3VycmVudCkpIHtcbiAgICAgIC8vIFRoaXMgcGF0Y2ggZG9lcyBub3Qgb3ZlcmxhcCB3aXRoIGFueSBvZiB0aGUgb3RoZXJzLCB5YXkuXG4gICAgICByZXQuaHVua3MucHVzaChjbG9uZUh1bmsobWluZUN1cnJlbnQsIG1pbmVPZmZzZXQpKTtcbiAgICAgIG1pbmVJbmRleCsrO1xuICAgICAgdGhlaXJzT2Zmc2V0ICs9IG1pbmVDdXJyZW50Lm5ld0xpbmVzIC0gbWluZUN1cnJlbnQub2xkTGluZXM7XG4gICAgfSBlbHNlIGlmIChodW5rQmVmb3JlKHRoZWlyc0N1cnJlbnQsIG1pbmVDdXJyZW50KSkge1xuICAgICAgLy8gVGhpcyBwYXRjaCBkb2VzIG5vdCBvdmVybGFwIHdpdGggYW55IG9mIHRoZSBvdGhlcnMsIHlheS5cbiAgICAgIHJldC5odW5rcy5wdXNoKGNsb25lSHVuayh0aGVpcnNDdXJyZW50LCB0aGVpcnNPZmZzZXQpKTtcbiAgICAgIHRoZWlyc0luZGV4Kys7XG4gICAgICBtaW5lT2Zmc2V0ICs9IHRoZWlyc0N1cnJlbnQubmV3TGluZXMgLSB0aGVpcnNDdXJyZW50Lm9sZExpbmVzO1xuICAgIH0gZWxzZSB7XG4gICAgICAvLyBPdmVybGFwLCBtZXJnZSBhcyBiZXN0IHdlIGNhblxuICAgICAgbGV0IG1lcmdlZEh1bmsgPSB7XG4gICAgICAgIG9sZFN0YXJ0OiBNYXRoLm1pbihtaW5lQ3VycmVudC5vbGRTdGFydCwgdGhlaXJzQ3VycmVudC5vbGRTdGFydCksXG4gICAgICAgIG9sZExpbmVzOiAwLFxuICAgICAgICBuZXdTdGFydDogTWF0aC5taW4obWluZUN1cnJlbnQubmV3U3RhcnQgKyBtaW5lT2Zmc2V0LCB0aGVpcnNDdXJyZW50Lm9sZFN0YXJ0ICsgdGhlaXJzT2Zmc2V0KSxcbiAgICAgICAgbmV3TGluZXM6IDAsXG4gICAgICAgIGxpbmVzOiBbXVxuICAgICAgfTtcbiAgICAgIG1lcmdlTGluZXMobWVyZ2VkSHVuaywgbWluZUN1cnJlbnQub2xkU3RhcnQsIG1pbmVDdXJyZW50LmxpbmVzLCB0aGVpcnNDdXJyZW50Lm9sZFN0YXJ0LCB0aGVpcnNDdXJyZW50LmxpbmVzKTtcbiAgICAgIHRoZWlyc0luZGV4Kys7XG4gICAgICBtaW5lSW5kZXgrKztcblxuICAgICAgcmV0Lmh1bmtzLnB1c2gobWVyZ2VkSHVuayk7XG4gICAgfVxuICB9XG5cbiAgcmV0dXJuIHJldDtcbn1cblxuZnVuY3Rpb24gbG9hZFBhdGNoKHBhcmFtLCBiYXNlKSB7XG4gIGlmICh0eXBlb2YgcGFyYW0gPT09ICdzdHJpbmcnKSB7XG4gICAgaWYgKC9eQEAvbS50ZXN0KHBhcmFtKSB8fCAoL15JbmRleDovbS50ZXN0KHBhcmFtKSkpIHtcbiAgICAgIHJldHVybiBwYXJzZVBhdGNoKHBhcmFtKVswXTtcbiAgICB9XG5cbiAgICBpZiAoIWJhc2UpIHtcbiAgICAgIHRocm93IG5ldyBFcnJvcignTXVzdCBwcm92aWRlIGEgYmFzZSByZWZlcmVuY2Ugb3IgcGFzcyBpbiBhIHBhdGNoJyk7XG4gICAgfVxuICAgIHJldHVybiBzdHJ1Y3R1cmVkUGF0Y2godW5kZWZpbmVkLCB1bmRlZmluZWQsIGJhc2UsIHBhcmFtKTtcbiAgfVxuXG4gIHJldHVybiBwYXJhbTtcbn1cblxuZnVuY3Rpb24gZmlsZU5hbWVDaGFuZ2VkKHBhdGNoKSB7XG4gIHJldHVybiBwYXRjaC5uZXdGaWxlTmFtZSAmJiBwYXRjaC5uZXdGaWxlTmFtZSAhPT0gcGF0Y2gub2xkRmlsZU5hbWU7XG59XG5cbmZ1bmN0aW9uIHNlbGVjdEZpZWxkKGluZGV4LCBtaW5lLCB0aGVpcnMpIHtcbiAgaWYgKG1pbmUgPT09IHRoZWlycykge1xuICAgIHJldHVybiBtaW5lO1xuICB9IGVsc2Uge1xuICAgIGluZGV4LmNvbmZsaWN0ID0gdHJ1ZTtcbiAgICByZXR1cm4ge21pbmUsIHRoZWlyc307XG4gIH1cbn1cblxuZnVuY3Rpb24gaHVua0JlZm9yZSh0ZXN0LCBjaGVjaykge1xuICByZXR1cm4gdGVzdC5vbGRTdGFydCA8IGNoZWNrLm9sZFN0YXJ0XG4gICAgJiYgKHRlc3Qub2xkU3RhcnQgKyB0ZXN0Lm9sZExpbmVzKSA8IGNoZWNrLm9sZFN0YXJ0O1xufVxuXG5mdW5jdGlvbiBjbG9uZUh1bmsoaHVuaywgb2Zmc2V0KSB7XG4gIHJldHVybiB7XG4gICAgb2xkU3RhcnQ6IGh1bmsub2xkU3RhcnQsIG9sZExpbmVzOiBodW5rLm9sZExpbmVzLFxuICAgIG5ld1N0YXJ0OiBodW5rLm5ld1N0YXJ0ICsgb2Zmc2V0LCBuZXdMaW5lczogaHVuay5uZXdMaW5lcyxcbiAgICBsaW5lczogaHVuay5saW5lc1xuICB9O1xufVxuXG5mdW5jdGlvbiBtZXJnZUxpbmVzKGh1bmssIG1pbmVPZmZzZXQsIG1pbmVMaW5lcywgdGhlaXJPZmZzZXQsIHRoZWlyTGluZXMpIHtcbiAgLy8gVGhpcyB3aWxsIGdlbmVyYWxseSByZXN1bHQgaW4gYSBjb25mbGljdGVkIGh1bmssIGJ1dCB0aGVyZSBhcmUgY2FzZXMgd2hlcmUgdGhlIGNvbnRleHRcbiAgLy8gaXMgdGhlIG9ubHkgb3ZlcmxhcCB3aGVyZSB3ZSBjYW4gc3VjY2Vzc2Z1bGx5IG1lcmdlIHRoZSBjb250ZW50IGhlcmUuXG4gIGxldCBtaW5lID0ge29mZnNldDogbWluZU9mZnNldCwgbGluZXM6IG1pbmVMaW5lcywgaW5kZXg6IDB9LFxuICAgICAgdGhlaXIgPSB7b2Zmc2V0OiB0aGVpck9mZnNldCwgbGluZXM6IHRoZWlyTGluZXMsIGluZGV4OiAwfTtcblxuICAvLyBIYW5kbGUgYW55IGxlYWRpbmcgY29udGVudFxuICBpbnNlcnRMZWFkaW5nKGh1bmssIG1pbmUsIHRoZWlyKTtcbiAgaW5zZXJ0TGVhZGluZyhodW5rLCB0aGVpciwgbWluZSk7XG5cbiAgLy8gTm93IGluIHRoZSBvdmVybGFwIGNvbnRlbnQuIFNjYW4gdGhyb3VnaCBhbmQgc2VsZWN0IHRoZSBiZXN0IGNoYW5nZXMgZnJvbSBlYWNoLlxuICB3aGlsZSAobWluZS5pbmRleCA8IG1pbmUubGluZXMubGVuZ3RoICYmIHRoZWlyLmluZGV4IDwgdGhlaXIubGluZXMubGVuZ3RoKSB7XG4gICAgbGV0IG1pbmVDdXJyZW50ID0gbWluZS5saW5lc1ttaW5lLmluZGV4XSxcbiAgICAgICAgdGhlaXJDdXJyZW50ID0gdGhlaXIubGluZXNbdGhlaXIuaW5kZXhdO1xuXG4gICAgaWYgKChtaW5lQ3VycmVudFswXSA9PT0gJy0nIHx8IG1pbmVDdXJyZW50WzBdID09PSAnKycpXG4gICAgICAgICYmICh0aGVpckN1cnJlbnRbMF0gPT09ICctJyB8fCB0aGVpckN1cnJlbnRbMF0gPT09ICcrJykpIHtcbiAgICAgIC8vIEJvdGggbW9kaWZpZWQgLi4uXG4gICAgICBtdXR1YWxDaGFuZ2UoaHVuaywgbWluZSwgdGhlaXIpO1xuICAgIH0gZWxzZSBpZiAobWluZUN1cnJlbnRbMF0gPT09ICcrJyAmJiB0aGVpckN1cnJlbnRbMF0gPT09ICcgJykge1xuICAgICAgLy8gTWluZSBpbnNlcnRlZFxuICAgICAgaHVuay5saW5lcy5wdXNoKC4uLiBjb2xsZWN0Q2hhbmdlKG1pbmUpKTtcbiAgICB9IGVsc2UgaWYgKHRoZWlyQ3VycmVudFswXSA9PT0gJysnICYmIG1pbmVDdXJyZW50WzBdID09PSAnICcpIHtcbiAgICAgIC8vIFRoZWlycyBpbnNlcnRlZFxuICAgICAgaHVuay5saW5lcy5wdXNoKC4uLiBjb2xsZWN0Q2hhbmdlKHRoZWlyKSk7XG4gICAgfSBlbHNlIGlmIChtaW5lQ3VycmVudFswXSA9PT0gJy0nICYmIHRoZWlyQ3VycmVudFswXSA9PT0gJyAnKSB7XG4gICAgICAvLyBNaW5lIHJlbW92ZWQgb3IgZWRpdGVkXG4gICAgICByZW1vdmFsKGh1bmssIG1pbmUsIHRoZWlyKTtcbiAgICB9IGVsc2UgaWYgKHRoZWlyQ3VycmVudFswXSA9PT0gJy0nICYmIG1pbmVDdXJyZW50WzBdID09PSAnICcpIHtcbiAgICAgIC8vIFRoZWlyIHJlbW92ZWQgb3IgZWRpdGVkXG4gICAgICByZW1vdmFsKGh1bmssIHRoZWlyLCBtaW5lLCB0cnVlKTtcbiAgICB9IGVsc2UgaWYgKG1pbmVDdXJyZW50ID09PSB0aGVpckN1cnJlbnQpIHtcbiAgICAgIC8vIENvbnRleHQgaWRlbnRpdHlcbiAgICAgIGh1bmsubGluZXMucHVzaChtaW5lQ3VycmVudCk7XG4gICAgICBtaW5lLmluZGV4Kys7XG4gICAgICB0aGVpci5pbmRleCsrO1xuICAgIH0gZWxzZSB7XG4gICAgICAvLyBDb250ZXh0IG1pc21hdGNoXG4gICAgICBjb25mbGljdChodW5rLCBjb2xsZWN0Q2hhbmdlKG1pbmUpLCBjb2xsZWN0Q2hhbmdlKHRoZWlyKSk7XG4gICAgfVxuICB9XG5cbiAgLy8gTm93IHB1c2ggYW55dGhpbmcgdGhhdCBtYXkgYmUgcmVtYWluaW5nXG4gIGluc2VydFRyYWlsaW5nKGh1bmssIG1pbmUpO1xuICBpbnNlcnRUcmFpbGluZyhodW5rLCB0aGVpcik7XG5cbiAgY2FsY0xpbmVDb3VudChodW5rKTtcbn1cblxuZnVuY3Rpb24gbXV0dWFsQ2hhbmdlKGh1bmssIG1pbmUsIHRoZWlyKSB7XG4gIGxldCBteUNoYW5nZXMgPSBjb2xsZWN0Q2hhbmdlKG1pbmUpLFxuICAgICAgdGhlaXJDaGFuZ2VzID0gY29sbGVjdENoYW5nZSh0aGVpcik7XG5cbiAgaWYgKGFsbFJlbW92ZXMobXlDaGFuZ2VzKSAmJiBhbGxSZW1vdmVzKHRoZWlyQ2hhbmdlcykpIHtcbiAgICAvLyBTcGVjaWFsIGNhc2UgZm9yIHJlbW92ZSBjaGFuZ2VzIHRoYXQgYXJlIHN1cGVyc2V0cyBvZiBvbmUgYW5vdGhlclxuICAgIGlmIChhcnJheVN0YXJ0c1dpdGgobXlDaGFuZ2VzLCB0aGVpckNoYW5nZXMpXG4gICAgICAgICYmIHNraXBSZW1vdmVTdXBlcnNldCh0aGVpciwgbXlDaGFuZ2VzLCBteUNoYW5nZXMubGVuZ3RoIC0gdGhlaXJDaGFuZ2VzLmxlbmd0aCkpIHtcbiAgICAgIGh1bmsubGluZXMucHVzaCguLi4gbXlDaGFuZ2VzKTtcbiAgICAgIHJldHVybjtcbiAgICB9IGVsc2UgaWYgKGFycmF5U3RhcnRzV2l0aCh0aGVpckNoYW5nZXMsIG15Q2hhbmdlcylcbiAgICAgICAgJiYgc2tpcFJlbW92ZVN1cGVyc2V0KG1pbmUsIHRoZWlyQ2hhbmdlcywgdGhlaXJDaGFuZ2VzLmxlbmd0aCAtIG15Q2hhbmdlcy5sZW5ndGgpKSB7XG4gICAgICBodW5rLmxpbmVzLnB1c2goLi4uIHRoZWlyQ2hhbmdlcyk7XG4gICAgICByZXR1cm47XG4gICAgfVxuICB9IGVsc2UgaWYgKGFycmF5RXF1YWwobXlDaGFuZ2VzLCB0aGVpckNoYW5nZXMpKSB7XG4gICAgaHVuay5saW5lcy5wdXNoKC4uLiBteUNoYW5nZXMpO1xuICAgIHJldHVybjtcbiAgfVxuXG4gIGNvbmZsaWN0KGh1bmssIG15Q2hhbmdlcywgdGhlaXJDaGFuZ2VzKTtcbn1cblxuZnVuY3Rpb24gcmVtb3ZhbChodW5rLCBtaW5lLCB0aGVpciwgc3dhcCkge1xuICBsZXQgbXlDaGFuZ2VzID0gY29sbGVjdENoYW5nZShtaW5lKSxcbiAgICAgIHRoZWlyQ2hhbmdlcyA9IGNvbGxlY3RDb250ZXh0KHRoZWlyLCBteUNoYW5nZXMpO1xuICBpZiAodGhlaXJDaGFuZ2VzLm1lcmdlZCkge1xuICAgIGh1bmsubGluZXMucHVzaCguLi4gdGhlaXJDaGFuZ2VzLm1lcmdlZCk7XG4gIH0gZWxzZSB7XG4gICAgY29uZmxpY3QoaHVuaywgc3dhcCA/IHRoZWlyQ2hhbmdlcyA6IG15Q2hhbmdlcywgc3dhcCA/IG15Q2hhbmdlcyA6IHRoZWlyQ2hhbmdlcyk7XG4gIH1cbn1cblxuZnVuY3Rpb24gY29uZmxpY3QoaHVuaywgbWluZSwgdGhlaXIpIHtcbiAgaHVuay5jb25mbGljdCA9IHRydWU7XG4gIGh1bmsubGluZXMucHVzaCh7XG4gICAgY29uZmxpY3Q6IHRydWUsXG4gICAgbWluZTogbWluZSxcbiAgICB0aGVpcnM6IHRoZWlyXG4gIH0pO1xufVxuXG5mdW5jdGlvbiBpbnNlcnRMZWFkaW5nKGh1bmssIGluc2VydCwgdGhlaXIpIHtcbiAgd2hpbGUgKGluc2VydC5vZmZzZXQgPCB0aGVpci5vZmZzZXQgJiYgaW5zZXJ0LmluZGV4IDwgaW5zZXJ0LmxpbmVzLmxlbmd0aCkge1xuICAgIGxldCBsaW5lID0gaW5zZXJ0LmxpbmVzW2luc2VydC5pbmRleCsrXTtcbiAgICBodW5rLmxpbmVzLnB1c2gobGluZSk7XG4gICAgaW5zZXJ0Lm9mZnNldCsrO1xuICB9XG59XG5mdW5jdGlvbiBpbnNlcnRUcmFpbGluZyhodW5rLCBpbnNlcnQpIHtcbiAgd2hpbGUgKGluc2VydC5pbmRleCA8IGluc2VydC5saW5lcy5sZW5ndGgpIHtcbiAgICBsZXQgbGluZSA9IGluc2VydC5saW5lc1tpbnNlcnQuaW5kZXgrK107XG4gICAgaHVuay5saW5lcy5wdXNoKGxpbmUpO1xuICB9XG59XG5cbmZ1bmN0aW9uIGNvbGxlY3RDaGFuZ2Uoc3RhdGUpIHtcbiAgbGV0IHJldCA9IFtdLFxuICAgICAgb3BlcmF0aW9uID0gc3RhdGUubGluZXNbc3RhdGUuaW5kZXhdWzBdO1xuICB3aGlsZSAoc3RhdGUuaW5kZXggPCBzdGF0ZS5saW5lcy5sZW5ndGgpIHtcbiAgICBsZXQgbGluZSA9IHN0YXRlLmxpbmVzW3N0YXRlLmluZGV4XTtcblxuICAgIC8vIEdyb3VwIGFkZGl0aW9ucyB0aGF0IGFyZSBpbW1lZGlhdGVseSBhZnRlciBzdWJ0cmFjdGlvbnMgYW5kIHRyZWF0IHRoZW0gYXMgb25lIFwiYXRvbWljXCIgbW9kaWZ5IGNoYW5nZS5cbiAgICBpZiAob3BlcmF0aW9uID09PSAnLScgJiYgbGluZVswXSA9PT0gJysnKSB7XG4gICAgICBvcGVyYXRpb24gPSAnKyc7XG4gICAgfVxuXG4gICAgaWYgKG9wZXJhdGlvbiA9PT0gbGluZVswXSkge1xuICAgICAgcmV0LnB1c2gobGluZSk7XG4gICAgICBzdGF0ZS5pbmRleCsrO1xuICAgIH0gZWxzZSB7XG4gICAgICBicmVhaztcbiAgICB9XG4gIH1cblxuICByZXR1cm4gcmV0O1xufVxuZnVuY3Rpb24gY29sbGVjdENvbnRleHQoc3RhdGUsIG1hdGNoQ2hhbmdlcykge1xuICBsZXQgY2hhbmdlcyA9IFtdLFxuICAgICAgbWVyZ2VkID0gW10sXG4gICAgICBtYXRjaEluZGV4ID0gMCxcbiAgICAgIGNvbnRleHRDaGFuZ2VzID0gZmFsc2UsXG4gICAgICBjb25mbGljdGVkID0gZmFsc2U7XG4gIHdoaWxlIChtYXRjaEluZGV4IDwgbWF0Y2hDaGFuZ2VzLmxlbmd0aFxuICAgICAgICAmJiBzdGF0ZS5pbmRleCA8IHN0YXRlLmxpbmVzLmxlbmd0aCkge1xuICAgIGxldCBjaGFuZ2UgPSBzdGF0ZS5saW5lc1tzdGF0ZS5pbmRleF0sXG4gICAgICAgIG1hdGNoID0gbWF0Y2hDaGFuZ2VzW21hdGNoSW5kZXhdO1xuXG4gICAgLy8gT25jZSB3ZSd2ZSBoaXQgb3VyIGFkZCwgdGhlbiB3ZSBhcmUgZG9uZVxuICAgIGlmIChtYXRjaFswXSA9PT0gJysnKSB7XG4gICAgICBicmVhaztcbiAgICB9XG5cbiAgICBjb250ZXh0Q2hhbmdlcyA9IGNvbnRleHRDaGFuZ2VzIHx8IGNoYW5nZVswXSAhPT0gJyAnO1xuXG4gICAgbWVyZ2VkLnB1c2gobWF0Y2gpO1xuICAgIG1hdGNoSW5kZXgrKztcblxuICAgIC8vIENvbnN1bWUgYW55IGFkZGl0aW9ucyBpbiB0aGUgb3RoZXIgYmxvY2sgYXMgYSBjb25mbGljdCB0byBhdHRlbXB0XG4gICAgLy8gdG8gcHVsbCBpbiB0aGUgcmVtYWluaW5nIGNvbnRleHQgYWZ0ZXIgdGhpc1xuICAgIGlmIChjaGFuZ2VbMF0gPT09ICcrJykge1xuICAgICAgY29uZmxpY3RlZCA9IHRydWU7XG5cbiAgICAgIHdoaWxlIChjaGFuZ2VbMF0gPT09ICcrJykge1xuICAgICAgICBjaGFuZ2VzLnB1c2goY2hhbmdlKTtcbiAgICAgICAgY2hhbmdlID0gc3RhdGUubGluZXNbKytzdGF0ZS5pbmRleF07XG4gICAgICB9XG4gICAgfVxuXG4gICAgaWYgKG1hdGNoLnN1YnN0cigxKSA9PT0gY2hhbmdlLnN1YnN0cigxKSkge1xuICAgICAgY2hhbmdlcy5wdXNoKGNoYW5nZSk7XG4gICAgICBzdGF0ZS5pbmRleCsrO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25mbGljdGVkID0gdHJ1ZTtcbiAgICB9XG4gIH1cblxuICBpZiAoKG1hdGNoQ2hhbmdlc1ttYXRjaEluZGV4XSB8fCAnJylbMF0gPT09ICcrJ1xuICAgICAgJiYgY29udGV4dENoYW5nZXMpIHtcbiAgICBjb25mbGljdGVkID0gdHJ1ZTtcbiAgfVxuXG4gIGlmIChjb25mbGljdGVkKSB7XG4gICAgcmV0dXJuIGNoYW5nZXM7XG4gIH1cblxuICB3aGlsZSAobWF0Y2hJbmRleCA8IG1hdGNoQ2hhbmdlcy5sZW5ndGgpIHtcbiAgICBtZXJnZWQucHVzaChtYXRjaENoYW5nZXNbbWF0Y2hJbmRleCsrXSk7XG4gIH1cblxuICByZXR1cm4ge1xuICAgIG1lcmdlZCxcbiAgICBjaGFuZ2VzXG4gIH07XG59XG5cbmZ1bmN0aW9uIGFsbFJlbW92ZXMoY2hhbmdlcykge1xuICByZXR1cm4gY2hhbmdlcy5yZWR1Y2UoZnVuY3Rpb24ocHJldiwgY2hhbmdlKSB7XG4gICAgcmV0dXJuIHByZXYgJiYgY2hhbmdlWzBdID09PSAnLSc7XG4gIH0sIHRydWUpO1xufVxuZnVuY3Rpb24gc2tpcFJlbW92ZVN1cGVyc2V0KHN0YXRlLCByZW1vdmVDaGFuZ2VzLCBkZWx0YSkge1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGRlbHRhOyBpKyspIHtcbiAgICBsZXQgY2hhbmdlQ29udGVudCA9IHJlbW92ZUNoYW5nZXNbcmVtb3ZlQ2hhbmdlcy5sZW5ndGggLSBkZWx0YSArIGldLnN1YnN0cigxKTtcbiAgICBpZiAoc3RhdGUubGluZXNbc3RhdGUuaW5kZXggKyBpXSAhPT0gJyAnICsgY2hhbmdlQ29udGVudCkge1xuICAgICAgcmV0dXJuIGZhbHNlO1xuICAgIH1cbiAgfVxuXG4gIHN0YXRlLmluZGV4ICs9IGRlbHRhO1xuICByZXR1cm4gdHJ1ZTtcbn1cblxuZnVuY3Rpb24gY2FsY09sZE5ld0xpbmVDb3VudChsaW5lcykge1xuICBsZXQgb2xkTGluZXMgPSAwO1xuICBsZXQgbmV3TGluZXMgPSAwO1xuXG4gIGxpbmVzLmZvckVhY2goZnVuY3Rpb24obGluZSkge1xuICAgIGlmICh0eXBlb2YgbGluZSAhPT0gJ3N0cmluZycpIHtcbiAgICAgIGxldCBteUNvdW50ID0gY2FsY09sZE5ld0xpbmVDb3VudChsaW5lLm1pbmUpO1xuICAgICAgbGV0IHRoZWlyQ291bnQgPSBjYWxjT2xkTmV3TGluZUNvdW50KGxpbmUudGhlaXJzKTtcblxuICAgICAgaWYgKG9sZExpbmVzICE9PSB1bmRlZmluZWQpIHtcbiAgICAgICAgaWYgKG15Q291bnQub2xkTGluZXMgPT09IHRoZWlyQ291bnQub2xkTGluZXMpIHtcbiAgICAgICAgICBvbGRMaW5lcyArPSBteUNvdW50Lm9sZExpbmVzO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIG9sZExpbmVzID0gdW5kZWZpbmVkO1xuICAgICAgICB9XG4gICAgICB9XG5cbiAgICAgIGlmIChuZXdMaW5lcyAhPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIGlmIChteUNvdW50Lm5ld0xpbmVzID09PSB0aGVpckNvdW50Lm5ld0xpbmVzKSB7XG4gICAgICAgICAgbmV3TGluZXMgKz0gbXlDb3VudC5uZXdMaW5lcztcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICBuZXdMaW5lcyA9IHVuZGVmaW5lZDtcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICBpZiAobmV3TGluZXMgIT09IHVuZGVmaW5lZCAmJiAobGluZVswXSA9PT0gJysnIHx8IGxpbmVbMF0gPT09ICcgJykpIHtcbiAgICAgICAgbmV3TGluZXMrKztcbiAgICAgIH1cbiAgICAgIGlmIChvbGRMaW5lcyAhPT0gdW5kZWZpbmVkICYmIChsaW5lWzBdID09PSAnLScgfHwgbGluZVswXSA9PT0gJyAnKSkge1xuICAgICAgICBvbGRMaW5lcysrO1xuICAgICAgfVxuICAgIH1cbiAgfSk7XG5cbiAgcmV0dXJuIHtvbGRMaW5lcywgbmV3TGluZXN9O1xufVxuIl19


/***/ }),
/* 14 */
/***/ (function(module, exports, __webpack_require__) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/structuredPatch = structuredPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/createTwoFilesPatch = createTwoFilesPatch;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/createPatch = createPatch;

	var /*istanbul ignore start*/_line = __webpack_require__(5) /*istanbul ignore end*/;

	/*istanbul ignore start*/function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

	/*istanbul ignore end*/function structuredPatch(oldFileName, newFileName, oldStr, newStr, oldHeader, newHeader, options) {
	  if (!options) {
	    options = {};
	  }
	  if (typeof options.context === 'undefined') {
	    options.context = 4;
	  }

	  var diff = /*istanbul ignore start*/(0, _line.diffLines) /*istanbul ignore end*/(oldStr, newStr, options);
	  diff.push({ value: '', lines: [] }); // Append an empty value to make cleanup easier

	  function contextLines(lines) {
	    return lines.map(function (entry) {
	      return ' ' + entry;
	    });
	  }

	  var hunks = [];
	  var oldRangeStart = 0,
	      newRangeStart = 0,
	      curRange = [],
	      oldLine = 1,
	      newLine = 1;

	  /*istanbul ignore start*/var _loop = function _loop( /*istanbul ignore end*/i) {
	    var current = diff[i],
	        lines = current.lines || current.value.replace(/\n$/, '').split('\n');
	    current.lines = lines;

	    if (current.added || current.removed) {
	      /*istanbul ignore start*/var _curRange;

	      /*istanbul ignore end*/ // If we have previous context, start with that
	      if (!oldRangeStart) {
	        var prev = diff[i - 1];
	        oldRangeStart = oldLine;
	        newRangeStart = newLine;

	        if (prev) {
	          curRange = options.context > 0 ? contextLines(prev.lines.slice(-options.context)) : [];
	          oldRangeStart -= curRange.length;
	          newRangeStart -= curRange.length;
	        }
	      }

	      // Output our changes
	      /*istanbul ignore start*/(_curRange = /*istanbul ignore end*/curRange).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_curRange /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/lines.map(function (entry) {
	        return (current.added ? '+' : '-') + entry;
	      })));

	      // Track the updated file position
	      if (current.added) {
	        newLine += lines.length;
	      } else {
	        oldLine += lines.length;
	      }
	    } else {
	      // Identical context lines. Track line changes
	      if (oldRangeStart) {
	        // Close out any changes that have been output (or join overlapping)
	        if (lines.length <= options.context * 2 && i < diff.length - 2) {
	          /*istanbul ignore start*/var _curRange2;

	          /*istanbul ignore end*/ // Overlapping
	          /*istanbul ignore start*/(_curRange2 = /*istanbul ignore end*/curRange).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_curRange2 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/contextLines(lines)));
	        } else {
	          /*istanbul ignore start*/var _curRange3;

	          /*istanbul ignore end*/ // end the range and output
	          var contextSize = Math.min(lines.length, options.context);
	          /*istanbul ignore start*/(_curRange3 = /*istanbul ignore end*/curRange).push. /*istanbul ignore start*/apply /*istanbul ignore end*/( /*istanbul ignore start*/_curRange3 /*istanbul ignore end*/, /*istanbul ignore start*/_toConsumableArray( /*istanbul ignore end*/contextLines(lines.slice(0, contextSize))));

	          var hunk = {
	            oldStart: oldRangeStart,
	            oldLines: oldLine - oldRangeStart + contextSize,
	            newStart: newRangeStart,
	            newLines: newLine - newRangeStart + contextSize,
	            lines: curRange
	          };
	          if (i >= diff.length - 2 && lines.length <= options.context) {
	            // EOF is inside this hunk
	            var oldEOFNewline = /\n$/.test(oldStr);
	            var newEOFNewline = /\n$/.test(newStr);
	            if (lines.length == 0 && !oldEOFNewline) {
	              // special case: old has no eol and no trailing context; no-nl can end up before adds
	              curRange.splice(hunk.oldLines, 0, '\\ No newline at end of file');
	            } else if (!oldEOFNewline || !newEOFNewline) {
	              curRange.push('\\ No newline at end of file');
	            }
	          }
	          hunks.push(hunk);

	          oldRangeStart = 0;
	          newRangeStart = 0;
	          curRange = [];
	        }
	      }
	      oldLine += lines.length;
	      newLine += lines.length;
	    }
	  };

	  for (var i = 0; i < diff.length; i++) {
	    /*istanbul ignore start*/_loop( /*istanbul ignore end*/i);
	  }

	  return {
	    oldFileName: oldFileName, newFileName: newFileName,
	    oldHeader: oldHeader, newHeader: newHeader,
	    hunks: hunks
	  };
	}

	function createTwoFilesPatch(oldFileName, newFileName, oldStr, newStr, oldHeader, newHeader, options) {
	  var diff = structuredPatch(oldFileName, newFileName, oldStr, newStr, oldHeader, newHeader, options);

	  var ret = [];
	  if (oldFileName == newFileName) {
	    ret.push('Index: ' + oldFileName);
	  }
	  ret.push('===================================================================');
	  ret.push('--- ' + diff.oldFileName + (typeof diff.oldHeader === 'undefined' ? '' : '\t' + diff.oldHeader));
	  ret.push('+++ ' + diff.newFileName + (typeof diff.newHeader === 'undefined' ? '' : '\t' + diff.newHeader));

	  for (var i = 0; i < diff.hunks.length; i++) {
	    var hunk = diff.hunks[i];
	    ret.push('@@ -' + hunk.oldStart + ',' + hunk.oldLines + ' +' + hunk.newStart + ',' + hunk.newLines + ' @@');
	    ret.push.apply(ret, hunk.lines);
	  }

	  return ret.join('\n') + '\n';
	}

	function createPatch(fileName, oldStr, newStr, oldHeader, newHeader, options) {
	  return createTwoFilesPatch(fileName, fileName, oldStr, newStr, oldHeader, newHeader, options);
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9wYXRjaC9jcmVhdGUuanMiXSwibmFtZXMiOlsic3RydWN0dXJlZFBhdGNoIiwiY3JlYXRlVHdvRmlsZXNQYXRjaCIsImNyZWF0ZVBhdGNoIiwib2xkRmlsZU5hbWUiLCJuZXdGaWxlTmFtZSIsIm9sZFN0ciIsIm5ld1N0ciIsIm9sZEhlYWRlciIsIm5ld0hlYWRlciIsIm9wdGlvbnMiLCJjb250ZXh0IiwiZGlmZiIsInB1c2giLCJ2YWx1ZSIsImxpbmVzIiwiY29udGV4dExpbmVzIiwibWFwIiwiZW50cnkiLCJodW5rcyIsIm9sZFJhbmdlU3RhcnQiLCJuZXdSYW5nZVN0YXJ0IiwiY3VyUmFuZ2UiLCJvbGRMaW5lIiwibmV3TGluZSIsImkiLCJjdXJyZW50IiwicmVwbGFjZSIsInNwbGl0IiwiYWRkZWQiLCJyZW1vdmVkIiwicHJldiIsInNsaWNlIiwibGVuZ3RoIiwiY29udGV4dFNpemUiLCJNYXRoIiwibWluIiwiaHVuayIsIm9sZFN0YXJ0Iiwib2xkTGluZXMiLCJuZXdTdGFydCIsIm5ld0xpbmVzIiwib2xkRU9GTmV3bGluZSIsInRlc3QiLCJuZXdFT0ZOZXdsaW5lIiwic3BsaWNlIiwicmV0IiwiYXBwbHkiLCJqb2luIiwiZmlsZU5hbWUiXSwibWFwcGluZ3MiOiI7OztnQ0FFZ0JBLGUsR0FBQUEsZTt5REFpR0FDLG1CLEdBQUFBLG1CO3lEQXdCQUMsVyxHQUFBQSxXOztBQTNIaEI7Ozs7dUJBRU8sU0FBU0YsZUFBVCxDQUF5QkcsV0FBekIsRUFBc0NDLFdBQXRDLEVBQW1EQyxNQUFuRCxFQUEyREMsTUFBM0QsRUFBbUVDLFNBQW5FLEVBQThFQyxTQUE5RSxFQUF5RkMsT0FBekYsRUFBa0c7QUFDdkcsTUFBSSxDQUFDQSxPQUFMLEVBQWM7QUFDWkEsY0FBVSxFQUFWO0FBQ0Q7QUFDRCxNQUFJLE9BQU9BLFFBQVFDLE9BQWYsS0FBMkIsV0FBL0IsRUFBNEM7QUFDMUNELFlBQVFDLE9BQVIsR0FBa0IsQ0FBbEI7QUFDRDs7QUFFRCxN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QUEvQyxFQUEwREMsU0FBMUQsRUFBcUVDLE9BQXJFLEVBQThFO0FBQ25GLFNBQU9SLG9CQUFvQitDLFFBQXBCLEVBQThCQSxRQUE5QixFQUF3QzNDLE1BQXhDLEVBQWdEQyxNQUFoRCxFQUF3REMsU0FBeEQsRUFBbUVDLFNBQW5FLEVBQThFQyxPQUE5RSxDQUFQO0FBQ0QiLCJmaWxlIjoiY3JlYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtkaWZmTGluZXN9IGZyb20gJy4uL2RpZmYvbGluZSc7XG5cbmV4cG9ydCBmdW5jdGlvbiBzdHJ1Y3R1cmVkUGF0Y2gob2xkRmlsZU5hbWUsIG5ld0ZpbGVOYW1lLCBvbGRTdHIsIG5ld1N0ciwgb2xkSGVhZGVyLCBuZXdIZWFkZXIsIG9wdGlvbnMpIHtcbiAgaWYgKCFvcHRpb25zKSB7XG4gICAgb3B0aW9ucyA9IHt9O1xuICB9XG4gIGlmICh0eXBlb2Ygb3B0aW9ucy5jb250ZXh0ID09PSAndW5kZWZpbmVkJykge1xuICAgIG9wdGlvbnMuY29udGV4dCA9IDQ7XG4gIH1cblxuICBjb25zdCBkaWZmID0gZGlmZkxpbmVzKG9sZFN0ciwgbmV3U3RyLCBvcHRpb25zKTtcbiAgZGlmZi5wdXNoKHt2YWx1ZTogJycsIGxpbmVzOiBbXX0pOyAgIC8vIEFwcGVuZCBhbiBlbXB0eSB2YWx1ZSB0byBtYWtlIGNsZWFudXAgZWFzaWVyXG5cbiAgZnVuY3Rpb24gY29udGV4dExpbmVzKGxpbmVzKSB7XG4gICAgcmV0dXJuIGxpbmVzLm1hcChmdW5jdGlvbihlbnRyeSkgeyByZXR1cm4gJyAnICsgZW50cnk7IH0pO1xuICB9XG5cbiAgbGV0IGh1bmtzID0gW107XG4gIGxldCBvbGRSYW5nZVN0YXJ0ID0gMCwgbmV3UmFuZ2VTdGFydCA9IDAsIGN1clJhbmdlID0gW10sXG4gICAgICBvbGRMaW5lID0gMSwgbmV3TGluZSA9IDE7XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgZGlmZi5sZW5ndGg7IGkrKykge1xuICAgIGNvbnN0IGN1cnJlbnQgPSBkaWZmW2ldLFxuICAgICAgICAgIGxpbmVzID0gY3VycmVudC5saW5lcyB8fCBjdXJyZW50LnZhbHVlLnJlcGxhY2UoL1xcbiQvLCAnJykuc3BsaXQoJ1xcbicpO1xuICAgIGN1cnJlbnQubGluZXMgPSBsaW5lcztcblxuICAgIGlmIChjdXJyZW50LmFkZGVkIHx8IGN1cnJlbnQucmVtb3ZlZCkge1xuICAgICAgLy8gSWYgd2UgaGF2ZSBwcmV2aW91cyBjb250ZXh0LCBzdGFydCB3aXRoIHRoYXRcbiAgICAgIGlmICghb2xkUmFuZ2VTdGFydCkge1xuICAgICAgICBjb25zdCBwcmV2ID0gZGlmZltpIC0gMV07XG4gICAgICAgIG9sZFJhbmdlU3RhcnQgPSBvbGRMaW5lO1xuICAgICAgICBuZXdSYW5nZVN0YXJ0ID0gbmV3TGluZTtcblxuICAgICAgICBpZiAocHJldikge1xuICAgICAgICAgIGN1clJhbmdlID0gb3B0aW9ucy5jb250ZXh0ID4gMCA/IGNvbnRleHRMaW5lcyhwcmV2LmxpbmVzLnNsaWNlKC1vcHRpb25zLmNvbnRleHQpKSA6IFtdO1xuICAgICAgICAgIG9sZFJhbmdlU3RhcnQgLT0gY3VyUmFuZ2UubGVuZ3RoO1xuICAgICAgICAgIG5ld1JhbmdlU3RhcnQgLT0gY3VyUmFuZ2UubGVuZ3RoO1xuICAgICAgICB9XG4gICAgICB9XG5cbiAgICAgIC8vIE91dHB1dCBvdXIgY2hhbmdlc1xuICAgICAgY3VyUmFuZ2UucHVzaCguLi4gbGluZXMubWFwKGZ1bmN0aW9uKGVudHJ5KSB7XG4gICAgICAgIHJldHVybiAoY3VycmVudC5hZGRlZCA/ICcrJyA6ICctJykgKyBlbnRyeTtcbiAgICAgIH0pKTtcblxuICAgICAgLy8gVHJhY2sgdGhlIHVwZGF0ZWQgZmlsZSBwb3NpdGlvblxuICAgICAgaWYgKGN1cnJlbnQuYWRkZWQpIHtcbiAgICAgICAgbmV3TGluZSArPSBsaW5lcy5sZW5ndGg7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICBvbGRMaW5lICs9IGxpbmVzLmxlbmd0aDtcbiAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgLy8gSWRlbnRpY2FsIGNvbnRleHQgbGluZXMuIFRyYWNrIGxpbmUgY2hhbmdlc1xuICAgICAgaWYgKG9sZFJhbmdlU3RhcnQpIHtcbiAgICAgICAgLy8gQ2xvc2Ugb3V0IGFueSBjaGFuZ2VzIHRoYXQgaGF2ZSBiZWVuIG91dHB1dCAob3Igam9pbiBvdmVybGFwcGluZylcbiAgICAgICAgaWYgKGxpbmVzLmxlbmd0aCA8PSBvcHRpb25zLmNvbnRleHQgKiAyICYmIGkgPCBkaWZmLmxlbmd0aCAtIDIpIHtcbiAgICAgICAgICAvLyBPdmVybGFwcGluZ1xuICAgICAgICAgIGN1clJhbmdlLnB1c2goLi4uIGNvbnRleHRMaW5lcyhsaW5lcykpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIC8vIGVuZCB0aGUgcmFuZ2UgYW5kIG91dHB1dFxuICAgICAgICAgIGxldCBjb250ZXh0U2l6ZSA9IE1hdGgubWluKGxpbmVzLmxlbmd0aCwgb3B0aW9ucy5jb250ZXh0KTtcbiAgICAgICAgICBjdXJSYW5nZS5wdXNoKC4uLiBjb250ZXh0TGluZXMobGluZXMuc2xpY2UoMCwgY29udGV4dFNpemUpKSk7XG5cbiAgICAgICAgICBsZXQgaHVuayA9IHtcbiAgICAgICAgICAgIG9sZFN0YXJ0OiBvbGRSYW5nZVN0YXJ0LFxuICAgICAgICAgICAgb2xkTGluZXM6IChvbGRMaW5lIC0gb2xkUmFuZ2VTdGFydCArIGNvbnRleHRTaXplKSxcbiAgICAgICAgICAgIG5ld1N0YXJ0OiBuZXdSYW5nZVN0YXJ0LFxuICAgICAgICAgICAgbmV3TGluZXM6IChuZXdMaW5lIC0gbmV3UmFuZ2VTdGFydCArIGNvbnRleHRTaXplKSxcbiAgICAgICAgICAgIGxpbmVzOiBjdXJSYW5nZVxuICAgICAgICAgIH07XG4gICAgICAgICAgaWYgKGkgPj0gZGlmZi5sZW5ndGggLSAyICYmIGxpbmVzLmxlbmd0aCA8PSBvcHRpb25zLmNvbnRleHQpIHtcbiAgICAgICAgICAgIC8vIEVPRiBpcyBpbnNpZGUgdGhpcyBodW5rXG4gICAgICAgICAgICBsZXQgb2xkRU9GTmV3bGluZSA9ICgvXFxuJC8udGVzdChvbGRTdHIpKTtcbiAgICAgICAgICAgIGxldCBuZXdFT0ZOZXdsaW5lID0gKC9cXG4kLy50ZXN0KG5ld1N0cikpO1xuICAgICAgICAgICAgaWYgKGxpbmVzLmxlbmd0aCA9PSAwICYmICFvbGRFT0ZOZXdsaW5lKSB7XG4gICAgICAgICAgICAgIC8vIHNwZWNpYWwgY2FzZTogb2xkIGhhcyBubyBlb2wgYW5kIG5vIHRyYWlsaW5nIGNvbnRleHQ7IG5vLW5sIGNhbiBlbmQgdXAgYmVmb3JlIGFkZHNcbiAgICAgICAgICAgICAgY3VyUmFuZ2Uuc3BsaWNlKGh1bmsub2xkTGluZXMsIDAsICdcXFxcIE5vIG5ld2xpbmUgYXQgZW5kIG9mIGZpbGUnKTtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoIW9sZEVPRk5ld2xpbmUgfHwgIW5ld0VPRk5ld2xpbmUpIHtcbiAgICAgICAgICAgICAgY3VyUmFuZ2UucHVzaCgnXFxcXCBObyBuZXdsaW5lIGF0IGVuZCBvZiBmaWxlJyk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgfVxuICAgICAgICAgIGh1bmtzLnB1c2goaHVuayk7XG5cbiAgICAgICAgICBvbGRSYW5nZVN0YXJ0ID0gMDtcbiAgICAgICAgICBuZXdSYW5nZVN0YXJ0ID0gMDtcbiAgICAgICAgICBjdXJSYW5nZSA9IFtdO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgICBvbGRMaW5lICs9IGxpbmVzLmxlbmd0aDtcbiAgICAgIG5ld0xpbmUgKz0gbGluZXMubGVuZ3RoO1xuICAgIH1cbiAgfVxuXG4gIHJldHVybiB7XG4gICAgb2xkRmlsZU5hbWU6IG9sZEZpbGVOYW1lLCBuZXdGaWxlTmFtZTogbmV3RmlsZU5hbWUsXG4gICAgb2xkSGVhZGVyOiBvbGRIZWFkZXIsIG5ld0hlYWRlcjogbmV3SGVhZGVyLFxuICAgIGh1bmtzOiBodW5rc1xuICB9O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gY3JlYXRlVHdvRmlsZXNQYXRjaChvbGRGaWxlTmFtZSwgbmV3RmlsZU5hbWUsIG9sZFN0ciwgbmV3U3RyLCBvbGRIZWFkZXIsIG5ld0hlYWRlciwgb3B0aW9ucykge1xuICBjb25zdCBkaWZmID0gc3RydWN0dXJlZFBhdGNoKG9sZEZpbGVOYW1lLCBuZXdGaWxlTmFtZSwgb2xkU3RyLCBuZXdTdHIsIG9sZEhlYWRlciwgbmV3SGVhZGVyLCBvcHRpb25zKTtcblxuICBjb25zdCByZXQgPSBbXTtcbiAgaWYgKG9sZEZpbGVOYW1lID09IG5ld0ZpbGVOYW1lKSB7XG4gICAgcmV0LnB1c2goJ0luZGV4OiAnICsgb2xkRmlsZU5hbWUpO1xuICB9XG4gIHJldC5wdXNoKCc9PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09Jyk7XG4gIHJldC5wdXNoKCctLS0gJyArIGRpZmYub2xkRmlsZU5hbWUgKyAodHlwZW9mIGRpZmYub2xkSGVhZGVyID09PSAndW5kZWZpbmVkJyA/ICcnIDogJ1xcdCcgKyBkaWZmLm9sZEhlYWRlcikpO1xuICByZXQucHVzaCgnKysrICcgKyBkaWZmLm5ld0ZpbGVOYW1lICsgKHR5cGVvZiBkaWZmLm5ld0hlYWRlciA9PT0gJ3VuZGVmaW5lZCcgPyAnJyA6ICdcXHQnICsgZGlmZi5uZXdIZWFkZXIpKTtcblxuICBmb3IgKGxldCBpID0gMDsgaSA8IGRpZmYuaHVua3MubGVuZ3RoOyBpKyspIHtcbiAgICBjb25zdCBodW5rID0gZGlmZi5odW5rc1tpXTtcbiAgICByZXQucHVzaChcbiAgICAgICdAQCAtJyArIGh1bmsub2xkU3RhcnQgKyAnLCcgKyBodW5rLm9sZExpbmVzXG4gICAgICArICcgKycgKyBodW5rLm5ld1N0YXJ0ICsgJywnICsgaHVuay5uZXdMaW5lc1xuICAgICAgKyAnIEBAJ1xuICAgICk7XG4gICAgcmV0LnB1c2guYXBwbHkocmV0LCBodW5rLmxpbmVzKTtcbiAgfVxuXG4gIHJldHVybiByZXQuam9pbignXFxuJykgKyAnXFxuJztcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGNyZWF0ZVBhdGNoKGZpbGVOYW1lLCBvbGRTdHIsIG5ld1N0ciwgb2xkSGVhZGVyLCBuZXdIZWFkZXIsIG9wdGlvbnMpIHtcbiAgcmV0dXJuIGNyZWF0ZVR3b0ZpbGVzUGF0Y2goZmlsZU5hbWUsIGZpbGVOYW1lLCBvbGRTdHIsIG5ld1N0ciwgb2xkSGVhZGVyLCBuZXdIZWFkZXIsIG9wdGlvbnMpO1xufVxuIl19


/***/ }),
/* 15 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/"use strict";

	exports.__esModule = true;
	exports. /*istanbul ignore end*/arrayEqual = arrayEqual;
	/*istanbul ignore start*/exports. /*istanbul ignore end*/arrayStartsWith = arrayStartsWith;
	function arrayEqual(a, b) {
	  if (a.length !== b.length) {
	    return false;
	  }

	  return arrayStartsWith(a, b);
	}

	function arrayStartsWith(array, start) {
	  if (start.length > array.length) {
	    return false;
	  }

	  for (var i = 0; i < start.length; i++) {
	    if (start[i] !== array[i]) {
	      return false;
	    }
	  }

	  return true;
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy91dGlsL2FycmF5LmpzIl0sIm5hbWVzIjpbImFycmF5RXF1YWwiLCJhcnJheVN0YXJ0c1dpdGgiLCJhIiwiYiIsImxlbmd0aCIsImFycmF5Iiwic3RhcnQiLCJpIl0sIm1hcHBpbmdzIjoiOzs7Z0NBQWdCQSxVLEdBQUFBLFU7eURBUUFDLGUsR0FBQUEsZTtBQVJULFNBQVNELFVBQVQsQ0FBb0JFLENBQXBCLEVBQXVCQyxDQUF2QixFQUEwQjtBQUMvQixNQUFJRCxFQUFFRSxNQUFGLEtBQWFELEVBQUVDLE1BQW5CLEVBQTJCO0FBQ3pCLFdBQU8sS0FBUDtBQUNEOztBQUVELFNBQU9ILGdCQUFnQkMsQ0FBaEIsRUFBbUJDLENBQW5CLENBQVA7QUFDRDs7QUFFTSxTQUFTRixlQUFULENBQXlCSSxLQUF6QixFQUFnQ0MsS0FBaEMsRUFBdUM7QUFDNUMsTUFBSUEsTUFBTUYsTUFBTixHQUFlQyxNQUFNRCxNQUF6QixFQUFpQztBQUMvQixXQUFPLEtBQVA7QUFDRDs7QUFFRCxPQUFLLElBQUlHLElBQUksQ0FBYixFQUFnQkEsSUFBSUQsTUFBTUYsTUFBMUIsRUFBa0NHLEdBQWxDLEVBQXVDO0FBQ3JDLFFBQUlELE1BQU1DLENBQU4sTUFBYUYsTUFBTUUsQ0FBTixDQUFqQixFQUEyQjtBQUN6QixhQUFPLEtBQVA7QUFDRDtBQUNGOztBQUVELFNBQU8sSUFBUDtBQUNEIiwiZmlsZSI6ImFycmF5LmpzIiwic291cmNlc0NvbnRlbnQiOlsiZXhwb3J0IGZ1bmN0aW9uIGFycmF5RXF1YWwoYSwgYikge1xuICBpZiAoYS5sZW5ndGggIT09IGIubGVuZ3RoKSB7XG4gICAgcmV0dXJuIGZhbHNlO1xuICB9XG5cbiAgcmV0dXJuIGFycmF5U3RhcnRzV2l0aChhLCBiKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGFycmF5U3RhcnRzV2l0aChhcnJheSwgc3RhcnQpIHtcbiAgaWYgKHN0YXJ0Lmxlbmd0aCA+IGFycmF5Lmxlbmd0aCkge1xuICAgIHJldHVybiBmYWxzZTtcbiAgfVxuXG4gIGZvciAobGV0IGkgPSAwOyBpIDwgc3RhcnQubGVuZ3RoOyBpKyspIHtcbiAgICBpZiAoc3RhcnRbaV0gIT09IGFycmF5W2ldKSB7XG4gICAgICByZXR1cm4gZmFsc2U7XG4gICAgfVxuICB9XG5cbiAgcmV0dXJuIHRydWU7XG59XG4iXX0=


/***/ }),
/* 16 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/"use strict";

	exports.__esModule = true;
	exports. /*istanbul ignore end*/convertChangesToDMP = convertChangesToDMP;
	// See: http://code.google.com/p/google-diff-match-patch/wiki/API
	function convertChangesToDMP(changes) {
	  var ret = [],
	      change = /*istanbul ignore start*/void 0 /*istanbul ignore end*/,
	      operation = /*istanbul ignore start*/void 0 /*istanbul ignore end*/;
	  for (var i = 0; i < changes.length; i++) {
	    change = changes[i];
	    if (change.added) {
	      operation = 1;
	    } else if (change.removed) {
	      operation = -1;
	    } else {
	      operation = 0;
	    }

	    ret.push([operation, change.value]);
	  }
	  return ret;
	}
	//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uLy4uL3NyYy9jb252ZXJ0L2RtcC5qcyJdLCJuYW1lcyI6WyJjb252ZXJ0Q2hhbmdlc1RvRE1QIiwiY2hhbmdlcyIsInJldCIsImNoYW5nZSIsIm9wZXJhdGlvbiIsImkiLCJsZW5ndGgiLCJhZGRlZCIsInJlbW92ZWQiLCJwdXNoIiwidmFsdWUiXSwibWFwcGluZ3MiOiI7OztnQ0FDZ0JBLG1CLEdBQUFBLG1CO0FBRGhCO0FBQ08sU0FBU0EsbUJBQVQsQ0FBNkJDLE9BQTdCLEVBQXNDO0FBQzNDLE1BQUlDLE1BQU0sRUFBVjtBQUFBLE1BQ0lDLHdDQURKO0FBQUEsTUFFSUMsMkNBRko7QUFHQSxPQUFLLElBQUlDLElBQUksQ0FBYixFQUFnQkEsSUFBSUosUUFBUUssTUFBNUIsRUFBb0NELEdBQXBDLEVBQXlDO0FBQ3ZDRixhQUFTRixRQUFRSSxDQUFSLENBQVQ7QUFDQSxRQUFJRixPQUFPSSxLQUFYLEVBQWtCO0FBQ2hCSCxrQkFBWSxDQUFaO0FBQ0QsS0FGRCxNQUVPLElBQUlELE9BQU9LLE9BQVgsRUFBb0I7QUFDekJKLGtCQUFZLENBQUMsQ0FBYjtBQUNELEtBRk0sTUFFQTtBQUNMQSxrQkFBWSxDQUFaO0FBQ0Q7O0FBRURGLFFBQUlPLElBQUosQ0FBUyxDQUFDTCxTQUFELEVBQVlELE9BQU9PLEtBQW5CLENBQVQ7QUFDRDtBQUNELFNBQU9SLEdBQVA7QUFDRCIsImZpbGUiOiJkbXAuanMiLCJzb3VyY2VzQ29udGVudCI6WyIvLyBTZWU6IGh0dHA6Ly9jb2RlLmdvb2dsZS5jb20vcC9nb29nbGUtZGlmZi1tYXRjaC1wYXRjaC93aWtpL0FQSVxuZXhwb3J0IGZ1bmN0aW9uIGNvbnZlcnRDaGFuZ2VzVG9ETVAoY2hhbmdlcykge1xuICBsZXQgcmV0ID0gW10sXG4gICAgICBjaGFuZ2UsXG4gICAgICBvcGVyYXRpb247XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgY2hhbmdlcy5sZW5ndGg7IGkrKykge1xuICAgIGNoYW5nZSA9IGNoYW5nZXNbaV07XG4gICAgaWYgKGNoYW5nZS5hZGRlZCkge1xuICAgICAgb3BlcmF0aW9uID0gMTtcbiAgICB9IGVsc2UgaWYgKGNoYW5nZS5yZW1vdmVkKSB7XG4gICAgICBvcGVyYXRpb24gPSAtMTtcbiAgICB9IGVsc2Uge1xuICAgICAgb3BlcmF0aW9uID0gMDtcbiAgICB9XG5cbiAgICByZXQucHVzaChbb3BlcmF0aW9uLCBjaGFuZ2UudmFsdWVdKTtcbiAgfVxuICByZXR1cm4gcmV0O1xufVxuIl19


/***/ }),
/* 17 */
/***/ (function(module, exports) {

	/*istanbul ignore start*/'use strict';

	exports.__esModule = true;
	exports. /*istanbul ignore end*/convertChangesToXML = convertChangesToXML;
	function convertChangesToXML(changes) {
	  var ret = [];
	  for (var i = 0; i < changes.length; i++) {
	    var change = changes[i];
	    if (change.added) {
	      ret.push('<ins>');
	    } else if (change.removed) {
	      ret.push('<del>');
	    }

	    ret.push(escapeHTML(change.value));

	    if (change.added) {
	      ret.push('</ins>');
	    } else if (change.removed) {
	      ret.push('</del>');
	    }
	  }
	  return ret.join('');
	}

	function escapeHTML(s) {
	  var n = s;
	  n = n.replace(/&/g, '&amp;');
	  n = n.replace(/</g, '&lt;');
	  n = n.replace(/>/g, '&gt;');
	  n = n.replace(/"/g, '&quot;');

	  return n;
	}
	

/***/ })
/******/ ])
});
;

/***/ }),

/***/ "../node_modules/lodash.throttle/index.js":
/*!************************************************!*\
  !*** ../node_modules/lodash.throttle/index.js ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

/**
 * lodash (Custom Build) <https://lodash.com/>
 * Build: `lodash modularize exports="npm" -o ./`
 * Copyright jQuery Foundation and other contributors <https://jquery.org/>
 * Released under MIT license <https://lodash.com/license>
 * Based on Underscore.js 1.8.3 <http://underscorejs.org/LICENSE>
 * Copyright Jeremy Ashkenas, DocumentCloud and Investigative Reporters & Editors
 */

/** Used as the `TypeError` message for "Functions" methods. */
var FUNC_ERROR_TEXT = 'Expected a function';

/** Used as references for various `Number` constants. */
var NAN = 0 / 0;

/** `Object#toString` result references. */
var symbolTag = '[object Symbol]';

/** Used to match leading and trailing whitespace. */
var reTrim = /^\s+|\s+$/g;

/** Used to detect bad signed hexadecimal string values. */
var reIsBadHex = /^[-+]0x[0-9a-f]+$/i;

/** Used to detect binary string values. */
var reIsBinary = /^0b[01]+$/i;

/** Used to detect octal string values. */
var reIsOctal = /^0o[0-7]+$/i;

/** Built-in method references without a dependency on `root`. */
var freeParseInt = parseInt;

/** Detect free variable `global` from Node.js. */
var freeGlobal = typeof global == 'object' && global && global.Object === Object && global;

/** Detect free variable `self`. */
var freeSelf = typeof self == 'object' && self && self.Object === Object && self;

/** Used as a reference to the global object. */
var root = freeGlobal || freeSelf || Function('return this')();

/** Used for built-in method references. */
var objectProto = Object.prototype;

/**
 * Used to resolve the
 * [`toStringTag`](http://ecma-international.org/ecma-262/7.0/#sec-object.prototype.tostring)
 * of values.
 */
var objectToString = objectProto.toString;

/* Built-in method references for those with the same name as other `lodash` methods. */
var nativeMax = Math.max,
    nativeMin = Math.min;

/**
 * Gets the timestamp of the number of milliseconds that have elapsed since
 * the Unix epoch (1 January 1970 00:00:00 UTC).
 *
 * @static
 * @memberOf _
 * @since 2.4.0
 * @category Date
 * @returns {number} Returns the timestamp.
 * @example
 *
 * _.defer(function(stamp) {
 *   console.log(_.now() - stamp);
 * }, _.now());
 * // => Logs the number of milliseconds it took for the deferred invocation.
 */
var now = function() {
  return root.Date.now();
};

/**
 * Creates a debounced function that delays invoking `func` until after `wait`
 * milliseconds have elapsed since the last time the debounced function was
 * invoked. The debounced function comes with a `cancel` method to cancel
 * delayed `func` invocations and a `flush` method to immediately invoke them.
 * Provide `options` to indicate whether `func` should be invoked on the
 * leading and/or trailing edge of the `wait` timeout. The `func` is invoked
 * with the last arguments provided to the debounced function. Subsequent
 * calls to the debounced function return the result of the last `func`
 * invocation.
 *
 * **Note:** If `leading` and `trailing` options are `true`, `func` is
 * invoked on the trailing edge of the timeout only if the debounced function
 * is invoked more than once during the `wait` timeout.
 *
 * If `wait` is `0` and `leading` is `false`, `func` invocation is deferred
 * until to the next tick, similar to `setTimeout` with a timeout of `0`.
 *
 * See [David Corbacho's article](https://css-tricks.com/debouncing-throttling-explained-examples/)
 * for details over the differences between `_.debounce` and `_.throttle`.
 *
 * @static
 * @memberOf _
 * @since 0.1.0
 * @category Function
 * @param {Function} func The function to debounce.
 * @param {number} [wait=0] The number of milliseconds to delay.
 * @param {Object} [options={}] The options object.
 * @param {boolean} [options.leading=false]
 *  Specify invoking on the leading edge of the timeout.
 * @param {number} [options.maxWait]
 *  The maximum time `func` is allowed to be delayed before it's invoked.
 * @param {boolean} [options.trailing=true]
 *  Specify invoking on the trailing edge of the timeout.
 * @returns {Function} Returns the new debounced function.
 * @example
 *
 * // Avoid costly calculations while the window size is in flux.
 * jQuery(window).on('resize', _.debounce(calculateLayout, 150));
 *
 * // Invoke `sendMail` when clicked, debouncing subsequent calls.
 * jQuery(element).on('click', _.debounce(sendMail, 300, {
 *   'leading': true,
 *   'trailing': false
 * }));
 *
 * // Ensure `batchLog` is invoked once after 1 second of debounced calls.
 * var debounced = _.debounce(batchLog, 250, { 'maxWait': 1000 });
 * var source = new EventSource('/stream');
 * jQuery(source).on('message', debounced);
 *
 * // Cancel the trailing debounced invocation.
 * jQuery(window).on('popstate', debounced.cancel);
 */
function debounce(func, wait, options) {
  var lastArgs,
      lastThis,
      maxWait,
      result,
      timerId,
      lastCallTime,
      lastInvokeTime = 0,
      leading = false,
      maxing = false,
      trailing = true;

  if (typeof func != 'function') {
    throw new TypeError(FUNC_ERROR_TEXT);
  }
  wait = toNumber(wait) || 0;
  if (isObject(options)) {
    leading = !!options.leading;
    maxing = 'maxWait' in options;
    maxWait = maxing ? nativeMax(toNumber(options.maxWait) || 0, wait) : maxWait;
    trailing = 'trailing' in options ? !!options.trailing : trailing;
  }

  function invokeFunc(time) {
    var args = lastArgs,
        thisArg = lastThis;

    lastArgs = lastThis = undefined;
    lastInvokeTime = time;
    result = func.apply(thisArg, args);
    return result;
  }

  function leadingEdge(time) {
    // Reset any `maxWait` timer.
    lastInvokeTime = time;
    // Start the timer for the trailing edge.
    timerId = setTimeout(timerExpired, wait);
    // Invoke the leading edge.
    return leading ? invokeFunc(time) : result;
  }

  function remainingWait(time) {
    var timeSinceLastCall = time - lastCallTime,
        timeSinceLastInvoke = time - lastInvokeTime,
        result = wait - timeSinceLastCall;

    return maxing ? nativeMin(result, maxWait - timeSinceLastInvoke) : result;
  }

  function shouldInvoke(time) {
    var timeSinceLastCall = time - lastCallTime,
        timeSinceLastInvoke = time - lastInvokeTime;

    // Either this is the first call, activity has stopped and we're at the
    // trailing edge, the system time has gone backwards and we're treating
    // it as the trailing edge, or we've hit the `maxWait` limit.
    return (lastCallTime === undefined || (timeSinceLastCall >= wait) ||
      (timeSinceLastCall < 0) || (maxing && timeSinceLastInvoke >= maxWait));
  }

  function timerExpired() {
    var time = now();
    if (shouldInvoke(time)) {
      return trailingEdge(time);
    }
    // Restart the timer.
    timerId = setTimeout(timerExpired, remainingWait(time));
  }

  function trailingEdge(time) {
    timerId = undefined;

    // Only invoke if we have `lastArgs` which means `func` has been
    // debounced at least once.
    if (trailing && lastArgs) {
      return invokeFunc(time);
    }
    lastArgs = lastThis = undefined;
    return result;
  }

  function cancel() {
    if (timerId !== undefined) {
      clearTimeout(timerId);
    }
    lastInvokeTime = 0;
    lastArgs = lastCallTime = lastThis = timerId = undefined;
  }

  function flush() {
    return timerId === undefined ? result : trailingEdge(now());
  }

  function debounced() {
    var time = now(),
        isInvoking = shouldInvoke(time);

    lastArgs = arguments;
    lastThis = this;
    lastCallTime = time;

    if (isInvoking) {
      if (timerId === undefined) {
        return leadingEdge(lastCallTime);
      }
      if (maxing) {
        // Handle invocations in a tight loop.
        timerId = setTimeout(timerExpired, wait);
        return invokeFunc(lastCallTime);
      }
    }
    if (timerId === undefined) {
      timerId = setTimeout(timerExpired, wait);
    }
    return result;
  }
  debounced.cancel = cancel;
  debounced.flush = flush;
  return debounced;
}

/**
 * Creates a throttled function that only invokes `func` at most once per
 * every `wait` milliseconds. The throttled function comes with a `cancel`
 * method to cancel delayed `func` invocations and a `flush` method to
 * immediately invoke them. Provide `options` to indicate whether `func`
 * should be invoked on the leading and/or trailing edge of the `wait`
 * timeout. The `func` is invoked with the last arguments provided to the
 * throttled function. Subsequent calls to the throttled function return the
 * result of the last `func` invocation.
 *
 * **Note:** If `leading` and `trailing` options are `true`, `func` is
 * invoked on the trailing edge of the timeout only if the throttled function
 * is invoked more than once during the `wait` timeout.
 *
 * If `wait` is `0` and `leading` is `false`, `func` invocation is deferred
 * until to the next tick, similar to `setTimeout` with a timeout of `0`.
 *
 * See [David Corbacho's article](https://css-tricks.com/debouncing-throttling-explained-examples/)
 * for details over the differences between `_.throttle` and `_.debounce`.
 *
 * @static
 * @memberOf _
 * @since 0.1.0
 * @category Function
 * @param {Function} func The function to throttle.
 * @param {number} [wait=0] The number of milliseconds to throttle invocations to.
 * @param {Object} [options={}] The options object.
 * @param {boolean} [options.leading=true]
 *  Specify invoking on the leading edge of the timeout.
 * @param {boolean} [options.trailing=true]
 *  Specify invoking on the trailing edge of the timeout.
 * @returns {Function} Returns the new throttled function.
 * @example
 *
 * // Avoid excessively updating the position while scrolling.
 * jQuery(window).on('scroll', _.throttle(updatePosition, 100));
 *
 * // Invoke `renewToken` when the click event is fired, but not more than once every 5 minutes.
 * var throttled = _.throttle(renewToken, 300000, { 'trailing': false });
 * jQuery(element).on('click', throttled);
 *
 * // Cancel the trailing throttled invocation.
 * jQuery(window).on('popstate', throttled.cancel);
 */
function throttle(func, wait, options) {
  var leading = true,
      trailing = true;

  if (typeof func != 'function') {
    throw new TypeError(FUNC_ERROR_TEXT);
  }
  if (isObject(options)) {
    leading = 'leading' in options ? !!options.leading : leading;
    trailing = 'trailing' in options ? !!options.trailing : trailing;
  }
  return debounce(func, wait, {
    'leading': leading,
    'maxWait': wait,
    'trailing': trailing
  });
}

/**
 * Checks if `value` is the
 * [language type](http://www.ecma-international.org/ecma-262/7.0/#sec-ecmascript-language-types)
 * of `Object`. (e.g. arrays, functions, objects, regexes, `new Number(0)`, and `new String('')`)
 *
 * @static
 * @memberOf _
 * @since 0.1.0
 * @category Lang
 * @param {*} value The value to check.
 * @returns {boolean} Returns `true` if `value` is an object, else `false`.
 * @example
 *
 * _.isObject({});
 * // => true
 *
 * _.isObject([1, 2, 3]);
 * // => true
 *
 * _.isObject(_.noop);
 * // => true
 *
 * _.isObject(null);
 * // => false
 */
function isObject(value) {
  var type = typeof value;
  return !!value && (type == 'object' || type == 'function');
}

/**
 * Checks if `value` is object-like. A value is object-like if it's not `null`
 * and has a `typeof` result of "object".
 *
 * @static
 * @memberOf _
 * @since 4.0.0
 * @category Lang
 * @param {*} value The value to check.
 * @returns {boolean} Returns `true` if `value` is object-like, else `false`.
 * @example
 *
 * _.isObjectLike({});
 * // => true
 *
 * _.isObjectLike([1, 2, 3]);
 * // => true
 *
 * _.isObjectLike(_.noop);
 * // => false
 *
 * _.isObjectLike(null);
 * // => false
 */
function isObjectLike(value) {
  return !!value && typeof value == 'object';
}

/**
 * Checks if `value` is classified as a `Symbol` primitive or object.
 *
 * @static
 * @memberOf _
 * @since 4.0.0
 * @category Lang
 * @param {*} value The value to check.
 * @returns {boolean} Returns `true` if `value` is a symbol, else `false`.
 * @example
 *
 * _.isSymbol(Symbol.iterator);
 * // => true
 *
 * _.isSymbol('abc');
 * // => false
 */
function isSymbol(value) {
  return typeof value == 'symbol' ||
    (isObjectLike(value) && objectToString.call(value) == symbolTag);
}

/**
 * Converts `value` to a number.
 *
 * @static
 * @memberOf _
 * @since 4.0.0
 * @category Lang
 * @param {*} value The value to process.
 * @returns {number} Returns the number.
 * @example
 *
 * _.toNumber(3.2);
 * // => 3.2
 *
 * _.toNumber(Number.MIN_VALUE);
 * // => 5e-324
 *
 * _.toNumber(Infinity);
 * // => Infinity
 *
 * _.toNumber('3.2');
 * // => 3.2
 */
function toNumber(value) {
  if (typeof value == 'number') {
    return value;
  }
  if (isSymbol(value)) {
    return NAN;
  }
  if (isObject(value)) {
    var other = typeof value.valueOf == 'function' ? value.valueOf() : value;
    value = isObject(other) ? (other + '') : other;
  }
  if (typeof value != 'string') {
    return value === 0 ? value : +value;
  }
  value = value.replace(reTrim, '');
  var isBinary = reIsBinary.test(value);
  return (isBinary || reIsOctal.test(value))
    ? freeParseInt(value.slice(2), isBinary ? 2 : 8)
    : (reIsBadHex.test(value) ? NAN : +value);
}

module.exports = throttle;


/***/ }),

/***/ "../node_modules/octicons/build/svg/git-commit.svg":
/*!*********************************************************!*\
  !*** ../node_modules/octicons/build/svg/git-commit.svg ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNCIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDE0IDE2Ij48cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0xMC44NiA3Yy0uNDUtMS43Mi0yLTMtMy44Ni0zLTEuODYgMC0zLjQxIDEuMjgtMy44NiAzSDB2MmgzLjE0Yy40NSAxLjcyIDIgMyAzLjg2IDMgMS44NiAwIDMuNDEtMS4yOCAzLjg2LTNIMTRWN2gtMy4xNHpNNyAxMC4yYy0xLjIyIDAtMi4yLS45OC0yLjItMi4yIDAtMS4yMi45OC0yLjIgMi4yLTIuMiAxLjIyIDAgMi4yLjk4IDIuMiAyLjIgMCAxLjIyLS45OCAyLjItMi4yIDIuMnoiLz48L3N2Zz4="

/***/ })

}]);
//# sourceMappingURL=25.bundle.js.map