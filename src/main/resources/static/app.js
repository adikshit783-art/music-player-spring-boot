let songs = [];
let currentSongIndex = 0;

const audioPlayer =
    document.getElementById("audioPlayer");

const songTitle =
    document.getElementById("songTitle");

const songArtist =
    document.getElementById("songArtist");

const coverImage =
    document.getElementById("coverImage");

const playButton =
    document.getElementById("playButton");

const songsContainer =
    document.getElementById("songsContainer");


// Get songs from Spring Boot
async function loadSongs() {

    try {

        const response =
            await fetch("/api/songs");

        songs = await response.json();

        displaySongs(songs);

    } catch (error) {

        console.error("Error loading songs:", error);

        songsContainer.innerHTML =
            "Unable to load songs.";

    }
}


// Display songs
function displaySongs(songList) {

    songsContainer.innerHTML = "";

    songList.forEach((song, index) => {

        const songElement =
            document.createElement("div");

        songElement.classList.add("song-item");

        songElement.innerHTML = `
            <strong>${song.title}</strong>
            <p>${song.artist}</p>
        `;

        songElement.addEventListener(
            "click",
            () => playSong(index)
        );

        songsContainer.appendChild(songElement);
    });
}


// Play selected song
function playSong(index) {

    currentSongIndex = index;

    const song = songs[index];

    songTitle.textContent = song.title;

    songArtist.textContent = song.artist;

    if (song.coverImageUrl && song.coverImageUrl.trim() !== "") {
        coverImage.src = "/" + song.coverImageUrl;
    } else {
        coverImage.src = "/images/default.jpg";
    }

    audioPlayer.src = song.audioUrl;

    audioPlayer.play();

    playButton.textContent = "⏸";
}


// Play / Pause
function togglePlay() {

    // If no song is selected, play the first song
    if (!audioPlayer.src) {

        if (songs.length === 0) {
            alert("No songs available");
            return;
        }

        playSong(0);
        return;
    }

    // If song is paused, play it
    if (audioPlayer.paused) {

        audioPlayer.play();

        playButton.textContent = "⏸";

    } else {

        // If song is playing, pause it
        audioPlayer.pause();

        playButton.textContent = "▶";
    }
}


// Next song
function nextSong() {

    if (songs.length === 0) {
        return;
    }

    currentSongIndex++;

    if (currentSongIndex >= songs.length) {
        currentSongIndex = 0;
    }

    playSong(currentSongIndex);
}


// Previous song
function previousSong() {

    if (songs.length === 0) {
        return;
    }

    currentSongIndex--;

    if (currentSongIndex < 0) {
        currentSongIndex = songs.length - 1;
    }

    playSong(currentSongIndex);
}


// Volume
document
    .getElementById("volume")
    .addEventListener("input", function () {

        audioPlayer.volume = this.value;

    });


// Search
async function searchSongs() {

    const keyword =
        document.getElementById("searchInput").value;

    if (!keyword.trim()) {

        loadSongs();

        return;
    }

    try {

        const response =
            await fetch(
                `/api/songs/search?keyword=${encodeURIComponent(keyword)}`
            );

        const result =
            await response.json();

        displaySongs(result);

    } catch (error) {

        console.error("Search error:", error);
    }
}


// Load songs when page opens
loadSongs();