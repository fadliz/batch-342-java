function openModal(action, categoryId = null) {
  const modalTitle = document.getElementById("myModalLabel");
  const saveButton = document.getElementById("saveButton");
  const form = document.getElementById("categoryForm");
  const modalParagraph = document.getElementById("modalParagraph");
  const categoryIdInput = document.getElementById("categoryId");
  const deleteButton = document.getElementById("deleteButton");

  form.classList.remove("d-none");
  form.reset();
  modalParagraph.textContent = "";
  deleteButton.classList.add("d-none");
  saveButton.classList.remove("d-none");

  if (action === "add") {
    modalTitle.textContent = "Add New Category";
    saveButton.textContent = "Save Changes";
    saveButton.onclick = function () {
      submitCategoryForm("POST", "/category");
    };
  } else if (action === "edit") {
    modalTitle.textContent = "Edit Category";
    saveButton.textContent = "Update Category";
    fetch(`/api/category/${categoryId}`)
      .then((response) => response.json())
      .then((category) => {
        document.getElementById("name").value = category.name;
        document.getElementById("description").value = category.description;
        categoryIdInput.value = category.id;
      });
    saveButton.onclick = function () {
      submitCategoryForm("PUT", `/api/category/${categoryId}`);
    };
  } else if (action === "delete") {
    deleteButton.classList.remove("d-none");
    saveButton.classList.add("d-none");
    form.classList.add("d-none");

    let productName = "name";
    let productDescription = "description";
    fetch(`/api/category/${categoryId}`)
      .then((response) => response.json())
      .then((category) => {
        productName = category.name;
        productDescription = category.description;
        const modalContent = `
        Are you <strong><em>sure</em></strong> you want to delete <br><br>
        <strong>Name:</strong> ${productName} <br>
        <strong>Description:</strong> ${productDescription}
    `;

        modalParagraph.innerHTML = modalContent;
      });

    modalTitle.textContent = "Delete Category";
    saveButton.textContent = "Cancel";

    deleteButton.onclick = function () {
      deleteCategory(categoryId);
    };
  }
  new bootstrap.Modal(document.getElementById("myModal")).show();
}

function submitCategoryForm(method, url) {
  const formData = new FormData(document.getElementById("categoryForm"));
  fetch(url, {
    method: method,
    body: formData,
  }).then((response) => {
    if (response.ok) {
      window.location.reload();  
    } else {
      alert("Error saving category.");
    }
  });
}

function deleteCategory(categoryId) {
  fetch(`/api/category/${categoryId}`, {
    method: "DELETE",
  }).then((response) => {
    if (response.ok) {
      window.location.reload(); 
    } else {
      alert("Error deleting category.");
    }
  });
}
