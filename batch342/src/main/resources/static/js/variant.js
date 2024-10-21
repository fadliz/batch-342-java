document.getElementById("saveButton").addEventListener("click", function () {
  document.getElementById("variantForm").submit();
});

document.getElementById("deleteButton").addEventListener("click", function () {
  const variantId = document.getElementById("deleteVariantId").value; // Get the variant ID
  deleteVariant(variantId);
});

const saveButton = document.getElementById("saveButton");
const deleteButton = document.getElementById("deleteButton");

function openForm() {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: "/variant/form",
    contentType: "html",
    success: function (variantForm) {
      $("#variantModal").modal("show");
      $(".modal-title").html("Variant Form");
      $(".modal-body").html(variantForm);
      const productSelect = document.getElementById("productId");
      productSelect.innerHTML =
        '<option value="" selected disabled hidden>Choose here</option>';
    },
  });
}

function editForm(id) {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/variant/edit/${id}`,
    contentType: `html`,
    success: function (variantForm) {
      $("#variantModal").modal("show");
      $(".modal-title").html("Variant Form");
      $(".modal-body").html(variantForm);
      // const categoryId = document.getElementById("categoryId").value;
      // if (categoryId) {
      //   loadProducts(categoryId); // Populate the products select box
      // }
    },
  });
}

function deleteForm(id) {
  saveButton.classList.add("d-none");
  deleteButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/variant/deleteForm/${id}`,
    contentType: `html`,
    success: function (variantForm) {
      $("#variantModal").modal("show");
      $(".modal-title").html("Variant Form");
      $(".modal-body").html(variantForm);
    },
  });
}

function deleteVariant(id) {
  $.ajax({
    type: "get",
    url: `/variant/delete/${id}`,
    contentType: `html`,
    success: function (response) {
      location.reload();
    },
  });
}
function loadProducts(categoryId) {
  // Clear existing product options
  
  const productSelect = document.getElementById("productId");
  productSelect.innerHTML =
    '<option value="" selected disabled hidden>Choose here</option>';

  if (categoryId) {
    $.ajax({
      url: `/variant/products/${categoryId}`,
      type: "GET",
      success: function (data) {
        data.forEach(function (product) {
          const option = document.createElement("option");
          option.value = product.id;
          option.text = product.name;
          productSelect.appendChild(option);
        });
      },
    });
  }
}
