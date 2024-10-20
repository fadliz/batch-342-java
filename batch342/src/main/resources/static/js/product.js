// TODO: FIX MODAL
function openModal(action, productId = null) {
    const modalTitle = document.getElementById("productModalLabel");
    const saveButton = document.getElementById("saveButton");
    const form = document.getElementById("productForm");
    const modalParagraph = document.getElementById("modalParagraph");
    const productIdInput = document.getElementById("productId");
    const deleteButton = document.getElementById("deleteButton");
  
    form.classList.remove("d-none");
    form.reset();
    modalParagraph.textContent = "";
    deleteButton.classList.add("d-none");
    saveButton.classList.remove("d-none");
  
    if (action === "add") {
      modalTitle.textContent = "Add New Product";
      saveButton.textContent = "Save Product";
      saveButton.onclick = function () {
        submitProductForm("POST", "/api/product");
      };
    } else if (action === "edit") {
      modalTitle.textContent = "Edit Product";
      saveButton.textContent = "Update Product";
      fetch(`/api/product/${productId}`)
        .then((response) => response.json())
        .then((product) => {
          document.getElementById("name").value = product.name;
          document.getElementById("description").value = product.description;
          document.getElementById("price").value = product.price;
          document.getElementById("category").value = product.categoryId;
          productIdInput.value = product.id;
        });
      saveButton.onclick = function () {
        submitProductForm("PUT", `/api/product/${productId}`);
      };
    } else if (action === "delete") {
      deleteButton.classList.remove("d-none");
      saveButton.classList.add("d-none");
      form.classList.add("d-none");
  
      fetch(`/api/product/${productId}`)
        .then((response) => response.json())
        .then((product) => {
          const modalContent = `
          Are you <strong><em>sure</em></strong> you want to delete <br><br>
          <strong>Name:</strong> ${product.name} <br>
          <strong>Description:</strong> ${product.description} <br>
          <strong>Price:</strong> $${product.price}
      `;
  
          modalParagraph.innerHTML = modalContent;
        });
  
      modalTitle.textContent = "Delete Product";
      saveButton.textContent = "Cancel";
  
      deleteButton.onclick = function () {
        deleteProduct(productId);
      };
    }
    new bootstrap.Modal(document.getElementById("productModal")).show();
  }
  
  function submitProductForm(method, url) {
    const formData = new FormData(document.getElementById("productForm"));
    fetch(url, {
      method: method,
      body: formData,
    }).then((response) => {
      if (response.ok) {
        window.location.reload(); // Reload page after successful operation
      } else {
        alert("Error saving product.");
      }
    });
  }
  
  function deleteProduct(productId) {
    fetch(`/api/product/${productId}`, {
      method: "DELETE",
    }).then((response) => {
      if (response.ok) {
        window.location.reload(); // Reload page after deletion
      } else {
        alert("Error deleting product.");
      }
    });
  }