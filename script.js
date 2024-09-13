function detectIOSVersion() {
            const userAgent = navigator.userAgent;
            const iosMatch = userAgent.match(/OS (\d+_\d+(_\d+)?)/);
            
            if (iosMatch) {
                const version = iosMatch[1].replace(/_/g, '.');
                const versionNumber = parseFloat(version);
                
                if (versionNumber < 16.5) {
                    document.getElementById('message').innerHTML = '<img src="greeting.jpg" alt="Greeting Image">';
                } else {
                    document.getElementById('message').innerText = "no jelbrek for u :(";
                }
            } else {
                document.getElementById('message').innerText = "nice try ;)";
            }
        }

        detectIOSVersion();
