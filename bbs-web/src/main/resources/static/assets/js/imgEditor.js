//ID 를 바라본다 , 초기 컬러와 사이즈 설정
var canvas = new fabric.Canvas('c', {
    //backgroundColor : '#58ff03', //컬러지정
    width : 600, //너비
    height : 600, // 높이
    //selectionColor : 'blue', 
    //selectionLineWidth : 2

    });




function preventLeaving(e) {
    var activeObject = e.target;
    var currentWidth = activeObject.get('width') * activeObject.get('scaleX');
    var currentHeight = activeObject.get('height') * activeObject.get('scaleY');
    var currentScaleX = activeObject.get('scaleX');
    var currentScaleY = activeObject.get('scaleY');

    // console.log(activeObject.get('ownMatrixCache')['value'][0]);
    // console.log(activeObject.get('ownMatrixCache')['value'][3]);

    if ((activeObject.get('left') < 0)){
        var leftRate = (activeObject.get('width')*activeObject.get('ownMatrixCache')['value'][0])/activeObject.get('width');
    }else{
        var leftRate = (activeObject.get('left')+(activeObject.get('width')*activeObject.get('ownMatrixCache')['value'][0]))/activeObject.get('width');
    }
    if ((activeObject.get('top') < 0)){
        var topRate = (activeObject.get('height')*activeObject.get('ownMatrixCache')['value'][3])/activeObject.get('height');
    }else{
        var topRate = (activeObject.get('top')+(activeObject.get('height')*activeObject.get('ownMatrixCache')['value'][3]))/activeObject.get('height');
    }

    var rightRate = (canvas.getWidth()-activeObject.get('left'))/activeObject.get('width');
    var bottomRate = (canvas.getHeight()-activeObject.get('top'))/activeObject.get('height');

    /*console.log('left : '+activeObject.get('left'));
    console.log('top : '+activeObject.get('top'));
    console.log('currentWidth : '+currentWidth);
    console.log('currentHeight : '+currentHeight);
    console.log('currentScaleX : '+currentScaleX);
    console.log('currentScaleY : '+currentScaleY);
    console.log('canvas.getWidth() : '+canvas.getWidth());
    console.log('canvas.getHeight() : '+canvas.getHeight());
    console.log(activeObject);
    //left
    console.log('leftRate'+leftRate);
    //top
    console.log('topRate'+topRate);
    //right
    console.log('rightRate'+rightRate);
    //bottom
    console.log('bottomRate'+bottomRate);

    console.log(activeObject.get('isMoving'));*/



    if ((activeObject.get('left') < 0)){
        activeObject.set({'left': 0});
        // if(currentScaleX > leftRate){
        //     activeObject.set({'scaleX': leftRate});
        // }
    }

    if ((activeObject.get('top') < 0)){
        activeObject.set({'top': 0});
        // if(currentScaleY > topRate ){
        //     activeObject.set({'scaleY': topRate});
        // }
    }

    if (activeObject.get('left') + currentWidth > canvas.getWidth()){
        activeObject.set({'left': canvas.getWidth() - currentWidth});
        // if(currentScaleX > rightRate ){
        //     activeObject.set({'scaleX': rightRate});
        // }
    }
    if (activeObject.get('top') + currentHeight > canvas.getHeight()){
        activeObject.set({'top': canvas.getHeight() - currentHeight});
        // if(currentScaleY > bottomRate ){
        //     activeObject.set({'scaleY': bottomRate});
        // }
    }

    //below just prevention for object from getting width or height greater than canvas width and height
    if (currentWidth > canvas.getWidth()){
        activeObject.set('scaleX', canvas.getWidth() / activeObject.get('width'));
    }
    if (currentHeight > canvas.getHeight()){
        activeObject.set('scaleY', canvas.getHeight() / activeObject.get('height'));
    }



}
canvas.on( 'object:moving', preventLeaving);
canvas.on( 'object:scaling', preventLeaving);


