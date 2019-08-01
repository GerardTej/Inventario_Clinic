function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('form img').attr('src', e.target.result);
            $('form img').css('width', '450px');
            $('form img').css('height', '225px');
        };
        reader.readAsDataURL(input.files[0]);
    }
}

