function memberCheck() {
    // 회원 선택 드롭다운 요소를 가져옵니다
    var selectBox = document.getElementById('memberSelect');
    // 선택된 회원의 memberId 값을 가져옵니다
    var selectBoxValue = selectBox.value;
    // 선택된 회원의 이름(텍스트)을 가져옵니다
    var selectedMemberName = selectBox.options[selectBox.selectedIndex].text;
    // 회원 번호를 표시하는 입력란 요소를 가져옵니다
    var memberIdDisplay = document.getElementById('memberIdDisplay');
    // 회원 번호 입력란의 값에 선택된 회원의 memberId 값을 설정합니다
    memberIdDisplay.value = selectBoxValue;
}
function test(){
    alert("처음부터 다시 입력합니다")
    document.getElementById("classSelect").reset()
}

function accurate() {
    var registMonthElement = document.getElementById("registMonth");
    var registMonthValue = registMonthElement.value;

    // 수강월 유효성 검사
    if (!(/^\d{6}$/.test(registMonthValue))) {
        alert("여섯자리 숫자로 입력해주세요 (예: 202201)");
        registMonthElement.focus();
        return false;
    }

    // 회원명 선택 유효성 검사
    var memberSelect = document.getElementById("memberSelect");
    if (memberSelect.selectedIndex === 0) {
        alert("회원명을 선택해주세요");
        memberSelect.focus();
        return false;
    }

    // 강의 장소 유효성 검사
    var classAreaElement = document.getElementById("classArea");
    var classAreaValue = classAreaElement.value.trim();
    if (classAreaValue === "") {
        alert("강의 장소를 입력해주세요");
        classAreaElement.focus();
        return false;
    }

    // 강의 선택 유효성 검사
    var classSelect = document.getElementById("classSelect");
    if (classSelect.selectedIndex === 0) {
        alert("강의를 선택해주세요");
        classSelect.focus();
        return false;
    }

    document.getElementById("aaa").submit()
    // 모든 조건을 만족하면 제출 가능
    return true;
}


function tuitionCheck(){
    //강의명 드롭다운 요소를 가져온다.
    var classSelectBox = document.getElementById('classSelect');
    //강의명 teacherDto 의 tuition 값을 가져온다.
    //var classSelectBoxValue = classSelectBox.getAttribute('data-tuition')
    // 선택된 강의의 수강료를 가져옵니다.
    var classSelectBoxValue = parseInt(classSelectBox.options[classSelectBox.selectedIndex].getAttribute('data-tuition')); // 1

    //선택된 강의명을 가져온다.
    var selectedClassTuition = classSelectBox.options[classSelectBox.selectedIndex].text;

    //회원 선택 드롭다운 요소를 가져온다.
    var memberSelectBox = document.getElementById('memberSelect');
    //회원 선택의 등급을 가져온다.
    //var memberGrade = memberSelectBox.getAttribute('data-grade');
    var memberGrade = memberSelectBox.options[memberSelectBox.selectedIndex].getAttribute('data-grade'); //2
    //회원 번호 입력란 요소를 가져온다.
    var memberIdDisplayValue = document.getElementById('memberIdDisplay').value;

    //수강료를 표시하는 입력란 요소를 가져온다.
    var tuitionDisplay = document.getElementById('tuitionDisplay');

    if(memberIdDisplayValue === "") {
     alert("회원을 먼저 선택해주세요.")
     document.getElementById("memberSelect").focus();
     return;
    }
    if(memberGrade === "VIP"){
        tuitionDisplay.value = classSelectBoxValue * 0.5;
    } else {
        tuitionDisplay.value = classSelectBoxValue;
    }
}