//오브젝트 선택
var selectItem;
// Log Object Selections in order, ini
canvas.on('selection:created', function(options) {
    
    $('.ed_text input[type=text]').val('');
    $('.option_font select option').attr('selected',false);
    $('.option_font_btn button').removeClass('active');
    // $('.option_color_btn button').removeClass('active');


    eventSelect(options);
});
canvas.on('selection:updated', function(options) {
    
    $('.ed_text input[type=text]').val('');
    $('.option_font select option').attr('selected',false);
    $('.option_font_btn button').removeClass('active');
    // $('.option_color_btn button').removeClass('active');


    eventSelect(options);
});

//ini
var select_fill,
    select_fontFamily,
    select_fontWeight,
    select_fontStyle,
    select_underline,
    select_linethrough,
    select_textAlign,
    select_text;

function eventSelect(options){
    selectItem = '';
    //console.log(options.target._objects);

    selectItem = options.selected[0];//일단 하나만 선택
    console.log(selectItem);
    /* $.each(options.target._objects, function( index) {
            $("#info").append(index+": "+options.target._objects[index].fill+"<br>");
    }); */

    //패널에 텍스트 상태 반영
    select_fill = selectItem.fill;
    select_fontFamily = selectItem.fontFamily;
    select_fontWeight = selectItem.fontWeight;
    select_fontStyle = selectItem.fontStyle;
    select_underline = selectItem.underline;
    select_linethrough = selectItem.linethrough;
    select_textAlign = selectItem.textAlign;
    select_text = selectItem.text;

    if(selectItem.text){ //텍스트일때
        console.log('select text');
        $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
        $('.ed_menu_text').addClass('active');


        console.log(select_text);
        $('.ed_text input[type=text]').val(select_text).focus();
        $('.option_font select option').each(function(){
            if($(this).val() == select_fontFamily){
                $(this).attr('selected', true);
            }
        });
        if(select_fontWeight == 700){
            $('.option_font_btn .fontWeight_btn').addClass('active');
        }
        if(select_fontStyle == 'italic'){
            $('.option_font_btn .fontStyle_btn').addClass('active');
        }
        if(select_underline == 'underline'){
            $('.option_font_btn .underline_btn').addClass('active');
        }
        if(select_linethrough == 'line-through'){
            $('.option_font_btn .lineThrough_btn').addClass('active');
        }

        if(select_textAlign == 'left'){
            $('.option_font_btn .textAlignLeft_btn').addClass('active');
        }else if(select_textAlign == 'center'){
            $('.option_font_btn .textAlignCenter_btn').addClass('active');
        }else if(select_textAlign == 'right'){
            $('.option_font_btn .textAlignRight_btn').addClass('active');
        }
    }else if(selectItem.label == 'cropArea'){ //크롭일떄
        console.log('select cropArea');
        $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
        $('.ed_menu_crop').addClass('active');


    }else{ //그외 도형

        $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
        $('.ed_menu_rect').addClass('active');



    }
    
    //컬러는 공통
    $('.option_color_btn input[type=color]').val(select_fill);


}

// Clean the div when selection cleared
canvas.on('selection:cleared', function(options) {
    //$("#info").html("Results:<br>");
    console.log('selection:cleared');
    selectItem ='';


    for (i = 0; i < canvas._objects.length; i++) {
        if(canvas._objects[i].label == 'cropArea'){
            var cropArea = canvas._objects[i];
        }
    }
    if(!cropArea){
        $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
        $('.ed_menu_home').addClass('active');
    }




});




//함수정의
//대상 상단 정렬 
function alignTop(){
    selectItem.set({top:alignT - 0});
    canvas.renderAll();
};

//대상 가운데 정렬 수직
function alignMiddle(){
    selectItem.centerV();
};

//대상 하단 정렬
function alignBottom(){
    if(!alignB){
        selectItem.set({top:600 - (selectItem.height * selectItem.scaleY)});
    }else{
        selectItem.set({top:600 - alignB - (selectItem.height * selectItem.scaleY)});
    }
    
    canvas.renderAll();
};

//대상 왼쪽 정렬
function alignLeft(){
    selectItem.set({left:alignL - 0});
    canvas.renderAll();
    
};

//대상 가운데 정렬 수평
function alignCenter(){
    selectItem.centerH();
};

