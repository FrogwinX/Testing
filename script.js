async function executeQuery() {
    const id = document.getElementById('idInput').value;

    try {
        const response = await fetch(`https://edwintest-backend.azurewebsites.net/query?id=${id}`);
        const data = await response.text();

        document.getElementById('displayName').innerText = `Name: ${data}`;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('displayName').innerText = 'Error occurred';
    }
}


