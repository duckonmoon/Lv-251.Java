/**
 * Created by Admin on 02.08.2017.
 */
$("#autocomplete-spec").autocomplete({
    serviceUrl: '/doc/by/spec',
    noSuggestionNotice:'No results',
    showNoSuggestionNotice:true,
    paramName: "name",
    delimiter: ",",
    transformResult: function (response) {
        console.log("before doc by spec" );
        return {

            suggestions: $.map($.parseJSON(response), function (item) {

                var i = item.name;
                console.log(i);
                return {value: i, data: item.name};
            })
        };
    } });