//대상 오른쪽 정렬
function alignRight(){
    if(!alignR){
        selectItem.set({left:600 - (selectItem.width * selectItem.scaleX)});
    }else{
        selectItem.set({left:600 - alignR - (selectItem.width * selectItem.scaleX)});
    }
    console.log(alignR);
    canvas.renderAll();
};

//앞으로보내기
function toFront(){
    canvas.bringForward(selectItem, true);
};

//뒤로보내기
function toBack(){
    canvas.sendBackwards(selectItem, true);
};

//삭제
function remove(){
    canvas.remove(selectItem);
};

//잠금
function lock(){
    console.log(selectItem.selectable);
    if(selectItem.selectable == true){
        selectItem.set({selectable:false});
    }else{
        selectItem.set({selectable:true});
    }
    canvas.renderAll();
};

var save; //(임시)저장변수
function saveCanvas(){
    //json저장방법
    //save = JSON.stringify(canvas.toJSON());
    //혹은 
    save = JSON.stringify (canvas);
    console.log(canvas);
    alert(save);
};

//로드
function loadCanvas(json){
//var json = {"version":"4.3.0","objects":[{"type":"rect","version":"4.3.0","originX":"left","originY":"top","left":200,"top":300,"width":20,"height":20,"fill":"red","stroke":"rgba(100,200,200,0.5)","strokeWidth":1,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":20,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0,"rx":0,"ry":0},{"type":"circle","version":"4.3.0","originX":"left","originY":"top","left":100,"top":100,"width":40,"height":40,"fill":"green","stroke":null,"strokeWidth":1,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":0,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0,"radius":20,"startAngle":0,"endAngle":6.283185307179586},{"type":"triangle","version":"4.3.0","originX":"left","originY":"top","left":400,"top":400,"width":20,"height":30,"fill":"blue","stroke":null,"strokeWidth":1,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":0,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0},{"type":"i-text","version":"4.3.0","originX":"left","originY":"top","left":283.57,"top":382.55,"width":231.87,"height":33.9,"fill":"rgb(0,0,0)","stroke":null,"strokeWidth":1,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":0,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0,"text":"I'm in Comic Sans","fontSize":30,"fontWeight":"700","fontFamily":"dotum","fontStyle":"normal","lineHeight":1.16,"underline":false,"overline":false,"linethrough":true,"textAlign":"center","textBackgroundColor":"","charSpacing":0,"styles":{}},{"type":"image","version":"4.3.0","originX":"left","originY":"top","left":280,"top":288,"width":240,"height":224,"fill":"rgb(0,0,0)","stroke":null,"strokeWidth":0,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":0,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0,"cropX":0,"cropY":0,"src":"http://localhost/fabric/images/user/img_sample.png","crossOrigin":null,"filters":[]}],"background":"#58ff03","backgroundImage":{"type":"image","version":"4.3.0","originX":"left","originY":"top","left":0,"top":0,"width":800,"height":800,"fill":"rgb(0,0,0)","stroke":null,"strokeWidth":0,"strokeDashArray":null,"strokeLineCap":"butt","strokeDashOffset":0,"strokeLineJoin":"miter","strokeMiterLimit":4,"scaleX":1,"scaleY":1,"angle":0,"flipX":false,"flipY":false,"opacity":1,"shadow":null,"visible":true,"backgroundColor":"","fillRule":"nonzero","paintFirst":"fill","globalCompositeOperation":"source-over","skewX":0,"skewY":0,"cropX":0,"cropY":0,"src":"http://localhost/fabric/images/user/bg/img_main_1.png","crossOrigin":null,"filters":[]}};
canvas.loadFromJSON(json, function(){
    canvas.renderAll();
    }); 
    
};

//캔버스 초기화
function clearCanvas(){
    canvas.clear();
};

//이미지 삽입 - url
function addImageURL(url){
    //이미지 삽입
    fabric.Image.fromURL ( url, function (oImg) { 
    canvas.add (oImg); //이미지 출력
    oImg.center();//가운데 정렬
    });
};

