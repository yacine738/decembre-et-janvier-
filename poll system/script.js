const options = [
    {id:"option1", Text:"Javascript", votes:0},
    {id:"option2", Text:"Python", votes:0},
    {id:"option3", Text:"Java", votes:0},
    {id:"option4", Text:"C++", votes:0},
 ];
 
 function submitVotes() {
    const selectedOption = document.querySelector('input[name="poll"]:checked');
    if (!selectedOption) {
        alert("Please select an option");
        return; 
    }
    const optionId = selectedOption.value; 
    const selectedOptionObj = options.find(option => option.id === optionId);
    if (selectedOptionObj) {
        selectedOptionObj.votes++;
        displayResult();
    }
 }
 
 function displayResult() {
    const result = document.getElementById("result");
    result.innerHTML = ""; 
 
    options.forEach(option => {
        const percentage = ((option.votes / getTotalVotes()) * 100).toFixed(2) || 0; 
        const barWidth = percentage > 0 ? percentage + "%" : "0%"; 
 
        const optionResult = document.createElement("div"); 
        optionResult.className = "option-result"; 
        optionResult.innerHTML = `
            <span class="option-text">${option.Text}</span>
            <div class="bar-container">
                <div class="bar" style="width:${barWidth}"></div>
            </div>
            <span class="percentage">${percentage}%</span>`; 
 
        result.appendChild(optionResult); 
    });
 }
 
 function getTotalVotes() { 
    return options.reduce((total, option) => total + option.votes, 0); 
 }
 