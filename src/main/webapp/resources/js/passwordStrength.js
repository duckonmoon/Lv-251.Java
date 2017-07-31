/**
 * Added by Pavlo Kuchereshko.
 */
$( document ).ready(function() {
    $('#passwordReg').on('propertychange change keyup paste input', function() {
        var password = $(this).val();
        var passwordScore = zxcvbn(password)['score'];

        var updateMeter = function(width, background, text) {
            $('.password-background').css({"width": width, "background-color": background});
            $('#strengthPswId').text(text).css('color', background);
        };

        var updatePasswordLengthWarn = function(text) {
            $('#lengthWarn').text(text).css('color', "#ff5b5a");
        };

        if (passwordScore === 0) {
            if (password.length === 0) {
                updateMeter("0%", "#ff383f", "");
            } else {
                updateMeter("20%", "#ff383f", " Strength : Very weak");
            }
        }
        if (passwordScore === 1) updateMeter("40%", "#ff6d52", " Strength : Weak");
        if (passwordScore === 2) updateMeter("60%", "#d59832", " Strength : Medium");
        if (passwordScore === 3) updateMeter("80%", "#8dc64e", " Strength : Strong");
        if (passwordScore === 4) updateMeter("100%", "#3ec91f", " Strength : Very strong"); // Color needs changing
        if (document.getElementById("passwordReg").value.length < 8
            && document.getElementById("passwordReg").value.length > 0) {
            updatePasswordLengthWarn("Password must be at least 8 characters in length. ");
        } else updatePasswordLengthWarn("");
    });

    function show() {
        var p = document.getElementById('passwordReg');
        p.setAttribute('type', 'text');
    }

    function hide() {
        var p = document.getElementById('passwordReg');
        p.setAttribute('type', 'password');
    }
    var pwShown = 0;

    document.getElementById("eye").addEventListener("click", function () {
        if (pwShown === 0) {
            pwShown = 1;
            show();
        } else {
            pwShown = 0;
            hide();
        }
    }, false);

});

$( document ).ready(function() {
    $('#passwordConfirmReg').on('propertychange change keyup paste input', function() {


        var updateMatch = function(text) {
            $('#matchPsw').text(text).css('color', "#ff383f");
        };

        if (document.getElementById("passwordConfirmReg").value !== ""
            && document.getElementById("passwordReg").value !== document.getElementById("passwordConfirmReg").value) {
            updateMatch("Passwords doesn\'t match");
        }
        else updateMatch(" ");
    });
});

$('#registration').submit(function() {

    var mustReturn = false;

    var updateFirstNameWarn = function(text) {
        $('#firstNameWarn').text(text).css('color', "#ff383f");
    };

    var updateLastNameWarn = function(text) {
        $('#lastNameWarn').text(text).css('color', "#ff383f");
    };

    var updateEmailWarn = function(text) {
        $('#emailWarn').text(text).css('color', "#ff383f");
    };

    /*var updatePasswordLengthWarn = function(text) {
        $('.lengthWarn').text(text).css('color', "#ffa0a0");
    };*/

    var isReturn = function (goReturn) {
        if (goReturn) mustReturn = true;
        return mustReturn;
    };

    if (document.getElementById("firstName").value.trim().length === 0) {
        updateFirstNameWarn("May not be empty");
        isReturn(true);
    } else updateFirstNameWarn("");

    if (document.getElementById("lastName").value.trim().length === 0) {
        updateLastNameWarn("May not be empty");
        isReturn(true);
    } else updateLastNameWarn("");

    if (document.getElementById("emailReg").value.trim().length === 0) {
        updateEmailWarn("May not be empty");
        isReturn(true);
    } else updateEmailWarn("");

    /*if (document.getElementById("passwordReg").value.length < 8) {
        updatePasswordLengthWarn("Password must be at least 8 characters in length");
        isReturn(true);
    } else updatePasswordLengthWarn("");*/

    if (document.getElementById("passwordConfirmReg").value !== ""
        && document.getElementById("passwordReg").value !== document.getElementById("passwordConfirmReg").value) {
        isReturn(true);
    }

    if (mustReturn) return false;
});