//이미지삽입 - img태그
function addImageIMG(img, label){
    var imgElement = img;
    //var imgElement = document.getElementById('img_sample');
    var imgInstance = new fabric.Image(imgElement, {
    left: 100,
    top: 100,
    label:label,
    });
    if(label == 'char'){
        imgInstance.set({scaleY:0.3,scaleX:0.3});
    }
    canvas.add(imgInstance);
    imgInstance.center();
    //console.log(imgInstance)
    //canvas.setActiveObject(imgInstance);
};

//정렬기준 변수
var alignT, alignB, alignL, alignR;
//상품이미지 삽입 
function setProduct(bgUrl, olUrl, color, T, B, L, R){
    //지우기
    if(canvas.backgroundImage){
        canvas.backgroundImage.dispose();
    }
    if(canvas.setBackgroundColor){
        canvas.setBackgroundColor();
    }
    
    //캔버스 만들고	생성
    //bg삽입 , 사이즈
    canvas.setBackgroundImage(bgUrl, canvas.renderAll.bind(canvas), {
    width: canvas.width,
    height: canvas.height,
    // Needed to position backgroundImage at 0/0
    originX: 'left',
    originY: 'top'
    });

    //canvas.setBackgroundColor(color, console.log('that'));
    canvas.setBackgroundColor(color);
    //canvas.setWidth(value, optionsopt)
    //canvas.renderAll();

    //오버레이 삽입-> 나중에 클립패스 만들것
    canvas.setOverlayImage(olUrl, canvas.renderAll.bind(canvas),{
    width: canvas.width,
    height: canvas.height,
    // Needed to position backgroundImage at 0/0
    originX: 'left',
    originY: 'top'
    });

    canvas.renderAll();

//제품불러올떄 정렬기준도 같이 정해야한다 상,하,좌,우
    alignT = T;
    alignB = B;
    alignL = L;
    alignR = R;
console.log(alignT+'/'+alignB+'/'+alignL+'/'+alignR);
};


function addText(){
    //텍스트 삽입
    var text = new fabric.IText("텍스트", {
    fontFamily: 'Noto Sans KR',
    fontSize: '30',
    fontWeight: '400',
    scaleX:'3',
    scaleY:'3',
    //linethrough: true,
    textAlign: 'center',
    fill: '#000000',
    radius: 100,
    borderColor:'#ffffff',
    cornerColor:'#007bff',
    transparentCorners: false,
    onKeyUp : function(){
        //텍스트 입력하면 반영
        //$('.ed_text input[type=text]').val(this.text);
    },
    onSelect : function(){
        //선택되면 
        //console.log('go');
    }
    });
    canvas.add(text);
    text.center();
    canvas.setActiveObject(text);

};



/*     $('.char_img img').click(function(){
    addImageIMG(this);
}); */




//이벤트



//폰트 미리 불러오기 -> 효과 체크 필요, 개선 필요
$(function(){
var arrFont = ['Cafe24 Cafe24 Dangdanghae','Cafe24 Cafe24 Ohsquare','Cafe24 Ssukssuk','Cafe24 Shiningstar','Gmarket Sans TTF','MARU Buri Beta','IBM Plex Sans KR','RIDIBatang'];
var i = 0;
setTimeout(function(){
    
    var timer1 = setInterval(function(){
            $('.ff').css('font-family',arrFont[i]);
            i++;

    }, 500);

    var timer2 = setTimeout(function(){
        clearInterval(timer1);
    }, 10000);
}, 500);
});
//bold
$('.fontWeight_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){
        $(this).removeClass('active');
        selectItem.set({'fontWeight':'400'});
    }else{
        $(this).addClass('active');
        selectItem.set({'fontWeight':'700'});
    }
    canvas.renderAll();
});
//italic
$('.fontStyle_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){
        $(this).removeClass('active');
        selectItem.set({'fontStyle':'normal'});
    }else{
        $(this).addClass('active');
        selectItem.set({'fontStyle':'italic'});
    }
    canvas.renderAll();
});
//underline
$('.underline_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){
        $(this).removeClass('active');
        selectItem.set({'underline':false});
    }else{
        
        $(this).addClass('active');
        selectItem.set({'underline':true});
    }
    canvas.renderAll();
});
//lineThrough_btn
$('.lineThrough_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){
        $(this).removeClass('active');
        selectItem.set({'linethrough':false});
    }else{
        
        $(this).addClass('active');
        selectItem.set({'linethrough':true});
    }
    canvas.renderAll();
});

