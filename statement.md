# Project Statement: Image Filtering Engine

## Problem Statement
Graphic design software and image manipulation tools are often resource-heavy, requiring massive memory overhead and complex graphical user interfaces. For users who simply need to apply standard mathematical visual filters to images (especially in bulk), there is a need for a lightweight, high-performance, command-line tool that performs these operations natively without external graphical dependencies.

## Scope of the Project
The Image Filtering Engine is a Java-based Object-Oriented application designed to process uncompressed image data. The system reads standard image files, translates the pixel data into a custom 2D matrix in memory, and applies algorithmic matrix convolutions (such as box blurring or sepia tone color mapping). The modified matrix is then rendered back into a physical image file. The project focuses heavily on modularity, utilizing interface-driven design to allow new filters to be added without modifying the core I/O engine.

## Target Users
*   **Computer Science Students:** Individuals studying 2D array manipulation, memory management, and graphic algorithm application.
*   **Developers & Data Scientists:** Users who need a lightweight, fast CLI script for automated or batch image processing.
*   **Digital Artists:** Users requiring quick, reproducible visual filters without launching heavy design suites.

## High-Level Features
*   **Custom Memory Mapping:** Translates standard image files into a proprietary `ImageMatrix` of `Pixel` objects for rapid algorithmic manipulation.
*   **Modular Architecture:** Implements the Strategy Design Pattern via the `ImageTransformer` interface, cleanly separating the core application logic from the individual filter algorithms.
*   **Mathematical Visual Filters:** Includes pre-built algorithms for Grayscale averaging, Sepia color-weighting, and 3x3 Box Blur convolutions.
*   **Robust File I/O:** Safely handles file reading and writing with graceful exception handling to prevent runtime crashes upon bad user inputs.
*   **Interactive CLI:** Provides a streamlined terminal interface for selecting files, picking filters, and assigning output destinations.