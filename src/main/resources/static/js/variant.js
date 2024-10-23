
function fetchProductFromCategory(categoryId = null) {
  const selectedCategoryId = categoryId;
  const productSelect = document.getElementById("productId");

  productSelect.innerHTML =
    '<option value="" selected disabled hidden>Choose product</option>';

  if (!selectedCategoryId) {
    const noneOption = document.createElement("option");
    noneOption.textContent = "None";
    noneOption.value = "";
    productSelect.appendChild(noneOption);
    return;
  }

  fetch(`/api/product/category/${selectedCategoryId}`)
    .then((response) => response.json())
    .then((products) => {
      products.forEach((product) => {
        const option = document.createElement("option");
        option.value = product.id;
        option.textContent = product.name;
        productSelect.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("Error fetching products:", error);
      const errorOption = document.createElement("option");
      errorOption.textContent = "Error loading products";
      errorOption.disabled = true;
      productSelect.appendChild(errorOption);
    });
}

document
  .getElementById("categoryId")
  .addEventListener("change", function (event) {
    fetchProductFromCategory(event.target.value);
  });

function openModal(action, variantId = null) {
  const modalTitle = document.getElementById("variantModalLabel");
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
        document.getElementById("categoryId").value =
          variant.product.categoryId;
        fetchProductFromCategory(variant.product.categoryId);
        document.getElementById("productId").value = variant.productId;
        document.getElementById("description").value = variant.description;
        document.getElementById("price").value = variant.price;
        document.getElementById("stock").value = variant.stock;
        document.getElementById("createdBy").value = variant.createdBy;
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
  new bootstrap.Modal(document.getElementById("variantModal")).show();
}

function submitVariantForm(method, url) {
  const formData = new FormData(document.getElementById("variantForm"));
  const data = Object.fromEntries(formData.entries()); 
  const jsonData = JSON.stringify(data);
  console.log(jsonData);
  fetch(url, {
    method: method,
    headers: {
      "Content-Type": "application/json", 
    },
    body: jsonData,
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
