async function executeQuery() {
    const id = document.getElementById('idInput').value;

    try {
        const response = await fetch(`http://localhost:8080/query?id=${id}`);
        const data = await response.text();

        document.getElementById('displayName').innerText = `Name: ${data}`;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('displayName').innerText = 'Error occurred';
    }
}


