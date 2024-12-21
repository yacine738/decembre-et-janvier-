const minutesLabel = document.getElementById("minutes");
const secondsLabel = document.getElementById("seconds");
const millisecondsLabel = document.getElementById("milliseconds");

const startButton = document.getElementById("startBtn");
const pauseButton = document.getElementById("pauseBtn");
const stopButton = document.getElementById("stopBtn");
const resetButton = document.getElementById("resetBtn");

const laplist = document.getElementById("laplist");

let minutes = 0;
let seconds = 0;
let milliseconds = 0;
let interval;

startButton.addEventListener('click', startTimer);
pauseButton.addEventListener('click', pauseTimer);
stopButton.addEventListener('click', stopTimer);
resetButton.addEventListener('click', resetTimer);

function startTimer() {
    interval = setInterval(updateTimer, 10);
    startButton.disabled = true;
}

function pauseTimer() {
    clearInterval(interval);
    startButton.disabled = false;
}

function stopTimer() {
    clearInterval(interval);
    addToLapList();
    resetTimerData();
    startButton.disabled = false;
}

function resetTimer() {
    clearInterval(interval);
    resetTimerData();
    startButton.disabled = false;
}

function updateTimer() {
    milliseconds += 10;

    if (milliseconds >= 1000) {
        milliseconds = 0;
        seconds++;
    }
    if (seconds >= 60) {
        seconds = 0;
        minutes++;
    }
    
    displayTimer();
}

function displayTimer() {
    millisecondsLabel.textContent = padTime(milliseconds / 10);
    secondsLabel.textContent = padTime(seconds);
    minutesLabel.textContent = padTime(minutes);
}

function padTime(time) {
    return time.toString().padStart(2, '0');
}

function resetTimerData() {
    minutes = 0;
    seconds = 0;
    milliseconds = 0;
    displayTimer();
}

function addToLapList() {
    const lapTime = `${padTime(minutes)}:${padTime(seconds)}:${padTime(Math.floor(milliseconds / 10))}`;
    
    const listItem = document.createElement('li');
    listItem.innerHTML = `<span>Lap ${laplist.childElementCount + 1}:</span> ${lapTime}`;
    laplist.appendChild(listItem);
}
