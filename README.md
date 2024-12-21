# Streaming Service Project

This project simulates a streaming service platform where users can manage a library of media items (films and TV shows). It allows users to add, remove, and rate films and TV shows, as well as view detailed information about each.

## Main Features

- **Create Streaming Services**: Define a streaming service with a name and price.
- **Add/Remove Media**: Add or remove films and TV shows to/from the streaming service's library.
- **Rate Films/TV Shows**: Rate films and TV shows on a scale from 0 to 5.
- **View Media Information**: Retrieve detailed information about a film or TV show (e.g., name, year, genre, rating, etc.).
- **Manage TV Show Seasons**: For TV shows, add, remove, and retrieve seasons hosted by different streaming services.

## Classes Overview

- **StreamingService**: Represents a streaming service platform. It allows managing a media library, adding/removing films and TV shows, and rating the media.
- **MediaItem**: An abstract base class for all media items, such as films and TV shows, containing common properties like name, genre, and rating.
- **Film**: A class representing a film, inheriting from `MediaItem`. It includes attributes like year, runtime, and hosting status.
- **TVShow**: A class representing a TV show, inheriting from `MediaItem`. It manages seasons and tracks which seasons are hosted on which streaming service.
- **Season**: Represents a single season of a TV show, including attributes like season number, year, episode count, and hosting status.
- **Genre**: An enum representing the genre of a media item (e.g., Action, Comedy, Drama, etc.).
