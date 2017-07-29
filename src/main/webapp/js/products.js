/**
 * Created by icondor on 22/07/2017.
 */

/**
 * Created by condor on 04/02/17
 */

function listProductsUL(productsjson) {

    var list = document.getElementById('listOfProducts').getElementsByTagName('ul')[0];
    var listHtml = '';

    for (var i = 0; i < productsjson.length; i++) {
        var p = productsjson[i];

        var el= '<li>'+p.name+'&nbsp;'+p.price+'</li>';
        listHtml=listHtml+el;
    }
    list.innerHTML = listHtml;
}

// cazul cand nu folosim o lista html
function listProducts(productsjson) {
    var list = document.getElementById('listOfProducts');
    var listHtml = '';

    for (var i = 0; i < productsjson.length; i++) {
        var product = productsjson[i];
        listHtml=listHtml+product.name+'&nbsp;'+product.price+'</br>';
    }
    list.innerHTML = listHtml;
}


function listOfProducts() {
    $.ajax({
        url: 'productsurl?action=list'
    }).done(function (response) {
        listProductsUL(response.productsjson);
    });
}


// buggy one
// accepts empty strings
// accepts html code (script injections as well)
/// etc
function insertProduct() {
    var name = document.getElementById('name').value;
    var price = document.getElementById('price').value;
    $.ajax({
        url: 'productsurl?action=insert&nameOfProduct='+name+'&priceOfProduct='+price
    }).done(function (response) {
        location.href = "insertProduct.html";
    });
}

function login() {
    var u = document.getElementById('user').value;
    var p = document.getElementById('pwd').value;
    $.ajax({
        url: 'login?user='+u+'&pwd='+p
    }).done(function (response) {
        location.href = "loginForm.html";
    });
}

