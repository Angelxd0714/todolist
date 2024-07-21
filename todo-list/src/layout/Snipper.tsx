
"use client";

import { Button, Spinner } from "flowbite-react";

export function SnniperLoad() {
  return (
    <div className="flex flex-row gap-3">
      <Button color="gray">
        <Spinner aria-label="Alternate spinner button example" size="sm" />
        <span className="pl-3">Loading...</span>
      </Button>
    </div>
  );
}
