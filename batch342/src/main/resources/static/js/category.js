document.getElementById("saveButton").addEventListener("click", function () {
  document.getElementById("categoryForm").submit();
});
document.getElementById("deleteButton").addEventListener("click", function () {
  const categoryId = document.getElementById("deleteCategoryId").value; // Get the category ID
  deleteCategory(categoryId);
});

const saveButton = document.getElementById("saveButton");
const deleteButton = document.getElementById("deleteButton");

function openForm() {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: "/category/form",
    contentType: "html",
    success: function (categoryForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Category Form");
      $(".modal-body").html(categoryForm);
    },
  });
}

function editForm(id) {
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/category/edit/${id}`,
    contentType: `html`,
    success: function (categoryForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Category Form");
      $(".modal-body").html(categoryForm);
    },
  });
}

function deleteForm(id) {
  saveButton.classList.add("d-none");
  deleteButton.classList.remove("d-none");
  $.ajax({
    type: "get",
    url: `/category/deleteForm/${id}`,
    contentType: `html`,
    success: function (categoryForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Category Form");
      $(".modal-body").html(categoryForm);
    },
  });
}

function deleteCategory(id) {
  $.ajax({
    type: "get",
    url: `/category/delete/${id}`,
    contentType: `html`,
    success: function (response) {
      location.reload();
    },
  });
}
