(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[41],{

/***/ "../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-frontend-contribution.js":
/*!*******************************************************************************************************!*\
  !*** ../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-frontend-contribution.js ***!
  \*******************************************************************************************************/
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
var common_1 = __webpack_require__(/*! @theia/core/lib/common */ "../node_modules/@theia/core/lib/common/index.js");
var variable_1 = __webpack_require__(/*! ./variable */ "../node_modules/@theia/variable-resolver/lib/browser/variable.js");
var variable_quick_open_service_1 = __webpack_require__(/*! ./variable-quick-open-service */ "../node_modules/@theia/variable-resolver/lib/browser/variable-quick-open-service.js");
exports.LIST_VARIABLES = {
    id: 'variable.list',
    label: 'Variable: List All'
};
var VariableResolverFrontendContribution = /** @class */ (function () {
    function VariableResolverFrontendContribution(contributionProvider, variableRegistry, variableQuickOpenService) {
        this.contributionProvider = contributionProvider;
        this.variableRegistry = variableRegistry;
        this.variableQuickOpenService = variableQuickOpenService;
    }
    VariableResolverFrontendContribution.prototype.onStart = function () {
        var _this = this;
        this.contributionProvider.getContributions().forEach(function (contrib) {
            return contrib.registerVariables(_this.variableRegistry);
        });
    };
    VariableResolverFrontendContribution.prototype.registerCommands = function (commands) {
        var _this = this;
        commands.registerCommand(exports.LIST_VARIABLES, {
            isEnabled: function () { return true; },
            execute: function () { return _this.variableQuickOpenService.open(); }
        });
    };
    VariableResolverFrontendContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.ContributionProvider)), __param(0, inversify_1.named(variable_1.VariableContribution)),
        __param(1, inversify_1.inject(variable_1.VariableRegistry)),
        __param(2, inversify_1.inject(variable_quick_open_service_1.VariableQuickOpenService)),
        __metadata("design:paramtypes", [Object, variable_1.VariableRegistry,
            variable_quick_open_service_1.VariableQuickOpenService])
    ], VariableResolverFrontendContribution);
    return VariableResolverFrontendContribution;
}());
exports.VariableResolverFrontendContribution = VariableResolverFrontendContribution;


/***/ }),

/***/ "../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-frontend-module.js":
/*!*************************************************************************************************!*\
  !*** ../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-frontend-module.js ***!
  \*************************************************************************************************/
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
var core_1 = __webpack_require__(/*! @theia/core */ "../node_modules/@theia/core/lib/common/index.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var variable_1 = __webpack_require__(/*! ./variable */ "../node_modules/@theia/variable-resolver/lib/browser/variable.js");
var variable_quick_open_service_1 = __webpack_require__(/*! ./variable-quick-open-service */ "../node_modules/@theia/variable-resolver/lib/browser/variable-quick-open-service.js");
var variable_resolver_frontend_contribution_1 = __webpack_require__(/*! ./variable-resolver-frontend-contribution */ "../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-frontend-contribution.js");
var variable_resolver_service_1 = __webpack_require__(/*! ./variable-resolver-service */ "../node_modules/@theia/variable-resolver/lib/browser/variable-resolver-service.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    var e_1, _a;
    bind(variable_1.VariableRegistry).toSelf().inSingletonScope();
    bind(variable_resolver_service_1.VariableResolverService).toSelf().inSingletonScope();
    core_1.bindContributionProvider(bind, variable_1.VariableContribution);
    bind(variable_resolver_frontend_contribution_1.VariableResolverFrontendContribution).toSelf().inSingletonScope();
    try {
        for (var _b = __values([browser_1.FrontendApplicationContribution, core_1.CommandContribution]), _c = _b.next(); !_c.done; _c = _b.next()) {
            var identifier = _c.value;
            bind(identifier).toService(variable_resolver_frontend_contribution_1.VariableResolverFrontendContribution);
        }
    }
    catch (e_1_1) { e_1 = { error: e_1_1 }; }
    finally {
        try {
            if (_c && !_c.done && (_a = _b.return)) _a.call(_b);
        }
        finally { if (e_1) throw e_1.error; }
    }
    bind(variable_quick_open_service_1.VariableQuickOpenService).toSelf().inSingletonScope();
});


/***/ })

}]);
//# sourceMappingURL=41.bundle.js.map