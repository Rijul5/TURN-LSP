(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[36],{

/***/ "../node_modules/@theia/core/lib/browser/menu/browser-context-menu-renderer.js":
/*!*************************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/browser/menu/browser-context-menu-renderer.js ***!
  \*************************************************************************************/
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
var browser_menu_plugin_1 = __webpack_require__(/*! ./browser-menu-plugin */ "../node_modules/@theia/core/lib/browser/menu/browser-menu-plugin.js");
var BrowserContextMenuRenderer = /** @class */ (function () {
    function BrowserContextMenuRenderer(menuFactory) {
        this.menuFactory = menuFactory;
    }
    BrowserContextMenuRenderer.prototype.render = function (menuPath, anchor, onHide) {
        var contextMenu = this.menuFactory.createContextMenu(menuPath);
        var _a = anchor instanceof MouseEvent ? { x: anchor.clientX, y: anchor.clientY } : anchor, x = _a.x, y = _a.y;
        if (onHide) {
            contextMenu.aboutToClose.connect(function () { return onHide(); });
        }
        contextMenu.open(x, y);
    };
    BrowserContextMenuRenderer = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(browser_menu_plugin_1.BrowserMainMenuFactory)),
        __metadata("design:paramtypes", [browser_menu_plugin_1.BrowserMainMenuFactory])
    ], BrowserContextMenuRenderer);
    return BrowserContextMenuRenderer;
}());
exports.BrowserContextMenuRenderer = BrowserContextMenuRenderer;


/***/ }),

/***/ "../node_modules/@theia/core/lib/browser/menu/browser-menu-module.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/browser/menu/browser-menu-module.js ***!
  \***************************************************************************/
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
var frontend_application_1 = __webpack_require__(/*! ../frontend-application */ "../node_modules/@theia/core/lib/browser/frontend-application.js");
var context_menu_renderer_1 = __webpack_require__(/*! ../context-menu-renderer */ "../node_modules/@theia/core/lib/browser/context-menu-renderer.js");
var browser_menu_plugin_1 = __webpack_require__(/*! ./browser-menu-plugin */ "../node_modules/@theia/core/lib/browser/menu/browser-menu-plugin.js");
var browser_context_menu_renderer_1 = __webpack_require__(/*! ./browser-context-menu-renderer */ "../node_modules/@theia/core/lib/browser/menu/browser-context-menu-renderer.js");
exports.default = new inversify_1.ContainerModule(function (bind) {
    bind(browser_menu_plugin_1.BrowserMainMenuFactory).toSelf().inSingletonScope();
    bind(context_menu_renderer_1.ContextMenuRenderer).to(browser_context_menu_renderer_1.BrowserContextMenuRenderer).inSingletonScope();
    bind(frontend_application_1.FrontendApplicationContribution).to(browser_menu_plugin_1.BrowserMenuBarContribution).inSingletonScope();
});


/***/ }),

