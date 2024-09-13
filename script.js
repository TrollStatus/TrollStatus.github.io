function detectIOSVersion() {
    const userAgent = navigator.userAgent;
    const iosVersionMatch = userAgent.match(/OS (\d+_\d+(_\d+)?)/);
    
    if (iosVersionMatch) {
        const iosVersion = iosVersionMatch[1].replace(/_/g, '.');
        const versionNumber = parseFloat(iosVersion);
        
        if (versionNumber < 16.5) {
            // Display greeting image
            document.body.innerHTML = '<h1>No jelbrek for u :(</h1>';
        } else {
            // Display message for higher versions
            document.body.innerHTML = '<h1>No jelbrek for u :(</h1>';
        }
    } else {
        console.log("Not an iOS device.");
    }
}

// Call the function to execute
detectIOSVersion();