//textAlignLeft_btn
$('.textAlignLeft_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){

    }else{
        $('.textAlignCenter_btn').removeClass('active');
        $('.textAlignRight_btn').removeClass('active');
        $(this).addClass('active');
        selectItem.set({'textAlign':'left'});
    }
    canvas.renderAll();
});
//textAlignLeft_btn
$('.textAlignCenter_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){

    }else{
        $('.textAlignLeft_btn').removeClass('active');
        $('.textAlignRight_btn').removeClass('active');
        $(this).addClass('active');
        selectItem.set({'textAlign':'center'});
    }
    canvas.renderAll();
});
//textAlignLeft_btn
$('.textAlignRight_btn').on('propertychange change keyup paste input blur',function(){
    if($(this).hasClass('active')){

    }else{
        $('.textAlignCenter_btn').removeClass('active');
        $('.textAlignLeft_btn').removeClass('active');
        $(this).addClass('active');
        selectItem.set({'textAlign':'right'});
    }
    canvas.renderAll();
});

//option_color_btn
$('.option_color_btn input[type=color]').on('propertychange change keyup paste input blur',function(){

    var dataColor = $(this).val();
    selectItem.set({'fill':dataColor});
    canvas.renderAll();

});




//circle
$('.shape_circle').click(function(){

    var circle = new fabric.Circle({
        radius: 34, fill: '#959595'
    });
    canvas.add(circle);
    circle.center();
    canvas.setActiveObject(circle);
});


//triangle
$('.shape_triangle').click(function(){

    var triangle = new fabric.Triangle({
        width: 72, height: 62, fill: '#959595'
        });
    
        canvas.add(triangle);
        triangle.center();
        canvas.setActiveObject(triangle);
});


//rect
$('.shape_rect').click(function(){

    var rect = new fabric.Rect({
        width: 62, height: 62, fill: '#959595'
        });
    
        canvas.add(rect);
        rect.center();
        canvas.setActiveObject(rect);
});


//rhombus
$('.shape_rhombus').click(function(){

    var path = new fabric.Path('M0,38.2L38.2,0l38.2,38.2L38.2,76.4L0,38.2z');
        path.set({ fill: '#959595'});
        canvas.add(path);
        path.center();
        canvas.setActiveObject(path);
});


//triR
$('.shape_triR').click(function(){

    var path = new fabric.Path('M31.676,7.447a5,5,0,0,1,8.648,0L67.639,54.489A5,5,0,0,1,63.315,62H8.685a5,5,0,0,1-4.324-7.511Z');
        path.set({ fill: '#959595'});
        canvas.add(path);
        path.center();
        canvas.setActiveObject(path);
});


//rectR
$('.shape_rectR').click(function(){

    var rect = new fabric.Rect({
        width: 62, height: 62, fill: '#959595', rx : 9,
        });
    
        canvas.add(rect);
        rect.center();
        canvas.setActiveObject(rect);
});


//rhomR
$('.shape_rhomR').click(function(){

    var path = new fabric.Path('M5.7,32.5L32.5,5.7c3.1-3.1,8.2-3.1,11.3,0l26.9,26.9c3.1,3.1,3.1,8.2,0,11.3L43.8,70.7c-3.1,3.1-8.2,3.1-11.3,0L5.7,43.8C2.5,40.7,2.5,35.7,5.7,32.5z');
        path.set({ fill: '#959595'});
        canvas.add(path);
        path.center();
        canvas.setActiveObject(path);
});


