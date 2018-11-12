(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[37],{

/***/ "../node_modules/@theia/core/lib/browser/window/window-service.js":
/*!************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/browser/window/window-service.js ***!
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
/**
 * Service for opening new browser windows.
 */
exports.WindowService = Symbol('WindowService');
var DefaultWindowService = /** @class */ (function () {
    function DefaultWindowService() {
    }
    DefaultWindowService.prototype.openNewWindow = function (url) {
        var newWindow = window.open(url);
        if (newWindow === null) {
            throw new Error('Cannot open a new window for URL: ' + url);
        }
    };
    DefaultWindowService = __decorate([
        inversify_1.injectable()
    ], DefaultWindowService);
    return DefaultWindowService;
}());
exports.DefaultWindowService = DefaultWindowService;


/***/ }),

/***/ "../node_modules/@theia/core/lib/electron-browser/window/electron-window-module.js":
/*!*****************************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/electron-browser/window/electron-window-module.js ***!
  \*****************************************************************************************/
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
var window_service_1 = __webpack_require__(/*! ../../browser/window/window-service */ "../node_modules/@theia/core/lib/browser/window/window-service.js");
var electron_window_service_1 = __webpack_require__(/*! ./electron-window-service */ "../node_modules/@theia/core/lib/electron-browser/window/electron-window-service.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(window_service_1.WindowService).to(electron_window_service_1.ElectronWindowService).inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/core/lib/electron-browser/window/electron-window-service.js":
/*!******************************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/electron-browser/window/electron-window-service.js ***!
  \******************************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var electron_1 = __webpack_require__(/*! electron */ "electron");
var window_service_1 = __webpack_require__(/*! ../../browser/window/window-service */ "../node_modules/@theia/core/lib/browser/window/window-service.js");
var ElectronWindowService = /** @class */ (function (_super) {
    __extends(ElectronWindowService, _super);
    function ElectronWindowService() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ElectronWindowService.prototype.openNewWindow = function (url) {
        electron_1.ipcRenderer.send('create-new-window', url);
    };
    ElectronWindowService = __decorate([
        inversify_1.injectable()
    ], ElectronWindowService);
    return ElectronWindowService;
}(window_service_1.DefaultWindowService));
exports.ElectronWindowService = ElectronWindowService;


/***/ })

}]);
//# sourceMappingURL=37.bundle.js.map