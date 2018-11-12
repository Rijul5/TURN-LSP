(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[4],{

/***/ "../node_modules/@theia/variable-resolver/lib/browser/variable-quick-open-service.js":
/*!*******************************************************************************************!*\
  !*** ../node_modules/@theia/variable-resolver/lib/browser/variable-quick-open-service.js ***!
  \*******************************************************************************************/
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
var quick_open_1 = __webpack_require__(/*! @theia/core/lib/browser/quick-open/ */ "../node_modules/@theia/core/lib/browser/quick-open/index.js");
var variable_1 = __webpack_require__(/*! ./variable */ "../node_modules/@theia/variable-resolver/lib/browser/variable.js");
var VariableQuickOpenService = /** @class */ (function () {
    function VariableQuickOpenService(variableRegistry, quickOpenService) {
        this.variableRegistry = variableRegistry;
        this.quickOpenService = quickOpenService;
    }
    VariableQuickOpenService.prototype.open = function () {
        this.items = this.variableRegistry.getVariables().map(function (v) { return new VariableQuickOpenItem(v.name, v.description); });
        this.quickOpenService.open(this, {
            placeholder: 'Registered variables',
            fuzzyMatchLabel: true,
            fuzzyMatchDescription: true,
            fuzzySort: true
        });
    };
    VariableQuickOpenService.prototype.onType = function (lookFor, acceptor) {
        acceptor(this.items);
    };
    VariableQuickOpenService = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(variable_1.VariableRegistry)),
        __param(1, inversify_1.inject(quick_open_1.QuickOpenService)),
        __metadata("design:paramtypes", [variable_1.VariableRegistry,
            quick_open_1.QuickOpenService])
    ], VariableQuickOpenService);
    return VariableQuickOpenService;
}());
exports.VariableQuickOpenService = VariableQuickOpenService;
var VariableQuickOpenItem = /** @class */ (function (_super) {
    __extends(VariableQuickOpenItem, _super);
    function VariableQuickOpenItem(name, description) {
        var _this = _super.call(this) || this;
        _this.name = name;
        _this.description = description;
        return _this;
    }
    VariableQuickOpenItem.prototype.getLabel = function () {
        return '${' + this.name + '}';
    };
    VariableQuickOpenItem.prototype.getDetail = function () {
        return this.description || '';
    };
    VariableQuickOpenItem.prototype.run = function (mode) {
        return false;
    };
    return VariableQuickOpenItem;
}(quick_open_1.QuickOpenItem));
exports.VariableQuickOpenItem = VariableQuickOpenItem;


/***/ }),

/***/ "../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-service.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-service.js ***!
  \*****************************************************************************************/
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
var variable_1 = __webpack_require__(/*! ./variable */ "../node_modules/@theia/variable-resolver/lib/browser/variable.js");
/**
 * The variable resolver service should be used to resolve variables in strings.
 */
