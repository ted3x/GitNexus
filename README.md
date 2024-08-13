# GitNexus

GitNexus is a cross-platform desktop application built using Kotlin Multiplatform (KMP) that
provides a unified interface for managing Git repositories. With GitNexus, you can easily view and
manage pull requests across multiple repositories, making your version control workflow more
efficient and streamlined.

## Features

- **Multi-Repository Support**: View and manage pull requests from multiple repositories in a single
  interface.
- **Branch Management**: Seamlessly create, delete, and switch between branches.
- **Commit History Visualization**: Visualize commit history with an intuitive, graphical
  representation.
- **Merge Conflict Resolution**: Tools to help you resolve merge conflicts directly within the app.
- **Customizable Interface**: Tailor the appearance and functionality of GitNexus to suit your
  workflow.
- **Cross-Platform**: Available for macOS, Windows, and Linux, leveraging Kotlin Multiplatform
  technology.

## Installation

### Requirements

- **JDK 11+**: Ensure you have Java Development Kit version 11 or higher.
- **Kotlin 1.6+**: GitNexus is built with Kotlin, so you'll need the Kotlin compiler.
- **Git 2.25+**: GitNexus requires Git to be installed on your system.

### Building from Source

To build GitNexus from source, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/ted3x/gitnexus.git
   ```

2. Navigate to the project directory:
   ```bash
   cd gitnexus
   ```
3. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

### Running the Application

After building, you can run GitNexus using the following command:

```bash
./gradlew run
```

## Usage

Once the application is running, you can:

1. **Add Repositories**: Connect to your GitHub, GitLab, or Bitbucket accounts to add repositories.
2. **View Pull Requests**: Access pull requests from all connected repositories in a unified
   interface.
3. **Manage Branches**: Easily switch between branches or create new ones.
4. **Resolve Conflicts**: Use built-in tools to resolve merge conflicts directly within the app.

## Contributing

We welcome contributions from the community! To contribute to GitNexus, please follow these steps:

1. Fork the repository on GitHub.
2. Create a new branch for your feature or bugfix.
3. Commit your changes with descriptive commit messages.
4. Push your branch to your forked repository.
5. Create a pull request, explaining your changes in detail.

For more information, please read our [Contributing Guide](CONTRIBUTING.md).

## License

GitNexus is licensed under the MIT License. You are free to use, modify, and distribute this
software under the terms of the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For questions, suggestions, or feedback, please open an issue on the GitHub repository or contact
the project maintainers at [tedex@manvelidze.me].

## Acknowledgments

- **Kotlin Multiplatform**: For providing the tools to build cross-platform applications.
- **JetBrains**: For their continued support of open-source projects and the Kotlin programming
  language.
- **GitKraken**: For inspiring the creation of GitNexus.
