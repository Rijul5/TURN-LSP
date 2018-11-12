(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[52],{

/***/ "../node_modules/@theia/output/lib/browser/output-frontend-module.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/output/lib/browser/output-frontend-module.js ***!
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
var output_widget_1 = __webpack_require__(/*! ./output-widget */ "../node_modules/@theia/output/lib/browser/output-widget.js");
var browser_1 = __webpack_require__(/*! @theia/core/lib/browser */ "../node_modules/@theia/core/lib/browser/index.js");
var output_contribution_1 = __webpack_require__(/*! ./output-contribution */ "../node_modules/@theia/output/lib/browser/output-contribution.js");
var output_channel_1 = __webpack_require__(/*! ../common/output-channel */ "../node_modules/@theia/output/lib/common/output-channel.js");
var output_preferences_1 = __webpack_require__(/*! ../common/output-preferences */ "../node_modules/@theia/output/lib/common/output-preferences.js");
exports.default = new inversify_1.ContainerModule(function (bind, unbind, isBound, rebind) {
    output_preferences_1.bindOutputPreferences(bind);
    bind(output_widget_1.OutputWidget).toSelf();
    bind(output_channel_1.OutputChannelManager).toSelf().inSingletonScope();
    bind(browser_1.WidgetFactory).toDynamicValue(function (context) { return ({
        id: output_widget_1.OUTPUT_WIDGET_KIND,
        createWidget: function () { return context.container.get(output_widget_1.OutputWidget); }
    }); });
    browser_1.bindViewContribution(bind, output_contribution_1.OutputContribution);
});


/***/ })

}]);
//# sourceMappingURL=52.bundle.js.map