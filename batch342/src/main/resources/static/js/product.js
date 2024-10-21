document.getElementById("saveButton").addEventListener("click", function () {
  document.getElementById("productForm").submit();
});

document.getElementById("deleteButton").addEventListener("click", function () {
  const productId = document.getElementById("deleteProductId").value; // Get the product ID
  deleteProduct(productId);
});

const saveButton = document.getElementById("saveButton");
const deleteButton = document.getElementById("deleteButton");

function openForm() {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: "/product/form",
    contentType: "html",
    success: function (productForm) {
      $("#productModal").modal("show");
      $(".modal-title").html("Product Form");
      $(".modal-body").html(productForm);
    },
  });
}

function editForm(id) {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/product/edit/${id}`,
    contentType: `html`,
    success: function (productForm) {
      $("#productModal").modal("show");
      $(".modal-title").html("Product Form");
      $(".modal-body").html(productForm);
    },
  });
}

function deleteForm(id) {
  saveButton.classList.add("d-none");
  deleteButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/product/deleteForm/${id}`,
    contentType: `html`,
    success: function (productForm) {
      $("#productModal").modal("show");
      $(".modal-title").html("Product Form");
      $(".modal-body").html(productForm);
    },
  });
}

function deleteProduct(id) {
  $.ajax({
    type: "get",
    url: `/product/delete/${id}`,
    contentType: `html`,
    success: function (response) {
      location.reload();
    },
  });
}
