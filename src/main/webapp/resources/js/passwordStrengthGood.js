/**
 * Added by Pavlo Kuchereshko.
 */
$( document ).ready(function() {
    $('#passwordReg').on('propertychange change keyup paste input', function() {
        var password = $(this).val();
        var passwordScore = zxcvbn(password)['score'];

        var updateMeter = function(width, background, text) {
            $('.password-background').css({"width": width, "background-color": background});
            $('.strengthPsw').text('Strength: ' + text).css('color', background);
        };

        if (passwordScore === 0) {
            if (password.length === 0) {
                updateMeter("0%", "#ffa0a0", "none");
            } else {
                updateMeter("20%", "#ffa0a0", "very weak");
            }
        }
        if (passwordScore == 1) updateMeter("40%", "#ffb78c", "weak");
        if (passwordScore == 2) updateMeter("60%", "#ffec8b", "medium");
        if (passwordScore == 3) updateMeter("80%", "#c3ff88", "strong");
        if (passwordScore == 4) updateMeter("100%", "#ACE872", "very strong"); // Color needs changing

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
        if (pwShown == 0) {
            pwShown = 1;
            show();
        } else {
            pwShown = 0;
            hide();
        }
    }, false);

});