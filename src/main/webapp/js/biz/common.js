/**
 * 功能：jQuery按钮radio组
 * 开发：在外层div加样式.radiobtn,以及默认选中radio的checked属性
 * 目前只支持在一个html钟有效，因为.radiobtn如果多个会搞乱
 */

$selectedRadioId = $(".radiobtn input[type='radio']:checked")[0].id;
var beforeLabel = $("label[for='"+$selectedRadioId+"']");
beforeLabel.addClass("btn-info");
$(".radiobtn input[type='radio']").each(function(e){
    $(this).addClass("hidden");
});

$(".radiobtn input[type='radio']").change(function(e){
    beforeLabel.removeClass("btn-info");
    var currentLabel = $("label[for='"+this.id+"']");
    currentLabel.addClass("btn-info");
    beforeLabel = currentLabel;
});
