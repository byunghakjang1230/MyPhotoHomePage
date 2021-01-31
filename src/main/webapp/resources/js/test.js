var result_tample = Handlebars.compile($('#result_tample').html());
var maincate_tample = Handlebars.compile($('#maincate_tample').html());
var subcate_tample = Handlebars.compile($('#subcate_tample').html());
var change_switch = false;
var before_num = 0;
var after_num = 0;

////////////////////////////////////////////////
////리스트에 번호 붙이기.(초기화)			////
var setLiClassNum = function () {
	$('#result_ > ul > li').removeClass();
	var count = $('#result_ > ul > li').length;
	for (var i = 0; i < count; i++) {
		$('#result_ > ul > li:nth-child(' + (i + 1) + ')').attr('class', i);
	}
}


////////////////////////////////////////////////
////카테고리 불러오기 및 변경시 액션			////
var cateRead = function(cate, resultFunction){
	$.ajax({
		url: '/ir/ct/' + cate,
		type: 'get',
		dataType: 'json',
		headers: {
			'Content-Type':'text/html; charset=utf-8'
		},
		success: function (data) {
			resultFunction(data);
		}
	});
};

var mainCateRead = function (data) {
	$('#maincate').empty().append(maincate_tample(data));
};
var subCateRead = function (data) {
	$('#subcate').empty().append(subcate_tample(data));
}

//////////////////////////////////////////////
//		파일 이벤트와 관련된 함수들.				//

var dragNdropInput = function(event){
	var files = event.originalEvent.dataTransfer.files;
	[].forEach.call(files, readfile);
}

var inputTagInput = function(event){
	var files = event.target.files;
	[].forEach.call(files, readfile);
}


var readfile = function (file) {
	var reader = new FileReader();
	reader.addEventListener('load', function () {
		imgUpload(file);
	}, false);
	reader.readAsDataURL(file);
}

//아래 매서드를 필요에 따라 새로 정의.
var imgUpload = function (file) {
	var formData = new FormData();
	formData.append('imgfile', file);
	$.ajax({
		url: '/ir/temp',
		type: 'post',
		dataType: 'json',
		data: formData,
		processData: false,
		contentType: false,
		success: function (data) {
			$('#result_ > ul').append(result_tample(data));
		}
	});
	setLiClassNum();
}

//////////////////////////////////////////////
//		파일 submit때 수행될 함수. 				//
var getFileValues = function (count) {
    var photo_info = [];
    var maincate = $('#maincate').val();
    var subcate = $('#subcate').val();
    for (var i = 0; i < count; i++) {
        var photo = {
            'maincate': maincate,
            'subcate': subcate,
            'title': $('#result_ > ul > li.' + i + ' #title').val(),
            'context': $('#result_ > ul > li.' + i + ' #context').val(),
            'filename': $('#result_ > ul > li.' + i + ' #filename').val(),
            'thumbname': $('#result_ > ul > li.' + i + ' #thumbname').val()
        }
        photo_info.push(photo);
    }
    return photo_info;
}

////////////////////////////////////////////////////////////


// 메일카테고리 불러오기.
cateRead('', mainCateRead);
// li에 번호붙이기
setLiClassNum();



$('#send_bt').on('click', function (event) {
    event.preventDefault();
    var count = $('#result_ > ul > li').length;
    if (count > 0) {                
        $.ajax({
            url: '/ir/reg',
            type: 'post',
            dataType: 'text',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(getFileValues(count)),
            success: function (result) {
                alert('등록되었습니다.')
                $('#result_ > ul').empty();
            },
            statusCode: {
                400: function () {
                    alert('등록에 실패했습니다.\n다시 시도해주세요.');
                }
            }
        });
    }
});

$('#result_ > ul').on('DOMNodeInserted', function () {
	setLiClassNum();
});

$('#result_').on('click', '#change', function () {
    var empty = $(this).parent().parent().parent().attr('class');
    if (change_switch == false) {
        before_num = empty;
        $(this).addClass('selected');
        change_switch = true;
    } else {
        after_num = empty;
        if (after_num < before_num) {
            $('#result_ li.' + after_num).before($('#result_ li.' + before_num));
        } else if (after_num > before_num) {
            $('#result_ li.' + after_num).after($('#result_ li.' + before_num));
        }
        $('#change.selected').removeClass('selected');
        setLiClassNum();
        change_switch = false;
    }
});

$('#maincate').on('change', function () {
    var maincate = $(this).val();
    cateRead(maincate, subCateRead);
});

$('*').on('dragenter dragover drop', function (event) {
	event.preventDefault();
});

$('#input_field_').on('drop', function (event) {
	event.preventDefault();
    dragNdropInput(event);
});

$('#img_in').on('click', function (event) {
	event.preventDefault();
    $('#file').trigger('click');
});

$('#file').on('change', function (event) {
	event.preventDefault();
    inputTagInput(event);
});
        
$('#result_').on('click', '#del', function (event) {
	event.preventDefault();
    var thumbname = $(this).parent().parent().find('#thumbname').val();
    var filename = $(this).parent().parent().find('#filename').val();
    var del_li = $(this).parent().parent().parent();
    if(thumbname != '' && filename != ''){
    	$.ajax({
    		url: '/ir/del',
            type: 'post',
            dataType: 'text',
            data: JSON.stringify({
            	'filename': filename,
                'thumbname': thumbname
            }),
            headers: {
            	'Content-Type': 'application/json'
            },
            success: function (result) {
            	del_li.remove();
            	setLiClassNum();
            },
            statusCode: {
            	400 : function(){
            		alert('데이터 처리중입니다.\n잠시뒤 시도해 주세요.');
            	}
            }                    
    	});
    }else{
    	alert('파일 이름이 없습니다.');
    }            
});

