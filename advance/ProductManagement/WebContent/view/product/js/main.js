/**
 * 
 */
var getWidthAdd = document.getElementById("btn__add");
var getWidthEdit = document.getElementById("btn__edit");
var getWidthDelete = document.getElementById("btn__delete");

var widthTd = getWidthAdd.offsetWidth + getWidthDelete.offsetWidth + getWidthEdit.offsetWidth;

document.getElementById("btn__action").style.width=widthTd+'px';