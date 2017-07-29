/**
 * Created by Yana on 28.07.2017.
 */
$(document).ready(function() {
    $("select").change(function(){
        if($(this).val() == 0){
            $(".fa-user-md").removeClass("fa-user-md");
            $(".change").addClass("fa-ambulance");

            console.log("You select 0");
            $("#autocomplete").autocomplete({
                serviceUrl: '/all/clinics',
                paramName: "name",
                delimiter: ",",
                transformResult: function (response) {
                    console.log("before" + response.toString());
                    return {

                        suggestions: $.map($.parseJSON(response), function (item) {

                            var i = item.clinic_name;
                            console.log(i);
                            var html="<a href='"+"/clinics/"+item.id+"'>"+i+"</a>";
                            return {value: i, data: item.id,url:'/clinics/'+item.id};

                        })


                    };


                },
                onSelect: function (suggestion) {
                    console.log('You selected: ' + suggestion.value + ', ' + suggestion.data );
                    var id = suggestion.data;
                    $.ajax({
                        url: '/search/clinics/'+id,
                        method: 'GET',
                        contentType: 'application/json',

                        success: function (result) {


                            console.log(result.clinic_name);
                            $(".content").empty();
                            $(".content").append("<a href='"+"/clinics/details/"+result.id+"'><div class='container'><div class='row row-content'><div class='container-fluid'>" + result.clinic_name + "" +
                                " " + result.description + "</div></div></div></a>")


                        }

                    })

                }


            });

        }else {
            $(".change ").removeClass("fa-ambulance");
            $(".change").addClass("fa-user-md");
            console.log("You select 1")
            console.log($("#selectDocOrClinic").val());
            allDocs();
        }
    });

   if($("#selectDocOrClinic").val()==0) {

       console.log($("#selectDocOrClinic").val());
       $("#autocomplete").autocomplete({
           serviceUrl: '/all/clinics',
           paramName: "name",
           delimiter: ",",
           transformResult: function (response) {
               console.log("before" + response.toString());
               return {

                   suggestions: $.map($.parseJSON(response), function (item) {

                       var i = item.clinic_name;
                       console.log(i);
                       var html="<a href='"+"/clinics/"+item.id+"'>"+i+"</a>";
                       return {value: i, data: item.id,url:'/clinics/'+item.id};

                   })


               };


           },
           onSelect: function (suggestion) {
               console.log('You selected: ' + suggestion.value + ', ' + suggestion.data );
               var id = suggestion.data;
               $.ajax({
                   url: '/search/clinics/'+id,
                   method: 'GET',
                   contentType: 'application/json',

                   success: function (result) {


                       console.log(result.clinic_name);
                       $(".content").empty();
                       $(".content").append("<a href='"+"/clinics/details/"+result.id+"'><div class='container'><div class='row row-content'><div class='container-fluid'>" + result.clinic_name + "" +
                           " " + result.description + "</div></div></div></a>")


                   }

               })

           }


       });

   }
});


