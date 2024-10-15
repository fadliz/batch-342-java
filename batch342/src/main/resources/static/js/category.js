function openModal(action, categoryId = null) {
    const modalTitle = document.getElementById('myModalLabel');
    const saveButton = document.getElementById('saveButton');
    const deleteButton = document.getElementById('deleteButton');
    const form = document.getElementById('categoryForm');
    const categoryIdInput = document.getElementById('categoryId');

    

    form.reset();
    deleteButton.classList.add('d-none');
    saveButton.classList.remove('d-none');

    if (action === 'add') {
        modalTitle.textContent = 'Add New Category';
        saveButton.textContent = 'Save Changes';
        saveButton.onclick = function() {
            submitCategoryForm('POST', '/category');
        };
    } else if (action === 'edit') {
        modalTitle.textContent = 'Edit Category';
        saveButton.textContent = 'Update Category';
        fetch(`/api/category/${categoryId}`)
            .then(response => response.json())
            .then(category => {
                console.log(category);
                document.getElementById('name').value = category.name;
                document.getElementById('description').value = category.description;
                categoryIdInput.value = category.id;
            });
        saveButton.onclick = function() {
            submitCategoryForm('PUT', `/api/category/${categoryId}`);
        };
    } else if (action === 'delete') {
        modalTitle.textContent = 'Delete Category';
        saveButton.textContent = 'Cancel';
        deleteButton.classList.remove('d-none');
        saveButton.classList.add('d-none');
        // Show confirmation message instead of the form
        document.querySelector('.modal-body').textContent = 'Are you sure you want to delete this category?';

        deleteButton.onclick = function() {
            // Handle category deletion
            deleteCategory(categoryId);
        };
    }
    new bootstrap.Modal(document.getElementById('myModal')).show();
}

function submitCategoryForm(method, url) {
    const formData = new FormData(document.getElementById('categoryForm'));
    fetch(url, {
        method: method,
        body: formData
    }).then(response => {
        if (response.ok) {
            window.location.reload(); // Reload page after successful operation
        } else {
            alert('Error saving category.');
        }
    });
}

function deleteCategory(categoryId) {
    fetch(`/api/category/${categoryId}`, {
        method: 'DELETE'
    }).then(response => {
        if (response.ok) {
            window.location.reload(); // Reload page after deletion
        } else {
            alert('Error deleting category.');
        }
    });
}