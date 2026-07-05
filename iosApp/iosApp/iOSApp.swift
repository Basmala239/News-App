import SwiftUI

@main
struct iOSApp: App {

    init(){
        AppModuleKt.doInitKoin { _ in }
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}