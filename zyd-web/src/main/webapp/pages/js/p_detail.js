$(function() {
    initUInfo();
});

//初始化艺人详情页面
function initUInfo() {
    var userId = Fun.reqParams.u;
    if (userId == null || userId == "") {
        return;
    }
    $.ajax({
        url : Fun.myBaseUrl + 'user/getUserWithMR.do?uId='+userId,
        type : 'post',
        dataType : 'json',
        success : function(resp) {
            if (resp.data == null) {
                alert("获取艺人信息失败");
                return;
            }
            document.title = resp.data.userName;
            $('#uImg').html(resp.data.avatar);
            var getUserhtml;
            if (resp.data.isDead == 1) {
                getUserhtml = _.template($("#Card03").html(), {
                    u : resp.data
                });
            } else if (resp.data.isTitle == 1) {
                getUserhtml = _.template($("#Card").html(), {
                    u : resp.data
                });
            } else {
                getUserhtml = _.template($("#Card02").html(), {
                    u : resp.data
                });
            }
            $('.cardContent').append(getUserhtml);
            $('.cardContent').show();

            var getTabhtml;
            if (resp.data.mentoringRelationshipDtos != null) {
                var getM01html = _.template($("#M01").html(), {
                    list : resp.data.mentoringRelationshipDtos
                });
                var getM02html = _.template($("#M02").html(), {
                    list : resp.data.mentoringRelationshipDtos
                });
                if (getM01html != null && getM01html.trim() != '') {
                    $('#m01').append(getM01html);
                }
                if (getM02html != null && getM02html.trim() != '') {
                    $('#m02').append(getM02html);
                }
                getTabhtml = _.template($("#TabArea").html(), {
                    hasM : 1
                });
                var mrdata = buildMentoringData(resp.data);
                var mrlinks = buildMentoringLinks(resp.data);
                dom.setOption({
                    series: [{
                        data: mrdata,
                        links: mrlinks
                    }]
                });
            } else {
                getTabhtml = _.template($("#TabArea").html(), {
                    hasM : 0
                });
            }
            $('.tab_a').append(getTabhtml);
            $('.tab_a').show();

            var getPartLefthtml = _.template($("#Tab01").html(), {
                u : resp.data
            });

            $('#login_one_1').append(getPartLefthtml);
            $('#login_one_1').show();

            var currSelected = "one_1";
            $("#subnav li").on('click', function(){
                $('#subnav li').removeClass('current02');
                $(this).addClass('current02');
                $('#login_' + currSelected).hide();
                $('#login_'+ $(this).attr("id")).show();
                currSelected = $(this).attr("id");
            });
        },
    });
}

function showOrHideCover(userId){
    if($(".cover").css("display")=="none"){
        if (userId == null || userId == "") {
            alert("无效操作");
            return;
        }
        $.ajax({
            url : Fun.myBaseUrl + 'user/getUser.do?uId='+userId,
            type : 'post',
            dataType : 'json',
            success : function(resp) {
                if (resp.data == null) {
                    alert("获取艺人信息失败");
                    return;
                }
                var getCoverhtml = _.template($("#Cover").html(), {
                    u : resp.data
                });
                $('.cover').append(getCoverhtml);
                $('.cover').show();

                var phoneWidth = document.body.clientWidth;
                phoneWidth = phoneWidth - (phoneWidth*0.06);
                var pic04H = phoneWidth/2*0.98;

                if (resp.data.userImg == null || resp.data.userImg == "") {
                    pic04H = 2;
                }
                var nameTop = (pic04H+32)/16 + 2 - 0.1;
                var contentTop = nameTop + 1.4;
                // $(".pic_04").css("height", pic04H+"px");
                $(".name_cover").css("top", nameTop+"rem");
                $(".content").css("top", contentTop+"rem");

            },
        });
    }else{
        $(".cover").html("");
        $(".cover").hide();
    }
}

function buildMentoringData(user){
    var result = [];
    var temp = {};
    var mentoringRelationshipDtos = user.mentoringRelationshipDtos;
    temp = {
        name: user.userName,
        symbol: '',
        itemStyle: {
            normal: {
                color: '#36a8ff', //圆点的颜色
                label: {
                    position: 'right',
                    textStyle: {
                        color: '#36a8ff'
                    }
                }
            }
        },
    }
    result.push(temp);
    for (var i = 0; i < mentoringRelationshipDtos.length; i++) {
        var dto = mentoringRelationshipDtos[i];
        if (dto.relType == "徒弟") {
            temp = {
                name: dto.relUserName,
                category: 1,
                draggable: true,
                itemStyle: {
                    normal: {
                        color: '#60d587',//圆点的颜色
                        label: {
                            position: 'top',
                            textStyle: {
                                color: '#000'
                            }
                        }
                    },
                    emphasis: {
                        color: "#000"
                    }
                }
            }
        } else if (dto.relType == "师傅") {
            temp = {
                name: dto.relUserName,
                category: 0,
                draggable: true,
                itemStyle: {
                    normal: {
                        color: '#7985f1',
                        label: {
                            position: 'top',
                            textStyle: {
                                color: '#7985f1'
                            }
                        }
                    },
                    emphasis: {
                        color: "#000"
                    }
                }
            }
        }
        result.push(temp);
    }
    return result;
}

function buildMentoringLinks(user){
    var result = [];
    var temp = {};
    var mentoringRelationshipDtos = user.mentoringRelationshipDtos;
    var userName = user.userName;
    for (var i = 0;i<mentoringRelationshipDtos.length;i++) {
        var dto = mentoringRelationshipDtos[i];
        if (dto.relType == '徒弟') {
            temp = {
                source: userName,
                target: dto.relUserName,
                value: "",
                lineStyle: {
                    normal: {
                        color: '#60d587',
                        curveness: 0.1 // 线的弯曲度 0-1之间 越大则歪曲度更大
                    }
                },
                label: {
                    normal: {
                        textStyle: {
                            color: '#07ac72'
                        }
                    }
                }
            }
            result.push(temp);
        } else if (dto.relType == '师傅') {
            temp = {
                source: userName,
                target: dto.relUserName,
                value: "",
                lineStyle: {
                    normal: {
                        color: '#7985f1',
                        curveness: 0.1 // 线的弯曲度 0-1之间 越大则歪曲度更大
                    }
                },
                label: {
                    normal: {
                        textStyle: {
                            color: '#07ac72'
                        }
                    }
                }
            }
            result.push(temp);
        }
    }
    return result;
}

