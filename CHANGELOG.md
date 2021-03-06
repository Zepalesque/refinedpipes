# Refined Pipes Changelog

## 0.5.1

- Fixed crash when breaking fluid pipe (raoulvdberge)

## 0.5

- Port to Minecraft 1.16 (raoulvdberge)
- Added Russian translation (KhottyManatee55)
- Added Chinese translation (liuseniubi)

## 0.4.2

- Fixed extremely high memory usage (Chocohead)

## 0.4.1
- Added formatting to quantities in the tooltips (raoulvdberge)
- Fixed invalid cast server crash (raoulvdberge)
- Fixed log spamming when destination for items are not found (raoulvdberge)
- Fixed crash when item pipe in round robin mode no longer has any destination (raoulvdberge)

## 0.4
- Added filtering options for the Extractor Attachment (raoulvdberge)
- Added redstone mode options for the Extractor Attachment (raoulvdberge)
- Added whitelist / blacklist options for the Extractor Attachment (raoulvdberge)
- Added routing mode (nearest first, furthest first, random and round robin) options for the Extractor Attachment (raoulvdberge)
- Added exact mode (NBT sensitivity) options for the Extractor Attachment (raoulvdberge)
- Added stack size configurability to the Extractor Attachment (raoulvdberge)
- Improved performance of rendering pipes (raoulvdberge)
- Fixed rendering bug where fluid remained in pipes (raoulvdberge)

## 0.3
Note: Due to fluid networks now being split up by their tier, all fluid pipes from version 0.2.1 and earlier are incompatible and won't be functioning. This can be fixed by breaking and replacing all the fluid pipes in a network.

- Implemented pick block on attachments (raoulvdberge)
- Improved performance of calculating pipe shapes (raoulvdberge)
- Added energy pipes (raoulvdberge)
- Added new tiers for the Fluid Pipe: Elite and Ultimate (raoulvdberge)

## 0.2.1
Note: Due to refactoring of the network architecture, pipes from version 0.2 and earlier are incompatible and won't be functioning. This can be fixed by breaking and replacing all the pipes in a network.

- Added ghost hitboxes when holding an attachment in hand (raoulvdberge)
- Refactored network architecture (raoulvdberge)

## 0.2
- Added fluid pipes (raoulvdberge)
- Improved tooltips (raoulvdberge)

## 0.1.4
- Added hitboxes for the attachments on pipes (raoulvdberge)
- Added a config file (raoulvdberge)

## 0.1.3
- Fixed Item Pipes using the wrong side of an inventory (raoulvdberge)

## 0.1.2
- Updated the textures slightly (raoulvdberge)
- Updated the recipes slightly (raoulvdberge)
- Added inventory connector to make placing attachments easier (raoulvdberge)
- Inventories connected with a pipe and an attachment are no longer marked as a valid destination (raoulvdberge)
- Added new tiers for the Extractor Attachment: Elite and Ultimate (raoulvdberge)
- Removed simple tier for the Item Pipe (raoulvdberge)
- Fixed Extractor Attachments not extracting properly (raoulvdberge)

## 0.1.1
Note: Pipes that are placed in the world from version 0.1 will all be removed, since the IDs have changed.

- Renamed "Pipe" to "Item Pipe" (raoulvdberge)
- Added different tiers for the Extractor Attachment: Basic, Improved and Advanced (raoulvdberge)
- Fixed missing model variant errors (raoulvdberge)
- Fixed pipes having no drops (raoulvdberge)

## 0.1
- Initial release