var VariableResolverService = /** @class */ (function () {
    function VariableResolverService() {
    }
    VariableResolverService_1 = VariableResolverService;
    /**
     * Resolve the variables in the given string array.
     * @returns promise resolved to the provided string array with already resolved variables.
     * Never reject.
     */
    VariableResolverService.prototype.resolveArray = function (value) {
        return this.resolve(value);
    };
    /**
     * Resolve the variables in the given string.
     * @returns promise resolved to the provided string with already resolved variables.
     * Never reject.
     */
    VariableResolverService.prototype.resolve = function (value) {
        return __awaiter(this, void 0, void 0, function () {
            var context, resolved;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        context = new VariableResolverService_1.Context(this.variableRegistry);
                        return [4 /*yield*/, this.doResolve(value, context)];
                    case 1:
                        resolved = _a.sent();
                        return [2 /*return*/, resolved];
                }
            });
        });
    };
    VariableResolverService.prototype.doResolve = function (value, context) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                if (value === undefined || value === null) {
                    return [2 /*return*/, value];
                }
                if (typeof value === 'string') {
                    return [2 /*return*/, this.doResolveString(value, context)];
                }
                if (Array.isArray(value)) {
                    return [2 /*return*/, this.doResolveArray(value, context)];
                }
                if (typeof value === 'object') {
                    return [2 /*return*/, this.doResolveObject(value, context)];
                }
                return [2 /*return*/, value];
            });
        });
    };
    VariableResolverService.prototype.doResolveObject = function (obj, context) {
        return __awaiter(this, void 0, void 0, function () {
            var e_1, _a, result, _b, _c, name_1, value, resolved, e_1_1;
            return __generator(this, function (_d) {
                switch (_d.label) {
                    case 0:
                        result = {};
                        _d.label = 1;
                    case 1:
                        _d.trys.push([1, 6, 7, 8]);
                        _b = __values(Object.keys(obj)), _c = _b.next();
                        _d.label = 2;
                    case 2:
                        if (!!_c.done) return [3 /*break*/, 5];
                        name_1 = _c.value;
                        value = obj[name_1];
                        return [4 /*yield*/, this.doResolve(value, context)];
                    case 3:
                        resolved = _d.sent();
                        result[name_1] = resolved;
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
                    case 8: return [2 /*return*/, result];
                }
            });
        });
    };
    VariableResolverService.prototype.doResolveArray = function (values, context) {
        return __awaiter(this, void 0, void 0, function () {
            var e_2, _a, result, values_1, values_1_1, value, resolved, e_2_1;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0:
                        result = [];
                        _b.label = 1;
                    case 1:
                        _b.trys.push([1, 6, 7, 8]);
                        values_1 = __values(values), values_1_1 = values_1.next();
                        _b.label = 2;
                    case 2:
                        if (!!values_1_1.done) return [3 /*break*/, 5];
                        value = values_1_1.value;
                        return [4 /*yield*/, this.doResolve(value, context)];
                    case 3:
                        resolved = _b.sent();
                        result.push(resolved);
                        _b.label = 4;
                    case 4:
                        values_1_1 = values_1.next();
                        return [3 /*break*/, 2];
                    case 5: return [3 /*break*/, 8];
                    case 6:
                        e_2_1 = _b.sent();
                        e_2 = { error: e_2_1 };
                        return [3 /*break*/, 8];
                    case 7:
                        try {
                            if (values_1_1 && !values_1_1.done && (_a = values_1.return)) _a.call(values_1);
                        }
                        finally { if (e_2) throw e_2.error; }
                        return [7 /*endfinally*/];
                    case 8: return [2 /*return*/, result];
                }
            });
        });
    };
    VariableResolverService.prototype.doResolveString = function (value, context) {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.resolveVariables(value, context)];
                    case 1:
                        _a.sent();
                        return [2 /*return*/, value.replace(VariableResolverService_1.VAR_REGEXP, function (match, varName) {
                                var varValue = context.get(varName);
                                return varValue !== undefined ? varValue : match;
                            })];
                }
            });
        });
    };
    VariableResolverService.prototype.resolveVariables = function (value, context) {
        return __awaiter(this, void 0, void 0, function () {
            var match, variableName;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!((match = VariableResolverService_1.VAR_REGEXP.exec(value)) !== null)) return [3 /*break*/, 2];
                        variableName = match[1];
                        return [4 /*yield*/, context.resolve(variableName)];
                    case 1:
                        _a.sent();
                        return [3 /*break*/, 0];
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    var VariableResolverService_1;
    VariableResolverService.VAR_REGEXP = /\$\{(.*?)\}/g;
    __decorate([
        inversify_1.inject(variable_1.VariableRegistry),
        __metadata("design:type", variable_1.VariableRegistry)
    ], VariableResolverService.prototype, "variableRegistry", void 0);
    VariableResolverService = VariableResolverService_1 = __decorate([
        inversify_1.injectable()
    ], VariableResolverService);
    return VariableResolverService;
}());
exports.VariableResolverService = VariableResolverService;
(function (VariableResolverService) {
    var Context = /** @class */ (function () {
        function Context(variableRegistry) {
            this.variableRegistry = variableRegistry;
            this.resolved = new Map();
        }
        Context.prototype.get = function (name) {
            return this.resolved.get(name);
        };
        Context.prototype.resolve = function (name) {
            return __awaiter(this, void 0, void 0, function () {
                var variable, value, _a, e_3;
                return __generator(this, function (_b) {
                    switch (_b.label) {
                        case 0:
                            if (this.resolved.has(name)) {
                                return [2 /*return*/];
                            }
                            _b.label = 1;
                        case 1:
                            _b.trys.push([1, 4, , 5]);
                            variable = this.variableRegistry.getVariable(name);
                            _a = variable;
                            if (!_a) return [3 /*break*/, 3];
                            return [4 /*yield*/, variable.resolve()];
                        case 2:
                            _a = (_b.sent());
                            _b.label = 3;
                        case 3:
                            value = _a;
                            this.resolved.set(name, value);
                            return [3 /*break*/, 5];
                        case 4:
                            e_3 = _b.sent();
                            console.error("Failed to resolved '" + name + "' variable", e_3);
                            this.resolved.set(name, undefined);
                            return [3 /*break*/, 5];
                        case 5: return [2 /*return*/];
                    }
                });
            });
        };
        return Context;
    }());
    VariableResolverService.Context = Context;
})(VariableResolverService = exports.VariableResolverService || (exports.VariableResolverService = {}));
exports.VariableResolverService = VariableResolverService;


/***/ }),

/***/ "../node_modules/@theia/variable-resolver/lib/browser/variable.js":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/variable-resolver/lib/browser/variable.js ***!
  \************************************************************************/
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
exports.VariableContribution = Symbol('VariableContribution');
/**
 * The variable registry manages variables.
 */
var VariableRegistry = /** @class */ (function () {
    function VariableRegistry(logger) {
        this.logger = logger;
        this.variables = new Map();
        this.toDispose = new core_1.DisposableCollection();
    }
    VariableRegistry.prototype.dispose = function () {
        this.toDispose.dispose();
    };
    /**
     * Register the given variable.
     * Do nothing if a variable is already registered for the given variable name.
     */
    VariableRegistry.prototype.registerVariable = function (variable) {
        var _this = this;
        if (this.variables.has(variable.name)) {
            this.logger.warn("A variables with name " + variable.name + " is already registered.");
            return core_1.Disposable.NULL;
        }
        this.variables.set(variable.name, variable);
        var disposable = {
            dispose: function () { return _this.variables.delete(variable.name); }
        };
        this.toDispose.push(disposable);
        return disposable;
    };
    /**
     * Return all registered variables.
     */
    VariableRegistry.prototype.getVariables = function () {
        return __spread(this.variables.values());
    };
    /**
     * Get a variable for the given name or `undefined` if none.
     */
    VariableRegistry.prototype.getVariable = function (name) {
        return this.variables.get(name);
    };
    VariableRegistry = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(core_1.ILogger)),
        __metadata("design:paramtypes", [Object])
    ], VariableRegistry);
    return VariableRegistry;
}());
exports.VariableRegistry = VariableRegistry;


/***/ })

}]);
//# sourceMappingURL=4.bundle.js.map