/***/ "../node_modules/@theia/core/lib/browser/menu/browser-menu-plugin.js":
/*!***************************************************************************!*\
  !*** ../node_modules/@theia/core/lib/browser/menu/browser-menu-plugin.js ***!
  \***************************************************************************/
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
Object.defineProperty(exports, "__esModule", { value: true });
var inversify_1 = __webpack_require__(/*! inversify */ "../node_modules/inversify/lib/inversify.js");
var widgets_1 = __webpack_require__(/*! @phosphor/widgets */ "../node_modules/@phosphor/widgets/lib/index.js");
var commands_1 = __webpack_require__(/*! @phosphor/commands */ "../node_modules/@phosphor/commands/lib/index.js");
var common_1 = __webpack_require__(/*! ../../common */ "../node_modules/@theia/core/lib/common/index.js");
var keybinding_1 = __webpack_require__(/*! ../keybinding */ "../node_modules/@theia/core/lib/browser/keybinding.js");
var BrowserMainMenuFactory = /** @class */ (function () {
    function BrowserMainMenuFactory(commandRegistry, keybindingRegistry, menuProvider) {
        this.commandRegistry = commandRegistry;
        this.keybindingRegistry = keybindingRegistry;
        this.menuProvider = menuProvider;
    }
    BrowserMainMenuFactory.prototype.createMenuBar = function () {
        var e_1, _a;
        var menuBar = new DynamicMenuBarWidget();
        menuBar.id = 'theia:menubar';
        var menuModel = this.menuProvider.getMenu(common_1.MAIN_MENU_BAR);
        var phosphorCommands = this.createPhosporCommands(menuModel);
        // for the main menu we want all items to be visible.
        phosphorCommands.isVisible = function () { return true; };
        try {
            for (var _b = __values(menuModel.children), _c = _b.next(); !_c.done; _c = _b.next()) {
                var menu = _c.value;
                if (menu instanceof common_1.CompositeMenuNode) {
                    var menuWidget = new DynamicMenuWidget(menu, { commands: phosphorCommands });
                    menuBar.addMenu(menuWidget);
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
        return menuBar;
    };
    BrowserMainMenuFactory.prototype.createContextMenu = function (path) {
        var menuModel = this.menuProvider.getMenu(path);
        var phosphorCommands = this.createPhosporCommands(menuModel);
        var contextMenu = new DynamicMenuWidget(menuModel, { commands: phosphorCommands });
        return contextMenu;
    };
    BrowserMainMenuFactory.prototype.createPhosporCommands = function (menu) {
        var commands = new commands_1.CommandRegistry();
        this.addPhosphorCommands(commands, menu);
        return commands;
    };
    BrowserMainMenuFactory.prototype.addPhosphorCommands = function (commands, menu) {
        var e_2, _a;
        try {
            for (var _b = __values(menu.children), _c = _b.next(); !_c.done; _c = _b.next()) {
                var child = _c.value;
                if (child instanceof common_1.ActionMenuNode) {
                    this.addPhosphorCommand(commands, child);
                }
                else if (child instanceof common_1.CompositeMenuNode) {
                    this.addPhosphorCommands(commands, child);
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
    };
    BrowserMainMenuFactory.prototype.addPhosphorCommand = function (commands, menu) {
        var _this = this;
        var command = this.commandRegistry.getCommand(menu.action.commandId);
        if (!command) {
            return;
        }
        commands.addCommand(command.id, {
            execute: function () { return _this.commandRegistry.executeCommand(command.id); },
            label: menu.label,
            icon: menu.icon,
            isEnabled: function () { return _this.commandRegistry.isEnabled(command.id); },
            isVisible: function () { return _this.commandRegistry.isVisible(command.id); },
            isToggled: function () { return _this.commandRegistry.isToggled(command.id); }
        });
        var bindings = this.keybindingRegistry.getKeybindingsForCommand(command.id);
        /* Only consider the first keybinding. */
        if (bindings.length > 0) {
            var binding = bindings[0];
            var keys = keybinding_1.Keybinding.acceleratorFor(binding);
            commands.addKeyBinding({
                command: command.id,
                keys: keys,
                selector: '.p-Widget' // We have the Phosphor.JS dependency anyway.
            });
        }
    };
    BrowserMainMenuFactory = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(common_1.CommandRegistry)),
        __param(1, inversify_1.inject(keybinding_1.KeybindingRegistry)),
        __param(2, inversify_1.inject(common_1.MenuModelRegistry)),
        __metadata("design:paramtypes", [common_1.CommandRegistry,
            keybinding_1.KeybindingRegistry,
            common_1.MenuModelRegistry])
    ], BrowserMainMenuFactory);
    return BrowserMainMenuFactory;
}());
exports.BrowserMainMenuFactory = BrowserMainMenuFactory;
var DynamicMenuBarWidget = /** @class */ (function (_super) {
    __extends(DynamicMenuBarWidget, _super);
    function DynamicMenuBarWidget() {
        var _this = _super.call(this) || this;
        // HACK we need to hook in on private method _openChildMenu. Don't do this at home!
        DynamicMenuBarWidget.prototype['_openChildMenu'] = function () {
            if (_this.activeMenu instanceof DynamicMenuWidget) {
                _this.activeMenu.aboutToShow();
            }
            _super.prototype['_openChildMenu'].call(_this);
        };
        return _this;
    }
    return DynamicMenuBarWidget;
}(widgets_1.MenuBar));
/**
 * A menu widget that would recompute its items on update
 */
var DynamicMenuWidget = /** @class */ (function (_super) {
    __extends(DynamicMenuWidget, _super);
    function DynamicMenuWidget(menu, options) {
        var _this = _super.call(this, options) || this;
        _this.menu = menu;
        _this.options = options;
        if (menu.label) {
            _this.title.label = menu.label;
        }
        _this.updateSubMenus(_this, _this.menu, _this.options.commands);
        return _this;
    }
    DynamicMenuWidget.prototype.aboutToShow = function () {
        this.clearItems();
        this.updateSubMenus(this, this.menu, this.options.commands);
    };
    DynamicMenuWidget.prototype.open = function (x, y, options) {
        var _this = this;
        // we want to restore the focus after the menu closes.
        var previouslyActive = window.document.activeElement;
        var cb = function () {
            previouslyActive.focus();
            _this.aboutToClose.disconnect(cb);
        };
        this.aboutToClose.connect(cb);
        _super.prototype.open.call(this, x, y, options);
    };
    DynamicMenuWidget.prototype.updateSubMenus = function (parent, menu, commands) {
        var e_3, _a;
        try {
            for (var _b = __values(menu.children), _c = _b.next(); !_c.done; _c = _b.next()) {
                var item = _c.value;
                if (item instanceof common_1.CompositeMenuNode) {
                    if (item.label && item.children.length > 0) {
                        parent.addItem({
                            type: 'submenu',
                            submenu: new DynamicMenuWidget(item, this.options)
                        });
                    }
                    else {
                        if (item.children.length > 0) {
                            if (parent.items.length > 0) {
                                parent.addItem({
                                    type: 'separator'
                                });
                            }
                            this.updateSubMenus(parent, item, commands);
                        }
                    }
                }
                else if (item instanceof common_1.ActionMenuNode) {
                    parent.addItem({
                        command: item.action.commandId,
                        type: 'command'
                    });
                }
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
    return DynamicMenuWidget;
}(widgets_1.Menu));
var BrowserMenuBarContribution = /** @class */ (function () {
    function BrowserMenuBarContribution(factory) {
        this.factory = factory;
    }
    BrowserMenuBarContribution.prototype.onStart = function (app) {
        var logo = this.createLogo();
        app.shell.addWidget(logo, { area: 'top' });
        var menu = this.factory.createMenuBar();
        app.shell.addWidget(menu, { area: 'top' });
    };
    BrowserMenuBarContribution.prototype.createLogo = function () {
        var logo = new widgets_1.Widget();
        logo.id = 'theia:icon';
        logo.addClass('theia-icon');
        return logo;
    };
    BrowserMenuBarContribution = __decorate([
        inversify_1.injectable(),
        __param(0, inversify_1.inject(BrowserMainMenuFactory)),
        __metadata("design:paramtypes", [BrowserMainMenuFactory])
    ], BrowserMenuBarContribution);
    return BrowserMenuBarContribution;
}());
exports.BrowserMenuBarContribution = BrowserMenuBarContribution;


/***/ })

}]);
//# sourceMappingURL=36.bundle.js.map