//heart
$('.shape_heart').click(function(){

    var path = new fabric.Path('M61.2,4.1C54-2.1,43.2-1,36.5,5.9l-2.6,2.7l-2.6-2.7C24.6-1,13.8-2.1,6.6,4.1c-7.9,6.9-8.8,18.9-2,26.8c0.2,0.2,0.4,0.5,0.7,0.7l25.6,26.5c1.6,1.7,4.2,1.7,5.9,0.1c0,0,0.1-0.1,0.1-0.1l25.6-26.5C69.8,24,69.5,12,62,4.7C61.7,4.5,61.5,4.3,61.2,4.1z');
        path.set({ fill: '#959595'});
        canvas.add(path);
        path.center();
        canvas.setActiveObject(path);
});




//////////////////////////////////////////////////////////////////////////////



function openThumbnailImgEditor(data){
    setThumbnailImgEditor(data.dataset.id);
    openImgEditor();
}

function openOptionImgEditor(data){
    setOptionImgEditor(data.dataset.id);
    openImgEditor();
}

function openImgEditor()
{
    $('.ed_wrap').show();
    $('html').css({overflow: 'hidden'});

    $('.ed_imglist>div>div:eq(0)>button>img').trigger('click');
}


function closeImgEditor(){
    $('.ed_wrap').hide();
    $('html').css({overflow: ''});
}


var isModified = false;

function canvasModifiedCallback() {
    console.log('canvas modified!');
    isModified = true;
};

canvas.on('object:added', canvasModifiedCallback);
canvas.on('object:removed', canvasModifiedCallback);
canvas.on('object:modified', canvasModifiedCallback);

var currentProductId;
var currentImageSrc;
var currentImageFileName;

$(document).on("click", '.ed_select_img img', function(){
    var imgW = this.naturalWidth;
    var imgH = this.naturalHeight;
    var src = $(this).attr("src");
    currentProductId = $(this).attr('data-id')
    currentImageSrc = src;

    if(isModified == true){
        if (!confirm("변경된 부분이 있습니다. 초기화하시겠습니까?")) {
            // 취소(아니오) 버튼 클릭 시 이벤트
        } else {
            // 확인(예) 버튼 클릭 시 이벤트
            canvas.clear();
            canvas
                .setBackgroundImage(src, canvas.renderAll.bind(canvas), {
                    // Needed to position backgroundImage at 0/0
                    originX: 'left',
                    originY: 'top',
                    crossOrigin: 'anonymous'
                })
                .setWidth(imgW)
                .setHeight(imgH);
            isModified = false;
        }
    }else{
        canvas.clear();
        canvas
            .setBackgroundImage(src, canvas.renderAll.bind(canvas), {
                // Needed to position backgroundImage at 0/0
                originX: 'left',
                originY: 'top',
                crossOrigin: 'anonymous'
            })
            .setWidth(imgW)
            .setHeight(imgH);
        isModified = false;
    }



});


//overlay 입력
$('.crop_btn').click(function(){
    // var path = new fabric.Path('M190.5,295H-10V-5H290V295Zm98.5-1V195.5H190.5V294Zm-99.5,0V195.5h-99V294ZM-9,294H89.5V195.5H-9Zm298-99.5v-99H190.5v99Zm-99.5,0v-99h-99v99Zm-100,0v-99H-9v99ZM289,94.5V-4H190.5V94.5Zm-99.5,0V-4h-99V94.5Zm-100,0V-4H-9V94.5Z');
    // path.set({ fill: '#ffffff',maxWidth:300, maxHeight:300});
    // canvas.add(path);
    // path.center();
    // canvas.setActiveObject(path);

    //rect
    var rect = new fabric.Rect({
        width: 300,
        height: 300,
        // maxwidth: canvas.width,
        // maxheight: canvas.height,
        fill: 'transparent',
        borderColor:'#ffffff',
        cornerColor:'#007bff',
        transparentCorners: false,
        //stroke:'#ffffff',
        hasRotatingPoint: false,
        lockRotation: true,
        label:'cropArea'
    });
    rect.setControlVisible('mtr', false);
    canvas.add(rect);
    rect.center();
    canvas.setActiveObject(rect);


    /*canvas.clipTo = function(ctx) {
        ctx.beginPath();
        var rect = new fabric.Rect({
            fill: 'red',
            opacity: 0,
            left: 0,
            top: 0,
            width: canvas.width,
            height: canvas.height
        });
        ctx.strokeStyle = 'black';
        rect.render(ctx);
        ctx.stroke();
    }*/
});




