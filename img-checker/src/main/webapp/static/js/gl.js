gl = {};

/** utils */
gl.utils = {};

gl.utils.formatDate = function(val){
    if (val != null) {
        var date = new Date(val);
        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
             + date.getDate() +" " + date.getHours() +":"+ date.getMinutes() +":" + date.getSeconds();
    }
}

//通用alertDialog
function glDialog(content) {
    var d = dialog({
        title: '提示',
        content: content,
        okValue: '确定',
        ok: function () {
            return true;
        }
    }).width(250).show();
    return d;
}