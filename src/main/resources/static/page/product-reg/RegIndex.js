import ProductRegUI from "./RegUI.js";
const regUI = new ProductRegUI();

export function initializeProductRegPage () {
    regUI.addProductRegButtonClickEvent(document.getElementById('productRegBtn'));
}