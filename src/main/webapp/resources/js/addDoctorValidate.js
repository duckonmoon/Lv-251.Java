/**
 * Created by Admin on 18.08.2017.
 */

// function validPhoto() {
//     console.log("heeelllo")
//     maxSize=100000;
//     var sizeinbytes = document.getElementById('file').files[0].size;
//     console.log(sizeinbytes)
//     if(sizeinbytes>maxSize){
//         $("#errorFile").show();
//     }
// }


function Validate(oForm) {
 hideErrors();
    var sizeinbytes=0;
     var maxSize=100000;
    var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

if($("#file").val()!=''){
    sizeinbytes = document.getElementById('file').files[0].size;}
     console.log("after"+$("#file").val());

    if(sizeinbytes>maxSize){
        $("#errorFile").show();
        return false
    }
  if ($("#firstname").val()==''){
      $("#errorName").show();
        return false;
  }
  if($("#lastname").val()==''){
      console.log("Cant be empty");
      $("#errorLastName").show();
      return false;
  }
    if($("#docEmail").val()==''||!$("#docEmail").val().match(emailRegex)){
        $("#errorEmail").show();
        return false;
    }

    if($("#pass").val()=='' || $("#pass").val().length<8){
        $("#errorPassword").show();
        return false;
    }
    if($("#pass").val()!=$("#passMatch").val()){
        $("#errorMatching").show();
        return false;
    }
    if($("#autocomplete-spec").val()==''){
        $("#errorSpec").show();
        return false;
    }
    return true;
}
 function  hideErrors() {
     $("#errorFile").hide();
     $("#errorMatching").hide();
     $("#errorEmail").hide();
     $("#errorName").hide();
     $("#errorLastName").hide();
 }