// TODO: FIX MODAL
function openVariantModal(action, variantId = null) {
    const modalTitle = document.getElementById("myModalLabel");
    const saveButton = document.getElementById("saveButton");
    const form = document.getElementById("variantForm");
    const modalParagraph = document.getElementById("modalParagraph");
    const variantIdInput = document.getElementById("variantId");
    const deleteButton = document.getElementById("deleteButton");
  
    form.classList.remove("d-none");
    form.reset();
    modalParagraph.textContent = "";
    deleteButton.classList.add("d-none");
    saveButton.classList.remove("d-none");
  
    if (action === "add") {
      modalTitle.textContent = "Add New Variant";
      saveButton.textContent = "Save Variant";
      saveButton.onclick = function () {
        submitVariantForm("POST", "/variant");
      };
    } else if (action === "edit") {
      modalTitle.textContent = "Edit Variant";
      saveButton.textContent = "Update Variant";
      fetch(`/api/variant/${variantId}`)
        .then((response) => response.json())
        .then((variant) => {
          document.getElementById("name").value = variant.name;
          document.getElementById("productId").value = variant.productId;
          document.getElementById("description").value = variant.description;
          document.getElementById("price").value = variant.price;
          document.getElementById("stock").value = variant.stock;
          variantIdInput.value = variant.id;
        });
      saveButton.onclick = function () {
        submitVariantForm("PUT", `/api/variant/${variantId}`);
      };
    } else if (action === "delete") {
      deleteButton.classList.remove("d-none");
      saveButton.classList.add("d-none");
      form.classList.add("d-none");
  
      let variantName = "name";
      fetch(`/api/variant/${variantId}`)
        .then((response) => response.json())
        .then((variant) => {
          variantName = variant.name;
          const modalContent = `
          Are you <strong><em>sure</em></strong> you want to delete <br><br>
          <strong>Name:</strong> ${variantName} <br>
        `;
          modalParagraph.innerHTML = modalContent;
        });
  
      modalTitle.textContent = "Delete Variant";
      saveButton.textContent = "Cancel";
  
      deleteButton.onclick = function () {
        deleteVariant(variantId);
      };
    }
    new bootstrap.Modal(document.getElementById("myModal")).show();
  }
  
  function submitVariantForm(method, url) {
    const formData = new FormData(document.getElementById("variantForm"));
    fetch(url, {
      method: method,
      body: formData,
    }).then((response) => {
      if (response.ok) {
        window.location.reload();
      } else {
        alert("Error saving variant.");
      }
    });
  }
  
  function deleteVariant(variantId) {
    fetch(`/api/variant/${variantId}`, {
      method: "DELETE",
    }).then((response) => {
      if (response.ok) {
        window.location.reload();
      } else {
        alert("Error deleting variant.");
      }
    });
  }
  