//crop aply
$('.crop_aply_btn').click(function(){
    for (i = 0; i < canvas._objects.length; i++) {
        if(canvas._objects[i].label == 'cropArea'){
            var cropArea = canvas._objects[i];
            // console.log(cropArea);
        }
    }
    var cropWidth = cropArea.width * cropArea.scaleX;
    var cropHeight = cropArea.height * cropArea.scaleY;

    var dataURL = canvas.toDataURL({
        format: 'png',
        left: cropArea.left,
        top: cropArea.top,
        width: cropWidth,
        height: cropHeight
    });
    // console.log(dataURL);
    canvas.clear();
    canvas
        .setBackgroundImage(dataURL, canvas.renderAll.bind(canvas), {
            // Needed to position backgroundImage at 0/0
            originX: 'left',
            originY: 'top',
            crossOrigin: 'anonymous'
        })
        .setWidth(cropWidth)
        .setHeight(cropHeight);

    $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
    $('.ed_menu_home').addClass('active');

});



//crop cancel
$('.crop_cancel_btn').click(function(){
    for (i = 0; i < canvas._objects.length; i++) {
        if(canvas._objects[i].label == 'cropArea'){
            var cropArea = canvas._objects[i];
        }
    }
    canvas.remove(cropArea);
    $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
    $('.ed_menu_home').addClass('active');

});

//텍스트 입력
$('.add_text_btn').click(function(){
    addText();
});

//font-family 변경
$('.option_font select').on('propertychange change keyup paste input blur',function(){
    var changeFont = $(this).val();
    selectItem.set({'fontFamily':changeFont});

    canvas.renderAll();

});

//rect
$('.add_rect_btn').click(function(){

    var rect = new fabric.Rect({
        width: 100,
        height: 40,
        fill: '#ffffff',
        borderColor:'#ffffff',
        cornerColor:'#007bff',
        transparentCorners: false
    });

    canvas.add(rect);
    rect.center();
    canvas.setActiveObject(rect);
    canvas.sendToBack(selectItem);
});

//rect cancel
$('.rect_cancel_btn').click(function(){
    $('.ed_controller_panel>ul>li[class^=ed_menu]').removeClass('active');
    $('.ed_menu_home').addClass('active');
});


// DEL key
/*$(document).keydown(function(event) {
    if ( event.keyCode == 8 || event.which == 46 ) {
        for (i = 0; i < canvas._objects.length; i++) {
            if(canvas._objects[i].label == 'cropArea'){
                var cropArea = canvas._objects[i];
            }
        }
        if(!cropArea){
            canvas.remove(selectItem);
        }

    }
});*/



//편집결과 저장 ajax
async function fnSave() {
    isModified = false;

    // 현재 선택된객체 취소
    canvas.discardActiveObject();
    canvas.renderAll();

    var resultAjax = JSON.stringify (canvas);

    var $canvas = document.getElementById("c");
    var imgDataUrl = $canvas.toDataURL("image/png");

    console.log(resultAjax)
    console.log($canvas)
    console.log(imgDataUrl)

    var blobBin = atob(imgDataUrl.split(',')[1]);	// base64 데이터 디코딩
    var array = [];
    for (var i = 0; i < blobBin.length; i++) {
        array.push(blobBin.charCodeAt(i));
    }
    var file = new Blob([new Uint8Array(array)], {type: 'image/png'});	// Blob 생성
    currentProductId = $(this).attr('data-id');
    currentImageFileName = currentImageSrc.split('/').pop();

    var formdata = new FormData();	// formData 생성
    formdata.append("file", file, currentImageFileName);	// file data 추가
    formdata.append("canvasStr", resultAjax);

    var imageUrl;
    await fileUpload('/api/image/update', formdata)
        .done(res => {
            imageUrl = getRes(res)
            alert("저장되었습니다.");
            $(`img[src='${currentImageSrc}']`).attr("src", currentImageSrc + `?v=${new Date().getTime()}`);
        })
        .fail((res) => {
            alertResMsg(res);
        });
    console.log(imageUrl)
}

















