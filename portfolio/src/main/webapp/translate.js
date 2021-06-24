// Event listener
document.getElementById("request-translation").addEventListener("click", requestTranslation);

function requestTranslation() {
        // Obtains content of text and language to translate
        const text = document.getElementById('messageToTranslate').textContent;
        const languageCode = document.getElementById('language').value;

        //  Stores "translated-result" id
        const resultContainer = document.getElementById('translated-result');
        resultContainer.innerText = 'Loading...';

        // Stores text and language code in variable "params"
        const params = new URLSearchParams();
        params.append('text', text);
        params.append('languageCode', languageCode);

        // Fetches request to /translate URL
        fetch('/translate', {
          method: 'POST',
          body: params
        }).then(response => response.text())
        .then((translatedMessage) => {
          resultContainer.innerText = translatedMessage;
        });
}